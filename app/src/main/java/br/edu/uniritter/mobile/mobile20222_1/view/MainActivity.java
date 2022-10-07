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

import java.util.List;

import br.edu.uniritter.mobile.mobile20222_1.R;
import br.edu.uniritter.mobile.mobile20222_1.adapter.UsersAddapter;
import br.edu.uniritter.mobile.mobile20222_1.model.ToDo;
import br.edu.uniritter.mobile.mobile20222_1.model.User;
import br.edu.uniritter.mobile.mobile20222_1.presenter.ToDoPresenter;
import br.edu.uniritter.mobile.mobile20222_1.presenter.ToDoPresenterContract;
import br.edu.uniritter.mobile.mobile20222_1.repository.ToDoRepository;
import br.edu.uniritter.mobile.mobile20222_1.repository.UserRepository;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ToDoPresenterContract.view {
    private final String TAG = "MainActivity";
    private int userID ;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: começando a bagaça");

        //aqui infla o layout xml
        setContentView(R.layout.activity_main);

        /*(R.id.botao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Activity2.class);
                startActivity(intent);
            }
        });
        */
        //findViewById(R.id.ToDoButton).setOnClickListener( this );
        User user = getIntent().getParcelableExtra("userObj");
        this.userID = user.getId();

        View.OnClickListener ocl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Alguém clicou ocl");
                Intent intent = new Intent(view.getContext(), UserActivity.class);

                startActivity(intent);
            }
        };
        //buscando um elemento visual do layout para manuipulação
        //Button bt  = findViewById(R.id.button02);

        //findViewById(R.id.button02).setOnClickListener( ocl );
        /*findViewById(R.id.botao).setOnClickListener(
                (view) -> {
                    Log.d(TAG, "onClick: Alguém clicou lambda");

                    Intent intent = new Intent(view.getContext(), Activity2.class);
                    startActivity(intent);
                });
        RecyclerView rc = findViewById(R.id.recycler1);
        UsersAddapter adapter = new UsersAddapter( UserRepository.getInstance(this).getUsers());
        rc.setAdapter(adapter);
        LinearLayoutManager llm1 = new LinearLayoutManager(this);
        rc.setLayoutManager(llm1);
*/

        int userID = user.getId();
        findViewById(R.id.Perfilbutton).setOnClickListener(
                (view) -> {
                    Log.d(TAG, "onClick: Alguém clicou no botao de perfil");

                    Intent intent = new Intent(view.getContext(), UserActivity.class);
                    startActivity(intent);
                });
        findViewById(R.id.ToDoButton).setOnClickListener(

                (view) -> {
                    Log.d(TAG, "onClick: Alguém clicou no botão de tarefas");
                    new ToDoPresenter(this).GoToDos(this.userID);

                    /*
                    Intent intent = new Intent(view.getContext(), ToDoActivity.class);

                    startActivity(intent);*/

                });

        //int id = getIntent().getIntExtra("userId",-1);
        //User user = UserRepository.getInstance().getUserById(id);
        //troquei de envio de id int para objeto


        //button = findViewById(R.id.ToDoButton);
        //button.setText("0");// + ToDoRepository.getInstance(this).GetTudosUncheckbyUser(user.getId()));


        //TextView tv = (TextView) findViewById(R.id.editTextTextPersonName2);
        TextView tv = (TextView) findViewById(R.id.TextPersonName2);
        tv.setText(user.getName());

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button02) {
            Intent intent = new Intent(view.getContext(), Activity2.class);
            startActivity(intent);
        }
        /*if (view.getId() == R.id.ToDoButton) {
            Log.d(TAG, "onClick: Alguém clicou no botão de tarefas");

            Intent intent = new Intent(view.getContext(), ToDoActivity.class);
            intent.putExtra("userID", userID);
            startActivity(intent);
        }*/
    }

    @Override
    public void message(String msg) {

    }

    @Override
    public Activity getActivity() {
        return this;
    }
}