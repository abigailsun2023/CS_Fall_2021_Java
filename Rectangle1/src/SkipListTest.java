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
 * This class tests all the methods and edge cases in the SkipList class
 * 
 * @author Abigail Sun
 * @version 2021.23.09
 *
 */
public class SkipListTest extends TestCase {

    private SkipList<String, RectangleObject> list;
    private SkipList<Integer, String> list2;
    private RectangleObject rect;
    private RectangleObject rect2;
    private RectangleObject rect3;
    private RectangleObject rect6;

    /**
     * Sets up the test class
     */
    public void setUp() {
        list = new SkipList<String, RectangleObject>();
        list2 = new SkipList<Integer, String>();
        rect = new RectangleObject(10, 2, 30, 40);
        rect2 = new RectangleObject(1, 2, 3, 4);
        rect3 = new RectangleObject(1, 3, -1, 0);
        rect6 = new RectangleObject(10, 3, 50, 10);

    }


    /**
     * Tests search method
     */
    public void testSearch() {
        assertEquals(list2.size(), 0);
        list2.insert(2, "sit");
        list2.insert(3, "sit");
        list2.insert(2, "dummy");

        assertEquals(list2.search(2), "dummy");
        list2.remove(3);
        assertEquals(list2.search(3), null);
        assertEquals(list2.search(1), null);
    }


    /**
     * Tests findRectangle method
     */
    public void testFindRectangle() {
        // Tests the condition that if the skiplist is null, it will return with
        // rectangle not found and that it's null
        list2.findRectangle(null);
        assertEquals(systemOut().getHistory().toString(),
            "Rectangle not found: null\n");

        // Tests the condition that: while (x.forward[0] != null &&
        // x.forward[0].key().compareTo(key) == 0) {
        list2.insert(3, "sit");
        list2.insert(3, "down");
        assertEquals(list2.size(), 2);

        list2.findRectangle(3);
        assertEquals(systemOut().getHistory().toString(),
            "Rectangle not found: null\n" + "Rectangles found:\n"
                + "(3, down)\n" + "(3, sit)\n");

        list2.remove2(3, "sit");
        list2.remove2(3, "down");
        list2.findRectangle(3);
        assertEquals(systemOut().getHistory().toString(),
            "Rectangle not found: null\n" + "Rectangles found:\n"
                + "(3, down)\n" + "(3, sit)\n" + "Rectangles found:\n"
                + "(3, sit)\n");

    }


    /**
     * Tests findByElement method
     */
    public void testFindByElement() {
        assertEquals(list.size(), 0);
        list.insert("r1", rect);
        list.insert("r2", rect2);
        list.insert("r3", rect3);

        assertEquals("r2", list.findByElement(rect2));

        list.remove("r1");
        list.remove("r2");

        assertEquals(null, list.findByElement(rect2));
    }


    /**
     * Tests insert method
     */
    public void testInsert() {
        assertEquals(list2.size(), 0);
        list2.insert(2, "sit");
        assertEquals(list2.size(), 1);
        System.out.print(list2.toString());
    }


    /**
     * Tests the remove method (by name)
     */
    public void testRemove() {
        assertEquals(list2.size(), 0);
        list2.insert(2, "sit");
        assertEquals(list2.size(), 1);
        list2.remove(2);
        assertEquals(list2.size(), 0);

        list2.insert(1, "dummy");
        list2.insert(1, "dummy");
        list2.insert(1, "dummy2");
        list2.insert(1, "dummy3");
        list2.insert(2, "dummy4");
        list2.insert(3, "dummy5");
        list2.remove(1);
        assertEquals(list2.size(), 5);

        list2.remove(1);
        assertEquals(list2.size(), 4);

        list2.remove(3);
        assertEquals(list2.size(), 3);
    }


    /**
     * Tests the remove2 method
     */
    public void testRemove2() {
        list.insert("r1", rect);
        list.insert("r2", rect2);
        list.insert("r3", rect3);
        list.remove2("r2", rect2);
        assertEquals(list.size(), 2);

        list.remove2("r1", rect);
        list.remove2("r3", rect3);
        assertEquals(list.size(), 0);
    }


    /**
     * Tests remove by data method
     */
    public void testRemoveByData() {
        assertEquals(list2.size(), 0);
        list2.insert(2, "sit");
        assertEquals(list2.size(), 1);
        list2.removeByData("sit");
        assertEquals(list2.size(), 0);

    }


    /**
     * Tests the intersection method
     */
    public void testIntersections() {
        list.insert("r1", rect);
        list.insert("rect4", rect);
        list.intersections();

        list.insert("r6", rect6);
        assertEquals(systemOut().getHistory().toString(),
            "Intersections pairs:\n"
                + "(r1, 10, 2, 30, 40 | rect4, 10, 2, 30, 40)\n"
                + "(rect4, 10, 2, 30, 40 | r1, 10, 2, 30, 40)\n");
    }


    /**
     * Tests dump method with nothing inside
     */
    public void testDump1() {
        list.dump();
        assertEquals(systemOut().getHistory().toString(), "SkipList dump: \n"
            + "Node has depth 1, Value (null)\n" + "SkipList size is: 0\n");

    }


    /**
     * Tests dump method with elements inside
     */
    public void testDump2() {

        list2.insert(1, "rec");
        list2.insert(1, "rec2");
        list2.insert(2, "rec2");
        System.out.println("Dump starts here");

        list2.dump();
        assertEquals(3, list2.size());

    }


    /**
     * Tests regionsearch when a rectangle is supposed to be rejected since out
     * of
     * bounds
     */
    public void testRegionsearchRejected() {
        list.insert("r3", rect3);
        list.regionsearch(0, 0, -1000, -1000);
        assertEquals(systemOut().getHistory().toString(),
            "Rectangle rejected: (0, 0, -1000, -1000) \n");
    }

    /**
     * Tests regionsearch
     */
    public void testRegionsearch() {
        list.insert("r1", rect);
        list.regionsearch(0, 0, 1000, 1000);
        assertEquals(systemOut().getHistory().toString(),
            "Rectangles intersecting region (0, 0, 1000, 1000): \n"
                + "(r1, 10, 2, 30, 40) \n");

    }


    /**
     * Tests regionsearch when no rectangles are in the region
     */
    public void testRegionsearchNull() {
        list.regionsearch(0, 0, 1000, 1000);
        assertEquals(systemOut().getHistory().toString(),
            "Rectangles intersecting region (0, 0, 1000, 1000): \n");
    }

}
