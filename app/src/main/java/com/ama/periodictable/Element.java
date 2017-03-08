package com.ama.periodictable;

/**
 * Created by ching on 3/8/2017.
 */

public class Element {
    private int number;
    private String name;
    private String symbol;
    private String weight;

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() { return symbol; }

    public String getWeight() {
        if(weight.charAt(0) == '['){
            weight = weight.substring(1, weight.length() - 1);
        }

        if(weight.length() < 12)
            return weight;

        return weight.substring(0, 10) +"...";
    }
}
