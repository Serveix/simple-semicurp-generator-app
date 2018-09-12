package com.eliprojects.curpgenerator;

import android.os.Parcel;
import android.os.Parcelable;

public class Curp implements Parcelable{

    //datos del curp
    String lastName1, lastName2, userName;
    String sex;
    int day, year;
    String month;
    String state;

    public Curp(String lastName1, String lastName2, String userName, String sex, int day, String month, int year, String state) {
        this.lastName1 = lastName1;
        this.lastName2 = lastName2;
        this.userName  = userName;
        this.sex = sex;
        this.day = day;
        this.month = month;
        this.year = year;
        this.state = state;
    }

    protected Curp(Parcel in) {
        this.lastName1 = in.readString();
        this.lastName2 = in.readString();
        this.userName  = in.readString();
        this.sex = in.readString();
        this.day = in.readInt();
        this.month = in.readString();
        this.year = in.readInt();
        this.state = in.readString();
    }

    public static final Creator<Curp> CREATOR = new Creator<Curp>() {
        @Override
        public Curp createFromParcel(Parcel in) {
            return new Curp(in);
        }

        @Override
        public Curp[] newArray(int size) {
            return new Curp[size];
        }
    };



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.lastName1);
        parcel.writeString(this.lastName2);
        parcel.writeString(this.userName);
        parcel.writeString(this.sex);
        parcel.writeInt(this.day);
        parcel.writeString(this.month);
        parcel.writeInt(this.year);
        parcel.writeString(this.state);
    }
}
