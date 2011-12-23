/**
 * @author Selcuk Dogan, Tanveer Ahmed,  ÷nder Yavsan
 * @version 1.0
 * @created 01-Jun-2011 15:44:58
 *
 * Weist den Comando Buttons (Einlagern, Auslagern) einen H‰ndler zu. 
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
        	 System.out.println("CommandAction; C wurde gedrückt");
        	 Display.StatusField.setText("Eingabe Abgebrochen");
        	 Display.CodeField.setText("");
         }
         else if (lastCommand.equals("B")&& freigabe) {
        	 System.out.println("B wurde gedrückt");
        
      		PaketCode = 222; // Test Codes
      		
      		if (Integer.parseInt(Display.CodeField.getText())==PaketCode){
      			System.out.println( "CommanAction: Auslagern: Code Akzeptiert");
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
         }
         else if (lastCommand.equals("Abholen")){
        	 System.out.println("CommandAction: Auslagern wurde gedrückt"); 
        	 //Fassade.auslagern();
         }
         else if (lastCommand.equals("Einlagern")){
        	 System.out.println("CommandAction: Einlagern wurde gedrückt"); 
        	 //Fassade.einlagern();
         }
         
      }

   }
