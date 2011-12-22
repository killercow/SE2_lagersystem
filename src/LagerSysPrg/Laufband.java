package LagerSysPrg;
import Simulation.*; 

public class Laufband {

	public Motor LaufbandMotor_Simulation;
	public Motor LaufbandMotor;	
	public boolean bewegungvor = true; 
	private int LaufbandAdresse; 
	private static int LaufbandAdresseDefault = 0; 
	public static int Motor_AdresseLaufband; 
	private int MotorStatus; 

	public Laufband(){
		this.LaufbandAdresse = ErstelleLaufbandAdresse(); 
		System.out.println("Sim: Laufband "+LaufbandAdresse+" erstellt");
		LaufbandMotor = new Motor();
		Motor_AdresseLaufband = Motor.GetMotorAdresse(); 
		LaufbandMotor_Simulation = new Simulation.Motor();
	}
	
	private int ErstelleLaufbandAdresse(){
		int xteLaufbandAdresse = LaufbandAdresseDefault +1; 
		System.out.println("Laufband: Laufband mit der Adresse " + xteLaufbandAdresse + "erstellt.");
		return xteLaufbandAdresse;
	}

	public void finalize()
	  throws Throwable{

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