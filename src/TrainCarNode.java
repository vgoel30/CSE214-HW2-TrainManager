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
 * Node wrapper class for TrainCar object
 */

public class TrainCarNode {
	
	private TrainCarNode previous;
	private TrainCarNode next;
	private TrainCar car;
	
	/**
	 * Default constructor with no parameters
	 */
	public TrainCarNode(){	
	}
	
	/**
	 * Constructor with one TrainCar parameter
	 * @param car
	 */
	public TrainCarNode(TrainCar car){
		this.car = car;
	}
	
	/**
	 * Accessor method for the previous TrainCarNode
	 * @return previous
	 */
	public TrainCarNode getPrevious(){
		return previous;
	}
	
	/**
	 * Mutator method for the previous TrainCarNode
	 * @param previous
	 */
	public void setPrevious(TrainCarNode previous){
		 this.previous = previous;
	}
	
	/**
	 * Accessor method for the next TrainCarNode
	 * @return previous
	 */
	public TrainCarNode getNext(){
		return next;
	}
	
	/**
	 * Mutator method for the next TrainCarNode
	 * @param previous
	 */
	public void setNext(TrainCarNode next){
		 this.next = next;
	}
	
	/**
	 * Accessor method for car
	 * @return car
	 */
	public TrainCar getCar(){
		return car;
	}
	
	/**
	 * Mutator method for car
	 * @param car
	 */
	public void setCar(TrainCar car){
		this.car = car;
	}
	
	public String toString(){
		return this.getCar().toString();
	}
}
