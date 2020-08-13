package d0813.hw;

import util.DBHelper;

import java.sql.*;

public class EmpDemo {
    public void add() {
        EmpDemo ep = new EmpDemo();
        Emp emp = new Emp();
        emp.setEmpno(1);
        emp.setEname("吴邪");
        emp.setJob("吴山居");
        emp.setMgr("7999");
        emp.setHiredate(Date.valueOf("2000-03-25"));
        emp.setSal(8000.00);
        emp.setComm(2000.00);
        emp.setDeptno(null);
        ep.addEmp(emp);
    }

    public void addEmp(Emp emp) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@192.168.174.1:1521:orcl";
            String user = "scott";
            String password = "a";
            conn = DriverManager.getConnection(url, user, password);
            String sql = "insert into emp values(?,?,?,?,?,?,?,null)";
            ps = conn.prepareStatement(sql);
            System.out.println(sql);
            ps.setInt(1, emp.getEmpno());
            ps.setString(2, emp.getEname());
            ps.setString(3, emp.getJob());
            ps.setString(4, emp.getMgr());
            ps.setDate(5, emp.getHiredate());
            ps.setDouble(6, emp.getSal());
            ps.setDouble(7, emp.getComm());
            //ps.setInt(8, emp.getDeptno());
            int ret = ps.executeUpdate();
            System.out.println("新增了" + ret + "个员工");
            //rs = ps.executeQuery();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.close(rs, ps, conn);
        }
    }

    public void queryEmpByNo(int empno) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@192.168.174.1:1521:orcl";
            String user = "scott";
            String password = "a";
            conn = DriverManager.getConnection(url, user, password);
            String sql = "select * from emp where empno=?";
            ps = conn.prepareStatement(sql);
            System.out.println(sql);
            ps.setInt(1, empno);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("empno:" + rs.getInt(1));
                System.out.println("ename:" + rs.getString(2));
                System.out.println("job:" + rs.getString(3));
                System.out.println("mgr:" + rs.getString(4));
                System.out.println("hiredate:" + rs.getDate(5));
                System.out.println("sal:" + rs.getDouble(6));
                System.out.println("comm:" + rs.getDouble(7));
                System.out.println("deptno:" + rs.getInt(8));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.close(rs, ps, conn);
        }
    }

    public void queryEmpByName(String ename) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@192.168.174.1:1521:orcl";
            String user = "scott";
            String password = "a";
            conn = DriverManager.getConnection(url, user, password);
            String sql = "select * from emp where ename=?";
            ps = conn.prepareStatement(sql);
            System.out.println(sql);
            ps.setString(1, ename);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("empno:" + rs.getInt(1));
                System.out.println("ename:" + rs.getString(2));
                System.out.println("job:" + rs.getString(3));
                System.out.println("mgr:" + rs.getString(4));
                System.out.println("hiredate:" + rs.getDate(5));
                System.out.println("sal:" + rs.getDouble(6));
                System.out.println("comm:" + rs.getDouble(7));
                System.out.println("deptno:" + rs.getInt(8));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.close(rs, ps, conn);
        }
    }

    public void delEmp(int empno) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@192.168.174.1:1521:orcl";
            String user = "scott";
            String password = "a";
            conn = DriverManager.getConnection(url, user, password);
            String sql = "delete from emp where empno=?";
            ps = conn.prepareStatement(sql);
            System.out.println(sql);
            ps.setInt(1, empno);
            int ret = ps.executeUpdate();
            System.out.println("已删除" + ret + "个员工");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.close(rs, ps, conn);
        }
    }


    public void updateEmp(Emp emp) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@192.168.174.1:1521:orcl";
            String user = "scott";
            String password = "a";
            conn = DriverManager.getConnection(url, user, password);
            String sql = "update emp set ename=?,job=?,hiredate=?,sal=?,comm=? where empno=?";
            ps = conn.prepareStatement(sql);
            System.out.println(sql);
            ps.setString(1, emp.getEname());
            ps.setString(2, emp.getJob());
            ps.setDate(3, emp.getHiredate());
            ps.setDouble(4, emp.getSal());
            ps.setDouble(5, emp.getComm());
            ps.setInt(6,emp.getEmpno());
            int ret = ps.executeUpdate();
            System.out.println("修改了" + ret + "个员工信息");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.close(rs, ps, conn);
        }
    }

    public void update(){
        Emp emp = new Emp();
        emp.setEmpno(7937);
        emp.setEname("韩梅梅");
        emp.setJob("大学生");
        emp.setHiredate(Date.valueOf("2020-08-01"));
        emp.setSal(3000.00);
        emp.setComm(200.00);
        EmpDemo empDemo = new EmpDemo();
        empDemo.updateEmp(emp);
    }
}
