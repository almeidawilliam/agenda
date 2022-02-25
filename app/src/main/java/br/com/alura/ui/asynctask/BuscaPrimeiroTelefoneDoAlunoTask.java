package br.com.alura.ui.asynctask;

import android.os.AsyncTask;
import android.widget.TextView;

import br.com.alura.database.dao.TelefoneDAO;
import br.com.alura.model.Telefone;

public class BuscaPrimeiroTelefoneDoAlunoTask extends AsyncTask<Void, Void, Telefone> {

    private final TelefoneDAO telefoneDAO;
    private final int idAluno;
    private final PrimeiroTelefoneEncontradoListener listener;

    public BuscaPrimeiroTelefoneDoAlunoTask(TelefoneDAO telefoneDAO,
                                            int idAluno,
                                            PrimeiroTelefoneEncontradoListener listener) {
        this.telefoneDAO = telefoneDAO;
        this.idAluno = idAluno;
        this.listener = listener;
    }

    @Override
    protected Telefone doInBackground(Void... voids) {
        return telefoneDAO.buscaPrimeiroTelefoneDoAluno(idAluno);
    }

    @Override
    protected void onPostExecute(Telefone primeiroTelefone) {
        super.onPostExecute(primeiroTelefone);
        if (primeiroTelefone != null) {
            listener.quandoEncontrado(primeiroTelefone);
        }
    }

    public interface PrimeiroTelefoneEncontradoListener {
        void quandoEncontrado(Telefone telefoneEncontrado);
    }
}
