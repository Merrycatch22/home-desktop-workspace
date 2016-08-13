import java.util.Comparator;
/**
 * YearComparator.java
 * Nicholas Tarn
 * 5/25/16
 * Windows 7 Eclipse Compiler for Java
 * Compares based on year.
 *
 */
public class YearComparator implements Comparator<Date> {

	@Override
/**
 * calls the first Date's compareTo with argument as the second date.
 */
	public int compare(Date arg0, Date arg1) {
		return arg0.compareTo(arg1);
	}

}
