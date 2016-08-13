/**
 * IpAddressValueHasher.java
 * Nicholas Tarn
 * 6/5/16
 * Windows 7 Eclipse Compiler for Java
 * hashes by ipvalue.
 *
 */
public class IpAddressValueHasher implements Hasher<IpAddress> {

	@Override
	/**
	 * hashes by ipvalue.
	 */
	public int hash(IpAddress elem) {
		// TODO Auto-generated method stub
		return Long.valueOf(elem.getIpValue()).hashCode();
	}

}
