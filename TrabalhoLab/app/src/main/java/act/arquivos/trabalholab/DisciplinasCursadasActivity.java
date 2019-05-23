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

import act.arquivos.trabalholab.Adapter.DisciplinaAdapter;
import act.arquivos.trabalholab.Dados.Curso;
import act.arquivos.trabalholab.Dados.Disciplina;
import act.arquivos.trabalholab.Dados.Periodo;

public class DisciplinasCursadasActivity extends AppCompatActivity {

    private TextView tempo;
    private TextView ano;
    private TextView semestre;
    private Button novaDisciplina;
    private Periodo periodo = new Periodo();

    private DisciplinaAdapter disciplinaAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disciplinas_cursadas);

        setTitle("Disciplinas Cursadas");

        ano = (TextView) findViewById(R.id.anoTxtDisciplinasCursadas);
        semestre = (TextView) findViewById(R.id.semestreTxtDisciplinasCursadas);
        tempo = (TextView) findViewById(R.id.tempoTxtDisciplinasCursadas);

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
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == 10) {
                Bundle bundle = data.getBundleExtra("info");
                atualizaLista(bundle);
            }
        }
    }

    private void atualizaInfo(Bundle bundle){
        tempo.setText("Tempo: " + bundle.getInt("Tempo")+ "h");
        ano.setText("Ano: " + bundle.getInt("Ano"));
        semestre.setText("Semestre: " + bundle.getInt("Semestre"));

        periodo.setAno(bundle.getInt("Ano"));
        periodo.setSemestre(bundle.getInt("Semestre"));


        //curso.addDisciplinas(new Disciplina("Teste","10","Exatas"));

    }

    private void atualizaLista(Bundle bundle){
        Disciplina disciplina = new Disciplina();
        disciplina.setNome(bundle.getString("nome"));
        disciplina.setHoras(Integer.parseInt(bundle.getString("horas")));
        disciplina.setCurso(bundle.getString("curso"));

        if(bundle.getString("curso").equals("Exatas")){
            periodo.getExatas().addDisciplinas(disciplina);
        } else if(bundle.getString("curso").equals("Línguas")){
            periodo.getLinguas().addDisciplinas(disciplina);
        } else if(bundle.getString("curso").equals("Humanidades")){
            periodo.getHumanidades().addDisciplinas(disciplina);
        } else if(bundle.getString("curso").equals("Saúde")){
            periodo.getSaude().addDisciplinas(disciplina);
        }
    //periodo.addDisciplinas(disciplina);
        atualizaRecyclerView();
    }

    private void atualizaRecyclerView(){
        RecyclerView rv = findViewById(R.id.rvDisciplinas);
        disciplinaAdapter = new DisciplinaAdapter(periodo);
        disciplinaAdapter.notifyDataSetChanged();
        rv.setAdapter(disciplinaAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
}
