package org.hebut.scse.datastructure.string.cases;

import java.util.*;

public class StringOperate {
    /**
     * 字符串反转
     * 基本思想：How are you--->you are How
     * 因为字符串中有空格所以要考虑到单词的问题
     * 1. 整体反转 uoy era woH
     * 2. 对单词反转 you are How
     */
    public static String reverseWords(String s) {
        char[] c = s.toCharArray();
        int b = 0, len = c.length;
        reverse(c, 0, len - 1);
        for (int i = 0; i < len; i++) {
            if (c[i] == ' ') {
                reverse(c, b, i - 1);
                b = i + 1;
            }
        }
        reverse(c, b, len - 1);
        return new String(c);

    }

    public static void reverse(char[] c, int low, int high) {
        while (low < high) {
            char t = c[low];
            c[low] = c[high];
            c[high] = t;
            low++;
            high--;
        }
    }

    /**
     * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
     * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，
     * 即“XYZdefabc”
     */
    public static String LeftRotateString(String str, int n) {
        if (str == null || str.length() < 1)
            return str;
        char[] c = str.toCharArray();
        reverse(c, 0, n - 1);
        reverse(c, n, c.length - 1);
        reverse(c, 0, c.length - 1);
        return new String(c);
    }

    /**
     * 判断两个字符串相同
     */
    public static boolean equals(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        byte[] b1 = s1.getBytes(), b2 = s2.getBytes();
        Arrays.sort(b1);
        Arrays.sort(b2);
        for (int i = 0; i < s1.length(); i++)
            if (b1[i] != b2[i])
                return false;
        return true;
    }

