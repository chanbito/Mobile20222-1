package br.edu.uniritter.mobile.mobile20222_1.presenter.Contract;

import android.app.Activity;

public class CommentContract {
    public interface view {

        public Activity getActivity();
    }

    public interface presenter {
        /*public int GetTodosCount(int userID);*/
        public void GoCommentsbyPost(int postID);
    }
}
