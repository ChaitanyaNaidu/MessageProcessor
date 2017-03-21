package com.jpm.message;

/**
 * @author Chaitanya Naidu (n417278) on 21/03/2017.
 */
public class Adjustment {

    private final String adjustmentType;
    private final int value;

    public String getAdjustmentType() {
        return adjustmentType;
    }

    public int getValue() {
        return value;
    }

    public Adjustment(String adjustmentType, int value){
        this.adjustmentType=adjustmentType;
        this.value=value;
    }
    @Override
    public String toString(){
        return adjustmentType+"-"+value;
    }
}
