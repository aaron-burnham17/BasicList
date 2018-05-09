package edu.gcccd.csis;

import java.io.*;
import java.util.Iterator;

public class MyProject2 implements Project2 {

    @Override
    public NodeList<Integer> addition(NodeList<Integer> nodeList1, NodeList<Integer> nodeList2) {
        do {


            while (nodeList1.iterator().next() + nodeList2.iterator().next() >= 9) {

            }
        }while(true);
    }

    @Override
    public NodeList<Integer> addition(Iterator<NodeList<Integer>> iterator) {
        if(iterator.hasNext()){
            return addition(iterator.next(),addition(iterator));
        }
        else{
            return iterator.next();
        }

    }

    @Override
    public void save(NodeList<Integer> nodeList, String fileName) {
        try
        {
            BufferedWriter fw = new BufferedWriter(new FileWriter(fileName,true));
            for (final Integer i : nodeList) {
                fw.write(i);
            }
            fw.newLine();
            fw.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException");
        }
    }

    @Override
    public NodeList<Integer> load(String fileName) {
        NodeList list = new NodeList();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String c = "";

        try {
            while ((c = br.read()) != null) {
                int i = Integer.parseInt(c);
                list.append(i);
            }

            br.close();
        }
        catch(IOException io){

        }

        return list;

    }


    public static void main(final String[] args) {
        final int L = 30;

        final NodeList<Integer> n1 = Project2.generateNumber(L); // (head 1st) e.g. 3457
        final NodeList<Integer> n2 = Project2.generateNumber(L); // (head 1st) e.g. 682

        final Project2 p = new MyProject2();

        Project2.print(p.addition(n1, n2)); //  n1+n2, e.g. 4139

        final NodeList<NodeList<Integer>> listOfLists = new NodeList<>();
        for (int i = 0; i < L; i++) {
            listOfLists.append(Project2.generateNumber(L));
        }
        p.save(p.addition(listOfLists.iterator()), "result.bin");
        Project2.print(p.load("result.bin"));
    }
}
