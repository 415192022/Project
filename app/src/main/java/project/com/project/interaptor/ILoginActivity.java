package project.com.project.interaptor;

import project.com.project.model.CustomerModel;
import rx.Observable;

/**
 * Created by Administrator on 2016/6/26.
 */
public interface ILoginActivity {
    Observable<CustomerModel> login(String params);
}
