package LagerSysPrg; 

public class offen implements IKlappentuerZustand{
	
	private ZustandTuer Zustand; 
	
	public offen(ZustandTuer zustand){
		Zustand = zustand; 
	}

	public void oeffnen() {
		System.out.println("ZustandT�r: Die Klappent�r ist bereits offen!"); 
		
	}

	public void schliessen() {
		System.out.println("ZustandT�r: Die Klappent�r wird geschlossen!"); 
		Zustand.setStatus(0); 
	}
	
	
}