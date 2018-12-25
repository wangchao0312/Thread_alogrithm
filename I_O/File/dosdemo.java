package I_O.File;

import java.io.*;

public class dosdemo {
    public static void main(String[] args) throws IOException {
       String encoding = "UTF-8";//设置文件的编码！！
       String file="E:\\alogrithm\\日记1.txt";

        DataOutputStream dos=new DataOutputStream(new FileOutputStream(file));

        dos.writeInt(10);
        dos.writeInt(10);
        dos.writeLong(-10l);
        dos.writeDouble(12.3);
        dos.writeUTF("王超");



        /*FileOutputStream fos = new FileOutputStream("E:\\alogrithm\\日记1.txt");
        DataOutputStream dos = new DataOutputStream(fos);
        dos.writeUTF("10");
        dos.close();

        FileInputStream fis = new FileInputStream("E:\\alogrithm\\日记1.txt");
        DataInputStream dis = new DataInputStream(fis);
        String s = (String)dis.readUTF();
        dis.close();

        System.out.println(s);
*/

        DataInputStream input=new DataInputStream(new FileInputStream(file));
        int i= input.readInt();
        int j=input.readInt();
        long f=input.readLong();
        double a=input.readDouble();
        System.out.println(i);
        System.out.println(j);
        System.out.println(f);
        System.out.println(a);
        System.out.println(input.readUTF());
        input.close();
        dos.close();
    }
}
