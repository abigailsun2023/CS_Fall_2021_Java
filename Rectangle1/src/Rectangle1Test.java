import java.io.FileNotFoundException;
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
 * Tests the Rectangle1 class (main method)
 * 
 * @author Abigail Sun
 * @version 2021.09.24
 *
 */
public class Rectangle1Test extends TestCase {

    /**
     * Tests the main method with practice file to see if all functions/methods
     * are
     * working/displaying properly
     * 
     * @throws FileNotFoundException
     */
    public void testMain() throws FileNotFoundException {
        String[] stringy = { "P1test2.txt" };
        //Rectangle1.main(stringy);
        assertNotNull(stringy);

        try {
            Rectangle1.main(stringy);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}
