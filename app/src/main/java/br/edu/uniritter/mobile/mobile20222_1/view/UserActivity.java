package br.edu.uniritter.mobile.mobile20222_1.view;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import br.edu.uniritter.mobile.mobile20222_1.R;

public class UserActivity  extends AppCompatActivity implements View.OnClickListener{
    private final String TAG = "UserActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: start");
        setContentView(R.layout.activity_user);

    }

    @Override
    public void onClick(View view) {

    }
}
