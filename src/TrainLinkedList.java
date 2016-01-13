/** @author varungoel
 * Name: Varun Goel
 *ID: 109991128
 * email: varun.goel@stonybrook.edu
 * CSE 214 HW 2
 * Recitation Section: 7
 * Recitation TA: Anthony Musco
 * Grading TA: Zhichuang Sun
 */

/**
 * Class for linked list of TrainCar object
 *
 */
public class TrainLinkedList {

	private TrainCarNode head;
	private TrainCarNode tail;


	//size of the list
	int size = 0;
	//total length of the trains on the list
	double trainLength = 0;
	//total weight of the cars on the list
	double trainWeight = 0;
	//total value of the cars on the list
	double value = 0;
	//to check dangerous load
	boolean dangerPresent = false;

	public TrainLinkedList(){
		head = null;
		tail = null;
	}

	/**
	 * Accessor method for head
	 * @return head
	 */
	public TrainCarNode getHead(){
		return head;
	}

	/**
	 * Mutator method for head
	 */
	public void setHead(TrainCar car){
		TrainCarNode carNode = new TrainCarNode(car);
		carNode.setNext(head);

		if(head != null)
			head.setPrevious(carNode);

		head = carNode;

		if (tail == null) 
			tail = head;


		if(car.getProductLoad().getDanger())
			dangerPresent = true; 

		++size;
		trainLength = trainLength + car.getCarLength();
		trainWeight = trainWeight + car.getCarWeight() + car.getProductLoad().getWeight();
		value = value + car.getProductLoad().getValue();
	}

	/**
	 * Accessor method for tail
	 * @return tail
	 */
	public TrainCarNode getTail(){
		return tail;
	}

	/**
	 * Mutator method for tail
	 */
	public void setTail(TrainCar car){
		TrainCarNode carNode = new TrainCarNode(car);
		TrainCarNode nodePtr = head;

		//If the list is currently empty, head == tail 
		if(this.size() == 0){
			tail = carNode;
			head = carNode;
		}

		else{
			for(int i = 1; i < this.size(); i++){
				nodePtr = nodePtr.getNext();
			}
			carNode.setPrevious(nodePtr);
			nodePtr.setNext(carNode);
			tail = carNode; 
		}


		if(car.getProductLoad().getDanger())
			dangerPresent = true; 

		trainLength = trainLength + car.getCarLength();
		trainWeight = trainWeight + car.getCarWeight() + car.getProductLoad().getWeight();
		value = value + car.getProductLoad().getValue(); 
		++size;

	}


	/**
	 * Method to get the size
	 * @return Size of the list
	 */
	public int size(){
		int Size = 0;
		TrainCarNode nodePtr = head;
		while(nodePtr != null){
			Size++;
			nodePtr = nodePtr.getNext();
		}
		return Size;
	}

	/**
	 * Inserts a newCar as a node in the list
	 * @param newCar
	 * @param position
	 * @throws IllegalArgumentException
	 */
	public void insert(TrainCar newCar, int position){
		TrainCarNode nodePtr = head;
		TrainCarNode newCarNode = new TrainCarNode(newCar);

		if(position < 1 | position > this.size() + 1 | newCar == (null)){ 
			throw new IllegalArgumentException();
		}

		if(position == 1){
			setHead(newCar);
		}

		else if(position == this.size() + 1){
			setTail(newCar);
		}

		else{
			for(int i = 1; i < position - 1; i++){

				nodePtr = nodePtr.getNext();
			}

			newCarNode.setNext(nodePtr.getNext());
			newCarNode.setPrevious(nodePtr);
			nodePtr.getNext().setPrevious(newCarNode);
			nodePtr.setNext(newCarNode);

			if(newCar.getProductLoad().getDanger())
				dangerPresent = true; 

			trainLength = trainLength + newCar.getCarLength();
			trainWeight = trainWeight + newCar.getCarWeight() + + newCar.getProductLoad().getWeight();
			value = value + newCar.getProductLoad().getValue(); 
			++size;
		}
	}

