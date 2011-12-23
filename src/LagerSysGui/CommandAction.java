/**
 * @author Selcuk Dogan, Tanveer Ahmed,  Önder Yavsan
 * @version 1.0
 * @created 01-Jun-2011 15:44:58
 *
 * Weist den Comando Buttons (Einlagern, Auslagern) einen Händler zu. 
 */
package LagerSysGui;
import Fassade.*; 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.text.*;

import Fassade.*;

public class CommandAction implements ActionListener
   {
    public static boolean CodeOK=false; 
    private String lastCommand;
    public static boolean freigabe = false;
	private Display Display = new Display();
	private FassadeDisplay Fassade = new FassadeDisplay(); 
	public int PaketCode = 0; 
	
      public void actionPerformed(ActionEvent event)
      {
         String command = event.getActionCommand();
         System.out.println("command ist:"+command);
         //if (command.equals("C")) Display.CodeField.setText("");
               lastCommand = command;
               pruefeCommand();
      }
      
      public int GeteingegebenerCode(){
    	  return PaketCode; 
      }
      
      public void pruefeCommand()
      {
         if (lastCommand.equals("C") && freigabe){
        	 Display.StatusField.setText("Eingabe Abgebrochen");
        	 Display.CodeField.setText("");
         }
         else if (lastCommand.equals("B")&& freigabe) {
        
      		PaketCode = 222; // Test Codes
      		
      		if (Integer.parseInt(Display.CodeField.getText())==PaketCode){
      			System.out.println( "Auslagern: Code Akzeptiert");
      			Display.StatusField.setText("Eingabe Bestaetigt");
           	  	
      			CodeOK=true;
           	  	Fassade.auslagern();	
        	}else{
        		Display.StatusField.setText("Code nicht Akzeptiert");
        		System.out.println("Falscher Code");
        		CodeOK=false;
        		freigabe=false;
        		InsertAction.freigabe=false;
        }

        	 
        	 
        	 //Display.StatusField.setText("Eingabe Bestaetigt");
         }
         if (lastCommand.equals("Abholen")){
        	 Fassade.auslagern();
         }
         if (lastCommand.equals("Einlagern")){
        	 Fassade.einlagern();
         }
         
      }

   }
