package br.edu.uniritter.mobile.mobile20222_1.presenter.Contract_package;

import android.app.Activity;

import br.edu.uniritter.mobile.mobile20222_1.model.User;

public class LoginPresenterContract {
    public interface view {
        public void message(String msg);
        public Activity getActivity();
        public void preferencesUserUpdate(int userId);
    }

    public interface presenter {
        public void checkLogin(String login, String password);
        public void validLogin(User user);

    }
}
