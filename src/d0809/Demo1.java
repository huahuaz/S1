package d0809;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Demo1 {
    public static void main(String[] args) {
        //map 的泛型是2个类型，分别表示键值的类型
        //Map<String, String> map = new HashMap<>();
        //Map<String, String> map = new LinkedHashMap<>();
        Map<String, String> map = new TreeMap<>();
        map.put("5武松", "行着");
        System.out.println(map);
        map.put("4南派三叔", "三叔");
        System.out.println(map);
        map.put("1吴邪", "小三爷");
        System.out.println(map);
        map.put("2张起灵", "小哥");
        System.out.println(map);
        map.put("3王胖子", "胖子");
        System.out.println(map);

        System.out.println(map.get("2张起灵"));
        System.out.println(map.get("吴邪"));

        //增强for,要将map 集合转换成set 集合
        //Enntry 是Map 接口的静态内部接口
        Set<Entry<String, String>> entrySet = map.entrySet();
        for (Entry<String, String> en : entrySet) {
            System.out.println(en.getKey() + ":" + en.getValue());
        }
        System.out.println();
        //获取键set集合
        Set<String> set = map.keySet();
        //获取值的集合 ==> Collection
        Collection<String> col = map.values();

        for (String key : set) {
            //System.out.println(key + ":" + map.get(key));
        }
        for (Object o : col){
            System.out.println(o);
        }
    }
}
