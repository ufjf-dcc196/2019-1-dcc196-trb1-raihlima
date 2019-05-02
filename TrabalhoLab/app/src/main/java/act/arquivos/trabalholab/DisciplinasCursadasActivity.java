package act.arquivos.trabalholab;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import act.arquivos.trabalholab.Adapter.CursoAdapter;
import act.arquivos.trabalholab.Adapter.DisciplinaAdapter;
import act.arquivos.trabalholab.Dados.Curso;
import act.arquivos.trabalholab.Dados.Disciplina;

public class DisciplinasCursadasActivity extends AppCompatActivity {

    private TextView nome;
    private TextView ano;
    private TextView semestre;
    private Button novaDisciplina;
    private Curso curso = new Curso();

    private DisciplinaAdapter disciplinaAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disciplinas_cursadas);

        setTitle("Disciplinas Cursadas");

        nome = (TextView) findViewById(R.id.txtNomeCusro);
        ano = (TextView) findViewById(R.id.txtAnoCurso);
        semestre = (TextView) findViewById(R.id.txtSemestreCurso);

        novaDisciplina = (Button) findViewById(R.id.botaoNovaDisciplinaDC);

        Bundle bundleInfo = getIntent().getBundleExtra("info");

        atualizaInfo(bundleInfo);

        atualizaRecyclerView();


        novaDisciplina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DisciplinasCursadasActivity.this,NovaDisciplinaCursadaActivity.class);
                startActivityForResult(intent,10);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK){
            if(requestCode==10){
                Bundle bundle = data.getBundleExtra("info");
                atualizaLista(bundle);
            }
        }
    }

    private void atualizaInfo(Bundle bundle){
        nome.setText("Curso: " + (CharSequence)bundle.getString("nome"));
        ano.setText("Ano: " + (CharSequence)bundle.getString("ano"));
        semestre.setText("Semestre: " + (CharSequence)bundle.getString("semestre"));

        curso.setNome(bundle.getString("nome"));
        curso.setHoras(bundle.getInt("horas"));
        curso.setHorasPorcentagem(bundle.getInt("horasPorcentagem"));

        //curso.addDisciplinas(new Disciplina("Teste","10","Exatas"));

    }

    private void atualizaLista(Bundle bundle){
        Disciplina disciplina = new Disciplina();
        disciplina.setNome(bundle.getString("nome"));
        disciplina.setHoras(bundle.getString("horas"));
        disciplina.setCurso(bundle.getString("curso"));

        curso.addDisciplinas(disciplina);
        atualizaRecyclerView();
    }

    private void atualizaRecyclerView(){
        RecyclerView rv = findViewById(R.id.rvDisciplinas);
        disciplinaAdapter = new DisciplinaAdapter(curso);
        disciplinaAdapter.notifyDataSetChanged();
        rv.setAdapter(disciplinaAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
}
