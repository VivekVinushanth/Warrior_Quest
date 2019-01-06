
public class KillerFish extends Fish{
	public void Kill(Warrior w){
		if (w.isImmortal()==false){
			w.getKilled();
		}
		
	}
	public KillerFish(String name,int position_x,int position_y){
		super(name,position_x,position_y);
		
}

}
