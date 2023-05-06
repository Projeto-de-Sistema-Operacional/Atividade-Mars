package mars.mips.SO.ProcessManager;

public class Escalonador {
    private TabelaDeProcessos tabelaDeProcessos;

    public void escalonar() {
        PCB processeEmExecucao = TabelaDeProcessos.RemoveProcess();
        if (!processeEmExecucao.getProcessState().equals("Bloqueado")){
            TabelaDeProcessos.adicionarProcesso(processeEmExecucao);
        }
    }
}