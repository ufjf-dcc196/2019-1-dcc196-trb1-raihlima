package act.arquivos.trabalholab;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class NovaDisciplinaCursadaActivity extends AppCompatActivity {

    private EditText nome;
    private EditText horas;
    private Button confirmar;

    private RadioButton exatas;
    private RadioButton saude;
    private RadioButton humanidades;
    private RadioButton linguas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_disciplina_cursada);

        setTitle("Novo Planejamento");

        nome = (EditText) findViewById(R.id.edtTxtNomeDisciplina);
        horas = (EditText) findViewById(R.id.edtTxtHorasDiciplina);
        confirmar = (Button) findViewById(R.id.buttonConfirmarNovaDisciplina);

        exatas = (RadioButton) findViewById(R.id.rbExatas);
        saude = (RadioButton) findViewById(R.id.rbSaude);
        humanidades = (RadioButton) findViewById(R.id.rbHumanidades);
        linguas = (RadioButton) findViewById(R.id.rbLinguas);

        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(verificaPreenchimento()) {
                    Bundle bundle = new Bundle();
                    bundle.putString("nome", nome.getText().toString());
                    bundle.putString("horas", horas.getText().toString());
                    bundle.putString("curso", verificaSelecao());

                    Intent intent = new Intent();

                    intent.putExtra("info", bundle);

                    setResult(Activity.RESULT_OK, intent);
                    finish();
                }
                else {
                    Toast.makeText(NovaDisciplinaCursadaActivity.this,"Preencha todos os campos!",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private boolean verificaPreenchimento(){
        if(nome.getText().toString().equals("")){
            return false;
        } else if(horas.getText().equals("")){
            return false;
        }
        return true;
    }

    private String verificaSelecao(){
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rgCursos);
        RadioButton radioButton = (RadioButton) radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
        return radioButton.getText().toString();
    }
}
