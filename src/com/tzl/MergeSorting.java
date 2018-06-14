package com.tzl;

/**
 * Created by tzl on 2018/6/13.
 */
public class MergeSorting {
    public static int[] aux;
    public static void main(String[] args){
        int[] arr = new int[10000000];
        aux = new int[arr.length];
        System.out.print("排序前的数组：");
        for (int i = 0; i<10000000;i++){
            arr[i] = (int) (Math.random()*10000000);
            System.out.print(arr[i]+"\t");
        }
        System.out.println("");
        long curTime = System.currentTimeMillis();
        mergeSort(arr,0,arr.length-1);
        double tiem = (System.currentTimeMillis() - curTime)/1000;
        System.out.println("用时：" + tiem + "s");

        for (int i = 0; i<10000000;i++){
            System.out.print(arr[i]+"\t");
        }
    }

    public static void mergeSort(int[] arg,int lo,int hi){
        if(lo >= hi) return;//当lo >= hi时返回，此时已经分割成 单个数
        int mid = lo + (hi - lo)/2;
        mergeSort(arg,lo,mid);//递归切割
        mergeSort(arg,mid+1,hi);//递归切割
        merge(arg,lo,mid,hi);//一层一层的再合并上去
    }

    public static void merge(int[] arg,int lo, int mid, int hi){
        int j = lo;
        int k = mid+1;

        for (int i=lo;i<=hi;i++){
            aux[i] = arg[i];
        }
        for (int h=lo;h<=hi;h++){
            if (j > mid) arg[h] = aux[k++];//如果j大于中间值，说明前半段已经完成排序，直接插入后半段就ok
            else if (k > hi) arg[h] = aux[j++];//如果k大于最大下标（hi），说明后半段排序完成，直接插入前半段就行
            else if (aux[j] > aux[k]) arg[h] = aux[k++];//谁小插入谁
            else arg[h] = aux[j++];
        }

    }
}
