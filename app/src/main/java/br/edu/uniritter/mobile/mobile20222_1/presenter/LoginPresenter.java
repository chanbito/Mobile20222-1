package br.edu.uniritter.mobile.mobile20222_1.presenter;

import android.content.Intent;
import android.util.Log;

import br.edu.uniritter.mobile.mobile20222_1.model.User;
import br.edu.uniritter.mobile.mobile20222_1.presenter.Contract.LoginPresenterContract;
import br.edu.uniritter.mobile.mobile20222_1.repository.UserRepository;
import br.edu.uniritter.mobile.mobile20222_1.view.MainActivity;

public class LoginPresenter implements LoginPresenterContract.presenter{
    private LoginPresenterContract.view view;

    public LoginPresenter(LoginPresenterContract.view view) {
        this.view = view;
    }
    @Override
    public void checkLogin(String login, String password) {
        UserRepository repo  = UserRepository.getInstance(view.getActivity());
        User u = repo.getUserByUserLogin(login);
        if (u == null || ! u.getPassword().equals(password)) {
            Log.e("LoginPresenter", "Usuário ou senha Inválido");
            view.message("Usuário ou senha Inválido");
        } else {
            Log.e("LoginPresenter", "trocada");
            u.setPassword("trocada");
            validLogin(u);
        }
    }
    @Override
    public void validLogin(User user) {
        Intent intent = new Intent(view.getActivity(), MainActivity.class);
        //intent.putExtra("userId", user.getId());
        Log.d("Presenter", "user company: " + user.getCompany().getName());
        intent.putExtra("userObj", user);
        view.getActivity().startActivity(intent);
    }
}
