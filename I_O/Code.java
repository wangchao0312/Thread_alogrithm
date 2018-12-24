package I_O;

import java.io.UnsupportedEncodingException;

public class Code {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s="慕课ABC";
    /*    byte[] bytes=s.getBytes();
        for(byte b:bytes)
            System.out.println(Integer.toHexString(b&0xff));
        //GBK编码中文占用俩个字节，英文占用一个字节
        //utf-8汉语占用2个字节
        byte[] bytes2=s.getBytes("gbk");
        for(byte b:bytes2)
            System.out.println(Integer.toHexString(b&0xff));*/
        byte[] bytes4=s.getBytes("utf-16be");
        for(byte b:bytes4)
            System.out.println(Integer.toHexString(b&0xff));

        String str1=new String(bytes4,"utf-16be");
        System.out.println(str1);

    }
}
