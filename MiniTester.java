import java.util.ArrayList;
import java.util.Arrays;

public class MiniTester {
    Open_Addressing oa = new Open_Addressing(10, 0, -1);
    Chaining c = new Chaining(10, 0, -1);

    private void testHashFunctions() {
        System.out.println("-------TEST OUTPUT OF HASH FUNCTIONS------"+ "\n");
        boolean passedAllTests=true;
        if (oa.probe(1, 0) != 30){
            System.out.println("Testing g(1, 0)...\nOutput: " + oa.probe(1, 0) + "\nExpected: 30");
            passedAllTests=false;
        }
        if (c.chain(1) != 30){
            System.out.println("Testing h(1)...\nOutput: " + c.chain(1) + "\nExpected: 30");
            passedAllTests=false;
        }
        if (oa.probe(1, 1) != 31){
            System.out.println("Testing g(1, 1)...\nOutput: " + oa.probe(1, 1) + "\nExpected: 31");
            passedAllTests=false;
        }
        if (c.chain(4) != 25){
            System.out.println("Testing h(4)...\nOutput: " + c.chain(4) + "\nExpected: 25");
            passedAllTests=false;
        }
        if (c.chain(8) != 19){
            System.out.println("Testing h(8)...\nOutput: " + c.chain(8) + "\nExpected: 19");
            passedAllTests=false;
        }
        if (oa.probe(1, 3) != 1) {
            System.out.println("Testing g(1, 3)...\nOutput: " + oa.probe(1, 3) + "\nExpected: 1");
            passedAllTests = false;
        }

        if(passedAllTests)System.out.println("Output of the hash functions matches the expected results"+ "\n");
        else System.out.println("Output of the hash functions doesn't match the expected results"+ "\n");
    }

    private void testInsertKeyProbe() {
        System.out.println("-------TEST KEY INSERTION------\n");
        //System.out.println("Table before insertion: \n" + Arrays.toString(oa.Table) + "\n");
        long startTime = System.nanoTime();
        int[] expected={20, 19, 23, 18, 17, 25, 16, 28, 15, 14, 30, 13, 12, 32, 11, 31, 10, 9, 29, 8, 7, 27, 6, 26, 5, 4, 24, 3, 2, 22, 1, 21};
        // Insert integers from 1 to 32 into table using probe
        for (int i = 1; i < oa.m + 1; i++)
            oa.insertKey(i);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        if(Arrays.equals(oa.Table,expected)){
            System.out.println("Output of the insertion of Open_Addressing.java matches the expected results");
        }
        else {
            System.out.println("Output of insertKey(int key) of Open_Addressing.java doesn't match the expected results");
            System.out.println("Expected result: \n" + Arrays.toString(expected) + "\n");
            System.out.println("Table after insertion using probe: \n" + Arrays.toString(oa.Table) + "\n");
        }
        System.out.println("Time duration to fill table: " + duration + " ns" + "\n");
    }

