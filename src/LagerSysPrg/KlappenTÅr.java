package LagerSysPrg;


/**
 * @author Selcuk Dogan
 * @version 1.0
 * @created 01-Jun-2011 15:44:59
 */
public class KlappenT�r {

	public Motor m_Motor;
	public Taster m_Taster;
	public ZustandT�r m_Zustand;
	public ZustandT�r m_ZustandT�r;
	public Taster Taster_auf;
	public Taster Taster_zu;

	public KlappenT�r(){

	}

	/**
	 * 
	 * @exception Throwable Throwable
	 */
	public void finalize()
	  throws Throwable{

	}

	public boolean �ffnen(){
		return false;
	}

	public boolean schliessen(){
		return false;
	}

}