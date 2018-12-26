package dao;

import JDBC.jdbc_connection;
import model.Goddess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class goddessDao {
    public void addGoddess(Goddess g) throws SQLException {
        Connection conn = jdbc_connection.getConnection();
        String sql=""+
                "INSERT INTO imooc_goddess"+
                "(user_name,sex,age,birthday,email,mobile,create_user,create_date,"+
                "update_user,update_date,isdel)"+
                "VALUES(?,?,?,?,?,?,?,current_date(),?,current_date(),?);";
        PreparedStatement ptmt=conn.prepareStatement(sql);
        ptmt.setString(1,g.getUser_name());
        ptmt.setInt(2,g.getSex());
        ptmt.setInt(3,g.getAge());
        ptmt.setDate(4,new Date(g.getBirthday().getTime()));
        ptmt.setString(5,g.getEmail());
        ptmt.setString(6,g.getMobile());
        ptmt.setString(7,g.getCreater_user());
        ptmt.setString(8,g.getUpdate_user());
        ptmt.setInt(9,g.getIsdel());

        ptmt.execute();
    }
    public void updateGoddess(Goddess g) throws SQLException {
        Connection conn = jdbc_connection.getConnection();
        String sql="UPDATE  imooc_goddess"+
                " SET user_name=?,sex=?,age=?,birthday=?,email=?,mobile=?, "+
                " update_user=?,update_date=current_date(),isdel=? "+
                " WHERE id=? ";

        PreparedStatement ptmt=conn.prepareStatement(sql);
        ptmt.setString(1,g.getUser_name());
        ptmt.setInt(2,g.getSex());
        ptmt.setInt(3,g.getAge());
        ptmt.setDate(4,new Date(g.getBirthday().getTime()));
        ptmt.setString(5,g.getEmail());
        ptmt.setString(6,g.getMobile());
        ptmt.setString(7,g.getUpdate_user());
        ptmt.setInt(8,g.getIsdel());
        ptmt.setInt(9,g.getId());
        ptmt.execute();

    }
    public void deleteGoddess(Integer id) throws SQLException {
        Connection conn = jdbc_connection.getConnection();
        String sql= "DELETE FROM imooc_goddess"+ "  WHERE id=?;";

        PreparedStatement ptmt=conn.prepareStatement(sql);
        ptmt.setInt(1, id);

        ptmt.execute();

    }
    public List<Goddess> query() throws SQLException {
        Connection conn = jdbc_connection.getConnection();
        PreparedStatement stmt = conn.prepareStatement("select id,user_name,age from imooc_goddess");
        ResultSet re = stmt.executeQuery();

        List<Goddess> list=new ArrayList<>();
        Goddess g=null;
        while (re.next()) {
            g=new Goddess();
            g.setId(re.getInt(1));
            g.setUser_name(re.getString("user_name"));
            g.setAge(re.getInt(3));
            list.add(g);
        }
        return list;
    }
    public List<Goddess> query(String name,String mobile,String email) throws SQLException {
        Connection conn = jdbc_connection.getConnection();
        PreparedStatement stmt = conn.prepareStatement("select * from imooc_goddess where user_name like ? and mobile like ? and email like ?");
        stmt.setString(1,"%"+name+"%");
        stmt.setString(2,"%"+mobile+"%");
        stmt.setString(3,"%"+email+"%");
        ResultSet rs = stmt.executeQuery();



        List<Goddess> list=new ArrayList<>();
        Goddess g=null;
        while (rs.next()) {
            g=new Goddess();
            g.setId(rs.getInt(1));
            g.setUser_name(rs.getString(2));
            g.setSex(rs.getInt(3));
            g.setAge(rs.getInt(4));
            g.setBirthday(rs.getDate(5));
            g.setEmail(rs.getString(6));
            g.setMobile(rs.getString(7));
            g.setCreater_user(rs.getString(8));
            g.setCreate_date(rs.getDate(9));
            g.setUpdate_user(rs.getString(10));
            g.setUpdate_date(rs.getDate(11));
            g.setIsdel(rs.getInt(12));
            list.add(g);
        }
        return list;
    }
    public List<Goddess> query(List<Map<String ,Object>> params) throws SQLException {
        Connection conn = jdbc_connection.getConnection();
        StringBuilder str=new StringBuilder("select * from imooc_goddess where 1=1 ");
        if(params.size()>0&&params!=null){
            for(Map<String,Object> map:params)
                {
                    str.append(" and "+map.get("name")+" "+map.get("rela")+" "+map.get("value")+" ");
                }
        }
        System.out.println(str.toString());
        PreparedStatement stmt = conn.prepareStatement(str.toString());
        ResultSet rs = stmt.executeQuery();

        List<Goddess> result=new ArrayList<>();
        Goddess g=null;
        while (rs.next()) {
            g=new Goddess();
            g.setId(rs.getInt(1));
            g.setUser_name(rs.getString(2));
            g.setSex(rs.getInt(3));
            g.setAge(rs.getInt(4));
            g.setBirthday(rs.getDate(5));
            g.setEmail(rs.getString(6));
            g.setMobile(rs.getString(7));
            g.setCreater_user(rs.getString(8));
            g.setCreate_date(rs.getDate(9));
            g.setUpdate_user(rs.getString(10));
            g.setUpdate_date(rs.getDate(11));
            g.setIsdel(rs.getInt(12));
            result.add(g);
        }
        return result;
    }
    public Goddess get(Integer id) throws SQLException {
        Goddess g=null;
        Connection conn = jdbc_connection.getConnection();
        String sql="SELECT * FROM imooc_goddess"+"  WHERE id=?;";

        PreparedStatement ptmt=conn.prepareStatement(sql);
        ptmt.setInt(1,id);

        ResultSet rs=ptmt.executeQuery();
        while(rs.next())
        {
            g=new Goddess();
            g.setId(rs.getInt(1));
            g.setUser_name(rs.getString(2));
            g.setSex(rs.getInt(3));
            g.setAge(rs.getInt(4));
            g.setBirthday(rs.getDate(5));
            g.setEmail(rs.getString(6));
            g.setMobile(rs.getString(7));
            g.setCreater_user(rs.getString(8));
            g.setCreate_date(rs.getDate(9));
            g.setUpdate_user(rs.getString(10));
            g.setUpdate_date(rs.getDate(11));
            g.setIsdel(rs.getInt(12));
        }

        return g;
    }
}
