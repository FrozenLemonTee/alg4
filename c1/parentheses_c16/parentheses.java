/**
 *
 @author @FrozenLemonTee https://github.com/FrozenLemonTee
 @date 2021/03/30
 @encoding UTF-8
 **/
package DSAA.alg4.c1.parentheses_c16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class parentheses {
    /** 接收的待判断字符串 **/
    String p;
    /** 哈希表：包含所有左括号 **/
    HashSet<Character> set = new HashSet<Character>(){{add('{'); add('['); add('(');}};
    /** 哈希图： 键包含所有右括号，对应的值为对应的匹配左括号 **/
    HashMap<Character, Character> cp =
            new HashMap<Character, Character>(){{put(']', '['); put(')', '('); put('}', '{');}};

    /**
     * 构造函数，接收待判断字符串
     * @param p String: 待判断字符串
     * **/
    public parentheses(String p){
        this.p = p;
    }

    /**
     * 判断字符串的括号是否都匹配
     * @return bool: 返回是/否
     * **/
    public boolean isMatch(){
        ArrayList<Character> tmp = new ArrayList<>();
        for (int i = 0; i < this.p.length(); i += 1){
            Character c = this.p.charAt(i);
            if (!this.set.contains(c) && !this.cp.containsKey(c)){
                return false;
            }
            if (this.set.contains(c)){
                tmp.add(c);
            }else {
                if (this.cp.get(c) == tmp.get(tmp.size() - 1)){
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
        return tmp.size() == 0;
    }
}
