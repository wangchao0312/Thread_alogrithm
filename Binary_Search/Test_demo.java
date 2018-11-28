package Binary_Search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Test_demo {


    public static void main(String[] args){
        Student student1 = new Student(3, "wang");
        Student student2 = new Student(1, "efg");
        Student student3 = new Student(2, "abc");
         List<Student> arraylist=new ArrayList<Student>();
         arraylist.add(student1);
        arraylist.add(student2);
        arraylist.add(student3);
        Iterator iterator=arraylist.iterator();
        while(iterator.hasNext())
        {
            Student temp=(Student)iterator.next();
            System.out.println(temp.name);
        }
        Collections.sort(arraylist);
        iterator=arraylist.iterator();

        while(iterator.hasNext())
        {
            Student temp=(Student)iterator.next();
            System.out.println(temp.name);
        }
    }
}
