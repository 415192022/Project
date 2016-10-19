package project.com.project.model.base;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LMW on 2016/6/7.
 */
public class BaseModel<T> implements Serializable{
    private boolean result;
    private List<T> datalist;

    public boolean isResult() {
        return result;
    }

    public List<T> getDatalist() {
        return datalist;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public void setDatalist(List<T> datalist) {
        this.datalist = datalist;
    }

    @Override
    public String toString() {
        return "BaseModel{" +
                "result=" + result +
                ", datalist=" + datalist +
                '}';
    }
}
