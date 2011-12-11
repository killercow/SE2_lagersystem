/**
 * @author Selcuk Dogan, Tanveer Ahmed,  Önder Yavsan
 * @version 1.0
 * @created 01-Jun-2011 15:44:58
 *
 * Erstellt das Hauptfenster
 */
package LagerSysGui;
import java.awt.BorderLayout;
import javax.swing.*;

import javax.swing.*;
public class LagerSysFrame extends JFrame
{
   public LagerSysFrame(String title)
   {
      setTitle(title);   // Name der Titelleiste
      this.setSize(600, 400);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // Frame sichtbar machen
      
      setLayout(new BorderLayout());
      
      add(pad, BorderLayout.EAST);
      add(pad2,BorderLayout.WEST);
      add(Dis1, BorderLayout.SOUTH);
      
      pack();
      this.setVisible(true);
   }
   PadPanel pad = new PadPanel();
   ButtonPanel pad2 = new ButtonPanel();
   Display Dis1 = new Display();
}