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
 * This SkipNodeTest class tests all the methods in SkipNode to make sure it's
 * functioning properly.
 * 
 * @author Abigail Sun
 * @version 2021.09.29
 *
 */
public class SkipNodeTest extends TestCase {
    private SkipNode<Integer, String> node;

    /**
     * Sets up the test class
     */
    public void setUp() {
        node = new SkipNode<Integer, String>(5, "Hi", 1);
    }


    /**
     * Tests the key() method to see if it's giving the right number
     */
    public void testKey() {
        assertEquals(5, (int)node.key());
    }


    /**
     * Tests the element() method to see if it's giving the right number
     */
    public void testElement() {
        assertEquals("Hi", node.element());
    }


    /**
     * Tests the toString() method to see if it's giving the right number
     */
    public void testToString() {
        assertEquals(node.toString(), "5, Hi");
    }
}
