package Simulation;

public class Lichtsensor {

	private static int LichtsensorAdresse;
	private int LichtsensorAdresseDefault = 0; 
	public boolean isteingeschlatet = false; 

	public Lichtsensor(){
		this.LichtsensorAdresse = ErstelleAdresse(); 
	}

	private int ErstelleAdresse() {
		int xteLichtsensorAdresse = LichtsensorAdresseDefault +1; 
		System.out.println("Lichtsensor mit der Adresse " + xteLichtsensorAdresse + "erstellt.");
		return xteLichtsensorAdresse;
	}

	public boolean einschalten(){
		return isteingeschlatet = true; 
	}
	
	public boolean ausschalten(){
		return isteingeschaltet = false; 
	}

}