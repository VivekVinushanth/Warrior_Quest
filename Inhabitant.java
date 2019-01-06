
public abstract class Inhabitant {
	private String name; // use of encapsulation
	private int position_x; // so as to insert initial start up position
	private int position_y;
	
	public Inhabitant(String name,int position_x,int position_y){
		this.name=name;
		this.position_x=position_x;
		this.position_y=position_y;
		//Lake.addInhabitant(this, position_x, position_y);
		
	}
		
		
	public int getx(){ //used getters and setters for handling the variables
	    return position_x;
	}
	public void setx(int position_x){
	    this.position_x = position_x;
	}
	public int gety(){
	    return position_y;
	}
	public void sety(int position_y){
	    this.position_y = position_y;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name=name;
	}
	
	public String toString() { //overriding java's toString method
		return (name+"\t\t"+position_x+"\t\t"+position_y);
	}

}











