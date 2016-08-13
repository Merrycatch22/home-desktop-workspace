/**
 * IpAddressStringHasher.java
 * Nicholas Tarn
 * 6/5/16
 * Windows 7 Eclipse Compiler for Java
 * hashes by dotteddecimal per char.
 *
 */
public class IpAddressStringHasher implements Hasher<IpAddress> {

	@Override
	/**
	 * hashes by dotteddecimal per char.
	 */
	public int hash(IpAddress elem) {
		// TODO Auto-generated method stub
		int k, retVal = 0;
		String key=elem.getDottedDecimal();
		for(k=0;k<key.length();k++){
			retVal=37*retVal+key.charAt(k);
			
		}
		return retVal;
	}

}
