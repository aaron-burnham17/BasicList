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
   public void testAddition(){

        //testing addition(NodeList1, NodeList2)
        final NodeList<Integer> n1 = Project2.generateNumber(30);
        final NodeList<Integer> n2 = Project2.generateNumber(30);

        final BigInteger N1 = genBigInteger(n1);
        final BigInteger N2 = genBigInteger(n2);
        final NodeList<Integer> n3 = new MyProject2().addition(n1, n2);
        final BigInteger N3 = N1.add(N2);

          assertEquals(N3, genBigInteger(n3));

        //testing addition(Iterator)
        final NodeList<Integer> t1 = Project2.generateNumber(30);
        final NodeList<Integer> t2 = Project2.generateNumber(30);


        final BigInteger T1 = genBigInteger(t1);
        final BigInteger T2 = genBigInteger(t2);
        final NodeList<Integer> t = new MyProject2().addition(t1, t2);
        final BigInteger T = T1.add(T2);


        assertEquals(T, genBigInteger(t));
    }



        private static BigInteger genBigInteger(final NodeList<Integer> nodeList) {
        final StringBuilder sb = new StringBuilder();
        for (final int i : nodeList) {
            sb.append(i);
        }
        return new BigInteger(sb.toString());
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