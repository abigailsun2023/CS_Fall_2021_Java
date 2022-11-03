
// On my honor:
//
// - I have not used source code obtained from another student,
// or any other unauthorized source, either modified or
// unmodified.
//
// - All source code and documentation used in my program is
// either my original work, or was derived by me from the
// source code published in the textbook for this course.
//
// - I have not discussed coding details about this project with
// anyone other than the instructor, ACM/UPE tutors, programming
// partner (if allowed in this class), or the TAs assigned to
// this course. I understand that I may discuss the concepts
// of this program with other students, and that another student
// may help me debug my program so long as neither of us writes
// anything during the discussion or modifies any computer file
// during the discussion. I have violated neither the spirit nor
// letter of this restriction.
//
// - Abigail Sun

/**
 * The KVPair class that is the element of the skip nodes in the SkipList
 * 
 * @author Abigail Sun
 * @version 2021.23.09
 * 
 * @param <K>
 *            The key that the KVPair takes in
 * @param <E>
 *            The element that the KVPair takes in
 */
public class KVPair<K extends Comparable<K>, E> 
implements Comparable<KVPair<K, E>> {

    private E data;
    private K key;

    /**
     * Instantiates the KVPair needed for the SkipList methods
     * 
     * @param key2
     *            The key/name
     * @param elem
     *            The element/data
     */
    public KVPair(K key2, E elem) {
        data = elem;
        key = key2;
    }


    /**
     * Compares the KVPair to another
     * 
     * @param thing
     *            another KVPair to compare this KVPair to
     * @return 0 if the keys are equal
     */
    public int compareTo(KVPair<K, E> thing) {
        return key.compareTo(thing.key());
    }


    /**
     * Compares the key of this KVPair to the provided key
     * 
     * @param thing
     *            the key to compare to
     * @return 0 if the keys are equal
     */
    public int compareTo(K thing) {
        return key.compareTo(thing);
    }


    /**
     * Instantiates the data
     * 
     * @return data of the KVPair
     */
    public E value() {
        return data;
    }


    /**
     * Key/name of the KVPair
     * 
     * @return key for the name
     */
    public K key() {
        return key;
    }


    /**
     * Converts key and data to string for output
     * 
     * @return the key and data to a string
     */
    public String toString() {
        return (key.toString() + ", " + data.toString());

    }


}
