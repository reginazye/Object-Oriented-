
public class PostFixCalculator {
	private static boolean isOperator(String sign) {
		return sign.equals("+") || sign.equals("*");
	}

	/**
	 * Uses a Split String and a Stack to calculate a postfix expression
	 * 
	 * @param input
	 *            A string containing numbers and operators + or *
	 * @return The value of the operation or null if the expression is invalid
	 */
	public static Integer calculatePostfixExpression(String input) {
		String[] strings = input.split(" ");
		StackLL<Object> stack = new StackLL<Object>();
		String output = "";

		for (int i = 0; i < strings.length; i++) {
			if (!isOperator(strings[i])) {
				output = output + strings[i];
			}
			if (isOperator(strings[i])) {
				if (!stack.isEmpty() && !(stack.peek().equals("("))) {
					if (stack.peek().equals("*") || stack.peek().equals("+")) {
						output = output + stack.pop();
						stack.pop();
					}
				}
				stack.push(strings[i]);
			} else if (strings[i].equals("(")) {
				stack.push(strings[i]);
			} else if (strings[i].equals(")")) {
				if (!stack.isEmpty() && !(stack.peek().equals("("))) {
					output = output + strings[i];
					stack.pop();
				}
				stack.pop();
			}
			if (!stack.isEmpty()) {
				output = output + strings[i];
				stack.pop();
			}
		}
		return Integer.parseInt(output);
	}

	/**
	 * Calls "calculatePostfixExpression" for each argument in "args" and prints
	 * out the result
	 */
	public static void main(String args[]) {
		
	}
}