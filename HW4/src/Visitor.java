/**
 * Visitor.java
 * Nicholas Tarn
 * 5/25/16
 * Windows 7 Eclipse Compiler for Java
 * Visitor interface is separated.
 *
 */
public interface Visitor<T>
{
	/**visits an object.*/
    public void visit(T obj);
}