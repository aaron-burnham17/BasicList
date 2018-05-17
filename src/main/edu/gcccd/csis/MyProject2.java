package edu.gcccd.csis;

import java.io.*;
import java.util.Iterator;

public class MyProject2 implements Project2 {

    @Override
    public NodeList<Integer> addition(NodeList<Integer> nodeList1, NodeList<Integer> nodeList2) {

        //null case
        if(nodeList1 == null || nodeList2 == null){
            return nodeList1 == null ? nodeList2 : nodeList1;
        }

        NodeList<Integer> Total = new NodeList<>();
        NodeList<Integer> Remainder = new NodeList<>();
        boolean noRemainder = true;

        //nodelist1 > nodelist2 case
        while(nodeList1.getLength() > nodeList2.getLength()){
            Total.append(nodeList1.iterator().next());
            nodeList1.remove(nodeList1.iterator().next());
            Remainder.append(0);
        }

        //nodelist2 > nodeList1 case
        while(nodeList2.getLength() > nodeList1.getLength()){
            Total.append(nodeList2.iterator().next());
            nodeList2.remove(nodeList2.iterator().next());
            Remainder.append(0);
        }

        //Stores sums that are >= 10 into a remainder nodelist in order to add it through the next recursive call of addition
        while (nodeList1.iterator().hasNext() && nodeList2.iterator().hasNext()) {
            Total.append((nodeList1.iterator().next() + nodeList2.iterator().next()) % 10);
            Remainder.append((nodeList1.iterator().next() + nodeList2.iterator().next()) / 10);
            noRemainder = nodeList1.iterator().next() + nodeList2.iterator().next() >= 10 ? false : noRemainder;
            nodeList1.remove(nodeList1.iterator().next());
            nodeList2.remove(nodeList2.iterator().next());
        }

        Remainder.append(0);

        //Removes unnecessary zeros
        while (Total.iterator().hasNext() && Total.iterator().next() == 0) {
            Total.remove(0);
        }
        //Recursive Call to addition to add the remaining remainder values
        return noRemainder ? Total : addition(Total,Remainder);
    }

    @Override
    public NodeList<Integer> addition(Iterator<NodeList<Integer>> iterator) {
        //Priming call to iterator.next() to make sure recursive call functions correctly.
        NodeList<Integer> addOperand = iterator.next();
        return iterator.hasNext() ? addition(addOperand,addition(iterator)) : addOperand;
    }

    @Override
    public void save(NodeList<Integer> nodeList, String fileName) {
        try
        {
            BufferedWriter fw = new BufferedWriter(new FileWriter(fileName,true));
            for (final Integer i : nodeList) {
                fw.write(i.toString());
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

        NodeList<Integer> list = new NodeList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            int c;
            while( (c = br.read()) != -1){
                if (c >= 48 && c <=57) {
                    list.append( (c-48) );
                }
            }
            br.close();
            return list;
        }
        catch(IOException io){
            System.err.println("IOException");
            return list;
        }
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


