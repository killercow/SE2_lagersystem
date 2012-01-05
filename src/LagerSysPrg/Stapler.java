
package LagerSysPrg;
import Simulation.*; 
import java.util.*; 

public class Stapler {

	private int StaplerAdresse;
	private boolean MotorfaehrtinXRichtung = false; 
	private boolean MotorfaehrtinXRichtungrueckwarts = false; 
	private boolean MotorfaehrtinYRichtunghoch = false;
	private int MotorStatus; 
	private Random generator = new Random(); 
	
	public Stapler(){
	}
	
	public void ErstelleStaplerAdresse(){
		StaplerAdresse = generator.nextInt(255); 
		System.out.println("Stapler: Stapler mit der Adresse " + StaplerAdresse + " erstellt.");
	}
	
	public boolean StehtDerMotor(Motor motor){
		MotorStatus = motor.GetMotorStatus();
		if(MotorStatus == 0){
			return true; 
		}
		else{
			return false; 
		}
	}
	
	public void StaplerRichtunguebergeben(char richtung){
		if(richtung == 'r'){
			InXRichtungFahren('r'); 
		}
		if(richtung == 'v'){
			InXRichtungFahren('v'); 
		}
		if(richtung == 'h'){
			InYRichtungfahren('h'); 
		}
		if(richtung =='t'){
			InYRichtungfahren('t'); 
		}
	}
	
	public void ZumLagerplatzfahren(int lagerplatzNummer){
		StaplerRichtunguebergeben('r');
		Lagerplatz lagerplatz = FindeLagerplatzAusArray(lagerplatzNummer); 
		lagerplatz.StaplerKommtMitPaket(); 
		System.out.println("Stapler: Stapler ist am Lagerplatz "+ lagerplatzNummer +" angekommen.");
		LagerMain.init.StaplerMotorXRichtung.Motorausschalten(LagerMain.init.StaplerMotorXRichtung.GetMotorAdresse());
		PaketaufnehmenvomLagerplatz(); 
	}
	

	public boolean PaketaufnehmenvomLagerplatz() {
		if(LagerMain.init.LaufbandMotor.GetMotorStatus() == 0){
			LagerMain.init.LaufbandMotor.Motorvorwaertsfahrenlassen(LagerMain.init.LaufbandMotor.GetMotorAdresse()); 
		}
		else{
			if(LagerMain.init.LaufbandMotor.GetMotorStatus() == 2){
				LagerMain.init.LaufbandMotor.Motorausschalten(LagerMain.init.LaufbandMotor.GetMotorAdresse()); 
				LagerMain.init.LaufbandMotor.Motorvorwaertsfahrenlassen(LagerMain.init.LaufbandMotor.GetMotorAdresse()); 
			}
		}
		System.out.println("Stapler: Paket liegt auf dem Laufband."); 
		LagerMain.init.LaufbandMotor.Motorausschalten(LagerMain.init.LaufbandMotor.GetMotorAdresse()); 
		boolean istda = StaplerfaehrtzurAusgabezurueck();
		return istda; 
	}

	public boolean PaketinAusgabeablegen() {
		StaplerRichtunguebergeben('h');
		LagerMain.init.LaufbandMotor.Motorvorwaertsfahrenlassen(LagerMain.init.LaufbandMotor.GetMotorAdresse());
		return true; 
	}

	public void Paketaufnehmen(){
		if(LagerMain.init.LaufbandMotor.GetMotorStatus() == 0){
			LagerMain.init.LaufbandMotor.Motorvorwaertsfahrenlassen(LagerMain.init.LaufbandMotor.GetMotorAdresse()); 
		}
		else{
			if(LagerMain.init.LaufbandMotor.GetMotorStatus() == 2){
				LagerMain.init.LaufbandMotor.Motorausschalten(LagerMain.init.LaufbandMotor.GetMotorAdresse()); 
				LagerMain.init.LaufbandMotor.Motorvorwaertsfahrenlassen(LagerMain.init.LaufbandMotor.GetMotorAdresse()); 
			}
		}
		System.out.println("Stapler: Paket liegt auf dem Laufband."); 
		LagerMain.init.LaufbandMotor.Motorausschalten(LagerMain.init.LaufbandMotor.GetMotorAdresse()); 
	}
	
	private Lagerplatz FindeLagerplatzAusArray(int lagerplatzNummer){
		for(int i  = 0; i < 6; i++){
			if(LagerMain.init.Lagerplatzarray[i].GetLagerplatznummer() == lagerplatzNummer ){
				return LagerMain.init.Lagerplatzarray[i]; 
			}
		}
		return null; 
	}
	
