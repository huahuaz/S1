package d0912;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SsqMain {
    private String ssqfile = "D:\\Users\\82427\\IdeaProjects\\S1\\src\\d0912\\双色球.txt";// 文件路径

    private List<String> ssqdata = new ArrayList<>();// 文件内容集合

    // 读取文件
    private void read() {
        // 定义文件字符流
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(ssqfile);
            // 缓冲处理流
            br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                ssqdata.add(line);
            }
            br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 写入数据库
    public void save() {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:orcl";
            String user = "scott";
            String password = "a";
            conn = DriverManager.getConnection(url, user, password);
            // 在循环外创建语句对象
            String sql = "insert into LOTTERY values(SEQ_SSQ.nextval,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            for (String line : ssqdata) {
                String[] values = line.split("\\s+");// 使用空格分割每个元素
                // 设置12个参数
                for (int i = 1; i <= 12; i++) {
                    ps.setString(i, values[i - 1]);
                }
                ps.executeQuery();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 查询ssq数据
    public List<Map<String, Object>> query() {
        List<Map<String, Object>> list = new ArrayList<>();
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:orcl";
            String user = "scott";
            String password = "a";
            conn = DriverManager.getConnection(url, user, password);
            // 在循环外创建语句对象
            String sql = "select * from LOTTERY";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
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
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static void main(String[] args) {
        // 读入
        System.out.println("=======读入=======");
        SsqMain sm = new SsqMain();
        sm.read();
        for (String line : sm.ssqdata) {
            System.out.println(line);
        }
        // 保存到数据库
		/*System.out.println("=======保存到数据库=======");
		sm.save();
		System.out.println("=======保存成功=======");*/
        System.out.println("=========查询数据=======");
        List<Map<String, Object>> list = sm.query();
        for (Map<String, Object> l : list) {
            System.out.println(l);
        }
    }
}
