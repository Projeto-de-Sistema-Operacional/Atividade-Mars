package mars.mips.SO.ProcessManager;

public class Escalonador {
    private TabelaDeProcessos tabelaDeProcessos;

    public Escalonador(TabelaDeProcessos tabelaDeProcessos) {
        this.tabelaDeProcessos = tabelaDeProcessos;
    }

    public void escalonar() {
        if (this.tabelaDeProcessos.existeProcessoPronto()) {
            PCB processoAnterior = this.tabelaDeProcessos.getProcessoEmExecucao();
            PCB processoNovo = this.tabelaDeProcessos.removerProcessoPronto();
            if (processoAnterior != null) {
                processoAnterior.setProcessState("Pronto");
                this.tabelaDeProcessos.adicionarProcessoPronto(processoAnterior);
            }
            processoNovo.setProcessState("Executando");
            processoNovo.copyPCBToRegisters();
            this.tabelaDeProcessos.setProcessoEmExecucao(processoNovo);
        }
    }
}