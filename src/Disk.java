/**
 * Disk class - used to represent a disk in an enigma machine
 * @author Aaron Brengelman
 * Updated last:11/7/2017
 */
public class Disk {
	private char[] turnover = "RFWKA".toCharArray();
	private char[] diskI = "EKMFLGDQVZNTOWYHXUSPAIBRCJ".toCharArray();
	private char[] diskII = "AJDKSIRUXBLHWTMCQGZNPYFVOE".toCharArray();
	private char[] diskIII = "BDFHJLCPRTXVZNYEIWGAKMUSQO".toCharArray();
	private char[] diskIV = "ESOVPZJAYQUIRHXLNFTGKDCMWB".toCharArray();
	private char[] diskV = "VZBRGITYUPSDNHLXAWMJQOFECK".toCharArray();
	private char[][] disks = { diskI, diskII, diskIII, diskIV, diskV };
	private int position, disknum;
	private char[] disk;
	
	/**
	 * sets the key for the disk
	 * @param disk
	 */
	public Disk(int disk) {
		this.disk = disks[disk];
		disknum = disk - 1;
		position = 0;
	}
	
	/**
	 * sets the key for the disk and sets the position
	 * @param disk
	 */
	public Disk(int disk,int position) {
		this.disk = disks[disk];
		disknum = disk;
		this.position = 0;
		setPosition(position);
	}
	
	/**
	 * Magic that some how runs the input through the disk
	 * @param x -input
	 * @return -returns the new char (x)
	 */
	public char forward(char x) {
		x = disk[Convert.CharInt(x)];
		return Convert.IntChar((Convert.CharInt(x) + (26 - position)) % 26);
	}

	/**
	 * Magic that some how runs the input through the disk in reverse
	 * @param x -input
	 * @return -returns the new char (x)
	 */
	public char back(char x) { // runs a char through the disk back
		int y;
		for (y = 0; y < 26; y++) {
			if (disk[y] == Convert.IntChar((Convert.CharInt(x) + position) % 26))
				return Convert.alpu[y];
		}
		return ' ';
	}

	/**
	 * Sets the disk position to x
	 * @param x -the position to set the disk to
	 */
	public void setPosition(int x) {
		if (x < position) {
			Convert.ShiftChar(disk, x + 26 - position);
			position = x;
		} 
		else if (x == position) {
		} 
		else {
			Convert.ShiftChar(disk, x - position);
			position = x;
		}

	}
	
	/**
	 * adds position do disk and rotates the key
	 */
	public void addPosition() {
		Convert.ShiftChar(disk, 1);
		position = (position + 1) % 26;
	}
	
	/**
	 * get statement for int position
	 * @return - position in int form
	 */
	public int getPosition() { // returns the position
		return position;
	}

	/**
	 * get the disk number
	 * @return - label for key used in disk
	 */
	public int getDisk() { // returns the disk ID
		return disknum;
	}
	
	/**
	 * Checks to see if the next disk in the row needs to be turned over
	 * @return - true or false based on whether the next disk needs to be rotated
	 */
	public boolean getTurnOver() {
		if (position == Convert.CharInt(turnover[disknum]))
			return true;
		return false;
	}

}
