package org.hebut.scse.algorithm.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jxy on 2016/9/18.
 */
public class Arithmetic {
    /**
     * greatest common divisor GCD
     * （1）最大公约数（最大公因数）：几个数公有的因数中最大的一个，例12与18
     * 12的因数有1,12,2,6,3,4
     * 18的因数有1,18,2,9,6,3
     * 公有的因数有1,2,3,6
     * 所以6就是12与18的最大公约数.
     * least common multiple LCM
     *（2）最小公倍数：几个数公有的倍数中最小的一个，例4和6
     *  4的倍数有4,8,12,16,20,24,……
     *  6的倍数有6,12,18,24,……
     *  4和6 公倍数 12,18……,
     *  所以4和6的最小公倍数是12 .
     *  最小公倍数=两整数的乘积÷最大公约数
     */
    /*
     * 欧几里德算法又称辗转相除法，用于计算两个整数a,b的最大公约数。其计算原理依赖于下面的定理：
     * 定理：gcd(a,b) = gcd(b,a mod b)
     * http://www.360doc.com/content/15/0616/20/12129652_478588868.shtml
     */
    public static int gcd(int a,int b){
        while(b!=0){
            int c = a%b;
            a=b;
            b=c;
        }
        return a;
    }

    public static int lcm(int a,int b){
        return (a*b)/gcd(a,b);
    }
    /**
     * 分数化简
     * 首先你要求出 a , b 的最大公约数
     * 然后约除公约数就是最简
     * a:30
     * b:25
     * b/a
     */
    public static void simpleFraction(int a,int b){
        int gcd = gcd(a,b);
        System.out.println(b/gcd+"/"+a/gcd);
    }

    /**
     * 求素数（质数）
     * 只能被1或者本身整除的数
     * http://blog.csdn.net/xuyang1205/article/details/3481258
     * 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97
     */
    public static boolean isPrime(int n){
        if(n<2)
            return false;
        if(n==2)
            return true;
        for(int i=2;i<=Math.sqrt(n);i++)
            if(n%i==0)
                return false;
        return true;//i>Math.sqrt(n)
    }
    public static List<Integer> getPrime(int n){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=2;i<=n;i++)
            if(isPrime(i))
                list.add(i);
        return list;
    }
    public static int calPrime(int n){
        if(n<=1){
            return 0;
        }
        byte[] origin = new byte[n+1];
        int count = 0;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(origin[i] == 0){
                count++;
                int k = 2;
                while(i*k<=n){
                    origin[i*k] = 1;
                    k++;
                }
            }else{
                continue;
            }
        }
        return count;
    }

    /**
     * 水仙花数
     * 1^3 + 5^3+ 3^3 = 153
     */
    private static int suixianhua(int num) {
        int mod =0,ans=0;
        while(num>0){
            mod = num%10;
            ans  += mod *mod *mod;
            num /= 10;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(gcd(12,18)+":"+lcm(4,6));
        simpleFraction(30,25);
        System.out.println(calPrime(1000000000));
    }

}
