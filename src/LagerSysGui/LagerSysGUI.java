package LagerSysGui;
import Fassade.*; 

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JToggleButton;

public class LagerSysGUI{

	private JFrame LagerSysFrame = null;  //  @jve:decl-index=0:visual-constraint="5,6"
	private JPanel meinContainer = null;
	private JPanel NumPadPanel = null;
	
	private JButton[] PadButton = new JButton[13];  // 
	private String[] ButtonName = {"1","2","3","4","5","6","7","8","9","C","0","B","Abbruch"};
	
	private JPanel MainBtnPanel = null;
	private JPanel TextPanel = null;
	
	private JLabel CodeLabel = null;
	private JLabel DauerLabel = null;
	private JLabel PreisLabel = null;
	private JLabel StatusLabel = null;
	
	private JTextField ZeitField = null;
	private JTextField PreisField = null;
	private JTextField StatusField = null;
	private JTextField CodeField = null;
	
	private JButton einlagern = null;
	private JButton auslagern = null;
	boolean freigabe = false;
	private FassadeDisplay Fassade; 
	
	public LagerSysGUI() {
		//getLagerSysFrame();
		super();
		initialize();
		Fassade = new FassadeDisplay(); 
		
	}

	private void initialize(){
		
		getLagerSysFrame();
	}
	
	
	private JFrame getLagerSysFrame() {
		if (LagerSysFrame == null) {
			LagerSysFrame = new JFrame();
			LagerSysFrame.setSize(new Dimension(600, 400));
			LagerSysFrame.setTitle("LagerSystem");
			LagerSysFrame.setContentPane(getMeinContainer());
			LagerSysFrame.setVisible(true);
			LagerSysFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		return LagerSysFrame;
	}

	private JPanel getMeinContainer() {
		if (meinContainer == null) {
			meinContainer = new JPanel();
			meinContainer.setLayout(null);
			meinContainer.add(getNumPadPanel(), null);
			meinContainer.add(getMainBtnPanel(), null);
			meinContainer.add(getTextPanel(), null);
		}
		return meinContainer;
	}

	private JPanel getNumPadPanel() {
		if (NumPadPanel == null) {
			NumPadPanel = new JPanel();
			NumPadPanel.setLayout(new GridLayout(5,3));
			NumPadPanel.setBounds(new Rectangle(330, 15, 197, 166));

			for(int i=0;i<ButtonName.length;i++){
				NumPadPanel.add(getPadButton(ButtonName[i],i));
			}
		}
		return NumPadPanel;
	}

	
	private JButton getPadButton(String Label,int i) {
		if (PadButton[i] == null) {
			PadButton[i] = new JButton();
			PadButton[i].setText(Label);
			PadButton[i].addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent event) {
					System.out.println("Taste gedrueckt");
					eingabe(event.getActionCommand());
				}
			});
		}
		return PadButton[i];
	}

	private JPanel getMainBtnPanel() {
		if (MainBtnPanel == null) {
			MainBtnPanel = new JPanel();
			MainBtnPanel.setBounds(new Rectangle(15, 15, 301, 166));
			MainBtnPanel.setLayout( new GridLayout(2,1));
		
			MainBtnPanel.add(getAbholen("Abholen"));	
			MainBtnPanel.add(getEinlagern("Einlagern"));	
		}
		return MainBtnPanel;
	}
	
	private JButton getEinlagern(String Label) {
		if ( einlagern== null) {
			einlagern = new JButton();
			einlagern.setText(Label);
			einlagern.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					eingabe(e.getActionCommand());				
				}
			});
		}
		return einlagern;
	}	
	private JButton getAbholen(String Label) {
		if (auslagern == null) {
			auslagern = new JButton();
			auslagern.setText(Label);
			auslagern.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					eingabe(e.getActionCommand());	
				}
			});
		}
		return auslagern;
	}
	
	
	private void eingabe(String comand)
    {
		if(comand=="Abholen"){
			System.out.println("Abholen wurde gedrŸckt!"); 
			StatusField.setText(comand);
			einlagern.setEnabled(false);
			CodeField.setText("");
			freigabe = true;
			Fassade.auslagern(); 
		}
		else if(comand=="Einlagern"){
			System.out.println("Einlagern wurde gedrŸckt!"); 
			StatusField.setText(comand);
			auslagern.setEnabled(false);
			
		  	Date dt = new Date();
		  	// Festlegung des Formats:
		  	SimpleDateFormat df = new SimpleDateFormat( "dd-MM-yyyy HH:mm:ss" );
		  	SimpleDateFormat time = new SimpleDateFormat("HH:mm");
		     	// Formatierung zu String:
		  	System.out.println( "Einlagern: Date = " + df.format( dt ) );        // z.B. '2001-01-26 19:03:56.731'
		  	ZeitField.setText(time.format(dt));
			Fassade.einlagern(); 
		}
		else if(comand=="Abbruch"){
			System.out.println("Abbruch wurde gedrŸckt!");
			getCodeField().setText("");
			auslagern.setEnabled(true);
			einlagern.setEnabled(true);
			StatusField.setText("");
			freigabe = false;
			
		}
		else if(comand=="C"&& freigabe){
			CodeField.setText("");
			System.out.println("C gedrŸckt");
		}
		else if(comand=="B"&& freigabe){
			System.out.println("B gedrŸckt");
			StatusField.setText("eingegebener Code:" + CodeField.getText());
			
			freigabe = CodePruefen(); ;
		}else if (freigabe){
			CodeField.setText(CodeField.getText()+comand);
		}
    }
	private boolean CodePruefen(){
		int CodeListe=222;
	
   		if (Integer.parseInt(CodeField.getText())==CodeListe){
   			System.out.println( "Auslagern: Code Akzeptiert");
      	  StatusField.setText("Eingabe Bestaetigt");
      	  	return true;
      	  //auslagern();	
   		}else{
   			StatusField.setText("Code nicht Akzeptiert");
   			return false;
   			//CodeOK=false;
   			//auslagern();
   		}
	}

	
	private JPanel getTextPanel() {
		if (TextPanel == null) {
			StatusLabel = new JLabel();
			StatusLabel.setBounds(new Rectangle(15, 75, 481, 46));
			StatusLabel.setText("Status:");
			PreisLabel = new JLabel();
			PreisLabel.setBounds(new Rectangle(345, 15, 151, 46));
			PreisLabel.setText("Preis");
			DauerLabel = new JLabel();
			DauerLabel.setBounds(new Rectangle(210, 15, 121, 46));
			DauerLabel.setText("Dauer:");
			CodeLabel = new JLabel();
			CodeLabel.setBounds(new Rectangle(15, 15, 181, 46));
			CodeLabel.setText("Code:");
			TextPanel = new JPanel();
			TextPanel.setLayout(null);
			TextPanel.setBounds(new Rectangle(15, 195, 514, 136));
			
			TextPanel.add(CodeLabel, null);
			TextPanel.add(getCodeField(), null);
			TextPanel.add(DauerLabel, null);
			TextPanel.add(PreisLabel, null);
			TextPanel.add(getZeitField(), null);
			TextPanel.add(getPreisField(), null);
			TextPanel.add(StatusLabel, null);
			TextPanel.add(getStatusField(), null);
		}
		return TextPanel;
	}
	
	public JTextField getCodeField() {
		if (CodeField == null) {
			CodeField = new JTextField();
			CodeField.setBounds(new Rectangle(60, 30, 121, 16));
		}
		return CodeField;
	}
	public JTextField getZeitField() {
		if (ZeitField == null) {
			ZeitField = new JTextField();
			ZeitField.setBounds(new Rectangle(240, 30, 76, 16));
		}
		return ZeitField;
	}
	public JTextField getPreisField() {
		if (PreisField == null) {
			PreisField = new JTextField();
			PreisField.setBounds(new Rectangle(390, 30, 91, 16));
		}
		return PreisField;
	}
	public JTextField getStatusField() {
		if (StatusField == null) {
			StatusField = new JTextField();
			StatusField.setBounds(new Rectangle(60, 90, 421, 16));
		}
		return StatusField;
	}

	public static void main(String[] args) {
		new LagerSysGUI();
	}

}