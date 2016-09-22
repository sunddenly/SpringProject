package org.hebut.scse.algorithm.sort;

/**
 * Created by jxy on 2016/9/17.
 */
public class MergeSort {
    public static void merge(int[] a,int low,int mid,int high){
        int h1=mid,l1=low;
        int h2=high,l2=mid+1,k=0;
        int[] temp = new int[high-low+1];
        while(l1<=h1&&l2<=h2){
            if(a[l1]<=a[l2])
                temp[k++]=a[l1++];
            else
                temp[k++]=a[l2++];
        }
        while(l1<=h1)
            temp[k++]=a[l1++];
        while(l2<=h2)
            temp[k++]=a[l2++];
        System.arraycopy(temp,0,a,low,high-low+1);
    }
    public static void merge2(int[] a,int low,int mid,int high){
        for(int i=0;i<mid+1;i++)
            if(a[i]>a[mid+1]){
                int t=a[i];
                a[i]=a[mid+1];
                a[mid+1]=t;
                sort(a,mid+1,high);
            }
    }

    private static void sort(int[] a, int begin,int end) {
        for(int i=begin;i<end;i++){
            if(a[i]>a[i+1]){
                int t=a[i];
                a[i]=a[i+1];
                a[i+1]=t;
            }
        }
    }
    public static void mergeSort(int[] a,int low,int high){
        if(low<high){
            int mid = (low+high)/2;
            mergeSort(a,low,mid);
            mergeSort(a,mid+1,high);
            merge2(a,low,mid,high);
        }
    }
    public static void mergeSort(int[] a,int len){
        int steps = (int) Math.ceil(Math.log(len)/Math.log(2));
        for(int i=1;i<=steps;i++){
            int h=(int)Math.pow(2,i);
            for(int low=0;low<len-1;low+=h){
                int mid = low+h/2-1;
                if(mid<len-1){
                    int high=low+h-1;
                    if(high>len-1)
                        high=len-1;
                    merge(a,low,mid,high);
                }
            }

        }
    }
    public static void main(String[] args) {
        int[] a={1,3,5,2,4,6};
        //merge2(a,0,(a.length-1)/2,a.length-1);
//        mergeSort(a,0,a.length-1);
        mergeSort(a,a.length);
        print(a);
    }
    public static void print(int[] a){
        for (int i:a) {
            System.out.print(i+",");
        }
    }
}
