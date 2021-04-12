/**
 *
 @author @FrozenLemonTee https://github.com/FrozenLemonTee
 @date 2021/04/01
 @encoding UTF-8
 **/
package DSAA.alg4.c1.InToPost_c16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;

public class parseInfix {
    /**
     * @see parsePostFix#isNum(String)
     * **/
    private static boolean isNum(String s){
        return parsePostFix.isNum(s);
    }

    /**
     * @see parsePostFix#isOperator(String)
     * **/
    private static boolean isOperator(String o){
        return parsePostFix.isOperator(o);
    }

    /**
     * 判断前者运算符的运算优先级是否大于后者
     * @param a String: 待判断运算符a
     * @param b String: 待判断运算符b
     *
     * @return boolean: 返回是/否
     * **/
    private static boolean isHigherPriority(String a, String b){
        HashMap<String, Integer> map = new HashMap<String, Integer>(){{
            put("+", 1); put("-", 1); put("*", 2); put("/", 2);
        }};
        return map.get(a) > map.get(b);
    }

    /**
     * 判断运算符是否可以入栈（注意判空，否则报IndexOutOfBoundsException异常）
     * @param o String: 待判断操作符
     * @param stack ArrayList<String>: 待判断栈
     *
     * @return boolean: 返回是/否
     * **/
    private static boolean canPush(String o, ArrayList<String> stack){
        if (stack.size() == 0){
            return true;
        }
        String end = stack.get(stack.size() - 1);
        if (!isOperator(end)){
            return true;
        }
        return isHigherPriority(o, end);
    }

    /**
     * 判断括号内所有操作符是否尚未完全出栈完毕
     * @param stack ArrayList<String>: 待判断栈
     *
     * @return boolean: 返回是/否
     * **/
    private static boolean canPop(ArrayList<String> stack){
        return !Objects.equals(stack.get(stack.size() - 1), "(");
    }

    /**
     * 中序表达式转后序表达式，以方便最终解析
     * @param inFix String: 待转换的中序表达式
     *
     * @return String: 返回转换后得到的后序表达式
     * **/
    public static String inToPost(String inFix){
        String[] split = inFix.split(" ");
        ArrayList<String> res = new ArrayList<>();
        ArrayList<String> stack = new ArrayList<>();
        for (String s: split){
            if (isNum(s)){
                res.add(s);
            } else if (Objects.equals(s, "(")){
                stack.add(s);
            } else if (isOperator(s)){
                while (!canPush(s, stack)){
                    res.add(stack.remove(stack.size() - 1));
                }
                stack.add(s);
            } else {
                ArrayList<String> tmp = new ArrayList<>();
                while (canPop(stack)){
                    tmp.add(stack.remove(stack.size() - 1));
                }
                stack.remove(stack.size() - 1);
                Collections.reverse(tmp);
                res.addAll(tmp);
            }
        }
        Collections.reverse(stack);
        res.addAll(stack);
        StringBuilder sb = new StringBuilder();
        for (String ss: res){
            sb.append(ss).append(" ");
        }
        return sb.toString();
    }
}
