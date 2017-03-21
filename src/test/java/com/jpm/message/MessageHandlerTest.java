package com.jpm.message;

import java.util.Scanner;

/**
 * @author Chaitanya Naidu (n417278) on 21/03/2017.
 */
public class MessageHandlerTest extends MessageHandler {

    public MessageHandlerTest(Scanner scanner){
        super(scanner);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MessageHandlerTest messageHandlerTest=new MessageHandlerTest(scanner);
        Thread thread=new Thread(messageHandlerTest);
        thread.start();
    }
    /**
     * Example of output showed below.  I have printed sales report for every 5 messages for testing purpose and adjustments report for every 10 messages
     *
     */
    /**

     1. Message Type-1
     2. Message Type-2
     3. Message Type-3
     Select your choice of sale:1
     Enter product type: apples
     1. Message Type-1
     2. Message Type-2
     3. Message Type-3
     Select your choice of sale:2
     Enter number of occurrences of sale: 10
     Enter product type: apples
     1. Message Type-1
     2. Message Type-2
     3. Message Type-3
     Select your choice of sale:3
     Enter number of occurrences of sale: 5
     Enter product type: apples
     Enter your choice of adjustment:
     1.Add
     2.Subtract
     3.Multiply
     Add 10p apples
     1. Message Type-1
     2. Message Type-2
     3. Message Type-3
     Select your choice of sale:2
     Enter number of occurrences of sale: 10
     Enter product type: berries
     1. Message Type-1
     2. Message Type-2
     3. Message Type-3
     Select your choice of sale:1
     Enter product type: berries

     -------------------------------
     Sales report
     -------------------------------
     16 apples at 20p with a total sale of 320
     11 berries at 10p with a total sale of 110
     -------------------------------

     1. Message Type-1
     2. Message Type-2
     3. Message Type-3
     Select your choice of sale:3
     Enter number of occurrences of sale: 5
     Enter product type: apples
     Enter your choice of adjustment:
     1.Add
     2.Subtract
     3.Multiply
     Subtract 2p apples
     1. Message Type-1
     2. Message Type-2
     3. Message Type-3
     Select your choice of sale:2
     Enter number of occurrences of sale: 5
     Enter product type: grapes
     1. Message Type-1
     2. Message Type-2
     3. Message Type-3
     Select your choice of sale:3
     Enter number of occurrences of sale: 20
     Enter product type: grapes
     Enter your choice of adjustment:
     1.Add
     2.Subtract
     3.Multiply
     Multiply 2p grapes
     1. Message Type-1
     2. Message Type-2
     3. Message Type-3
     Select your choice of sale:1
     Enter product type: kiwi
     1. Message Type-1
     2. Message Type-2
     3. Message Type-3
     Select your choice of sale:2
     Enter number of occurrences of sale: 5
     Enter product type: kiwi

     -------------------------------
     Sales report
     -------------------------------
     21 apples at 18p with a total sale of 378
     11 berries at 10p with a total sale of 110
     25 grapes at 20p with a total sale of 500
     6 kiwi at 10p with a total sale of 60
     -------------------------------

     pausing the messages...
     -------------------------------
     Adjustments report
     -------------------------------
     Adjustments on product type :apples
        Performed ADD with value 10p
        Performed SUBTRACT with value 2p
     Adjustments on product type :berries
     Adjustments on product type :grapes
        Performed MULTIPLY with value 2p
     Adjustments on product type :kiwi
     -------------------------------

     Process finished with exit code 0

     */
}