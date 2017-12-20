package numbers.to.string;

import java.util.ArrayList;
import java.util.List;

public class RecursiveApproach {

	public static void main(String[] args) {
		System.out.println(decode("", "11234"));

	}

	public static List<String> decode(String prefix, String code) {
		
		List<String> list = new ArrayList<>();
		
		if (code.length() == 0) {
			list.add(prefix);
			return list;
		}

		if (code.charAt(0) == '0')
			return list;

		list.addAll(decode(prefix + (char) (code.charAt(0) - '1' + 'a'), code.substring(1)));
		
		if (code.length() >= 2 && code.charAt(0) == '1') {
			list.addAll(decode(prefix + (char) (10 + code.charAt(1) - '1' + 'a'), code.substring(2)));
		}
		
		if (code.length() >= 2 && code.charAt(0) == '2' && code.charAt(1) <= '6') {
			list.addAll(decode(prefix + (char) (20 + code.charAt(1) - '1' + 'a'), code.substring(2)));
		}
		
		return list;
	}
}
