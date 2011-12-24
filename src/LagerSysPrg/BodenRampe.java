package LagerSysPrg;
import Simulation.*;
import java.util.*; 

public class BodenRampe {
	
	public int BodenRampenAdresse; 
	public Motor bodenRampenMotor;
	private int bodenRampenMotorAdresse; 
	public ZustandRampe zustandRampe;
	private boolean Zustand;
	private Taster Tasteroben;
	private int TasterobenAdresse; 
	private Taster Tasterunten;
	private int TasteruntenAdresse; 
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
		bodenRampenMotor.Motorausschalten(bodenRampenMotorAdresse);
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
			if(Tasterunten.WartenAufTaster()){
				System.out.println("BodenRampe: Die BodenRampe ist unten angekommen. ");
				bodenRampenMotor.Motorausschalten(bodenRampenMotorAdresse); 
				BodenRampeZustand.stoppen(); 
			}
			else{
				System.out.println("BodenRampe: Fehler - Der Tasterunten wird nicht ausgelšst. ");
				bodenRampenMotor.Motorausschalten(bodenRampenMotorAdresse); 
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
			bodenRampenMotor.Motorhochfahrenlassen(bodenRampenMotorAdresse); 
			if(Tasteroben.WartenAufTaster()){
				System.out.println("BodenRampe: Die BodenRampe ist oben angekommen. ");
				bodenRampenMotor.Motorausschalten(bodenRampenMotorAdresse); 
				BodenRampeZustand.stoppen();
			}
			else{
				System.out.println("BodenRampe: Fehler - Der Tasteroben wird nicht ausgelšst. ");
				bodenRampenMotor.Motorausschalten(bodenRampenMotorAdresse); 
				BodenRampeZustand.stoppen(); 
			}
		}
	}
	
	

}