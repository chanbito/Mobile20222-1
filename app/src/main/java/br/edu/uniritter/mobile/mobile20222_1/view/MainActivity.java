package br.edu.uniritter.mobile.mobile20222_1.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.edu.uniritter.mobile.mobile20222_1.R;
import br.edu.uniritter.mobile.mobile20222_1.adapter.PostsAdapter;
import br.edu.uniritter.mobile.mobile20222_1.model.User;
import br.edu.uniritter.mobile.mobile20222_1.presenter.ToDoPresenter;
import br.edu.uniritter.mobile.mobile20222_1.presenter.Contract_package.ToDoPresenterContract;
import br.edu.uniritter.mobile.mobile20222_1.repository.ToDoRepository;
import br.edu.uniritter.mobile.mobile20222_1.repository.PostRepository;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ToDoPresenterContract.view {
    private final String TAG = "MainActivity";
    private User user ;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: começando a bagaça");

        //aqui infla o layout xml
        setContentView(R.layout.activity_main);
        ToDoRepository.getInstance(this);
        PostRepository.getInstance(this);

        user = getIntent().getParcelableExtra("userObj");

        Log.d(TAG, "user company: " + user.getCompany().getName());

        RecyclerView rc = findViewById(R.id.recyclerPost);
        PostsAdapter adapter = new PostsAdapter( PostRepository.getInstance(this).getPostsbyUser(
                this.user.getId()));
        rc.setAdapter(adapter);
        LinearLayoutManager llm1 = new LinearLayoutManager(this);
        rc.setLayoutManager(llm1);

        findViewById(R.id.Perfilbutton).setOnClickListener(
                (view) -> {
                    Log.d(TAG, "onClick: Alguém clicou no botao de perfil");

                    Intent intent = new Intent(view.getContext(), UserActivity.class);
                    startActivity(intent);
                });
        findViewById(R.id.ToDoButton).setOnClickListener(

                (view) -> {
                    Log.d(TAG, "onClick: Alguém clicou no botão de tarefas");
                    new ToDoPresenter(this).GoToDos(this.user.getId());

                    /*
                    Intent intent = new Intent(view.getContext(), ToDoActivity.class);

                    startActivity(intent);*/

                });

        //int id = getIntent().getIntExtra("userId",-1);
        //User user = UserRepository.getInstance().getUserById(id);
        //troquei de envio de id int para objeto

        Log.d(TAG, "Company: " + user.getCompany().getName());
        button = findViewById(R.id.ToDoButton);
        button.setText("" + ToDoRepository.getInstance(this).GetTudosUncheckbyUser(this.user.getId()));


        //TextView tv = (TextView) findViewById(R.id.editTextTextPersonName2);
        TextView tv = (TextView) findViewById(R.id.TextPersonName2);
        tv.setText(user.getName());


    }

    @Override
    public void onClick(View view) {
    }

    @Override
    public void message(String msg) {

    }

    @Override
    public Activity getActivity() {
        return this;
    }
}