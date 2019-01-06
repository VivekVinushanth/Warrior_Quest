public class LakeNode{
	
	int position_x;
	int position_y;
	public LakeNode(int position_x,int position_y) {
		this.position_x=position_x;
		this.position_y=position_y;
	}
	
	Inhabitant [] InhabitArray =new Inhabitant[3]; // to contain characters at a node and to check whether they overlap or not
    											//0-for Warrior........1-for-Fish.......2-for-Lotus
	
	
	
	public void addInhabit(Inhabitant chara) { // InhabitArray[0] as a shared resource for warrior threads
		if (chara instanceof Warrior) {
			synchronized (InhabitArray) { 
			if (InhabitArray[0]!=null) {
				try {
					System.out.println("Warrior "+chara.getName()+" Cannot be overlapped to this node ("+this.position_x+","+this.position_y+")");
					InhabitArray.wait();
				}catch (InterruptedException e) {
					e.printStackTrace();
					
				}
			}else {
				InhabitArray[0]=chara;
				if (InhabitArray[1]!=null) {
					if (InhabitArray[1] instanceof eRubber) {   //incase of rubber pulling fish-thraed has to be terminated
						
						Warrior warrior1=(Warrior) chara;       // and 
						((eRubber)InhabitArray[1]).pullFins(warrior1);
						 //warrior1.looseFins();
						 
						 System.out.println("OOPS, "+warrior1.getName()+" is bit by "+InhabitArray[1].getName()+" fish. He lost his fin and immovable.");
						// System.out.println();
						 Thread.currentThread().stop();

						
					} else if (InhabitArray[1] instanceof KillerFish) { //incase of killer fish-thraed has to be terminated permanently
						Warrior warrior2=(Warrior) chara;
						if (warrior2.isImmortal()==false){
							System.out.println("Alas, "+warrior2.getName()+" is killed by deadly "+InhabitArray[1].getName()+" fish. Royal Salute.RIP");
							 //System.out.println();
							((KillerFish)InhabitArray[1]).Kill(warrior2);
							//warrior2.getKilled();
							Thread.currentThread().stop();
							
					 
						}else if(warrior2.isImmortal()==true){
							warrior2.setImmortal(false); //reducing the power of immortality
							System.out.println("HOHO, "+warrior2.getName()+" is immortal!!! and you can't even touch him "+InhabitArray[1].getName());
							 System.out.println();
							warrior2.NoOfwarriors-=1;
							}
					}
				}else if(InhabitArray[2] instanceof MagicLotus) {   //incase of rubber pulling fish-thraed has to be terminated
							Warrior warrior1=(Warrior) chara;       // and 
						if (warrior1.isImmortal()==false){
								System.out.println("Great to hear that "+warrior1.getName()+" has picked the petal of Magic Lotus and became Immortal. Go and fetch the treasury my Warrior!!!!");
								//System.out.println();
							 warrior1.pumpToLotus();
							 
						}
				}
			}
							
			
			InhabitArray.notifyAll();
		
		}
	}
				
		
		else if(chara instanceof Fish) { 
			if (InhabitArray[1]==null) {
				InhabitArray[1]=chara;
			}	
		}
		else if (chara instanceof Lotus) {
			if (InhabitArray[2]==null) {
				InhabitArray[2]=chara;
			}
		}
			
	}
	
	public void removeInhabit(Inhabitant chara) { //removing inhabitants-this supports the movement of warrior-
		if (chara instanceof Warrior) {
			synchronized (InhabitArray) {   // as a shared resource-to stop removing things if it is a null
			if (InhabitArray[0]==null) {
				try {
					InhabitArray.wait();
					 System.out.println();
					//System.out.println("Cannot remove from nothing u know");
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
				InhabitArray[0]=null;
				InhabitArray.notifyAll();
			
			}	
		}else if(chara instanceof Fish) {
			if (InhabitArray[1]==chara) {
				InhabitArray[1]=null;		
		}
			
		}else if (chara instanceof Lotus) {
			if (InhabitArray[2]==chara) {
				InhabitArray[2]=null;
			}
		}
	}
	
	public boolean inhabitPresent() {
		if (InhabitArray[0]==null) {  //check whether another warrior is on the point
			return true;
		}
		return false;
	}	
}
	