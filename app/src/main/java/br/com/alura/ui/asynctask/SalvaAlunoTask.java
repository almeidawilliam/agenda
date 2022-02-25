package br.com.alura.ui.asynctask;

import br.com.alura.database.dao.AlunoDAO;
import br.com.alura.database.dao.TelefoneDAO;
import br.com.alura.model.Aluno;
import br.com.alura.model.Telefone;

public class SalvaAlunoTask extends BaseAlunoComTelefoneTask {

    private final AlunoDAO daoAluno;
    private final TelefoneDAO telefoneDAO;
    private final Aluno aluno;
    private final Telefone telefoneFixo;
    private final Telefone telefoneCelular;

    public SalvaAlunoTask(AlunoDAO daoAluno,
                          TelefoneDAO telefoneDAO,
                          Aluno aluno,
                          Telefone telefoneFixo,
                          Telefone telefoneCelular,
                          FinalizadaListener listener) {
        super(listener);
        this.daoAluno = daoAluno;
        this.telefoneDAO = telefoneDAO;
        this.aluno = aluno;
        this.telefoneFixo = telefoneFixo;
        this.telefoneCelular = telefoneCelular;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        Long idAlunoSalvo = daoAluno.salva(aluno);
        vinculaAlunoComTelefone(idAlunoSalvo.intValue(), telefoneFixo, telefoneCelular);
        telefoneDAO.salva(telefoneFixo, telefoneCelular);
        return null;
    }
}
