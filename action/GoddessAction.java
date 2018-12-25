package action;

import model.Goddess;
import dao.goddessDao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class GoddessAction {

    /*public static  void main(String[] args) throws SQLException {
        goddessDao g=new goddessDao();
        List<Goddess> list =g.query();
        for(Goddess godd:list)
            System.out.println(godd.getUser_name()+": age:"+godd.getAge());
    }*/
    /*public static void main(String[] args) throws SQLException {
        Goddess g1=new Goddess();
        goddessDao gDao=new goddessDao();
        g1.setUser_name("小夏");
        g1.setAge(22);
        g1.setSex(1);
        g1.setBirthday(new Date());
        g1.setEmail("xiaoxia@163.com");
        g1.setMobile("17621662866");
        g1.setCreater_user("ADMIN");
        g1.setUpdate_user("ADMIN");
        g1.setIsdel(1);

        gDao.addGoddess(g1);
    }*/
    public static void main(String[] args) throws SQLException {
        Goddess g1=new Goddess();
        goddessDao gDao=new goddessDao();
       /* g1.setUser_name("小夏");
        g1.setAge(21);
        g1.setSex(1);
        g1.setBirthday(new Date());
        g1.setEmail("xiaoxiaxin@163.com");
        g1.setMobile("17621660000");

        g1.setId(3);
        g1.setUpdate_user("WANGCHAO");
        g1.setIsdel(1);

        gDao.updateGoddess(g1);
        gDao.deleteGoddess(3);*/


       g1=gDao.get(1);
       System.out.println(g1.toString());
    }

   /* public static void main(String[] args){


    }*/

}
