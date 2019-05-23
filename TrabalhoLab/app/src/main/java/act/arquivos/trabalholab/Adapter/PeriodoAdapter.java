package act.arquivos.trabalholab.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import act.arquivos.trabalholab.Dados.Aluno;
import act.arquivos.trabalholab.Dados.Periodo;
import act.arquivos.trabalholab.R;

public class PeriodoAdapter extends RecyclerView.Adapter <PeriodoAdapter.ViewHolder> {

    private List <Periodo> listaPeriodos = new ArrayList<>();
    private PeriodoAdapter.OnPeriodoClickListener listener;

    public PeriodoAdapter(Aluno aluno) {
        for(int i=0;i<aluno.getListaPeriodos().size();i++){
            this.listaPeriodos.add(aluno.getListaPeriodos().get(i));
        }
    }

    public void alteraDados(Aluno aluno){
        listaPeriodos.clear();
        for(int i=0;i<aluno.getListaPeriodos().size();i++){
            this.listaPeriodos.add(aluno.getListaPeriodos().get(i));
        }
        notifyDataSetChanged();
    }

    public void setOnPeriodoClickListener(PeriodoAdapter.OnPeriodoClickListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public PeriodoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View linha = inflater.inflate(R.layout.lista_periodo_layout, viewGroup, false);
        PeriodoAdapter.ViewHolder vh = new PeriodoAdapter.ViewHolder(linha);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull PeriodoAdapter.ViewHolder viewHolder, int i) {
        String ano = "Ano: " + Integer.toString(this.listaPeriodos.get(i).getAno());
        String semestre = "Semestre: " + Integer.toString(this.listaPeriodos.get(i).getSemestre());
        String tempoTotal = "Tempo : " + Integer.toString(this.listaPeriodos.get(i).getTotalHoras()) + "h";

        String exatasPorcentagem = Integer.toString(this.listaPeriodos.get(i).getExatas().getHorasPorcentagem()) + "%";
        String exatasComputadas = Integer.toString(this.listaPeriodos.get(i).getExatas().getHorasComputadas()) + "%";
        String exatasParciais = Integer.toString(this.listaPeriodos.get(i).getExatas().getGetHorasComputadasPorcentagem()) + "%";
        String saudePorcentagem = Integer.toString(this.listaPeriodos.get(i).getSaude().getHorasPorcentagem()) + "%";
        String saudeComputadas = Integer.toString(this.listaPeriodos.get(i).getSaude().getHorasComputadas()) + "%";;
        String saudeParciais  = Integer.toString(this.listaPeriodos.get(i).getSaude().getGetHorasComputadasPorcentagem()) + "%";;
        String humanidadesPorcentagem = Integer.toString(this.listaPeriodos.get(i).getHumanidades().getHorasPorcentagem()) + "%";
        String humanidadesComputadas = Integer.toString(this.listaPeriodos.get(i).getHumanidades().getHorasComputadas()) + "%";;
        String humanidadesParciais  = Integer.toString(this.listaPeriodos.get(i).getHumanidades().getGetHorasComputadasPorcentagem()) + "%";;
        String linguasPorcentagem = Integer.toString(this.listaPeriodos.get(i).getLinguas().getHorasPorcentagem()) + "%";
        String linguasComputadas = Integer.toString(this.listaPeriodos.get(i).getLinguas().getHorasComputadas()) + "%";;
        String linguasParciais = Integer.toString(this.listaPeriodos.get(i).getLinguas().getGetHorasComputadasPorcentagem()) + "%";

        viewHolder.ano.setText(ano);
        viewHolder.semestre.setText(semestre);
        viewHolder.tempo.setText(tempoTotal);
        viewHolder.exatasPorcentagem.setText(exatasPorcentagem);
        viewHolder.exatasComputadas.setText(exatasComputadas);
        viewHolder.exatasParciais.setText(exatasParciais);
        viewHolder.saudePorcentagem.setText(saudePorcentagem);
        viewHolder.saudeComputadas.setText(saudeComputadas);
        viewHolder.saudeParciais.setText(saudeParciais);
        viewHolder.humanidadesPorcentagem.setText(humanidadesPorcentagem);
        viewHolder.humanidadesComputadas.setText(humanidadesComputadas);
        viewHolder.humanidadesParciais.setText(humanidadesParciais);
        viewHolder.linguasPorcentagem.setText(linguasPorcentagem);
        viewHolder.linguasComputadas.setText(linguasComputadas);
        viewHolder.linguasParciais.setText(linguasParciais);
    }

    @Override
    public int getItemCount() {
        return this.listaPeriodos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView ano;
        TextView semestre;
        TextView tempo;
        TextView exatasPorcentagem;
        TextView exatasComputadas;
        TextView exatasParciais;
        TextView saudePorcentagem;
        TextView saudeComputadas;
        TextView saudeParciais;
        TextView humanidadesPorcentagem;
        TextView humanidadesComputadas;
        TextView humanidadesParciais;
        TextView linguasPorcentagem;
        TextView linguasComputadas;
        TextView linguasParciais;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ano = (TextView) itemView.findViewById(R.id.anoTxtPeriodoLayout);
            semestre = (TextView) itemView.findViewById(R.id.semestreTxtPeriodoLayout);
            tempo = (TextView) itemView.findViewById(R.id.tempoTotalTxtPeriodoLayout);
            exatasPorcentagem = (TextView) itemView.findViewById(R.id.exatasPorcentagemTxtPeriodoLayout);
            exatasComputadas = (TextView) itemView.findViewById(R.id.exatasHorasComputadasTxtPeriodoLayout);
            exatasParciais = (TextView) itemView.findViewById(R.id.exatasHorasParciaisTxtPeriodoLayout);
            saudePorcentagem = (TextView) itemView.findViewById(R.id.saudePorcentagemTxtPeriodoLayout);
            saudeComputadas = (TextView) itemView.findViewById(R.id.saudeHorasComputadasTxtPeriodoLayout);
            saudeParciais = (TextView) itemView.findViewById(R.id.saudeHorasParciaisTxtPeriodoLayout);
            humanidadesPorcentagem = (TextView) itemView.findViewById(R.id.humanidadesPorcentagemTxtPeriodoLayout);
            humanidadesComputadas = (TextView) itemView.findViewById(R.id.humanidadesHorasComputadasTxtPeriodoLayout);
            humanidadesParciais = (TextView) itemView.findViewById(R.id.humanidadesHorasParciaisTxtPeriodoLayout);
            linguasPorcentagem = (TextView) itemView.findViewById(R.id.linguasPorcentagemTxtPeriodoLayout);
            linguasComputadas = (TextView) itemView.findViewById(R.id.linguasHorasComputadasTxtPeriodoLayout);
            linguasParciais = (TextView) itemView.findViewById(R.id.linguasHorasParciaisTxtPeriodoLayout);



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(listener!=null){
                        listener.onPeriodoClick(v, position);
                    }
                }
            });
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if(position!=RecyclerView.NO_POSITION){
                listener.onPeriodoClick(v,position);
            }
        }
    }

    public interface OnPeriodoClickListener {
        public void onPeriodoClick(View v, int position);
    }
}
