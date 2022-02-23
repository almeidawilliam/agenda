package br.com.alura.database.dao;

import androidx.room.Dao;
import androidx.room.Query;

import br.com.alura.model.Telefone;

@Dao
public interface TelefoneDAO {

    @Query("SELECT t.* FROM Telefone t " +
            "JOIN Aluno a " +
            "ON t.idAluno = a.id " +
            "WHERE t.idAluno = :idAluno " +
            "LIMIT 1")
    Telefone buscaPrimeiroTelefoneDoAluno(int idAluno);
}
