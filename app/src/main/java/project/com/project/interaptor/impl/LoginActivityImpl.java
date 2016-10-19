package project.com.project.interaptor.impl;

import project.com.project.interaptor.ILoginActivity;
import project.com.project.model.CustomerModel;
import project.com.project.service.ILoginActivityService;
import project.com.project.utils.Const;
import project.com.project.utils.RetrofitUtils;
import rx.Observable;

/**
 * Created by Administrator on 2016/6/26.
 */
public class LoginActivityImpl implements ILoginActivity{
    @Override
    public Observable<CustomerModel> login(String params) {
        return RetrofitUtils
                .getInstance()
                .retrofitCtreate(Const.URL.URL_LOGIN, ILoginActivityService.class)
                .login(params)
                ;
    }
}
