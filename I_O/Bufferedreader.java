package I_O;

import java.io.*;

public class Bufferedreader {
    public static void main(String[] args) throws IOException {

       /* BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("E:\\alogrithm\\日记1.txt")));
        String line;
        while((line=br.readLine())!=null)
            System.out.print(line);//一次读一行 并不能识别换行，不识别换行符


        br.close();*/
       //搭配使用
        BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("E:\\alogrithm\\日记1.txt")));
        PrintWriter pw=new PrintWriter(new FileOutputStream("E:\\alogrithm\\日记2.txt"),true);
        String line;
        while((line=br.readLine())!=null)
        {
            System.out.print(line);//一次读一行 并不能识别换行，不识别换行符
            pw.print(line);
            pw.flush();
        }
        pw.close();
        br.close();
    }

}
