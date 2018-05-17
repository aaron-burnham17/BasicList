package edu.gcccd.csis;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



import static org.junit.Assert.*;


public class NodeTest {

    private static NodeList<Integer> genNodeList(final String s) {
        final NodeList<Integer> nodeList = new NodeList<>();
        for (final char c : s.toCharArray()) {
            nodeList.append(Character.getNumericValue(c));
        }
        return nodeList;
    }

    private static BigInteger genBigInteger(final NodeList<Integer> nodeList) {
        final StringBuilder sb = new StringBuilder();
        for (final int i : nodeList) {
            sb.append(i);
        }
        return new BigInteger(sb.toString());
    }



    String fileName = "NodeList.bin";
    File file = new File(fileName);
    Path path = Paths.get(fileName);

    @Before
    public void deleteFiles()
    {
        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }





    //testing normal addition cases

    @Test
    public void testNormalAddition() {

        //testing normal addition
        final NodeList<Integer> n1 = Project2.generateNumber(30);
        final NodeList<Integer> n2 = Project2.generateNumber(30);

        final BigInteger N1 = genBigInteger(n1);
        final BigInteger N2 = genBigInteger(n2);
        final NodeList<Integer> n3 = new MyProject2().addition(n1, n2);
        final BigInteger N3 = N1.add(N2);

        assertEquals(N3, genBigInteger(n3));
    }

    @Test
    public void testNullAddition(){
        final NodeList<Integer> n1 = null;
        final NodeList<Integer> n2 = null;
        assertNull(new MyProject2().addition(n1,n2));

        final NodeList<Integer> n3 =  new NodeList<>();
        n3.append(1);
        assertNull(new MyProject2().addition(n1,n2));
        assertEquals(genBigInteger(n3),genBigInteger(new MyProject2().addition(n1,n3)));
        assertEquals(genBigInteger(n3),genBigInteger(new MyProject2().addition(n3,n1)));

    }

    @Test
    public void testRemainderAddition()
    {
        final NodeList<Integer> r1 = new NodeList<>();
        final NodeList<Integer> r2 = new NodeList<>();
        r1.append(8);
        r1.append(8);
        r1.append(8);
        r2.append(2);
        r2.append(1);
        r2.append(1);

        final NodeList<Integer> r3 = new MyProject2().addition(r1, r2);
        assertEquals(BigInteger.valueOf(1099), genBigInteger(r3));

    }

    @Test
    public void testEmptyListAddition() {

        //testing an empty list
        final NodeList<Integer> e1 = new NodeList<>();
        final NodeList<Integer> e2 = new NodeList<>();
        NodeList<Integer> e3 = new MyProject2().addition(e1, e2);
        assertEquals(0, e3.getLength());
        NodeList<Integer> e4 = new NodeList<>();
        for(int i = 0; i < 10;i++) {
            e4.append(i);
        }
        e3 = new MyProject2().addition(e4,e1);
        assertEquals(BigInteger.valueOf(123456789),genBigInteger(e3));


    }

    @Test
    public void testZeroAddition() {
        //testing zeros
        final NodeList<Integer> zeros = genNodeList("1000");
        final NodeList<Integer> z2 = Project2.generateNumber(30);
        final BigInteger Zeros = genBigInteger(zeros);
        final BigInteger Z2 = genBigInteger(z2);
        final NodeList<Integer> z3 = new MyProject2().addition(zeros, z2);
        final BigInteger Z3 = Zeros.add(Z2);
        assertEquals(Z3, genBigInteger(z3));

        final NodeList<Integer> zerosv2 = genNodeList("100");
        final NodeList<Integer> z2v2 = Project2.generateNumber(30);
        final BigInteger Zerosv2 = genBigInteger(zerosv2);
        final BigInteger Z2v2 = genBigInteger(z2v2);
        final NodeList<Integer> z3v2 = new MyProject2().addition(zerosv2, z2v2);
        final BigInteger Z3v2 = Zerosv2.add(Z2v2);
        assertEquals(Z3v2, genBigInteger(z3v2));

        final NodeList<Integer> zerosv3 = genNodeList("10");
        final NodeList<Integer> z2v3 = Project2.generateNumber(30);
        final BigInteger Zerosv3 = genBigInteger(zerosv3);
        final BigInteger Z2v3 = genBigInteger(z2v3);
        final NodeList<Integer> z3v3 = new MyProject2().addition(zerosv3, z2v3);
        final BigInteger Z3v3 = Zerosv3.add(Z2v3);
        assertEquals(Z3v3, genBigInteger(z3v3));

        final NodeList<Integer>  zerosv4 = genNodeList("000000000");
        final NodeList<Integer> z2v4 = Project2.generateNumber(30);
        final BigInteger Zerosv4 = genBigInteger(zerosv4);
        final BigInteger Z2v4 = genBigInteger(z2v4);
        final NodeList<Integer> z3v4 = new MyProject2().addition(zerosv4, z2v4);
        final BigInteger Z3v4 = Zerosv4.add(Z2v4);
        assertEquals(Z3v4, genBigInteger(z3v4));

        final NodeList<Integer> zerosv5 = genNodeList("00001579");
        final NodeList<Integer> z2v5 = Project2.generateNumber(30);
        final BigInteger Zerosv5 = genBigInteger(zerosv5);
        final BigInteger Z2v5 = genBigInteger(z2v5);
        final NodeList<Integer> z3v5 = new MyProject2().addition(zerosv5, z2v5);
        final BigInteger Z3v5 = Zerosv5.add(Z2v5);
        assertEquals(Z3v5, genBigInteger(z3v5));

    }



