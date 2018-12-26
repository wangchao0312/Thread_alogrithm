package I_O;

import java.io.*;

public class InputStreamReader_demo {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr=new InputStreamReader(new FileInputStream("E:\\alogrithm\\日记1.txt"));

        /*int c;
        while((c=isr.read())!=-1)
            System.out.print((char) c);*/
        int c;
        char[] buffer=new char[8*1024];
        String s="";
        c=isr.read(buffer,0,buffer.length);

             s=new String(buffer,0,c);
        System.out.println(s);

        isr.close();

    }

}
