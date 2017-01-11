package stackutils;

import stackutils.ParenthesesChecker;
import datastructures.*;

/**
 * Uses a Split String and a Stack to check if parentheses match
 * 
 * @param input
 *            A string containing parentheses of types () [] {}
 * @return True if each open parentheses is matched by a closing parentheses
 */
public class ParenthesesChecker {
	public static boolean checkParentheses(String input) {
		String[] s = input.split(" ");
		StackLL<String> stack = new StackLL<String>();
		
		for (int i = 0; i < s.length; i++) {
			if (s[i].equals("{" )|| s[i].equals("(" )||s[i].equals("[" )) {
				stack.push(s[i]);
			} else if (s[i].equals("}" )) {
				if (stack.isEmpty() || !(stack.peek().equals("{") )){
					return false;
				}else{
					stack.pop();
				}
			} else if (s[i].equals("]")) {
				if (!(stack.peek().equals("[")) || stack.isEmpty()) {
					return false;
				}else {
					stack.pop();
				}
			} else if (s[i].equals(")")) {
				if (!(stack.peek().equals("(")) || stack.isEmpty()) {
					return false;
				}else{
					stack.pop();
				}
			}
		}
		return stack.isEmpty();
	}


	/**
	 * Calls "checkParentheses" for each argument in "args" and prints out if
	 * they match or not
	 */
	public static void main(String args[]) {
		for (int i = 0; i < args.length; i++) {
			System.out.println(checkParentheses(args[i]));
		}
	}
}