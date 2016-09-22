package org.hebut.scse.algorithm.sort;

/**
 * Created by jxy on 2016/9/17.
 */
public class SelectSort {
    public static void selectSort(int[] a){
        for(int i=0;i<a.length-1;i++){
            int min=a[i],pos=i;
            for(int j=i+1;j<a.length;j++){
                if(a[j]<min){
                    min=a[j];
                    pos=j;
                }
            }
            if(pos!=i){
                a[pos]=a[i];
                a[i]=min;
            }
        }
    }
    public static void heapSort(int[] a){
        for(int i=(a.length-1)/2;i>=0;i--)
            adjustMaxHeapDown(a,i,a.length-1);
        for(int i=a.length-1;i>=0;i--){
            int t=a[i];
            a[i]=a[0];
            a[0]=t;
            adjustMaxHeapDown(a,0,i-1);
        }
    }
    public static void adjustMaxHeapDown(int[] a,int begin,int end){
        int key=a[begin],s=begin,c=2*s+1;
        while(c<=end){
            if(c<end&&a[c]<a[c+1])
                c++;
            if(a[c]>key) {
                a[s] = a[c];
                s = c;
            }
            else
                break;
        }
        a[s]=key;
    }
    public static void main(String[] args) {
        int[] a = {54,3,2,1,1,2,4,3,6,7};
//        selectSort(a);
        heapSort(a);
        print(a);
    }
    public static void print(int[] a){
        for (int i:a) {
            System.out.print(i+",");
        }
    }
}
