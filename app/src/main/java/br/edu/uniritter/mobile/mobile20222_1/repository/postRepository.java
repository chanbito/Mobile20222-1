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
import br.edu.uniritter.mobile.mobile20222_1.model.Photo;
import br.edu.uniritter.mobile.mobile20222_1.model.Post;

public class postRepository implements Response.ErrorListener, Response.Listener<JSONArray> {
    private final String TAG = "postRepository";
    private Context context;
    private List<Post> posts;
    private static postRepository instance;

    public postRepository(Context context) {
        super();
        this.context = context;
        posts = new ArrayList<Post>();
        RequestQueue queue = Volley.newRequestQueue(context);
        JsonArrayRequest jar = new JsonArrayRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/posts",
                null,this,this);

        queue.add(jar);
        Log.e(TAG, "Buscando");
    }

    public static postRepository getInstance(Context cont) {
        if(instance == null)
            instance = new postRepository(cont);
        return instance;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public List<Post> getPostsbyUser(int userID) {
        List<Post> ret = new ArrayList<Post>();
        Log.d(TAG, "getPostsbyUser: " + posts.size());
        for (Post t: posts){
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
                posts.add(new Post(json.getInt("userId"),json.getInt("id"),
                        json.getString("title"), json.getString("body")));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        Log.e(TAG, "onResponse: terminei");
    }
}
