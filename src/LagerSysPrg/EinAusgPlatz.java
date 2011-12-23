package LagerSysPrg;
import java.text.SimpleDateFormat;

import Simulation.*; 

public class EinAusgPlatz {

	private boolean istBelegt;
	public BodenRampe bodenRampe;
	public int BodenRampeMotorAdresse; 
	public KlappenTuer klappenTuer;
	public LichtsensorLeiste lichtsensorLeiste;
	public Gewichtsensor gewichtsensor; 
	private int EAPlatzAdresseDefault = 0; 
	public static int einausgabePlatzAdresse;
	private Packet paket; 
	private Lagerplatz Lagerplatz;
	private Stapler Stapler; 
	
	public EinAusgPlatz(){
		this.einausgabePlatzAdresse=ErstelleEinAusgabePlatzAdresse();
		System.out.println("Sim: "+einausgabePlatzAdresse+" erstellt");
		paket = new Packet(); 
		Lagerplatz = new Lagerplatz(paket); 
		Stapler = new Stapler(paket, Lagerplatz); 
		bodenRampe = new BodenRampe();
		BodenRampeMotorAdresse = bodenRampe.GetBodenRampenAdresse(); 
		klappenTuer = new KlappenTuer(); 
		lichtsensorLeiste = new LichtsensorLeiste(); 
		gewichtsensor = new Gewichtsensor(); 
	}
	
	private int ErstelleEinAusgabePlatzAdresse(){
		int xteEAPLatzAdresse = EAPlatzAdresseDefault +1; 
		System.out.println("EAPlatz mit der Adresse " + xteEAPLatzAdresse + "erstellt.");
		return xteEAPLatzAdresse;
	} 
	
	public boolean Paketannehmen(){ 
		if(klappenTuer.oeffnen()){
			System.out.println("EAPLatz: Die Klappentür wurde geöffnet.");
			//auf Button von der Gui warten
			System.out.println("EAPLatz: Der Button in der Gui wurde gedrückt.");
			if(klappenTuer.schliessen()){
				System.out.println("EAPLatz: Die Klappentür wurde geschlossen.");
				SimpleDateFormat time = new SimpleDateFormat("HH:mm");
				paket.setEinLagZeit(time); 
				int Paketgewicht = gewichtsensor.MesseGewicht(); 
				paket.setGewicht(Paketgewicht); 
				System.out.println("EAPLatz: Das Paket hat ein Gewicht von: "+ Paketgewicht);
				lichtsensorLeiste.MesseGroesse(); 
				int XPosition = lichtsensorLeiste.GetXPosition(); 
				int YPosition = lichtsensorLeiste.GetYPosition(); 
				int ZPosition = lichtsensorLeiste.GetZPosition(); 
				int Groesse = (XPosition + YPosition + ZPosition) / 3; 
				paket.setGroesse(Groesse); 
				Stapler.Paketaufnehmen();
				if(Stapler.StaplerfaehrtzurAusgabezurueck()){
					System.out.println("EAPlatz: Der Stapler ist wieder in Ausgangssituation."); 
				}
				else{
					System.out.println("EAPlatz: Der Stapler fährt wieder in Ausgangssituation."); 
				}
				return true; 
			}
			else{
				return false; 
			}
		}
		else{
			System.out.println("EAPLatz: Fehler - Die Klappentür kann nicht geöffnet werden.");
			return false; 
		}
	}
	
	public void PaketaufBRzumStaplerfahren(){
		bodenRampe.BodenRampeSchraegStellen(); 
		System.out.println("EAPLatz: Die Bodenrampe wurde aktiviert und fährt hoch zum Stapler.");
		
	}
	
	public void EAPLatzinAusgangsstellungBringen(){
		bodenRampe.BodenRampeGeradeStellen(); 
		bodenRampe.BodenRampeausschalten(); 
		System.out.println("EAPLatz: Die Bodenrampe wurde deaktiviert und der EAPlatz ist in Wartestellung.");
	}


}