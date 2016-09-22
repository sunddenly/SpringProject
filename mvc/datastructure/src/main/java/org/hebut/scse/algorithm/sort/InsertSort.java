package org.hebut.scse.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jxy on 2016/9/17.
 */
public class InsertSort {
    //直接插入
    public static void insertSort(int[] a){
        for(int i=1;i<a.length;i++){
            int key=a[i],j=i;
            if(a[j-1]>key){
                while(j>=1&&a[j-1]>key){
                    a[j]=a[j-1];
                    j--;
                }
            }
            a[j]=key;
        }
    }
    //希尔插入
    public static void shellSort(int[] a){
        for(int h=a.length/2;h>0;h/=2){
            for(int i=h;i<a.length;i++){
                int key=a[i],j=i;
                if(a[j-h]>key){
                    while(j-h>=0&&a[j-h]>key){
                        a[j]=a[j-h];
                        j-=h;
                    }
                }
                a[j]=key;
            }
        }
    }
    //折半插入
    public static void binInsertSort(int[] a){
        for(int i=1;i<a.length;i++){
            int key=a[i];
            int s=binSearch(a,key,0,i-1);
            for(int j=i;j>s;j--)
                a[j]=a[j-1];
            a[s]=key;
        }

    }
    public static int binSearch(int[] a,int key,int low,int high){
        while(low<=high){
            int mid = (low+high)/2;
            if(a[mid]<=key)
                low = mid+1;
            else
                high = mid-1;
        }
        return high+1;
    }
    public static void main(String[] args) {
        int[] a = {54,3,2,1,1,2,4,3,6,7};
        //insertSort(a);
        binInsertSort(a);
//        shellSort(a);
        print(a);
    }
    public static void print(int[] a){
        for (int i:a) {
            System.out.print(i+",");
        }
    }
}
