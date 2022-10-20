package br.edu.uniritter.mobile.mobile20222_1.presenter.Contract_package;

import android.app.Activity;

public class CommentPresenterContract {
    public interface view {

        public Activity getActivity();
    }

    public interface presenter {
        /*public int GetTodosCount(int userID);*/
        public void PopularCommentsbyPost(int postID);
    }

}
