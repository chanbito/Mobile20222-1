package br.edu.uniritter.mobile.mobile20222_1.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Geo implements Parcelable {
    private int id;
    private String lat;
    private String lng;

    public Geo(String lat, String lng, int id ){
        this.lat = lat;
        this.lng = lng;
        this.id = id;
    }

    protected Geo(Parcel in) {
        lat = in.readString();
        lng = in.readString();
        id = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(lat);
        dest.writeString(lng);
        dest.writeInt(id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Geo> CREATOR = new Creator<Geo>() {
        @Override
        public Geo createFromParcel(Parcel in) {
            return new Geo(in);
        }

        @Override
        public Geo[] newArray(int size) {
            return new Geo[size];
        }
    };

    public String getLat() {
        return lat;
    }

    public int getId() {
        return id;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
}
