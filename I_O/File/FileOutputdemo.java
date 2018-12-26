package I_O.File;

import java.io.*;

public class FileOutputdemo {

    /**
     * 字节数组拷贝文件
     * @param fileFrom
     * @param fileTo
     * @throws IOException
     */
    public static void copyArray(File fileFrom,File fileTo) throws IOException {
        byte[] bytes=new byte[8*1024];
        FileOutputStream fileto=new FileOutputStream(fileTo);
        FileInputStream filefrom=new FileInputStream(fileFrom);
        int b;
        while((b=filefrom.read(bytes,0,bytes.length))!=-1)
            fileto.write(bytes,0,b);

        fileto.close();
        filefrom.close();
    }

    /**
     * 缓冲区拷贝文件
     * @param from
     * @param to
     * @throws IOException
     */
    public static void copyBuffer(File from,File to) throws IOException {
        BufferedInputStream in=new BufferedInputStream(new FileInputStream(from));
        BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream(to));
        int c;
        while(( c=in.read())!=-1)
            out.write(c);

        out.flush();

        in.close();
        out.close();
    }

    /**
     * 单字节不带缓冲拷贝文件
     * @param from
     * @param to
     * @throws IOException
     */
    public static void copyByte(File from,File to)throws IOException{
        FileInputStream in=new FileInputStream(from);
        FileOutputStream out=new FileOutputStream(to);
        int c;
        while((c=in.read())!=-1)
            out.write(c);
        in.close();;
        out.close();
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
        long start=System.currentTimeMillis();

        File from=new File("E:\\alogrithm\\1.pdf");
        File to=new File("E:\\alogrithm\\2.pdf");
        copyBuffer(from,to);
        long end=System.currentTimeMillis();
        System.out.println(end-start);

    }
}
