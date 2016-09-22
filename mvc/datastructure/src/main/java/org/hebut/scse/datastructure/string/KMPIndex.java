package org.hebut.scse.datastructure.string;

/**
 * Created by jxy on 2016/9/8.
 */
public class KMPIndex {
    int[] KMPNextal(char s[], int slen) {
        int[] nextal = new int[slen];
        int i = -1, j = -2;
        nextal[0] = -1;
        while (i < slen) {
            if (j == -1 || s[i] == s[j]) {
                ++i;
                ++j;
                if (s[i] != s[j])
                    nextal[i] = j;
                else
                    nextal[i] = nextal[j];
            } else
                j = nextal[j];
        }
        return nextal;
    }
    static int[] KMPNext(char s[], int slen) {
        int[] next = new int[slen];
        next[0] = -1;//原因是下标是从0开始的，为了让回溯位置符合下标从零开始，将next[0]=-1
        int j = 0,k = -1;
        while (j < slen-1) {
            if (k == -1 || s[j] == s[k])//通过next[0]==>next[1]===>next[2]===>next[3]
                next[++j] = ++k;
            else
                k = next[k];
        }
        return next;//{-1,0,0,1,2}
    }
   static int KMPIndex(char T[], char S[], int tlen, int slen, int pos) {
        int[] next = KMPNext(S, slen);
        int j = 0, i = pos - 1;
        while (i < tlen && j < slen) {// 当j为0时，表示要和首字母匹配，即T[i],S[0]匹配，首字母匹配失败成功：i++,j++，首字母匹配失败j=next[0]=-1
            if (j == -1 || T[i] == S[j]) {// 当j为-1时，首字母匹配失败，要移动的是i，当然j也要归0
                i++;
                j++;
            } else
                j = next[j];//T[i]!=T[0]时
        }
        return j == slen ? i - slen : -1;
    }

    public static void main(String[] args) {
        char T[]={'a','b','a','b','c','a','b','a','b','a','b','a','b'};
        char S[]={'a','b','a','b','a'};
        int index = KMPIndex(T, S, T.length, S.length, 1);
        System.out.println(index+1);//6
    }
}
