package Simulation;
import java.util.*;

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

	public int MesseGewicht(){
		Random generator = new Random(); 
		return generator.nextInt(); 
	}

}