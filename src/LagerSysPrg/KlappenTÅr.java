package LagerSysPrg;


/**
 * @author Selcuk Dogan
 * @version 1.0
 * @created 01-Jun-2011 15:44:59
 */
public class KlappenTür {

	public Motor m_Motor;
	public Taster m_Taster;
	public ZustandTür m_Zustand;
	public ZustandTür m_ZustandTür;
	public Taster Taster_auf;
	public Taster Taster_zu;

	public KlappenTür(){

	}

	/**
	 * 
	 * @exception Throwable Throwable
	 */
	public void finalize()
	  throws Throwable{

	}

	public boolean öffnen(){
		return false;
	}

	public boolean schliessen(){
		return false;
	}

}