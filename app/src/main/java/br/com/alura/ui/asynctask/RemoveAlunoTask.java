package br.com.alura.ui.asynctask;

import android.os.AsyncTask;

import br.com.alura.database.dao.AlunoDAO;
import br.com.alura.model.Aluno;
import br.com.alura.ui.activity.adapter.ListaAlunosAdapter;

public class RemoveAlunoTask extends AsyncTask<Void, Void, Void> {

    private final AlunoDAO dao;
    private final ListaAlunosAdapter adapter;
    private final Aluno aluno;

    public RemoveAlunoTask(AlunoDAO dao, ListaAlunosAdapter adapter, Aluno aluno) {
        this.dao = dao;
        this.adapter = adapter;
        this.aluno = aluno;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        dao.remove(aluno);
        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        adapter.remove(aluno);
        super.onPostExecute(unused);
    }
}
