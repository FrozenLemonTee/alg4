/**
 *
 @author @FrozenLemonTee https://github.com/FrozenLemonTee
 @date 2021/04/01
 @encoding UTF-8
 **/
package DSAA.alg4.c1.InToPost_c16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class parsePostFix {
    /**
     * 判断字符串是否是数字（包括两位数及以上的）
     * @param n String: 待判断字符串
     *
     * @return boolean: 返回是/否
     * **/
    public static boolean isNum(String n){
        return Character.isDigit(n.charAt(n.length() - 1));
    }

    /**
     * 判断字符串是否是运算符
     * @param o String: 待判断字符串
     *
     * @return boolean: 返回是/否
     * **/
    public static boolean isOperator(String o){
        HashSet<Character> set
                = new HashSet<Character>() {{add('+'); add('-'); add('*'); add('/');}};
        return set.contains(o.charAt(o.length() - 1));
    }

    /**
     * 转义函数，用于解析算式
     * @param num1 int: 数字num1
     * @param num2 int: 数字num2
     * @param operator String: 操作符operator
     *
     * @return String: 解析算式并算出结果后，以字符串的形式返回
     * **/
    private static String eval(String num1, String num2, String operator){
        HashMap<String, String> map
                = new HashMap<String, String>()
        {{  put("+", "" + (Integer.parseInt(num1) + Integer.parseInt(num2)));
            put("-", "" + (Integer.parseInt(num1) - Integer.parseInt(num2)));
            put("*", "" + (Integer.parseInt(num1) * Integer.parseInt(num2)));
            put("/", "" + (Integer.parseInt(num1) / Integer.parseInt(num2)));
        }};
        return map.get(operator);
    }

    /**
     * 辅助函数，私有，用于方法{@see #evalPostFix()}中控制进入更新临时栈的代码块
     * @param n ArrayList<String>: 数字栈n
     * @param o ArrayList<Character>: 运算符栈o
     *
     * @return boolean: 返回是/否
     * **/
    private static boolean isOperable(ArrayList<String> n, ArrayList<String> o){
        return !(n.size() < 2 || o.size() < 1);
    }

    /**
     * 解析后序表达式
     * @param postFix String: 待解析的后序表达式
     *
     * @return int: 解析后的结果以整型返回
     * **/
    public static int evalPostFix(String postFix){
        try {
            String[] tmp = postFix.split(" ");
            ArrayList<String> nums = new ArrayList<>();
            ArrayList<String> operators = new ArrayList<>();
            for (String s : tmp) {
                if (isNum(s)) {
                    nums.add(s);
                } else if (isOperator(s)) {
                    operators.add(s);
                }
                while (isOperable(nums, operators)) {
                    String num1 = nums.remove(nums.size() - 1);
                    String num2 = nums.remove(nums.size() - 1);
                    nums.add(eval(num2, num1, operators.remove(operators.size() - 1)));
                }
            }
            return Integer.parseInt(nums.get(nums.size() - 1));
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        return 0;
    }
}
