package Fassade;
import LagerSysGui.*; 
import java.text.SimpleDateFormat;
import java.util.Date;
import LagerSysPrg.*;
import Simulation.*;

public class FassadeDisplay {

	private Packet Paket = new Packet(); 
	private KlappenTuer Klappentuer = new KlappenTuer(); 
	private EinAusgPlatz EAPlatz = new EinAusgPlatz();
	
	public FassadeDisplay(){
		
	}

	public static void auslagern(){
//		Display.StatusField.setText("Abholen: Bitte Code eingeben");
//     	Display.CodeField.setText("");
//   		InsertAction.freigabe=true;
//   		CommandAction.freigabe=true;
   		//freigabe=true;
     	
//   		if (CommandAction.CodeOK){
     		System.out.println( "Auslagern: Preis und Lagerzeit ermitteln");
     		
//     		Display.PreisField.setText("Preis");
//    		Display.ZeitField.setText("Lagerzeit");
    	
    		System.out.println( "Auslagern: Geld pruefen");
    		System.out.println( "Auslagern: starte Stapler");
        		
//    		TestSim T = new TestSim();
//    		T.fahre(T.LP1);
    		
    		System.out.println( "Auslagern: Klappe oeffnen");
    		System.out.println( "Auslagern: Packet entnommen");
    		System.out.println( "Auslagern: Klappe schliessen");
    		System.out.println( "Auslagern: Auslagern beendet");
//  	  		Display.StatusField.setText("Abholen: Aufwiedersehen");
//  	  	InsertAction.freigabe=false;
//   		CommandAction.freigabe=false;
//   		}
   		
	}

	public void einlagern(){
		boolean Klappentueristoffen = false; 
		
		Display.StatusField.setText("Bitte legen Sie Packet ein");
		Display.CodeField.setText("code berechnen");
	  	  
		Date dt = new Date();
	  	// Festlegung des Formats:
		SimpleDateFormat df = new SimpleDateFormat( "dd-MM-yyyy HH:mm:ss" );
		SimpleDateFormat time = new SimpleDateFormat("HH:mm");
	     	// Formatierung zu String:
		System.out.println( "Einlagern: Date = " + df.format( dt ) );        // z.B. '2001-01-26 19:03:56.731'	  	
		Display.ZeitField.setText(time.format(dt));
	  	
	  	System.out.println( "Einlagern: Klappe šffnen");
	  	Klappentueristoffen = Klappentuer.oeffnen(); 
	  	if(Klappentueristoffen){
	  		System.out.println( "Einlagern: Packet eingelegt");
	  		if(EAPlatz.Paketannehmen()){
	  			System.out.println( "Einlagern: Klappe schliessen");
	  			Klappentuer.schliessen(); 
	  			EAPlatz.PaketaufBRzumStaplerfahren(); 
	  			EAPlatz.EAPLatzinAusgangsstellungBringen(); 
	  		}
	  		
	  	}
	  	System.out.println( "Einlagern: Beleg drucken");
	  	System.out.println( "Einlagern: einlagern beendet");
	  	
//		  Display.StatusField.setText("Einlagern: Beleg entnehmen");

	}

	/**
	 * 
	 * @param args    args
	 */
	public static void main(String[] args){

	}

}