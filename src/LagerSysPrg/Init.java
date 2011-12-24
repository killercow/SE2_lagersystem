package LagerSysPrg;

import Simulation.*;

public class Init {
	
	public  Stapler Stapler;
	
	public BodenRampe[] BodenRampenarray = new BodenRampe[2]; 
	public BodenRampe BodenRampeEAPlatz; 
	public BodenRampe BodenRampeLagerplatz; 
	 
	public Motor[] Motorarray = new Motor[5]; 
	public Motor BodenRampenMotor; 
	public Motor LaufbandMotor; 
	public Motor StaplerMotorXRichtung; 
	public Motor StaplerMotorYRichtung; 
	public Motor KlappentuerMotor; 
	
	public Taster[] Tasterarray = new Taster[6]; 
	public Taster LagerplatzTaster_Staplerangekommen; 
	public Taster LagerplatzTaster_PaketImPlatz; 
	public Taster BodenRampeTaster_oben; 
	public Taster BodenRampeTaster_unten; 
	public Taster KlappentuerTaster_auf; 
	public Taster KlappentuerTaster_zu; 
	
	public Lagerplatz[] Lagerplatzarray = new Lagerplatz[5];
	public  Lagerplatz Lagerplatz1 ; 
	public  Lagerplatz Lagerplatz2 ;
	public  Lagerplatz Lagerplatz3 ;
	public  Lagerplatz Lagerplatz4 ;
	public  Lagerplatz Lagerplatz5 ;
		
	public EinAusgPlatz EAPlatz;
	public KlappenTuer Klappentuer;
	
	public Gewichtsensor EAPlatzGewichtssensor; 
	public LichtsensorLeiste EAPlatzLichtsensorMatrix; 
	
	
	public Init(){
		EAPlatzLichtsensorMatrix = new LichtsensorLeiste(); 
		EAPlatzLichtsensorMatrix.ErstelleAdresse(); 
		EAPlatzGewichtssensor = new Gewichtsensor(); 
		EAPlatzGewichtssensor.ErstelleAdresse(); 
		Stapler = new Stapler(); 
		Stapler.ErstelleStaplerAdresse(); 
		EAPlatz = new EinAusgPlatz(); 
		EAPlatz.ErstelleEinAusgabePlatzAdresse(); 
		Klappentuer = new KlappenTuer(); 
		LagerplatzTaster_Staplerangekommen = new Taster(); 
		LagerplatzTaster_Staplerangekommen.ErstelleAdresse(); 
		LagerplatzTaster_PaketImPlatz = new Taster(); 
		LagerplatzTaster_PaketImPlatz.ErstelleAdresse(); 
		BodenRampeTaster_oben = new Taster(); 
		BodenRampeTaster_oben.ErstelleAdresse(); 
		BodenRampeTaster_unten = new Taster(); 
		BodenRampeTaster_unten.ErstelleAdresse(); 
		KlappentuerTaster_auf = new Taster(); 
		KlappentuerTaster_auf.ErstelleAdresse(); 
		KlappentuerTaster_zu = new Taster(); 
		KlappentuerTaster_zu.ErstelleAdresse(); 
		Lagerplatz1 = new Lagerplatz(); 
		Lagerplatz1.ErstelleLagerplatzAdresse(); 
		Lagerplatz2 = new Lagerplatz(); 
		Lagerplatz2.ErstelleLagerplatzAdresse();
		Lagerplatz3 = new Lagerplatz(); 
		Lagerplatz3.ErstelleLagerplatzAdresse(); 
		Lagerplatz4 = new Lagerplatz(); 
		Lagerplatz4.ErstelleLagerplatzAdresse(); 
		Lagerplatz5 = new Lagerplatz(); 
		Lagerplatz5.ErstelleLagerplatzAdresse(); 
		BodenRampeEAPlatz = new BodenRampe(); 
		BodenRampeEAPlatz.ErstelleAdresse(); 
		BodenRampeLagerplatz = new BodenRampe(); 
		BodenRampeLagerplatz.ErstelleAdresse(); 
		BodenRampenMotor = new Motor(); 
		BodenRampenMotor.ErstelleMotoradresse(); 
		LaufbandMotor = new Motor(); 
		LaufbandMotor.ErstelleMotoradresse(); 
		StaplerMotorXRichtung = new Motor(); 
		StaplerMotorXRichtung.ErstelleMotoradresse(); 
		StaplerMotorYRichtung = new Motor(); 
		StaplerMotorYRichtung.ErstelleMotoradresse(); 
		KlappentuerMotor = new Motor(); 
		KlappentuerMotor.ErstelleMotoradresse(); 
	}
	
	public void ErstelleLagerRaum(){
		
		Tasterarray[0] = LagerplatzTaster_Staplerangekommen; 
		Tasterarray[1] = LagerplatzTaster_PaketImPlatz; 
		Tasterarray[2] = BodenRampeTaster_oben; 
		Tasterarray[3] = BodenRampeTaster_unten; 
		Tasterarray[4] = KlappentuerTaster_auf; 
		Tasterarray[5] = KlappentuerTaster_zu;
		System.out.println("Das Tasterarray ist befüllt. ");
		
		Lagerplatzarray[0] = Lagerplatz1; 
		Lagerplatzarray[1] = Lagerplatz2;
		Lagerplatzarray[2] = Lagerplatz3;
		Lagerplatzarray[3] = Lagerplatz4;
		Lagerplatzarray[4] = Lagerplatz5;
		System.out.println("Das Lagerplatzarray ist befüllt. "); 
		
		BodenRampenarray[0] = BodenRampeEAPlatz; 
		BodenRampenarray[1] = BodenRampeLagerplatz; 
		System.out.println("Das BodenRampenarray ist befüllt. "); 
		
		Motorarray[0] = BodenRampenMotor; 
		Motorarray[1] = LaufbandMotor; 
		Motorarray[2] = StaplerMotorXRichtung; 
		Motorarray[3] = StaplerMotorYRichtung; 
		Motorarray[4] = KlappentuerMotor; 
		System.out.println("Das Motorarray ist befüllt. "); 
	}
	
	
}
