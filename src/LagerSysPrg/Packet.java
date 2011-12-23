package LagerSysPrg;

import java.text.SimpleDateFormat;
import java.util.*;

public class Packet {

	private SimpleDateFormat AusLagZeit = new SimpleDateFormat("HH:mm");
	private SimpleDateFormat EinLagZeit = new SimpleDateFormat("HH:mm");
	private float Gewicht;
	private int Groesse;
	private int PaketCode;
	private int Preis; 

	public Packet(){
		this.PaketCode = ErstellePaketCode(); 
		System.out.println("Paket: Der PaketCode lautet: " + PaketCode); 
	}


	private int ErstellePaketCode() {
		Random generator = new Random(); 
		return generator.nextInt();
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

}
