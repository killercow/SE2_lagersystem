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
	
	public boolean GetIstInBewegung(){
		return BodenRampeZustand.GetIstinBewegung(); 
	}
	
	public int GetBodenRampenAdresse(){
		return BodenRampenAdresse; 
	}
	
	private int ErstelleAdresse() {
		int xteBodenRampenAdresse = BodenRampenAdresseDefault +1; 
		System.out.println("BodenRampe: BodenRampe mit der Adresse " + xteBodenRampenAdresse + "erstellt.");
		return xteBodenRampenAdresse;
	}

	public void BodenRampeausschalten(){
		System.out.println("BodenRampe: Die BodenRampe wird ausgeschaltet.");
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
			bodenRampenMotor.Motortieffahrenlassen(bodenRampenMotorAdresse); 
			
			BodenRampeZustand.stoppen(); 
		}
		BodenRampeZustand.gerade(); 
		
	}
	
	public void BodenRampeSchraegStellen(){
		System.out.println("BodenRampe: Die BodenRampe soll nach oben fahren");
		int Status = GetBodenRampenZustand(); 
		if(Status == 2){
			System.out.println("BodenRampe: Die BodenRampe ist bereits oben. ");
			return; 
		}	
		if(Status == 1){
			bodenRampenMotor.Motorhochfahrenlassen(bodenRampenMotorAdresse); 
			
			BodenRampeZustand.stoppen(); 
		}
		BodenRampeZustand.schraeg(); 
	}
	
	

}