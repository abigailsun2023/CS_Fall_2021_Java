import student.TestCase;

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
 * This class tests the KVPair methods to see if they work properly
 * 
 * @author Abigail Sun
 * @version 2021.22.09
 *
 */
public class KVPairTest extends TestCase {
    private KVPair<String, RectangleObject> perry;
    private KVPair<String, RectangleObject> perry2;

    /**
     * Sets up the test class
     */
    public void setUp() {
        RectangleObject r = new RectangleObject(0, 0, 2, 2);
        RectangleObject r2 = new RectangleObject(0, 0, 2, 2);

        perry = new KVPair<String, RectangleObject>("sup", r);
        perry2 = new KVPair<String, RectangleObject>("sup", r2);

    }


    /**
     * Tests the compareTo method
     */
    public void testCompareTo() {
        // Compares perry3 to the others since it's a different type
        String perry3 = "yo";

        assertEquals("0, 0, 2, 2", perry2.value().toString());
        assertEquals(0, perry.compareTo(perry2));
        assertEquals(-6, perry.compareTo(perry3));

    }


    /**
     * Tests to see if the key() method gives the right key
     */
    public void testKey() {
        assertEquals("sup", perry.key());
    }


    /**
     * Tests toString for KVPair
     */
    public void testToString() {
        assertEquals("sup, 0, 0, 2, 2", perry2.toString());

    }

}
