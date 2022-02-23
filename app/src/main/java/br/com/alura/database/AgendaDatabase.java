package br.com.alura.database;

import static br.com.alura.database.AgendaMigrations.TODAS_MIGRATIONS;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import br.com.alura.database.converter.ConversorCalendar;
import br.com.alura.database.dao.AlunoDAO;
import br.com.alura.model.Aluno;

@Database(
        entities = {Aluno.class},
        version = 4,
        exportSchema = false
)
@TypeConverters({ConversorCalendar.class})
public abstract class AgendaDatabase extends RoomDatabase {

    private static final String NOME_BANCO_DE_DADOS = "agenda.db";


    public abstract AlunoDAO getRoomAlunoDAO();

    public static AgendaDatabase getInstance(Context context) {
        return Room
                .databaseBuilder(context, AgendaDatabase.class, NOME_BANCO_DE_DADOS)
                .allowMainThreadQueries()
//                .fallbackToDestructiveMigration()
                .addMigrations(TODAS_MIGRATIONS)
                .build();
    }
}
