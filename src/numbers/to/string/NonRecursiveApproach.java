package numbers.to.string;

import java.util.ArrayList;
import java.util.List;

public class NonRecursiveApproach {

	public static void main(String[] args) {
		List<String> codes = findAllCodes("11234");
		System.out.println(codes);
	}

	private static List<String> findAllCodes(String string) {
		List<String> result = new ArrayList<>();// [aabcd, aawd, alcd, kbcd, kwd]
		result.add(singlesGroup(string));
		result.addAll(oneDoubleGroup(string));
		result.add(allDoublesGroup(string));
		return result;
	}

	private static String  allDoublesGroup(String string) {
		char[] charArray = string.toCharArray();
		String result = "";
		int length = charArray.length;

		for (int i = 0; i < length - 1; i++) {
			int j = i + 1;
			String s2 = getCharacter(string.charAt(i), string.charAt(j));
			if(null != s2) {
				result = result+s2;
			}
		}
		return result;
	}

	private static List<String> oneDoubleGroup(String string) {
		char[] charArray = string.toCharArray();
		List<String> result = new ArrayList<>();
		int length = charArray.length;

		for (int i = 0; i < length - 1; i++) {
			int j = i + 1;
			String s1 = singlesGroup(string.subSequence(0, i) + "");
			String s2 = getCharacter(string.charAt(i), string.charAt(j));
			String s3 = singlesGroup(string.substring(j + 1));
			if (null != s2) {
				result.add(s1 + s2 + s3);
			}
		}
		return result;
	}

	private static String singlesGroup(String string) {
		char[] charArray = string.toCharArray();
		String prefix = "";
		for (char c : charArray) {
			prefix = getCharacter(prefix, c);
		}
		return prefix;
	}

	private static String getCharacter(String prefix, char c) {
		char character = (char) (c - '1' + 'a');
		prefix += (char) character;
		return prefix;
	}

	private static String getCharacter(char a, char b) {
		char character = 0;
		if (a == '1') {
			character = (char) (10 + b - '1' + 'a');
		} else if (a == '2' && b < '6') {
			character = (char) (20 + b - '1' + 'a');
		} else
			return null;

		return String.valueOf(character);
	}

}
