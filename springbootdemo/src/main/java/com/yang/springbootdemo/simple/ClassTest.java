package com.yang.springbootdemo.simple;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * </br>
 * Created by yangxiaohua on 2020/10/13.
 */
public class ClassTest {

  public static void main(String[] args) throws Exception {
    //
    //    OnlineOrder order = new OnlineOrder();
    //    OnlineOrderLine line = new OnlineOrderLine("1", "2");
    //    order.getLines().add(line);
    //    order.setOrderNum("55566644");
    //    Map<String, PropertyDescriptor> collect = Arrays
    //      .stream(Introspector.getBeanInfo(order.getClass()).getPropertyDescriptors())
    //      .map(d -> Pair.of(d.getName(), d)).collect(Collectors.toMap(Pair::getKey, Pair::getValue));
    //    List<Pair<String, ?>> fieldValues = new ArrayList<>();
    //    for (Entry<String, PropertyDescriptor> entry : collect.entrySet()) {
    //      if (StringUtils.equals("class", entry.getKey())) {
    //        continue;
    //      }
    //
    //      // 取所有字段
    //      Object value = entry.getValue().getReadMethod().invoke(order);
    //      System.out.println("value:" + value);
    //      System.out.println("type:" + entry.getValue().getPropertyType());
    //      if (entry.getValue().getPropertyType().isInterface()) {
    //        System.out.println("collection:" + entry.getKey());
    //      }
    //      fieldValues.add(Pair.of(entry.getKey(), value instanceof Enum ? ((Enum) value).name() : value));
    //    }

    long time = toDate("2020-10-15 19:43:02").getTime();
    long now = System.currentTimeMillis();
    System.out.println(time);
    System.out.println(now);
    System.out.println((now - time) / 1000L);

  }

  private static final SimpleDateFormat sdf_yMdHms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  public static Date toDate(String s) {
    synchronized (sdf_yMdHms) {
      try {
        return s == null ? null : sdf_yMdHms.parse(s);
      } catch (Exception e) {
        return null;
      }
    }
  }
}
