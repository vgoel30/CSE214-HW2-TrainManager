/** @author varungoel
 * Name: Varun Goel
 *ID: 109991128
 * email: varun.goel@stonybrook.edu
 * CSE 214 HW 2
 * Recitation Section: 7
 * Recitation TA: Anthony Musco
 * Grading TA: Zhichuang Sun
 */
import java.util.*;
public class TrainManager {



	static Scanner input = new Scanner(System.in);

	/**
	 * Static method to print the menu from where the user can select what they want to do next
	 */
	public static void printMenu(){
		System.out.println("(F) Cursor Forward	(B) Cursor Backward	(I) Insert after cursor");
		System.out.println("(R) Remove Car at Cursor	(L) Set Product Load	(S) Search for product load");
		System.out.println("(T) Display train	(M) Display manifest");
		System.out.println("(D) Remove Dangerous Cars	(Q) Quit");
	}


	public static void main(String[] args) {
		TrainLinkedList list = new TrainLinkedList();
		int cursorPosition = 0; //to keep track of current position of cursor
		ProductLoad defaultProductLoad = new ProductLoad("Empty",0,0,false);
		TrainCarNode cursor = list.getHead(); 


		printMenu();
		String option = input.nextLine().toUpperCase();

		while(!option.equals("Q")){

			//if user wants to move cursor forward
			if(option.equals("F")){
				if(cursorPosition == list.size() || cursor == null){
					System.out.println("No next car, cannot move cursor forward. (Press enter to proceed)");
					input.nextLine();
				}
				else{
					cursor = cursor.getNext();

					cursorPosition = cursorPosition + 1;

				}
			}

			//if user wants to move cursor backward
			else if(option.equals("B")){
				if(cursorPosition == 1 || cursor==(null)){
					System.out.println("No previous car, cannot move cursor backward.(Press enter to proceed)");
					input.nextLine();
				}
				else{
					cursor = cursor.getPrevious();



					if(cursorPosition != list.size())
						cursor.getNext().setPrevious(cursor);

					cursorPosition = cursorPosition - 1;

					if(cursorPosition != 1 )
						cursor.getPrevious().setNext(cursor);


				}
			}

			//If user wants to insert a new Car
			else if(option.equals("I")){
				double length;
				double weight;
				do{
					System.out.println("Enter car length (+ve value only)");
					length = input.nextDouble();
				}while(length <= 0);
				do{
					System.out.println("Enter car weight");
					weight = input.nextDouble();
				}while(weight <= 0);
				TrainCar newCar = new TrainCar(length,weight);
				newCar.setProductLoad(defaultProductLoad);
				TrainCarNode carNode = new TrainCarNode(newCar);
				list.insert(newCar, cursorPosition + 1);
				System.out.println("Train car of length " + length + " and weight " + weight + " inserted at position " + (cursorPosition + 1));


				carNode.setPrevious(cursor);
				cursor = carNode;
				cursorPosition++;



				input.nextLine();
			}

			//If user wants to remove the car at cursor
			else if(option.equals("R")){
				if(list.size() == 0)
					System.out.println("List is empty, can't remove anything!");
				else{
					list.remove(cursorPosition);
					cursorPosition--;
				}
			}
			//If user wants to set the product load
			else if(option.equals("L")){
				String danger = "";

				System.out.println("Enter product name");
				String name = input.nextLine();
				System.out.println("Enter weight");
				double weight = input.nextDouble();
				System.out.println("Enter value");
				double value = input.nextDouble();

				do{
					System.out.println("Is the product dangerous? (y/n)");
					danger = input.next();
				}while(!danger.equals("y") && !danger.equals("n"));

				boolean dangerous =  (danger.equals("y")) ? true : false;

				ProductLoad load = new ProductLoad(name,weight,value, dangerous);
				cursor.getCar().setProductLoad(load);
				list.trainWeight = list.trainWeight + cursor.getCar().getProductLoad().getWeight();
				list.value = list.value + load.getValue();
			}

			else if(option.equals("S")){
				System.out.println("Enter product name");
				String name = input.nextLine();
				list.findProduct(name);
			}

			//to print the train
			else if(option.equals("T")){
				System.out.println(list.toString());
			}

			else if(option.equals("M")){
				System.out.println();
				System.out.println("Cursor currently at " + cursorPosition);
				System.out.println();
				list.printManifest();
			}
			else if(option.equals("D")){
				list.removeDangerousCars();
				cursorPosition--;
			}
			System.out.println();
			printMenu();
			option = input.nextLine().toUpperCase();
		}

	}

}
