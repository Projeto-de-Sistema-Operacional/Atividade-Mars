package mars.mips.instructions.syscalls;
import mars.mips.SO.ProcessManager.TabelaDeProcessos;
import mars.mips.hardware.RegisterFile;

public class SyscallFork extends AbstractSyscall {
	
	public SyscallFork(){
		super(60, "SyscallFork");
	}
	public void simulate(ProgramStatement statement) throws ProcessingException{
		try{
			TabelaDeProcessos.criarProcesso(RegisterFile.getValue(4));
		} catch (AddressErrorException e) {
			throw new ProcessingException(statement, e)
		}
	}
}
