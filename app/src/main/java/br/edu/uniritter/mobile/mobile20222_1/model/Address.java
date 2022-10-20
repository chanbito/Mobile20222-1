package br.edu.uniritter.mobile.mobile20222_1.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Address implements Parcelable {
    private int id;
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    public Address(int id, String street, String suite, String city, String zipcode, Geo Geo){
        this.id = id;
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = Geo;
    }

    protected Address(Parcel in) {
        id = in.readInt();
        street = in.readString();
        suite = in.readString();
        city = in.readString();
        zipcode = in.readString();
        geo = in.readParcelable(Geo.class.getClassLoader());
    }

    public static final Creator<Address> CREATOR = new Creator<Address>() {
        @Override
        public Address createFromParcel(Parcel in) {
            return new Address(in);
        }

        @Override
        public Address[] newArray(int size) {
            return new Address[size];
        }
    };


   @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(street);
        parcel.writeString(suite);
        parcel.writeString(city);
        parcel.writeString(zipcode);
        parcel.writeParcelable(geo, i);
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
