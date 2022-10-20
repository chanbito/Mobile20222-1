package br.edu.uniritter.mobile.mobile20222_1.view;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import br.edu.uniritter.mobile.mobile20222_1.presenter.Contract_package.CommentPresenterContract;


public class CommentActivity extends AppCompatActivity implements CommentPresenterContract.view {
    private final String TAG = "CommentActivity";
    private CommentPresenterContract.presenter presenter;
    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: start");

        /*//aqui infla o layout xml
        commentRepository repo = commentRepository.getInstance(this);
        this.presenter = new CommentPresenter(this);

        RecyclerView rc = findViewById(R.id.recycler1);
        int postID = getIntent().getIntExtra("postID", -1);

        Log.d(TAG, "onCreate: userId " + postID);

        List<ToDo> param = repo.getCommentsbyPost(postID);
        Log.e(TAG, "onCreate: param " + param.size());
        ToDosAdapter adapter = new ToDosAdapter(param);

        rc.setAdapter(adapter);
        LinearLayoutManager llm1 = new LinearLayoutManager(this);
        rc.setLayoutManager(llm1);*/
    }
}
