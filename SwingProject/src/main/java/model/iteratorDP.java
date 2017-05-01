package model;

/**
 * Created by vindi on 4/25/2017.
 */
public interface iteratorDP {


    iteratorDP createIterator();
    Object next();
    Object getCurrent();
    boolean hasNext();

}
