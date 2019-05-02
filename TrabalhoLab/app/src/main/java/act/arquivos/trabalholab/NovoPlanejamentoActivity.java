package act.arquivos.trabalholab;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NovoPlanejamentoActivity extends AppCompatActivity {

    private Button confirmar;
    private EditText nomeAluno;
    private EditText ano;
    private EditText semestre;
    private EditText exatasHoras;
    private EditText humanidadesHoras;
    private EditText saudeHoras;
    private EditText linguasHoras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_planejamento);

        setTitle("Novo Planejamento");

        confirmar = (Button) findViewById(R.id.botaoConfirmarNovoPlanejamento);
        nomeAluno = (EditText) findViewById(R.id.edtTxtNomeAluno);
        ano = (EditText) findViewById(R.id.edtTxtAno);
        semestre = (EditText) findViewById(R.id.edtTxtSemestre);
        exatasHoras = (EditText) findViewById(R.id.edtTxtExatasHoras);
        humanidadesHoras = (EditText) findViewById(R.id.edtTxtHumanidadesHoras);
        saudeHoras = (EditText) findViewById(R.id.edtTxtSaudeHoras);
        linguasHoras = (EditText) findViewById(R.id.edtTxtLinguasHoras);

        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (verificaPreenchimento()) {
                    float total = Integer.parseInt(exatasHoras.getText().toString())+
                            Integer.parseInt(humanidadesHoras.getText().toString()) +
                            Integer.parseInt(saudeHoras.getText().toString()) +
                            Integer.parseInt(linguasHoras.getText().toString());
                    Bundle bundle = new Bundle();

                    int exatasP = (int)((Float.parseFloat(exatasHoras.getText().toString())/total)*(100));
                    int humanidadesP = (int)((Float.parseFloat(humanidadesHoras.getText().toString())/total)*(100));
                    int saudeP = (int)((Float.parseFloat(saudeHoras.getText().toString())/total)*(100));
                    int linguasP= (int)((Float.parseFloat(linguasHoras.getText().toString())/total)*(100));

                    bundle.putString("nome", nomeAluno.getText().toString());
                    bundle.putString("ano", ano.getText().toString());
                    bundle.putString("semestre", semestre.getText().toString());
                    bundle.putInt("exatasHoras", Integer.parseInt(exatasHoras.getText().toString()));
                    bundle.putInt("exatasPorcentagem", exatasP);
                    bundle.putInt("humanidadesHoras", Integer.parseInt(humanidadesHoras.getText().toString()));
                    bundle.putInt("humanidadesPorcentagem", humanidadesP);
                    bundle.putInt("saudeHoras", Integer.parseInt(saudeHoras.getText().toString()));
                    bundle.putInt("saudePorcentagem", saudeP);
                    bundle.putInt("linguasHoras", Integer.parseInt(linguasHoras.getText().toString()));
                    bundle.putInt("linguasPorcentagem", linguasP);

                    Intent intent = new Intent();

                    intent.putExtra("info", bundle);

                    setResult(Activity.RESULT_OK, intent);
                    finish();
                } else {
                    Toast.makeText(NovoPlanejamentoActivity.this, "Preencha todos os dados!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private int calculaPorcentagem(int total, int valor){
        return total/valor;
    }

    private boolean verificaPreenchimento(){
        if(nomeAluno.getText().toString().equals("")){
            return false;
        } else if(ano.getText().toString().equals("")){
            return false;
        } else if(semestre.getText().toString().equals("")){
            return false;
        } else if(exatasHoras.getText().toString().equals("")){
            return false;
        }  else if(humanidadesHoras.getText().toString().equals("")){
            return false;
        }  else if(saudeHoras.getText().toString().equals("")){
            return false;
        } else if(linguasHoras.getText().toString().equals("")){
            return false;
        }
        return true;
    }
}
