package LagerSysPrg;

public class ZustandRampe {

	public IBodenRampeZustand aktuellerZustand; 
	private int Status; 
	private boolean istinBewegung = false; 
	
	public ZustandRampe(){
		setzeAktuellenZustand(new gerade(this)); 
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}
	
	public void setzeAktuellenZustand(IBodenRampeZustand aktuelleBRZustand){
		aktuellerZustand = aktuelleBRZustand; 
	}
	
	public  void gerade(){
		aktuellerZustand.gerade(); 
	}
	public  void schraeg(){
		aktuellerZustand.schraeg(); 
	}
	public  void stoppen(){
		aktuellerZustand.stoppen(); 
	}

	public boolean GetIstinBewegung() {
		return istinBewegung;
	}

	public void setIstinBewegung(boolean istinBewegung) {
		this.istinBewegung = istinBewegung;
	}

}