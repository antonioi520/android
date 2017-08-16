package com.example.anton.lab1f;


import android.os.Parcel;
import android.os.Parcelable;

public class Orders implements Parcelable {
    private String first;
    private String last;
    private String typeofChocolate;
    private int numberOfBars;
    private Boolean shippingType;

    public Orders(){}

    public Orders(String first, String last, String typeofChocolate, int numberOfBars, Boolean shippingType){
        super();
        this.first = first;
        this.last = last;
        this.typeofChocolate = typeofChocolate;
        this.numberOfBars = numberOfBars;
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
        return numberOfBars;
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

    public void setNumberofBars(int numberOfBars) {
        this.numberOfBars = numberOfBars;
    }

    public void setShippingType(Boolean shippingType) {
        this.shippingType = shippingType;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.first);
        dest.writeString(this.last);
        dest.writeString(this.typeofChocolate);
        dest.writeInt(this.numberOfBars);
        dest.writeValue(this.shippingType);
    }

    protected Orders(Parcel in) {
        this.first = in.readString();
        this.last = in.readString();
        this.typeofChocolate = in.readString();
        this.numberOfBars = in.readInt();
        this.shippingType = (Boolean) in.readValue(Boolean.class.getClassLoader());
    }

    public static final Parcelable.Creator<Orders> CREATOR = new Parcelable.Creator<Orders>() {
        @Override
        public Orders createFromParcel(Parcel source) {
            return new Orders(source);
        }

        @Override
        public Orders[] newArray(int size) {
            return new Orders[size];
        }
    };
}
