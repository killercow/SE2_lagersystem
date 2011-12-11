
package LagerSysPrg;
import Simulation.*;

/**
 * @author Tanveer Ahmed s680338
 * @version 1.0
 * @created 01-Jun-2011 15:44:59
 */
public class Stapler {
	public Lagerplatz[] m_Lagerplatz;
	public Laufband m_Laufband;
	
	public Motor m_Motor_x;
	public Motor m_Motor_y;
	
	public Simulation.Motor s_Motor_x;
	public Simulation.Motor s_Motor_y;
	
	String Addresse;
	
	public Stapler(String SAdd, String MAdd1, String MAdd2, String L_Add, String LM_Add){
		this.Addresse= SAdd;
		System.out.println("Sim: "+SAdd+" erstellt");
		s_Motor_x = new Simulation.Motor(MAdd1);
		s_Motor_y = new Simulation.Motor(MAdd2);
		m_Laufband = new Laufband(L_Add, LM_Add);
	}
	
	public Stapler(){
		m_Motor_x = new Motor();
		m_Motor_y = new Motor();
		m_Laufband = new Laufband();
	}
	


	/**
	 * 
	 * @exception Throwable Throwable
	 */
	public void finalize()
	  throws Throwable{

	}

	public void ablegen(){

	}

	public void aufnehmen(){

	}

	public void fahreX(char richtung){
		//s_motor_x.Ein(richtung);	
	}

	public void fahreY(){

	}

	public boolean setBelegt(){
		return false;
	}

}