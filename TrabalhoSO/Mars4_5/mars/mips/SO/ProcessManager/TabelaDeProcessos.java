package mars.mips.SO.ProcessManager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import mars.mips.SO.ProcessManager.PCB;
import mars.mips.hardware.Register;
import mars.mips.hardware.RegisterFile;
import mars.mips.SO.ProcessManager.Escalonador;

public class TabelaDeProcessos {
    private static Queue<PCB> filaProcessos = new LinkedList<PCB>();

    public static Queue<PCB> getProcessosProntos(){
        return filaProcessos;
    }

    public static void setProcessosProntos(Queue<PCB> processosProntos){
        TabelaDeProcessos.filaProcessos = processosProntos;
    }

    public static void adicionarProcesso(PCB pcb){
        if(filaProcessos.size() == 0){
            pcb.setProcessState("Em Execução");
        }else pcb.setProcessState("Pronto");

        filaProcessos.add(pcb);
    }

    public static void criarProcesso(int enderecoInicio){
        PCB pcb = new PCB(enderecoInicio);
        adicionarProcesso(pcb);
    }

    public static PCB PeekProcess(){
        return filaProcessos.peek();
    }

    public static PCB RemoveProcess(){
        PCB processoRemovido = filaProcessos.remove();
        if(filaProcessos.size() != 0){
            PCB processoTopo = PeekProcess();
            processoTopo.setProcessState("Em Execução");
        }

        return processoRemovido;
    }

    public static String algoritmoEscolhido = "FIFO";

    public static String getAlgortimo(){
        return algoritmoEscolhido;
    }

    public static void setAlgoritmo(String algoritmo){
        TabelaDeProcessos.algoritmoEscolhido = algoritmo;
    }

    private static PCB rodando;

    private static void processChange(String algoritmo){
        if(PeekProcess() != null){
            System.out.println("Salvando");

            rodando.setProcessState("Pronto");
            rodando.setEnderecoInicio(RegisterFile.getProgramCounter());

            rodando.copyRegistersToPCB();
        }

        switch(algoritmo){
            case "FIFO":
            if(Escalonador.fifo()){
                RegisterFile.setProgramCounter(rodando.getNumeroDeRegistradores());

                System.out.println("Indo para : " + RegisterFile.getProgramCounter());
                rodando.copyPCBToRegisters();
            }
            break;
            case "PFixa":
            if(Escalonador.PFixa()){
                for(int i = 0; i < rodando.getRegisterValues().length; i++){
                    RegisterFile.updateRegister(i, rodando.getEndecoInicio());
                }
            }
            if(rodando != null){
                RegisterFile.setProgramCounter(rodando.getEndecoInicio());
            }
            break;
            case "Loteria":
            if(Escalonador.Loteria()){
                for(int i = 0; i < rodando.getRegisterValues().length; i++){
                    RegisterFile.updateRegister(i, rodando.getEndecoInicio());
                }
            }
            if(rodando != null){
                RegisterFile.setProgramCounter(rodando.getEndecoInicio());
            }
            break;
            default:
            System.out.println("default");
            break;
        }
    }
}
