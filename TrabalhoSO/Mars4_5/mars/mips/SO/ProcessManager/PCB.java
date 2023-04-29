 package mars.mips.SO.ProcessManager;
 import mars.mips.hardware.RegisterFile;

public class PCB {
	
	private String programStartAddress;
    private int pid;
    private String processState;
    private int[] registerValues;
	
	public void copyRegistersToPCB() {
        for (int i = 0; i < RegisterFile.NUM_REGISTERS; i++) {
            this.registerValues[i] = RegisterFile.getValue(i);
        }
    }

    public void copyPCBToRegisters() {
        for (int i = 0; i < RegisterFile.NUM_REGISTERS; i++) {
            RegisterFile.updateRegister(i, this.registerValues[i]);
        }
    }
    
    public String getProgramStartAddress() {
        return programStartAddress;
    }

    public void setProgramStartAddress(String programStartAddress) {
        this.programStartAddress = programStartAddress;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getProcessState() {
        return processState;
    }

    public void setProcessState(String processState) {
        this.processState = processState;
    }

    public int[] getRegisterValues() {
        return registerValues;
    }
	
    public PCB(String programStartAddress, int pid, String processState) {
        this.programStartAddress = programStartAddress;
        this.pid = pid;
        this.processState = processState;
        this.registerValues = new int[RegisterFile.NUM_REGISTERS];
        for (int i = 0; i < RegisterFile.NUM_REGISTERS; i++) {
            this.registerValues[i] = RegisterFile.getValue(i);
        }
    }
}
