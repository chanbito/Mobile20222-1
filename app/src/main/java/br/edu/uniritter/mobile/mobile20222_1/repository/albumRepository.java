package br.edu.uniritter.mobile.mobile20222_1.repository;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.edu.uniritter.mobile.mobile20222_1.model.Album;

public class albumRepository implements Response.Listener<JSONArray>, Response.ErrorListener{
    private final String TAG = "albumRepository";
    private List<Album> albuns;
    private static albumRepository instance;
    private Context context;

    public albumRepository(Context context) {
        super();
        this.context = context;
        albuns = new ArrayList<Album>();
        RequestQueue queue = Volley.newRequestQueue(context);
        JsonArrayRequest jar = new JsonArrayRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/albums",
                null,null,null);
        queue.add(jar);

        Log.e(TAG, "Buscando");
    }

    public static albumRepository getInstance(Context context) {
        if(instance == null)
            instance = new albumRepository(context);
        return instance;
    }

    public List<Album> getAlbuns() {
        return albuns;
    }

    public List<Album> getAlbunsbyUser(int userID) {
        List<Album> ret = new ArrayList<Album>();
        Log.d(TAG, "GetTudobyUser: " + albuns.size());
        for (Album t: albuns){
            if(t.getUserId() == userID)
                ret.add(t);
        }
        return ret;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e(TAG, "onErrorResponse: " + error.getMessage());
    }

    @Override
    public void onResponse(JSONArray response) {
        Log.e(TAG, "onResponse: " + response.length());
        for (int i = 0; i < response.length(); i++) {
            try {
                JSONObject json = response.getJSONObject(i);
                Log.d(TAG, "onResponse: " + json.toString());
                albuns.add(new Album(json.getInt("id"),json.getInt("userId"),
                        json.getString("title")));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        Log.e(TAG, "onResponse: terminei");
    }
}
