package edu.gcccd.csis;

import java.io.*;
import java.util.Iterator;

public class MyProject2 implements Project2 {

    @Override
    public NodeList<Integer> addition(NodeList<Integer> nodeList1, NodeList<Integer> nodeList2) {
        NodeList<Integer> Total = new NodeList<Integer>();
        NodeList<Integer> Remainder = new NodeList<Integer>();
        boolean noRemainder = true;
        int append = 0;
        do {
            if(nodeList1.getLength() > nodeList2.getLength()){
                Total.append(nodeList1.iterator().next());
                nodeList1.remove(nodeList1.iterator().next());
                Remainder.append(0);

            }
            else if(nodeList2.getLength() > nodeList1.getLength()){
                Total.append(nodeList2.iterator().next());
                nodeList2.remove(nodeList2.iterator().next());
                Remainder.append(0);

            }

            if(nodeList1.getLength() == nodeList2.getLength()){
                append = nodeList1.iterator().next() + nodeList2.iterator().next();
                nodeList1.remove(nodeList1.iterator().next());
                nodeList2.remove(nodeList2.iterator().next());
                if(append >= 10){
                    append %= 10;
                    Remainder.append(1);
                    noRemainder = false;
                }
                else{
                    Remainder.append(0);
                }
                Total.append(append);
            }


        }while(nodeList1.iterator().hasNext() && nodeList2.iterator().hasNext());
        Remainder.append(0);
        if (noRemainder){
            while(Total.iterator().next() == 0){
                Total.remove(0);
            }
            return Total;
        }
        else{
            return addition(Total,Remainder);
        }
    }

    @Override
    public NodeList<Integer> addition(Iterator<NodeList<Integer>> iterator) {
        NodeList<Integer> addOperand = iterator.next();
        if(iterator.hasNext()){
            return addition(addOperand,addition(iterator));
        }
        else{
            return addOperand;
        }
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

        NodeList list = new NodeList();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            int c = 0;
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
        for (int i = 0; i < 5; i++) {
            listOfLists.append(Project2.generateNumber(5));
        }
        Project2.print(p.addition(listOfLists.iterator()));
        //p.save(p.addition(listOfLists.iterator()), "result.bin");
        //Project2.print(p.load("result.bin"));


        //Iterator<NodeList<Integer>> listAdditive = listOfLists;
//        p.save(p.addition(listOfLists.iterator()), "result.bin");
//        Project2.print(p.load("result.bin"));

    }
}


