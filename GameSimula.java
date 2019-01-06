import java.util.*;
import java.util.concurrent.TimeUnit;
public class GameSimula {

	public static void main(String args[]) throws Exception{
		printWithDelays("Loading........ . . . . . .1%",TimeUnit.MILLISECONDS,50);
		printWithDelays("Loading......... .98% ...99%..100%",TimeUnit.MILLISECONDS,50);
		System.out.println();
		printWithDelays("Welcome to My Warrior Game Simulation!!!!!!    ",TimeUnit.MILLISECONDS,50);
		printWithDelays("Once there was a Lake called Nozama..... ",TimeUnit.MILLISECONDS,50);
		printWithDelays("But it has deadly fishes and fishes that pull fins and immortalizing Magic Lotus-*",TimeUnit.MILLISECONDS,50);
		printWithDelays("There was a TreasureChest in the lake..... ",TimeUnit.MILLISECONDS,50);
		printWithDelays("There was a SoulStone in the Treasury......",TimeUnit.MILLISECONDS,50);
		printWithDelays("King Arthur wanted that treasury. .. ....",TimeUnit.MILLISECONDS,50);
		printWithDelays("He ordered his warrriors to get in and seize the chest",TimeUnit.MILLISECONDS,50);
		printWithDelays("Here we GO!!!!!!!!",TimeUnit.MILLISECONDS,50);
		
		printWithDelays("Iniating the Lake of NOZAMA!!",TimeUnit.MILLISECONDS,50);
		System.out.println("|:::::::::::::::::::::::::|"); 
		System.out.println("|:::::::::::::::::::::::::|");
		System.out.println("|:::::::::::::::::::::::::|");
		System.out.println("|:::::::::::::::::::::::::|");
		System.out.println("|:::::::::{treasure}::::::|");
		System.out.println("|:::::::::::::::::::::::::|");
		System.out.println("|:::::::::::::::::::::::::|");
		System.out.println("|:::::::::::::::::::::::::|");
		System.out.println("|:::::::::::::::::::::::::|");
		System.out.println("|:::::::::::::::::::::::::|");
		System.out.println("|:::::::::::::::::::::::::|");
		
		Lake NozamaLake=Lake.initiateLake(); //iniating the lake
		
		System.out.println();
		printWithDelays("Iniating the Warriors and placing them on grid!!",TimeUnit.MILLISECONDS,50);
		System.out.println("........................................");
		
		NormalWarrior warr1 =new NormalWarrior("Captain America",0,0);
		Thread player1=new Thread(warr1);
		
		NormalWarrior warr2 =new NormalWarrior("Hercules",10,0);
		Thread player2=new Thread(warr2);
		
		SuperWarrior warr3 =new SuperWarrior("Shazmzerian",10,9);
		Thread player3=new Thread(warr3);
		
		NormalWarrior warr4 =new NormalWarrior("Punisher",2,0);
		Thread player4=new Thread(warr4);
		
		printWithDelays(warr1.getName()+"\tof "+ warr1.getClass()+"\tis placed at ("+warr1.getx()+","+warr1.gety()+") !!",TimeUnit.MILLISECONDS,50);
		printWithDelays(warr2.getName()+"\tof "+ warr2.getClass()+"\tis placed at ("+warr2.getx()+","+warr2.gety()+") !!",TimeUnit.MILLISECONDS,50);
		printWithDelays(warr3.getName()+"\tof "+ warr3.getClass()+"\tis placed at ("+warr3.getx()+","+warr3.gety()+") !!",TimeUnit.MILLISECONDS,50);
		printWithDelays(warr4.getName()+"\tof "+ warr4.getClass()+"\tis placed at ("+warr4.getx()+","+warr4.gety()+") !!",TimeUnit.MILLISECONDS,50);
	 	
		//===================================================================================================================================
		System.out.println();
		printWithDelays("Iniating the fishes and placing them on grid!!",TimeUnit.MILLISECONDS,50);
		System.out.println("........................................");
		
		Inhabitant fish1=new KillerFish("Piranha",5,3);
		Inhabitant fish2=new KillerFish("EEl",1,2);               //with the reference of inhabitant super class-polymorphism is used
		Inhabitant fish3=new InnocentFish("Torpedo",7,4);
		Inhabitant fish4=new InnocentFish("Vimba",3,2);
		Inhabitant fish5=new eRubber("Manta",5,8);
		Inhabitant fish6=new eRubber("Candiru",4,2); ////
		
		
		printWithDelays(fish1.getName()+"\tof "+ fish1.getClass()+"\tis placed at ("+fish1.getx()+","+fish1.gety()+") !!",TimeUnit.MILLISECONDS,50);
		printWithDelays(fish2.getName()+"\tof "+ fish2.getClass()+"\tis placed at ("+fish2.getx()+","+fish2.gety()+") !!",TimeUnit.MILLISECONDS,50);
		printWithDelays(fish3.getName()+"\tof "+ fish3.getClass()+"\tis placed at ("+fish3.getx()+","+fish3.gety()+") !!",TimeUnit.MILLISECONDS,50);
		printWithDelays(fish4.getName()+"\tof "+ fish4.getClass()+"\tis placed at ("+fish4.getx()+","+fish4.gety()+") !!",TimeUnit.MILLISECONDS,50);
		printWithDelays(fish5.getName()+"\tof "+ fish5.getClass()+"\tis placed at ("+fish5.getx()+","+fish5.gety()+") !!",TimeUnit.MILLISECONDS,50);
		printWithDelays(fish6.getName()+"\tof "+ fish6.getClass()+"\tis placed at ("+fish6.getx()+","+fish6.gety()+") !!",TimeUnit.MILLISECONDS,50);
		
		
		//===================================================================================================================================
		System.out.println();
		printWithDelays("Iniating the fishes and placing them on grid!!",TimeUnit.MILLISECONDS,50);
		System.out.println("........................................");
		
		Inhabitant lotus1=new Lotus("lotus_1",5,2);
		Inhabitant lotus2=new MagicLotus("Mlotus_2",1,0);
		Inhabitant lotus3=new Lotus("Lotus__3",3,7);
		Inhabitant lotus4=new MagicLotus("Mlotus_4",8,3);
		Inhabitant lotus5=new Lotus("Lotus_5",7,7);
		
		printWithDelays(lotus1.getName()+"\tof "+ lotus1.getClass()+"\tis placed at ("+lotus1.getx()+","+lotus1.gety()+") !!",TimeUnit.MILLISECONDS,50);
		printWithDelays(lotus2.getName()+"\tof "+ lotus2.getClass()+"\tis placed at ("+lotus2.getx()+","+lotus2.gety()+") !!",TimeUnit.MILLISECONDS,50);
		printWithDelays(lotus3.getName()+"\tof "+ lotus3.getClass()+"\tis placed at ("+lotus3.getx()+","+lotus3.gety()+") !!",TimeUnit.MILLISECONDS,50);
		printWithDelays(lotus4.getName()+"\tof "+ lotus4.getClass()+"\tis placed at ("+lotus4.getx()+","+lotus4.gety()+") !!",TimeUnit.MILLISECONDS,50);
		printWithDelays(lotus5.getName()+"\tof "+ lotus5.getClass()+"\tis placed at ("+lotus5.getx()+","+lotus5.gety()+") !!",TimeUnit.MILLISECONDS,50);
		
		
		
	//=============================================================================================================================================	
		
		
		
		Lake.addInhabitant(warr1, 0, 0);
		Lake.addInhabitant(warr2, 10, 0);
		Lake.addInhabitant(warr3, 10, 9);
		Lake.addInhabitant(warr4, 2, 0);//adding warriors to the nodes initilally
		
		Lake.addInhabitant(fish1, 5, 3);
		Lake.addInhabitant(fish2, 1, 2);
		Lake.addInhabitant(fish3, 7, 4);
		Lake.addInhabitant(fish4, 3, 2);
		Lake.addInhabitant(fish5, 5, 8);
		Lake.addInhabitant(fish6, 4, 2);//adding fishes to the nodes
		
		Lake.addInhabitant(lotus1, 5,2);
		Lake.addInhabitant(lotus2, 1,0);
		Lake.addInhabitant(lotus3, 3,7);
		Lake.addInhabitant(lotus4, 8,3);
		Lake.addInhabitant(lotus5, 7,7);
		
		//=============================================================================================
		
		System.out.println();
		printWithDelays("Game Begins....>>>>",TimeUnit.MILLISECONDS,100);
		warr1.notifyChest(); //here notifying the chest about the start of movement
		warr2.notifyChest();
		warr3.notifyChest();
		warr4.notifyChest();
		System.out.println();
		
		player1.start(); //here starting the threads-means of swimming begins here
		player2.start();
		player3.start();
		player4.start();
		
	}
		
		public static void printWithDelays(String data,TimeUnit unit,long delayTIME) throws InterruptedException {
	        for (char ch : data.toCharArray()) {                                    //itterate
	            System.out.print(ch);                                               //print Character
	            unit.sleep(delayTIME);                                                  //print with delay
	        }
	        System.out.println();
	    }
		
		
		
		
	
}	
		
		
		

