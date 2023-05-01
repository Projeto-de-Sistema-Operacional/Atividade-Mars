package mars.mips.instructions.syscalls;
import mars.mips.SO.ProcessManager.PCB;
import mars.mips.SO.ProcessManager.TabelaDeProcessos;
import mars.mips.SO.ProcessManager.Escalonador;

public class SyscallProcessTerminate extends AbstractSyscall{
	public SyscallProcessTerminate() {
		super(62, "SyscallProcessTerminate");
	}
	
	public void simulate(ProcessStatement statement) throws ProcessingException{
		PCB pcb = TabelaDeProcessos.getProcessoEmExecucao();
		
		Escalonador.escalonar();
		TabelaDeProcessos.removerProcessoPronto(pcb);
	}
}
