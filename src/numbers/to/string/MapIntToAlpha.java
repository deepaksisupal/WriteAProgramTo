package numbers.to.string;

public class MapIntToAlpha {

	public static void main(String[] args) {
		char i = '1';
		char character = 0;
		int count = 1;
		do {
			character = (char) (i - '1' + 'a');
			System.out.println( character + " " + i + " " + count++);
			i++;
		}
		while((char)character < 'z');
	}
}
