package mars.mips.SO.ProcessManager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import mars.mips.SO.ProcessManager.PCB;
import mars.mips.SO.ProcessManager.Escalonador;

public class TabelaDeProcessos {
    private ArrayList<PCB> processosProntos;
    private PCB processoEmExecucao;

    public TabelaDeProcessos() {
        this.processosProntos = new ArrayList<>();
        this.processoEmExecucao = null;
    }
    
    public static void criarProcesso(int enderecoInicio) {
    	PCB pcb = new PCB(enderecoInicio);
    	processosProntos.add(pcb);
    	Escalonador.escalonar();
    }
    
    

    public ArrayList<PCB> getProcessosProntos() {
        return processosProntos;
    }

    public void setProcessosProntos(ArrayList<PCB> processosProntos) {
        pcb.setProcessState("Execução");
        processosEmexecucao = pcb;
    }

    public PCB getProcessoEmExecucao() {
        return processoEmExecucao;
    }

    public void setProcessoEmExecucao(PCB processoEmExecucao) {
        this.processoEmExecucao = processoEmExecucao;
    }

    public void adicionarProcessoPronto(PCB processo) {
    	if(!pcb.getProcessState().equals("Pronto")) {
    		pcb.setProcessState("Pronto");
    	}
        this.processosProntos.add(processo);
    }

    public PCB removerProcessoPronto() {
        if (this.processosProntos.isEmpty()) {
            return null;
        } else {
            return this.processosProntos.remove(0);
        }
    }

    public boolean existeProcessoPronto() {
        return !this.processosProntos.isEmpty();
    }
}
