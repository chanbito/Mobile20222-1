package br.edu.uniritter.mobile.mobile20222_1.presenter.Contract;

import android.app.Activity;

public class ToDoPresenterContract {
    public interface view {
        public void message(String msg);
        public Activity getActivity();
    }

    public interface presenter {
        /*public int GetTodosCount(int userID);*/
        public void GoToDos(int userID);
    }
}
