package datastructures;

/**
 * Founder class 
 * 
 * @author ReginaYe
 *
 */
public class Founder {
	private String ID_num1;
	private String name1;
	private String year1;
	private String college1;
	
	/**
	 * constructor for founder 
	 * 
	 * @param ID
	 * @param name
	 * @param year
	 * @param college
	 */
	public Founder(String ID, String name, String year, String college){
		ID_num1 = ID;
		name1 = name;
		year1 = year;
		college1 = college; 
	}
	
	/**
	 * convert the founder content to string
	 */
	public String toString(){
		String s = "";
		s = "id: " + ID_num1+"\n "+ "name: "+ name1+"\n "+ "year: "+ year1+"\n "+"college: " + college1+"\n";
		return s;
	}
	
}
