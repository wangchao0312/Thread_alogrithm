package I_O.File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;



public class IOUtil {
    /**
     * 读取指定文件内容 按照16进制输出
     * 没10个字节换行
     * @param fileName
     */
    public static void printHex(String fileName) throws IOException {
        //把文件作为字节流进行读操作
        FileInputStream in=new FileInputStream(fileName);
        int b;
        int i=1;
        while((b=in.read())!=-1){
            if(b<0xf)
                System.out.print(0);
            System.out.print(Integer.toHexString(b)+"  ");
        if(i++%10==0)
            System.out.println("");}
        in.close();
    }

    public static void printHexByByteArray(String fileName) throws IOException {
        FileInputStream in=new FileInputStream(fileName);
        byte[] buf=new byte[20*1024];
        //从第零个位置开始存字节，将成功的独到的字节数返回
        int bytes=in.read(buf,0,buf.length-1);//一次性读完 字节数组需要足够大
        int j=1;
        for(int i=0;i<bytes;i++)
        {
            System.out.print(Integer.toHexString(buf[i])+" ");
            if(j++%10==0)
                System.out.println();

        }




    }
    public static void main(String[] args) throws IOException {
        printHexByByteArray("E:\\alogrithm\\日记1.txt");
    }

}
