import java.util.Comparator;
/**
 * IpAddressStringComparator.java
 * Nicholas Tarn
 * 6/5/16
 * Windows 7 Eclipse Compiler for Java
 * compares ip values.
 *
 */
public class IpAddressValueComparator implements Comparator<IpAddress>{

	@Override
	/**
	 * compares ip values
	 */
	public int compare(IpAddress arg0, IpAddress arg1) {
		// TODO Auto-generated method stub
		return Long.valueOf(arg0.getIpValue()).compareTo(Long.valueOf(arg1.getIpValue()));
	}

}
