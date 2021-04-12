/**
 *
 @author @FrozenLemonTee https://github.com/FrozenLemonTee
 @date 2021/03/31
 @encoding UTF-8
 **/
package DSAA.alg4.c1.leftBracketAdd_c17;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class leftBracketAdd {
    /** 动态字符数组，方便插入括号 **/
    ArrayList<Character> p;
    /** 所有符合条件的运算符集合 **/
    HashSet<Character> set =
            new HashSet<Character>(){{add('+'); add('-'); add('*'); add('/');}};

    /**
     * 构造函数，传入待判断的字符串
     * @param p String: 待判断的字符串
     * **/
    public leftBracketAdd(String p){
        this.p = new ArrayList<>();
        for (char c: p.toCharArray()){
            this.p.add(c);
        }
    }

    /**
     * 转义函数，私有，用于解析算式
     * @param a int: 数字a
     * @param b int: 数字b
     * @param o Character: 操作符o
     *
     * @return String: 解析算式并算出结果后，以字符串的形式返回
     * **/
    public String eval(int a, int b, Character o){
        HashMap<Character, Integer> cases
                = new HashMap<Character, Integer>()
                {{put('+', a + b); put('-', a - b); put('*', a * b); put('/', a / b);}};
        return cases.get(o) + "";
    }

    /**
     * 辅助函数，私有，用于方法{@see #addLeftBracket()}中控制进入更新临时栈的代码块
     * @param num ArrayList<String>:
     * @see #addLeftBracket()
     * @param operator ArrayList<Character>:
     * @see #addLeftBracket()
     * @param flag int:
     * @see #addLeftBracket()
     *
     * @return boolean: 返回是/否
     * **/
    private boolean isOperable(ArrayList<String> num, ArrayList<Character> operator, int flag){
        if (flag != 3){
            return false;
        }
        return num.size() >= 3 && Objects.equals(num.get(num.size() - 3), ")") &&
                Character.isDigit(num.get(num.size() - 1).charAt(num.get(num.size() - 1).length() - 1)) &&
                Character.isDigit(num.get(num.size() - 2).charAt(num.get(num.size() - 2).length() - 1)) &&
                operator.size() >= 1;
    }

    /**
     * 补全原中缀表达式中缺失的左括号
     * @return String: 补全以后返回字符串形式
     * **/
    public String addLeftBracket(){
        ArrayList<String> num = new ArrayList<>();
        ArrayList<Character> operator = new ArrayList<>();
        int flag = 0;
        for (int i = this.p.size() - 1; i >= 0; i -= 1){
            if (this.p.get(i) == ')'){
                num.add(")");
                flag = 0;
                continue;
            }
            if (Character.isDigit(this.p.get(i))){
                num.add(this.p.get(i) + "");
                if (flag == 0 || flag == 2){
                    flag += 1;
                }
            } else if (this.set.contains(this.p.get(i))){
                operator.add(this.p.get(i));
                if (flag == 1){
                    flag += 1;
                }
            }
            while (this.isOperable(num, operator, flag)){
                this.p.add(i, '(');
                int a = Integer.parseInt("" + num.remove(num.size() - 1));
                int b = Integer.parseInt("" + num.remove(num.size() - 1));
                num.remove(num.size() - 1);
                num.add(this.eval(a, b, operator.remove(operator.size() - 1)));
            }
        }
        StringBuilder s = new StringBuilder();
        for (Character c: this.p){
            s.append(c);
        }
        return s.toString();
    }
}
