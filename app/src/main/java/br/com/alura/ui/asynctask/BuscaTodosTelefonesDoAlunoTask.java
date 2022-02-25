package br.com.alura.ui.asynctask;

import android.os.AsyncTask;

import java.util.List;

import br.com.alura.database.dao.TelefoneDAO;
import br.com.alura.model.Aluno;
import br.com.alura.model.Telefone;

public class BuscaTodosTelefonesDoAlunoTask extends AsyncTask<Void, Void, List<Telefone>> {


    private final TelefoneDAO daoTelefone;
    private final Aluno aluno;
    private TelefonesDoAlunoEncontradoListener listener;

    public BuscaTodosTelefonesDoAlunoTask(TelefoneDAO daoTelefone,
                                          Aluno aluno,
                                          TelefonesDoAlunoEncontradoListener listener) {
        this.daoTelefone = daoTelefone;
        this.aluno = aluno;
        this.listener = listener;
    }

    @Override
    protected List<Telefone> doInBackground(Void... voids) {
        return daoTelefone.buscaTodosTelefonesDoAluno(aluno.getId());
    }


    @Override
    protected void onPostExecute(List<Telefone> telefones) {
        super.onPostExecute(telefones);
        listener.quandoEncontrado(telefones);
    }

    public interface TelefonesDoAlunoEncontradoListener {
        void quandoEncontrado(List<Telefone> telefones);
    }
}
