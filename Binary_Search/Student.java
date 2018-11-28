package Binary_Search;

public class Student implements Comparable<Student> {

    public  int ID;
    public String name;

    public Student(int ID,String name){
        this.ID=ID;
        this.name=name;
    }


    @Override
    public int compareTo(Student student){
        if(ID==student.ID)
            return 0;
        if(ID>student.ID)
            return 1;
        else
            return -1;
    }
}
