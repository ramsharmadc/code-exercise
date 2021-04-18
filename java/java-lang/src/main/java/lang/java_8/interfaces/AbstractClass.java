/**
 *
 */

package lang.java_8.interfaces;

/**
 * @author Lenovo
 */
public abstract class AbstractClass {

    private final int abstractVar = 0;

    protected abstract int methodOneofAbsCls(int pararm1);

    // Only pubic and protected methods/abstract methods are allowed
    public abstract int methodOneofAbsCls(int pararm1, int param2);

    // non-abstract methods can be private
    @SuppressWarnings("unused")
    private void methodTwoAbsCls() {

        System.out.println("Inside Abstract class non-abstract method." + abstractVar);
    }
}
