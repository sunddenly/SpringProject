package org.hebut.scse.algorithm.sort;

import org.hebut.scse.datastructure.list.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jxy on 2016/9/17.
 */
public class BucketSort {
    //基数排序（radix sort）属于“分配式排序”（distribution sort），又称“桶子法”（bucket sort）或bin sort，
    // 最高位优先(Most Significant Digit first)法，简称MSD法：先按k1排序分组，同一组中记录，关键码k1相等，再对各组按k2排序分成子组，之后，对后面的关键码继续这样的排序分组，
    // 直到按最次位关键码kd对各子组排序后。再将各组连接起来，便得到一个有序序列。
    // 最低位优先(Least Significant Digit first)法，简称LSD法：先从kd开始排序，再对kd-1进行排序，依次重复，直到对k1排序后便得到一个有序序列。
    public static void radixSort(int[] a,int radix,int d){
        int[] bucket = new int[radix];
        int[] temp = new int[a.length];
        for(int i=0,rate=1;i<d;i++){//按每一位进行排序
            Arrays.fill(bucket,0);
            System.arraycopy(a,0,temp,0,a.length);//用temp来更新data
            for(int j=0;j<a.length;j++){//遍历n个数，按关键字的某一位进行划分
                int key=(a[j]/rate)%radix;
                bucket[key]++;
            }
            for(int j=1;j<radix;j++){//1-9,求出每个桶中的最大位置
                bucket[j]=bucket[j]+bucket[j-1];
            }
            for(int j=a.length-1;j>=0;j--){//分配时由末位向首位进行,因为先分配的是大坐标
                int key = (temp[j]/rate)%radix;
                a[--bucket[key]]=temp[j];
            }
            rate *=radix;
        }
    }
    /*
     * 双层桶排序
     * 类似于分支策略，将一个大范围的排序，划分为多个小范围排序
     * 最后对每个范围进行合并
     * interval:表示每个桶与桶之间的计量范围
     * interval=max/bucketSize
     * 第k大数、中位数、不重复或重复数字
     */
    public static List<Integer> bucketSort(int[] a, int bucketSize,int interval){
        Node[] table = new Node[bucketSize];
        for(int i=0;i<bucketSize;i++) {
            table[i] = new Node();
            table[i].key=0;//记录当前桶的记录数
            table[i].next=null;
        }
        for(int j=0;j<a.length;j++){
            Node node = new Node();
            node.key=a[j];
            node.next=null;
            int index=a[j]/interval;//10;  0-9:0,10-19:1,20-29
            Node head = table[index];
            if(head.key==0){
                table[index].next=node;
                table[index].key++;
            }else {
                while (head.next!=null&&head.next.key<=node.key)
                    head=head.next;
                node.next=head.next;
                head.next=node;
                table[index].key++;
            }
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(Node head:table){
            Node node = head.next;
            while (node!=null){
                list.add(node.key);
                node=node.next;
            }
        }
        return list;
    }
    public static void main(String[] args) {
        int[] a = {54,3,2,1,1,2,4,3,6,7,99,20,1000};
//        radixSort(a,10,2);
//        print(a);
        System.out.println(bucketSort(a,11,100));
    }
    public static void print(int[] a){
        for (int i:a) {
            System.out.print(i+",");
        }
    }
}
