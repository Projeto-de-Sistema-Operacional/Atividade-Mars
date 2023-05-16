package mars.mips.SO.ProcessManager;

import java.util.Random;

public class Escalonador {

    public void escalonar() {
        PCB processeEmExecucao = TabelaDeProcessos.RemoveProcess();
        if (!processeEmExecucao.getProcessState().equals("Bloqueado")){
            TabelaDeProcessos.adicionarProcesso(processeEmExecucao);
        }
    }

    public static boolean fifo(){
        if(TabelaDeProcessos.PeekProcess() != null){
            TabelaDeProcessos.getProcessosProntos().add(TabelaDeProcessos.PeekProcess());
        }
        if(TabelaDeProcessos.getProcessosProntos().size() > 0 ){
            ((PCB) TabelaDeProcessos.getProcessosProntos()).setProcessState("Executando");

            TabelaDeProcessos.getProcessosProntos().remove(TabelaDeProcessos.PeekProcess());

            return true;
        }
        return false;
    }

    public static boolean PFixa(){
        if(TabelaDeProcessos.PeekProcess() != null){
            TabelaDeProcessos.getProcessosProntos().add(TabelaDeProcessos.PeekProcess());
        }
        if(TabelaDeProcessos.getProcessosProntos().size() > 0 ){
            TabelaDeProcessos.getProcessosProntos().peek();

            ((PCB) TabelaDeProcessos.getProcessosProntos()).setProcessState("Executando");

            TabelaDeProcessos.getProcessosProntos().remove(TabelaDeProcessos.PeekProcess());

            return true;
        }
        return false;
    }

    public static boolean Loteria(){
        if(TabelaDeProcessos.PeekProcess() != null){
            TabelaDeProcessos.getProcessosProntos().add(TabelaDeProcessos.PeekProcess());
        }
        if(TabelaDeProcessos.getProcessosProntos().size() > 0){
            Random random = new Random();

            int elemento = random.nextInt(TabelaDeProcessos.getProcessosProntos().size());
            ((PCB) TabelaDeProcessos.getProcessosProntos()).setProcessState("Executando");

            TabelaDeProcessos.getProcessosProntos().remove(elemento);
            return true;
        }
        return false;
    }
}