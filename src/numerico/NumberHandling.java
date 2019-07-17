package numerico;

class NumberHandling {
	public static boolean esEntero(String str) {
		if(str.isEmpty())
			return false;
		if(str.charAt(0) == '-')
			str = str.substring(1);
		for(char ch : str.toCharArray()) {
			if(Character.isDigit(ch))
				continue;
			return false;
		}
		return true;
	}
}
