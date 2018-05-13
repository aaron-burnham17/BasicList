package edu.gcccd.csis;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Iterator;


import static org.junit.Assert.*;


public class NodeTest {

    @Before
    public void setUp()
    {

    }

    @Test
   public void testAdditionNodeList(){

        //testing normal addition
        final NodeList<Integer> n1 = Project2.generateNumber(30);
        final NodeList<Integer> n2 = Project2.generateNumber(30);

        final BigInteger N1 = genBigInteger(n1);
        final BigInteger N2 = genBigInteger(n2);
        final NodeList<Integer> n3 = new MyProject2().addition(n1, n2);
        final BigInteger N3 = N1.add(N2);

          assertEquals(N3, genBigInteger(n3));

          //testing an empty list
        final NodeList<Integer> e1 = new NodeList<>();
        final NodeList<Integer> e2 = new NodeList<>();
        final NodeList<Integer> e3 = new MyProject2().addition(e1, e2);
        assertEquals(0, e3.getLength());




        //testing zeros


//        //testing that it can add numbers of different digits correctly
//        final NodeList<Integer> d1 = Project2.generateNumber(30);
//        final NodeList<Integer> d2 = Project2.generateNumber(30);
//
//        final BigInteger D1 = genBigInteger(n1);
//        final BigInteger D2 = genBigInteger(n2);
//        final NodeList<Integer> d3 = new MyProject2().addition(d1, d2);
//        final BigInteger D3 = D1.add(D2);
//        assertEquals(D3, d3);



        }

//        @Test
//        public void testAdditionIterator()
//                {
////                    final NodeList<NodeList<Integer>> listOfLists = new NodeList<>();
////                    for (int i = 0; i < 5; i++) {
////                        listOfLists.append(Project2.generateNumber(5));
//
//                    final NodeList<NodeList<Integer>> listOfLists = new NodeList<>();
//                    for (int i = 0; i<5; i++) {
//                       listOfLists.append(Project2.generateNumber(5));
//                        final BigInteger T = genBigInteger();
//                    }
//
//                    final NodeList<Integer> t = new MyProject2().addition(listOfLists.iterator());
//
//
////            final NodeList<Integer> t1 = Project2.generateNumber(30);
////            final NodeList<Integer> t2 = Project2.generateNumber(30);
//
//
//                final BigInteger T1 = genBigInteger(t1);
//                final BigInteger T2 = genBigInteger(t2);
//
//                final BigInteger T = T1.add(T2);
//
//
//                assertEquals(T, genBigInteger(t));
//        }



        private static BigInteger genBigInteger(final NodeList<Integer> nodeList) {
        final StringBuilder sb = new StringBuilder();
        for (final int i : nodeList) {
            sb.append(i);
        }
        return new BigInteger(sb.toString());
    }

    @Test
    public void testSave()
    {
        final NodeList<Integer> n1 = Project2.generateNumber(30);
        final NodeList<Integer> n2 = Project2.generateNumber(30);


        //p.save(p.addition(listOfLists.iterator()), "result.bin");
        //Project2.print(p.load("result.bin"));
    }

//    NodeList<Student> studentList;
//    private Student s;
//    private Student t;
//    private Student u;
//
//    @Before
//    public void setup() {
//        s = new Student(123, "Jane Smith", "js@gcccd.edu");
//        t = new Student(124, "John Doe", "jd@gcccd.edu");
//        u = new Student(125, "Jim Cook", "jc@gcccd.edu");
//    }
//
//    @Test
//    public void testAppend() {
//        studentList = new NodeList<>();
//
//        assertTrue(0 == studentList.getLength());
//        assertFalse(studentList.contains(s));
//
//        studentList.append(s);
//
//        assertTrue(1 == studentList.getLength());
//
//        studentList.append(t);
//
//        assertTrue(2 == studentList.getLength());
//        assertTrue(studentList.contains(s));
//        assertTrue(studentList.contains(t));
//    }
//
//
//    @Test
//    public void testRemove() {
//        studentList = new NodeList<>();
//        studentList.append(s);
//        studentList.append(t);
//        studentList.append(u);
//        studentList.remove(s); // remove 1st item
//
//        assertTrue(2 == studentList.getLength());
//        assertFalse(studentList.contains(s));
//        assertTrue(studentList.contains(t));
//        assertTrue(studentList.contains(u));
//
//        studentList.append(s);
//        studentList.remove(u); // remove middle item
//
//        assertTrue(2 == studentList.getLength());
//        assertFalse(studentList.contains(u));
//
//        studentList.remove(t); // remove last item
//
//        assertTrue(1 == studentList.getLength());
//        assertFalse(studentList.contains(t));
//
//        studentList.remove(s);
//
//        assertTrue(0 == studentList.getLength());
//    }
//
//    @Test
//    public void printAll() {
//        studentList = new NodeList<>();
//        studentList.append(s);
//        studentList.append(t);
//        studentList.append(u);
//        final Iterator<Student> iter = studentList.iterator();
//        while (iter.hasNext()) {
//            System.out.println(iter.next());
//        }
//    }
}