package d0814;

import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DBHelperTest {
    @Test
    public void testTransactional() {
        String sql1 = "update bank_account set balance = balance + ? where id=?";
        String sql2 = "insert into bank_oprecord values(bank_seq.nextval,?,?,sysdate)";
        DBHelper dbh = null;
        try {
            dbh = new DBHelper();
            if (dbh.update(sql1, 1000, 1) == 1) {
                dbh.update(sql2, 1, 1000);
            }
            //正常情况下提交
            dbh.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //异常情况下要回滚
            dbh.rollback();
        } finally {
            dbh.close();
        }
    }

    @Test
    public void testSelectPage() {
        String sql = "select * from emp";
        DBHelper dbh = null;
        try {
            dbh = new DBHelper();
            List<Map<String, Object>> page = dbh.selectPage(sql, 1, 5);
            Assert.assertEquals(5, page.size());
            Assert.assertEquals("韩梅梅", page.get(0).get("ENAME"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbh.close();
        }
    }

    @Test
    public void testGetValue() {
        String sql = "select max(deptno) from dept";
        DBHelper dbh = null;
        try {
            dbh = new DBHelper();
            System.out.println(dbh.getValue(sql));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbh.close();
        }
    }

    @Test
    public void testCount() {
        String sql = "select * from dept where deptno=1";
        DBHelper dbh = null;
        try {
            dbh = new DBHelper();
            System.out.println(dbh.count(sql));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbh.close();
        }
    }

    public static void test3() {
        DBHelper dbh = null;
        try {
            dbh = new DBHelper();
            String sql = "select * from dept where deptno=?";
            Map<String, Object> map = dbh.selectOne(sql, 10);
            System.out.println(map.get("DNAME"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbh.close();
        }
    }

    public static void test2() {
        DBHelper dbh = null;
        try {
            dbh = new DBHelper();
            List<Map<String, Object>> list = dbh.select("select * from dept");
            for (Map<String, Object> m : list) {
                System.out.println(m);
            }

            System.out.println("=============");
            list = dbh.select("select * from emp where sal >?", 1000);
            for (Map<String, Object> m : list) {
                System.out.println(m);
            }

            System.out.println("=============");
            list = dbh.select("select * from emp where sal between ? and ?", 1000, 2000);
            for (Map<String, Object> m : list) {
                System.out.println(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbh.close();
        }
    }

    public static void test1() {
        DBHelper dbh = null;
        try {
            dbh = new DBHelper();
            //dbh.update("insert into dept values(?,?,?)", 2, "网络部", "北京");
            dbh.update("update dept set dname=? where deptno=?", "技术部", 2);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbh.close();
        }
    }
}
