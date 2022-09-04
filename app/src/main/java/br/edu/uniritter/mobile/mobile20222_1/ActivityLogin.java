package br.edu.uniritter.mobile.mobile20222_1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.edu.uniritter.mobile.mobile20222_1.BD.UserBD;

public class ActivityLogin extends AppCompatActivity implements View.OnClickListener{
    private final String TAG = "Login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: começando o login");
        setContentView(R.layout.login_view);

        findViewById(R.id.button).setOnClickListener(
                (view) -> {
                    Log.d(TAG, "onClick: Login ");
                    TextView tpassword = (TextView) findViewById(R.id.CampoPassword);
                    TextView tlogin = (TextView) findViewById(R.id.CampoLogin);

                    String login = tlogin.getText().toString();
                    String senha = tpassword.getText().toString();

                    if(UserBD.Logar(login,senha)){
                        Intent intent = new Intent(view.getContext(), MainActivity.class);
                        startActivity(intent);
                    }else{
                        TextView warn = (TextView) findViewById(R.id.LabelIncorrectPassword);
                        warn.setVisibility(View.VISIBLE);
                    }


                });
    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button) {
            Log.d(TAG, "onClick: indo pra main");
            Intent intent = new Intent(view.getContext(), MainActivity.class);
            startActivity(intent);
        }
    }
}
