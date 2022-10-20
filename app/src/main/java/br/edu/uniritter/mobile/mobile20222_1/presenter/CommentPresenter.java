package br.edu.uniritter.mobile.mobile20222_1.presenter;

import android.content.Intent;

import br.edu.uniritter.mobile.mobile20222_1.presenter.Contract_package.CommentPresenterContract;
import br.edu.uniritter.mobile.mobile20222_1.view.CommentActivity;

public class CommentPresenter implements CommentPresenterContract.presenter {

    private final CommentPresenterContract.view view;

    public CommentPresenter(CommentPresenterContract.view view){
        this.view = view;
    }

    @Override
    public void PopularCommentsbyPost(int postID) {
        Intent intent = new Intent(view.getActivity(), CommentActivity.class);
        intent.putExtra("postID",postID);
        view.getActivity().startActivity(intent);
    }
}
