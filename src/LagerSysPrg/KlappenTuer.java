package LagerSysPrg;
import Simulation.*; 

public class KlappenTuer {

	public Motor m_Motor;
	public Taster m_Taster;
	public ZustandTuer m_Zustand;
	public ZustandTuer m_ZustandTuer;
	public Taster Taster_auf;
	public Taster Taster_zu;

	public KlappenTuer(){

	}

	public void finalize()
	  throws Throwable{

	}

	public boolean oeffnen(){
		return false;
	}

	public boolean schliessen(){
		return false;
	}

}