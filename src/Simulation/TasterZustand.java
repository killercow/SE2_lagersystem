package Simulation;

public class TasterZustand {

	//public ITasterZustand aktuellerZustand; 
	private int Status; 
	
	public TasterZustand(){
		setzeAktuellenZustand(new inaktiv(this)); 
	}
	
	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	public void setzeAktuellenZustand(ITasterZustand aktuellerTasterZustand){
		aktuellerZustand = aktuellerTasterZustand; 
	}
	
	public  void aktiv(){
		aktuellerZustand.aktiv(); 
	}
	public  void inaktiv(){
		aktuellerZustand.inaktiv(); 
	}
}
