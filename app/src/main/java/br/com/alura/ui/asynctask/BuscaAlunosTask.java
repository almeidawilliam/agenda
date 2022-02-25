package br.com.alura.ui.asynctask;

import android.os.AsyncTask;

import java.util.List;

import br.com.alura.database.dao.AlunoDAO;
import br.com.alura.model.Aluno;
import br.com.alura.ui.activity.adapter.ListaAlunosAdapter;

public class BuscaAlunosTask extends AsyncTask<Void, Void, List<Aluno>> {

    private final AlunoDAO dao;
    private final ListaAlunosAdapter adapter;

    public BuscaAlunosTask(AlunoDAO dao, ListaAlunosAdapter adapter) {
        this.dao = dao;
        this.adapter = adapter;
    }

    @Override
    protected List<Aluno> doInBackground(Void[] objects) {
        return dao.todos();
    }

    @Override
    protected void onPostExecute(List<Aluno> alunos) {
        super.onPostExecute(alunos);
        adapter.atualiza((List<Aluno>) alunos);
    }
}
