package br.com.alura.ui.asynctask;

import android.os.AsyncTask;
import android.widget.TextView;

import br.com.alura.database.dao.TelefoneDAO;
import br.com.alura.model.Telefone;

public class BuscaPrimeiroTelefoneDoAlunoTask extends AsyncTask<Void, Void, Telefone> {

    private final TelefoneDAO telefoneDAO;
    private final TextView telefoneView;
    private final int idAluno;

    public BuscaPrimeiroTelefoneDoAlunoTask(TelefoneDAO telefoneDAO, TextView telefone, int idAluno) {
        this.telefoneDAO = telefoneDAO;
        this.telefoneView = telefone;
        this.idAluno = idAluno;
    }

    @Override
    protected Telefone doInBackground(Void... voids) {
        return telefoneDAO.buscaPrimeiroTelefoneDoAluno(idAluno);
    }

    @Override
    protected void onPostExecute(Telefone primeiroTelefone) {
        super.onPostExecute(primeiroTelefone);
        if (primeiroTelefone != null) {
            telefoneView.setText(primeiroTelefone.getNumero());
        }
    }
}
