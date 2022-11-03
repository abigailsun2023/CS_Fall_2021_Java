import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
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
 * The Rectangle1 class where it throws a FileNotFoundException
 *
 * @author Abigail Sun
 * @version 2021.09.10
 */
public class Rectangle1 {
    private static Scanner scan;
    private static SkipList<String, RectangleObject> skip =
        new SkipList<String, RectangleObject>();

    /**
     * Main function for parsing and output.
     * 
     * @param args
     *            input for the parser
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(args[0]);
        scan = new Scanner(file);
        skip = new SkipList<>();

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] parts = line.trim().split("\\s+");
            if (parts[0].contentEquals("insert") && parts.length == 6) {

                int x = 0;
                int y = 0;
                int w = 0;
                int h = 0;
                try {
                    x = Integer.parseInt(parts[2]);
                    y = Integer.parseInt(parts[3]);
                    w = Integer.parseInt(parts[4]);
                    h = Integer.parseInt(parts[5]);
                }
                catch (NumberFormatException e) {
                    System.out.print("Invalid Command Format");
                }
                insert(parts[1], x, y, w, h);
            }
            else if (parts[0].contentEquals("remove") && parts.length == 2) {
                remove(parts[1]);

            }
            else if (parts[0].contentEquals("remove") && parts.length == 5) {

                int x = 0;
                int y = 0;
                int w = 0;
                int h = 0;
                try {
                    x = Integer.parseInt(parts[1]);
                    y = Integer.parseInt(parts[2]);
                    w = Integer.parseInt(parts[3]);
                    h = Integer.parseInt(parts[4]);
                }
                catch (NumberFormatException e) {
                    System.out.print("Invalid Command Format");
                }
                removeByData(x, y, w, h);

            }
            else if (parts[0].contentEquals("search")) {
                skip.findRectangle(parts[1]);
            }

            else if (parts[0].contentEquals("dump")) {
                skip.dump();
            }
            else if (parts[0].contentEquals("regionsearch")
                && parts.length == 5) {

                int x = 0;
                int y = 0;
                int w = 0;
                int h = 0;
                try {
                    x = Integer.parseInt(parts[1]);
                    y = Integer.parseInt(parts[2]);
                    w = Integer.parseInt(parts[3]);
                    h = Integer.parseInt(parts[4]);
                }
                catch (NumberFormatException e) {
                    System.out.print("Invalid Command Format");
                }
                skip.regionsearch(x, y, w, h);

            }
            else if (parts[0].contentEquals("intersections")
                && parts.length == 1) {
                skip.intersections();

            }

        }
        scan.close();
    }


    /**
     * Produces the output for insertions of data
     * 
     * @param name
     *            Name of rectangle inserted
     * @param x
     *            X-coordinate of rectangle inserted
     * @param y
     *            Y-coordinate of rectangle inserted
     * @param w
     *            Width of rectangle inserted
     * @param h
     *            Height of rectangle inserted
     */
    public static void insert(String name, int x, int y, int w, int h) {
        RectangleObject r = new RectangleObject(x, y, w, h);
        if (x + w > 1024 || h + y > 1024 || h <= 0 || w <= 0 || x < 0
            || y < 0) {
            System.out.print("Rectangle rejected: (" + name + ", " + r
                .toString() + ")\n");

        }
        else {
            skip.insert(name, r);
            System.out.print("Rectangle inserted: (" + name + ", " + r
                .toString() + ")\n");
        }
    }


    /**
     * Produces output when remove by name is invoked
     * 
     * @param name
     *            Name of rectangle
     */
    public static void remove(String name) {
        RectangleObject r = skip.search(name);
        if (r != null) {
            skip.remove(name);
            System.out.print("Rectangle removed: (" + name + ", " + r.toString()
                + ")\n");
        }
        else {
            System.out.print("Rectangle not removed: (" + name + ")\n");

        }
    }


    /**
     * Produces output when remove by data is invoked
     * 
     * @param x
     *            X-coordinate
     * @param y
     *            Y-coordinate
     * @param w
     *            Width
     * @param h
     *            Height
     */
    public static void removeByData(int x, int y, int w, int h) {
        RectangleObject r = new RectangleObject(x, y, w, h);
        if (x + w > 1024 || y + h > 1024 || x < 0 || y < 0 || w <= 0
            || h <= 0) {
            System.out.print("Rectangle rejected: (" + r.toString() + ")\n");
            return;
        }
        String e = skip.findByElement(r);
        if (e != null) {
            skip.remove2(e, r);
            System.out.print("Rectangle removed: (" + e + ", " + r.toString()
                + ")\n");
        }
        else {
            System.out.print("Rectangle not found: (" + r.toString() + ")\n");
        }
    }

}
