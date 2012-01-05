package Simulation;
import java.util.*;

public class Gewichtsensor {

	public int GewichtsensorAdresse;
	private Random generator = new Random();

	public Gewichtsensor(){ 
	}

	public void ErstelleAdresse() {		
		GewichtsensorAdresse = generator.nextInt(255); 
		System.out.println("Gewichtsensor mit der Adresse " + GewichtsensorAdresse + " erstellt.");
	}

	public int MesseGewicht(){
		return generator.nextInt(500); 
	}

}