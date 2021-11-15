package com.oa.dao;

import com.oa.bean.PageInfo;
import com.oa.bean.Employee;
import com.oa.bean.Employee;
import com.oa.util.DataSources;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//员工模块的数据库代码
public class EmployeeDao {

    //定义删除操作[入参一个id]
    public boolean deleteEmployee(int eid) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //1、获取数据库链接的对象
            connection = DataSources.getConnection();
            //2、定义sql语句
            String sql = "delete from employee_inf where id=?;";
            //3、通过数据库链接来获取sql的语句对象【语句对象是用于执行sql语句的】
            // prepareStatement方法来得到一个预编译的sql语句对象，要入参sql语句
            ps = connection.prepareStatement(sql);
            ps.setInt(1, eid);
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

    //定义修改操作[入参一个Employee对象]
    public boolean updateEmployee(Employee employee) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //1、获取数据库链接的对象
            connection = DataSources.getConnection();
            //2、定义sql语句
            String sql = null;
            //头像是否修改的判断
            if (employee.getImgname() == null) {
                sql = "update employee_inf set name=?,password=?,CARD_ID=?,PHONE=?,EMAIL=?,SEX=?,DEPT_ID=?,JOB_ID=?,party=?,race=?,education=? where id=?;";
            } else {
                sql = "update employee_inf set name=?,password=?,CARD_ID=?,PHONE=?,EMAIL=?,SEX=?,DEPT_ID=?,JOB_ID=?,party=?,race=?,education=?,imgname=? where id=?;";
            }
            //3、通过数据库链接来获取sql的语句对象【语句对象是用于执行sql语句的】
            // prepareStatement方法来得到一个预编译的sql语句对象，要入参sql语句
            ps = connection.prepareStatement(sql);
            //给占位符进行赋值 //第一个参数为占位符的位置
            ps.setString(1, employee.getUsername());
            ps.setString(2, employee.getPassword());
            ps.setString(3, employee.getCard_id());
            ps.setString(4, employee.getPhone());
            ps.setString(5, employee.getEmail());
            ps.setInt(6, employee.getSex().equals("男") ? 1 : 2);
            ps.setInt(7, employee.getDept_id());
            ps.setInt(8, employee.getJob_id());
            ps.setString(9, employee.getParty());
            ps.setString(10, employee.getRace());
            ps.setString(11, employee.getEducation());
            //头像是否修改的判断
            if (employee.getImgname() == null) {
                ps.setInt(12, employee.getId());
            } else {
                ps.setString(12, employee.getImgname());
                ps.setInt(13, employee.getId());
            }
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

    //定义添加操作[入参一个Employee对象]
    public boolean insertEmployee(Employee employee) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //1、获取数据库链接的对象
            connection = DataSources.getConnection();
            //2、定义sql语句
            String sql = "insert into employee_inf(name,password,CARD_ID,PHONE,EMAIL,SEX,DEPT_ID,JOB_ID,imgname) values(?,?,?,?,?,?,?,?,?);";
            //3、通过数据库链接来获取sql的语句对象【语句对象是用于执行sql语句的】
            // prepareStatement方法来得到一个预编译的sql语句对象，要入参sql语句
            ps = connection.prepareStatement(sql);
            //给占位符进行赋值 //第一个参数为占位符的位置
            ps.setString(1, employee.getUsername());
            ps.setString(2, employee.getPassword());
            ps.setString(3, employee.getCard_id());
            ps.setString(4, employee.getPhone());
            ps.setString(5, employee.getEmail());
            ps.setInt(6, employee.getSex().equals("男") ? 1 : 2);
            ps.setInt(7, employee.getDept_id());
            ps.setInt(8, employee.getJob_id());
            ps.setString(9, employee.getImgname());
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

