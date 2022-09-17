package br.edu.uniritter.mobile.mobile20222_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import br.edu.uniritter.mobile.mobile20222_1.model.User;
import br.edu.uniritter.mobile.mobile20222_1.presenter.LoginPresenter;
import br.edu.uniritter.mobile.mobile20222_1.presenter.LoginPresenterContract;

public class LoginActivity extends AppCompatActivity implements LoginPresenterContract.view {

    private LoginPresenterContract.presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.presenter = new LoginPresenter(this);
        findViewById(R.id.buttonLogin).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        presenter.checkLogin(
                                ((TextView) findViewById(R.id.edLogin)).getText().toString(),
                                ((TextView) findViewById(R.id.edPassword)).getText().toString()
                        );
                    }
                }
        );
    }

    @Override
    public void message(String msg) {
        Snackbar.make(this,findViewById(R.id.edPassword),
                       msg, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void validLogin(User user) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}