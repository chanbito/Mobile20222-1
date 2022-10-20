package br.edu.uniritter.mobile.mobile20222_1.view;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import br.edu.uniritter.mobile.mobile20222_1.R;
import br.edu.uniritter.mobile.mobile20222_1.adapter.ToDosAdapter;
import br.edu.uniritter.mobile.mobile20222_1.model.ToDo;
import br.edu.uniritter.mobile.mobile20222_1.presenter.ToDoPresenter;
import br.edu.uniritter.mobile.mobile20222_1.presenter.Contract_package.ToDoPresenterContract;
import br.edu.uniritter.mobile.mobile20222_1.repository.ToDoRepository;

public class ToDoActivity  extends AppCompatActivity implements ToDoPresenterContract.view {
    private final String TAG = "ToDoActivity";

    private ToDoPresenterContract.presenter presenter;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: start");

        //aqui infla o layout xml
        setContentView(R.layout.activity_todos);
        ToDoRepository repo = ToDoRepository.getInstance(this);
        this.presenter = new ToDoPresenter(this);

        RecyclerView rc = findViewById(R.id.recycler1);
        int userId = getIntent().getIntExtra("userID", -1);

        Log.d(TAG, "onCreate: userId " + userId);

        List<ToDo> param = repo.GetTuDobyUser(userId);
        Log.e(TAG, "onCreate: param " + param.size());
        ToDosAdapter adapter = new ToDosAdapter(param);

        rc.setAdapter(adapter);
        LinearLayoutManager llm1 = new LinearLayoutManager(this);
        rc.setLayoutManager(llm1);

    }

    @Override
    public void message(String msg) {
        Snackbar.make(this,findViewById(R.id.edPassword),
                msg, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public Activity getActivity() {
        return this;
    }
}
