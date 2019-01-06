
public class SuperWarrior extends Warrior{
	public void eat(){}
	public void sleep(){
		System.out.println("He is sleeping.......");
	}
	
	
	public SuperWarrior(String name,int position_x,int position_y){
		super(name,position_x,position_y);
		setImmortal(false);
		Binocular bino1=new Binocular();
	}

}
