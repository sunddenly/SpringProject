package org.hebut.scse.algorithm.sort;

import java.util.Stack;

/**
 * Created by jxy on 2016/9/17.
 */
public class SwapSort {
    /**
     * 冒泡排序：大数往右排序
     */
    public static void bubbleSortRight(int[] a){
        int flag=0;
        for(int i=0;i<a.length-1;i++){//一共n-1趟，剩余最后一个数时不用处理
            flag=0;
            for(int j=0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j]=a[j+1];
                    a[j+1]= temp;
                    flag=1;
                }
            }
            if(flag==0)
                break;
        }
    }
    /**
     * 冒泡排序：小数往左边排序
     */
    public static void bubbleSortLeft(int[] a){
        int flag=0;
        for(int i=0;i<a.length-1;i++){//一共n-1趟，剩余最后一个数时不用处理
            flag=0;
            for(int j=a.length-1;j>i;j-- ){
                if(a[j]<a[j-1]){
                    int temp = a[j];
                    a[j]=a[j-1];
                    a[j-1]= temp;
                    flag=1;
                }
            }
            if(flag==0)
                break;
        }
    }
    /**
     * 双向冒泡排序
     */
    public static void bubbleSort(int[] a){
        int l=0,r=a.length-1,s=0;
        while (l<r){
            for(int i=l;i<r;i++){
                if(a[i]>a[i+1]){
                    int t=a[i];
                    a[i]=a[i+1];
                    a[i+1]=t;
                    s=i;
                }
            }
            r=s;
            for(int i=r;i>l;i--){
                if(a[i]<a[i-1]){
                    int t=a[i];
                    a[i]=a[i-1];
                    a[i-1]=t;
                    s=i;
                }
            }
            l=s;
        }
    }
    /**
     * 快速排序:分割算法
     */
    public static int partition(int[] a,int low,int high){
        int key=a[low];
        while(low<high){
            while (low<high&&a[high]>=key)high--;
            a[low]=a[high];
            while (low<high&&a[low]<key)low++;
            a[high]=a[low];
        }
        a[low]=key;
        return low;
    }

    /**
     * 快速排序:分割算法
     */
    public static int partition2(int[] a,int low,int high){
        int key=a[high],i=low-1;
        for(int j=low;j<high;j++)
            if(a[j]<key){
                i++;
                int t=a[i];
                a[i]=a[j];
                a[j]=t;
            }
        a[high]=a[i+1];
        a[i+1]=key;
        return i+1;
    }
    public static void quickSort(int[] a,int low,int high){
        if(low<high){
            int loc = partition2(a,low,high);
            quickSort(a,low,loc-1);
            quickSort(a,loc+1,high);
        }
    }
    public static void quickSort2(int[] a,int low,int high){
        Stack<Integer> s = new Stack<Integer>();
        s.push(low);s.push(high);
        while (!s.isEmpty()){
            int h = s.pop(),l=s.pop();
            int loc = partition(a,l,h);
            if(loc+1<h){
                s.push(loc+1);
                s.push(h);
            }
            if(loc-1>l){
                s.push(l);
                s.push(loc-1);
            }
        }
    }
    public static void main(String[] args) {
        int[] a = {54,3,2,1,1,2,4,3,6,7};
//        bubbleSortRight(a);
//        bubbleSortLeft(a);
//        bubbleSort(a);
          quickSort2(a,0,a.length-1);

        print(a);
    }
    public static void print(int[] a){
        for (int i:a) {
            System.out.print(i+",");
        }
    }
}
