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
 * This SkipNode class makes the skipnodes for skiplist so that it uses the
 * KVPair
 * 
 * @author Abigail Sun
 * @version 2021.20.09
 *
 * @param <K>
 *            Key
 * @param <E>
 *            Element/Data
 */
class SkipNode<K extends Comparable<K>, E> {
    private KVPair<K, E> rec;
    /**
     * SkipNode that goes through the list
     */
    SkipNode<K, E>[] forward;
    private int level;

    /**
     * Returns element/data
     * 
     * @return the data inside the KVPair
     */
    public E element() {
        return rec.value();
    }


    /**
     * Returns the key
     * 
     * @return Key for KVPair
     */
    public K key() {
        return rec.key();
    }


    /**
     * Instantiates skip node for SkipList
     * 
     * @param key
     *            The name of rectangle
     * @param elem
     *            The data within rectangle
     * @param level
     *            The level/number of nodes
     */
    @SuppressWarnings("unchecked")
    public SkipNode(K key, E elem, int level) {
        rec = new KVPair<K, E>(key, elem);
        forward = new SkipNode[level + 1];
        for (int i = 0; i < level; i++) {
            forward[i] = null;
        }
        this.level = level;
    }


    /**
     * Converts SkipNode to string
     * 
     * @return the SkipNode into a string
     */
    public String toString() {
        return rec.toString();
    }


    /**
     * Returns number of levels
     * 
     * @return levels of nodes
     */
    public int levels() {
        return level;
    }

}
