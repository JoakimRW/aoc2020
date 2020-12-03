package p2b;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TwoB {

	public static void main(String[] args) {

		int correctCounter = 0;
		for (int i = 0; i < args.length; i = i + 3) {

			String positionsString = args[i];
			String character = args[i + 1];
			String password = args[i + 2];

			List<Integer> split = Arrays.asList(positionsString.split("-")).stream()//
					.map(Integer::valueOf)//
					.collect(Collectors.toList());

			long count = split.stream()//
					.map(n -> password.charAt(n - 1))//
					.filter(c -> c == character.charAt(0))//
					.count();

			if (count == 1) {
				correctCounter++;
			}
		}

		System.out.println(correctCounter);
	}
}
