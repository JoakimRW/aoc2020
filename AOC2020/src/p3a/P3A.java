package p3a;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class P3A {

	private static final int RIGHT_STEPS = 3;

	public static void main(String[] args) {
		List<String> mapList = Arrays.asList(args);
		double pieceLength = mapList.get(0).length();
		System.out.println(mapList);
		System.out.println(mapList.size());
		System.out.println(pieceLength);
		int mapMaxSize = RIGHT_STEPS*mapList.size();
		System.out.println(mapMaxSize);
		double mapLengths = Math.ceil(mapMaxSize/pieceLength);
		System.out.println(mapLengths);
		
		int treeCount = 0;
		int index = 0;
		for (Iterator<String> iterator = mapList.iterator(); iterator.hasNext();) {
			String string = iterator.next();
			if (string.charAt(index) == '#') {
				treeCount++;
			}
			index = index +RIGHT_STEPS;
			if (index > string.length()-1) {
				index = index-string.length();
			}
			
			
		}
		
		System.out.println(treeCount);
		
		
	}

}
