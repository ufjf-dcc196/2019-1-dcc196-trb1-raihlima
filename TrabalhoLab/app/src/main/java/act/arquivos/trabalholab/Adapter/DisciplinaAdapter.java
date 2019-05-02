package act.arquivos.trabalholab.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import act.arquivos.trabalholab.Dados.Curso;
import act.arquivos.trabalholab.Dados.Aluno;
import act.arquivos.trabalholab.Dados.Disciplina;
import act.arquivos.trabalholab.PlanejamentosActivity;
import act.arquivos.trabalholab.R;

public class DisciplinaAdapter extends RecyclerView.Adapter<DisciplinaAdapter.ViewHolder> {

    private List <Disciplina> listaDisciplinas = new ArrayList<>();
    private OnDisciplinaClickListener listener;

    public DisciplinaAdapter(Curso curso) {
        for(int i=0;i<curso.getDisciplinas().size();i++){
            this.listaDisciplinas.add(curso.getDisciplinas().get(i));
        }

    }

    public void setOnDisciplinaClickListener(OnDisciplinaClickListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public DisciplinaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View linha = inflater.inflate(R.layout.lista_disciplinas_layout, viewGroup, false);
        ViewHolder vh = new ViewHolder(linha);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull DisciplinaAdapter.ViewHolder viewHolder, int i) {
        String nome = this.listaDisciplinas.get(i).getNome();
        String hora  = this.listaDisciplinas.get(i).getHoras()+"h";
        String curso = this.listaDisciplinas.get(i).getCurso();

        viewHolder.txtNome.setText(nome);
        viewHolder.txtHoras.setText(hora);
        viewHolder.txtCurso.setText(curso);
    }

    @Override
    public int getItemCount() {
        return this.listaDisciplinas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtNome;
        TextView txtHoras;
        TextView txtCurso;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNome = (TextView) itemView.findViewById(R.id.txtNomeDisciplinaLD);
            txtHoras = (TextView) itemView.findViewById(R.id.txtHorasLD);
            txtCurso = (TextView) itemView.findViewById(R.id.txtCursoLD);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(listener!=null){
                        listener.onCursoClick(v, position);
                    }
                }
            });
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if(position!=RecyclerView.NO_POSITION){
                listener.onCursoClick(v,position);
            }
        }
    }

    public interface OnDisciplinaClickListener {
        public void onCursoClick(View v, int position);
    }

}
