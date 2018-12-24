package I_O.File;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class RandomAccessFIle {
    public static void main(String[] args)throws IOException{
        File demo=new File("demo");
        if(!demo.exists())
            demo.mkdir();

        File file=new File(demo,"raf.dat");
        if(!file.exists())
            file.createNewFile();

        RandomAccessFile raf=new RandomAccessFile(file,"rw");
        System.out.println(raf.getFilePointer());

        raf.write('A');//只写了一个字节 写的是后八位 一个char俩个字节
        System.out.println(raf.getFilePointer());
        raf.write('B');

        int i=0x7fffffff;
         raf.write(i>>>24);
        raf.write(i>>>16);
        raf.write(i>>>8);
        raf.write(i);
        System.out.println(raf.getFilePointer());

        raf.writeInt(i);
        String s="中";
        byte[] gbk=s.getBytes("gbk");
        raf.write(gbk);
        System.out.println(raf.getFilePointer());

        System.out.println(raf.length());

        raf.seek(0);

        //一次性读取
        byte[] buf=new byte[(int)raf.length()];
        raf.read(buf);
        System.out.println(Arrays.toString(buf));
        String s1=new String(buf);
        System.out.println(s1);
        raf.close();
    }
}
