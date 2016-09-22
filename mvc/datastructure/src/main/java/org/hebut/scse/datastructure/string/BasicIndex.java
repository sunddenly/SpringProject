package org.hebut.scse.datastructure.string;

/**
 * Created by jxy on 2016/9/8.
 */
public class BasicIndex {
    /**
     * 检测从主串T的pos位置开始，是否有和子串S匹配,如果有返回匹配开始位置，如果没有，返回-1
        T:主串,i,i=i-j+1
        S:子串,j
        tlen:主串长度
        slen:子串长度
        pos:主串开始位置
    */
    public static  int Index(char T[], char S[], int tlen, int slen, int pos) {
        int j = 0, i = pos-1;
        while (i < tlen && j < slen) {
            if (T[i] == S[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        return j == slen ? i - slen : -1;
    }

    public static void main(String[] args) {
        char T[]={'a','b','a','b','c','a','b','a','b','a','b','a','b'};
        char S[]={'a','b','a','b','a'};
        int index = Index(T, S, T.length, S.length, 1);
        System.out.println(index+1);//6
    }
}
