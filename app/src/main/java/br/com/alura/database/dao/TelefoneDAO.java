package br.com.alura.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import br.com.alura.model.Telefone;

@Dao
public interface TelefoneDAO {

    @Query("SELECT * FROM Telefone t " +
            "WHERE t.idAluno = :idAluno " +
            "LIMIT 1")
    Telefone buscaPrimeiroTelefoneDoAluno(int idAluno);

    @Insert
    void salva(Telefone... telefones);

    @Query("SELECT * FROM Telefone t " +
            "WHERE t.idAluno = :idAluno ")
    List<Telefone> buscaTodosTelefonesDoAluno(int idAluno);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void atualiza(Telefone... telefones);
}
