package tester;

import stackutils.*;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * JUnit test case for the parentheses
 * @author ReginaYe
 *
 */
public class ParenthesesCheckerTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void test1(){
		assertTrue(ParenthesesChecker.checkParentheses("[ { ( ) [ ] } ]"));
	}

	@Test
	public void test2(){
		assertFalse(ParenthesesChecker.checkParentheses("{ [ } ]"));
	}
	
	@Test
	public void test3(){
		assertFalse(ParenthesesChecker.checkParentheses("( ( { { } ] ) )"));
	}

	@Test
	public void test4(){
		assertTrue(ParenthesesChecker.checkParentheses("( ( { { [ ] ( ) } ( ) } ) { [ ] } )"));
	}
}
