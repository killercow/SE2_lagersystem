package LagerSysPrg;
import java.util.*;

public class LichtsensorLeiste {

	private int LichtsensorMatrixAdresse;
	private int LichtsensorMatrixAdresseDefault = 0; 
	public int XPosition = 0; 
	public int YPosition = 0; 
	public int ZPosition = 0; 
	

	public LichtsensorLeiste(){
		this.LichtsensorMatrixAdresse = ErstelleAdresse(); 
	}

	private int ErstelleAdresse() {
		int xteLichtsensorMatixAdresse = LichtsensorMatrixAdresseDefault +1; 
		System.out.println("LichtsensorMatrix mit der Adresse " + xteLichtsensorMatixAdresse + "erstellt.");
		return xteLichtsensorMatixAdresse;
	}

	public void MesseGroesse(){
		Random generator = new Random(); 
		XPosition = generator.nextInt(); 
		YPosition = generator.nextInt(); 
		ZPosition = generator.nextInt(); 	
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