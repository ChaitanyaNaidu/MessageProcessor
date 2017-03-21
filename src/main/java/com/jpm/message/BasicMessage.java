package com.jpm.message;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BasicMessage
{
  private final String productType;
  private int count;
  private int value;

  public int getCount() {
    return count;
  }

  public int getValue() {
    return value;
  }

  private List<Adjustment> adjustments;

  public BasicMessage(String productType,int value, int numberOfOccurrences) {
    this.productType=productType;
    this.value=value;
    this.count=numberOfOccurrences;
  }

  public void increaseCount(int countValue) {
    count+=countValue;
  }
  public void addSaleValue(int valueToBeAdded){
    value+=valueToBeAdded;
  }
  public void subtractSaleValue(int valueToBeSubtracted){
    value-=valueToBeSubtracted;
  }
  public void multiplySaleValue(int valueToBeMultiplied){
    value*=valueToBeMultiplied;
  }
  public String getProductType(){
    return productType;
  }
  public List<Adjustment> getAdjustments(){
    if(null==adjustments){
      adjustments=new ArrayList<Adjustment>(1);
    }
    return adjustments;
  }
  @Override
  public boolean equals(Object object) {
    BasicMessage productTypeForCompare=(BasicMessage) object;
    return productType.equalsIgnoreCase(productTypeForCompare.getProductType());
  }
  @Override
  public int hashCode() {
    return Objects.hash(productType);
  }
}