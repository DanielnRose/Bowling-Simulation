import java.io.*; 
import java.util.*;

//keps track of how many pins have fallen

public class score{

	private int pinfall;
		
	public score(){
		int pinfall = 0;
	}
	//set the pinfall value
	public void setPinfall(int p){
		pinfall = p;
	}
	//get the pinfall value
	public int getPinfall(){
		return pinfall;
	}

}