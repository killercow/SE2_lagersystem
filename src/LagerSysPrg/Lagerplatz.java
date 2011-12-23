package LagerSysPrg;
import java.util.*;
import Simulation.*;

public class Lagerplatz {

	private boolean belegt;
	private int groesse;
	public BodenRampe BodenRampe;
	public Packet Paket;
	public Taster Taster_Staplerangekommen;
	public Taster Taster_PaketImPlatz; 
	private int Lagerplatznummer;

	public Lagerplatz(Packet paket){
		Paket = paket; 
		Random generator = new Random(); 
		this.Lagerplatznummer = generator.nextInt(255);
		this.groesse = generator.nextInt(5000); 
		BodenRampe = new BodenRampe(); 
		Taster_Staplerangekommen = new Taster(); 
		Taster_PaketImPlatz = new Taster(); 
	}

	public int GetLagerplatznummer(){
		return Lagerplatznummer; 
	}
	
	public int GetLagerplatzgroesse(){
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