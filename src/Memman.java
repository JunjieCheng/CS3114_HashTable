import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Memory management
 */

/**
 * The class containing the main method.
 *
 * @author Junjie Cheng(cjunjie) Liang Shi(blairshi)
 * @version September 1, 2016
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
        artist = new HashTable<String, Handle>(size);
        song = new HashTable<String, Handle>(size);

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
        BufferedWriter writer;

        reader = new BufferedReader(new FileReader(fileName));
        writer = new BufferedWriter(new FileWriter("Output.txt"));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] words = line.split(" ", 2);

            if (words[0].equals("insert")) {
                insert(words[1], writer);
            }
            else if (words[0].equals("remove")) {
                remove(words[1]);
            }
            else {
                print(words[1], writer);
            }
        }

        reader.close();
        writer.close();
    }

    /**
     * Insert.
     * @param str   Inserted String.
     * @param f     Output file.
     * @throws IOException
     */
    public static void insert(String str, BufferedWriter f) throws IOException {
        String[] words = str.split("<SEP>");

        Handle h = pool.insert(words[0]);
        if (artist.insert(words[0], h)) {
            f.write("|" + words[0] + "| is added to the artist database.\n");
        }
        else {
            f.write("|" + words[0] + "| duplicates a record already in the artist database.\n");
        }

        h = pool.insert(words[1]);

        if (song.insert(words[1], h)) {
            f.write("|" + words[1] + "| is added to the song database.\n");
        }
        else {
            f.write("|" + words[1] + "| duplicates a record already in the song database.\n");
        }
    }

    /**
     * Remove.
     * @param str   Removed String.
     */
    public static void remove(String str) {
        //TODO for mileStone 3
    }

    /**
     * Print.
     * @param str   Print option.
     * @param f     Output file.
     * @throws IOException
     */
    public static void print(String str, BufferedWriter f) throws IOException {
        if (str.equals("artist")) {
            artist.print(f, "artist");
        }
        else if (str.equals("song")) {
            song.print(f, "song");
        }
        else {
            //TODO
        }
    }

}
