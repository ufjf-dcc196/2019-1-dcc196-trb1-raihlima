package act.arquivos.trabalholab;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NovoPlanejamentoActivity extends AppCompatActivity {

    Button confirmar;
    EditText nomeAluno;
    EditText ano;
    EditText semestre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_planejamento);

        confirmar = (Button) findViewById(R.id.botaoConfirmarNovoPlanejamento);
        nomeAluno = (EditText) findViewById(R.id.edtTxtNomeAluno);
        ano = (EditText) findViewById(R.id.edtTxtAno);
        semestre = (EditText) findViewById(R.id.edtTxtSemestre);

        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();

                bundle.putString("nome",nomeAluno.getText().toString());
                bundle.putString("ano",ano.getText().toString());
                bundle.putString("semestre",semestre.getText().toString());

                Intent intent = new Intent();

                intent.putExtra("info",bundle);

                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }
}
