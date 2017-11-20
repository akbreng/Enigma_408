
public class Convert {
	public static char[] alpu =("ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
	public static int CharInt (char nxt)
	{
		//error is here, changed the final return to 25 but still not right
		
		int z;
		for (z=0; z<26; z++ )
		{
			if (nxt == alpu[z])
				return z;				
		}
		return 25;
	}
	public static char IntChar (int x){
		return alpu[x];
	}
	public static char[] ShiftChar(char[] x,int y){
		char z,w;
		int i;
		for (w=0;w<y;w++){
			z=x[0];
			for (i=0;i<25;i++)
				x[i]=x[i+1];
			x[25]=z;
		}
		return x;
	}
}
