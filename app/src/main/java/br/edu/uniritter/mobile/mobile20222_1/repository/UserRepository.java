package br.edu.uniritter.mobile.mobile20222_1.repository;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.edu.uniritter.mobile.mobile20222_1.model.Address;
import br.edu.uniritter.mobile.mobile20222_1.model.Company;
import br.edu.uniritter.mobile.mobile20222_1.model.Geo;
import br.edu.uniritter.mobile.mobile20222_1.model.User;

public class UserRepository implements Listener<JSONArray>,Response.ErrorListener {
    private final String TAG = "UserRepository";
    private List<User> users;
    private static UserRepository instance;
    private Context contexto;

    private UserRepository(Context contexto) {
        super();
        this.contexto = contexto;
        users = new ArrayList<>();
        RequestQueue queue = Volley.newRequestQueue(contexto);
        //usando o proprio objeto como ResponseListener
        JsonArrayRequest jaRequest = new JsonArrayRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/users",
                null, this, this);

        queue.add(jaRequest);

        Log.e(TAG, "UserRepository: lancei");
    }

    public static UserRepository getInstance(Context contexto) {
        if (instance == null) {
            instance = new UserRepository(contexto);
        }
        return instance;
    }

    private Company getCompany(JSONObject json) throws JSONException {
        return new Company(json.getString("name"), json.getString("catchPhrase"),
                json.getString("bs"));
    }

    private Address GetAdrress(JSONObject json) {
        try {
            Geo _geo = new Geo(json.getJSONObject("geo").getString("lat"),
                    json.getJSONObject("geo").getString("lng"));
            return new Address(json.getString("street"), json.getString("suite"),
                    json.getString("city"), json.getString("zipcode"), _geo);

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }


    public List<User> getUsers() {
        return users;
    }

    public User getUserById(int id) {
        User ret = null;
        for (User u : users) {
            if (u.getId() == id) {
                ret = u;
            }
        }
        return ret;
    }

    public User getUserByUserLogin(String login) {
        User ret = null;
        Log.d(TAG, "getUserByUserLogin: users.size " + users.size());
        for (User u : users) {
            Log.d(TAG, "getUserByUserLogin: " + login + " ->" + u.getUserLogin());
            if (u.getUserLogin().equals(login)) {
                ret = u;
            }
        }
        return ret;
    }

    public User addUser(User user) {
        return null;
    }

    public User updateUser(User user) {
        return null;
    }

    public User removeUser(User user) {
        return null;
    }


    @Override
    public void onResponse(JSONArray response) {
        Log.e(TAG, "onResponse: " + response.length());
        for (int i = 0; i < response.length(); i++) {
            try {
                JSONObject json = response.getJSONObject(i);
                Log.d(TAG, "onResponse: " + json.toString());
                users.add(new User(json.getInt("id"), json.getString("name"),
                        json.getString("username"), json.getString("username"),
                        json.getString("email"), json.getString("phone"),
                        json.getString("website"), GetAdrress(json.getJSONObject("address")),
                        getCompany(json.getJSONObject("company"))));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        Log.e(TAG, "onResponse: terminei");
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e(TAG, "onErrorResponse: " + error.getMessage());
    }
}
