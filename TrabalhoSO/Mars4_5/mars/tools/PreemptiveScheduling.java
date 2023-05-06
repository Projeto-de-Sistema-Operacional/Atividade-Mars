   package mars.tools;
   import javax.swing.*;
   import javax.swing.border.*;
   import javax.swing.filechooser.FileFilter;
   import java.awt.*;
   import java.awt.event.*;
   import java.util.*;
   import java.io.*;
   import mars.*;
   import mars.util.*;
   import mars.tools.*;
   import mars.mips.hardware.*;
   import mars.mips.SO.ProcessManager.TabelaDeProcessos;
   import mars.mips.SO.ProcessManager.Escalonador;

public class PreemptiveScheduling extends AbstractMarsToolAndApplication {
	   
    private static String heading =  "Preemptive Scheduling";
	private static String version = " Version 1.0";
 	         	
     public PreemptiveScheduling(String title, String heading) {
       super(title,heading);
    }
 	 
     public PreemptiveScheduling() {
       super (heading+", "+version, heading);
    }
 		 
     public static void main(String[] args) {
       new PreemptiveScheduling(heading+", "+version,heading).go();
    }
 	
     public String getName() {
       return "Preemptive Scheduling";
    }
 	
    
 }