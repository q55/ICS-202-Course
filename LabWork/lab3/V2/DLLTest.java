package lab3.V2;

public class DLLTest {
	public static void main(String[] args) {
		DLL<Integer> test = new DLL<>();
		DLL<Integer> list = new DLL<>();
		for(int i = 1; i<5;i++){
			test.addToTail(i);

		}
		for(int i = 5; i<9;i++){
			list.addToTail(i);

		}
		test.printAll();
		//test.printReverse();
		test.insertAlternate(list);
		test.printAll();

	}
}