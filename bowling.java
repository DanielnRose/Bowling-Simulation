//Daniel Rose
//This program is a bowling simulation
//It simulated the first shot of a bowling frame and shows an animation for the different shots
//the animation works best if the size of the command promt is the size of the lane
//I also included a gif on me running the code incase it does not show up properly

//import
 import java.util.*;
 import java.util.concurrent.TimeUnit;
 import java.lang.Thread;
 
public class bowling {
  //main class
  public static void main(String[] args) {
	  //arraylist keeps track of scores and playagain allows you to shoot multiple shots
	  ArrayList<String> sl = new ArrayList<String>(10);
	  boolean playagain = true;
	  while(playagain == true){
	  
	  //declar where someone is standing and shooting
	  int standing = 1;
	  int aim = 1;
	  //print the lane with the numbers for aiming and shooting
	  System.out.println("|---------|");
	  System.out.println("| o o o o |");
	  System.out.println("|  o o o  |");
	  System.out.println("|   o o   |");
	  System.out.println("|    o    |");
	  for(int j = 0; j < 8; j++){
		System.out.println("|         |");
	  }
	  System.out.println("|1 2 3 4 5|");
	  for(int j = 0; j < 9; j++){
		System.out.println("|         |");
	  }
	  System.out.println("|1 2 3 4 5|");
	  
	  //Get the input of where you are aiming
	  System.out.println("Welcome To Bowling!!!");
	  System.out.print("Where will you be standing(1-5): ");
	  
	  //scan where you are standing and aiming
	  Scanner scan = new Scanner(System.in);
	  standing = scan.nextInt();
	  System.out.print("Where will you be aiming(1-5): ");
	  aim = scan.nextInt();
	  
	  //get which shot will take place
	  int[] goodshot = pinOutcome(standing);
	  int shot = goodshot[aim-1];
	  
	  //put the shot into the score
	  score s = new score();
	  s.setPinfall(shot);
	  
	  //print the shot sending the score s and where you were standing
	  lanePrint(s, standing);
	  
	  if (s.getPinfall() == 0){
		  sl.add("Gutter");
	  }
	   else if (s.getPinfall() == 1){
		  sl.add("Strike");
	  }
	   else if (s.getPinfall() == 2 || s.getPinfall() == 3){
		  sl.add("6 Pins");
	  }
	  
	  //Play again allows you to take another shot
	  System.out.print("Do you want to take another striks shot (Y/N): ");
	  char play = scan.next().charAt(0);
	  if (play == 'N' || play == 'n'){
		  playagain = false;
		}
		
		System.out.println("Your Shots: " +sl);
	}
  }
//this decodes each possible shot to one of 4 options
public static int[] pinOutcome(int pos){
	
	int[] goodshot = {0, 0, 0, 0, 0};
	//0 means gutter
	//1 means strike
	//2 means left side pins
	//3 means right side pins
	  switch (pos) {
            case 1:  int[] goodshot1 = {0, 1, 3, 0, 0};
					 goodshot = goodshot1;
					 return goodshot;
            case 2:  int[] goodshot2 = {0, 2, 3, 0, 0};
					 goodshot = goodshot2;
					 return goodshot;
            case 3:  int[] goodshot3 = {0, 0, 1, 0, 0};
					 goodshot = goodshot3;
					 return goodshot;
            case 4:  int[] goodshot4 = {0, 0, 2, 3, 0};
					 goodshot = goodshot4;
					 return goodshot;
            case 5:  int[] goodshot5 = {0, 0, 3, 1, 0};
					 goodshot = goodshot5;
					 return goodshot;
  }
	
	return goodshot;
}

//animations for once the ball hits the pins and the pins fall
//this is called from LanePrint
public static void emptyLane(char fall){
	//this is for all the pins are still there
	if (fall == 'c'){
		System.out.println("|---------|");
		System.out.println("| o o o o |");
		System.out.println("|  o o o  |");
		System.out.println("|   o o   |");
		System.out.println("|    o    |");
		for (int i =0; i<18; i++){
			System.out.println("|         |");
			}
	}	
	//this is for when the lane is empty
	else if (fall == 'e'){
		int x = 0;
		while (x < 5){
			
			System.out.println("|---------|");
			if (x < 4){
				System.out.println("| o o o o |");
			}
			if (x < 3){
				System.out.println("|  o o o  |");
				if (x < 2){
					System.out.println("|   o o   |");
				}
			}
			for (double i =0; i<(19+x); i++){
				System.out.println("|         |");
			}
			
			x++;
			delay(120);
		}
		
	}
	//this is when the ball will hit the left side of the lane
	//this is the animation fot the pins going down
	else if (fall == 'l'){
		int x = 1;
		while (x <= 3){
			
			if (x == 3){
				System.out.println("|---------|");
				System.out.println("|       o |");
				System.out.println("|      o  |");
				System.out.println("|     o   |");
				System.out.println("|    o    |");
			}
			else if (x == 2){
				System.out.println("|---------|");
				System.out.println("| o o o o |");
				System.out.println("|      o  |");
				System.out.println("|     o   |");
				System.out.println("|    o    |");
			}
			else	if (x == 1){
				System.out.println("|---------|");
				System.out.println("| o o o o |");
				System.out.println("|  o o o  |");
				System.out.println("|     o   |");
				System.out.println("|    o    |");
			}
				
			//here is my double
			for (double i =0; i<(18); i++){
				System.out.println("|         |");
			}
			
			x++;
			delay(120);
		}
		
	}
	//this is when the ball will hit the right side of the lane
	//this is the animation fot the pins going down
	else if (fall == 'r'){
		int x = 1;
		while (x <= 3){
			
			if (x == 3){
				System.out.println("|---------|");
				System.out.println("| o       |");
				System.out.println("|  o      |");
				System.out.println("|   o     |");
				System.out.println("|    o    |");
			}
			else if (x == 2){
				System.out.println("|---------|");
				System.out.println("| o o o o |");
				System.out.println("|  o      |");
				System.out.println("|   o     |");
				System.out.println("|    o    |");
			}
			else	if (x == 1){
				System.out.println("|---------|");
				System.out.println("| o o o o |");
				System.out.println("|  o o o  |");
				System.out.println("|   o     |");
				System.out.println("|    o    |");
			}
				
			//here is my double
			for (double i =0; i<(18); i++){
				System.out.println("|         |");
			}
			
			x++;
			delay(120);
		}
	}
}



//This prints the lane as the ball is moving down it
//for each senario there is 4 loops
//one that prints the space before the ball as it moves 
//one that prints the space to the left of the ball as it moves 
//one that prints the space on the right of the ball as it moves 
//and the last one for each senario prints the space below the ball as it moves 
//This then calls empryLane() to then clear the lane depending on where the ball is
public static void lanePrint(score s, int standing){
	//different counters
	double c2 = 0;
	double c3 = 0;
	double c4 = 0;
	int score = s.getPinfall();
	
	//0 is gutter
	if (score == 0){
		//the ball with move 18 frames
		for(int j = 0; j < 18; j++){
			System.out.println("|---------|");
			System.out.println("| o o o o |");
			System.out.println("|  o o o  |");
			System.out.println("|   o o   |");
			System.out.println("|    o    |");
			c2 = 0;
			while (c2<(18-j)){
				System.out.println("|         |");		
				c2++; 
			}
			System.out.print("|");
			c3 = 0;
			while (c3 < (j/2)){
				System.out.print(" ");
				c3++;
			}
				System.out.print("O");
			c4 = 0;
			while (c4 < (8-(j/2))){
				System.out.print(" ");
				c4++;
			}
			System.out.println("|");
			c2 = 0;
			while (c2<(j)){
				System.out.println("|         |");		
				c2++;
			}
			delay(120);
		}
		emptyLane('c');
	    System.out.println("You Guttered");
	}
	
	
	//1 is strike
	if (score == 1){
		for(int j = 0; j < 20; j++){
			System.out.println("|---------|");
			System.out.println("| o o o o |");
			System.out.println("|  o o o  |");
			System.out.println("|   o o   |");
			System.out.println("|    o    |");
			c2 = 0;
			while (c2<(18-j)){
				System.out.println("|         |");		
				c2++; 
			}
			System.out.print("|");
			c3 = 0;
			while (c3 < (j/4)-1){
				System.out.print(" ");
				c3++;
			}
				System.out.print("O");
			c4 = 0;
			if (j <= 4) {
				while (c4 <  8){
				System.out.print(" ");
				c4++;
				}
			}
			else{
			while (c4 < (9-(j/4))){
				System.out.print(" ");
				c4++;
			}
			}
			System.out.println("|");
			c2 = 0;
			while (c2<(j)){
				System.out.println("|         |");		
				c2++;
			}
			delay(120);
		}
		emptyLane('e');
		System.out.println("You Got a Strike!!!");
		
	}
	//2 is left side pins
	if (score == 2){
		for(int j = 0; j < 20; j++){
			System.out.println("|---------|");
			System.out.println("| o o o o |");
			System.out.println("|  o o o  |");
			System.out.println("|   o o   |");
			System.out.println("|    o    |");
			c2 = 0;
			while (c2<(18-j)){
				System.out.println("|         |");		
				c2++; 
			}
				System.out.println("|  0      |");
			c2 = 0;
			while (c2<j){
				System.out.println("|         |");		
				c2++;
			}
			delay(120);
		}
		emptyLane('l');
		System.out.println("You got 6 pins");
		
	}
	
	//3 is right side pins
	if (score == 3){
		for(int j = 0; j < 20; j++){
			System.out.println("|---------|");
			System.out.println("| o o o o |");
			System.out.println("|  o o o  |");
			System.out.println("|   o o   |");
			System.out.println("|    o    |");
			c2 = 0;
			while (c2<(18-j)){
				System.out.println("|         |");		
				c2++; 
			}
				System.out.println("|      O  |");
			c2 = 0;
			while (c2<j){
				System.out.println("|         |");		
				c2++;
			}
			delay(120);
		}
		emptyLane('r');
		System.out.println("You got 6 pins");
		
	}
	
}
//this creates a delay with a given ms value for the animations
public static void delay(int ms) {
    try {
        Thread.sleep(ms);
    } catch (InterruptedException e) {
        System.err.format("IOException: %s%n", e);
    }
}

}