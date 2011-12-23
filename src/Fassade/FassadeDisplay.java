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
	private CommandAction commandAction = new CommandAction(); 
	
	public FassadeDisplay(){
		
	}

	public void auslagern(){
		Display.StatusField.setText("Abholen: Bitte Code eingeben");
		int Paketcode = commandAction.GeteingegebenerCode(); 
		Display.CodeField.setText("");
		InsertAction.freigabe=true;
		commandAction.freigabe=true;
		Date dt = new Date();
	  	// Festlegung des Formats:
		SimpleDateFormat df = new SimpleDateFormat( "dd-MM-yyyy HH:mm:ss" );
		SimpleDateFormat time = new SimpleDateFormat("HH:mm");
		
		System.out.println( "Auslagern: Date = " + df.format( dt ) );
		Paket.setAusLagZeit(time); 
		System.out.println("Auslagern: Einlagerungszeit= "+ Paket.getEinLagZeit());
		
		if (CommandAction.CodeOK){
     		System.out.println( "Auslagern: Preis und Lagerzeit ermitteln");
     		EAPlatz.PreisfuerPaketberechnen(); 
     		EAPlatz.PreisfuerLagerzeitberechnen(); 
    		Display.PreisField.setText("Preis: " + Paket.getPreis());
    		Display.ZeitField.setText("Auslagerungszeit: " + Paket.getAusLagZeit());
    		Display.StatusField.setText("Bitte bezahlen Sie den Betrag!"); 
    		//Warten auf Kasse
    		System.out.println( "Auslagern: starte Stapler");
    		EAPlatz.Paketabholen(); 
    		System.out.println( "Auslagern: Klappe oeffnen");
    		Klappentuer.oeffnen(); 
    		System.out.println( "Auslagern: Packet entnommen");
    		System.out.println( "Auslagern: Klappe schliessen");
    		Klappentuer.schliessen();     		
    		System.out.println( "Auslagern: Auslagern beendet");
 	  		Display.StatusField.setText("Abholen: Aufwiedersehen"); 
 	  		InsertAction.freigabe=false;
 	  		CommandAction.freigabe=false;
  		}
   		
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
	  	
	  	Display.StatusField.setText("Einlagern: Beleg entnehmen");

	}
	public static void main(String[] args){

	}

}