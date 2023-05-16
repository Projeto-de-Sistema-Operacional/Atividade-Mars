 package mars.mips.SO.ProcessManager;
 import java.util.Random;

import mars.mips.hardware.RegisterFile;

public class PCB {
	
	private int enderecoInicio; 
    private int pid;
    private String processState;
    private int[] registerValues;
    private int numeroDeRegistradores = 34;
	
	public void copyRegistersToPCB() {
        for (int i = 0; i < numeroDeRegistradores; i++) {
           if( i>=32 ) registerValues[i] = RegisterFile.getValue(i + 1);
           else registerValues[i] = RegisterFile.getValue(i);
        }
    }

    public void copyPCBToRegisters() {
        for (int i = 0; i < numeroDeRegistradores; i++) {
            if( i>=32 ) registerValues[i] = RegisterFile.updateRegister(i + 1, registerValues[i]);
            else RegisterFile.updateRegister(i, registerValues[i]);
         }
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

    public int getNumeroDeRegistradores(){
        return numeroDeRegistradores;
    }

    public int[] getRegisterValues() {
        return registerValues;
    }

    public void setRegisterValues(int[] registerValues) {
        this.registerValues  = registerValues; 
    }

    public int getEndecoInicio(){
        return enderecoInicio;
    }

    public void setEnderecoInicio(int enderecoInicio){
        this.enderecoInicio = enderecoInicio;
    }	

    public PCB(int enederecoInicio) {
        registerValues = new int[numeroDeRegistradores];
        setEnderecoInicio(enederecoInicio);
        setProcessState("Pronto");
        pid = new Random().nextInt(Integer.MAX_VALUE);
    }
}
