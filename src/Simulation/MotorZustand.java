package LagerSysPrg;

public class MotorZustand {

		public IMotorZustand aktuellerZustand; 
		private int Status; 
		
		public MotorZustand(){
			setzeAktuellenZustand(new Steht(this)); 
		}
		
		public int getStatus() {
			return Status;
		}

		public void setStatus(int status) {
			Status = status;
		}

		public void setzeAktuellenZustand(IMotorZustand aktuellerMotorZustand){
			aktuellerZustand = aktuellerMotorZustand; 
		}
		
		public  void Rechts(){
			aktuellerZustand.rechts(); 
		}
		public  void Links(){
			aktuellerZustand.links(); 
		}
		public  void Stoppen(){
			aktuellerZustand.stoppen(); 
		}
		
}
