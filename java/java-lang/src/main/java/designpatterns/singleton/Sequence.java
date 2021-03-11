package designpatterns.singleton;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * ** Some things to note about this implementation: ** Synchronized methods are used to ensure that
 * the class is thread-safe. This class cannot be sub-classed because the constructor is private.
 * This may or may not be a good thing depending on the resource being protected. To allow
 * sub-classing, the visibility of the constructor should be changed to protected. Object
 * serialization can cause problems; if a Singleton is serialized and then de-serialized more than
 * once, there will be multiple objects and not a singleton.
 */
public class Sequence {

    private static final Sequence instance = new Sequence();
    private static final AtomicInteger counter = new AtomicInteger(0);

    public static synchronized Sequence getInstance() {
        // Lazy instantiation
        /*
         * if (instance == null) { instance = new Sequence(); }
         */
        return instance;
    }

    public static synchronized int next() {
        return counter.incrementAndGet();
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }
}
