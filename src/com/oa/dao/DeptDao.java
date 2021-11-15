package com.oa.dao;

import com.oa.bean.Announcement;
import com.oa.bean.Dept;
import com.oa.bean.PageInfo;
import com.oa.bean.User;
import com.oa.util.DataSources;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeptDao {

    //定义查询所有Dept数据
    public List<Dept> queryDept() {
        //创建一个list集合用于保存查询到数据
        List<Dept> DeptList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //1、获取数据库链接的对象
            connection = DataSources.getConnection();
            //2、定义sql语句
            String sql = "select * from dept_inf;";
            //3、通过数据库链接来获取sql的语句对象【语句对象是用于执行sql语句的】
            // prepareStatement方法来得到一个预编译的sql语句对象，要入参sql语句
            ps = connection.prepareStatement(sql);
            //4、通过sql语句对象来执行sql语句
            ResultSet result = ps.executeQuery();//查询语句使用executeQuery方法执行，返回的是结果集ResultSet
            // result为结果集，里面包含了所有的查询结果
            while (result.next()) {//next方法用于判断当前的结果集中是否有下一条数据
                int id = result.getInt("id");
                String name = result.getString("name");
                String remark = result.getString("remark");
                Dept dept = new Dept(id, name, remark);
                DeptList.add(dept);
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
        return DeptList;
    }

    public static int queryDeptCount(String search) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //1、获取数据库链接的对象
            connection = DataSources.getConnection();
            //2、定义sql语句
            String sql = "select count(*) from dept_inf where name like ?";
            //3、通过数据库链接来获取sql的语句对象【语句对象是用于执行sql语句的】
            // prepareStatement方法来得到一个预编译的sql语句对象，要入参sql语句
            ps = connection.prepareStatement(sql);
            //给占位符赋值
            ps.setString(1, "%"+search+"%");//配置模糊查询的配置规则
            //4、通过sql语句对象来执行sql语句
            ResultSet result = ps.executeQuery();//查询语句使用executeQuery方法执行，返回的是结果集ResultSet
            // result为结果集，里面包含了所有的查询结果
            if (result.next()) {//next方法用于判断当前的结果集中是否有下一条数据
                int res = result.getInt(1);
                System.out.println("%"+search+"%");
                System.out.println(res);
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

    //定义根据分页信息查询user数据
    public List<Dept> queryDept(PageInfo page, String search) {
        //创建一个list集合用于保存查询到数据
        List<Dept> deptList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //1、获取数据库链接的对象
            connection = DataSources.getConnection();
            //2、定义sql语句
            String sql = "select * from dept_inf where name like ? limit ?,?";
            //3、通过数据库链接来获取sql的语句对象【语句对象是用于执行sql语句的】
            // prepareStatement方法来得到一个预编译的sql语句对象，要入参sql语句
            ps = connection.prepareStatement(sql);
            // 设置limit参数数据
            ps.setString(1, "%"+search+"%");//配置模糊查询的配置规则
            ps.setInt(2, page.getStartIndex());
            ps.setInt(3, page.getPageSize());
            //4、通过sql语句对象来执行sql语句
            ResultSet result = ps.executeQuery();//查询语句使用executeQuery方法执行，返回的是结果集ResultSet
            // result为结果集，里面包含了所有的查询结果
            while (result.next()) {//next方法用于判断当前的结果集中是否有下一条数据
                //有下一条数据，则通过结果集中的get()方法来获取数据   注意这是一条记录
                int id = result.getInt("id");
                String name = result.getString("name");
                String remark = result.getString("remark");
                //将数据进行封装，封装到dept对象中
                Dept dept = new Dept(id, name, remark);
                //将user对象添加到集合中
                deptList.add(dept);
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
        return deptList;
    }

    //--定义dept的根据id查询的方法（入参id）
    public Dept queryDeptById(int deptid) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //1、获取数据库链接的对象
            connection = DataSources.getConnection();
            //2、定义sql语句
            String sql = "select * from dept_inf where id=?;";
            //3、通过数据库链接来获取sql的语句对象【语句对象是用于执行sql语句的】
            // prepareStatement方法来得到一个预编译的sql语句对象，要入参sql语句
            ps = connection.prepareStatement(sql);
            ps.setInt(1, deptid);
            //4、通过sql语句对象来执行sql语句
            ResultSet result = ps.executeQuery();//查询语句使用executeQuery方法执行，返回的是结果集ResultSet
            // result为结果集，里面包含了所有的查询结果
            while (result.next()) {//next方法用于判断当前的结果集中是否有下一条数据
                //有下一条数据，则通过结果集中的get()方法来获取数据   注意这是一条记录
                int id = result.getInt("id");
                String name = result.getString("name");
                String remark = result.getString("remark");
                //将数据进行封装，封装到user对象中
                Dept dept = new Dept(id, name, remark);
                //将user进行返回
                return dept;
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
        return null;
    }

    //定义修改
    public boolean updateDept(Dept dept) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //1、获取数据库链接的对象
            connection = DataSources.getConnection();
            //2、定义sql语句
            String sql = "update dept_inf set name=?,remark=? where id=?";
            //3、通过数据库链接来获取sql的语句对象【语句对象是用于执行sql语句的】
            // prepareStatement方法来得到一个预编译的sql语句对象，要入参sql语句
            ps = connection.prepareStatement(sql);
            //给占位符进行赋值 //第一个参数为占位符的位置
            ps.setString(1, dept.getName());
            ps.setString(2, dept.getRemark());
            ps.setInt(3, dept.getId());

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

    //定义删除操作[入参一个user对象]
    public boolean deleteDept(int id) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //1、获取数据库链接的对象
            connection = DataSources.getConnection();
            //关闭自动提交
            connection.setAutoCommit(false);
            //2、定义sql语句
            String sql_1 = "SET FOREIGN_KEY_CHECKS = 0; ";
            String sql_2 = "delete from dept_inf where id = "+id;
            String sql_3 = "SET FOREIGN_KEY_CHECKS = 1; ";
            //3、通过数据库链接来获取sql的语句对象【语句对象是用于执行sql语句的】
            // prepareStatement方法来得到一个预编译的sql语句对象，要入参sql语句
            ps = connection.prepareStatement(sql_1);
            ps.addBatch();
            //获取语句执行情况
            int result = ps.executeUpdate(sql_2);
            ps.addBatch();
            ps.executeUpdate(sql_3);
            ps.addBatch();
            connection.commit();
            /*connection.prepareStatement("SET FOREIGN_KEY_CHECKS = 1;");*/
            //4、通过sql语句对象来执行sql语句
            /*int result = ps.executeUpdate();//添加、删除、修改sql都可以使用executeUpdate方法执行*/
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
    public boolean insertDept(Dept dept) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //1、获取数据库链接的对象
            connection = DataSources.getConnection();
            //2、定义sql语句
            String sql = "insert into dept_inf(name,remark) values(?,?);";
            //3、通过数据库链接来获取sql的语句对象【语句对象是用于执行sql语句的】
            // prepareStatement方法来得到一个预编译的sql语句对象，要入参sql语句
            ps = connection.prepareStatement(sql);
            //给占位符进行赋值 //第一个参数为占位符的位置
            ps.setString(1, dept.getName());
            ps.setString(2, dept.getRemark());
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
}
