package LagerSysPrg;
import Simulation.*; 
import java.util.*;

public class Laufband {

	public boolean bewegungvor = true; 
	private int LaufbandAdresse; 
	private int MotorStatus;
	private Random generator = new Random();

	public Laufband(){
	}
	
	public void ErstelleLaufbandAdresse(){
		LaufbandAdresse= generator.nextInt(255); 
		System.out.println("Laufband: Laufband mit der Adresse " + LaufbandAdresse + " erstellt.");
	}
	
	public boolean StehtderMotor(){
		MotorStatus = LagerMain.init.LaufbandMotor.GetMotorStatus(); 
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
			LagerMain.init.LaufbandMotor.Motorvorwaertsfahrenlassen(LagerMain.init.LaufbandMotor.GetMotorAdresse()); 
		}
		else{
			if(LagerMain.init.LaufbandMotor.GetMotorStatus() == 2){
				LagerMain.init.LaufbandMotor.Motorausschalten(LagerMain.init.LaufbandMotor.GetMotorAdresse()); 
				LagerMain.init.LaufbandMotor.Motorvorwaertsfahrenlassen(LagerMain.init.LaufbandMotor.GetMotorAdresse()); 
			}
		}
		System.out.println("Laufband: Laufband l�uft jetzt vorw�rts"); 
		bewegungvor = true; 
	}

	public void Bewegungrueckwaerts(){
		if(StehtderMotor()){
			LagerMain.init.LaufbandMotor.Motorrueckwaertsfahrenlassen(LagerMain.init.LaufbandMotor.GetMotorAdresse()); 
		}
		else{
			if(LagerMain.init.LaufbandMotor.GetMotorStatus() == 1){
				LagerMain.init.LaufbandMotor.Motorausschalten(LagerMain.init.LaufbandMotor.GetMotorAdresse()); 
				LagerMain.init.LaufbandMotor.Motorrueckwaertsfahrenlassen(LagerMain.init.LaufbandMotor.GetMotorAdresse()); 
			}
		}
		System.out.println("Laufband: Laufband l�uft jetzt r�ckw�rts"); 
		bewegungvor = false; 
	}
	
	public void LaufbandmotorAusschalten(){
		LagerMain.init.LaufbandMotor.Motorausschalten(LagerMain.init.LaufbandMotor.GetMotorAdresse()); 
	}

}