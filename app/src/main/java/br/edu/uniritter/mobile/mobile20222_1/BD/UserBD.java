package br.edu.uniritter.mobile.mobile20222_1.BD;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import br.edu.uniritter.mobile.mobile20222_1.model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class UserBD {

    private static List<User> Banco;

    public static List<User> getUsers() {
        _StartBanco();
        return Banco;
    }

    public static boolean Logar(String Login, String Password){
        _StartBanco();
        for (User item: Banco){

            if(item.getUserLogin().equals(Login) && item.getPassword().equals(Password)){
                Log.d("Banco", "POde entra");
                return true;
            }
        }
        return false;
    }

    public static boolean NewUserBD(String name,String Login, String Password){
        _StartBanco();
        int id = int.class.cast(Banco.stream().count());
        User novo = new User(id,name,Login,Password);
        Banco.add(novo);
        return true;

    }

    private static void _StartBanco(){
        if(Banco == null){
            Banco = new ArrayList<>();
            int _id = 0;
            Banco.add( new User(_id++, "Jean", "jp1", "1234"));
            Banco.add( new User(_id++, "Jean 2", "jp2", "1234"));
            Banco.add( new User(_id++, "Jean 3", "jp3", "1234"));
            Banco.add( new User(_id++, "Jean 4", "jp4", "1234"));
            Banco.add( new User(_id++, "admin", "admin", "admin"));
        }
    }
}
