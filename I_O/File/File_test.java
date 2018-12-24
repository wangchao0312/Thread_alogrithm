package I_O.File;
import java.io.File;
import java.io.IOException;

public class File_test {
    public static void main(String[] args) throws IOException {
        File file=new File("E:\\alogrithm\\src\\I_O");
        System.out.println(file.isFile());
        File file1=new File("E:\\alogrithm\\src\\I_O\\File","日记1.txt");
        file1.createNewFile();
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getName());
    }
}
