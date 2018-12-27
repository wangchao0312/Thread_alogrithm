package view;

import action.GoddessAction;
import model.Goddess;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
            "B返回主菜单";
    private static final String OPERATION_MAIN="MAIN";
    private static final String OPERATION_QUERY="QUERY";
    private static final String OPERATION_GET="GET";
    private static final String OPERATION_ADD="ADD";
    private static final String OPERATION_UPDATE="UPDATE";
    private static final String OPERATION_DELETE="DELETE";
    private static final String OPERATION_SEARCH="SEARCH";
    private static final String OPERATION_EXIT="EXIT";
    private static final String OPERATION_BREAK="BREAK";

    public static void main(String[] args) throws SQLException {

        System.out.println(CONTEXT);
        //保持一直运行程序
        Scanner scan=new Scanner(System.in);
        Goddess goddess=new Goddess();
        GoddessAction action=new GoddessAction();
        String pre=null;
        Integer step=1;
        while(scan.hasNext())
        {
            String in=scan.next().toString();
            if(in.toUpperCase().equals(OPERATION_EXIT)||OPERATION_EXIT.substring(0,1).equals(in.toUpperCase()))
            {
                System.out.println("退出系统");
                break;
            }
            else  if(in.toUpperCase().equals(OPERATION_QUERY)||OPERATION_QUERY.substring(0,1).equals(in.toUpperCase()))
            {
                List<Goddess> list=action.query();
                for(Goddess god:list)
                    System.out.println(god.toString());
            }
            else if(in.toUpperCase().equals(OPERATION_ADD)||OPERATION_ADD.substring(0,1).equals(in.toUpperCase())||OPERATION_ADD.equals(pre))
            {
                pre=OPERATION_ADD;
                if(step==1) {
                    System.out.println("请输入姓名");
                }
                else if(step==2)
                {
                    goddess.setUser_name(in);
                    System.out.println("请输入年龄");
                }
                else if(step==3)
                {
                    goddess.setAge(Integer.valueOf(in));
                    System.out.println("请输入生日 yyyy-mm-dd");
                }
                else if(step==4)
                {
                    SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
                    Date birthday=null;
                    try{
                        birthday=sf.parse(in);
                        goddess.setBirthday(birthday);
                        System.out.println("请输入email");
                    } catch (ParseException e) {
                        e.printStackTrace();
                        step=3;
                        System.out.println("生日请重新输入");
                    }
                }
                else if(step==5)
                {
                    goddess.setEmail(in);
                    System.out.println("请输入电话");
                }
                else if(step==6)
                {
                    goddess.setMobile(in);
                    try{
                        action.add(goddess);
                        System.out.println("添加成功");
                    } catch (SQLException e) {
                        e.printStackTrace();
                        System.out.println("添加失败");
                    }
                }
                if(OPERATION_ADD.equals(pre))
                    step++;
            }
            else {
                System.out.println("您输入的值为：" + in);
            }
        }
    }

}

