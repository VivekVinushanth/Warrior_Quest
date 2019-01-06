import java.util.ArrayList;

public class TreasureChest {
	int position_x;
	int position_y;
	private boolean isAttained;
	private printToFile printfile=new printToFile(); 
	
	
	public TreasureChest(int x,int y){
		this.position_x=x;
		this.position_y=y;
		this.isAttained=false;
	
}
	private ArrayList <Warrior> observer_Warriors=new ArrayList <Warrior>();
	
	public void attachWarrior(Warrior w) {  //adding observer warriors interested in chest
		observer_Warriors.add(w);
	}
	
	public void detachWarrior(Warrior w) { //removing warriors if they are not interested-no need for this method here all of them are interested
		observer_Warriors.remove(w);
	}
	
	public boolean hasRecovered() {
		return isAttained;
	}
	
	public void attainmentStatus(boolean x) {
		this.isAttained=x;
		if(this.isAttained==true){
			notifyWarrior();
			
		}	
	}
	
	//when the treasure chest is reached notify all the observer warriors to end swimming and to end the game
	//to be continued
	public void notifyWarrior() {
		if(this.hasRecovered()){
			for (int i=0;i<observer_Warriors.size();i++) {
				//observer_Warriors.get(i).mobilityCheck(false);
				observer_Warriors.get(i).update(this);
	}
		}

	}
	
	public void startTracking(Warrior w) {
		w.setStartTime(System.nanoTime());
	}
	
	public void notifyprintToFile(Warrior w) {
		printfile.EndProcess(w);
	}
	
	
	}
	


