package br.com.alura.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;

import br.com.alura.database.AgendaDatabase;
import br.com.alura.database.dao.AlunoDAO;
import br.com.alura.model.Aluno;
import br.com.alura.ui.activity.adapter.ListaAlunosAdapter;
import br.com.alura.ui.asynctask.BuscaAlunosTask;

public class ListaAlunosView {

    private final ListaAlunosAdapter adapter;
    private final AlunoDAO dao;
    private final Context context;

    public ListaAlunosView(Context context) {
        this.context = context;
        adapter = new ListaAlunosAdapter(this.context);
        this.dao = AgendaDatabase.getInstance(context).getAlunoDAO();
    }

    public void confirmaRemocao(@NonNull MenuItem item) {
        new AlertDialog.Builder(context)
                .setTitle("Removendo aluno")
                .setMessage("Tem certeza que deseja remover o aluno?")
                .setPositiveButton("Sim",
                        (dialogInterface, i) -> {
                            AdapterView.AdapterContextMenuInfo menuInfo =
                                    (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                            Aluno alunoEscolhido = adapter.getItem(menuInfo.position);
                            remove(alunoEscolhido);
                        })
                .setNegativeButton("Não", null)
                .show();
    }

    public void atualizaAlunos() {
        new BuscaAlunosTask(dao, adapter).execute();
    }

    private void remove(Aluno aluno) {
        dao.remove(aluno);
        adapter.remove(aluno);
    }

    public void configuraAdapter(ListView listaDeAlunos) {
        listaDeAlunos.setAdapter(adapter);
    }
}
