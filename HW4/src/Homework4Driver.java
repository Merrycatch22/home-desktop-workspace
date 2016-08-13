import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Homework4Driver.java
 * Nicholas Tarn
 * 5/25/16
 * Windows 7 Eclipse Compiler for Java
 * Drives some BST<Date>s.
 *
 */
public class Homework4Driver {
	public static Scanner userScanner = new Scanner(System.in);

	// opens a text file for input, returns a Scanner:
	public static Scanner openInputFile() {
		String filename;
		Scanner scanner = null;

		System.out.print("Enter the input filename: ");
		filename = userScanner.nextLine();
		File file = new File(filename);

		try {
			scanner = new Scanner(file);
		} // end try
		catch (FileNotFoundException fe) {
			System.out.println("Can't open input file\n");
			return null; // array of 0 elements
		} // end catch
		return scanner;
	}

	// AND DON'T FORGET ALL THE OTHER static methods described on the
	// assignment!

	public static void testBST(BST<Date> tree) {
		int inputMo = 1, inputDy = 1, inputYr = 1000;
		Date[] dates = new Date[4];
		Date tempDate;
		Scanner infile;

		System.out.println("\n(Use the SAME file you just used)");
		infile = openInputFile();
		if (infile == null) // open the same file you used for the simulation
		{
			System.out.println("Unable to open input file for testing\n");
			return;
		}
		if (infile.hasNext()) // getting the first Date from the file
		{
			inputMo = infile.nextInt();
			inputDy = infile.nextInt();
			inputYr = infile.nextInt();
			dates[0] = new Date(inputMo, inputDy, inputYr);
		}
		for (int count = 0; count < 4 && infile.hasNext(); ++count) {
			infile.nextLine(); // skip next 3 lines, after last \n
		}
		if (infile.hasNext()) // getting the 4th Date from the file
		{
			inputMo = infile.nextInt();
			inputDy = infile.nextInt();
			inputYr = infile.nextInt();
			dates[1] = new Date(inputMo, inputDy, inputYr);
		}
		while (infile.hasNext())// going to the end of the file
		{
			inputMo = infile.nextInt();
			inputDy = infile.nextInt();
			inputYr = infile.nextInt();
		}
		infile.close(); // done with input file

		dates[2] = new Date(inputMo, inputDy, inputYr);// saving the last in the
														// file
		dates[3] = new Date(); // assigning default Date
		for (int i = 0; i < dates.length; ++i) {
			System.out.println("\nTesting if " + dates[i] + " is in the tree...");
			if (tree.contains(dates[i]))
				System.out.println("The tree's contains method found " + dates[i]);
			else
				System.out.println("The tree's contains method didn't find " + dates[i]);
			tempDate = tree.getEntry(dates[i]);
			if (tempDate != null)
				System.out.println("The tree's getEntry method returned: " + tempDate);
			else
				System.out.println("The tree's getEntry couldn't return: " + dates[i]);
		}
		System.out.println("\nTesting constructor with array...");
		BST<Date> testBST = new BST<>(dates, new YearComparator());
		testBST.writeIndentedTree(System.out);
		testBST.clear();
	} // end testBST
	/**
	 * The method required with the underlined "method that you write"
	 * @param tree
	 */
	public static void student(BST<Date> tree) {
		Date getFirst = tree.getFirst();
		Date getLast = tree.getLast();
		System.out.println("getFirst() returns " + getFirst.toString());
		System.out.println("getLast() returns " + getLast.toString());
		if (tree.delete(getFirst)) {
			System.out.println("Deletion of " + getFirst.toString() + " successful!");
		} else {
			System.out.println("Deletion of " + getFirst.toString() + " not successful!");
		}
		if (tree.insert(getLast)) {
			System.out.println("Insertion of " + getLast.toString() + " returned true");
		} else {
			System.out.println("Insertion of " + getLast.toString() + " returned false");
		}
		if (tree.insert(getFirst)) {
			System.out.println("Insertion of " + getFirst.toString() + " again successful!");
		} else {
			System.out.println("Insertion of " + getFirst.toString() + " again not successful!");
		}
	}
	/**
	 * Main. Runs all the main requirements.
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST<Date> yearTree = new BST<Date>(new YearComparator());
		BST<Date> monthTree = new BST<Date>(new MonthComparator());
		Scanner input = openInputFile();
		if (input != null) {
			while (input.hasNext()) {
				Date date = new Date();
				int m = input.nextInt();
				int d = input.nextInt();
				int y = input.nextInt();
				if (date.setDate(m, d, y)) {
					yearTree.insert(date);
					monthTree.insert(date);
				} else {
					System.out.println("Invalid date in file: " + m + "-" + d + "-" + y);
				}
			}
			System.out.println("\nYear-ordered tree has: ");
			yearTree.inorder(new YearVisitor());
			System.out.println("\nMonth-ordered tree has: ");
			monthTree.inorder(new MonthVisitor());
			System.out.println("\nTesting Year-ordered tree: ");
			testBST(yearTree);
			System.out.println("\nTesting Month-ordered tree: ");
			testBST(monthTree);
			System.out.println("\nYear-ordered indented tree: ");
			yearTree.writeIndentedTree(System.out);
			System.out.println("\nMonth-ordered indented tree: ");
			monthTree.writeIndentedTree(System.out);
			System.out.println("\nStudent Testing Year-ordered tree: ");
			student(yearTree);
			System.out.println("\nStudent Testing Month-ordered tree: ");
			student(monthTree);
			System.out.println("\nPostorder traversal of updated Year-ordered tree: ");
			yearTree.postorder(new YearVisitor());
			System.out.println("\nNow the updated Month-ordered indented tree has ");
			monthTree.writeIndentedTree(System.out);

		}
	}

}
/*
Enter the input filename: HW4 Input.txt
Invalid date in file: 9-31-1939

Year-ordered tree has: 
1934-11-28
1935-9-23
1937-11-8
1939-7-18
1940-4-29
1947-8-17
1953-2-10
1955-10-20
1962-12-30
1966-12-17
1981-3-25
1981-3-27
1983-7-28
1995-10-5
1999-9-23
2002-8-18
2007-12-24
2010-8-17
2013-11-30
2016-8-28
2024-9-18
2028-9-28

Month-ordered tree has: 
2/10/1953
3/25/1981
3/27/1981
4/29/1940
7/18/1939
7/28/1983
8/17/1947
8/17/2010
8/18/2002
8/28/2016
9/18/2024
9/23/1935
9/23/1999
9/28/2028
10/5/1995
10/20/1955
11/8/1937
11/28/1934
11/30/2013
12/17/1966
12/24/2007
12/30/1962

Testing Year-ordered tree: 

(Use the SAME file you just used)
Enter the input filename: HW4 Input.txt

Testing if 9/23/1999 is in the tree...
The tree's contains method found 9/23/1999
The tree's getEntry method returned: 9/23/1999

Testing if 3/27/1981 is in the tree...
The tree's contains method found 3/27/1981
The tree's getEntry method returned: 3/27/1981

Testing if 11/28/1934 is in the tree...
The tree's contains method found 11/28/1934
The tree's getEntry method returned: 11/28/1934

Testing if 1/1/1000 is in the tree...
The tree's contains method didn't find 1/1/1000
The tree's getEntry couldn't return: 1/1/1000

Testing constructor with array...
1. 9/23/1999
    2. 3/27/1981
        3. 11/28/1934
            4. 1/1/1000

Testing Month-ordered tree: 

(Use the SAME file you just used)
Enter the input filename: HW4 Input.txt

Testing if 9/23/1999 is in the tree...
The tree's contains method found 9/23/1999
The tree's getEntry method returned: 9/23/1999

Testing if 3/27/1981 is in the tree...
The tree's contains method found 3/27/1981
The tree's getEntry method returned: 3/27/1981

Testing if 11/28/1934 is in the tree...
The tree's contains method found 11/28/1934
The tree's getEntry method returned: 11/28/1934

Testing if 1/1/1000 is in the tree...
The tree's contains method didn't find 1/1/1000
The tree's getEntry couldn't return: 1/1/1000

Testing constructor with array...
1. 9/23/1999
    2. 3/27/1981
        3. 11/28/1934
            4. 1/1/1000

Year-ordered indented tree: 
1. 9/23/1999
    2. 8/18/2002
        3. 11/30/2013
            4. 9/18/2024
                5. 9/28/2028
                5. 8/28/2016
            4. 12/24/2007
                5. 8/17/2010
    2. 10/20/1955
        3. 3/27/1981
            4. 10/5/1995
                5. 7/28/1983
            4. 12/30/1962
                5. 12/17/1966
                    6. 3/25/1981
        3. 8/17/1947
            4. 2/10/1953
            4. 4/29/1940
                5. 9/23/1935
                    6. 7/18/1939
                        7. 11/8/1937
                    6. 11/28/1934

Month-ordered indented tree: 
1. 9/23/1999
    2. 11/30/2013
        3. 12/24/2007
            4. 12/30/1962
            4. 12/17/1966
        3. 10/20/1955
            4. 11/8/1937
                5. 11/28/1934
            4. 9/28/2028
                5. 10/5/1995
    2. 8/18/2002
        3. 9/18/2024
            4. 9/23/1935
            4. 8/28/2016
        3. 3/27/1981
            4. 8/17/1947
                5. 8/17/2010
                5. 4/29/1940
                    6. 7/18/1939
                        7. 7/28/1983
            4. 2/10/1953
                5. 3/25/1981

Student Testing Year-ordered tree: 
getFirst() returns 11/28/1934
getLast() returns 9/28/2028
Deletion of 11/28/1934 successful!
Insertion of 9/28/2028 returned true
Insertion of 11/28/1934 again successful!

Student Testing Month-ordered tree: 
getFirst() returns 2/10/1953
getLast() returns 12/30/1962
Deletion of 2/10/1953 successful!
Insertion of 12/30/1962 returned true
Insertion of 2/10/1953 again successful!

Postorder traversal of updated Year-ordered tree: 
1934-11-28
1937-11-8
1939-7-18
1935-9-23
1940-4-29
1953-2-10
1947-8-17
1981-3-25
1966-12-17
1962-12-30
1983-7-28
1995-10-5
1981-3-27
1955-10-20
2010-8-17
2007-12-24
2016-8-28
2028-9-28
2028-9-28
2024-9-18
2013-11-30
2002-8-18
1999-9-23

Now the updated Month-ordered indented tree has 
1. 9/23/1999
    2. 11/30/2013
        3. 12/24/2007
            4. 12/30/1962
                5. 12/30/1962
            4. 12/17/1966
        3. 10/20/1955
            4. 11/8/1937
                5. 11/28/1934
            4. 9/28/2028
                5. 10/5/1995
    2. 8/18/2002
        3. 9/18/2024
            4. 9/23/1935
            4. 8/28/2016
        3. 3/27/1981
            4. 8/17/1947
                5. 8/17/2010
                5. 4/29/1940
                    6. 7/18/1939
                        7. 7/28/1983
            4. 3/25/1981
                5. 2/10/1953
*/
