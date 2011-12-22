package LagerSysPrg;
import java.util.*;
import Simulation.*;

public class Lagerplatz {

	private boolean belegt;
	private int groesse;
	public BodenRampe BodenRampe;
	public Packet Paket;
	public Taster Taster_Staplerangekommen;
	private int Lagerplatznummer;

	public Lagerplatz(Packet paket){
		Paket = paket; 
		Random generator = new Random(); 
		this.Lagerplatznummer = generator.nextInt();
		this.groesse = generator.nextInt(); 
		BodenRampe = new BodenRampe(); 
	}

	public int GetLagerplatznummer(){
		return Lagerplatznummer; 
	}
	
	public int GetLagerplatzgroesse(){
		return groesse; 
	}
	
	public void StaplerKommtMitPaket(){
		if(Taster_Staplerangekommen.WartenAufTaster()){
			System.out.println("Lagerplatz: Der Stapler ist am Lagerplatz angekommen; "); 
			BodenRampe.BodenRampeGeradeStellen(); 
		}
	}
	
	

}