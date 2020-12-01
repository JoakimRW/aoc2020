package oneA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainClass {

	public static void main(String[] args) {
		List<Long> l = Arrays.asList(args).stream().map(Long::parseLong).collect(Collectors.toList());
		System.out.println(l);
		List<Long> b = new ArrayList<>(l);
		l.forEach(a -> {
			b.remove(a);
			Stream<Long> f = b.stream().filter(c -> (a + c == 2020L));
			Optional<Long> findFirst = f.findFirst();
			if (findFirst.isPresent()) {
				System.out.println(a * findFirst.get());
			}
		});
	}
}
