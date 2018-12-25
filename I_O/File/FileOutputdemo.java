package I_O.File;

import java.io.*;

public class FileOutputdemo {

    public static void copy(File fileFrom,File fileTo) throws IOException {
        byte[] bytes=new byte[8*1024];
        FileOutputStream fileto=new FileOutputStream(fileTo);
        FileInputStream filefrom=new FileInputStream(fileFrom);
        int b;
        while((b=filefrom.read(bytes,0,bytes.length))!=-1)
            fileto.write(bytes,0,b);

        fileto.close();
        filefrom.close();
    }


    public static void main(String[] args) throws IOException {
        //
        /*FileOutputStream out=new FileOutputStream("E:\\alogrithm\\日记1.txt");
        out.write('A');
        out.write('B');
        int A=10;
        out.write(A>>>24);
        out.write(A>>>16);
        out.write(A>>>8);
        out.write(A);//只写了A的最低八位
        byte[] bytes="abcde".getBytes();
        out.write(bytes);
        out.close();

        IOUtil.printHexByByteArray("E:\\alogrithm\\日记1.txt");*/
        File from=new File("E:\\alogrithm\\日记1.txt");
        File to=new File("E:\\alogrithm\\日记2.txt");
        copy(from,to);
    }
}
