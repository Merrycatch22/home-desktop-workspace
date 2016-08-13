import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Homework5Driver.java
 * Nicholas Tarn
 * 6/5/16
 * Windows 7 Eclipse Compiler for Java
 * Drives some HashTables.
 *
 */
public class Homework5Driver {
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

	// Call the following in main for EACH of the HashTables:

	public static void testHashTable(HashTable<IpAddress> table, IpAddress targetIpAddress) {
		IpAddress tempIpAddress;
		// found a IpAddress in table1 in table2
		tempIpAddress = table.getEntry(targetIpAddress);
		if (tempIpAddress != null) {
			System.out.println("Retrieved in HashTable, IpAddress: " + tempIpAddress + ", now trying to delete it");
			// now delete it
			testRemove(table, targetIpAddress); // YOU WRITE THIS (SEE SPECS
												// BELOW)
		} else
			System.out.println("Error in HashTable: can't retrieve " + targetIpAddress);

	} // testHashTable

	/**
	 * tests removal (of lastIp)
	 * @param table
	 * @param targetIpAddress
	 */
	public static void testRemove(HashTable<IpAddress> table, IpAddress targetIpAddress) {
		// YOU FINISH SO THIS METHOD DOES THE FOLLOWING
		// Call the HashTable's remove method, passing the targetIpAdddress
		// If it returns true, display a message that it was removed (and
		// display targetIpAddress)
		// If it returns false, display a message that the remove failed
		// (and display targetIpAddress
		// Make sure you don't call the remove() method more than once in this
		// method!
		if(table.remove(targetIpAddress)){
			System.out.println("Removed "+targetIpAddress+" successfully!");
		}else{
			System.out.println("Not Removed "+targetIpAddress+" successfully!");
		}
		

	}

