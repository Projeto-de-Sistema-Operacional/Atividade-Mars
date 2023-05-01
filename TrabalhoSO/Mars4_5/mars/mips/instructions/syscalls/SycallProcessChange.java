package mars.mips.instructions.syscalls;
import mars.mips.SO.ProcessManager.PCB;
import mars.mips.SO.ProcessManager.TabelaDeProcessos;
import mars.mips.SO.ProcessManager.Escalonador;

public class SycallProcessChange extends AbstractSyscall {

	public SycallProcessChange() {
		super(61,"SyscallProcessChange");
	}
	
	public void simulate(ProgramStatement statement) throws ProcessingException{
		PCB pcb = TabelaDeProcessos.getProcessoEmExecucao();
		pcb.copyRegistersToPCB();
		
		Escalonador.escalonar();
		pcb.copyPCBToRegisters();
	}
}
