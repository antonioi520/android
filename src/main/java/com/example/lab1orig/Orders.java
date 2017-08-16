package com.example.lab1orig;

/**
 * Created by anton on 7/19/2017.
 */

public class Orders {
    String first;
    String last;
    String typeofChocolate;
    int numberofBars;
    Boolean shippingType;

    public Orders(){}

    public Orders(String first, String last, String typeofChocolate, int numberofBars, Boolean shippingType){
        super();
        this.first = first;
        this.last = last;
        this.typeofChocolate = typeofChocolate;
        this.numberofBars = numberofBars;
        this.shippingType = shippingType;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String getTypeofChocolate() {
        return typeofChocolate;
    }

    public int getNumberofBars() {
        return numberofBars;
    }

    public Boolean getShippingType() {
        return shippingType;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public void setTypeofChocolate(String typeofChocolate) {
        this.typeofChocolate = typeofChocolate;
    }

    public void setNumberofBars(int numberofBars) {
        this.numberofBars = numberofBars;
    }

    public void setShippingType(Boolean shippingType) {
        this.shippingType = shippingType;
    }


}
