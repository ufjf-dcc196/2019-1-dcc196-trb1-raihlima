package act.arquivos.trabalholab;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import act.arquivos.trabalholab.Dados.Aluno;

public class PlanejamentosActivity extends AppCompatActivity {

    Button novoPlanejamento;
    private Aluno aluno;

    TextView nome;
    TextView ano;
    TextView semestre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aluno = new Aluno();
        novoPlanejamento = (Button) findViewById(R.id.botaoNovoPlanejamento);
        nome = (TextView) findViewById(R.id.txtAluno);
        ano = (TextView) findViewById(R.id.txtAno);
        semestre = (TextView) findViewById(R.id.txtSemestre);



        novoPlanejamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanejamentosActivity.this,NovoPlanejamentoActivity.class);
                startActivityForResult(intent,1);
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
    }

    private void alterarInfo(){
        nome.setText("Nome: " + (CharSequence)aluno.getNome());
        ano.setText("Ano: "+(CharSequence)aluno.getAno());
        semestre.setText("Semestre: "+ (CharSequence)aluno.getSemestre());
    }

}
