package br.edu.uniritter.mobile.mobile20222_1.repository.SQLRepositoryes;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.edu.uniritter.mobile.mobile20222_1.model.Geo;
import br.edu.uniritter.mobile.mobile20222_1.model.User;

public class GeoSQLRepository {
    private final String TAG = "UserSQLRepository";
    private static GeoSQLRepository instance;
    private Context contexto;
    private SQLiteDatabase database;

    public static GeoSQLRepository getInstance(Context contexto) {
        if (instance == null) {
            instance = new GeoSQLRepository(contexto);
        }
        return instance;
    }

    private GeoSQLRepository(Context contexto) {
        super();
        this.contexto = contexto;
        DataBaseHelper dataBaseHelper = new DataBaseHelper(contexto);
        database = dataBaseHelper.getWritableDatabase();

    }
    public List<Geo> getGeo() {
        String sql = "select id, lat, lng from geo;";

        Cursor cursor = database.rawQuery(sql,null);
        cursor.moveToFirst();
        List<Geo> geos = new ArrayList<>();
        do {
            geos.add(geoFromCursor(cursor));
        } while (cursor.moveToNext());
        return geos;
    }
    public Geo getGeoById(int id) {
        String sql = "select id, lat, lng from geos where id=? ;";
        String[] args = {""+id};
        Cursor cursor = database.rawQuery(sql,args);
        if (cursor.moveToFirst()) {
            return geoFromCursor(cursor);
        } else {
            return null;
        }
    }

    //
    public void insertGeo(Geo geo) {
        String sql = "insert into geo (id, lat, lng) " +
                "values (?, ?, ?);";
        //para usar execSQL os args são um array de Object, não de Strings
        Object[] args = {geo.getId(), geo.getLat(), geo.getLng()};
        database.execSQL(sql,args);
    }
    public void updateGeo(Geo geo) {
        String sql = "update  geos set id = ?, lat = ?, lng = ?;";
        //para usar execSQL os args são um array de Object, não de Strings
        Object[] args = {geo.getId(), geo.getLat(), geo.getLng()};
        database.execSQL(sql,args);
    }
    public void deleteGeo(Geo geo) {
        String sql = "delete from geos where id = ?;";
        //para usar execSQL os args são um array de Object, não de Strings
        Object[] args = {geo.getId()};
        database.execSQL(sql,args);
    }


    private Geo geoFromCursor(Cursor cursor) {
        Geo geo = new Geo(
                cursor.getString(1),
                cursor.getString(2),
                cursor.getInt(0)
        );
        return geo;
    }

}
