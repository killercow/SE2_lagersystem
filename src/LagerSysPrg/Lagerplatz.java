package LagerSysPrg;
import java.util.*;
import Simulation.*;

public class Lagerplatz {

	private boolean belegt;
	private int groesse;
	public BodenRampe BodenRampe;
	public Paket Paket;
	public Taster Taster_Staplerangekommen;
	public Taster Taster_PaketImPlatz; 
	private int Lagerplatznummer;
	private Random generator = new Random();
	
	public Lagerplatz(){ 
	}
	
	public void ErstelleLagerplatzAdresse(){
		Lagerplatznummer = generator.nextInt(255);
	}

	public int GetLagerplatznummer(){
		return Lagerplatznummer; 
	}
	
	public int GetLagerplatzgroesse(){
		groesse = generator.nextInt(5000);
		return groesse; 
	}
	
	public void StaplerKommtMitPaket(){
		if(Taster_Staplerangekommen.WartenAufTaster()){
			System.out.println("Lagerplatz: Der Stapler ist am Lagerplatz angekommen. "); 
			BodenRampe.BodenRampeGeradeStellen(); 
		}
	}
	
	public void PaketaufBRlegen(){
		BodenRampe.BodenRampeSchraegStellen(); 
		if(Taster_PaketImPlatz.WartenAufTaster()){
			System.out.println("Lagerplatz: Das Paket liegt im Fach ");
			BodenRampe.BodenRampeGeradeStellen(); 
			BodenRampe.BodenRampeausschalten(); 
		}
	}
	
	

}