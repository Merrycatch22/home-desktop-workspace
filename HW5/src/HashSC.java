import java.util.*;

/**
 * HashSC.java
 * Nicholas Tarn
 * 6/5/16
 * Windows 7 Eclipse Compiler for Java
 * A hashTable of linkedLists to account for collisions.
 *
 */
public class HashSC<E> extends HashTable<E>// CHANGE TO MAKE THIS A SUBCLASS OF
											// HashTable for HW#5!!!!!!!!!!
{
	static final int INIT_TABLE_SIZE = 97;
	static final double INIT_MAX_LAMBDA = 1.5;

	protected LList<E>[] mLists;
	protected int mSize;
	protected int mTableSize;
	protected double mMaxLambda;

	public HashSC(int tableSize, Hasher<E> h, Comparator<E> c) // ADD
																// Comparator<E>
																// and Hasher<E>
																// parameters
																// for
																// HW#5!!!!!!!!
	{
		// Pass Comparator<E> and Hasher<E> parameters to the SUPERCLASS
		// constructor for HW#5!!!!!!!!!!

		super(h, c);
		if (tableSize < INIT_TABLE_SIZE)
			mTableSize = INIT_TABLE_SIZE;
		else
			mTableSize = nextPrime(tableSize);

		allocateMListArray(); // uses mTableSize;
		mMaxLambda = INIT_MAX_LAMBDA;
	}

	public HashSC(Hasher<E> h, Comparator<E> c)// ADD Comparator<E> and
												// Hasher<E> parameters for
												// HW#5!!!!!!!!
	{
		this(INIT_TABLE_SIZE, h, c); // FIX THIS (also pass Comparator<E> and
										// Hasher<E>)
	}

	// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	// DON'T FORGET TO OVERRIDE displayTable() (YOU WRITE FOR HW#5)
	// FOR EACH ARRAY ELEMENT...
	// Display the index of the array element, THEN
	// if the linked list at that element is empty, display "---"
	// otherwise, display the data in each linked list node all on ONE line, BUT
	// YOU MUST USE THE ITERATOR RETURNED FROM EACH LINKED LIST
	// to retrieve each Node's data (YOU ARE NOT ALLOWED TO CALL getEntry)
	// (see the test runs for examples)
	// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	/**
	 * displays the hashTable, -> designates that the collided linkedList's next entry.
	 */
	@Override
	public void displayTable() {
		// TODO Auto-generated method stub
		for (int i = 0; i < mLists.length; i++) {
			System.out.print(i + ": ");
			if (mLists[i].getLength() == 0) {
				System.out.print("----");
			} else {
				Iterator<E> iter = mLists[i].iterator();
				E currElem;
				for (int j = 0; iter.hasNext(); ++j) {
					if (j != 0) {
						System.out.print(" -> ");
					}
					currElem = iter.next();
					System.out.print(currElem.toString());
				}
			}
			System.out.println();
		}
	}
	/**
	 * gets an entry on the hash by comparatoring through the linkedList
	 */
	public E getEntry(E target) {
		LList<E> theList = mLists[myHash(target)];
		Iterator<E> iter = theList.iterator();
		E currElem;
		for (int i = 0; iter.hasNext(); ++i) {
			currElem = iter.next();
			if (comparator.compare(currElem, target) == 0)
				return currElem;
		}
		return null;
	}
	public boolean insert(E x) {
		LList<E> theList = mLists[myHash(x)];
		Iterator<E> iter = theList.iterator();
		E currElem;
		for (int i = 0; iter.hasNext(); ++i) {
			currElem = iter.next();
			if (comparator.compare(currElem, x) == 0) {
				return false;
			}
		}
		this.numCollisions+=theList.getLength();
		theList.add(x);
		if (theList.getLength() > this.longestCollisionRun) 
			this.longestCollisionRun = theList.getLength();
		if (++mSize > mMaxLambda * mTableSize)
			rehash();
		return true;
	}

	public void makeEmpty() {
		int k, size = mLists.length;

		for (k = 0; k < size; k++)
			mLists[k].clear();
		mSize = 0;
	}

	
	/**
	 * returns true if getEntry returns an item, false if null
	 */
	public boolean contains(E x) {
		LList<E> theList = mLists[myHash(x)];

		return getEntry(x) != null; // CHANGE AS INDICATED ON
									// HW#5!!!!!!!!!!!!!!!!
		// may call this' "fixed" getEntry as it traverses as required
	}

	
	/**
	 * uses comparator to insert into LList
	 * adds length of LList prior to add for collision
	 * checks if LList length is longer than longestCollisionRunz
	 */
	public boolean remove(E x) {
		LList<E> theList = mLists[myHash(x)];
		Iterator<E> iter = theList.iterator();
		E currElem;

		for (int i = 0; iter.hasNext(); ++i) {
			currElem = iter.next();
			if (comparator.compare(currElem, x) == 0) {
				theList.remove(i + 1);
				--mSize;
				return true;
			}
		}

		// not found
		return false;
	}

	public int size() {
		return mSize;
	}

	public boolean setMaxLambda(double lam) {
		if (lam < .1 || lam > 100.)
			return false;
		mMaxLambda = lam;
		return true;
	}

	public void displayStatistics() {
		System.out.println("\nIn the HashSC object:\n");
		System.out.println("Table Size = " + mTableSize);
		;
		System.out.println("Number of entries = " + mSize);
		System.out.println("Load factor = " + (double) mSize / mTableSize);
		System.out.println("Number of collisions = " + this.numCollisions);
		System.out.println("Longest Linked List = " + this.longestCollisionRun);
	}

	// protected methods of class ----------------------
	protected void rehash() {
		// ADD CODE HERE TO RESET THE HashTable COUNTERS TO 0 for
		// HW#5!!!!!!!!!!!!!!!!
		this.numCollisions = 0;
		this.longestCollisionRun = 0;
		// we save old list and size then we can reallocate freely
		LList<E>[] oldLists = mLists;
		int k, oldTableSize = mTableSize;
		Iterator<E> iter;

		mTableSize = nextPrime(2 * oldTableSize);

		// allocate a larger, empty array
		allocateMListArray(); // uses mTableSize;

		// use the insert() algorithm to re-enter old data
		mSize = 0;
		for (k = 0; k < oldTableSize; k++)
			for (iter = oldLists[k].iterator(); iter.hasNext();)
				insert(iter.next());
	}
	/**
	 * mods hash so to place in array
	 * @param x
	 * @return place to add to LList
	 */
	protected int myHash(E x) {
		int hashVal;

		// CHANGE TO USE Hasher's hash method INSTEAD of x.hashCode for
		// HW#5!!!!!!!!!!!
		// hashVal = x.hashCode() % mTableSize;
		hashVal = hasher.hash(x) % mTableSize;
		if (hashVal < 0)
			hashVal += mTableSize;

		return hashVal;
	}

	protected static int nextPrime(int n) {
		int k, candidate, loopLim;

		// loop doesn't work for 2 or 3
		if (n <= 2)
			return 2;
		else if (n == 3)
			return 3;

		for (candidate = (n % 2 == 0) ? n + 1 : n; true; candidate += 2) {
			// all primes > 3 are of the form 6k +/- 1
			loopLim = (int) ((Math.sqrt((double) candidate) + 1) / 6);

			// we know it is odd. check for divisibility by 3
			if (candidate % 3 == 0)
				continue;

			// now we can check for divisibility of 6k +/- 1 up to sqrt
			for (k = 1; k <= loopLim; k++) {
				if (candidate % (6 * k - 1) == 0)
					break;
				if (candidate % (6 * k + 1) == 0)
					break;
			}
			if (k > loopLim)
				return candidate;
		}
	}

	private void allocateMListArray() {
		int k;

		mLists = new LList[mTableSize];
		for (k = 0; k < mTableSize; k++)
			mLists[k] = new LList<E>();
	}

}
