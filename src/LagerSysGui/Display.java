/**
 * @author  Tanveer Ahmed,
 * @version 1.0
 * @created 01-Jun-2011 15:44:58
 *
 * Erstelt Textfelder für die Ausgabe von Zeit, Preis, Abholcode.
 */

package LagerSysGui;
import javax.swing.*;

import java.awt.*;

public class Display extends JPanel{
	public Display(){
		setLayout(new BorderLayout());  // Layout-Manager festlegen
	      // Angabe der Anzahl von Spalten und Zeilen im Konstruktor
	   this.setLayout(new GridLayout(6, 2)); 
	   // Panel Komponenten im Centerblock platzieren     		      
	   addLabel("Code");
	   this.add(CodeField);
	   addLabel("Lager Dauer");
	   this.add(ZeitField);
	   addLabel("Preis");
	   this.add(PreisField);
	   addLabel("Status");
	   this.add(StatusField);
	}
	private void addLabel(String label){
		JLabel LabelField = new JLabel(label);
		this.add(LabelField);
	}
	
	TextField1 F1 = new TextField1();
	
	public JTextField CodeField= new JTextField();
	public JTextField ZeitField= new JTextField();
	public JTextField PreisField= new JTextField(); 
	public JTextField StatusField= new JTextField();   
}
