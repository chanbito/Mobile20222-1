package br.edu.uniritter.mobile.mobile20222_1.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private int id;
    private String name;
    private String userLogin;
    private String password;
    private String email;
    private String phone;
    private String website;
    private Address address;
    private Company company;

    public User(int id, String name, String userLogin, String password, String email, String phone,
                String website, Address address, Company company) {
        this.id = id;
        this.name = name;
        this.userLogin = userLogin;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.website = website;
        this.address = address;
        this.company = company;
    }

    protected User(Parcel in) {
        id = in.readInt();
        name = in.readString();
        userLogin = in.readString();
        password = in.readString();
        email = in.readString();
        phone = in.readString();
        website = in.readString();
        // visitar https://stackoverflow.com/questions/42665066/android-parsing-same-variable-object-name-in-retrofit
        address = in.readTypedObject(Address.CREATOR);
        company = in.readTypedObject(Company.CREATOR);
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTitulo() {
        return userLogin+" - "+name+" ("+id+")";
    }
    public String getPassword() {
        return password;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(userLogin);
        parcel.writeString(password);
        parcel.writeTypedObject(address, i);
        parcel.writeTypedObject(company, i);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
