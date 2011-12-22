package LagerSysPrg;

public class ZustandTuer {
	
	public IKlappentuerZustand aktuellerZustand; 
	private int Status; 

	public ZustandTuer(){
		setzeAktuellenZustand(new geschlossen(this)); 
	}
	
	public void setzeAktuellenZustand(IKlappentuerZustand aktuellerKTZustand){
		aktuellerZustand = aktuellerKTZustand; 
	}

	public void oeffnen() {
		aktuellerZustand.oeffnen(); 
	}

	public void schliessen() {
		aktuellerZustand.schliessen(); 
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

}