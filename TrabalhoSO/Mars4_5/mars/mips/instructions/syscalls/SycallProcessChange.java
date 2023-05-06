package mars.mips.instructions.syscalls;
import mars.mips.SO.ProcessManager.PCB;
import mars.mips.SO.ProcessManager.TabelaDeProcessos;
import mars.ProcessingException;
import mars.ProgramStatement;
import mars.mips.SO.ProcessManager.Escalonador;

public class SycallProcessChange extends AbstractSyscall {

	public SycallProcessChange() {
		super(61,"SyscallProcessChange");
	}

	@Override
	public void simulate(ProgramStatement statement) throws ProcessingException {
		// TODO Auto-generated method stub
		PCB processoEmExecucao = TabelaDeProcessos.PeekProcess();
		processoEmExecucao.copyRegistersToPCB();
		
		// Escalonador.escalonar();
		PCB novoProcessoEmExecucao = TabelaDeProcessos.PeekProcess();
		novoProcessoEmExecucao.copyPCBToRegisters();
	}
}
