package br.com.alura.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import br.com.alura.database.dao.RoomAlunoDAO;
import br.com.alura.model.Aluno;

@Database(
        entities = {Aluno.class},
        version = 1,
        exportSchema = false
)
public abstract class AgendaDatabase extends RoomDatabase {

    public abstract RoomAlunoDAO getRoomAlunoDAO();
}
