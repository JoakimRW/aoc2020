package p1a;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MainClass {

	public static void main(String[] args) {
		List<Long> l = Arrays.asList(args).stream().map(Long::parseLong).collect(Collectors.toList());
		System.out.println(l);
		l.forEach(a -> {
			Optional<Long> findFirst = l.stream().filter(c -> (a + c == 2020L)).findFirst();
			if (findFirst.isPresent()) {
				System.out.println(a * findFirst.get());
			}
		});
	}
}
