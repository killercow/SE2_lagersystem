package LagerSysPrg;
import Simulation.*; 

public class KlappenTuer {

	public Motor KlappentuerMotor;
	private int KlappentuerMotorAdresse; 
	public ZustandTuer KlappentuerZustand = new ZustandTuer();
	public Taster Taster_auf;
	private int Taster_auf_Adresse; 
	public Taster Taster_zu;
	private int Taster_zu_Adresse; 
	private boolean Klappentueristoffen = false; 

	public KlappenTuer(){
	}
	
	public int GetKlappentuerStatus(){
		return KlappentuerZustand.getStatus(); 
	}

	public boolean oeffnen(){
		if(GetKlappentuerStatus() == 1){
			System.out.println("KlappenTuer: Die Klappentür ist offen!"); 
			return Klappentueristoffen = true;
		}
		else{
			System.out.println("KlappenTuer: Die Klappentür wird geöffnet!");
			KlappentuerMotor.Motorvorwaertsfahrenlassen(KlappentuerMotorAdresse); 
			if(Taster_auf.WartenAufTaster()){
				System.out.println("KlappenTuer: Die Klappentür ist geöffnet!");
				KlappentuerMotor.Motorausschalten(KlappentuerMotorAdresse); 
				KlappentuerZustand.setStatus(1); 
				return Klappentueristoffen = true; 
			}
			else{
				System.out.println("KlappenTuer: Die Klappentürtaster hat einen Fehler!");
				KlappentuerMotor.Motorausschalten(KlappentuerMotorAdresse); 
				return Klappentueristoffen = false; 
			}
		}
		
	}

	public boolean schliessen(){
		if(GetKlappentuerStatus() == 0){
			System.out.println("KlappenTuer: Die Klappentür ist geschlossen!"); 
			return Klappentueristoffen = false;
		}
		else{
			System.out.println("KlappenTuer: Die Klappentür wird geschlossen!");
			KlappentuerMotor.Motorrueckwaertsfahrenlassen(KlappentuerMotorAdresse); 
			if(Taster_zu.WartenAufTaster()){
				System.out.println("KlappenTuer: Die Klappentür ist geschlossen!");
				KlappentuerMotor.Motorausschalten(KlappentuerMotorAdresse); 
				KlappentuerZustand.setStatus(0); 
				return Klappentueristoffen = false; 
			}
			else{
				System.out.println("KlappenTuer: Die Klappentürtaster hat einen Fehler!");
				KlappentuerMotor.Motorausschalten(KlappentuerMotorAdresse); 
				return Klappentueristoffen = true; 
			}
		}
	}

}