/**
 * @author Tanveer Ahmed,
 * @version 1.0
 * @created 01-Jun-2011 15:44:58
 *
 * Weist den Ziffern Buttons einen Händler zu.
 */
package LagerSysGui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import com.sun.org.apache.bcel.internal.generic.GETFIELD;

public class InsertAction implements ActionListener{
	Display Display = new Display();
	  public void actionPerformed(ActionEvent event)
      {
    	  if (freigabe){
         String input = event.getActionCommand();
         System.out.println("input ist:"+input);
         
         // Beim Start keinen Text anzeigen
         // Das Start Flag anschlie§end auf false setzen
        if (start)
         {
        
           Display.CodeField.setText("");
            start = false;
         }
         // Text anzeigen
         Display.CodeField.setText(Display.CodeField.getText() + input);
         }
      }
      private boolean start=true;
      public static boolean freigabe=true;
   }