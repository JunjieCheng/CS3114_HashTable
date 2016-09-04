import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



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

        Handle h = pool.insert(words[0]);
        if (artist.insert(words[0], h)) {
            System.out.println("|" + words[0] +
                    "| is added to the artist database.");
        }
        else {
            System.out.println("|" + words[0] + 
                    "| duplicates a record already in the artist database.");
        }

        h = pool.insert(words[1]);

        if (song.insert(words[1], h)) {
            System.out.println("|" + words[1] + 
                    "| is added to the song database.");
        }
        else {
            System.out.println("|" + words[1] + 
                    "| duplicates a record already in the song database.");
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
     */
    public static void print(String str) {
        if (str.equals("artist")) {
            artist.print("artist");
        }
        else if (str.equals("song")) {
            song.print("song");
        }
        else {
            pool.print();
        }
    }

}
