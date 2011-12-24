
package LagerSysPrg;
import Simulation.*; 
import java.util.*; 

public class Stapler {
	public Lagerplatz Lagerplatz; 
	public Laufband laufband;
	public int LaufbandMotorAdresse;
	
	private Motor motorXRichtung;
	private static int motorXRichtungAdresse; 
	private Motor motorYRichtung;
	private static int motorYRichtungAdresse; 
	
	public Simulation.Motor motorXRichtungSimulation;
	public Simulation.Motor motorYRichtungSimulation;
	

	private int StaplerAdresse;
	private boolean MotorfaehrtinXRichtung = false; 
	private boolean MotorfaehrtinXRichtungrueckwarts = false; 
	private boolean MotorfaehrtinYRichtunghoch = false;
	private int MotorStatus; 
	private Paket paket; 
	private int Lagerplatznummer; 
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
	
	public void ZumLagerplatzfahren(){
		StaplerRichtunguebergeben('r');
		Lagerplatznummer = Lagerplatz.GetLagerplatznummer(); 
		Lagerplatz.StaplerKommtMitPaket(); 
		System.out.println("Stapler: Stapler ist am Lagerplatz "+ Lagerplatznummer +" angekommen.");
		motorXRichtung.Motorausschalten(motorXRichtungAdresse);
		PaketaufnehmenvomLagerplatz(); 
	}
	

	public boolean PaketaufnehmenvomLagerplatz() {
		if(laufband.LaufbandMotor.GetMotorStatus() == 0){
			laufband.LaufbandMotor.Motorvorwaertsfahrenlassen(LaufbandMotorAdresse); 
		}
		else{
			if(laufband.LaufbandMotor.GetMotorStatus() == 2){
				laufband.LaufbandMotor.Motorausschalten(LaufbandMotorAdresse); 
				laufband.LaufbandMotor.Motorvorwaertsfahrenlassen(LaufbandMotorAdresse); 
			}
		}
		System.out.println("Stapler: Paket liegt auf dem Laufband."); 
		laufband.LaufbandMotor.Motorausschalten(LaufbandMotorAdresse); 
		boolean istda = StaplerfaehrtzurAusgabezurueck();
		return istda; 
	}

	public boolean PaketinAusgabeablegen() {
		StaplerRichtunguebergeben('h');
		laufband.LaufbandMotor.Motorvorwaertsfahrenlassen(LaufbandMotorAdresse);
		return true; 
	}

	public void Paketaufnehmen(){
		if(laufband.LaufbandMotor.GetMotorStatus() == 0){
			laufband.LaufbandMotor.Motorvorwaertsfahrenlassen(LaufbandMotorAdresse); 
		}
		else{
			if(laufband.LaufbandMotor.GetMotorStatus() == 2){
				laufband.LaufbandMotor.Motorausschalten(LaufbandMotorAdresse); 
				laufband.LaufbandMotor.Motorvorwaertsfahrenlassen(LaufbandMotorAdresse); 
			}
		}
		System.out.println("Stapler: Paket liegt auf dem Laufband."); 
		laufband.LaufbandMotor.Motorausschalten(LaufbandMotorAdresse); 
		StaplerfahertmitPaketzumLagerplatz(); 
	}
	
	private void StaplerfahertmitPaketzumLagerplatz(){
		StaplerRichtunguebergeben('r');
		Lagerplatznummer = Lagerplatz.GetLagerplatznummer(); 
		Lagerplatz.StaplerKommtMitPaket(); 
		System.out.println("Stapler: Stapler ist am Lagerplatz "+ Lagerplatznummer +" angekommen.");
		motorXRichtung.Motorausschalten(motorXRichtungAdresse);
		Paketablegen(); 		
	}

	private void Paketablegen(){
		StaplerRichtunguebergeben('h');
		laufband.LaufbandMotor.Motorvorwaertsfahrenlassen(LaufbandMotorAdresse);
		Lagerplatz.PaketaufBRlegen(); 
		System.out.println("Stapler: Paket liegt im Lagerplatz.");
		laufband.LaufbandMotor.Motorausschalten(LaufbandMotorAdresse);
		StaplerRichtunguebergeben('t');
		StaplerfaehrtzurAusgabezurueck(); 
	}
	
	public boolean StaplerfaehrtzurAusgabezurueck(){
		StaplerRichtunguebergeben('v');
		System.out.println("Stapler: Stapler ist an der Ausgabe angekommen.");
		motorXRichtung.Motorausschalten(motorXRichtungAdresse);
		return true; 
	}
	
	public boolean FaehrtMotorXRichtungrueckwaerts(){
		return MotorfaehrtinXRichtungrueckwarts; 
	}
	
	public boolean FaehrtMotorXRichtunghoch(){
		return MotorfaehrtinYRichtunghoch; 
	}

	public void InXRichtungFahren(char richtung){
		if(StehtDerMotor(motorXRichtung)){
			if(richtung == 'r'){
				motorXRichtung.Motorrueckwaertsfahrenlassen(motorXRichtungAdresse); 
				MotorfaehrtinXRichtungrueckwarts = true;
				
			}
			if(richtung == 'v'){
				motorXRichtung.Motorvorwaertsfahrenlassen(motorXRichtungAdresse); 
				MotorfaehrtinXRichtungrueckwarts = false;
			}
		}
		else{
			if(motorXRichtung.GetMotorStatus() == 2){
				motorXRichtung.Motorausschalten(motorXRichtungAdresse); 
				if(richtung == 'r'){
					motorXRichtung.Motorrueckwaertsfahrenlassen(motorXRichtungAdresse); 
					MotorfaehrtinXRichtungrueckwarts = true;
					
				}
				if(richtung == 'v'){
					motorXRichtung.Motorvorwaertsfahrenlassen(motorXRichtungAdresse); 
					MotorfaehrtinXRichtungrueckwarts = false;
				}
			}
						
		}
	}

	public void InYRichtungfahren(char richtung){
		if(StehtDerMotor(motorYRichtung)){
			if(richtung == 'r'){
				motorYRichtung.Motorhochfahrenlassen(motorYRichtungAdresse); 
				MotorfaehrtinYRichtunghoch = true;
				
			}
			if(richtung == 'v'){
				motorYRichtung.Motorvorwaertsfahrenlassen(motorYRichtungAdresse); 
				MotorfaehrtinYRichtunghoch = false;
			}
		}
		else{
			if(motorYRichtung.GetMotorStatus() == 1){
				motorYRichtung.Motorausschalten(motorYRichtungAdresse);
				if(richtung == 'r'){
					motorYRichtung.Motorhochfahrenlassen(motorYRichtungAdresse); 
					MotorfaehrtinYRichtunghoch = true;
					
				}
				if(richtung == 'v'){
					motorYRichtung.Motorvorwaertsfahrenlassen(motorYRichtungAdresse); 
					MotorfaehrtinYRichtunghoch = false;
				}
			}			
		}
	}

}