import java.util.Scanner;

public class Enigma {
	private Scanner key;
	private Disk[] disks; // disks
	private Reflector ref; // reflector
	private char[] plugboard; //plug board

	public Enigma() { //constructor for the Enigma machine
		disks = new Disk[3]; //sets disks to default
		disks[0] = new Disk(2);
		disks[1] = new Disk(1);
		disks[2] = new Disk(0);
		ref = new Reflector('B'); //sets default reflector
		plugboard = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray(); //sets plug board to be blank
	}
	
	public String Encrypt(String stringInput)
	{
		String str = "";
		
		for(int x = 0; x < stringInput.length(); x++)
		{
			str = str + Encrypt(stringInput.charAt(x));
			
		}
		return str;
	}
	
	public char Encrypt(char charinput) //rotates disks and puts value through the Enigma machine
	{
		
		disks[0].addPosition();
		if (disks[0].getTurnOver()){
			disks[1].addPosition();
			if (disks[1].getTurnOver()){
				disks[2].addPosition();
			}
		}
		charinput = plugboard[Convert.CharInt(charinput)];
		charinput = disks[0].forward(charinput);
		charinput = disks[1].forward(charinput);
		charinput = disks[2].forward(charinput);
		charinput = ref.forward(charinput);
		charinput = disks[2].back(charinput);
		charinput = disks[1].back(charinput);
		charinput = disks[0].back(charinput);
		charinput = plugboard[Convert.CharInt(charinput)];
		return charinput;
	}
	
	public void setDiskPosition(int slot, int position){
		disks[slot].setPosition(position);
	}
	
	public void setDisk(int slot, int disk, int position){
		disks[slot] = new Disk(disk, position);
	}
	
	public int getDisk(int slot){
		return disks[slot].getDisk();
	}
	
	public int getPosition(int slot){
		return disks[slot].getPosition();
	}
	
	public void setPlugboard(char[] plug){
		plugboard = plug;
	}
	
	public char[] getPlugboard(){
		return plugboard;
	}
}
