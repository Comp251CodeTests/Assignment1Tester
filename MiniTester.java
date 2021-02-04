import java.util.Arrays;

public class MiniTester {
	Open_Addressing oa = new Open_Addressing(10, 0, -1);
	Chaining c = new Chaining(10, 0, -1);

	private void testHashFunctions() {
		System.out.println("-------TEST OUTPUT OF HASH FUNCTIONS------");

		if (oa.probe(1, 0) != 30)
			System.out.println("Testing g(1, 0)...\nOutput: " + oa.probe(1, 0) + "\nExpected: 30");
		if (c.chain(1) != 30)
			System.out.println("Testing h(1)...\nOutput: " + c.chain(1) + "\nExpected: 30");
		if (oa.probe(1, 1) != 31)
			System.out.println("Testing g(1, 1)...\nOutput: " + oa.probe(1, 1) + "\nExpected: 31");
		if (c.chain(4) != 25)
			System.out.println("Testing h(4)...\nOutput: " + c.chain(4) + "\nExpected: 25");
		if (c.chain(8) != 19)
			System.out.println("Testing h(8)...\nOutput: " + c.chain(8) + "\nExpected: 19");
		if (oa.probe(1, 3) != 1)
			System.out.println("Testing g(1, 3)...\nOutput: " + oa.probe(1, 3) + "\nExpected: 1");

		System.out.println("");
	}

	private void testInsertKeyProbe() {
		System.out.println("- - - - - - - - - - - - - - - - - - - -\n");
		System.out.println("Table before insertion: \n" + Arrays.toString(oa.Table) + "\n");

		long startTime = System.nanoTime();
		// Insert integers from 1 to 32 into table using probe
		for (int i = 1; i < oa.m + 1; i++)
			oa.insertKey(i);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);

		System.out.println("Table after insertion using probe: \n" + Arrays.toString(oa.Table) + "\n");

		System.out.println("Time duration to fill table: " + duration + " ns" + "\n");
	}

	private void testRemoveKey() {
		System.out.println("- - - - - - - - - - - - - - - - - - - -\n");
		System.out.println("Table before deletion: \n" + Arrays.toString(oa.Table) + "\n");

		long startTime = System.nanoTime();
		// Remove integers from 1 to 32 from table
		for (int i = 1; i < oa.m + 1; i++)
			oa.removeKey(i);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);

		System.out.println("Table after deletion: \n" + Arrays.toString(oa.Table) + "\n");

		System.out.println("Time duration to empty table: " + duration + " ns" + "\n");
	}

	private void testInsertKeyChain() {
		System.out.println("- - - - - - - - - - - - - - - - - - - -\n");
		System.out.println("Table before insertion: \n" + c.Table + "\n");

		long startTime = System.nanoTime();
		// Insert integers from 1 to 32 into table using chain
		for (int i = 1; i < c.m + 1; i++)
			c.insertKey(i);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);

		System.out.println("Table after insertion using chain: \n" + c.Table + "\n");

		System.out.println("Time duration to fill table: " + duration + " ns" + "\n");
	}

	private void testSilence() {
		System.out.println("----------TEST OUTPUT OF SILENCE----------");

		int[] positions1 = new int[] { 1, 1 };
		int[] positions2 = new int[] { 1, 2, 3 };
		int[] positions3 = new int[] { 1, 2, 3, 1 };
		int[] positions4 = new int[] { 1, 2, 3, 1, 1 };

		if (a1_real.silence(positions1) != 1)
			System.out.println("Testing for [1,1]...\nOutput: " + a1_real.silence(positions1) + "\nExpected: 1");
		if (a1_real.silence(positions2) != 3)
			System.out.println("Testing for [1,2,3]...\nOutput: " + a1_real.silence(positions2) + "\nExpected: 3");
		if (a1_real.silence(positions3) != 3)
			System.out.println("Testing for [1,2,3,1]...\nOutput: " + a1_real.silence(positions3) + "\nExpected: 3");
		if (a1_real.silence(positions4) != 1)
			System.out.println("Testing for [1,2,3,1,1]...\nOutput: " + a1_real.silence(positions4) + "\nExpected: 1");
	}

	public static void main(String[] args) {
		MiniTester m = new MiniTester();
		m.testHashFunctions();
//		m.testInsertKeyProbe();
//		m.testRemoveKey();
//		m.testInsertKeyChain();
		m.testSilence();
	}

}