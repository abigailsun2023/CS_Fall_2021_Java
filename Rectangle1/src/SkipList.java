import java.util.Random;
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
 * SkipList class where all the methods that are needed to create the skiplist
 * for rectangle1
 * 
 * @author Abigail Sun
 * @version 2021.09.24
 *
 * @param <K>
 *            Key for each node
 * @param <E>
 *            Element/data in the skiplist
 */
class SkipList<K extends Comparable<K>, E> {
    private SkipNode<K, E> head;
    private int level;
    private int size;
    static private Random ran = new Random(); // Hold the Random class object

    /**
     * Constructor for SkipList class
     */
    public SkipList() {
        head = new SkipNode<K, E>(null, null, 0);
        level = -1;
        size = 0;
    }


    /**
     * Searches the SkipList to see if the list is null
     * 
     * @param key
     *            name of rectangle
     * @return If there are elements in the SkipList
     */
    public E search(K key) {
        SkipNode<K, E> x = head; // Dummy header node
        for (int i = level; i >= 0; i--) {// For each level...
            while ((x.forward[i] != null) && (x.forward[i].key().compareTo(
                key) < 0)) // go forward
            {
                x = x.forward[i]; // Go one last step
            }
        }
        x = x.forward[0]; // Move to actual record, if it exists
        if ((x != null) && (x.key().compareTo(key) == 0)) {
            return x.element(); // Got it
        }
        else {
            return null; // Its not there
        }
    }


    /**
     * Finds the rectangles in the SkipList
     * 
     * @param key
     *            Name of rectangle
     */
    public void findRectangle(K key) {
        SkipNode<K, E> x = head; // Dummy header node
        for (int i = level; i >= 0; i--) // For each level...
        {
            while ((x.forward[i] != null) && (x.forward[i].key().compareTo(
                key) < 0)) // go forward
            {
                x = x.forward[i]; // Go one last step
            }
        }
        if (x.forward[0] != null && x.forward[0].key().compareTo(key) == 0) {
            x = x.forward[0];
            System.out.print("Rectangles found:\n");
            System.out.print("(" + key + ", " + x.element() + ")\n"); // Got it
            while (x.forward[0] != null && x.forward[0].key().compareTo(
                key) == 0) {
                x = x.forward[0];
                System.out.print("(" + key + ", " + x.element() + ")\n"); // Got
                                                                          // it
            }
        }
        else {
            System.out.print("Rectangle not found: " + key + "\n");
        }
    }


    /**
     * Finds a rectangle by data/element
     * 
     * @param elem
     *            Data in a rectangle
     * @return element Rectangle
     */
    public K findByElement(E elem) {
        SkipNode<K, E> x = head; // Dummy header node
        while (x.forward[0] != null) {
            x = x.forward[0];
            if (x.element().equals(elem)) {
                return x.key();
            }
        }
        return null;
    }


    /**
     * Inserts a rectangle using a key and taking the element
     * 
     * @param key
     *            Name of rectangles
     * @param elem
     *            Data of rectangles
     */
    public void insert(K key, E elem) {
        int newLevel = randomLevel(); // New node's level
        if (newLevel > level) {// If new node is deeper
            adjustHead(newLevel); // adjust the header
        }
        // Track end of level
        @SuppressWarnings("unchecked")
        SkipNode<K, E>[] update = new SkipNode[level + 1];
        SkipNode<K, E> x = head; // Start at header node
        for (int i = level; i >= 0; i--) { // Find insert position
            while ((x.forward[i] != null) && (x.forward[i].key().compareTo(
                key) < 0)) {
                x = x.forward[i];
            }
            update[i] = x; // Track end at level i
        }
        x = new SkipNode<K, E>(key, elem, newLevel);
        for (int i = 0; i <= newLevel; i++) { // Splice into list
            x.forward[i] = update[i].forward[i]; // Who x points to
            update[i].forward[i] = x; // Who points to x
        }
        size++; // Increment dictionary size
    }


    /**
     * Adjusts the head of the SkipList whenever there's a new level
     * 
     * @param newLevel
     *            The new number of levels
     */
    private void adjustHead(int newLevel) {
        SkipNode<K, E> temp = head;
        head = new SkipNode<K, E>(null, null, newLevel);
        for (int i = 0; i <= level; i++) {
            head.forward[i] = temp.forward[i];
        }
        level = newLevel;
    }


    /**
     * Will return the level of nodes. This will be random everytime it's called
     * 
     * @return lev The level of nodes
     */
    int randomLevel() {
        int lev;
        for (lev = 0; Math.abs(ran.nextInt()) % 2 == 0; lev++) {// ran is random
                                                                // generator
            // Do nothing
        }
        return lev;
    }


