import java.util.LinkedList;

class MatchBracketsLinked {

	public static void main(String[] args) {
		Boolean res = isValidBrackets(args[0]);
		System.out.println(res);
	}

	public static boolean isValidBrackets(String brackets) {
		
		LinkedList<Character> bracketsList = new LinkedList<>();

		for (int i=0; i<brackets.length(); i++) {
			if ("{[(".contains(String.valueOf(brackets.charAt(i)))) {
				bracketsList.push(brackets.charAt(i));
			} else {
				char rev = getReversedBracket(brackets.charAt(i));
				if (bracketsList.isEmpty() || rev != bracketsList.getLast()) return false;
				bracketsList.pop();
			}
		}

		return bracketsList.isEmpty();
	}

	public static char getReversedBracket(char b) {
		switch(b) {
			case '}':
				return '{';
			case ']':
				return '[';
			case ')':
				return '(';
			default:
				return '0';
		}
	}

}
