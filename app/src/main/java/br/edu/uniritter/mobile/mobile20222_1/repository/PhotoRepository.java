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

import br.edu.uniritter.mobile.mobile20222_1.model.Photo;

public class PhotoRepository implements Response.Listener<JSONArray>, Response.ErrorListener {
    private final String TAG = "PhotoRepository";
    private List<Photo> photos;
    private static PhotoRepository instance;
    private Context context;

    public PhotoRepository(Context context) {
        super();
        this.context = context;
        photos = new ArrayList<Photo>();
        RequestQueue queue = Volley.newRequestQueue(context);
        JsonArrayRequest jar = new JsonArrayRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/photos",
                null,this,this);

        queue.add(jar);


        Log.e(TAG, "Buscando");
    }

    public List<Photo> getPhotos(){return photos; }

    public List<Photo> getPhotosbyAlbum(int albumId){
        List<Photo> ret = new ArrayList<Photo>();
        Log.d(TAG, "getPhotosbyAlbum: " + photos.size());
        for (Photo t: photos){
            if(t.getAlbumId() == albumId)
                ret.add(t);
        }
        return ret;
    }

    public static PhotoRepository getInstance(Context context) {
        if(instance == null)
            instance = new PhotoRepository(context);
        return instance;
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
                photos.add(new Photo(json.getInt("albumId"),json.getInt("id"),
                        json.getString("title"), json.getString("url"),
                        json.getString("thumbnailUrl")));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        Log.e(TAG, "onResponse: terminei");
    }
}
