package br.edu.uniritter.mobile.mobile20222_1.presenter;

import android.app.Activity;
import android.content.Intent;

import br.edu.uniritter.mobile.mobile20222_1.repository.ToDoRepository;
import br.edu.uniritter.mobile.mobile20222_1.repository.UserRepository;
import br.edu.uniritter.mobile.mobile20222_1.view.MainActivity;
import br.edu.uniritter.mobile.mobile20222_1.view.ToDoActivity;

public class ToDoPresenter implements ToDoPresenterContract.presenter {

    private ToDoPresenterContract.view view;

    public ToDoPresenter(ToDoPresenterContract.view view) {
        this.view = view;
    }

    @Override
    public void GoToDos(int userID) {
        Intent intent = new Intent(view.getActivity(), ToDoActivity.class);
        intent.putExtra("userID",userID);
        view.getActivity().startActivity(intent);
    }

    /*@Override
    public int GetTodosCount(int userID) {
        ToDoRepository repo = new ToDoRepository(view.getActivity());
        return repo.GetTudosUncheckbyUser(userID);
    }

    @Override
    public void GoToDos(int userID) {
        Intent intent = new Intent(view.getActivity(), ToDoActivity.class);
        intent.putExtra("userID",userID);
        view.getActivity().startActivity(intent);
    }*/
}
