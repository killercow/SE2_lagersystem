package LagerSysPrg;
import java.util.*;
import Simulation.*;

public class Lagerplatz {

	private boolean belegt;
	private int groesse;
	private int Lagerplatznummer;
	private Random generator = new Random();
	
	public Lagerplatz(){ 
	}
	
	public void ErstelleLagerplatzAdresse(){
		Lagerplatznummer = generator.nextInt(255);
		System.out.println("Lagerplatz: Laufband mit der Adresse " + Lagerplatznummer + " erstellt.");
	}

	public int GetLagerplatznummer(){
		return Lagerplatznummer; 
	}
	
	public int GetLagerplatzgroesse(){
		groesse = generator.nextInt(5000);
		return groesse; 
	}
	
	public void StaplerKommtMitPaket(){
		if(LagerMain.init.LagerplatzTaster_Staplerangekommen.WartenAufTaster()){
			System.out.println("Lagerplatz: Der Stapler ist am Lagerplatz angekommen. "); 
			LagerMain.init.BodenRampeLagerplatz.BodenRampeGeradeStellen(); 
		}
	}
	
	public void PaketaufBRlegen(){
		LagerMain.init.BodenRampeLagerplatz.BodenRampeSchraegStellen(); 
		if(LagerMain.init.LagerplatzTaster_PaketImPlatz.WartenAufTaster()){
			System.out.println("Lagerplatz: Das Paket liegt im Fach ");
			this.belegt = true; 
			LagerMain.init.BodenRampeLagerplatz.BodenRampeGeradeStellen(); 
			LagerMain.init.BodenRampeLagerplatz.BodenRampeausschalten(); 
		}
	}
	
	public void PaketaufBRlegenAuslagern(){
		LagerMain.init.BodenRampeLagerplatz.BodenRampeSchraegStellen(); 
		if(LagerMain.init.LagerplatzTaster_PaketImPlatz.WartenAufTaster()){
			System.out.println("Lagerplatz: Das Paket liegt im Fach ");
			this.belegt = false; 
			LagerMain.init.BodenRampeLagerplatz.BodenRampeGeradeStellen(); 
			LagerMain.init.BodenRampeLagerplatz.BodenRampeausschalten(); 
		}
	}

	public boolean getBelegt() {
		return belegt;
	}
	
	

}