    //定义根据id查询Employee数据
    public Employee queryEmployeeById(int eId) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //1、获取数据库链接的对象
            connection = DataSources.getConnection();
            //2、定义sql语句
            String sql =
                    sql = "select * from employee_inf where id =?";
            //3、通过数据库链接来获取sql的语句对象【语句对象是用于执行sql语句的】
            // prepareStatement方法来得到一个预编译的sql语句对象，要入参sql语句
            ps = connection.prepareStatement(sql);
            // 设置limit参数数据
            ps.setInt(1, eId);
            //4、通过sql语句对象来执行sql语句
            ResultSet result = ps.executeQuery();//查询语句使用executeQuery方法执行，返回的是结果集ResultSet
            // result为结果集，里面包含了所有的查询结果
            while (result.next()) {//next方法用于判断当前的结果集中是否有下一条数据
                //有下一条数据，则通过结果集中的get()方法来获取数据   注意这是一条记录
                int id = result.getInt("ID");
                String password = result.getString("password");
                int dept_id = result.getInt("DEPT_ID");
                int job_id = result.getInt("JOB_ID");
                String Employeename = result.getString("NAME");
                String card_id = result.getString("CARD_ID");
                String phone = result.getString("PHONE");
                String email = result.getString("EMAIL");
                String sex = result.getInt("SEX") == 1 ? "男" : "女";
                String party = result.getString("PARTY");
                String race = result.getString("RACE");
                String education = result.getString("EDUCATION");
                String createDate = result.getString("CREATE_DATE");
                String imgname = result.getString("imgname");
                //将数据进行封装，封装到Employee对象中
                Employee employee = new Employee(id, password, dept_id, job_id, Employeename, sex, email, education, phone, card_id, party, race, imgname, createDate, null, null);
                //将Employee对象返回
                return employee;
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

    //定义根据分页信息查询Employee数据
    public List<Employee> queryEmployee(PageInfo page, String search, int deptId) {
        //创建一个list集合用于保存查询到数据
        List<Employee> EmployeeList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //1、获取数据库链接的对象
            connection = DataSources.getConnection();
            //2、定义sql语句
            String sql = null;
            if (deptId <= 0) {
                sql = "select e.*,d.name as deptName,j.name as jobName from employee_inf e \n" +
                        "inner join dept_inf d \n" +
                        "on d.id = e.DEPT_ID \n" +
                        "inner join job_inf j \n" +
                        "on j.id = e.JOB_ID where e.name like ? limit ?,?";
            } else {
                sql = "select e.*,d.name as deptName,j.name as jobName from employee_inf e \n" +
                        "inner join dept_inf d \n" +
                        "on d.id = e.DEPT_ID \n" +
                        "inner join job_inf j \n" +
                        "on j.id = e.JOB_ID where e.name like ? and DEPT_ID =? limit ?,?";
            }
            //3、通过数据库链接来获取sql的语句对象【语句对象是用于执行sql语句的】
            // prepareStatement方法来得到一个预编译的sql语句对象，要入参sql语句
            ps = connection.prepareStatement(sql);
            // 设置limit参数数据
            ps.setString(1, "%" + search + "%");//配置模糊查询的配置规则
            if (deptId <= 0) {
                ps.setInt(2, page.getStartIndex());
                ps.setInt(3, page.getPageSize());
            } else {
                ps.setInt(2, deptId);
                ps.setInt(3, page.getStartIndex());
                ps.setInt(4, page.getPageSize());
            }
            //4、通过sql语句对象来执行sql语句
            ResultSet result = ps.executeQuery();//查询语句使用executeQuery方法执行，返回的是结果集ResultSet
            // result为结果集，里面包含了所有的查询结果
            while (result.next()) {//next方法用于判断当前的结果集中是否有下一条数据
                //有下一条数据，则通过结果集中的get()方法来获取数据   注意这是一条记录
                int id = result.getInt("ID");
                String password = result.getString("password");
                int dept_id = result.getInt("DEPT_ID");
                int job_id = result.getInt("JOB_ID");
                String Employeename = result.getString("NAME");
                String card_id = result.getString("CARD_ID");
                String phone = result.getString("PHONE");
                String email = result.getString("EMAIL");
                String sex = result.getInt("SEX") == 1 ? "男" : "女";
                String party = result.getString("PARTY");
                String race = result.getString("RACE");
                String education = result.getString("EDUCATION");
                String createDate = result.getString("CREATE_DATE");
                String imgname = result.getString("imgname");
                String deptName = result.getString("deptName");
                String jobName = result.getString("jobName");
                //将数据进行封装，封装到Employee对象中
                Employee employee = new Employee(id, password, dept_id, job_id, Employeename, sex, email, education, phone, card_id, party, race, imgname, createDate, deptName, jobName);
                //将Employee对象添加到集合中
                EmployeeList.add(employee);
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
        return EmployeeList;
    }

    //定义查询Employee总数据记录
    public static int queryEmployeeCount(String search, int deptId) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //1、获取数据库链接的对象
            connection = DataSources.getConnection();
            //2、定义sql语句
            String sql = "select count(*) from employee_inf where name like ?";
            if (deptId > 0) {
                sql = sql + " and DEPT_ID =?";
            }
            //3、通过数据库链接来获取sql的语句对象【语句对象是用于执行sql语句的】
            // prepareStatement方法来得到一个预编译的sql语句对象，要入参sql语句
            ps = connection.prepareStatement(sql);
            //给占位符赋值
            ps.setString(1, "%" + search + "%");//配置模糊查询的配置规则
            if (deptId > 0) {
                ps.setInt(2, deptId);
            }
            //4、通过sql语句对象来执行sql语句
            ResultSet result = ps.executeQuery();//查询语句使用executeQuery方法执行，返回的是结果集ResultSet
            // result为结果集，里面包含了所有的查询结果
            if (result.next()) {//next方法用于判断当前的结果集中是否有下一条数据
                int res = result.getInt(1);
                System.out.println("%" + search + "%");
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
    //定义登录查询Employee数据
    public Employee queryEmployeeLogin(String name, String pass) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //1、获取数据库链接的对象
            connection = DataSources.getConnection();
            //2、定义sql语句
            String sql = "select * from employee_inf where name =? and password=?";
            //3、通过数据库链接来获取sql的语句对象【语句对象是用于执行sql语句的】
            // prepareStatement方法来得到一个预编译的sql语句对象，要入参sql语句
            ps = connection.prepareStatement(sql);
            // 设置limit参数数据
            ps.setString(1, name);
            ps.setString(2, pass);
            //4、通过sql语句对象来执行sql语句
            ResultSet result = ps.executeQuery();//查询语句使用executeQuery方法执行，返回的是结果集ResultSet
            // result为结果集，里面包含了所有的查询结果
            if (result.next()) {//next方法用于判断当前的结果集中是否有下一条数据
                //有下一条数据，则通过结果集中的get()方法来获取数据   注意这是一条记录
                int id = result.getInt("ID");
                String password = result.getString("password");
                int dept_id = result.getInt("DEPT_ID");
                int job_id = result.getInt("JOB_ID");
                String Employeename = result.getString("NAME");
                String card_id = result.getString("CARD_ID");
                String phone = result.getString("PHONE");
                String email = result.getString("EMAIL");
                String sex = result.getInt("SEX") == 1 ? "男" : "女";
                String party = result.getString("PARTY");
                String race = result.getString("RACE");
                String education = result.getString("EDUCATION");
                String createDate = result.getString("CREATE_DATE");
                String imgname = result.getString("imgname");
                //将数据进行封装，封装到Employee对象中
                Employee employee = new Employee(id, password, dept_id, job_id, Employeename, sex, email, education, phone, card_id, party, race, imgname, createDate, null, null);
                //将Employee对象返回
                return employee;
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
}
