package br.edu.uniritter.mobile.mobile20222_1.repository;

import android.content.Context;
import android.util.Log;

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

import br.edu.uniritter.mobile.mobile20222_1.model.ToDo;

public class ToDoRepository implements Listener<JSONArray>, Response.ErrorListener {
    private final String TAG = "ToDoRepository";
    private List<ToDo>  todos;
    private static ToDoRepository instance;
    private Context context;

    public ToDoRepository(Context context) {
        super();
        this.context = context;
        todos = new ArrayList<>();
        RequestQueue queue = Volley.newRequestQueue(context);
        JsonArrayRequest jar = new JsonArrayRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/todos",
                null,this,this);

        queue.add(jar);


        Log.e(TAG, "Buscando");
    }

    public List<ToDo> getTodo(){return todos; }

    public static ToDoRepository getInstance(Context contexto) {
        if (instance == null) {
            instance = new ToDoRepository(contexto);
        }
        return instance;
    }

    public ToDo GetTudo(int id){
        ToDo ret = null;
        Log.d(TAG, "GetTudo: " + todos.size());
        for (ToDo t: todos){
            if(t.getId() == id)
                ret = t;
        }
        return ret;
    }

    public List<ToDo> GetTuDobyUser(int id){
        List<ToDo> ret = new ArrayList<ToDo>();
        Log.d(TAG, "GetTudobyUser: " + todos.size());
        for (ToDo t: todos){
            if(t.getUserId() == id)
                ret.add(t);
        }
        return ret;
    }

    public int GetTudosUncheckbyUser(int id){
        int ret = 0;
        Log.d(TAG, "GetTudosUncheckbyUser: " + todos.size());
        for (ToDo t: todos){
            if(t.getUserId() == id && !t.getCompleted())
                ret++;
        }
        Log.d(TAG, "GetTudosUncheckbyUser result: " + ret);
        return ret;
    }

    @Override
    public void onResponse(JSONArray response) {
        Log.e(TAG, "onResponse: " + response.length());
        for (int i = 0; i < response.length(); i++) {
            try {
                JSONObject json = response.getJSONObject(i);
                Log.d(TAG, "onResponse: " + json.toString());
                todos.add(new ToDo(json.getInt("userId"),json.getInt("id"),
                        json.getString("title"),json.getBoolean("completed")));
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

    public List<ToDo> getTodos() {
        return todos;
    }
}
