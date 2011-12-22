package LagerSysPrg; 

public class offen implements IKlappentuerZustand{
	
	private ZustandTuer Zustand; 
	
	public offen(ZustandTuer zustand){
		Zustand = zustand; 
	}

	public void oeffnen() {
		System.out.println("ZustandTür: Die Klappentür ist bereits offen!"); 
		
	}

	public void schliessen() {
		System.out.println("ZustandTür: Die Klappentür wird geschlossen!"); 
		Zustand.setStatus(0); 
	}
	
	
}