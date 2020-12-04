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
//		System.out.println(Arrays.asList(args));
		List<String> readFileList = new ArrayList<>();
		try {
			readFileList = Files.readAllLines(Paths.get("./src/p4a/input.txt")).stream().collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println("söndrig fil?" + e);
		}
		
//		System.out.println(readFileList);
//		System.out.println(readFileList.get(3).isEmpty());
//		System.out.println(Arrays.asList(readFileList.get(0).split(" ")).size());
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
		int fieldNumber = 0;
		int failCounter = 0;
		System.out.println(readFileList);
		System.out.println("** total passports " +readFileList.stream().filter(s -> s.isEmpty()).collect(Collectors.toList()).size());
		for (int i = 0; i < readFileList.size(); i++) {
			
			if (readFileList.get(i).isEmpty()) {
				fieldNumber++;
				System.out.println("***" + fieldNumber);
				if (fields.containsAll(validFields)) {
					passCounter++;
					System.out.println("passcount " + passCounter);
				} else {
					System.out.println(fields.stream().sorted().collect(Collectors.toList()));
					System.out.println(fields.size());
					System.out.println(completeFields);
					failCounter++;
					
				}
				System.out.println("***fail " + failCounter);
				System.out.println("***");
				completeFields.clear();
				fields.clear();
			} else {
				String text = readFileList.get(i);
				String[] splitField = text.split(" ");
				System.out.println("split " + splitField.length + Arrays.asList(splitField));
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
