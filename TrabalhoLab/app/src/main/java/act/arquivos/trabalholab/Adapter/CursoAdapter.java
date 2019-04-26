package act.arquivos.trabalholab.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import act.arquivos.trabalholab.Dados.Curso;
import act.arquivos.trabalholab.Dados.Aluno;
import act.arquivos.trabalholab.R;

public class CursoAdapter extends RecyclerView.Adapter<CursoAdapter.ViewHolder> {

    private List <Curso> listaCursos;
    private OnCursoClickListener listener;

    public CursoAdapter(Aluno aluno) {
        this.listaCursos.add(aluno.getLinguas());
        this.listaCursos.add(aluno.getExatas());
        this.listaCursos.add(aluno.getSaude());
        this.listaCursos.add(aluno.getHumanidades());
    }

    public void setOnCursoClickListener(OnCursoClickListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public CursoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View linha = inflater.inflate(R.layout.lista_curso_layout, viewGroup, false);
        ViewHolder vh = new ViewHolder(linha);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CursoAdapter.ViewHolder viewHolder, int i) {
        String nome = this.listaCursos.get(i).getNome();
        String porcentagem  = Integer.toString(this.listaCursos.get(i).getHoras());
        String computadas = Integer.toString(this.listaCursos.get(i).getHoras());
        String parciais  = Integer.toString(this.listaCursos.get(i).getHoras());

        viewHolder.txtNome.setText(nome);
        viewHolder.txtPorcentagem.setText(porcentagem);
        viewHolder.txtParciais.setText(computadas);
        viewHolder.txtComputadas.setText(parciais);
    }

    @Override
    public int getItemCount() {
        return this.listaCursos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtNome;
        TextView txtPorcentagem;
        TextView txtParciais;
        TextView txtComputadas;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNome = (TextView) itemView.findViewById(R.id.txtCursoLayout);
            txtPorcentagem = (TextView) itemView.findViewById(R.id.txtHorasPorcentagemLayout);
            txtParciais = (TextView) itemView.findViewById(R.id.txtHorasParciaisLayout);
            txtComputadas = (TextView) itemView.findViewById(R.id.txtHorasComputadasLayout);

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

    public interface OnCursoClickListener {
        public void onCursoClick(View v, int position);
    }

}
