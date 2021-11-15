package com.oa.dao;

import com.oa.bean.PageInfo;
import com.oa.bean.Announcement;
import com.oa.bean.User;
import com.oa.util.DataSources;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//针对公告模块的数据库操作
public class AnnouncementDao {

    //定义删除操作[入参一个user对象]
    public boolean deleteAnnouncement(int id) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //1、获取数据库链接的对象
            connection = DataSources.getConnection();
            //2、定义sql语句
            String sql = "delete from announcement_info where id = ?;";
            //3、通过数据库链接来获取sql的语句对象【语句对象是用于执行sql语句的】
            // prepareStatement方法来得到一个预编译的sql语句对象，要入参sql语句
            ps = connection.prepareStatement(sql);
            //给占位符进行赋值 //第一个参数为占位符的位置
            ps.setInt(1, id);
            //4、通过sql语句对象来执行sql语句
            int result = ps.executeUpdate();//添加、删除、修改sql都可以使用executeUpdate方法执行
            // result为执行sql语句的影响行数、成功为大于0，否则小于等于0
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5、释放资源
            try {
                ps.close();
                DataSources.close(connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    //定义添加操作[入参一个user对象]
    public boolean insertAnnouncement(Announcement announcement) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //1、获取数据库链接的对象
            connection = DataSources.getConnection();
            //2、定义sql语句
            String sql = "insert into announcement_info(title,content,createtime,uid) values(?,?,now(),?);";
            //3、通过数据库链接来获取sql的语句对象【语句对象是用于执行sql语句的】
            // prepareStatement方法来得到一个预编译的sql语句对象，要入参sql语句
            ps = connection.prepareStatement(sql);
            //给占位符进行赋值 //第一个参数为占位符的位置
            ps.setString(1, announcement.getTitle());
            ps.setString(2, announcement.getContent());
            ps.setInt(3, announcement.getUid());
            //4、通过sql语句对象来执行sql语句
            int result = ps.executeUpdate();//添加、删除、修改sql都可以使用executeUpdate方法执行
            // result为执行sql语句的影响行数、成功为大于0，否则小于等于0
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5、释放资源
            try {
                ps.close();
                DataSources.close(connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    //定义修改操作[入参一个announcement对象]
    public boolean updateAnnouncement(Announcement announcement) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //1、获取数据库链接的对象
            connection = DataSources.getConnection();
            //2、定义sql语句
            String sql = "update announcement_info set title=?,content=?,createtime=now(),uid=? where id=?;";
            //3、通过数据库链接来获取sql的语句对象【语句对象是用于执行sql语句的】
            // prepareStatement方法来得到一个预编译的sql语句对象，要入参sql语句
            ps = connection.prepareStatement(sql);
            //给占位符进行赋值 //第一个参数为占位符的位置
            ps.setString(1, announcement.getTitle());
            ps.setString(2, announcement.getContent());
            ps.setInt(3, announcement.getUid());
            ps.setInt(4, announcement.getId());
            //4、通过sql语句对象来执行sql语句
            int result = ps.executeUpdate();//添加、删除、修改sql都可以使用executeUpdate方法执行
            // result为执行sql语句的影响行数、成功为大于0，否则小于等于0
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5、释放资源
            try {
                ps.close();
                DataSources.close(connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    //定义根据分页信息查询Announcement数据【查询所有、按照条件进行查询】
    public List<Announcement> queryAnnouncement(PageInfo page, String search) {
        //创建一个list集合用于保存查询到数据
        List<Announcement> AnnouncementList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //1、获取数据库链接的对象
            connection = DataSources.getConnection();
            //2、定义sql语句
            String sql = "select a.*,u.username from announcement_info a \n" +
                    "INNER JOIN user_inf u \n" +
                    "on a.uid = u.ID \n" +
                    "where a.content like ? ORDER BY a.createtime desc limit ?,?";
            //3、通过数据库链接来获取sql的语句对象【语句对象是用于执行sql语句的】
            // prepareStatement方法来得到一个预编译的sql语句对象，要入参sql语句
            ps = connection.prepareStatement(sql);
            // 设置limit参数数据
            ps.setString(1, "%" + search + "%");//配置模糊查询的配置规则
            ps.setInt(2, page.getStartIndex());
            ps.setInt(3, page.getPageSize());
            //4、通过sql语句对象来执行sql语句
            ResultSet result = ps.executeQuery();//查询语句使用executeQuery方法执行，返回的是结果集ResultSet
            // result为结果集，里面包含了所有的查询结果
            while (result.next()) {//next方法用于判断当前的结果集中是否有下一条数据
                //有下一条数据，则通过结果集中的get()方法来获取数据   注意这是一条记录
                int id = result.getInt("id");
                String title = result.getString("title");
                String content = result.getString("content");
                String createtime = result.getString("createtime");
                int uid = result.getInt("uid");
                String username = result.getString("username");
                //将数据进行封装，封装到Announcement对象中
                Announcement Announcement = new Announcement(id, title, content, createtime, uid, username);
                //将Announcement对象添加到集合中
                AnnouncementList.add(Announcement);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5、释放资源
            try {
                ps.close();
                DataSources.close(connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        //返回集合对象
        return AnnouncementList;
    }

    //定义根据分页信息查询Announcement数据【查询所有、按照条件进行查询】
    public Announcement queryAnnouncementById(int aid) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //1、获取数据库链接的对象
            connection = DataSources.getConnection();
            //2、定义sql语句
            String sql = "select a.*,u.username from announcement_info a \n" +
                    "INNER JOIN user_inf u \n" +
                    "on a.uid = u.ID \n" +
                    "where a.id=?;";
            //3、通过数据库链接来获取sql的语句对象【语句对象是用于执行sql语句的】
            // prepareStatement方法来得到一个预编译的sql语句对象，要入参sql语句
            ps = connection.prepareStatement(sql);
            // 设置limit参数数据
            ps.setInt(1, aid);
            //4、通过sql语句对象来执行sql语句
            ResultSet result = ps.executeQuery();//查询语句使用executeQuery方法执行，返回的是结果集ResultSet
            // result为结果集，里面包含了所有的查询结果
            while (result.next()) {//next方法用于判断当前的结果集中是否有下一条数据
                //有下一条数据，则通过结果集中的get()方法来获取数据   注意这是一条记录
                int id = result.getInt("id");
                String title = result.getString("title");
                String content = result.getString("content");
                String createtime = result.getString("createtime");
                int uid = result.getInt("uid");
                String username = result.getString("username");
                //将数据进行封装，封装到Announcement对象中
                Announcement Announcement = new Announcement(id, title, content, createtime, uid, username);
                //将Announcement对象添加到集合中
                return Announcement;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5、释放资源
            try {
                ps.close();
                DataSources.close(connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        //返回null
        return null;
    }

    //定义查询Announcement总数据记录
    public static int queryAnnouncementCount(String search) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //1、获取数据库链接的对象
            connection = DataSources.getConnection();
            //2、定义sql语句
            String sql = "select count(*) from announcement_info where content like ?";
            //3、通过数据库链接来获取sql的语句对象【语句对象是用于执行sql语句的】
            // prepareStatement方法来得到一个预编译的sql语句对象，要入参sql语句
            ps = connection.prepareStatement(sql);
            //给占位符赋值
            ps.setString(1, "%" + search + "%");//配置模糊查询的配置规则
            //4、通过sql语句对象来执行sql语句
            ResultSet result = ps.executeQuery();//查询语句使用executeQuery方法执行，返回的是结果集ResultSet
            // result为结果集，里面包含了所有的查询结果
            if (result.next()) {//next方法用于判断当前的结果集中是否有下一条数据
                int res = result.getInt(1);
                return res;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5、释放资源
            try {
                ps.close();
                DataSources.close(connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        //没有返回0
        return 0;
    }

}