    /**
     * 删除字符串中重复字符-蛮力法
     * 示例：“google”---->”go\0\0le”--->gole  O(n*n)
     */
    public static String delDup(String s) {
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++)
            if (c[i] == '\0')
                continue;
            else {
                for (int j = i + 1; j < c.length; j++) {
                    if (c[j] == '\0')
                        continue;
                    if (c[i] == c[j])
                        c[j] = '\0';
                }
            }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c.length; i++)
            if (c[i] != '\0')
                sb.append(c[i]);
        return sb.toString();
    }

    public static String delDup2(String s) {
        char[] c = s.toCharArray();//ASCII中文为unicode
        int[] bitMap = new int[8];
        for (int i = 0; i < c.length; i++) {
            int index = c[i] / 32;
            int shift = c[i] % 32;
            if ((bitMap[index] & (1 << shift)) != 0)
                c[i] = '\0';
            bitMap[index] |= (1 << shift);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c.length; i++)
            if (c[i] != '\0')
                sb.append(c[i]);
        return sb.toString();
    }

    /**
     * 统计单词个数
     */
    public static int wordCount(String s) {
        int count = 0, word = 0;
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == ' ')
                word = 0;
            else if (word == 0) {
                word = 1;
                count++;
            }
        }
        return count;
    }

    /**
     * 字符串截取，不允许出现半个汉字
     */
    public static String truncateStr(String s, int n) {
        if (s == null | s.equals("") || n < 1)
            return "";
        char[] c = s.toCharArray();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c.length; i++) {
            if (count < n) {
                if (Character.valueOf(c[i]).toString().getBytes().length > 1) {//如果是汉字
                    if ((count + 1) == n)
                        return sb.toString();
                    count += 2;
                    sb.append(c[i]);
                } else {
                    count += 1;
                    sb.append(c[i]);
                }
            } else {
                return sb.toString();
            }
        }
        return sb.toString();
    }

    /**
     * 回溯法
     * 字符串全排列，仅仅交换不截取
     * 将字符串分为两部分：(begin),(begin+1,len-1),用后面部分和前面的交换
     * abc=>[abc, acb, bac, bca, cba, cab]
     */
    public static ArrayList<String> permutation(String s) {
        ArrayList<String> result = new ArrayList<String>();
        if (s == null || s.length() < 1)
            return result;
        permutation(s.toCharArray(), 0, result);
        return result;
    }

    private static void permutation(char[] c, int begin, ArrayList<String> result) {
        if (begin == c.length - 1) {
            String s = new String(c);
            if (!result.contains(s))
                result.add(s);
            return;
        }
        for (int i = begin; i < c.length; i++) {
            char t = c[i];
            c[i] = c[begin];
            c[begin] = t;
            permutation(c, begin + 1, result);
            t = c[i];
            c[i] = c[begin];
            c[begin] = t;
        }
    }

    /**
     * 求字符串的所有子集-回溯法
     * 在长度为n的字符串种，选取长度为m的字符串，m<=n
     */
    public static ArrayList<ArrayList<String>> subSet(String s) {
        ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
        ArrayList<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        char[] c = s.toCharArray();
        for (int i = 1; i <= c.length; i++) {
            subSet(c, 0, i, sb, result);
            results.add(result);
            result = new ArrayList<String>();
        }
        return results;
    }

    private static void subSet(char[] c, int begin, int m, StringBuilder sb, ArrayList<String> result) {
        if (m == 0) {
            result.add(sb.toString());
            return;
        }
        if (begin == c.length)
            return;
        sb.append(c[begin]);
        subSet(c, begin + 1, m - 1, sb, result);
        sb.deleteCharAt(sb.length() - 1);
        subSet(c, begin + 1, m, sb, result);
    }

    /**
     * 二进制组合方法：先求出有多少种组合，再解析组合
     */
    public static ArrayList<String> binSubSet(String s) {
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 1; i < (1 << s.length()); i++) {//0001~1111所有组合编码
            String sub = binSubSet(s.toCharArray(), i);
            result.add(sub);
        }
        return result;
    }

    //num编码解析为字符串
    public static String binSubSet(char[] c, int encode) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < c.length; i++)
            if ((encode & (1 << i)) != 0)
                sb.append(c[i]);
        return sb.toString();

    }

    /**
     * 字符串转换为整数
     * 字符串合法：输出整数,status=VALID
     * 字符不合法：输出0，status=INVALID
     */
    enum Status {
        INVALID, VALID
    }

    public static int StrToInt(String s) {
        //边界判断
        if (s == null || s.length() < 1)
            return 0;
        //初始值
        Status status = Status.INVALID;
        long num = 0L;
        char[] c = s.toCharArray();
        int i = 0, sign = 0;
        //确定符号
        sign = c[0] == '-' ? -1 : 1;
        if (c[0] == '-' || c[0] == '+')
            i++;
        //符号之后还有数字,计算数值
        while (i < c.length) {
            if (c[i] >= '0' && c[i] <= '9') {
                num = num * 10 + c[i] - '0';
                if ((sign > 0 && num > 0x7fffffff) || (sign < 0 && num < 0x80000000)) {
                    num = 0;
                    break;
                }
                i++;
            } else {
                num = 0;
                break;
            }
        }
        if (i == c.length) {
            status = Status.VALID;
            num = num * sign;
        }
        return (int) num;
    }

    /**
     * 判断数值
     * 字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
     * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是
     */
    public static boolean isNumeric(char[] c) {
        //边界判断
        if (c == null | c.length == 0)
            return false;
        int i = 0, numDot = 0, numE = 0;
        //符号判断
        if (c[i] == '-' || c[i] == '+')
            i++;
        while (i < c.length) {
            if (c[i] >= '0' && c[i] <= '9')
                i++;
            else if (c[i] == '.') {
                if (numE > 0)
                    return false;
                i++;
                numDot++;
            } else if (c[i] == 'e' || c[i] == 'E') {
                i++;
                numE++;
                if (i == c.length)
                    return false;
                if (c[i] == '-' || c[i] == '+')
                    i++;
                if (i == c.length)
                    return false;
            } else {
                return false;
            }
        }
        if (numDot > 1 || numE > 1)
            return false;
        return true;
    }

    /**
     * 字符串压缩
     * "aabcccccaaa"返回："a2b1c5a3"
     * "welcometonowcoderrrrr"返回："welcometonowcoderrrrr"
     */
    public static String countCompression(String str) {
        //边界判断
        if (str == null || str.isEmpty())
            return str;
        //初始变量
        int size = 0, count = 1, len = str.length();
        char[] c = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        //核心算法
        for (int i = 0; i < len - 1; i++) {
            if (c[i] == c[i + 1])
                count++;
            else {
                sb.append(c[i] + "" + count);
                size += 1 + String.valueOf(count).length();//加上词频前面的字符
                count = 1;//加上当前字符串
            }
        }
        size += 1 + String.valueOf(count).length();
        sb.append(c[c.length - 1] + "" + count);
        return sb.length() < str.length() ? sb.toString() : str;

    }

    /**
     * 一个字符串中的空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     */
    public static String replaceSpace(StringBuffer str) {
        //边界判断
        if (str == null || str.length() < 1)
            return str.toString();
        //变量初始
        int spaceCount = 0, newLen = 0;
        //字符串扩充
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == ' ')
                spaceCount++;
        newLen = str.length() + 2 * spaceCount;
        char[] c = Arrays.copyOf(str.toString().toCharArray(), newLen);
        //核心算法：从后往前替换
        int j = newLen - 1;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (c[i] == ' ') {
                c[j--] = '0';
                c[j--] = '2';
                c[j--] = '%';
            } else {
                c[j--] = c[i];
            }
        }
        return new String(c);
    }

    /**
     * 在一个字符串(1<=字符串长度<=10000，全部由大小写字母组成)中找到第一个只出现一次的字符,并返回它的位置
     */
    public static int FirstNotRepeatingChar(String str) {
        //边界判断
        if (str == null || str.length() < 1)
            return 0;
        int index;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++)
            if (map.containsKey(str.charAt(i))) {
                Integer count = map.get(str.charAt(i));
                count++;
                map.put(str.charAt(i), count);
            } else {
                map.put(str.charAt(i), 1);
            }
        for (int i = 0; i < str.length(); i++)
            if (map.get(str.charAt(i)) == 1)
                return i;
        return -1;
    }

    /**
     * 找出字符流中第一个只出现一次的字符
     */
    static LinkedHashMap<Character,Integer> map = new LinkedHashMap<Character,Integer>();
    public static void Insert(char ch) {
        if (map.containsKey(ch)) {
            map.put(ch, map.get(ch)+1);
        } else {
            map.put(ch, 1);
        }
    }
    public static char FirstAppearingOnce() {
        char c='#';
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            if(entry.getValue()==1){
                c=entry.getKey();
                break;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        //System.out.println(reverseWords("How are you"));
        //System.out.println(equals("123","123"));
//        System.out.println(delDup("google谷歌谷歌"));
//        System.out.println(wordCount("how Are you how"));
//        System.out.println(truncateStr("我ABC它",7));
//          System.out.println(permutation("abc"));
//        System.out.println(subSet("abcdef"));
//        System.out.println(binSubSet("abcd"));
//        System.out.println(isNumeric("12e+".toCharArray()));
//        System.out.println(countCompression("aabcccccaaab"));
        System.out.println(replaceSpace(new StringBuffer("a c f g")));
    }

}
