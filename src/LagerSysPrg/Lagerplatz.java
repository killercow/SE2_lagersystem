package LagerSysPrg;

import Simulation.Taster;

/**
 * @author Tanveer Ahmed s680338
 * @version 1.0
 * @created 01-Jun-2011 15:44:59
 */
public class Lagerplatz {

	private boolean belegt;
	private int groesse;
	public BodenRampe m_BodenRampe;
	public Packet m_Packet;
	public Simulation.Taster s_Taster_a;
	public Simulation.Taster s_Taster_b;
	
	public Taster m_Taster_a;
	public Taster m_Taster_b;
	
	private int nummer;
	
	public String name;
	
	private int XPos;
	private int YPos;
	public Packet m_Paket;

	public Lagerplatz(){
		// konstruktor noch nicht fertig

	}
	
	public Lagerplatz(String t1, String t2, String N, int Z1, int Z2){
		
		this.name=N;
		System.out.println("Sim: Lagerplatz "+name+" erstellt");
		s_Taster_a = new Simulation.Taster(t1,Z1); // Der Taster wird nach 5 Sec gedrückt
		s_Taster_b = new Simulation.Taster(t2,Z2);
	}

	public boolean Setbelegt(){
		return false;
	}

	/**
	 * 
	 * @exception Throwable Throwable
	 */
	public void Zielplatz()
	  throws Throwable{

	}

}