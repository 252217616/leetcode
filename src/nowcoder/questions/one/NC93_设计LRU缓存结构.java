package nowcoder.questions.one;

import nowcoder.entity.ListNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * NC93_设计LRU缓存结构
 *
 * 设计LRU(最近最少使用)缓存结构，该结构在构造时确定大小，假设大小为 k ，并有如下两个功能
 * 1. set(key, value)：将记录(key, value)插入该结构
 * 2. get(key)：返回key对应的value值
 *
 * 提示:
 * 1.某个key的set或get操作一旦发生，认为这个key的记录成了最常使用的，然后都会刷新缓存。
 * 2.当缓存的大小超过k时，移除最不经常使用的记录。
 * 3.输入一个二维数组与k，二维数组每一维有2个或者3个数字，第1个数字为opt，第2，3个数字为key，value
 * 若opt=1，接下来两个整数key, value，表示set(key, value)
 * 若opt=2，接下来一个整数key，表示get(key)，若key未出现过或已被移除，则返回-1
 * 对于每个opt=2，输出一个答案
 * 4.为了方便区分缓存里key与value，下面说明的缓存里key用""号包裹
 *
 *
 * 要求：set和get操作复杂度均为 O(1)O(1)
 *
 * [[1,1,1],[1,2,2],[1,3,2],[2,1],[1,4,4],[2,2]],3
 * 返回值：
 * [1,-1]
 * 说明：
 * [1,1,1]，第一个1表示opt=1，要set(1,1)，即将(1,1)插入缓存，缓存是{"1"=1}
 * [1,2,2]，第一个1表示opt=1，要set(2,2)，即将(2,2)插入缓存，缓存是{"1"=1,"2"=2}
 * [1,3,2]，第一个1表示opt=1，要set(3,2)，即将(3,2)插入缓存，缓存是{"1"=1,"2"=2,"3"=2}
 * [2,1]，第一个2表示opt=2，要get(1)，返回是[1]，因为get(1)操作，缓存更新，缓存是{"2"=2,"3"=2,"1"=1}
 * [1,4,4]，第一个1表示opt=1，要set(4,4)，即将(4,4)插入缓存，但是缓存已经达到最大容量3，移除最不经常使用的{"2"=2}，插入{"4"=4}，缓存是{"3"=2,"1"=1,"4"=4}
 * [2,2]，第一个2表示opt=2，要get(2)，查找不到，返回是[1,-1]
 *
 * @author lujun
 * @date 2021/12/21
 */
public class NC93_设计LRU缓存结构 {
    private Map<Integer, Node> map = new HashMap<>();
    private int max;
    private Node head = new Node(-1,-1);
    private Node tail = new Node(-1,-1);

    public static void main(String[] args) {

    }

    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU (int[][] operators, int k) {
        // write code here
        this.max = k;
        head.next = tail;
        tail.pre = head;
        int len = (int)Arrays.stream(operators).filter(x->x[0] == 2).count();
        int[] res = new int[len];
        int i = 0;
        for (int[] operator : operators) {
            if(operator[0] == 1){
                put(operator[1],operator[2]);
            }else {
                res[i++] = get(operator[1]);
            }
        }
        return res;
    }

    public void put(int key,int val){
        //如有重复的key,将key变成第一个
        if(get(key)> -1){
            map.get(key).val = val;
        }else {
            //如果满了,把最后一个去掉
            if(map.size() == max){
                int rk = tail.pre.key;
                tail.pre.pre.next = tail;
                tail.pre = tail.pre.pre;
                map.remove(rk);
            }
            final Node node = new Node(key,val);
            map.put(key,node);
            moveToHead(node);
        }

    }

    public int get(int key){
        if(this.map.containsKey(key)){
            //把node 从链表中取出
            final Node node = this.map.get(key);
            node.pre.next = node.next;
            node.next.pre = node.pre;
            moveToHead(node);
            return node.val;
        }
        return -1;

    }
    private void moveToHead(Node node) {
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }


    public static class Node{
        private int val;
        private int key;
        private Node pre;
        private Node next;

        public Node(int key,int val){
            this.val = val;
            this.key = key;
        }
    }

}