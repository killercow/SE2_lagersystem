package LagerSysPrg; 

public class geschlossen implements IKlappentuerZustand{
	
	private ZustandTuer Zustand; 
	
	public geschlossen(ZustandTuer zustand){
		Zustand = zustand; 
	}

	public void oeffnen() {
		System.out.println("ZustandT�r: Die Klappent�r wird geoeffnet!"); 
		Zustand.setStatus(1); 
	}

	public void schlie�en() {
		System.out.println("ZustandT�r: Die Klappent�r ist bereits geschlossen!"); 
	}
	
	
}