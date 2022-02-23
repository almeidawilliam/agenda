package br.com.alura;

import android.app.Application;

import androidx.room.Room;

import br.com.alura.database.AgendaDatabase;
import br.com.alura.database.dao.RoomAlunoDAO;
import br.com.alura.model.Aluno;

public class AgendaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        criaAlunosDeTeste();
    }

    private void criaAlunosDeTeste() {
        AgendaDatabase database = Room
                .databaseBuilder(this, AgendaDatabase.class, "agenda.db")
                .allowMainThreadQueries()
                .build();
        RoomAlunoDAO dao = database.getRoomAlunoDAO();
        dao.salva(new Aluno("William", "15981476877", "almeida.ws@hotmail.com"));
//        dao.salva(new Aluno("Nicole", "15981264150", "nicolecatarina@gmail.com"));
    }
}