    private void testRemoveKey() {
        System.out.println("-------TEST KEY DELETION------\n");
        //System.out.println("Table before deletion: \n" + Arrays.toString(oa.Table) + "\n");
        int[] expected={-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        long startTime = System.nanoTime();
        // Remove integers from 1 to 32 from table
        for (int i = 1; i < oa.m + 1; i++)
            oa.removeKey(i);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        if(Arrays.equals(oa.Table,expected)){
            System.out.println("Output of removeKey(int key){} of Open_Addressing.java matches the expected results");
        }
        else {
            System.out.println("Expected result: \n" + Arrays.toString(expected) + "\n");
            System.out.println("Table after deletion: \n" + Arrays.toString(oa.Table) + "\n");
        }
        System.out.println("Time duration to empty table: " + duration + " ns" + "\n");
    }

    private void testInsertAfterRemoveKeyProbe() {
        System.out.println("-------TEST KEY INSERTION AFTER DELETION ON PROBE------\n");
        //System.out.println("Table before insertion: \n" + Arrays.toString(oa.Table) + "\n");
        long startTime = System.nanoTime();
        int[] expected={20, 19, 23, 18, 17, 25, 16, 28, 15, 14, 30, 13, 12, 32, 11, 31, 10, 9, 29, 8, 7, 27, 6, 26, 5, 4, 24, 3, 2, 22, 1, 21};
        // Insert integers from 1 to 32 into table using probe
        for (int i = 1; i < oa.m + 1; i++)
            oa.insertKey(i);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        if(Arrays.equals(oa.Table,expected)){
            System.out.println("Output of the insertion of Open_Addressing.java matches the expected results");
        }
        else {
            System.out.println("Output of insertKey(int key) of Open_Addressing.java doesn't match the expected results");
            System.out.println("Expected result: \n" + Arrays.toString(expected) + "\n");
            System.out.println("Table after insertion using probe: \n" + Arrays.toString(oa.Table) + "\n");
        }
        System.out.println("Time duration to fill table: " + duration + " ns" + "\n");
    }

    private void testInsertKeyChain() {
        System.out.println("-------TEST KEY INSERTION CHAINING------\n");

        ArrayList<ArrayList<Integer>>  Expected = new ArrayList<>();
        ArrayList<ArrayList<Integer>>  alternateExpected = new ArrayList<>();

        int[][] ExpectedMatrix = {{20}, {19}, {}, {18}, {17}, {}, {16}, {}, {15}, {14}, {}, {13}, {12}, {32}, {31, 11}, {}, {30, 10}, {29, 9}, {}, {28, 8}, {27, 7}, {}, {26, 6}, {}, {25, 5}, {24, 4}, {}, {23, 3}, {22, 2}, {}, {21, 1}, {}};
        int[][] alternateExpectedMatrix = {{20}, {19}, {}, {18}, {17}, {}, {16}, {}, {15}, {14}, {}, {13}, {12}, {32}, {11, 31}, {}, {10, 30}, {9, 29}, {}, {8, 28}, {7, 27}, {}, {6, 26}, {}, {5, 25}, {4, 24}, {}, {3, 23}, {2, 22}, {}, {1, 21}, {}};


        for(int i = 0; i < ExpectedMatrix.length; i++) {
            Expected.add(new ArrayList<Integer>());
            alternateExpected.add ( new ArrayList<Integer> () );
            for(int j = 0; j < ExpectedMatrix[i].length; j++) {
                Expected.get(i).add(ExpectedMatrix[i][j]);
                alternateExpected.get (i).add ( alternateExpectedMatrix[i][j] );
            }
        }

        long startTime = System.nanoTime();
        // Insert integers from 1 to 32 into table using chain
        for (int i = 1; i < c.m + 1; i++)
            c.insertKey(i);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        if(c.Table.equals(Expected) || c.Table.equals ( alternateExpected ))System.out.println("The insertKey(int key) method in Chaining.java matches the expected results");
        else{
            System.out.println("The insertKey(int key) method in Chaining.java doesn't match the expected results");
            System.out.println("Expected result: \n" + Expected + "\n");
            System.out.println("Table after insertion using chain: \n" + c.Table + "\n");
        }
        System.out.println("Time duration to fill table: " + duration + " ns" + "\n");
    }

    private void testSilence() {
        System.out.println("----------TEST OUTPUT OF SILENCE----------"+ "\n");
        boolean passedAll=true;
        int[] positions1 = new int[] { 1, 1 };
        int[] positions2 = new int[] { 1, 2, 3 };
        int[] positions3 = new int[] { 1, 2, 3, 1 };
        int[] positions4 = new int[] { 1, 2, 3, 1, 1 };


        int[] positions5 = new int[] {};
        int[] positions6 = new int[] { 2 };



        if (a1_real.silence(positions1) != 1)
        {
            System.out.println("Testing for [1,1]...\nOutput: " + a1_real.silence(positions1) + "\nExpected: 1");
            passedAll=false;
        }
        if (a1_real.silence(positions2) != 3)
        {
            System.out.println("Testing for [1,2,3]...\nOutput: " + a1_real.silence(positions2) + "\nExpected: 3");
            passedAll=false;
        }
        if (a1_real.silence(positions3) != 3)
        {
            System.out.println("Testing for [1,2,3,1]...\nOutput: " + a1_real.silence(positions3) + "\nExpected: 3");
            passedAll=false;
        }
        if (a1_real.silence(positions4) != 1)
        {
            System.out.println("Testing for [1,2,3,1,1]...\nOutput: " + a1_real.silence(positions4) + "\nExpected: 1");
            passedAll=false;
        }
        if (a1_real.silence(positions5) != 0)
        {
            System.out.println("Testing for empty array...\nOutput: " + a1_real.silence(positions5) + "\nExpected: 0");
            passedAll=false;
        }
        if (a1_real.silence(positions6) != 1)
        {
            System.out.println("Testing for [2]...\nOutput: " + a1_real.silence(positions6) + "\nExpected: 1");
            passedAll=false;
        }

        if(passedAll)System.out.println("Passed all the tests of the silence method"+ "\n");
        else {System.out.println("Failed some/all the tests of the silence method"+ "\n");}
    }

    private void testSilenceBigInput1() {
        System.out.println("----------TEST OUTPUT OF SILENCE ON BIG INPUT 1----------"+ "\n");
        boolean passedAll=true;

        System.out.print("--> Preparing input array...");
        int n = 20000000;
        int[] positions = new int[ n ];

        for( int i = 0; i < n; i++ ) positions[ i ] = i;

        System.out.println("Done!");

        System.out.print("--> Calling the function...");

        long startTime = System.nanoTime();
        int result = a1_real.silence( positions );
        long endTime = System.nanoTime();
        System.out.println("Done!");

        long duration = (endTime - startTime) /1000000; //convert to miliseconds

        if ( result != n )
        {
            System.out.println("Testing on large array of integeres of size " + n + "...\nOutput: " + result + "\nExpected: " + n );
            passedAll=false;
        }
        System.out.println("The function took " + duration + " ms. This should take under 10 seconds." + "\n");
        if(passedAll)System.out.println("Passed the big input test 1 for the silence method!"+ "\n");
    }

    private void testSilenceBigInput2() {
        System.out.println("----------TEST OUTPUT OF SILENCE ON BIG INPUT 2----------"+ "\n");
        boolean passedAll=true;

        System.out.print("--> Preparing input array...");
        int n = 20000000;
        int[] positions = new int[ n ];

        for( int i = 0; i < n; i++ )
        {

            if( i >= n / 2 ) positions[ i ] = n - i;
            else positions[ i ] = i;
        }

        System.out.println("Done!");

        System.out.print("--> Calling the function...");

        long startTime = System.nanoTime();
        int result = a1_real.silence( positions );
        long endTime = System.nanoTime();
        System.out.println("Done!");

        int expected = 2;


        long duration = (endTime - startTime) /1000000; //convert to miliseconds

        if ( result != expected )
        {
            System.out.println("Testing on large array of integeres of size " + n + "...\nOutput: " + result + "\nExpected: " + expected );
            passedAll=false;
        }
        System.out.println("The function took " + duration + " ms. This should not take more than a few seconds." + "\n");
        if(passedAll)System.out.println("Passed the big input test 2 for the silence method!"+ "\n");
    }


    public static void main(String[] args) {
        MiniTester m = new MiniTester();
        m.testHashFunctions();
        m.testInsertKeyProbe();
        m.testRemoveKey();
        m.testInsertAfterRemoveKeyProbe();
        m.testInsertKeyChain();
        m.testSilence();
        m.testSilenceBigInput1();
        m.testSilenceBigInput2();
    }

}