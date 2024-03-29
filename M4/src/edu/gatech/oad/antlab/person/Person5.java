package edu.gatech.oad.antlab.person;

/**
 *  A simple class for person 5
 *  returns their name and a
 *  modified string 
 *  
 *  @author Bob
 *  @version 1.1
 */
public class Person5 {
  /** Holds the persons real name */
  private String name;
  	/**
	 * The constructor, takes in the persons
	 * name
	 * @param pname the person's real name
	 */
  public Person5(String pname) {
    name = pname;
  }
  	/**
	 * This method should take the string
	 * input and return its characters rotated
	 * 3 positions.
	 * given "gtg123b" it should return
	 * "123bgtg".
	 *
	 * @param input the string to be modified
	 * @return the modified string
	 */
	private String calc(String input) {
	 
	  if(input.length() == 2) {
		  return input.substring(1) + input.substring(0);
	  }
	  else if(input.length() > 3) {
		  String leftSub = input.substring(0,2);
		  String rightSub = input.substring(3);
		  return rightSub.concat(leftSub);
	  }
	  else
		  return input;

	}
	
	/**
	 * Return a string rep of this object
	 * that varies with an input string
	 *
	 * @param input the varying string
	 * @return the string representing the 
	 *         object
	 */
	public String toString(String input) {
	  return name + calc(input);
	}

}
