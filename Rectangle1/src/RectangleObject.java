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
 * RectangleObject class creates the rectangles
 * 
 * @author Abigail Sun
 * @version 2021.09.15
 */
public class RectangleObject implements Comparable<RectangleObject> {
    private int x;
    private int y;
    private int w;
    private int h;

    /**
     * Constructor for RectangleObject which makes it take in parameters for the
     * x/y-coordinates, width and height
     * 
     * @param name
     * @param x
     *            x coordinate
     * @param y
     *            y coordinate
     * @param w
     *            width of rectangle object
     * @param h
     *            height of rectangle object
     */
    RectangleObject(int x, int y, int w, int h) {
        this.w = w;
        this.h = h;
        this.x = x;
        this.y = y;
    }


    /**
     * Returns width
     * 
     * @return width of rectangle
     */
    public int getWidth() {
        return w;
    }


    /**
     * Returns height
     * 
     * @return height of rectangle
     */
    public int getHeight() {
        return h;
    }


    /**
     * Returns x coordinate
     * 
     * @return x coordinate
     */
    public int getX() {
        return x;
    }


    /**
     * Returns y coordinate
     * 
     * @return y coordinate
     */
    public int getY() {
        return y;
    }


    /**
     * Returns all the data for rectangle
     * 
     * @return rec Returns the coordinates, height, and width to be equal to the
     *         value
     */
    @Override
    public boolean equals(Object rec) {
        if (rec == null) {
            return false;
        }
        if (!rec.getClass().equals(this.getClass())) {
            return false;
        }
        else if (rec != null) {
            if ((((RectangleObject)rec).getX() == x && ((RectangleObject)rec)
                .getY() == y) && ((RectangleObject)rec).getHeight() == h
                && ((RectangleObject)rec).getWidth() == w) {
                return true;
            }
        }
        return false;
    }


    /**
     * Converts the RectangleObject data into a string
     * 
     * @return x, y, w, and h for the parameters of the rectangle object
     */
    public String toString() {
        return (x + ", " + y + ", " + w + ", " + h);
    }


    /**
     * When two rectangles are overlapping each other
     * 
     * @param rec
     *            Other rectangle object
     * @return Returns if the two RectangleObjects are overlapping or not
     */
    public boolean overlap(RectangleObject rec) {
        if ((rec.getX() + rec.getWidth() <= x) || (x + w <= rec.getX())) {
            return false;
        }
        if ((rec.getY() + rec.getHeight() <= y) || (y + h <= rec.getY())) {
            return false;
        }
        return true;

    }

    @Override
    public int compareTo(RectangleObject o) {
        return 0;
    }

}
