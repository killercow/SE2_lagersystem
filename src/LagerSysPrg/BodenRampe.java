package LagerSysPrg;
import Simulation.*;

public class BodenRampe {
	
	public static int BodenRampenAdresse;
	private int BodenRampenAdresseDefault = 0; 
	public Motor bodenRampenMotor;
	private int bodenRampenMotorAdresse; 
	public ZustandRampe zustandRampe;
	private boolean Zustand;
	private Taster Tasteroben;
	private int TasterobenAdresse; 
	private Taster Tasterunten;
	private int TasteruntenAdresse; 
	private ZustandRampe BodenRampeZustand = new ZustandRampe(); 

	public BodenRampe(){
		this.BodenRampenAdresse= ErstelleAdresse();
		System.out.println("Sim: Bodenrampe "+ BodenRampenAdresse +" ertsellen");
		bodenRampenMotor = new Motor(); 
		bodenRampenMotorAdresse = bodenRampenMotor.GetMotorAdresse(); 
		bodenRampenMotor = new Simulation.Motor();
		Tasteroben = new Taster();
		TasterobenAdresse = Tasteroben.GetTasterAdresse(); 
		Tasterunten = new Taster(); 
		TasteruntenAdresse = Tasterunten.GetTasterAdresse(); 
		
	}
	
	public int GetBodenRampenZustand(){
		return BodenRampeZustand.getStatus(); 
	}
	
	public int GetBodenRampenAdresse(){
		return BodenRampenAdresse; 
	}
	
	private int ErstelleAdresse() {
		int xteBodenRampenAdresse = BodenRampenAdresseDefault +1; 
		System.out.println("BodenRampe mit der Adresse " + xteBodenRampenAdresse + "erstellt.");
		return xteBodenRampenAdresse;
	}

	public void BodenRampeausschalten(){
		System.out.println("Die BodenRampe wird ausgeschaltet.");
		BodenRampeZustand.stoppen(); 
	}
	
	public void BodenRampeGeradeStellen(){
		System.out.println("Die BodenRampe soll nach unten fahren");
		int Status = GetBodenRampenZustand(); 
		if(Status == 2){
			BodenRampeZustand.stoppen(); 
		}
		BodenRampeZustand.gerade(); 
	}
	
	public void BodenRampeSchraegStellen(){
		System.out.println("Die BodenRampe soll nach oben fahren");
		int Status = GetBodenRampenZustand(); 
		if(Status == 1){
			BodenRampeZustand.stoppen(); 
		}
		BodenRampeZustand.schraeg(); 
	}
	
	

}