package com.jpm.message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Runnable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MessageHandler implements Runnable
{
  List<BasicMessage> basicMessages=new ArrayList<BasicMessage>(5);
  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  Scanner scanner;

  public MessageHandler(Scanner scanner) {
    this.scanner=scanner;
  }

  private BasicMessage readTypeOneSaleMessage(int numberOfOccurrences){
    System.out.print("Enter product type: ");
    String productType = scanner.next();
    BasicMessage basicMessage1=new BasicMessage(productType,0,0);
    if(basicMessages.contains(basicMessage1)){
      BasicMessage basicMessage=basicMessages.get(basicMessages.indexOf(basicMessage1));
      basicMessage.increaseCount(numberOfOccurrences);
    }else {
      BasicMessage basicMessage=new BasicMessage(productType,10,numberOfOccurrences);
      basicMessages.add(basicMessage);
    }
    return basicMessage1;
  }
  private BasicMessage readTypeTwoSaleMessage(){
    System.out.print("Enter number of occurrences of sale: ");
    int numberOfOccurrences = scanner.nextInt();
    return readTypeOneSaleMessage(numberOfOccurrences);
  }
  private void readTypeThreeSaleMessage(){
    BasicMessage productType=readTypeTwoSaleMessage();
    System.out.println("Enter your choice of adjustment:\n1.Add\n2.Subtract\n3.Multiply ");

    String adjustmentChoice= null;
    try {
      adjustmentChoice = reader.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
    String[] adjustments=adjustmentChoice.split("\\s+");

    BasicMessage basicMessage=basicMessages.get(basicMessages.indexOf(productType));
    if ("Add".equalsIgnoreCase(adjustments[0])) {
      Adjustment adjustment = new Adjustment("ADD", Integer.parseInt(adjustments[1].replace("p", "")));
      basicMessage.getAdjustments().add(adjustment);
      basicMessage.addSaleValue(adjustment.getValue());

    } else if ("Subtract".equalsIgnoreCase(adjustments[0])) {
      Adjustment adjustment = new Adjustment("SUBTRACT", Integer.parseInt(adjustments[1].replace("p", "")));
      basicMessage.getAdjustments().add(adjustment);
      basicMessage.subtractSaleValue(adjustment.getValue());
    } else if("Multiply".equalsIgnoreCase(adjustments[0])){
      Adjustment adjustment = new Adjustment("MULTIPLY", Integer.parseInt(adjustments[1].replace("p", "")));
      basicMessage.getAdjustments().add(adjustment);
      basicMessage.multiplySaleValue(adjustment.getValue());
    }
  }
  private void displaySaleReport(){
    System.out.println("\n-------------------------------");
    System.out.println("Sales report");
    System.out.println("-------------------------------");
    for(BasicMessage basicMessage:basicMessages){
      System.out.println(basicMessage.getCount()+" "+basicMessage.getProductType()+" at "+basicMessage.getValue() +"p with a total sale of "+(basicMessage.getCount()*basicMessage.getValue()));
    }
    System.out.println("-------------------------------\n");
  }
  public void displayAdjustments(){
    System.out.println("-------------------------------");
    System.out.println("Adjustments report");
    System.out.println("-------------------------------");
    for(BasicMessage basicMessage:basicMessages) {
      System.out.println("Adjustments on product type :"+basicMessage.getProductType());
      for(Adjustment adjustment:basicMessage.getAdjustments()){
        System.out.println("   Performed "+adjustment.getAdjustmentType()+" with value "+adjustment.getValue()+"p");
      }
    }
    System.out.println("-------------------------------\n");
  }
  public void run() {
      int numberOfMessages=0;
      while (true) {
        System.out.println("1. Message Type-1 \n2. Message Type-2 \n3. Message Type-3");
        System.out.print("Select your choice of sale:");
        int choice=scanner.nextInt();
        switch (choice){
          case 1 : readTypeOneSaleMessage(1);
                    break;
          case 2 : readTypeTwoSaleMessage();
                  break;
          case 3 : readTypeThreeSaleMessage();
                  break;
        }
        numberOfMessages++;
        if(numberOfMessages%10==0){
          displaySaleReport();
          System.out.println();
        }
        if(numberOfMessages%50==0){
          System.out.println("\npausing the messages...");
          displayAdjustments();
          break;
        }
      }
  }
}