    /**
     * Instantiates the size
     * 
     * @return Size
     */
    public int size() {
        return size;

    }


    /**
     * Removes a rectangle by name
     * 
     * @param key
     *            Name of rectangle removed
     */
    public void remove(K key) {
        int shmitty = 0;
        SkipNode<K, E> x = head; // Dummy header node
        for (int i = level; i >= 0; i--) {
            while ((x.forward[i] != null) && (x.forward[i].key().compareTo(
                key) < 0)) {
                x = x.forward[i];
            }
            if ((x.forward[i] != null) && (x.forward[i].key().compareTo(
                key) == 0)) {
                shmitty = 1;
                if (x.forward[i].forward[i] != null) {
                    x.forward[i] = x.forward[i].forward[i];
                }
                else {
                    x.forward[i] = null;
                }

            }
        }
        if (shmitty == 1) {
            size--;
        }

    }


    /**
     * Removes a rectangle by name and data
     * 
     * @param key
     *            Name of rectangle removed
     * @param elem
     *            Data for the rectangle
     */
    public void remove2(K key, E elem) {
        int shmitty = 0;
        SkipNode<K, E> x = head; // Dummy header node
        for (int i = level; i >= 0; i--) {
            while (x.forward[i] != null && x.forward[i].key().compareTo(key) < 0
                && !elem.equals(x.forward[i].element())) {
                x = x.forward[i];
            }
            if ((x.forward[i] != null) && x.forward[i].key().compareTo(key) == 0
                && elem.equals(x.forward[i].element())) {
                shmitty = 1;
                if (x.forward[i].forward[i] != null) {
                    x.forward[i] = x.forward[i].forward[i];
                }
                else {
                    x.forward[i] = null;
                }

            }
        }
        if (shmitty == 1) {
            size--;
        }

    }


    /**
     * Removes rectangle by data
     * 
     * @param elem
     *            The data for the removed rectangle
     */
    public void removeByData(E elem) {
        SkipNode<K, E> x = head;
        while (x.forward[0] != null) {
            x = x.forward[0];
            if (x.element().equals(elem)) {
                remove(x.key());
            }
        }
    }


    /**
     * Turns the elements and key information into a string for dump()
     * 
     * @return String of key and element
     */
    public String toString() {
        StringBuilder dummy = new StringBuilder();
        SkipNode<K, E> x = head;
        while (x.forward[0] != null) {
            x = x.forward[0];
            dummy.append(x.key() + " " + x.element() + "\n");
        }
        return dummy.toString();
    }


    /**
     * Checks for rectangles that are intersecting/overlapping
     */
    public void intersections() {

        System.out.print("Intersections pairs:\n");
        SkipNode<K, E> a = head;
        SkipNode<K, E> b = head.forward[0];
        while (a.forward[0] != null) {
            a = a.forward[0];
            while (b != null) {
                if (((RectangleObject)a.element()).overlap((RectangleObject)b
                    .element()) && !a.equals(b)) {
                    System.out.print("(" + a.key() + ", " + a.element()
                        .toString() + " | " + b.key() + ", " + b.element()
                            .toString() + ")\n");
                }
                b = b.forward[0];
            }
            b = head.forward[0];
        }
    }


    /**
     * Dumps all the information/rectangles that were inserted, removed,
     * found/not
     * found, intersecting, etc.
     * 
     * @return The string of all the data
     */
    public String dump() {
        StringBuilder build = new StringBuilder();
        build.append("SkipList dump: \n");
        SkipNode<K, E> a = head;
        build.append("Node has depth " + (a.levels() + 1) + ", Value (null)\n");

        while (a.forward[0] != null) {
            a = a.forward[0];
            build.append("Node has depth " + (a.levels() + 1) + ", Value (" + a
                .key() + ", " + a.element() + ")\n");
        }
        build.append("SkipList size is: " + size + "\n");
        System.out.print(build.toString());
        return build.toString();

    }


    /**
     * Searches the region to see what rectangles (if any) are in the called
     * region
     * 
     * @param x
     *            x-coordinate
     * @param y
     *            y-coordinate
     * @param w
     *            width
     * @param h
     *            height
     */
    public void regionsearch(int x, int y, int w, int h) {
        SkipNode<K, E> a = head;
        RectangleObject r = new RectangleObject(x, y, w, h);
        if (h <= 0 || w <= 0) {
            System.out.print("Rectangle rejected: (" + r.toString() + ") \n");
            return;
        }
        System.out.print("Rectangles intersecting region (" + r.toString()
            + "): \n");
        while (a.forward[0] != null) {
            a = a.forward[0];

            if (((RectangleObject)a.element()).overlap(r)) {
                System.out.print("(" + a.key() + ", " + a.element() + ") \n");
            }
        }
    }

}
