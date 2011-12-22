package Simulation;

public class Gewichtsensor {

	private int GewichtsensorAdresseDefault = 0; 
	public static int GewichtsensorAdresse;

	public Gewichtsensor(){
		this.GewichtsensorAdresse = ErstelleAdresse(); 
	}

	private int ErstelleAdresse() {
		int xteGewichtsensorAdresse = GewichtsensorAdresseDefault +1; 
		System.out.println("Gewichtsensor mit der Adresse " + xteGewichtsensorAdresse + "erstellt.");
		return xteGewichtsensorAdresse;
	}

	public void MesseGewicht(){
		
	}

}