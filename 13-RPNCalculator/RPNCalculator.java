import static java.lang.System.out;
import java.util.ArrayDeque;
import java.util.Scanner;

public class RPNCalculator {
	private static ArrayDeque<Long> stack = new ArrayDeque<Long>();
	
	private RPNCalculator() {}
	
	public static Long evaluate(String expression) {
		if (!(expression.matches("[ 0-9+\\-\\*/%]*")) || (expression.contains("."))) {
			out.println("Invalid expression: only digits 0-9 and operators +, -, *, /, % allowed.");
			return null;
		}
		Scanner parser = new Scanner(expression).useDelimiter(" ");
		while (parser.hasNext()) {
			String next = parser.next();
			if ((next.length() == 1) && (next.matches("[+\\-\\*/%]"))) {
				if (stack.size() < 2) {
					out.println("Invalid expression: too many operators.");
					stack.clear();
					return null;
				}
				long second = stack.pop().longValue();
				long first = stack.pop().longValue();
				if (next.equals("+")) {stack.push(first + second);}
				if (next.equals("-")) {stack.push(first - second);}
				if (next.equals("*")) {stack.push(first * second);}
				if (next.equals("/")) {stack.push(first / second);}
				if (next.equals("%")) {stack.push(first % second);}
			}
			else {
<<<<<<< HEAD
				if (next.matches("[+\\-\\*/%]+")) {
					out.println("Invalid expression: separate values and operators with spaces.");
					return null;
				}
=======
				if ((next.contains("+")) || (next.contains("-")) || (next.contains("*")) || (next.contains("/")) || (next.contains("%"))) { //I couldn't get a regular expression to work.
				out.println("Invalid expression: separate values and operators with spaces.");
				stack.clear();
				return null;
			}
>>>>>>> 23f55099f5810898e0b5ac2cf58196cab733c79b
				stack.push(new Long(next));
			}
		}
		if (stack.size() > 1) {
			out.println("Invalid expression: too many values.");
			stack.clear();
			return null;
		}
		return stack.pop();
	}
	
	public static void main(String[] args) {
		out.println("RPN Calculator. Type in an expression, with values and operators separated by spaces, in reverse Polish or postfix notation and press Enter to print the result. Integers (between -2^63 and 2^63 - 1) only because Java is finicky with types. Press q or Ctrl + C to quit.");
		out.print(">> ");
		Scanner scanner = new Scanner(System.in);
		for (;;) {
			String next = "";
			for (;;) {
				next = scanner.nextLine().trim();
				if (next.equals("")) {out.print(">> ");}
				else {break;}
			}
			if (next.equals("q")) {return;}
			Long nextEvaluate = evaluate(next);
			if (nextEvaluate != null) {out.println(nextEvaluate);}
			out.print(">> ");
		}
	}
}
<<<<<<< HEAD
=======

>>>>>>> 23f55099f5810898e0b5ac2cf58196cab733c79b
