package d0814;

import java.sql.*;
import java.util.*;

public class DBHelper {
    //oop : 类的构成元素--静态块，块不允许抛出编译期异常
    static {
        //加载驱动只需要执行一次，以后再也不需要执行
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            //将异常转换成运行期异常，再抛出就没问题了
            throw new RuntimeException(e);
            //运行期异常无感知
            //编译期异常有感知
        }
    }

    private Connection conn;

    public DBHelper() throws SQLException {
        conn = getConnection();
    }

    /**
     * 创建连接
     *
     * @return
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        String url = "jdbc:oracle:thin:@192.168.174.1:1521:orcl";
        String user = "scott";
        String password = "a";
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * 定义执行sql语句的函数，返回结果
     */
    public int update(String sql, Object... param) throws SQLException {
        //创建预编译语句对象 ==> 它是普通语句对象的子类
        PreparedStatement ps = conn.prepareStatement(sql);
        //打印sql
        System.out.println(sql);
        //在执行语句前，将参数设置到sql语句中，用setXXX
        for (int i = 0; i < param.length; i++) {
            ps.setObject(i + 1, param[i]);
        }
        //执行时不传sql 语句
        return ps.executeUpdate();
    }

    public List<Map<String, Object>> select(String sql, Object... param) throws SQLException {
        //创建预编译语句对象 ==> 它是普通语句对象的子类
        PreparedStatement ps = conn.prepareStatement(sql);
        //打印sql
        System.out.println("SQL:" + sql);
        System.out.println("参数：" + Arrays.toString(param));
        //在执行语句前，将参数设置到sql语句中，用setXXX
        for (int i = 0; i < param.length; i++) {
            ps.setObject(i + 1, param[i]);
        }
        ResultSet rs = ps.executeQuery();
        //rs ==> List<Map<String,Object>>
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        //rs 可以获取到结果集的"元数据对象" 元数据：描述数据的数据
        ResultSetMetaData rsmd = rs.getMetaData();

        while (rs.next()) {
            //LinkedHashMap 有序不重复
            Map<String, Object> map = new LinkedHashMap<String, Object>();
            for (int i = 0; i < rsmd.getColumnCount(); i++) {
                String columnName = rsmd.getColumnName(i + 1);
                Object columnValue = rs.getObject(columnName);
                //获取所有的字段名，以及对应的字段值
                map.put(columnName, columnValue);
            }
            //获取所有的字段名，以及对应的字段值
            list.add(map);
        }
        //执行时不传sql 语句
        return list;
    }

    public Map<String, Object> selectOne(String sql, Object... param) throws SQLException {
        List<Map<String, Object>> list = select(sql, param);
        return list.size() == 0 ? null : list.get(0);
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
