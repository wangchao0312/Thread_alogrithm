package I_O;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Filereader {
    public static void main(String[] args) throws IOException {
        FileReader file=new FileReader("E:\\alogrithm\\日记1.txt");
        FileWriter to=new FileWriter("E:\\alogrithm\\日记2.txt",true);//true为追加，false删除新建

        char[] buffer=new char[2056];
        int c;
        while((c=file.read(buffer,0,buffer.length))!=-1)
        {
            to.write(buffer,0,c);
        }
        //to.flush();
        to.close();
        file.close();
    }
}
