package br.edu.uniritter.mobile.mobile20222_1.presenter;

import br.edu.uniritter.mobile.mobile20222_1.model.User;

public class LoginPresenterContract {
    public interface view {
        public void message(String msg);
        public void validLogin(User user);

    }
    public interface presenter {
        public void checkLogin(String login, String password);

    }
}
