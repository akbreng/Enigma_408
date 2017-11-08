import java.util.Scanner;

public class Enigma {
	private Scanner key;
	private Disk[] disks; // disks
	private Reflector ref; // reflector
	private char[] plugboard; //plug board

	public Enigma(Scanner key) { //constructor for the Enigma machine
		this.key = key;
		disks = new Disk[3]; //sets disks to default
		disks[0] = new Disk(1);
		disks[1] = new Disk(2);
		disks[2] = new Disk(3);
		ref = new Reflector('B'); //sets default reflector
		plugboard = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray(); //sets plug board to be blank
	}
	
	public void promptPlugboard(){
		// PLUGBOARD
		int x;
		plugboard = new char[26];
		char charinput = 0;
		
		boolean selected;
		boolean paired;
		int i;
		for (i = 0; i < 10; i++) {
			selected = false;
			System.out.print("Please select letter to pair: ");
			while (!selected){
				x = Convert.CharInt(key.next().toUpperCase().charAt(0));
				if (plugboard[x] == 0) {
					if (plugboard[Convert.CharInt(charinput)] != 0)
						System.out.print(charinput + " has been paired already \nPlease enter new letter: ");
					else if (charinput == Convert.alpu[x])
						System.out.print(charinput + " can not be pair with itself\nPlease enter new letter: ");
					else {
						System.out.print("Please select letter to pair with " + Convert.alpu[x] + ": ");
						paired = false;
						while (!paired) {
							charinput = key.next().toUpperCase().charAt(0);
							if (plugboard[Convert.CharInt(charinput)] != 0)
								System.out.print(charinput + " has been paired already \nPlease enter new letter: ");
							else if (charinput == Convert.alpu[x])
								System.out.print(charinput + " can not be pair with itself\nPlease enter new letter: ");
							else {
								plugboard[x] = charinput;
								plugboard[Convert.CharInt(charinput)] = Convert.IntChar(x);
								paired = true;
							}
						}
					}
				}
			}
		}
	}
	public void PromptReflector(){
		//SELECTING REFLECTOR
		
				System.out.println("Reflector: A , B , C");
				System.out.print("Please select Reflector: ");
				ref = new Reflector(Convert.CharInt(key.next().toUpperCase().charAt(0)));
	}
	public void PromptDisks(){
		// SELECTING THE ORDER OF DISKS
		
		int x;
		System.out.println("Disks: I , II , III , IV , V");
		System.out.print("Please select first disk: ");
		x = key.nextInt();
		disks[0] = new Disk(x);
		while (x == disks[0].getDisk())
		{
			System.out.print("Please select second disk: ");
			x = key.nextInt();
			if (x == disks[0].getDisk())
				System.out.println("Disk can not be used more than once");
		}
		disks[1] = new Disk(x);
		while (x == disks[0].getDisk() || x == disks[1].getDisk())
		{
			System.out.print("please select third disk: ");
			x = key.nextInt();
			if (x == disks[0].getDisk() || x == disks[1].getDisk())
				System.out.println("Disk can not be used more than once");
		}
		disks[2] = new Disk(x);
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
}
