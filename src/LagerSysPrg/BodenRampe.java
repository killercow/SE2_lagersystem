package LagerSysPrg;
import Simulation.*;

public class BodenRampe {
	
	String Adresse;
	public Motor br_Motor;
	public ZustandRampe m_ZustandRampe;
	private boolean Zustand;
	private Taster br_Taster_O;
	private Taster br_Taster_U;

	public BodenRampe(String BR_Add,String BRM_Add, String BRTO_Add, String BRTU_Add){
		this.Adresse=BR_Add;
		System.out.println("Sim: Bodenrampe "+BR_Add+" ertsellen");
		br_Motor = new Simulation.Motor();
		//br_Taster_O = new Simulation.Taster(BRTO_Add,5000);
		//br_Taster_U = new Simulation.Taster(BRTU_Add,5000);
	}

	public BodenRampe(){
	}
	
	public void finalize()
	  throws Throwable{

	}

	public void heben(){

	}

	public void senken(){

	}

}