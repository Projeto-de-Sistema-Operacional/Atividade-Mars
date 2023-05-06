package mars.mips.SO.ProcessManager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import mars.mips.SO.ProcessManager.PCB;
import mars.mips.SO.ProcessManager.Escalonador;

public class TabelaDeProcessos {
    private static Queue<PCB> filaProcessos = new LinkedList<PCB>();

    public static void adicionarProcesso(PCB pcb){
        if(filaProcessos.size() == 0){
            pcb.setProcessState("Em Execução");
        }else pcb.setProcessState("Pronto");

        filaProcessos.add(pcb);
    }

    public static void criarProcesso(int enderecoInicio){
        PCB pcb = new PCB(enderecoInicio);
        adicionarProcesso(pcb);
    }

    public static PCB PeekProcess(){
        return filaProcessos.peek();
    }

    public static PCB RemoveProcess(){
        PCB processoRemovido = filaProcessos.remove();
        if(filaProcessos.size() != 0){
            PCB processoTopo = PeekProcess();
            processoTopo.setProcessState("Em Execução");
        }

        return processoRemovido;
    }
}
