package br.edu.uniritter.mobile.mobile20222_1.presenter;

import android.content.res.Resources;

import br.edu.uniritter.mobile.mobile20222_1.R;
import br.edu.uniritter.mobile.mobile20222_1.model.User;

public class LoginPresenter implements LoginPresenterContract.presenter{
    private LoginPresenterContract.view view;

    public LoginPresenter(LoginPresenterContract.view view) {
        this.view = view;
    }
    @Override
    public void checkLogin(String login, String password) {
        User u = User.getUserByUserLogin(login);
        if (u == null || ! u.getPassword().equals(password)) {
            view.message("Usuário ou senha Inválido");
        } else {
            view.validLogin(u);
        }
    }
}