    //testing Iterator addition

    @Test
    public void testNormalAdditionIterator()
    {
        final NodeList<NodeList<Integer>> listOfLists = new NodeList<>();
        for (int i = 0; i < 3; i++) {
            listOfLists.append(genNodeList("333"));
        }
        final NodeList<Integer> addition = new MyProject2().addition(listOfLists.iterator());
        assertEquals(BigInteger.valueOf(999), genBigInteger(addition));
    }

    @Test
    public void testNullAdditionIterator()
    {
        final NodeList<NodeList<Integer>> listOfLists =  new NodeList<>();
        for(int i = 0; i < 3;i++){
            listOfLists.append(null);
        }
        final NodeList<Integer> addition = new MyProject2().addition(listOfLists.iterator());
        assertNull(addition);
    }

    @Test
    public void testRemainderAdditionIterator()
    {
        final NodeList<NodeList<Integer>> listOfLists = new NodeList<>();
        for (int i = 0; i < 3; i++) {
            listOfLists.append(genNodeList("888"));
        }
        final NodeList<Integer> addition = new MyProject2().addition(listOfLists.iterator());
        assertEquals(BigInteger.valueOf(2664), genBigInteger(addition));
    }

    @Test
    public void testZeroAdditionIterator()
    {
        final NodeList<NodeList<Integer>> listOfLists = new NodeList<>();
        for (int i = 0; i < 3; i++) {
            listOfLists.append(genNodeList("000333"));
        }
        final NodeList<Integer> addition = new MyProject2().addition(listOfLists.iterator());
        assertEquals(BigInteger.valueOf(999), genBigInteger(addition));
    }

    @Test
    public void testEmptyAdditionIterator()
    {
        final NodeList<NodeList<Integer>> listOfLists = new NodeList<>();
        for (int i = 0; i < 3; i++) {
            listOfLists.append(new NodeList<>());
        }
        NodeList<Integer> addition = new MyProject2().addition(listOfLists.iterator());
        assertEquals(0,addition.getLength());
        final NodeList<Integer> emptyListAdder = new NodeList<>();
        for(int i = 0; i < 10;i++) {
            emptyListAdder.append(i);
        }
        listOfLists.append(emptyListAdder);
        addition = new MyProject2().addition(listOfLists.iterator());
        assertEquals(BigInteger.valueOf(123456789),genBigInteger(addition));
    }


    @Test
    public void testSaveFileCreated() {
        //creating and adding nodelists
        MyProject2 p = new MyProject2();
        final NodeList<Integer> n1 = Project2.generateNumber(30);
        final NodeList<Integer> n2 = Project2.generateNumber(30);

        //ensuring that the file doesn't exist previously
        assertTrue(!file.exists());

        //ensuring that it's created after invoking the save method
        p.save(p.addition(n1, n2), fileName);
        assertTrue(file.exists());

    }

    @Test
    public void testSaveCorrectly(){
        MyProject2 p = new MyProject2();
        final NodeList<Integer> n1 = Project2.generateNumber(30);
        final NodeList<Integer> n2 = Project2.generateNumber(30);
        final NodeList<Integer> n3 = p.addition(n1, n2);
        p.save(n3, fileName);

        BigInteger N3 = genBigInteger(n3);

        assertEquals(genBigInteger(p.load(fileName)), N3);

    }

    @Test
    public void testLoad()
    {
        MyProject2 p = new MyProject2();
        final NodeList<Integer> n1 = Project2.generateNumber(30);
        final NodeList<Integer> n2 = Project2.generateNumber(30);
        final NodeList<Integer> n3 = p.addition(n1, n2);

        p.save(n3, fileName);

        assertEquals(genBigInteger(n3), genBigInteger(p.load(fileName)));

    }


}

