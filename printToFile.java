
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

public class printToFile implements java.io.Serializable{
	private double Swimming_time;
	
	

	public void EndProcess(Object w){   //concluding the game and signing off with printing to the fileout
		if (w instanceof Warrior) {
			Warrior warr1=(Warrior) w;
		declareWinner(warr1);
		saveWinner(warr1);
		System.exit(0);
		}
	}
	
	
	public double calcSwimming_Time(Warrior w) {
		Swimming_time=(w.getEndTime()-w.getStartTime())/1000000000.000;
		return Swimming_time;
	}
	
	
	public synchronized void declareWinner(Warrior w) {
		calcSwimming_Time(w);
		System.out.println(w.getName()+" has taken "+Swimming_time+"seconds to reach out the Treasure Chest");
		System.out.println("King Arthur is Happy and has announced HeartzRoi island as a property of "+w.getName());
	}
	
	
	BufferedWriter bw=null;
	
	
	public void saveWinner(Warrior w) {  //writing the name of the winner to the 
			String filename="Winner_Result.txt";
		try {
			FileWriter filewriter=new FileWriter(filename);
			//if there doesn't exist a file/create one and do further
			
			BufferedWriter writer =new BufferedWriter(filewriter);
			writer.write("Game Summary\n=============================================");
			writer.newLine();
			writer.write("As per the order of king Arthur 4 Warriors started the quest for Treasurechest with SoulStone");
			writer.newLine();
			writer.write("But "+w.getName()+" has manged to get to reach the TresureChest");
			writer.newLine();
			String time_Taken=Double.toString(Swimming_time)+(" seconds.");
			writer.write(" He need "+time_Taken);
			writer.close();
			
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
			
			
		}
		
	

