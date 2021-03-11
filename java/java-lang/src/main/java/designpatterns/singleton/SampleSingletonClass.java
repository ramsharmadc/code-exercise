package designpatterns.singleton;

/**
 * ** Some things to note about this implementation: ** Synchronized methods are used to ensure that
 * the class is thread-safe. This class cannot be sub-classed because the constructor is private.
 * This may or may not be a good thing depending on the resource being protected. To allow
 * sub-classing, the visibility of the constructor should be changed to protected. Object
 * serialization can cause problems; if a Singleton is serialized and then de-serialized more than
 * once, there will be multiple objects and not a singleton.
 */

public class SampleSingletonClass {

    private static SampleSingletonClass instance;

    public SampleSingletonClass() { // if the constructor made private, class
        // can not be extended
    }

    public synchronized SampleSingletonClass getInstance() {

        if (instance == null) {
            instance = new SampleSingletonClass();
        }

        return instance;
    }
}
