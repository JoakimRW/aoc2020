package p2a;

public class TwoA {

	public static void main(String[] args) {

		int correctCounter = 0;
		for (int i = 0; i < args.length; i = i + 3) {

			String times = args[i];
			String character = args[i + 1];
			String password = args[i + 2];

			String[] split = times.split("-");
			Integer timesMin = Integer.valueOf(split[0]);
			Integer timesMax = Integer.valueOf(split[1]);

			String test = password.replaceAll("[^" + character + "]", "");
			int length = test.length();

			if (length >= timesMin && length <= timesMax) {
				correctCounter++;
			}
		}

		System.out.println(correctCounter);

	}

}
