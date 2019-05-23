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
import act.arquivos.trabalholab.Adapter.PeriodoAdapter;
import act.arquivos.trabalholab.Dados.Aluno;
import act.arquivos.trabalholab.Dados.Periodo;

public class PlanejamentosActivity extends AppCompatActivity {

    public static final int NOVOPLANEJAMENTO = 1;
    public static final int DISCIPLINASCURSADAS = 2;
    private Button novoPlanejamento;
    private Aluno aluno;

    private TextView nome;
    private TextView ano;
    private TextView semestre;

    private PeriodoAdapter periodoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Planejamento");


        aluno = new Aluno();
        novoPlanejamento = (Button) findViewById(R.id.botaoNovoPlanejamento);
        nome = (TextView) findViewById(R.id.txtAluno);

        RecyclerView rv = findViewById(R.id.rvPeriodo);
        periodoAdapter = new PeriodoAdapter(aluno);
        rv.setAdapter(periodoAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

       // atualizarLista();

        novoPlanejamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanejamentosActivity.this,NovoPlanejamentoActivity.class);
                startActivityForResult(intent,NOVOPLANEJAMENTO);
            }
        });



        periodoAdapter.setOnPeriodoClickListener(new PeriodoAdapter.OnPeriodoClickListener() {
            @Override
            public void onPeriodoClick(View v, int position) {
                Toast.makeText(PlanejamentosActivity.this,Integer.toString(position), Toast.LENGTH_SHORT).show();
                Periodo p = aluno.getListaPeriodos().get(position);
                Intent intent = new Intent(PlanejamentosActivity.this,DisciplinasCursadasActivity.class);
                Bundle bundle = new Bundle();
                System.out.println(p.getAno()+p.getSemestre());
                bundle.putInt("Semestre",p.getSemestre());
                bundle.putInt("Ano", p.getAno());
                bundle.putInt("Tempo", p.getTotalHoras());
                intent.putExtra("info", bundle);
                startActivityForResult(intent,DISCIPLINASCURSADAS);

                //Intent intent = new Intent(PlanejamentosActivity.this,DisciplinasCursadasActivity.class);
                //startActivityForResult(intent,2);
                /*
                if(position==0){
                    Intent intent = new Intent(PlanejamentosActivity.this,DisciplinasCursadasActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("nome","Línguas");
                    bundle.putString("ano", aluno.getAno());
                    bundle.putString("semestre",aluno.getSemestre());
                    intent.putExtra("info", bundle);

                    startActivityForResult(intent,2);

                } else if (position==1){
                    Intent intent = new Intent(PlanejamentosActivity.this,DisciplinasCursadasActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("nome","Exatas");
                    bundle.putString("ano", aluno.getAno());
                    bundle.putString("semestre",aluno.getSemestre());
                    intent.putExtra("info", bundle);

                    startActivityForResult(intent,3);

                } else if (position==2){
                    Intent intent = new Intent(PlanejamentosActivity.this,DisciplinasCursadasActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("nome","Saúde");
                    bundle.putString("ano", aluno.getAno());
                    bundle.putString("semestre",aluno.getSemestre());
                    intent.putExtra("info", bundle);

                    startActivityForResult(intent,4);

                } else if( position==3){
                    Intent intent = new Intent(PlanejamentosActivity.this,DisciplinasCursadasActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("nome","Humanidades");
                    bundle.putString("ano", aluno.getAno());
                    bundle.putString("semestre",aluno.getSemestre());
                    intent.putExtra("info", bundle);

                    startActivityForResult(intent,5);

                }
                */
          }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK){
            if(requestCode== NOVOPLANEJAMENTO){
                Bundle bundle = data.getBundleExtra("info");
                criarNovoAluno(bundle);
                alterarInfo();
            }
        }
    }

    private void criarNovoAluno(Bundle bundle){
        Periodo p = new Periodo();
        p.setAno(Integer.parseInt(bundle.getString("ano")));
        p.setSemestre(Integer.parseInt(bundle.getString("semestre")));
        p.getExatas().setHoras(bundle.getInt("exatasHoras"));
        p.getExatas().setHorasPorcentagem(bundle.getInt("exatasPorcentagem"));
        p.getSaude().setHoras(bundle.getInt("saudeHoras"));
        p.getSaude().setHorasPorcentagem(bundle.getInt("saudePorcentagem"));
        p.getLinguas().setHoras(bundle.getInt("linguasHoras"));
        p.getLinguas().setHorasPorcentagem(bundle.getInt("linguasPorcentagem"));
        p.getHumanidades().setHoras(bundle.getInt("humanidadesHoras"));
        p.getHumanidades().setHorasPorcentagem(bundle.getInt("humanidadesPorcentagem"));

        aluno.addPeriodo(p);
        aluno.setNome(bundle.getString("nome"));
        //Toast.makeText(PlanejamentosActivity.this, Integer.toString(aluno.getExatas().getHoras()), Toast.LENGTH_SHORT).show();
    }

    private void alterarInfo(){
        nome.setText("Nome: " + (CharSequence)aluno.getNome());
        atualizarLista();
    }

    private void atualizarLista(){
        RecyclerView rv = findViewById(R.id.rvPeriodo);
        periodoAdapter.alteraDados(aluno);
        periodoAdapter.notifyDataSetChanged();


    }

}
