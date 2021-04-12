/**
 *
 @author @FrozenLemonTee https://github.com/FrozenLemonTee
 @date 2021/03/29
 @encoding UTF-8
 **/
package DSAA.alg4.c1.visualCouter_c15;

import DSAA.alg4.c1.point2D_c11.point2D;
import standard.StdDraw;

public class visualCounter {
    /** 计数器计数次数上限 **/
    int N_max;
    /** 计数器绝对值上限 **/
    int value_max;
    /** 计数器当前计数次数 **/
    int n;
    /** 计数器当前值 **/
    int value;

    /**
     * 判断当前计数次数是否达到了上限
     * @return boolean: 返回是/否
     * **/
    public boolean isMAX_N(){
        return this.n >= this.N_max;
    }

    /**
     * 计数器的字符串表现形式（重载）
     * @return String：打印当前计数器各属性值
     * **/
    @Override
    public String toString() {
        return "visualCounter #" + this.hashCode() + "{count: "
                + this.n + "/" + this.N_max + ", " + "value: "
                + this.value + ", value_limit: ±" + this.value_max + "}";
    }

    /**
     * 计数器的构造函数
     * @param N_max int: 指定该计数器的计数次数上限
     * @param value_max int: 指定该计数器的绝对值上限
     * **/
    public visualCounter(int N_max, int value_max){
        this.N_max = N_max;
        this.value_max = value_max;
        this.n = 0;
        this.value = 0;
        this.initDraw();
    }

    /**
     * @see DSAA.alg4.c1.point2D_c11.point2D#initDraw(double, double, double, double, double)
     * **/
    private void initDraw(){
        point2D.initDraw(-this.value_max*1.2, this.value_max*1.2,
                -this.value_max*1.2, this.value_max*1.2, 0.01);
    }

    /**
     * 计数器值加一
     * **/
    private void plus(){
        if (this.n < this.N_max){
            this.n += 1;
            if (this.value < this.value_max){
                this.value += 1;
            }
        }
    }

    /**
     * 计数器值减一
     * **/
    private void minus(){
        if (this.n < this.N_max){
            this.n += 1;
            if (this.value > -this.value_max){
                this.value -= 1;
            }
        }
    }

    /**
     * 处理输入的字符串作为操作指令，控制计数器加减
     * @param c String: 操作指令串
     * **/
    public void switches(String c){
        switch (c){
            case "+":
                this.plus();
                break;
            case "-":
                this.minus();
                break;
            default:
                break;
        }
    }

    /**
     * 可视化计数器的值
     * **/
    public void show(){
        StdDraw.clear();
        if (this.value != 0){
            StdDraw.line(0, 0, this.value, 0);
        }
    }
}
