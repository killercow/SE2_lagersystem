/**
 * @author Selcuk Dogan, Tanveer Ahmed,  Önder Yavsan
 * @version 1.0
 * @created 01-Jun-2011 15:44:58
 *
 * Erstellt ein Panel mit zwei Buttons. Für Einlagern und Auslagern
 */


package LagerSysGui;
import javax.swing.*;




import java.awt.*;
import java.awt.event.ActionListener;

class ButtonPanel extends JPanel
{
   public ButtonPanel()
   {
	   setLayout(new BorderLayout());  // Layout-Manager festlegen
	      // Angabe der Anzahl von Spalten und Zeilen im Konstruktor
	      this.setLayout(new GridLayout(2, 1)); 
	      // Panel Komponenten im Centerblock platzieren           
	      ActionListener command = new CommandAction();

	      addButton("Abholen",command);
	      addButton("Einlagern",command);
	           
	      //add(panel, BorderLayout.CENTER);
   }
   private void addButton(String label, ActionListener listener)
   {
      JButton button = new JButton(label);
      button.addActionListener(listener);
      this.add(button);
   }
}
