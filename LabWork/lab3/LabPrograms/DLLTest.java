package lab3.LabPrograms;

import java.util.Random;

public class DLLTest {
	public static void main(String[] args) {
		DLL<Integer> list = new DLL<>();
		DLL<Integer> alternateList = new DLL<>();



		Random rand = new Random();

		for (int i = 0; i < 10; i++) {
			list.addToTail(rand.nextInt(100));
		}
		System.out.println("Original List:");
		list.printAll();

		System.out.println("after Reverse:");
		list.printReverse();

		System.out.println("\n");

		System.out.println("Original List:");
		list.printAll();

		System.out.println("Deleting 7th element iteratively until the list is empty:");
		while(!list.isEmpty()){
			list.delete7();
			list.printAll();
		}

		for (int i = 1; i <= 4; i++) {
			list.addToTail(i);
		}
		for (int i = 5; i <= 8; i++) {
			alternateList.addToTail(i);
		}

		System.out.println("Alternate List Before insertAlternate:");
		alternateList.printAll();
		System.out.println("Original List Before insertAlternate:");
		list.printAll();
		System.out.println("After insertAlternate:");
		list.insertAlternate(alternateList);
	}
}
