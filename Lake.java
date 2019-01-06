
public class Lake {
	TreasureChest Chest1;
	
	private static Lake NozamaLake;   //singleton-to prevent from creating more than one lake object
	public static Lake initiateLake() {
		if (NozamaLake==null) {
			NozamaLake= new Lake();
		}
		return NozamaLake;
		
	}
	
	private static LakeNode[][] GridPoints = new LakeNode[11][11]; // creating all nodes needed
	private  Lake() {
		for (int i=0;i<=10;i++) {
			for (int j=0;j<=10;j++) {
				GridPoints[i][j]= new LakeNode(i,j);
			}
			
			
		}
	}
	
	public static void addInhabitant(Inhabitant chara,int posi_x,int posi_y) {
		GridPoints[posi_x][posi_y].addInhabit(chara);
		chara.setx(posi_x);
		chara.sety(posi_y);
	}
	
	public static void removeInhabitant(Inhabitant chara,int posi_x,int posi_y) {
		GridPoints[posi_x][posi_y].removeInhabit(chara);
		chara.setx(posi_x);
		chara.sety(posi_y);
	}
		
	public static boolean movable(int posx,int posy) {
		if (0<=posx && posx<=10 && 0<=posy && posy<=10) {
				
			
			return true;
		}
		return false;
		
	}
	

}