	/**
	 * reads the file so that ips will be inserted into hashTables
	 * @param scv
	 * @param qps
	 * @return
	 */
	public static IpAddress readFile(HashTable<IpAddress> scv, HashTable<IpAddress> qps) {
		Scanner in = openInputFile();
		if (in == null) {
			return null;
		} else {
			IpAddress ip = null;
			while (in.hasNext()) {
				ip = new IpAddress(in.next().trim());
				if (scv.insert(ip)) {
					System.out.println("Inserted into HashSC: " + ip.toString());
				} else {
					System.out.println("not Inserted into HashSC: " + ip.toString());
				}
				if (qps.insert(ip)) {
					System.out.println("Inserted into HashQP: " + ip.toString());
				} else {
					System.out.println("not Inserted into HashQP: " + ip.toString());
				}
			}
			return ip;
		}
	}
	/**
	 * does all the requirements it's main
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashTable<IpAddress> scv = new HashSC<>(new IpAddressValueHasher(), new IpAddressValueComparator());
		HashTable<IpAddress> qps = new HashQP<>(new IpAddressStringHasher(), new IpAddressStringComparator());
		IpAddress lastIp = readFile(scv, qps);
		if (lastIp == null) {
			System.out.println("Unable to read the file");
		} else {
			System.out.println("\nContents of HashSC with the IpValue key:");
			scv.displayTable();
			scv.displayStatistics();
			System.out.println("\nContents of HashQP with the String key:");
			qps.displayTable();
			qps.displayStatistics();

			if (scv.contains(lastIp)) {
				System.out.println("\nTesting HashSC with IpValue key: ");
				testHashTable(scv, lastIp);
			} else {
				System.out.println("A MESSAGE");
			}
			if (qps.contains(lastIp)) {
				System.out.println("\nTesting HashQP with String key: ");
				testHashTable(qps, lastIp);
			} else {
				System.out.println("A MESSAGE");
			}
			
			System.out.println("\nNow the contents of HashSC with the IpValue key has:");
			scv.displayTable();
			System.out.println("\nNow the contents of HashQP with the String key has:");
			qps.displayTable();
			
		}
	}

}
/*
Enter the input filename: HW5Input.txt
Inserted into HashSC: 205.226.201, 13492937
Inserted into HashQP: 205.226.201, 13492937
Inserted into HashSC: 205.226.203.186, 3454192570
Inserted into HashQP: 205.226.203.186, 3454192570
Inserted into HashSC: 205.226.203.35, 3454192419
Inserted into HashQP: 205.226.203.35, 3454192419
Inserted into HashSC: 205.226.203.56, 3454192440
Inserted into HashQP: 205.226.203.56, 3454192440
Inserted into HashSC: 205.226.203.62, 3454192446
Inserted into HashQP: 205.226.203.62, 3454192446
Inserted into HashSC: 205.266.204.238, 3456814318
Inserted into HashQP: 205.266.204.238, 3456814318
Inserted into HashSC: 202.33.250.146, 3391224466
Inserted into HashQP: 202.33.250.146, 3391224466
Inserted into HashSC: 202.33.250.147, 3391224467
Inserted into HashQP: 202.33.250.147, 3391224467
Inserted into HashSC: 202.33.250.148, 3391224468
Inserted into HashQP: 202.33.250.148, 3391224468
Inserted into HashSC: 202.33.250.149, 3391224469
Inserted into HashQP: 202.33.250.149, 3391224469
Inserted into HashSC: 202.33.250.150, 3391224470
Inserted into HashQP: 202.33.250.150, 3391224470
Inserted into HashSC: 202.33.250.151, 3391224471
Inserted into HashQP: 202.33.250.151, 3391224471
Inserted into HashSC: 202.33.250.152, 3391224472
Inserted into HashQP: 202.33.250.152, 3391224472
Inserted into HashSC: 202.33.250.153, 3391224473
Inserted into HashQP: 202.33.250.153, 3391224473
Inserted into HashSC: 202.33.250.154, 3391224474
Inserted into HashQP: 202.33.250.154, 3391224474
Inserted into HashSC: 204.162.96, 13410912
Inserted into HashQP: 204.162.96, 13410912
Inserted into HashSC: 204.162.97.1, 3433193729
Inserted into HashQP: 204.162.97.1, 3433193729
Inserted into HashSC: 204.162.97.152, 3433193880
Inserted into HashQP: 204.162.97.152, 3433193880
Inserted into HashSC: 204.162.97.17, 3433193745
Inserted into HashQP: 204.162.97.17, 3433193745
Inserted into HashSC: 204.162.97.2, 3433193730
Inserted into HashQP: 204.162.97.2, 3433193730
Inserted into HashSC: 206.3.30.196, 3456310980
Inserted into HashQP: 206.3.30.196, 3456310980
Inserted into HashSC: 206.3.0.250, 3456303354
Inserted into HashQP: 206.3.0.250, 3456303354
Inserted into HashSC: 206.3.30.251, 3456311035
Inserted into HashQP: 206.3.30.251, 3456311035
Inserted into HashSC: 195.145.119.24, 3281090328
Inserted into HashQP: 195.145.119.24, 3281090328
Inserted into HashSC: 195.145.119.25, 3281090329
Inserted into HashQP: 195.145.119.25, 3281090329
Inserted into HashSC: 198.5.208, 12977616
Inserted into HashQP: 198.5.208, 12977616
Inserted into HashSC: 198.5.210, 12977618
Inserted into HashQP: 198.5.210, 12977618
Inserted into HashSC: 204.162.97.205, 3433193933
Inserted into HashQP: 204.162.97.205, 3433193933
Inserted into HashSC: 204.162.97.228, 3433193956
Inserted into HashQP: 204.162.97.228, 3433193956
Inserted into HashSC: 204.162.97.231, 3433193959
Inserted into HashQP: 204.162.97.231, 3433193959
Inserted into HashSC: 204.162.97.3, 3433193731
Inserted into HashQP: 204.162.97.3, 3433193731
Inserted into HashSC: 204.162.97.32, 3433193760
Inserted into HashQP: 204.162.97.32, 3433193760
Inserted into HashSC: 204.162.98.11, 3433193995
Inserted into HashQP: 204.162.98.11, 3433193995
Inserted into HashSC: 204.162.98.12, 3433193996
Inserted into HashQP: 204.162.98.12, 3433193996
Inserted into HashSC: 204.162.98.124, 3433194108
Inserted into HashQP: 204.162.98.124, 3433194108
Inserted into HashSC: 204.162.98.126, 3433194110
Inserted into HashQP: 204.162.98.126, 3433194110
Inserted into HashSC: 204.162.98.151, 3433194135
Inserted into HashQP: 204.162.98.151, 3433194135
Inserted into HashSC: 204.162.98.161, 3433194145
Inserted into HashQP: 204.162.98.161, 3433194145
Inserted into HashSC: 204.162.98.168, 3433194152
Inserted into HashQP: 204.162.98.168, 3433194152
Inserted into HashSC: 204.162.98.18, 3433194002
Inserted into HashQP: 204.162.98.18, 3433194002
Inserted into HashSC: 204.162.98.192, 3433194176
Inserted into HashQP: 204.162.98.192, 3433194176
Inserted into HashSC: 204.162.98.2, 3433193986
Inserted into HashQP: 204.162.98.2, 3433193986
Inserted into HashSC: 204.162.98.237, 3433194221
Inserted into HashQP: 204.162.98.237, 3433194221
Inserted into HashSC: 204.162.98.27, 3433194011
Inserted into HashQP: 204.162.98.27, 3433194011
Inserted into HashSC: 204.162.98.3, 3433193987
Inserted into HashQP: 204.162.98.3, 3433193987
Inserted into HashSC: 204.162.98.36, 3433194020
Inserted into HashQP: 204.162.98.36, 3433194020
Inserted into HashSC: 204.162.98.38, 3433194022
Inserted into HashQP: 204.162.98.38, 3433194022
Inserted into HashSC: 204.162.98.4, 3433193988
Inserted into HashQP: 204.162.98.4, 3433193988
Inserted into HashSC: 204.162.98.45, 3433194029
Inserted into HashQP: 204.162.98.45, 3433194029
Inserted into HashSC: 204.162.98.48, 3433194032
Inserted into HashQP: 204.162.98.48, 3433194032
Inserted into HashSC: 204.162.98.49, 3433194033
Inserted into HashQP: 204.162.98.49, 3433194033
Inserted into HashSC: 204.162.98.5, 3433193989
Inserted into HashQP: 204.162.98.5, 3433193989
Inserted into HashSC: 204.162.98.6, 3433193990
Inserted into HashQP: 204.162.98.6, 3433193990
Inserted into HashSC: 204.162.98.7, 3433193991
Inserted into HashQP: 204.162.98.7, 3433193991
Inserted into HashSC: 204.162.98.8, 3433193992
Inserted into HashQP: 204.162.98.8, 3433193992
Inserted into HashSC: 204.162.98.80, 3433194064
Inserted into HashQP: 204.162.98.80, 3433194064
Inserted into HashSC: 204.162.98.88, 3433194072
Inserted into HashQP: 204.162.98.88, 3433194072
Inserted into HashSC: 204.162.98.9, 3433193993
Inserted into HashQP: 204.162.98.9, 3433193993
Inserted into HashSC: 204.162.98.91, 3433194075
Inserted into HashQP: 204.162.98.91, 3433194075
Inserted into HashSC: 204.162.98.98, 3433194082
Inserted into HashQP: 204.162.98.98, 3433194082
Inserted into HashSC: 204.202.132.19, 3435824147
Inserted into HashQP: 204.202.132.19, 3435824147

Contents of HashSC with the IpValue key:
0: ----
1: ----
2: ----
3: 204.162.98.192, 3433194176
4: 205.226.203.62, 3454192446
5: ----
6: 204.162.98.98, 3433194082
7: 204.162.98.2, 3433193986
8: 204.162.98.3, 3433193987
9: 204.162.98.4, 3433193988
10: 204.162.98.5, 3433193989
11: 204.162.98.6, 3433193990
12: 195.145.119.24, 3281090328 -> 204.162.98.7, 3433193991
13: 195.145.119.25, 3281090329 -> 204.162.98.8, 3433193992 -> 204.202.132.19, 3435824147
14: 204.162.98.9, 3433193993
15: ----
16: 206.3.30.251, 3456311035 -> 204.162.98.11, 3433193995
17: 204.162.98.12, 3433193996
18: ----
19: ----
20: ----
21: ----
22: ----
23: 204.162.98.18, 3433194002
24: ----
25: ----
26: ----
27: ----
28: ----
29: ----
30: ----
31: 205.226.203.186, 3454192570
32: 204.162.98.124, 3433194108 -> 204.162.98.27, 3433194011
33: ----
34: 204.162.98.126, 3433194110
35: ----
36: ----
37: ----
38: ----
39: ----
40: ----
41: 204.162.97.1, 3433193729 -> 204.162.98.36, 3433194020
42: 204.162.97.2, 3433193730
43: 205.226.201, 13492937 -> 204.162.97.3, 3433193731 -> 204.162.98.38, 3433194022
44: ----
45: ----
46: ----
47: ----
48: 204.162.98.237, 3433194221
49: ----
50: 204.162.98.45, 3433194029
51: 204.162.97.205, 3433193933
52: ----
53: 204.162.98.48, 3433194032
54: 204.162.98.49, 3433194033
55: ----
56: ----
57: 204.162.97.17, 3433193745
58: 206.3.30.196, 3456310980
59: 202.33.250.146, 3391224466 -> 204.162.98.151, 3433194135
60: 202.33.250.147, 3391224467
61: 202.33.250.148, 3391224468
62: 202.33.250.149, 3391224469
63: 205.266.204.238, 3456814318 -> 202.33.250.150, 3391224470
64: 202.33.250.151, 3391224471
65: 202.33.250.152, 3391224472
66: 202.33.250.153, 3391224473
67: 202.33.250.154, 3391224474
68: ----
69: 204.162.98.161, 3433194145
70: ----
71: ----
72: 204.162.97.32, 3433193760
73: ----
74: 205.226.203.35, 3454192419 -> 204.162.97.228, 3433193956
75: ----
76: 204.162.98.168, 3433194152
77: 204.162.97.231, 3433193959
78: ----
79: ----
80: 204.162.96, 13410912
81: ----
82: ----
83: 198.5.208, 12977616
84: ----
85: 198.5.210, 12977618 -> 204.162.98.80, 3433194064
86: ----
87: ----
88: ----
89: ----
90: ----
91: ----
92: ----
93: 204.162.98.88, 3433194072
94: ----
95: 205.226.203.56, 3454192440 -> 204.162.97.152, 3433193880 -> 206.3.0.250, 3456303354
96: 204.162.98.91, 3433194075

In the HashSC object:

Table Size = 97
Number of entries = 61
Load factor = 0.6288659793814433
Number of collisions = 17
Longest Linked List = 3

Contents of HashQP with the String key:
0: ----
1: 204.162.98.88, 3433194072
2: ----
3: ----
4: ----
5: ----
6: 198.5.208, 12977616
7: 204.162.97.228, 3433193956
8: ----
9: ----
10: ----
11: 204.162.98.36, 3433194020
12: ----
13: 204.162.98.38, 3433194022
14: ----
15: ----
16: ----
17: ----
18: ----
19: ----
20: ----
21: ----
22: 204.202.132.19, 3435824147
23: ----
24: 204.162.98.151, 3433194135
25: ----
26: ----
27: ----
28: ----
29: ----
30: ----
31: 204.162.98.91, 3433194075
32: ----
33: ----
34: ----
35: 198.5.210, 12977618
36: ----
37: 204.162.97.231, 3433193959
38: 204.162.98.98, 3433194082
39: ----
40: ----
41: ----
42: ----
43: ----
44: ----
45: ----
46: ----
47: 204.162.98.45, 3433194029
48: ----
49: ----
50: 202.33.250.146, 3391224466
51: 202.33.250.147, 3391224467
52: 202.33.250.148, 3391224468
53: 202.33.250.149, 3391224469
54: 204.162.98.48, 3433194032
55: 204.162.98.49, 3433194033
56: ----
57: ----
58: 205.226.203.56, 3454192440
59: ----
60: ----
61: 204.162.98.161, 3433194145
62: 204.162.96, 13410912
63: ----
64: ----
65: ----
66: ----
67: ----
68: 204.162.98.168, 3433194152
69: ----
70: ----
71: ----
72: ----
73: ----
74: ----
75: ----
76: ----
77: ----
78: ----
79: ----
80: ----
81: 202.33.250.150, 3391224470
82: 202.33.250.151, 3391224471
83: 202.33.250.152, 3391224472
84: 205.226.203.186, 3454192570
85: 202.33.250.153, 3391224473
86: 202.33.250.154, 3391224474
87: ----
88: ----
89: ----
90: ----
91: 205.226.203.62, 3454192446
92: ----
93: ----
94: ----
95: ----
96: ----
97: ----
98: ----
99: ----
100: ----
101: ----
102: ----
103: ----
104: ----
105: ----
106: ----
107: ----
108: ----
109: ----
110: ----
111: 204.162.97.17, 3433193745
112: ----
113: 204.162.98.124, 3433194108
114: ----
115: 204.162.98.126, 3433194110
116: ----
117: ----
118: ----
119: ----
120: ----
121: ----
122: 204.162.97.152, 3433193880
123: ----
124: ----
125: ----
126: 206.3.30.196, 3456310980
127: 204.162.97.205, 3433193933
128: ----
129: 204.162.98.11, 3433193995
130: 204.162.98.12, 3433193996
131: ----
132: ----
133: ----
134: ----
135: ----
136: 204.162.98.18, 3433194002
137: ----
138: ----
139: ----
140: 204.162.98.2, 3433193986
141: 204.162.98.3, 3433193987
142: 204.162.98.4, 3433193988
143: 204.162.98.237, 3433194221
144: 204.162.98.5, 3433193989
145: 205.226.201, 13492937
146: 204.162.98.7, 3433193991
147: 204.162.98.8, 3433193992
148: 204.162.98.6, 3433193990
149: 204.162.97.1, 3433193729
150: 204.162.97.2, 3433193730
151: 204.162.97.3, 3433193731
152: ----
153: 195.145.119.24, 3281090328
154: 195.145.119.25, 3281090329
155: ----
156: 204.162.98.9, 3433193993
157: ----
158: 205.266.204.238, 3456814318
159: 206.3.0.250, 3456303354
160: 206.3.30.251, 3456311035
161: ----
162: ----
163: ----
164: ----
165: ----
166: ----
167: ----
168: ----
169: ----
170: ----
171: ----
172: 204.162.98.27, 3433194011
173: 204.162.98.192, 3433194176
174: ----
175: ----
176: ----
177: ----
178: ----
179: ----
180: 204.162.97.32, 3433193760
181: 205.226.203.35, 3454192419
182: ----
183: ----
184: ----
185: ----
186: ----
187: ----
188: ----
189: ----
190: 204.162.98.80, 3433194064
191: ----
192: ----
193: ----
194: ----
195: ----
196: ----

In the HashQP object:

Table Size = 197
Number of entries = 61
Load factor = 0.3096446700507614
Number of collisions = 20
Longest Collision Run = 3

Testing HashSC with IpValue key: 
Retrieved in HashTable, IpAddress: 204.202.132.19, 3435824147, now trying to delete it
Removed 204.202.132.19, 3435824147 successfully!

Testing HashQP with String key: 
Retrieved in HashTable, IpAddress: 204.202.132.19, 3435824147, now trying to delete it
Removed 204.202.132.19, 3435824147 successfully!

Now the contents of HashSC with the IpValue key has:
0: ----
1: ----
2: ----
3: 204.162.98.192, 3433194176
4: 205.226.203.62, 3454192446
5: ----
6: 204.162.98.98, 3433194082
7: 204.162.98.2, 3433193986
8: 204.162.98.3, 3433193987
9: 204.162.98.4, 3433193988
10: 204.162.98.5, 3433193989
11: 204.162.98.6, 3433193990
12: 195.145.119.24, 3281090328 -> 204.162.98.7, 3433193991
13: 195.145.119.25, 3281090329 -> 204.162.98.8, 3433193992
14: 204.162.98.9, 3433193993
15: ----
16: 206.3.30.251, 3456311035 -> 204.162.98.11, 3433193995
17: 204.162.98.12, 3433193996
18: ----
19: ----
20: ----
21: ----
22: ----
23: 204.162.98.18, 3433194002
24: ----
25: ----
26: ----
27: ----
28: ----
29: ----
30: ----
31: 205.226.203.186, 3454192570
32: 204.162.98.124, 3433194108 -> 204.162.98.27, 3433194011
33: ----
34: 204.162.98.126, 3433194110
35: ----
36: ----
37: ----
38: ----
39: ----
40: ----
41: 204.162.97.1, 3433193729 -> 204.162.98.36, 3433194020
42: 204.162.97.2, 3433193730
43: 205.226.201, 13492937 -> 204.162.97.3, 3433193731 -> 204.162.98.38, 3433194022
44: ----
45: ----
46: ----
47: ----
48: 204.162.98.237, 3433194221
49: ----
50: 204.162.98.45, 3433194029
51: 204.162.97.205, 3433193933
52: ----
53: 204.162.98.48, 3433194032
54: 204.162.98.49, 3433194033
55: ----
56: ----
57: 204.162.97.17, 3433193745
58: 206.3.30.196, 3456310980
59: 202.33.250.146, 3391224466 -> 204.162.98.151, 3433194135
60: 202.33.250.147, 3391224467
61: 202.33.250.148, 3391224468
62: 202.33.250.149, 3391224469
63: 205.266.204.238, 3456814318 -> 202.33.250.150, 3391224470
64: 202.33.250.151, 3391224471
65: 202.33.250.152, 3391224472
66: 202.33.250.153, 3391224473
67: 202.33.250.154, 3391224474
68: ----
69: 204.162.98.161, 3433194145
70: ----
71: ----
72: 204.162.97.32, 3433193760
73: ----
74: 205.226.203.35, 3454192419 -> 204.162.97.228, 3433193956
75: ----
76: 204.162.98.168, 3433194152
77: 204.162.97.231, 3433193959
78: ----
79: ----
80: 204.162.96, 13410912
81: ----
82: ----
83: 198.5.208, 12977616
84: ----
85: 198.5.210, 12977618 -> 204.162.98.80, 3433194064
86: ----
87: ----
88: ----
89: ----
90: ----
91: ----
92: ----
93: 204.162.98.88, 3433194072
94: ----
95: 205.226.203.56, 3454192440 -> 204.162.97.152, 3433193880 -> 206.3.0.250, 3456303354
96: 204.162.98.91, 3433194075

Now the contents of HashQP with the String key has:
0: ----
1: 204.162.98.88, 3433194072
2: ----
3: ----
4: ----
5: ----
6: 198.5.208, 12977616
7: 204.162.97.228, 3433193956
8: ----
9: ----
10: ----
11: 204.162.98.36, 3433194020
12: ----
13: 204.162.98.38, 3433194022
14: ----
15: ----
16: ----
17: ----
18: ----
19: ----
20: ----
21: ----
22: ----
23: ----
24: 204.162.98.151, 3433194135
25: ----
26: ----
27: ----
28: ----
29: ----
30: ----
31: 204.162.98.91, 3433194075
32: ----
33: ----
34: ----
35: 198.5.210, 12977618
36: ----
37: 204.162.97.231, 3433193959
38: 204.162.98.98, 3433194082
39: ----
40: ----
41: ----
42: ----
43: ----
44: ----
45: ----
46: ----
47: 204.162.98.45, 3433194029
48: ----
49: ----
50: 202.33.250.146, 3391224466
51: 202.33.250.147, 3391224467
52: 202.33.250.148, 3391224468
53: 202.33.250.149, 3391224469
54: 204.162.98.48, 3433194032
55: 204.162.98.49, 3433194033
56: ----
57: ----
58: 205.226.203.56, 3454192440
59: ----
60: ----
61: 204.162.98.161, 3433194145
62: 204.162.96, 13410912
63: ----
64: ----
65: ----
66: ----
67: ----
68: 204.162.98.168, 3433194152
69: ----
70: ----
71: ----
72: ----
73: ----
74: ----
75: ----
76: ----
77: ----
78: ----
79: ----
80: ----
81: 202.33.250.150, 3391224470
82: 202.33.250.151, 3391224471
83: 202.33.250.152, 3391224472
84: 205.226.203.186, 3454192570
85: 202.33.250.153, 3391224473
86: 202.33.250.154, 3391224474
87: ----
88: ----
89: ----
90: ----
91: 205.226.203.62, 3454192446
92: ----
93: ----
94: ----
95: ----
96: ----
97: ----
98: ----
99: ----
100: ----
101: ----
102: ----
103: ----
104: ----
105: ----
106: ----
107: ----
108: ----
109: ----
110: ----
111: 204.162.97.17, 3433193745
112: ----
113: 204.162.98.124, 3433194108
114: ----
115: 204.162.98.126, 3433194110
116: ----
117: ----
118: ----
119: ----
120: ----
121: ----
122: 204.162.97.152, 3433193880
123: ----
124: ----
125: ----
126: 206.3.30.196, 3456310980
127: 204.162.97.205, 3433193933
128: ----
129: 204.162.98.11, 3433193995
130: 204.162.98.12, 3433193996
131: ----
132: ----
133: ----
134: ----
135: ----
136: 204.162.98.18, 3433194002
137: ----
138: ----
139: ----
140: 204.162.98.2, 3433193986
141: 204.162.98.3, 3433193987
142: 204.162.98.4, 3433193988
143: 204.162.98.237, 3433194221
144: 204.162.98.5, 3433193989
145: 205.226.201, 13492937
146: 204.162.98.7, 3433193991
147: 204.162.98.8, 3433193992
148: 204.162.98.6, 3433193990
149: 204.162.97.1, 3433193729
150: 204.162.97.2, 3433193730
151: 204.162.97.3, 3433193731
152: ----
153: 195.145.119.24, 3281090328
154: 195.145.119.25, 3281090329
155: ----
156: 204.162.98.9, 3433193993
157: ----
158: 205.266.204.238, 3456814318
159: 206.3.0.250, 3456303354
160: 206.3.30.251, 3456311035
161: ----
162: ----
163: ----
164: ----
165: ----
166: ----
167: ----
168: ----
169: ----
170: ----
171: ----
172: 204.162.98.27, 3433194011
173: 204.162.98.192, 3433194176
174: ----
175: ----
176: ----
177: ----
178: ----
179: ----
180: 204.162.97.32, 3433193760
181: 205.226.203.35, 3454192419
182: ----
183: ----
184: ----
185: ----
186: ----
187: ----
188: ----
189: ----
190: 204.162.98.80, 3433194064
191: ----
192: ----
193: ----
194: ----
195: ----
196: ----

*/
