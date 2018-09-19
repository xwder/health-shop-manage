package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Test {

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void main(String[] args) {

        List<Bean> list = new ArrayList<Bean>();
        for (int i = 1; i < 10; i++) {
            Bean bean = new Bean();
            bean.setName("name_" + i);
            bean.setPriority(new Random().nextInt(10));
            list.add(bean);
        }
        // 打印
        for (Bean b : list) {
            System.out.println(b.getPriority() + "|" + b.getName());
        }

        Collections.sort(list, new Comparator() {
            public int compare(Object a, Object b) {
                int one = ((Bean) a).getPriority();
                int two = ((Bean) b).getPriority();
                return one - two;
            }
        });
        System.out.println("--------------------------------");
        // 打印
        for (Bean b : list) {
            System.out.println(b.getPriority() + "|" + b.getName());
        }
    }

}