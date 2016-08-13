import java.util.Comparator;
/**
 * MonthComparator.java
 * Nicholas Tarn
 * 5/25/16
 * Windows 7 Eclipse Compiler for Java
 * Compares based on month.
 *
 */
public class MonthComparator implements Comparator<Date> {
	
	@Override
	/**
	 * compares two Dates with priorities being month,day, then year
	 */
	public int compare(Date arg0, Date param) {
		int result=arg0.getMonth()-param.getMonth();
		if(result==0){
			result=arg0.getDay()-param.getDay();
			if(result==0){
				result=arg0.getYear()-param.getYear();
			}
		}
		return result;
	}

}
