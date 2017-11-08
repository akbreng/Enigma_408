/**
 * Reflector class - used to represent a reflector in an enigma machine
 * @author Aaron Brengelman
 *	Updated last:11/7/2017
 */
public class Reflector {
	private char[] reflectorA = "EJMZALYXVBWFCRQUONTSPIKHGD".toCharArray();
	private char[] reflectorB = "YRUHQSLDPXNGOKMIEBFZCWVJAT".toCharArray();
	private char[] reflectorC = "FVPJIAOYEDRZXWGCTKUQSBNMHL".toCharArray();
	private char[][] reflectors  = {reflectorA,reflectorB,reflectorC};
	private int refl;
	
	/**
	 * sets the key for the reflector
	 * @param refl - selects the key to use for the reflector
	 */
	public Reflector(int refl) { // constructor for disk with int
		this.refl = refl-1;
	}
	public Reflector(char refl) { // constructor for disk with char
		this.refl = Convert.CharInt(refl);
	}

	/**
	 * inputs a char and returns the reflection of the char from selected key
	 * @param x - input char to be reflected
	 * @return = returns the char that has been reflected
	 */
	public char forward(char x) { //runs a char through the reflector
		return reflectors[refl][Convert.CharInt(x)];
	}
}
