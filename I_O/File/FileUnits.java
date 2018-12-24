package I_O.File;
import java.io.File;
import java.io.IOException;

// 列出File下一些常用的操作 过滤、遍历等

public class FileUnits {
    /**
     *遍历当前目录下所有子目录与文件
     * @param dir 目录所在位置
     * @throws IOException
     */
    public static void listDirectory(File dir)throws IOException{
        if(!dir.exists())
            throw new IllegalArgumentException("目录不存在！！");
        if(!dir.isDirectory())
            throw new IllegalArgumentException("不是个目录！！");

       /* String [] filenames=dir.list();//返回当前目录下所有文件夹和文件，不包括子目录
        for(String temp:filenames)
            System.out.println(dir+"\\"+temp);
*/
        File[] files=dir.listFiles();//返回当前目录下所有文件夹和文件，不包括子目录

        if(files.length>0)
        {
            for(File file:files){
                if(file.isDirectory())
                    listDirectory(file);
                else
                    System.out.println(file);
            }
        }
    }
    public static void main(String[] args)throws IOException{


        listDirectory(new File("E:\\360downloads"));
    }

}