	public void StaplerfahertmitPaketzumLagerplatz(int lagerplatzNummer){
		StaplerRichtunguebergeben('r');
		Lagerplatz lagerplatz = FindeLagerplatzAusArray(lagerplatzNummer); 
		lagerplatz.StaplerKommtMitPaket(); 
		System.out.println("Stapler: Stapler ist am Lagerplatz "+ lagerplatzNummer +" angekommen.");
		LagerMain.init.StaplerMotorXRichtung.Motorausschalten(LagerMain.init.StaplerMotorXRichtung.GetMotorAdresse());
		Paketablegen(lagerplatz); 		
	}

	private void Paketablegen(Lagerplatz lagerplatz){
		StaplerRichtunguebergeben('h');
		LagerMain.init.LaufbandMotor.Motorvorwaertsfahrenlassen(LagerMain.init.LaufbandMotor.GetMotorAdresse());
		lagerplatz.PaketaufBRlegen(); 
		System.out.println("Stapler: Paket liegt im Lagerplatz.");
		LagerMain.init.LaufbandMotor.Motorausschalten(LagerMain.init.LaufbandMotor.GetMotorAdresse());
		StaplerRichtunguebergeben('t');
		StaplerfaehrtzurAusgabezurueck(); 
	}
	
	public boolean StaplerfaehrtzurAusgabezurueck(){
		StaplerRichtunguebergeben('v');
		System.out.println("Stapler: Stapler ist an der Ausgabe angekommen.");
		LagerMain.init.StaplerMotorXRichtung.Motorausschalten(LagerMain.init.StaplerMotorXRichtung.GetMotorAdresse());
		return true; 
	}
	
	public boolean FaehrtMotorXRichtungrueckwaerts(){
		return MotorfaehrtinXRichtungrueckwarts; 
	}
	
	public boolean FaehrtMotorXRichtunghoch(){
		return MotorfaehrtinYRichtunghoch; 
	}

	public void InXRichtungFahren(char richtung){
		if(StehtDerMotor(LagerMain.init.StaplerMotorXRichtung)){
			if(richtung == 'r'){
				LagerMain.init.StaplerMotorXRichtung.Motorrueckwaertsfahrenlassen(LagerMain.init.StaplerMotorXRichtung.GetMotorAdresse()); 
				MotorfaehrtinXRichtungrueckwarts = true;
				
			}
			if(richtung == 'v'){
				LagerMain.init.StaplerMotorXRichtung.Motorvorwaertsfahrenlassen(LagerMain.init.StaplerMotorXRichtung.GetMotorAdresse()); 
				MotorfaehrtinXRichtungrueckwarts = false;
			}
		}
		else{
			if(LagerMain.init.StaplerMotorXRichtung.GetMotorStatus() == 2){
				LagerMain.init.StaplerMotorXRichtung.Motorausschalten(LagerMain.init.StaplerMotorXRichtung.GetMotorAdresse()); 
				if(richtung == 'r'){
					LagerMain.init.StaplerMotorXRichtung.Motorrueckwaertsfahrenlassen(LagerMain.init.StaplerMotorXRichtung.GetMotorAdresse()); 
					MotorfaehrtinXRichtungrueckwarts = true;
					
				}
				if(richtung == 'v'){
					LagerMain.init.StaplerMotorXRichtung.Motorvorwaertsfahrenlassen(LagerMain.init.StaplerMotorXRichtung.GetMotorAdresse()); 
					MotorfaehrtinXRichtungrueckwarts = false;
				}
			}
						
		}
	}

	public void InYRichtungfahren(char richtung){
		if(StehtDerMotor(LagerMain.init.StaplerMotorYRichtung)){
			if(richtung == 'r'){
				LagerMain.init.StaplerMotorYRichtung.Motorhochfahrenlassen(LagerMain.init.StaplerMotorYRichtung.GetMotorAdresse()); 
				MotorfaehrtinYRichtunghoch = true;
				
			}
			if(richtung == 'v'){
				LagerMain.init.StaplerMotorYRichtung.Motorvorwaertsfahrenlassen(LagerMain.init.StaplerMotorYRichtung.GetMotorAdresse()); 
				MotorfaehrtinYRichtunghoch = false;
			}
		}
		else{
			if(LagerMain.init.StaplerMotorYRichtung.GetMotorStatus() == 1){
				LagerMain.init.StaplerMotorYRichtung.Motorausschalten(LagerMain.init.StaplerMotorYRichtung.GetMotorAdresse());
				if(richtung == 'r'){
					LagerMain.init.StaplerMotorYRichtung.Motorhochfahrenlassen(LagerMain.init.StaplerMotorYRichtung.GetMotorAdresse()); 
					MotorfaehrtinYRichtunghoch = true;
					
				}
				if(richtung == 'v'){
					LagerMain.init.StaplerMotorYRichtung.Motorvorwaertsfahrenlassen(LagerMain.init.StaplerMotorYRichtung.GetMotorAdresse()); 
					MotorfaehrtinYRichtunghoch = false;
				}
			}			
		}
	}

}