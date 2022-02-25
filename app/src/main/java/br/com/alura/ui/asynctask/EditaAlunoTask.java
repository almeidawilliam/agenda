package br.com.alura.ui.asynctask;

import java.util.List;

import br.com.alura.database.dao.AlunoDAO;
import br.com.alura.database.dao.TelefoneDAO;
import br.com.alura.model.Aluno;
import br.com.alura.model.Telefone;
import br.com.alura.model.TipoTelefone;

public class EditaAlunoTask extends BaseAlunoComTelefoneTask {

    private final AlunoDAO daoAluno;
    private final TelefoneDAO daoTelefone;
    private final Aluno aluno;
    private final Telefone telefoneFixo;
    private final Telefone telefoneCelular;
    private List<Telefone> telefonesDoAluno;

    public EditaAlunoTask(AlunoDAO daoAluno,
                          TelefoneDAO daoTelefone,
                          Aluno aluno,
                          Telefone telefoneFixo,
                          Telefone telefoneCelular, List<Telefone> telefonesDoAluno,
                          FinalizadaListener listener) {
        super(listener);
        this.daoAluno = daoAluno;
        this.daoTelefone = daoTelefone;
        this.aluno = aluno;
        this.telefoneFixo = telefoneFixo;
        this.telefoneCelular = telefoneCelular;
        this.telefonesDoAluno = telefonesDoAluno;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        daoAluno.edita(aluno);
        vinculaAlunoComTelefone(aluno.getId(), telefoneFixo, telefoneCelular);
        atualizaIdsDosTelefones(telefoneFixo, telefoneCelular);
        daoTelefone.atualiza(telefoneFixo, telefoneCelular);
        return null;
    }

    private void atualizaIdsDosTelefones(Telefone telefoneFixo, Telefone telefoneCelular) {
        for (Telefone telefone : telefonesDoAluno) {
            if (telefone.getTipo() == TipoTelefone.FIXO) {
                telefoneFixo.setId(telefone.getId());
            } else {
                telefoneCelular.setId(telefoneCelular.getId());
            }
        }
    }
}