	/**
	 * Removes the node at the given position
	 * @param position
	 * @throws IllegalArgumentException
	 */
	public void remove(int position){

		if(position < 1 | this.size() == 0 | position > this.size())
			throw new IllegalArgumentException();

		else{

			TrainCarNode nodePtr = this.head;

			//removes head if list size == 1
			if(position == 1 & this.size() == 1){
				trainLength = trainLength - head.getCar().getCarLength();
				trainWeight = trainWeight - head.getCar().getCarWeight() - nodePtr.getCar().getCarWeight();;
				value = value - head.getCar().getProductLoad().getValue(); 
				head = null;
				tail = null;
				--size;
			}

			else if(position == 1){

				this.setHead(nodePtr.getNext().getCar());
				remove(2);
				remove(2);
			}

			else if(position == this.size()){
				trainLength = trainLength - tail.getCar().getCarLength();
				trainWeight = trainWeight - tail.getCar().getCarWeight();
				value = value - tail.getCar().getProductLoad().getValue(); 
				this.getTail().getPrevious().setNext(null);
				--size;
			}

			else{
				for(int i = 1; i < position; i++)
					nodePtr = nodePtr.getNext();

				trainLength = trainLength - nodePtr.getCar().getCarLength();
				trainWeight = trainWeight - nodePtr.getCar().getCarWeight();
				value = value - head.getCar().getProductLoad().getValue(); 
				nodePtr.getNext().setPrevious(nodePtr.getPrevious());
				nodePtr.getPrevious().setNext(nodePtr.getNext());
				--size;
			}
		}
	}

	/**
	 * Method that returns total length of the train car
	 * @return trainLength
	 */
	public double getLength(){
		return this.trainLength;
	}

	/**
	 * Method that returns total weight of the train car
	 * @return trainWeight
	 */
	public double getWeight(){
		return this.trainWeight;
	}

	/**
	 * Method to get value of the train car
	 * @return value
	 */
	public double getValue(){
		return this.value;
	}

	/**
	 * Method to check if there is a product load that is dangerous. Runs in O(1)
	 * @return dangerPresent
	 */
	public boolean isDangerous(){
		return dangerPresent;
	}

	/**
	 * Additional O(n) helper method to check for dangerous cars
	 * @return boolean value to check if danger is present
	 */
	public boolean isDangerousHelper(){
		TrainCarNode nodePtr = head;
		for(int i = 1; i <= this.size(); i++){
			if(nodePtr.getCar().getProductLoad().getDanger())
				return true;
			nodePtr = nodePtr.getNext();
		}
		return false;
	}

	/**
	 * Finds products with the same name and adds their weight and values and prints them
	 * @param name
	 */
	public void findProduct(String name){
		TrainCarNode nodePtr = head;
		double weight = 0, value = 0;
		boolean danger = false;
		for(int i = 1; i <= this.size(); i++){
			if(nodePtr.getCar().getProductLoad().getName().equals(name)){
				weight = weight + nodePtr.getCar().getProductLoad().getWeight() + nodePtr.getCar().getCarWeight();
				value = value + nodePtr.getCar().getProductLoad().getValue();
				danger = nodePtr.getCar().getProductLoad().getDanger();
			}
			nodePtr = nodePtr.getNext();
		}
		System.out.println("Total weight (in pounds): " + weight + ". Total value (in dollars) " + value + " and danger is " + danger);
	}



	/**
	 * Method to print the Train List
	 */
	public void printManifest(){
		TrainCarNode nodePtr = head;

		System.out.println("Car\t\t\t\t\t\tLoad");
		System.out.println("Num\t    Length\t\tWeight | Name\t\t Weight\t\t   Value\t\tDangerous");

		for(int i = 1; i <= size; i++){
			System.out.print(i + "\t    " + nodePtr.getCar().getCarLength() + "\t\t" + nodePtr.getCar().getCarWeight() +  "  |" +  nodePtr.getCar().getProductLoad().getName()  +  "\t\t " + nodePtr.getCar().getProductLoad().getWeight() + "\t\t  " + nodePtr.getCar().getProductLoad().getValue());
			System.out.print("\t\t");
			printDangerousness(nodePtr.getCar());
			System.out.println();
			nodePtr = nodePtr.getNext();
		}
	}

	/**
	 * Helper method for printManifest to print dangerousness of the car
	 * @param car
	 */
	public static void printDangerousness(TrainCar car){
		if(car.getProductLoad().getDanger())
			System.out.print("YES");
		else
			System.out.print("NO");
	}

	/**
	 * Method to remove all the dangerous cars in the list
	 */
	public void removeDangerousCars(){
		TrainCarNode nodePtr = head;

		for(int i = 1; i <= this.size(); i++){
			if(nodePtr.getCar().getProductLoad().getDanger()){
				this.remove(i);
				i = i - 1;
			}	
			nodePtr = nodePtr.getNext();
		}
	}


	/**
	 * Overrides the toString method for better representation
	 * @return String representation of the list
	 */
	public String toString(){

		return "Total cars: " + this.size() + ". Total length is " + trainLength + ". Total weight is " + trainWeight + ". Total value is " + value + ". Danger is " + isDangerousHelper();
	}

	public static void main(String[] args) {

	}
}
