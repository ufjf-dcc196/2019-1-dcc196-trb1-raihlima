package act.arquivos.trabalholab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisciplinasCursadasActivity extends AppCompatActivity {

    private TextView nome;
    private TextView ano;
    private TextView semestre;
    private Button novaDisciplina;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disciplinas_cursadas);

        nome = (TextView) findViewById(R.id.txtNomeCusro);
        ano = (TextView) findViewById(R.id.txtAnoCurso);
        semestre = (TextView) findViewById(R.id.txtSemestreCurso);

        novaDisciplina = (Button) findViewById(R.id.botaoNovaDisciplinaDC);

        Bundle bundleInfo = getIntent().getBundleExtra("info");

        atualizaInfo(bundleInfo);

        novaDisciplina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DisciplinasCursadasActivity.this,NovaDisciplinaCursadaActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }

    private void atualizaInfo(Bundle bundle){
        nome.setText("Curso: " + (CharSequence)bundle.getString("nome"));
        ano.setText("Ano: " + (CharSequence)bundle.getString("ano"));
        semestre.setText("Semestre: " + (CharSequence)bundle.getString("semestre"));
    }
}
