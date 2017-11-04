package edu.gcccd.csis;

import java.io.*;
import java.util.Iterator;
import java.util.Random;

/**
 * Java does not allow to store and add very long numbers.
 * Therefore, we are going to use very simple lists to store positive long numbers, one list element per digit.
 * The most significant digit is stored in the head element, the least significant digit is stored in the tail.
 * <p>
 * The main method may creates two very long numbers.
 * It is your task, to complete the class so that is can calculate the sum of positive very long numbers
 * and store the result in a file.
 * </p>
 * <p>
 * All methods need to have unit-test to verify corner cases and happy-paths.
 * You may find the java.math.BigInteger class help-full when writing the unittests.
 * </p>
 * Provide a detailed estimate (depending on the value of L),
 * for how often ANY iterator's next() method gets called, when
 * addition(Iterator<NodeList<Integer>> iterator) gets called.
 */
public class Project2 {

    static NodeList<Integer> generateNumber(final int maxLength) {
        final NodeList<Integer> nodeList = new NodeList<>();

        final int len = 1 + new Random().nextInt(maxLength);
        for (int i = 0; i < len; i++) {
            nodeList.append(new Random().nextInt(10));
        }
        return nodeList;
    }

    /**
     * Prints a very long number to System.out
     *
     * @param nodeList NodeList<Integer>
     */
    static void print(final NodeList<Integer> nodeList) {
        for (final Integer i : nodeList) {
            System.out.print(i);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int L = 30;

        final NodeList<Integer> n1 = generateNumber(L);
        final NodeList<Integer> n2 = generateNumber(L);

        final Project2 project = new Project2();

        // Print n1 (head 1st) e.g. 3457
        print(n1);

        // Print n2 (head 1st) e.g. 682
        print(n2);

        // Print n1+n2, e.g. 4139
        print(project.addition(n1, n2));

        NodeList<NodeList<Integer>> listOfLists = new NodeList<>();
        for (int i = 0; i<L; i++) {
            listOfLists.append(generateNumber(L));
        }
        project.save(project.addition(listOfLists.iterator()),"result.txt");
        print(project.load("result.txt"));
    }

    /**
     * Add two very long numbers
     *
     * @param nodeList1 NodeList<Integer>
     * @param nodeList2 NodeList<Integer>
     * @return nodeList representing the sum (add) of nodeList1 and nodeList2, without leading '0'
     */
    public NodeList<Integer> addition(NodeList<Integer> nodeList1, NodeList<Integer> nodeList2) {
        return null;
    }

    /**
     * Add very long numbers
     *
     * @param iterator Iterator<NodeList<Integer>>
     * @return nodeList representing the sum (add) of all very long numbers, without leading '0'
     */
    public NodeList<Integer> addition(Iterator<NodeList<Integer>> iterator) {
        return null;
    }

    /**
     * Saves a very large number as a file
     *
     * @param nodeList NodeList<Integer>
     * @param fileName String
     */
    public void save(NodeList<Integer> nodeList, String fileName) {

    }

    /**
     * Loads a very large number from a file
     *
     * @param fileName String
     * @return NodeList<Integer>
     */
    public NodeList<Integer> load(final String fileName) {
        return null;
    }
}