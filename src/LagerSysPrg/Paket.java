package LagerSysPrg;

import java.text.SimpleDateFormat;
import java.util.*;

public class Paket {

	private SimpleDateFormat AusLagZeit = new SimpleDateFormat("HH:mm");
	private SimpleDateFormat EinLagZeit = new SimpleDateFormat("HH:mm");
	private float Gewicht;
	private int Groesse;
	private int PaketCode;
	private int Preis; 
	private int Lagerplatznummer; 
	public static int nummerVonPaketen = 0; 

	public Paket(){
		nummerVonPaketen++; 
	}
	
	public void finalize(){
		nummerVonPaketen--; 
	}
	
	

	public void ErstellePaketCode() {
		Random generator = new Random(); 
		this.PaketCode = generator.nextInt(1000000);
		System.out.println("Paket: Der PaketCode lautet: " + PaketCode); 
	}
	
	public void PreisfuerPaketberechnen(){
		if(this.getGroesse() > 500){
			this.setPreis(20); 
		}
		else{
			this.setPreis(2); 
		}
	}
	
	public void PreisfuerLagerzeitberechnen(){
		int Preis = this.getPreis(); 
		if(this.getAusLagZeit() != this.getAusLagZeit()){
			this.setPreis(Preis+5); 
		}
		else{
			this.setPreis(Preis); 
		}
	}
	
	public void Paketeinlagern(){
		LagerMain.init.EAPlatz.Paketannehmen(); 
		int paketGewicht = LagerMain.init.EAPlatzGewichtssensor.MesseGewicht(); 
		this.setGewicht(paketGewicht); 
		System.out.println("Paket: Das Paket hat ein Gewicht von: "+ paketGewicht);
		LagerMain.init.EAPlatzLichtsensorMatrix.MesseGroesse(); 
		int XPosition = LagerMain.init.EAPlatzLichtsensorMatrix.GetXPosition(); 
		int YPosition = LagerMain.init.EAPlatzLichtsensorMatrix.GetYPosition(); 
		int ZPosition = LagerMain.init.EAPlatzLichtsensorMatrix.GetZPosition(); 
		int Groesse = (XPosition + YPosition + ZPosition) / 3;
		this.setGroesse(Groesse); 
		PreisfuerPaketberechnen(); 		
		LagerMain.init.Stapler.Paketaufnehmen(); 
		LagerMain.init.Stapler.StaplerfahertmitPaketzumLagerplatz(this.getLagerplatznummer()); 
		if(LagerMain.init.Stapler.StaplerfaehrtzurAusgabezurueck()){
			System.out.println("Paket: Der Stapler ist wieder in Ausgangssituation.");
		}
		else{
			System.out.println("Paket: Der Stapler fährt wieder in Ausgangssituation."); 
		}
		System.out.println("Paket: Paket wurde eingelagert"); 
	}
	
	public void  Paketauslagern(int lagerplatzNummer){
		SimpleDateFormat time = new SimpleDateFormat("HH:mm");
		this.setAusLagZeit(time); 
		PreisfuerLagerzeitberechnen(); 
		LagerMain.init.Stapler.ZumLagerplatzfahren(lagerplatzNummer); 
		if(LagerMain.init.Stapler.PaketaufnehmenvomLagerplatz()){
			if(LagerMain.init.Stapler.PaketinAusgabeablegen()){
				LagerMain.init.BodenRampeEAPlatz.BodenRampeSchraegStellen(); 
				System.out.println("EAPlatz: Das Paket liegt jetzt auf der BR am EAPlatz.");
				LagerMain.init.BodenRampeEAPlatz.BodenRampeGeradeStellen(); 
				LagerMain.init.BodenRampeEAPlatz.BodenRampeausschalten();
				LagerMain.init.EAPlatz.Paketabholen(); 
				System.out.println("Paket: Paket wurde abgeholt!"); 
				LagerMain.init.EAPlatz.EAPLatzinAusgangsstellungBringen(); 
			}
		}
	}
	
	public int GetPaketCode(){
		return PaketCode; 
	}

	public float getGewicht() {
		return Gewicht;
	}


	public void setGewicht(float gewicht) {
		Gewicht = gewicht;
	}


	public int getGroesse() {
		return Groesse;
	}


	public void setGroesse(int groesse) {
		Groesse = groesse;
	}


	public SimpleDateFormat getAusLagZeit() {
		return AusLagZeit;
	}


	public void setAusLagZeit(SimpleDateFormat ausLagZeit) {
		AusLagZeit = ausLagZeit;
	}


	public SimpleDateFormat getEinLagZeit() {
		return EinLagZeit;
	}


	public void setEinLagZeit(SimpleDateFormat einLagZeit) {
		EinLagZeit = einLagZeit;
	}


	public int getPreis() {
		return Preis;
	}


	public void setPreis(int preis) {
		Preis = preis;
	}

	public int getLagerplatznummer() {
		return Lagerplatznummer;
	}

	public void setLagerplatznummer(int lagerplatznummer) {
		Lagerplatznummer = lagerplatznummer;
	}

}
