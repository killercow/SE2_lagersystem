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
		KlappentuerMotor = new Motor(); 
		KlappentuerMotorAdresse = KlappentuerMotor.GetMotorAdresse(); 
		Taster_auf = new Taster(); 
		Taster_auf_Adresse = Taster_auf.GetTasterAdresse(); 
		Taster_zu = new Taster(); 
		Taster_zu_Adresse = Taster_zu.GetTasterAdresse(); 
	}
	
	public int GetKlappentuerStatus(){
		return KlappentuerZustand.getStatus(); 
	}

	public boolean oeffnen(){
		if(GetKlappentuerStatus() == 1){
			System.out.println("KlappenTuer: Die Klappent�r ist offen!"); 
			return Klappentueristoffen = true;
		}
		else{
			System.out.println("KlappenTuer: Die Klappent�r wird ge�ffnet!");
			KlappentuerMotor.Motorvorwaertsfahrenlassen(KlappentuerMotorAdresse); 
			if(Taster_auf.WartenAufTaster()){
				System.out.println("KlappenTuer: Die Klappent�r ist ge�ffnet!");
				KlappentuerMotor.Motorausschalten(KlappentuerMotorAdresse); 
				KlappentuerZustand.setStatus(1); 
				return Klappentueristoffen = true; 
			}
			else{
				System.out.println("KlappenTuer: Die Klappent�rtaster hat einen Fehler!");
				KlappentuerMotor.Motorausschalten(KlappentuerMotorAdresse); 
				return Klappentueristoffen = false; 
			}
		}
		
	}

	public boolean schliessen(){
		if(GetKlappentuerStatus() == 0){
			System.out.println("KlappenTuer: Die Klappent�r ist geschlossen!"); 
			return Klappentueristoffen = false;
		}
		else{
			System.out.println("KlappenTuer: Die Klappent�r wird geschlossen!");
			KlappentuerMotor.Motorrueckwaertsfahrenlassen(KlappentuerMotorAdresse); 
			if(Taster_zu.WartenAufTaster()){
				System.out.println("KlappenTuer: Die Klappent�r ist geschlossen!");
				KlappentuerMotor.Motorausschalten(KlappentuerMotorAdresse); 
				KlappentuerZustand.setStatus(0); 
				return Klappentueristoffen = false; 
			}
			else{
				System.out.println("KlappenTuer: Die Klappent�rtaster hat einen Fehler!");
				KlappentuerMotor.Motorausschalten(KlappentuerMotorAdresse); 
				return Klappentueristoffen = true; 
			}
		}
	}

}