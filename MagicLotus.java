
public class MagicLotus extends Lotus{
	public MagicLotus(String name,int position_x,int position_y){
		super(name,position_x,position_y);
	}
	public boolean Immortalize (Warrior w) {
			System.out.println("The Warrior has become an Immortal");
			w.setImmortal(true);
			return true;
		
	}
	
	

}
