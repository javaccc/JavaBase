package com.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by acebrook on 2017/9/2.
 */
public class HashMapTest {

    class NameKey {
        private String name;

        public NameKey(String name) {
            this.name = name;
        }

        // 重写hashCode，为了测试同样哈希码，但是不相同的key，在map是怎么插入和更新的
        @Override
        public int hashCode() {
            return (null == name ? 0 : name.length());
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof NameKey) {
                NameKey o = (NameKey) obj;
                if (o.name == this.name) {
                    return true;
                }
                return o.name != null && o.name.equals(this.name);
            }
            return false;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

    public void testLoadFactor() {
        Map<String, Object> map = new HashMap<>(5, 3);
    }


    public void testHashMapPut() {
        Map<NameKey, Object> map = new HashMap<>(); // 默认初始容量为16，加载因子是0.75
        map.put(new NameKey("name"), "acebrook"); // debug，观察是怎么插入元素
        map.put(new NameKey("name"), "acebrook01"); // debug，观察是怎么覆盖元素
        map.put(new NameKey("key1"), "acebrook02"); // debug，观察是怎么覆盖元素
        // IDE中debug，可以force step into（强制性进入），可以进入有时step into进步的情况。
        // resize的条件：哈希表已用空间达到threshold（哈希表容量*加载因子，而且，当前插入的元素的key是不存在（hash值不相同；
        // 如果相同，只需要插入链表即可，不需要占用哈希表的剩余空间）
        // 如果key的哈希值对应的位置已经有元素，但是，key不相同（如果相同，只需要更新key对应Entry的value），
        // 不遍历链表，直接作为链表第一个节点（即哈希表bucketIndex对应的元素不放在哈希表，而是作为当前插入元素的next节点
        // HashMap底层数据结构（动态数组+链表），其中链表不是用双向链表（；LinkedHashMap是采用双向链表）实现，而是采用单链表结构
        // LinkedList底层也是双向链表结构，但是LinkedHashMap的双向链表和LinkedList没关系
        System.out.println("collections = " + map);
    }

    public void testLinkedHashMap() {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
    }

    public static void main(String[] args) {
        HashMapTest test = new HashMapTest();
//        test.testLoadFactor();
        test.testHashMapPut();
    }
}
