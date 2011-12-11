/**
 * @author Selcuk Dogan, Tanveer Ahmed,  Önder Yavsan
 * @version 1.0
 * @created 01-Jun-2011 15:44:58
 *
 * Erstellt die Ziffern Button in einen Panel
 */
package LagerSysGui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class PadPanel extends JPanel
{
   public PadPanel()
   {
	   setLayout(new BorderLayout());  // Layout-Manager festlegen
	   this.setLayout(new GridLayout(4, 3)); // Angabe der Anzahl von Spalten und Zeilen im Konstruktor
	      
      ActionListener insert = new InsertAction();
      ActionListener command = new CommandAction();
      
      addButton("7", insert);
      addButton("8", insert);
      addButton("9", insert);
 
      addButton("4", insert);
      addButton("5", insert);
      addButton("6", insert);
 
      addButton("1", insert);
      addButton("2", insert);
      addButton("3", insert);
 
      addButton("C", command);
      addButton("0", insert);
      addButton("B", command);
      
      //add(panel, BorderLayout.CENTER);// Panel Komponenten im Centerblock platzieren
   }
   private void addButton(String label, ActionListener listener)
   {
      JButton button = new JButton(label);
      button.addActionListener(listener);
      this.add(button);
   }
 }