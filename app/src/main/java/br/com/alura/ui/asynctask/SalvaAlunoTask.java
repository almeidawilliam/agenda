package br.com.alura.ui.asynctask;

import android.os.AsyncTask;

import br.com.alura.database.dao.AlunoDAO;
import br.com.alura.database.dao.TelefoneDAO;
import br.com.alura.model.Aluno;
import br.com.alura.model.Telefone;

public class SalvaAlunoTask extends AsyncTask<Void, Void, Void> {

    private final AlunoDAO daoAluno;
    private final TelefoneDAO telefoneDAO;
    private final Aluno aluno;
    private final Telefone telefoneFixo;
    private final Telefone telefoneCelular;
    private QuandoAlunoSalvoListener listener;

    public SalvaAlunoTask(AlunoDAO daoAluno,
                          TelefoneDAO telefoneDAO,
                          Aluno aluno,
                          Telefone telefoneFixo,
                          Telefone telefoneCelular,
                          QuandoAlunoSalvoListener listener) {
        this.daoAluno = daoAluno;
        this.telefoneDAO = telefoneDAO;
        this.aluno = aluno;
        this.telefoneFixo = telefoneFixo;
        this.telefoneCelular = telefoneCelular;
        this.listener = listener;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        Long idAlunoSalvo = daoAluno.salva(aluno);
        vinculaAlunoComTelefone(idAlunoSalvo.intValue(), telefoneFixo, telefoneCelular);
        telefoneDAO.salva(telefoneFixo, telefoneCelular);

        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        listener.quandoSalvo();
    }

    private void vinculaAlunoComTelefone(int idAlunoSalvo, Telefone... telefones) {
        for (Telefone telefone : telefones) {
            telefone.setIdAluno(idAlunoSalvo);
        }
    }

    public interface QuandoAlunoSalvoListener {
        void quandoSalvo();
    }
}
