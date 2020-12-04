package p4a;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P4A {

	public static void main(String[] args) {
		List<String> validFields = new ArrayList<>();
		List<String> optionalFields = new ArrayList<>();
		List<String> readFileList = new ArrayList<>();
		try {
			readFileList = Files.readAllLines(Paths.get("./src/p4a/input.txt")).stream().collect(Collectors.toList());

		} catch (Exception e) {
			System.out.println("söndrig fil?" + e);
		}

		validFields.add("byr");
		validFields.add("iyr");
		validFields.add("eyr");
		validFields.add("hgt");
		validFields.add("hcl");
		validFields.add("ecl");
		validFields.add("pid");
		optionalFields.add("cid");
		int passCounter = 0;
		ArrayList<String> fields = new ArrayList<>();
		ArrayList<String> completeFields = new ArrayList<>();
		for (int i = 0; i < readFileList.size(); i++) {

			if (readFileList.get(i).isEmpty()) {
				if (fields.containsAll(validFields)) {
					passCounter++;
				}

				completeFields.clear();
				fields.clear();
			} else if (readFileList.size() - 1 == i) {
				String text = readFileList.get(i);
				String[] splitField = text.split(" ");
				completeFields.addAll(Arrays.asList(splitField));

				for (int j = 0; j < splitField.length; j++) {
					String[] splitEntry = splitField[j].split(":");
					fields.add(splitEntry[0]);
				}

				if (fields.containsAll(validFields)) {
					passCounter++;
				}
				completeFields.clear();
				fields.clear();
			} else {
				String text = readFileList.get(i);
				String[] splitField = text.split(" ");
				completeFields.addAll(Arrays.asList(splitField));

				for (int j = 0; j < splitField.length; j++) {
					String[] splitEntry = splitField[j].split(":");
					fields.add(splitEntry[0]);
				}
			}
		}

		System.out.println(passCounter);
	}

}
