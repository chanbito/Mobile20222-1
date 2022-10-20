package br.edu.uniritter.mobile.mobile20222_1.adapter;

import android.app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import br.edu.uniritter.mobile.mobile20222_1.presenter.Contract_package.CommentPresenterContract;

public class CommentsAdapter  extends AppCompatActivity implements CommentPresenterContract.view {
    private final String TAG = "CommentsAdapter";

    private CommentPresenterContract.presenter presenter;

    @Override
    public Activity getActivity() {
        return null;
    }
}
