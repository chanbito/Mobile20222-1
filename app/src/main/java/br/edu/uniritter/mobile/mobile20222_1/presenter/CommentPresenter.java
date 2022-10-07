package br.edu.uniritter.mobile.mobile20222_1.presenter;

import android.content.Intent;

import br.edu.uniritter.mobile.mobile20222_1.model.Comment;
import br.edu.uniritter.mobile.mobile20222_1.presenter.Contract.CommentContract;
import br.edu.uniritter.mobile.mobile20222_1.view.ToDoActivity;

public class CommentPresenter implements CommentContract.presenter {

    private final CommentContract.view view;

    private CommentPresenter(CommentContract.view view){
        this.view = view;
    }
    
    @Override
    public void GoCommentsbyPost(int postID) {
        /*Intent intent = new Intent(view.getActivity(), .class);
        intent.putExtra("postID",postID);
        view.getActivity().startActivity(intent);*/
    }
}
