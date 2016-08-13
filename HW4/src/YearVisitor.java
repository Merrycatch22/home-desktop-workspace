/**
 * YearVisitor.java
 * Nicholas Tarn
 * 5/25/16
 * Windows 7 Eclipse Compiler for Java
 * Visits dates. To be used on a BST with YearComparator.
 *
 */
public class YearVisitor implements Visitor<Date>{

	@Override
	/**
	 * prints a date in dash format.
	 */
	public void visit(Date obj) {
		// TODO Auto-generated method stub
		System.out.println(obj.getYear()+"-"+obj.getMonth()+"-"+obj.getDay());
	}

}
