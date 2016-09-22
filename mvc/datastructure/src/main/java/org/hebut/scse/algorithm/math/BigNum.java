package org.hebut.scse.algorithm.math;

import java.math.BigInteger;

/**
 * Created by jxy on 2016/9/18.
 */
public class BigNum {
    /**
     * Java中long类型可以表示 -9,223,372,036,854,775,808（即-2^64）到9,223,372,036,854,775,807（即2^64-1）范围内的整数
     * 有的时候我们希望能够处理在此范围之外的整数,比如求阶乘n!,20!就已经超过了long的表示范围所以此时可以采用BigInteger来实现
     * BigInteger通过字节数组来表示一个大数，通过字符串来初始化话一个大数
     * private byte[] digits;
     * public BigInteger(byte[] digits) {
     * this.digits = digits;
     * }
     * public BigInteger(String numberStr) {
     *
     * }
    */
    public static BigInteger getFactorial(long n){
        BigInteger sum = new BigInteger(String.valueOf(n));
        for(long i=1;i<=n;i++)
            sum=sum.multiply(BigInteger.valueOf(i));
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(getFactorial(30));
    }

}
