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
 * Class to define TrainCar object
 *
 */
public class TrainCar {

	private double carLength;
	private double carWeight;
	private ProductLoad load ;

	/**
	 * Default constructor
	 */
	public TrainCar(){
	}

	/**
	 * Constructor with parameters
	 * @param length
	 * @param weight
	 */
	public TrainCar(double length, double weight){
		carLength = length;
		carWeight = weight;
	}



	/**
	 * Accessor method for length;
	 * @return length;
	 */
	public double getCarLength(){
		return carLength;
	}

	/**
	 * Accessor method for weight;
	 * @return length;
	 */
	public double getCarWeight(){
		return carWeight;
	}

	/**
	 * Accessor method for load
	 * @return load
	 */
	public ProductLoad getProductLoad(){
		return load;
	}

	/**
	 * Mutator method for load
	 * @param name
	 * @param weight
	 * @param isDangerous
	 */
	public void setProductLoad(ProductLoad load){
		this.load = load;
	}

	/**
	 * Method to check whether load is empty or not
	 * @return boolean value for whether the load is empty
	 */
	public boolean isEmpty(){
		return (this.load.equals(null));
	}

	/**
	 * Overrides the default toString method
	 * @return String description of the Train Car
	 */
	public String toString(){
		return "Car length is " + carLength +  " and car weight is " +  carWeight + ". Danger: " + this.getProductLoad().getDanger();
	}

	/**
	 * Uses the toString method to print the description of the Train Car
	 */
	public void printCar(){
		System.out.println(this.toString());
	}

	public static void main(String[] args){

	}

}
