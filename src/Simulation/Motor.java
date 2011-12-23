package Simulation;
import java.util.*;

public class Motor{

	private static int MotorAdresse;
	private static int MotorAdresseDefault = 0; 
	private MotorZustand MotorStatus = new MotorZustand(); 

	public Motor(){
		this.MotorAdresse = ErstelleMotoradresse(); 
	}
	
	public int GetMotorStatus(){
		return MotorStatus.getStatus(); 
	}
	
	public static int GetMotorAdresse(){
		return MotorAdresse; 
	}
	
	private int ErstelleMotoradresse(){
		Random generator = new Random(); 
		int xteMotorAdresse = MotorAdresseDefault + generator.nextInt(255);
		System.out.println("Motor: Motor mit der Adresse " + xteMotorAdresse + " erstellt.");
		return xteMotorAdresse; 
	}
	
	public void Motorvorwaertsfahrenlassen(int MotorAdresse){
		System.out.println("Motor: Der Motor mit der Adresse " + MotorAdresse + " soll vorwärts fahren.");
		int Status = GetMotorStatus(); 
		if(Status == 2){
			MotorStatus.Stoppen(); 
		}
		MotorStatus.Rechts(); 
	}
	
	public void Motorrueckwaertsfahrenlassen(int MotorAdresse){
		System.out.println("Motor: Der Motor mit der Adresse " + MotorAdresse + " soll rückwärts fahren.");
		int Status = GetMotorStatus(); 
		if(Status == 1){
			MotorStatus.Stoppen(); 
		}
		MotorStatus.Links(); 
	}
	
	public void Motorhochfahrenlassen(int MotorAdresse){
		System.out.println("Motor: Der Motor mit der Adresse " + MotorAdresse + " soll hoch fahren.");
		int Status = GetMotorStatus(); 
		if(Status == 2){
			MotorStatus.Stoppen(); 
		}
		MotorStatus.Rechts(); 
	}
	
	public void Motortieffahrenlassen(int MotorAdresse){
		System.out.println("Motor: Der Motor mit der Adresse " + MotorAdresse + " soll tief fahren.");
		int Status = GetMotorStatus(); 
		if(Status == 1){
			MotorStatus.Stoppen(); 
		}
		MotorStatus.Links(); 
	}

	public void Motorausschalten(int MotorAdresse){
		System.out.println("Motor: Der Motor mit der Adresse " + MotorAdresse + " wird ausgeschaltet.");
		MotorStatus.Stoppen(); 
	}


}