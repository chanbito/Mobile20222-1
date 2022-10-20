package br.edu.uniritter.mobile.mobile20222_1.repository.SQLRepositoryes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "BancoApp2";
    private static final Integer DB_VERSION = 1;

    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String geoCreate = "create table geos (id INTEGER PRIMARY KEY, lat TEXT,\n" +
                " lng TEXT);";
        sqLiteDatabase.execSQL(geoCreate);

        String adrressCreate = "create table adrress (id INTEGER PRIMARY KEY, street TEXT,\n" +
                "     suite TEXT, city TEXT, zipcode TEXT, geoId INTEGER);";
        sqLiteDatabase.execSQL(adrressCreate);

        String companyCreate = "create table companys (id INTEGER PRIMARY KEY, name TEXT,\n" +
                "     catchPhrase TEXT, bs TEXT);";
        sqLiteDatabase.execSQL(companyCreate);

        String userCreate = "create table users (id INTEGER PRIMARY KEY, name TEXT,\n" +
                "     userLogin TEXT, password TEXT, email TEXT, phone TEXT, website TEXT" +
                ", adrressId INTEGER, companyId INTEGER);";
        sqLiteDatabase.execSQL(userCreate);

        /*String todosCreate = "create table todos (id INTEGER PRIMARY KEY, name TEXT,\n" +
                "     userLogin TEXT, password TEXT, email TEXT, phone TEXT, website TEXT);";
        sqLiteDatabase.execSQL(todosCreate);

        String postsCreate = "create table posts (id INTEGER PRIMARY KEY, name TEXT,\n" +
                "     userLogin TEXT, password TEXT, email TEXT, phone TEXT, website TEXT);";
        sqLiteDatabase.execSQL(postsCreate);*/


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
