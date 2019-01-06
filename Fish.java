
public abstract class Fish extends Inhabitant{
	 //creation of the abstract class,so that i could extend at anytime and use it.
		protected static int no_of_fish=0;
		//creation of fish class
		
		 public Fish (String name,int position_x,int position_y){
			 super(name,position_x,position_y);
				no_of_fish++;
				name=this.getName();
				position_x=this.getx();
				position_y=this.gety();
				
				
		 }
		 

}
