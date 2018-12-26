package view;

import java.sql.SQLOutput;
import java.util.Scanner;

public class View {
    private static final String CONTEXT="" +
            "M:主菜单\n" +
            "Q查看所有人信息\n" +
            "G查看某人全部信息\n" +
            "A添加信息\n" +
            "U更新信息\n" +
            "D删除信息\n"+
            "S查询信息（根据姓名手机号查询）\n"+
            "E退出系统\n"+
            "B返回主菜单\n";
    private static final String OPERATION_MAIN="MAIN";
    private static final String OPERATION_QUERY="QUERY";
    private static final String OPERATION_GET="GET";
    private static final String OPERATION_ADD="ADD";
    private static final String OPERATION_UPDATE="UPDATE";
    private static final String OPERATION_DELETE="DELETE";
    private static final String OPERATION_SEARCH="SEARCH";
    private static final String OPERATION_EXIT="EXIT";
    private static final String OPERATION_BREAK="BREAK";

    public static void main(String[] args) {

        System.out.println(CONTEXT);
        //保持一直运行程序
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext())
        {
            String in=scan.next().toString();
            if(in.toUpperCase().equals(OPERATION_EXIT)||OPERATION_EXIT.substring(0,1).equals(in.toUpperCase()))
            {
                System.out.println("退出系统");
                break;
            }
            System.out.println("您输入的值为："+in.toString());




        }
    }

}

