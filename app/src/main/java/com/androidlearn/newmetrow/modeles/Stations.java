package com.androidlearn.newmetrow.modeles;

import android.os.Parcel;
import android.os.Parcelable;

public class Stations implements Parcelable {

    private String id;
    private String lineId;
    private String OrderID;
    private String Station_Duration;
    private String title;
    private String title_english;
    private String CreossLine_ID;
    private String addr;
    private String ticket;
    private String escalator;
    private String atm;
    private String taxi;
    private String bus;
    private String phone;
    private String water;
    private String lost;
    private String parking;
    private String elevator;
    private String latitude;
    private String longitude;

     public  Stations(){

     }
    protected Stations(Parcel in) {
        id = in.readString();
        lineId = in.readString();
        OrderID = in.readString();
        Station_Duration = in.readString();
        title = in.readString();
        title_english = in.readString();
        CreossLine_ID = in.readString();
        addr = in.readString();
        ticket = in.readString();
        escalator = in.readString();
        atm = in.readString();
        taxi = in.readString();
        bus = in.readString();
        phone = in.readString();
        water = in.readString();
        lost = in.readString();
        parking = in.readString();
        elevator = in.readString();
        latitude = in.readString();
        longitude = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(lineId);
        dest.writeString(OrderID);
        dest.writeString(Station_Duration);
        dest.writeString(title);
        dest.writeString(title_english);
        dest.writeString(CreossLine_ID);
        dest.writeString(addr);
        dest.writeString(ticket);
        dest.writeString(escalator);
        dest.writeString(atm);
        dest.writeString(taxi);
        dest.writeString(bus);
        dest.writeString(phone);
        dest.writeString(water);
        dest.writeString(lost);
        dest.writeString(parking);
        dest.writeString(elevator);
        dest.writeString(latitude);
        dest.writeString(longitude);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Stations> CREATOR = new Creator<Stations>() {
        @Override
        public Stations createFromParcel(Parcel in) {
            return new Stations(in);
        }

        @Override
        public Stations[] newArray(int size) {
            return new Stations[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    public String getStation_Duration() {
        return Station_Duration;
    }

    public void setStation_Duration(String station_Duration) {
        Station_Duration = station_Duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle_english() {
        return title_english;
    }

    public void setTitle_english(String title_english) {
        this.title_english = title_english;
    }

    public String getCreossLine_ID() {
        return CreossLine_ID;
    }

    public void setCreossLine_ID(String creossLine_ID) {
        CreossLine_ID = creossLine_ID;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getEscalator() {
        return escalator;
    }

    public void setEscalator(String escalator) {
        this.escalator = escalator;
    }

    public String getAtm() {
        return atm;
    }

    public void setAtm(String atm) {
        this.atm = atm;
    }

    public String getTaxi() {
        return taxi;
    }

    public void setTaxi(String taxi) {
        this.taxi = taxi;
    }

    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public String getLost() {
        return lost;
    }

    public void setLost(String lost) {
        this.lost = lost;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public String getElevator() {
        return elevator;
    }

    public void setElevator(String elevator) {
        this.elevator = elevator;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
