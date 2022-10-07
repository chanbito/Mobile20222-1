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

import br.edu.uniritter.mobile.mobile20222_1.model.Comment;
import br.edu.uniritter.mobile.mobile20222_1.model.Photo;

public class commentRepository implements Response.Listener<JSONArray>, Response.ErrorListener {
    private final String TAG = "commentRepository";
    private List<Comment> comments;
    private static commentRepository instance;
    private Context context;

    public commentRepository(Context context) {
        super();
        this.context = context;
        comments = new ArrayList<Comment>();
        RequestQueue queue = Volley.newRequestQueue(context);
        JsonArrayRequest jar = new JsonArrayRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/comments",
                null,this,this);

        queue.add(jar);
    }

    public static commentRepository getInstance(Context context) {
        if(instance == null)
            instance = new commentRepository((context));
        return instance;
    }

    public List<Comment> getCommentsbyPost(int postID) {
        List<Comment> ret = new ArrayList<Comment>();
        Log.d(TAG, "getCommentsbyPost: " + comments.size());
        for (Comment t: comments){
            if(t.getPostId() == postID)
                ret.add(t);
        }
        return ret;
    }

    public List<Comment> getComments() {
        return comments;
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
                comments.add(new Comment(json.getInt("postID"),json.getInt("id"),
                        json.getString("email"), json.getString("body"),
                        json.getString("email")));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        Log.e(TAG, "onResponse: terminei");
    }
}
