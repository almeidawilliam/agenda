package br.com.alura;

import android.app.Application;

import br.com.alura.dao.AlunoDAO;
import br.com.alura.model.Aluno;

public class AgendaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        criaAlunosDeTeste();
    }

    private void criaAlunosDeTeste() {
        AlunoDAO dao = new AlunoDAO();
        dao.salva(new Aluno("William", "15981476877", "almeida.ws@hotmail.com"));
//        dao.salva(new Aluno("Nicole", "15981264150", "nicolecatarina@gmail.com"));
    }
}
