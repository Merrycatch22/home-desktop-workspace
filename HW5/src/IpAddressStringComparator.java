import java.util.Comparator;
/**
 * IpAddressStringComparator.java
 * Nicholas Tarn
 * 6/5/16
 * Windows 7 Eclipse Compiler for Java
 * compares ip strings.
 *
 */
public class IpAddressStringComparator implements Comparator<IpAddress>{

	@Override
	/**
	 * compares ip strings.
	 */
	public int compare(IpAddress arg0, IpAddress arg1) {
		// TODO Auto-generated method stub
		return arg0.getDottedDecimal().compareTo(arg1.getDottedDecimal());
	}

}
