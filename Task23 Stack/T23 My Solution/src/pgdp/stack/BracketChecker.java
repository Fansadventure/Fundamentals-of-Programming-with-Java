package pgdp.stack;

public class BracketChecker {
	public static boolean checkBrackets(String input) {
		CharStack myStack = new CharStack(input.length());
		for(int i=0;i<input.length();i++){
			char temp = input.charAt(i);
			if(temp =='(' || temp == '[' || temp == '{')
				myStack.push(temp);
			else if( (temp==')'|| temp == ']' || temp=='}')
					&& (myStack.isEmpty() || !matches(myStack.pop(),temp)))
				return false;
		}
		return myStack.isEmpty();
	}

	private static boolean matches(char open, char close) {
		return open == '(' && close == ')' || open == '[' && close == ']'
				|| open == '{' && close == '}';
	}
}
