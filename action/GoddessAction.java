package action;

import model.Goddess;
import dao.goddessDao;

import java.sql.SQLException;
import java.util.*;

public class GoddessAction {

    public void add(Goddess goddess) throws SQLException {
        goddessDao dao=new goddessDao();
        dao.addGoddess(goddess);
    }
    public void edit(Goddess goddess) throws SQLException {
            goddessDao dao=new goddessDao();
            dao.updateGoddess(goddess);
    }
    public void del(Integer id) throws SQLException {
        goddessDao dao=new goddessDao();
        dao.deleteGoddess(id);
    }
    public List<Goddess> query() throws SQLException {
        goddessDao dao=new goddessDao();
        return dao.query();
    }
   public List<Goddess> query(List<Map<String,Object>> params) throws SQLException {
        goddessDao dao=new goddessDao();
        return dao.query(params);
    }

    public Goddess get(Integer id) throws SQLException {
        goddessDao dao=new goddessDao();
        return dao.get(id);
    }
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

      /* List<Map<String,Object>> params=new ArrayList<>();
        Map<String,Object> param=new HashMap<>();
        param.put("name","user_name");
        param.put("rela","=");
        param.put("value","'小溪'");
        params.add(param);
       List<Goddess> list=gDao.query(params);
       for(Goddess godd:list)
           System.out.println(godd.toString());*/
      GoddessAction action=new GoddessAction();
//      List<Goddess> list=action.query();
//        for(Goddess godd:list)
//            System.out.println(godd.toString());

//        g1.setUser_name("最美");
//        g1.setAge(22);
//        g1.setSex(1);
//        g1.setBirthday(new Date());
//        g1.setEmail("最美@163.com");
//        g1.setMobile("17621662866");
//        g1.setCreater_user("ADMIN");
//        g1.setUpdate_user("ADMIN");
//        g1.setIsdel(1);
//
//        action.add(g1);
//        action.del(3);

    }

   /* public static void main(String[] args){


    }*/

}
