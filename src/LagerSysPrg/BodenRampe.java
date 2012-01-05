package LagerSysPrg;
import java.util.*; 

public class BodenRampe {
	
	public int BodenRampenAdresse; 
	public ZustandRampe zustandRampe;
	private ZustandRampe BodenRampeZustand = new ZustandRampe();
	private Random generator = new Random(); 

	public BodenRampe(){  
	}
	
	public int GetBodenRampenZustand(){
		return BodenRampeZustand.getStatus(); 
	}
	
	public int GetBodenRampenAdresse(){
		return BodenRampenAdresse; 
	}
	
	public void ErstelleAdresse() {
		BodenRampenAdresse = generator.nextInt(255); 
		System.out.println("BodenRampe: BodenRampe mit der Adresse " + BodenRampenAdresse + " erstellt.");
	}

	public void BodenRampeausschalten(){
		System.out.println("BodenRampe: Die BodenRampe wird ausgeschaltet.");
		LagerMain.init.BodenRampenMotor.Motorausschalten(LagerMain.init.BodenRampenMotor.GetMotorAdresse());
		BodenRampeZustand.stoppen(); 
	}
	
	public void BodenRampeGeradeStellen(){
		System.out.println("BodenRampe: Die BodenRampe soll nach unten fahren");
		int Status = GetBodenRampenZustand(); 
		if(Status == 1){
			System.out.println("BodenRampe: Die BodenRampe ist bereits unten. ");
			return; 
		}		
		if(Status == 2){
			LagerMain.init.BodenRampenMotor.Motortieffahrenlassen(LagerMain.init.BodenRampenMotor.GetMotorAdresse()); 
			if(LagerMain.init.BodenRampeTaster_unten.WartenAufTaster()){
				System.out.println("BodenRampe: Die BodenRampe ist unten angekommen. ");
				LagerMain.init.BodenRampenMotor.Motorausschalten(LagerMain.init.BodenRampenMotor.GetMotorAdresse()); 
				BodenRampeZustand.stoppen(); 
			}
			else{
				System.out.println("BodenRampe: Fehler - Der Tasterunten wird nicht ausgelšst. ");
				LagerMain.init.BodenRampenMotor.Motorausschalten(LagerMain.init.BodenRampenMotor.GetMotorAdresse()); 
				BodenRampeZustand.stoppen(); 
			}
		} 
	}
	
	public void BodenRampeSchraegStellen(){
		System.out.println("BodenRampe: Die BodenRampe soll nach oben fahren");
		int Status = GetBodenRampenZustand(); 
		if(Status == 2){
			System.out.println("BodenRampe: Die BodenRampe ist bereits oben. ");
			return; 
		}	
		if(Status == 1){
			LagerMain.init.BodenRampenMotor.Motorhochfahrenlassen(LagerMain.init.BodenRampenMotor.GetMotorAdresse()); 
			if(LagerMain.init.BodenRampeTaster_oben.WartenAufTaster()){
				System.out.println("BodenRampe: Die BodenRampe ist oben angekommen. ");
				LagerMain.init.BodenRampenMotor.Motorausschalten(LagerMain.init.BodenRampenMotor.GetMotorAdresse()); 
				BodenRampeZustand.stoppen();
			}
			else{
				System.out.println("BodenRampe: Fehler - Der Tasteroben wird nicht ausgelšst. ");
				LagerMain.init.BodenRampenMotor.Motorausschalten(LagerMain.init.BodenRampenMotor.GetMotorAdresse()); 
				BodenRampeZustand.stoppen(); 
			}
		}
	}
	
	

}