package datastructures;

/**
 * College Founder class
 * 
 * @author ReginaYe
 *
 */
public class CollegeFounders {
	
	private LinkedList<Founder> founder1 = new LinkedList<Founder>(); 
	
	/**
	 * add founder to the linked list of founders 
	 * @param f
	 */
	public void addFounder( Founder f){
		founder1.insertLast(f);;
	}

	/**
	 * convert the list of founders to string
	 */
	public String toString(){
		return founder1.toString();
	}
	
}
