package LagerSysPrg;
import java.util.*;

public class LichtsensorLeiste {

	private int LichtsensorMatrixAdresse;
	public int XPosition = 0; 
	public int YPosition = 0; 
	public int ZPosition = 0; 
	private Random generator = new Random();
	

	public LichtsensorLeiste(){
	}

	public void ErstelleAdresse() {	
		LichtsensorMatrixAdresse = generator.nextInt(255); 
		System.out.println("LichtsensorMatrix mit der Adresse " +LichtsensorMatrixAdresse + " erstellt.");
	}

	public void MesseGroesse(){
		XPosition = generator.nextInt(500); 
		YPosition = generator.nextInt(500); 
		ZPosition = generator.nextInt(500); 	
	}
	
	public int GetXPosition(){
		return XPosition; 
	}
	
	public int GetYPosition(){
		return YPosition; 
	}
	
	public int GetZPosition(){
		return ZPosition; 
	}

}