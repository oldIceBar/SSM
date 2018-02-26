package com.ice.controller;

import java.util.*;

public class Test {
    public static void main(String[] args) {
//        List<Map<String,Object>> a = new ArrayList<Map<String,Object>>();
//        for (Map<String,Object> item : a){
//            System.out.println(item);
//        }
//        Test.A c = new Test().new A();
//        Test.B d = new Test.B();
//        List<Integer> b = null;
//        for (Integer i : b){
//            System.out.println(i);
//        }
//        BigDecimal a = new BigDecimal("90").divide(new BigDecimal("100"),5,BigDecimal.ROUND_HALF_UP);
//        BigDecimal b = new BigDecimal("92.22").divide(new BigDecimal("100"));
//        System.out.println(a);
//        System.out.println(b);

//        Map<String,Object> res = new HashMap<>();
//        List<String> auto = new ArrayList<>();
//        auto.add("aaa");
//        List<String> normal = new ArrayList<>();
//        res.put("auto",auto);
//        res.put("normal",normal);
//        res.put("aa",null);
//        List l = (List)res.get("auto");
//        List<String> sl = l;
//        sl.forEach(a-> System.out.println(a));
//        System.out.println(res.get("auto"));
//        System.out.println(res.get("auto").toString());
//        System.out.println(res.get("aa"));
//        List list = (List)res.get("auto");
//        System.out.println(list==null);
//        System.out.println(STATUS.PENDDING.name());
//        for(int i=0;i<10;i++) {
//            try {
//                throw  new RuntimeException("aaa");
//            } catch (Exception e) {
//                e.printStackTrace();
//                System.out.println("go on ");
//            }
//        }
//        System.out.println("finished");
//        try{
//            throw new RuntimeException();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        System.out.println("adfsfjlsdajfk");

        Map map = new HashMap();

        Integer[] nums = new Integer[]{2,1,4,3,9,5};
        List list = Arrays.asList(nums);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        System.out.println(list);
//        Arrays.stream(nums).sorted()
    }

    class A {
        private long a;

        public long getA() {
            return a;
        }

        public void setA(long a) {
            this.a = a;
        }
    }
}
