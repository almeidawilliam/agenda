package br.com.alura.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.model.Aluno;

public class AlunoDAO {

    private static final List<Aluno> alunos = new ArrayList<>();
    private static int contadorDeIds = 1;

    public void salva(Aluno aluno) {
        aluno.setId(contadorDeIds);
        alunos.add(aluno);
        atualizaIds();
    }

    private void atualizaIds() {
        contadorDeIds++;
    }

    public void edita(Aluno aluno) {
        for (Aluno a : todos()) {
            if (aluno.getId() == a.getId()) {
                int index = alunos.indexOf(a);
                alunos.set(index, aluno);
                break;
            }
        }
    }

    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }

    public void remove(int id) {
        for (Aluno aluno : alunos) {
            if (aluno.getId() == id) {
                alunos.remove(aluno);
                break;
            }
        }
    }
}
