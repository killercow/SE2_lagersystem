package LagerSysPrg; 

public class geschlossen implements IKlappentuerZustand{
	
	private ZustandTuer Zustand; 
	
	public geschlossen(ZustandTuer zustand){
		Zustand = zustand; 
	}

	public void oeffnen() {
		System.out.println("ZustandTür: Die Klappentür wird geoeffnet!"); 
		Zustand.setStatus(1); 
	}

	public void schließen() {
		System.out.println("ZustandTür: Die Klappentür ist bereits geschlossen!"); 
	}
	
	
}