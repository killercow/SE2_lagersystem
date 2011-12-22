package Simulation;

public class Taster {

	private int TasterAdresseDefault = 0; 
	public static int TasterAdresse;
	private TasterZustand tasterZustand = new TasterZustand(); 
	public boolean TasterIstAktiv = false; 

	public Taster(){
		this.TasterAdresse = ErstelleAdresse(); 
	}

	private int ErstelleAdresse() {
		int xteTasterAdresse = TasterAdresseDefault +1; 
		System.out.println("Taster mit der Adresse " + xteTasterAdresse + "erstellt.");
		return xteTasterAdresse;
	}
	
	public int GetTasterAdresse(){
		return TasterAdresse; 
	}
	
	public int GetTasterStatus(){
		return tasterZustand.getStatus(); 
	}
	
	public boolean WartenAufTaster(){
		tasterZustand.inaktiv(); 
	}
	
	public void Tasteraktivieren(){
		System.out.println("Taster: Der Taster wird aktiviert");
		int Status = GetTasterStatus(); 
		if(Status == 1){
			System.out.println("Taster: Der Taster ist bereits aktiviert");
		}
		tasterZustand.aktiv();
		
	}
	
	public void Tasterdeaktivieren(){
		System.out.println("Taster: Der Taster wird deaktiviert");
		int Status = GetTasterStatus(); 
		if(Status == 0){
			System.out.println("Taster: Der Taster ist bereits deaktiviert");
		}
		tasterZustand.inaktiv();
	}


}