import java.util.ArrayList;

class MatchBrackets {

	public static void main(String[] args) {
		Boolean res = isValidBrackets(args[0]);
		System.out.println(res);
	}

	public static boolean isValidBrackets(String brackets) {
		
		ArrayList<Character> bracketsList = new ArrayList<>();

		for (int i=0; i<brackets.length(); i++) {
			if ("{[(".contains(String.valueOf(brackets.charAt(i)))) {
				bracketsList.add(brackets.charAt(i));	
			} else {
				char rev = getReversedBracket(brackets.charAt(i));
				if (bracketsList.isEmpty() || rev != bracketsList.get(bracketsList.size()-1)) return false;
				bracketsList.remove(bracketsList.size()-1);
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
