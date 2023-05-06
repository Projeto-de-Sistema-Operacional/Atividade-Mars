package mars.mips.instructions.syscalls;
import mars.mips.SO.ProcessManager.PCB;
import mars.mips.SO.ProcessManager.TabelaDeProcessos;
import mars.ProcessingException;
import mars.ProgramStatement;
import mars.mips.SO.ProcessManager.Escalonador;

public class SyscallProcessTerminate extends AbstractSyscall{
	public SyscallProcessTerminate() {
		super(62, "SyscallProcessTerminate");
	}
	
	@Override
	public void simulate(ProgramStatement statement) throws ProcessingException {
		TabelaDeProcessos.RemoveProcess();
	}
}
