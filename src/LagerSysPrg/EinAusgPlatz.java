package LagerSysPrg;
import Simulation.*; 

public class EinAusgPlatz {

	private boolean istBelegt;
	public BodenRampe bodenRampe;
	public int BodenRampeMotorAdresse; 
	public KlappenTuer klappenTuer;
	public LichtsensorLeiste lichtsensorLeiste;
	public Gewichtsensor gewichtsensor; 
	private int EAPlatzAdresseDefault = 0; 
	public static int einausgabePlatzAdresse;
	
	public EinAusgPlatz(){
		this.einausgabePlatzAdresse=ErstelleEinAusgabePlatzAdresse();
		System.out.println("Sim: "+einausgabePlatzAdresse+" erstellt");
		
		// Gewichtssensor
		// Lichtsensorleiste
		bodenRampe = new BodenRampe();
		BodenRampeMotorAdresse = bodenRampe.GetBodenRampenAdresse(); 
		// TuerKlappe
	}
	
	private int ErstelleEinAusgabePlatzAdresse(){
		int xteEAPLatzAdresse = EAPlatzAdresseDefault +1; 
		System.out.println("EAPlatz mit der Adresse " + xteEAPLatzAdresse + "erstellt.");
		return xteEAPLatzAdresse;
	} 
	
	public void finalize()
	  throws Throwable{

	}
	
	public void GetGewicht(float gewicht){

	}

	/**
	 * 
	 * @param tiefe
	 * @param breite
	 * @param hoehe    hoehe
	 */
	public void GetPacketGroesse(int tiefe, int breite, int hoehe){

	}

}