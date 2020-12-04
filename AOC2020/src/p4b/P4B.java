package p4b;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P4B {

	private static final String PID = "pid";
	private static final String ECL = "ecl";
	private static final String HCL = "hcl";
	private static final String HGT = "hgt";
	private static final String EYR = "eyr";
	private static final String IYR = "iyr";
	private static final String BYR = "byr";

	public static void main(String[] args) {

		List<String> validFields = new ArrayList<>();
		List<String> optionalFields = new ArrayList<>();
		List<String> readFileList = new ArrayList<>();
		try {
			readFileList = Files.readAllLines(Paths.get("./src/p4b/input.txt")).stream().collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println("söndrig fil?" + e);
		}

		validFields.add(BYR);
		validFields.add(IYR);
		validFields.add(EYR);
		validFields.add(HGT);
		validFields.add(HCL);
		validFields.add(ECL);
		validFields.add(PID);
		optionalFields.add("cid");
		int passCounter = 0;
		ArrayList<String> fields = new ArrayList<>();
		ArrayList<String> completeFields = new ArrayList<>();
		ArrayList<String> values = new ArrayList<>();
		for (int i = 0; i < readFileList.size(); i++) {

			if (readFileList.get(i).isEmpty()) {
				if (areFieldsValid(fields, values, validFields)) {
					passCounter++;
				}

				completeFields.clear();
				fields.clear();
				values.clear();
			} else if (readFileList.size() - 1 == i) {
				String text = readFileList.get(i);
				String[] splitField = text.split(" ");
				completeFields.addAll(Arrays.asList(splitField));

				for (int j = 0; j < splitField.length; j++) {
					String[] splitEntry = splitField[j].split(":");
					fields.add(splitEntry[0]);
					values.add(splitEntry[1]);
				}

				if (areFieldsValid(fields, values, validFields)) {
					passCounter++;
				}
				completeFields.clear();
				fields.clear();
				values.clear();
			} else {
				String text = readFileList.get(i);
				String[] splitField = text.split(" ");
				completeFields.addAll(Arrays.asList(splitField));

				for (int j = 0; j < splitField.length; j++) {
					String[] splitEntry = splitField[j].split(":");
					fields.add(splitEntry[0]);
					values.add(splitEntry[1]);
				}
			}
		}

		System.out.println(passCounter);
	}

	private static boolean areFieldsValid(List<String> fields, List<String> values, List<String> validFields) {
		if (!fields.containsAll(validFields)) {
			return false;
		}

		boolean byr = false;
		boolean iyr = false;
		boolean eyr = false;
		boolean hgt = false;
		boolean hcl = false;
		boolean ecl = false;
		boolean pid = false;
		for (int i = 0; i < fields.size(); i++) {

			String value = values.get(i);
			String string = fields.get(i);


			switch (string) {
			case BYR:
				try {
					Integer val = Integer.valueOf(value);
					byr = value.length() == 4 && val >= 1920 && val <= 2002;
				} catch (NumberFormatException e) {
					byr = false;
				}
				break;
			case IYR:
				try {
					Integer val = Integer.valueOf(value);
					iyr = value.length() == 4 && val >= 2010 && val <= 2020;
				} catch (NumberFormatException e) {
					iyr = false;
				}
				break;
			case EYR:
				try {
					Integer val = Integer.valueOf(value);
					eyr = value.length() == 4 && val >= 2020 && val <= 2030;
				} catch (NumberFormatException e) {
					eyr = false;
				}
				break;
			case HGT:
				String type = value.substring(value.length() - 2);
				if (type.equals("cm")) {
					Integer val = Integer.valueOf(value.substring(0, value.length() - 2));
					hgt = val >= 150 && val <= 193;
				} else if (type.equals("in")) {
					Integer val = Integer.valueOf(value.substring(0, value.length() - 2));
					hgt = val >= 59 && val <= 76;
				}
				break;
			case HCL:
				String subString = value.substring(1);
				hcl = value.charAt(0) == '#' && subString.length() == 6 && subString.matches("^[a-f0-9_]+$");
				break;
			case ECL:
				ecl = value.equals("amb") || value.equals("blu") || value.equals("brn") || value.equals("gry")
						|| value.equals("grn") || value.equals("hzl") || value.equals("oth");
				break;
			case PID:
				pid = value.matches("^[0-9_]+$") && value.length() == 9;
				break;

			default:
				break;
			}

		}
		return pid && ecl && hcl && hgt && eyr && iyr && byr;
	}
}
