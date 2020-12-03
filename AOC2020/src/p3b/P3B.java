package p3b;

public class P3B {
	private static final int RIGHT_STEPS = 3;

	public static void main(String[] args) {

		
		int slope1 = countTrees(1,1,args);
		int slope2 = countTrees(3,1,args);
		int slope3 = countTrees(5,1,args);
		int slope4 = countTrees(7,1,args);
		int slope5 = countTrees(1,2,args);
		
		
		System.out.println(slope1*slope2*slope3*slope4*slope5);
		

	}

	private static int countTrees(int rightSteps, int downSteps, String[] args) {
		
		int treeCount = 0;
		int index = 0;
		for (int i = 0; i < args.length; i=i+downSteps) {
			
			if (args[i].charAt(index) == '#') {
				treeCount++;
			}
			index = index + rightSteps;
			if (index > args[i].length() - 1) {
				index = index - args[i].length();
			}

		}
		System.out.println(treeCount);		
		return treeCount;
	}
	

}
