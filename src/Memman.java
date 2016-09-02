import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

    private static HashTable<String, Handle> artist, song;
    private static MemManager pool;
    private static DList freeBlocks;

    /**
     * @param args
     *     Command line parameters
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Require 3 parameter.");
            System.exit(1);
        }

        init(args);
        readFile(args[2]);
    }

    private static void init(String[] args) {
        int size = Integer.parseInt(args[0]);
        artist = new HashTable<String, Handle>(size);
        song = new HashTable<String, Handle>(size);

        size = Integer.parseInt(args[1]);
        pool = new MemManager(size);
        freeBlocks = new DList();
    }

    public static void readFile(String fileName) {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ", 2);

                if (words[0] == "insert") {
                    insert(words[1]);
                }
                else if (words[0] == "remove") {
                    remove(words[1]);
                }
                else {
                    print(words[1]);
                }
            }
            reader.close();
        } 
        catch (IOException e) {        
            e.printStackTrace();
        }
    }

    public static void insert(String str) {

    }

    public static void remove(String str) {

    }

    public static void print(String str) {

    }

}
