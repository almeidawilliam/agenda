package br.com.alura.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import br.com.alura.model.Aluno;

@Dao
public interface RoomAlunoDAO {

    @Insert
    void salva(Aluno aluno);

    @Query("SELECT * FROM ALUNO")
    List<Aluno> todos();

    @Delete
    void remove(int id);
}
