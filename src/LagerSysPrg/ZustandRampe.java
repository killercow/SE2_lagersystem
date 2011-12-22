package LagerSysPrg;

public class ZustandRampe {

	public IBodenRampeZustand aktuellerZustand; 
	private int Status;  
	
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
	
	public boolean WartenBisBewegungZuende(){
		try{
			Thread.sleep(5000); 
			return false; 
		}
		catch(InterruptedException e){
			e.printStackTrace();
			return true;
		}
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

}