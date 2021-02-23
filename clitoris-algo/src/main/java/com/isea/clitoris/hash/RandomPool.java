package com.isea.clitoris.hash;

import java.util.HashMap;
import java.util.Random;

/**
 * @author ifseayou@gmail.com
 * @date 2021/2/23 9:28
 * @target:
 * 设计一种结构：该结构中有三个功能，insert(key):将某个key加入到该结构，做到不重复加入
 * delete(key): 将某个key删除；getRandom()等概论返回结构中的任何一个key，要求三个方法的时间复杂度是O(1)
 */
public class RandomPool {
    public static class Pool<K>{
        private HashMap<K,Integer> map1;
        private HashMap<Integer,K> map2;
        private int size;
        public Pool(){
            map1 = new HashMap<>();
            map2 = new HashMap<>();
            size = 0;
        }
        public void insert(K key){
            if (!map1.containsKey(key)){
                map1.put(key,size);
                map2.put(size++,key);
            }
        }
        public K getRandom(){
            if(size == 0) return null;
            return map2.get(new Random().nextInt(size));
        }

        // 使用最后一个去填由于中间删除导致的空缺
        public void delete(K key){
            if (map1.containsKey(key)){
                Integer deleteIndex = map1.get(key);
                int lastIndex = size - 1;
                K lastKey = map2.get(lastIndex);

                map1.put(lastKey,deleteIndex);
                map2.put(deleteIndex,lastKey);

                map1.remove(key);
                map2.remove(lastIndex);
            }
        }
    }
    public static void main(String[] args) {
        Pool<String> pool = new Pool<String>();
        pool.insert("i");
        pool.insert("am");
        pool.insert("king");
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());

    }
}
