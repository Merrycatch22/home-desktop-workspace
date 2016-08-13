/**
 * MonthVisitor.java
 * Nicholas Tarn
 * 5/25/16
 * Windows 7 Eclipse Compiler for Java
 * Visits dates. To be used on a BST with MonthComparator.
 *
 */
public class MonthVisitor implements Visitor<Date>{

	@Override
/** prints date toString*/
	public void visit(Date obj) {
		// TODO Auto-generated method stub
		System.out.println(obj.toString());
	}

}
