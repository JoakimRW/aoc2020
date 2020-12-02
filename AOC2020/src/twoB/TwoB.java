package twoB;

public class TwoB {

	public static void main(String[] args) {

		int correctCounter = 0;
		for (int i = 0; i < args.length; i = i + 3) {

			String positionsString = args[i];
			String character = args[i + 1];
			String password = args[i + 2];

			String[] split = positionsString.split("-");
			Integer pos1 = Integer.valueOf(split[0]);
			Integer pos2 = Integer.valueOf(split[1]);

			char pos1Char = password.charAt(pos1 - 1);
			char pos2Char = password.charAt(pos2 - 1);
			char charAt = character.charAt(0);
			int count = 0;
			if (pos1Char == charAt) {
				count++;
			}
			if (pos2Char == charAt) {
				count++;
			}

			if (count == 1) {
				correctCounter++;
			}
		}

		System.out.println(correctCounter);
	}
}
