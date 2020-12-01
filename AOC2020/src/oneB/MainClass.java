package oneB;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainClass {

	public static void main(String[] args) {
		List<Long> l = Arrays.asList(args).stream().map(Long::parseLong).collect(Collectors.toList());
		System.out.println(l);

		l.forEach(a -> l.forEach(b -> {
			Stream<Long> f = l.stream().filter(c -> (a + b + c == 2020L));
			Optional<Long> findFirst = f.findFirst();
			if (findFirst.isPresent()) {
				System.out.println(a * b * findFirst.get());
			}
		}));
	}
}
