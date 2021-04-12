/**
 *
 @author @FrozenLemonTee https://github.com/FrozenLemonTee
 @date 2021/03/29
 @encoding UTF-8
 **/
package DSAA.alg4.c1.circular_c14;

import java.util.Objects;

public class circular {
    /**
     * 判断两个字符串是否是<b>特定长度<b/>变换下的回环变位字符串
     * @param s1 String: 待判断字符串1
     * @param s2 String: 待判断字符串2
     * @param rotation int: 变位长度
     *
     * @return int: 返回布尔值<b>是<b/>/<b>否<b/>
     * **/
    public static boolean isCircularRotation(String s1, String s2, int rotation){
        if (s1.length() != s2.length()){
            return false;
        }
        rotation %= s1.length();

        // O(n)的时间复杂度

//        for (int i = 0; i < s1.length(); i += 1){
//            if (s1.indexOf(i) != s2.indexOf((i + rotation) % s1.length())){
//                return false;
//            }
//        }
//        return true;

        // O(1)的时间复杂度
        return Objects.equals(s1, s2.substring(rotation) + s2.substring(0, rotation));
    }

    /**
     * 判断两个字符串是否是回环变位字符串（任意长度的变换符合要求皆可）
     * @param s1 String: 待判断字符串s1
     * @param s2 String: 待判断字符串s2
     *
     * @return int: 返回布尔值<b>是<b/>/<b>否<b/>
     * **/
    public static boolean isCircularString(String s1, String s2){
        if (s1.length() != s2.length()){
            return false;
        }
        for (int i = 0; i < s1.length() - 1; i += 1){
            if (isCircularRotation(s1, s2, i)){
                return true;
            }
        }
        return s1.length() == 0;
    }
}
