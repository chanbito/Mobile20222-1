package br.edu.uniritter.mobile.mobile20222_1.repository.SQLRepositoryes;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.edu.uniritter.mobile.mobile20222_1.model.User;

public class CompanySQLRepository {
    private final String TAG = "UserSQLRepository";
    private static CompanySQLRepository instance;
    private Context contexto;
    private SQLiteDatabase database;

    public static CompanySQLRepository getInstance(Context contexto) {
        if (instance == null) {
            instance = new CompanySQLRepository(contexto);
        }
        return instance;
    }

    private CompanySQLRepository(Context contexto) {
        super();
        this.contexto = contexto;
        DataBaseHelper dataBaseHelper = new DataBaseHelper(contexto);
        database = dataBaseHelper.getWritableDatabase();

    }
    public List<User> getUsers() {
        String sql = "select id, name, userLogin, password, email, phone, website from users where id=? and name = ?;";
        User u = new User(1, "1","1","1","1","1","1");
        String[] args = {u.getId()+"", "jean"};
        Cursor cursor = database.rawQuery(sql,args);
        cursor.moveToFirst();
        List<User> users = new ArrayList<>();
        do {
            users.add(userFromCursor(cursor));
        } while (cursor.moveToNext());
        return users;
    }
    public User getUserById(int id) {
        String sql = "select id, name, userLogin, password, email, phone, website from users where id=? ;";
        String[] args = {""+id};
        Cursor cursor = database.rawQuery(sql,args);
        if (cursor.moveToFirst()) {
            return userFromCursor(cursor);
        } else {
            return null;
        }
    }
    public List<User> getUsersByName(String name) {
        String sql = "select id, name, userLogin, password, email, phone, website from users where name like ?;";
        User u = new User(1, "1","1","1","1","1","1");
        String[] args = {"%"+name+"%"};
        Cursor cursor = database.rawQuery(sql,args);
        cursor.moveToFirst();
        List<User> users = new ArrayList<>();
        do {
            users.add(userFromCursor(cursor));
        } while (cursor.moveToNext());
        return users;
    }
    //
    public void insertUser(User user) {
        String sql = "insert into users (id, name, userLogin, password, email, phone, website) " +
                "values (?, ?, ?, ?, ?, ?, ?);";
        //para usar execSQL os args são um array de Object, não de Strings
        Object[] args = {user.getId(), user.getName(), user.getUserLogin(), user.getPassword()};
        database.execSQL(sql,args);
    }
    public void updateUser(User user) {
        String sql = "update  users set name = ?, userLogin = ?, password = ?, email = ?, phone = ?," +
                " website = ?;";
        //para usar execSQL os args são um array de Object, não de Strings
        Object[] args = {user.getName(), user.getUserLogin(), user.getPassword(), user.getEmail(),
        user.getPhone(), user.getWebsite()};
        database.execSQL(sql,args);
    }
    public void deleteUser(User user) {
        String sql = "delete from users where id = ?;";
        //para usar execSQL os args são um array de Object, não de Strings
        Object[] args = {user.getId()};
        database.execSQL(sql,args);
    }


    private User userFromCursor(Cursor cursor) {
        User user = new User(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5),
                cursor.getString(6)
        );
        return user;
    }

}
