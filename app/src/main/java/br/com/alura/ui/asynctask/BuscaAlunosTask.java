package br.com.alura.ui.asynctask;

import android.os.AsyncTask;

import br.com.alura.database.dao.AlunoDAO;
import br.com.alura.ui.activity.adapter.ListaAlunosAdapter;

public class BuscaAlunosTask extends AsyncTask {

    private final AlunoDAO dao;
    private final ListaAlunosAdapter adapter;

    public BuscaAlunosTask(AlunoDAO dao, ListaAlunosAdapter adapter) {
        this.dao = dao;
        this.adapter = adapter;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        adapter.atualiza(dao.todos());
        return null;
    }
}
