package LagerSysPrg;

public class KlappenTuer {

	public ZustandTuer KlappentuerZustand = new ZustandTuer();
	private boolean Klappentueristoffen = false; 

	public KlappenTuer(){
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
			LagerMain.init.KlappentuerMotor.Motorvorwaertsfahrenlassen(LagerMain.init.KlappentuerMotor.GetMotorAdresse()); 
			if(LagerMain.init.KlappentuerTaster_auf.WartenAufTaster()){
				System.out.println("KlappenTuer: Die Klappent�r ist ge�ffnet!");
				LagerMain.init.KlappentuerMotor.Motorausschalten(LagerMain.init.KlappentuerMotor.GetMotorAdresse()); 
				KlappentuerZustand.setStatus(1); 
				return Klappentueristoffen = true; 
			}
			else{
				System.out.println("KlappenTuer: Die Klappent�rtaster hat einen Fehler!");
				LagerMain.init.KlappentuerMotor.Motorausschalten(LagerMain.init.KlappentuerMotor.GetMotorAdresse()); 
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
			LagerMain.init.KlappentuerMotor.Motorrueckwaertsfahrenlassen(LagerMain.init.KlappentuerMotor.GetMotorAdresse()); 
			if(LagerMain.init.KlappentuerTaster_zu.WartenAufTaster()){
				System.out.println("KlappenTuer: Die Klappent�r ist geschlossen!");
				LagerMain.init.KlappentuerMotor.Motorausschalten(LagerMain.init.KlappentuerMotor.GetMotorAdresse()); 
				KlappentuerZustand.setStatus(0); 
				return Klappentueristoffen = false; 
			}
			else{
				System.out.println("KlappenTuer: Die Klappent�rtaster hat einen Fehler!");
				LagerMain.init.KlappentuerMotor.Motorausschalten(LagerMain.init.KlappentuerMotor.GetMotorAdresse()); 
				return Klappentueristoffen = true; 
			}
		}
	}

}