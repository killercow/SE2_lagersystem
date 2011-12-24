package LagerSysPrg;
import Simulation.*; 
import java.util.*;

public class Laufband {

	public Motor LaufbandMotor;	
	public boolean bewegungvor = true; 
	private int LaufbandAdresse; 
	public static int Motor_AdresseLaufband; 
	private int MotorStatus;
	private Random generator = new Random();

	public Laufband(){
	}
	
	public void ErstelleLaufbandAdresse(){
		LaufbandAdresse= generator.nextInt(255); 
		System.out.println("Laufband: Laufband mit der Adresse " + LaufbandAdresse + " erstellt.");
	}
	
	public boolean StehtderMotor(){
		MotorStatus = LaufbandMotor.GetMotorStatus(); 
		if(MotorStatus == 0){
			return true; 
		}else{
			return false; 
		}
	}
	
	public boolean bewegtSichLaufbandVor(){
		return bewegungvor; 
	}

	public void Bewegungvorwaerts(){
		if(StehtderMotor()){
			LaufbandMotor.Motorvorwaertsfahrenlassen(Motor_AdresseLaufband); 
		}
		else{
			if(LaufbandMotor.GetMotorStatus() == 2){
				LaufbandMotor.Motorausschalten(Motor_AdresseLaufband); 
				LaufbandMotor.Motorvorwaertsfahrenlassen(Motor_AdresseLaufband); 
			}
		}
		System.out.println("Laufband: Laufband läuft jetzt vorwärts"); 
		bewegungvor = true; 
	}

	public void Bewegungrueckwaerts(){
		if(StehtderMotor()){
			LaufbandMotor.Motorrueckwaertsfahrenlassen(Motor_AdresseLaufband); 
		}
		else{
			if(LaufbandMotor.GetMotorStatus() == 1){
				LaufbandMotor.Motorausschalten(Motor_AdresseLaufband); 
				LaufbandMotor.Motorrueckwaertsfahrenlassen(Motor_AdresseLaufband); 
			}
		}
		System.out.println("Laufband: Laufband läuft jetzt rückwärts"); 
		bewegungvor = false; 
	}
	
	public void LaufbandmotorAusschalten(){
		LaufbandMotor.Motorausschalten(Motor_AdresseLaufband); 
	}

}