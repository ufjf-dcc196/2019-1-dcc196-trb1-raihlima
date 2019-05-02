package act.arquivos.trabalholab;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import act.arquivos.trabalholab.Adapter.CursoAdapter;
import act.arquivos.trabalholab.Dados.Aluno;

public class PlanejamentosActivity extends AppCompatActivity {

    private Button novoPlanejamento;
    private Aluno aluno;

    private TextView nome;
    private TextView ano;
    private TextView semestre;

    private CursoAdapter cursoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        aluno = new Aluno();
        novoPlanejamento = (Button) findViewById(R.id.botaoNovoPlanejamento);
        nome = (TextView) findViewById(R.id.txtAluno);
        ano = (TextView) findViewById(R.id.txtAno);
        semestre = (TextView) findViewById(R.id.txtSemestre);

        atualizarLista();

        novoPlanejamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanejamentosActivity.this,NovoPlanejamentoActivity.class);
                startActivityForResult(intent,1);
            }
        });

        cursoAdapter.setOnCursoClickListener(new CursoAdapter.OnCursoClickListener() {
            @Override
            public void onCursoClick(View v, int position) {
                if(position==0){
                    Toast.makeText(PlanejamentosActivity.this, "Teste Linguas", Toast.LENGTH_SHORT).show();

                } else if (position==1){
                    Toast.makeText(PlanejamentosActivity.this, "Teste Exatas", Toast.LENGTH_SHORT).show();

                } else if (position==2){
                    Toast.makeText(PlanejamentosActivity.this, "Teste Saúde", Toast.LENGTH_SHORT).show();

                } else if( position==3){
                    Toast.makeText(PlanejamentosActivity.this, "Teste Humanidades", Toast.LENGTH_SHORT).show();

                }
          }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK){
            if(requestCode==1){
                Bundle bundle = data.getBundleExtra("info");
                criarNovoAluno(bundle);
                alterarInfo();
            }
        }
    }

    private void criarNovoAluno(Bundle bundle){
        aluno = new Aluno(bundle.getString("nome"),bundle.getString("ano"),bundle.getString("semestre"));
        aluno.getExatas().setHoras(bundle.getInt("exatasHoras"));
        aluno.getExatas().setHorasPorcentagem(bundle.getInt("exatasPorcentagem"));
        aluno.getHumanidades().setHoras(bundle.getInt("humanidadesHoras"));
        aluno.getHumanidades().setHorasPorcentagem(bundle.getInt("humanidadesPorcentagem"));
        aluno.getSaude().setHoras(bundle.getInt("saudeHoras"));
        aluno.getSaude().setHorasPorcentagem(bundle.getInt("saudePorcentagem"));
        aluno.getLinguas().setHoras(bundle.getInt("linguasHoras"));
        aluno.getLinguas().setHorasPorcentagem(bundle.getInt("linguasPorcentagem"));
        //Toast.makeText(PlanejamentosActivity.this, Integer.toString(aluno.getExatas().getHoras()), Toast.LENGTH_SHORT).show();
    }

    private void alterarInfo(){
        nome.setText("Nome: " + (CharSequence)aluno.getNome());
        ano.setText("Ano: "+(CharSequence)aluno.getAno());
        semestre.setText("Semestre: "+ (CharSequence)aluno.getSemestre());

    }

    private void atualizarLista(){
        RecyclerView rv = findViewById(R.id.rvCursos);
        cursoAdapter = new CursoAdapter(aluno);
        rv.setAdapter(cursoAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }

}
