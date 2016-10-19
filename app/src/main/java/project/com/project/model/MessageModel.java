package project.com.project.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/6/8.
 */
public class MessageModel<T extends Object> implements Serializable {
    private T t;
    private T t2;
    private T t3;
    private T t4;
    private T t5;
    private T t6;
    private T t7;
    private T t8;

    public T getT() {
        return t;
    }

    public T getT2() {
        return t2;
    }

    public T getT3() {
        return t3;
    }

    public T getT4() {
        return t4;
    }

    public T getT5() {
        return t5;
    }

    public T getT6() {
        return t6;
    }

    public T getT7() {
        return t7;
    }

    public T getT8() {
        return t8;
    }

    public void setT(T t) {
        this.t = t;
    }

    public void setT2(T t2) {
        this.t2 = t2;
    }

    public void setT3(T t3) {
        this.t3 = t3;
    }

    public void setT4(T t4) {
        this.t4 = t4;
    }

    public void setT5(T t5) {
        this.t5 = t5;
    }

    public void setT6(T t6) {
        this.t6 = t6;
    }

    public void setT7(T t7) {
        this.t7 = t7;
    }

    public void setT8(T t8) {
        this.t8 = t8;
    }

    @Override
    public String toString() {
        return "MessageModel{" +
                "t=" + t +
                ", t2=" + t2 +
                ", t3=" + t3 +
                ", t4=" + t4 +
                ", t5=" + t5 +
                ", t6=" + t6 +
                ", t7=" + t7 +
                ", t8=" + t8 +
                '}';
    }
}
