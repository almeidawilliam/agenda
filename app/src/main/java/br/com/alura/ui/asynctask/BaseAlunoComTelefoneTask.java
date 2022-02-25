package br.com.alura.ui.asynctask;

import android.os.AsyncTask;

import br.com.alura.model.Telefone;

public abstract class BaseAlunoComTelefoneTask extends AsyncTask<Void, Void, Void> {

    protected final FinalizadaListener listener;

    protected BaseAlunoComTelefoneTask(FinalizadaListener listener) {
        this.listener = listener;
    }

    protected void vinculaAlunoComTelefone(int idAlunoSalvo, Telefone... telefones) {
        for (Telefone telefone : telefones) {
            telefone.setIdAluno(idAlunoSalvo);
        }
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        listener.quandoFinalizada();
    }

    public interface FinalizadaListener {
        void quandoFinalizada();
    }
}
