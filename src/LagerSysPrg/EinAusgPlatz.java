package LagerSysPrg;

public class EinAusgPlatz {

	private boolean Belegt;
	public BodenRampe m_BodenRampe;
	public KlappenTuer m_KlappenTuer;
//	public LichtsensorLeiste[3] m_Lichtsensor;
	public LichtsensorLeiste m_LichtsensorLeiste;

	String address;
	
	public EinAusgPlatz(String EAPAdd, String BR_Add,String BRM_Add,String BRTO_Add, String BRTU_Add){
		this.address=EAPAdd;
		System.out.println("Sim: "+EAPAdd+" erstellt");
		
		// Gewichtssensor
		// Lichtsensorleiste
		// BodenRampe
		m_BodenRampe = new BodenRampe(BR_Add,BRM_Add, BRTO_Add, BRTU_Add);
		// TürKlappe
	}

	public EinAusgPlatz(){
		
		// Gewichtssensor
		// BodenRampe

	}
	/**
	 * 
	 * @exception Throwable Throwable
	 */
	public void finalize()
	  throws Throwable{

	}

	/**
	 * 
	 * @param gewicht    gewicht
	 */
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