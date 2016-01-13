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
 * Class for defining ProductLoad object
 *
 */

public class ProductLoad {

	/**  String for name of product*/
	private String name;

	/**  double for weight of product (in tons)*/
	private double weight;

	/**  double for value of product (in dollars)*/
	private double value;

	/** boolean to know whether product is dangerous or not */
	private boolean isDangerous;

	/**
	 * Default constructor with no parameters
	 */
	public ProductLoad(){
	}

	/**
	 * Constructor with parameters to create new ProductLoad
	 * @param name
	 * @param weight
	 * @param isDangerous
	 */
	public ProductLoad(String name, double weight, double value, boolean isDangerous){
		this.name = name;
		this.weight = weight;
		this.value = value;
		this.isDangerous = isDangerous;
	}

	/**
	 * Method to set name of product
	 * @param name
	 */
	public void setName(String name){
		this.name = name;
	}

	/**
	 * 
	 * @return String vale of name
	 */
	public String getName(){
		return name;
	}

	/**
	 * Method to set weight of the product
	 * @param weight
	 * @throws NegativeNumberException
	 */
	public void setWeight(double weight) throws NegativeNumberException{
		if(weight < 0)
			throw new NegativeNumberException();

		else
			this.weight = weight;
	}

	/**
	 * Method to return weight of product
	 * @return double value for the weight
	 */
	public double getWeight(){
		return weight;
	}

	/**
	 * Method to set value of the product
	 * @param value
	 * @throws NegativeNumberException
	 */
	public void setValue(double value) throws NegativeNumberException{
		if(value < 0)
			throw new NegativeNumberException();

		else
			this.value = value;
	}

	/**
	 * Method to return value of product
	 * @return double value for the product value
	 */
	public double getValue(){
		return this.value;
	}

	/**
	 * Method to set danger value of the product
	 * @param isDangerous
	 */
	public void setDanger(boolean isDangerous){
		this.isDangerous = isDangerous;
	}

	/**
	 * Method to get Danger value
	 * @returnisDangerous
	 */
	public boolean getDanger(){
		return isDangerous;
	}


	public static void main(String[] args){

	}

}
