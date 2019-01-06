import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.*;


public abstract class Warrior extends Inhabitant implements Runnable,java.io.Serializable {
	
	public static int NoOfwarriors=0;
	public static int Noof_MovingWarriors=0;
	
	SwimFin fin1=new SwimFin();
	
	private long startTime;
	private long endTime;
	private boolean has_Swimmingfins;
	private boolean isalive;
	private boolean has_treasure;
	private boolean ismobile;
    private double swimmingTime;
	private boolean immortal;
	private printToFile printfile=new printToFile(); 
	public static TreasureChest Chest1 = new TreasureChest(5,5);
	int newPosi_x;
	int newPosi_y;
	
	
	
	//Lake NozamaLake=Lake.initiateLake();
	public Warrior(String name,int position_x,int position_y){
		super(name,position_x,position_y);
		name=super.getName();
		position_x=this.getx();
		position_y=this.gety();
		NoOfwarriors++;
		isalive =true;
		ismobile=true;
		has_Swimmingfins=true;
		
	}
		
	public  int getNoWarriors(){
			return NoOfwarriors;
	}
	
	public  int getNo_movingWarriors(){
		return Noof_MovingWarriors;
	}
	
	//for mobility control
	public boolean hasMobility() {
		return ismobile;
	}
	
	public void mobilityCheck(boolean a) {
		 ismobile=a;
	}
	
	
	
	public void run() {
		if (NoOfwarriors<=0 && Noof_MovingWarriors<=0) {
			System.out.println("Mission Failed. All of them are Massacred");
			 
		}else {
		while(this.isalive && this.ismobile) {
		this.swim();
		try {
			Thread.currentThread().sleep(1000);
	}catch(InterruptedException e) {
		e.printStackTrace();
		System.out.println("error");
	}
	
	}Thread.currentThread().stop();
	
		
		}
		}
	
	
	//=========================================================================================================================================================
	public void swim (){ 
		synchronized(this){
		//swim method---it deals with several logics for moving
		// and we check whether 
		//this.startTime=System.nanoTime();
		
		int x= this.getx();
		int y= this.gety();
		
		
		
		if(has_Swimmingfins) {
			int [][] direct=new int [2][2];
			if (x<5 && y<5){
				direct[0]= new int[] {x+1,y};
				direct[1]=new int[] {x,y+1};
				Random dir1 = new Random();
				int dir =dir1.nextInt(2);    //using random behavior we choose any of the movable direction
				newPosi_x=direct[dir][0]; //assigning value to x
				newPosi_y=direct[dir][1]; //assigning value to y
					
				}else if (x<5 && y>5){
					direct[0]= new int[] {x+1,y};
					direct[1]=new int[] {x,y-1};
					Random dir1 = new Random();
				int dir =dir1.nextInt(2);    //using random behavior we choose any of the movable direction
				newPosi_x=direct[dir][0]; //assigning value to x
				newPosi_y=direct[dir][1]; //assigning value to y
				
				}else if (x>5 && y<5){
					direct[0]= new int[] {x-1,y};
					direct[1]=new int[] {x,y+1};
					Random dir1 = new Random();
				int dir =dir1.nextInt(2);    //using random behavior we choose any of the movable direction
				newPosi_x=direct[dir][0]; //assigning value to x
				newPosi_y=direct[dir][1]; //assigning value to y
					
				}else if (x>5 && y>5){
					direct[0]= new int[] {x-1,y};
					direct[1]=new int[] {x,y-1};
					Random dir1 = new Random();
				int dir =dir1.nextInt(2);    //using random behavior we choose any of the movable direction
				newPosi_x=direct[dir][0]; //assigning value to x
				newPosi_y=direct[dir][1]; //assigning value to y
				
				}else if (x==5 && y!=5){
					if (y<5){
						newPosi_x=5; //assigning value to x
						newPosi_y=y+1; //assigning value to y
						
					}else {
						newPosi_x=5; //assigning value to x
						newPosi_y=y-1; //assigning value to y
					}
					
				}else if (x!=5 && y==5){
					if (x<5){
						newPosi_x=x+1; //assigning value to x
						newPosi_y=y; //assigning value to y
						
					}else {
						newPosi_x=x-1; //assigning value to x
						newPosi_y=y; //assigning value to y
					}
				
				}
		}
			
			if (Lake.movable(newPosi_x,newPosi_y)) {  // we check here whether the warrior can move-ie; is the point is on grid and if it is free without another warrior
				synchronized(this) {
					Lake.removeInhabitant(this,x,y);    //  but can have lotus or fish
				}
				Lake.addInhabitant(this,newPosi_x,newPosi_y);
				System.out.println(this.getName()+"\t has moved from "+"("+x+","+y+") to ("+newPosi_x+","+newPosi_y+")");
				System.out.println();
				 //System.out.println(".......................................................................");
				if (newPosi_x==5 && newPosi_y==5) {
					Chest1.attainmentStatus(true);
					this.takeTreasure();
					}
				}else {
				System.out.println(this.getName()+"\t can't move from "+"("+x+","+y+") to ("+newPosi_x+","+newPosi_y+").");
				//System.out.println(".......................................................................");
				System.out.println();
				}
		}
	}
		
	//==================================================================================================================================================	
		
	public void pumpToLotus(){
		if (this.isImmortal()==false){
			setImmortal(true);
		}
	}
	
	
	
	public void getKilled(){
		isalive=false;
		int posi_x=this.getx();
		int posi_y=this.gety();
		NoOfwarriors-=1;
		Lake.removeInhabitant(this, posi_x, posi_y);
	}
		
		
		public void takeTreasure(){
			System.out.println("Treseasury is recovered by "+this.getName()+" Warrior.Hence the game Ends here.............");
			 System.out.println();
			Chest1.notifyprintToFile(this);
		}
		
		public void looseFins(){
			fin1=null;
			ismobile=false;
			Noof_MovingWarriors-=1;
		}
		
		
		public boolean isImmortal(){
			return immortal;
			
		}
		
		//methods related to accessing times
		public long getStartTime() {
			return startTime;
		}

		public void setStartTime(long startTime) {
			this.startTime = startTime;
		}

		public long getEndTime() {
			return System.nanoTime();
		}
		
		public void setEndTime(long currentTime) {
			endTime =currentTime;
		}
		
		
		
		 
		public void notifyChest(){
				//Warrior warrior = this;
				Chest1.attachWarrior(this); //hence informing that warriors are interested in the state change of Chest and adding as observers
				System.out.print("The Chest has been informed that "+this.getName()+" has started moving");
				System.out.println();
				Chest1.startTracking(this);
				
			}
 /*   
	public void notifyChest(){
			Warrior warrior = this;
			Chest1.attachWarrior(warrior); //hence informing that warriors are interested in the state change of Chest and adding as observers
			System.out.print("The Chest has been informed that "+warrior.getName()+" has started moving");
			System.out.println();
			
		}*/
		
	/*public void notifyprintToFile(){
		printfile.EndProcess(this);
		
		
	}*/
	

public void update(Object o) {
	 if(this.isalive && this.ismobile){
			this.isalive=false;
			this.ismobile=false;
			System.out.println("Since TreasureChest is reached, "+this.getName()+" has stopped moving");
			System.out.println();
		
			}else {
				this.isalive=false;
				this.ismobile=false;
				System.out.println("Since TreasureChest is reached, "+this.getName()+" is anyhow informed.Sorry for the lives");
				System.out.println();
	
}
}

public void setImmortal(boolean immortal) {
	this.immortal = immortal;
}
	  



}
