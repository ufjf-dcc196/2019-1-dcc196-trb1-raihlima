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
    private EditText exatasPorcentagem;
    private EditText humanidadesHoras;
    private EditText humanidadesPorcentagem;
    private EditText saudeHoras;
    private EditText saudePorcentagem;
    private EditText linguasHoras;
    private EditText linguasPorcentagem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_planejamento);

        confirmar = (Button) findViewById(R.id.botaoConfirmarNovoPlanejamento);
        nomeAluno = (EditText) findViewById(R.id.edtTxtNomeAluno);
        ano = (EditText) findViewById(R.id.edtTxtAno);
        semestre = (EditText) findViewById(R.id.edtTxtSemestre);
        exatasHoras = (EditText) findViewById(R.id.edtTxtExatasHoras);
        exatasPorcentagem = (EditText) findViewById(R.id.edtTxtExatasHorasPorcentagem);
        humanidadesHoras = (EditText) findViewById(R.id.edtTxtHumanidadesHoras);
        humanidadesPorcentagem = (EditText) findViewById(R.id.edtTxtHumanidadesHorasPorcentagem);
        saudeHoras = (EditText) findViewById(R.id.edtTxtSaudeHoras);
        saudePorcentagem = (EditText) findViewById(R.id.edtTxtSaudeHorasPorcentagem);
        linguasHoras = (EditText) findViewById(R.id.edtTxtLinguasHoras);
        linguasPorcentagem = (EditText) findViewById(R.id.edtTxtLinguasHorasPorcentagem);

        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (verificaPreenchimento()) {
                    Bundle bundle = new Bundle();

                    bundle.putString("nome", nomeAluno.getText().toString());
                    bundle.putString("ano", ano.getText().toString());
                    bundle.putString("semestre", semestre.getText().toString());
                    bundle.putInt("exatasHoras", Integer.parseInt(exatasHoras.getText().toString()));
                    bundle.putInt("exatasPorcentagem", Integer.parseInt(exatasPorcentagem.getText().toString()));
                    bundle.putInt("humanidadesHoras", Integer.parseInt(humanidadesHoras.getText().toString()));
                    bundle.putInt("humanidadesPorcentagem", Integer.parseInt(humanidadesPorcentagem.getText().toString()));
                    bundle.putInt("saudeHoras", Integer.parseInt(saudeHoras.getText().toString()));
                    bundle.putInt("saudePorcentagem", Integer.parseInt(saudePorcentagem.getText().toString()));
                    bundle.putInt("linguasHoras", Integer.parseInt(linguasHoras.getText().toString()));
                    bundle.putInt("linguasPorcentagem", Integer.parseInt(linguasPorcentagem.getText().toString()));

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

    private boolean verificaPreenchimento(){
        if(nomeAluno.getText().toString().equals("")){
            return false;
        } else if(ano.getText().toString().equals("")){
            return false;
        } else if(semestre.getText().toString().equals("")){
            return false;
        } else if(exatasHoras.getText().toString().equals("")){
            return false;
        } else if(exatasPorcentagem.getText().toString().equals("")){
            return false;
        } else if(humanidadesHoras.getText().toString().equals("")){
            return false;
        } else if(humanidadesPorcentagem.getText().toString().equals("")){
            return false;
        } else if(saudeHoras.getText().toString().equals("")){
            return false;
        } else if(saudePorcentagem.getText().toString().equals("")){
            return false;
        } else if(linguasHoras.getText().toString().equals("")){
            return false;
        } else if(linguasPorcentagem.getText().toString().equals("")){
            return false;
        }
        return true;
    }
}
