import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 * Memory management
 */

/**
 * The class containing the main method.
 * @author Junjie Cheng (cjunjie)
 * @version September 4, 2016
 */

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
// anyone other than my partner (in the case of a joint
// submission), instructor, ACM/UPE tutors or the TAs assigned
// to this course. I understand that I may discuss the concepts
// of this program with other students, and that another student
// may help me debug my program so long as neither of us writes
// anything during the discussion or modifies any computer file
// during the discussion. I have violated neither the spirit nor
// letter of this restriction.


public class Memman {

    /**
     * Artist Hash Table.
     */
    private static HashTable<String, Handle> artist;

    /**
     * Song Hash Table.
     */
    private static HashTable<String, Handle> song;

    /**
     * Memory pool.
     */
    private static MemManager pool;

    /**
     * @param args
     *     Command line parameters
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        if (args.length < 3) {
            System.out.println("Require 3 parameter.");
            System.exit(1);
        }

        init(args);
        readFile(args[2]);
    }

    /**
     * Initialize.
     * @param args  Arguments.
     */
    private static void init(String[] args) {
        int size = Integer.parseInt(args[0]);
        artist = new HashTable<String, Handle>("Artist", size);
        song = new HashTable<String, Handle>("Song", size);

        size = Integer.parseInt(args[1]);
        pool = new MemManager(size);
    }

    /**
     * Read file.
     * @param fileName  File name.
     * @throws IOException  
     */
    public static void readFile(String fileName) throws IOException {
        BufferedReader reader;

        reader = new BufferedReader(new FileReader(fileName));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] words = line.split(" ", 2);

            if (words[0].equals("insert")) {
                insert(words[1]);
            }
            else if (words[0].equals("remove")) {
                remove(words[1]);
            }
            else {
                print(words[1]);
            }
        }

        reader.close();
    }

    /**
     * Insert.
     * @param str   Inserted String.
     */
    public static void insert(String str) {
        String[] words = str.split("<SEP>");
        Handle h;

        if (artist.search(words[0]) == null) {
            h = pool.insert(words[0]);
            artist.insert(words[0], h);
        }

        if (song.search(words[1]) == null) {
            h = pool.insert(words[1]);
            song.insert(words[1], h);
        } 
    }

    /**
     * Remove.
     * @param str   Removed String.
     */
    public static void remove(String str) {
        String[] words = str.split(" ", 2);
        Handle h = null;

        if (words[0].equals("artist")) {
            h = artist.remove(words[1]);
        }
        else {
            h = song.remove(words[1]);
        }

        if (h != null) {
            pool.remove(h);
        }
    }

    /**
     * Print.
     * @param str   Print option.
     */
    public static void print(String str) {
        if (str.equals("artist")) {
            artist.print();
        }
        else if (str.equals("song")) {
            song.print();
        }
        else {
            pool.print();
        }
    }

}
