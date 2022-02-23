package br.com.alura.database.dao;

import androidx.room.Dao;
import androidx.room.Query;

import br.com.alura.model.Telefone;

@Dao
public interface TelefoneDAO {

    @Query("SELECT ")
    Telefone buscaPrimeiroTelefoneDoAluno();
}
