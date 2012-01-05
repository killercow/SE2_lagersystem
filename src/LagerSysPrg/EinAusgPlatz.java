package LagerSysPrg;
import java.util.*;


public class EinAusgPlatz {

	public static int einausgabePlatzAdresse;
	private int EAPlatzAdresse; 
	private Random generator = new Random(); 
	
	public EinAusgPlatz(){
	}
	
	public void ErstelleEinAusgabePlatzAdresse(){
		EAPlatzAdresse = generator.nextInt(255); 
		System.out.println("EAPlatz mit der Adresse " + EAPlatzAdresse + " erstellt.");
	} 
	
	public void Paketabholen(){	
		if(LagerMain.init.Klappentuer.schliessen()){
			LagerMain.init.Klappentuer.oeffnen(); 
		}

	}
	
	public void Paketannehmen(){ 
		if(LagerMain.init.Klappentuer.oeffnen()){
			System.out.println("EAPLatz: Die Klappentür wurde geöffnet.");
			//auf Button von der Gui warten
			System.out.println("EAPLatz: Der Button in der Gui wurde gedrückt.");
			if(LagerMain.init.Klappentuer.schliessen())
				System.out.println("EAPLatz: Die Klappentür wurde geschlossen.");
		} 
	}
	
	
	public void PaketaufBRzumStaplerfahren(){
		LagerMain.init.BodenRampeEAPlatz.BodenRampeSchraegStellen(); 
		System.out.println("EAPLatz: Die Bodenrampe wurde aktiviert und fährt hoch zum Stapler.");
		
	}
	
	public void EAPLatzinAusgangsstellungBringen(){
		LagerMain.init.BodenRampeEAPlatz.BodenRampeGeradeStellen(); 
		LagerMain.init.BodenRampeEAPlatz.BodenRampeausschalten(); 
		System.out.println("EAPLatz: Die Bodenrampe wurde deaktiviert und der EAPlatz ist in Wartestellung.");
	}


}