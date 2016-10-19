package project.com.project.presenter;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.google.gson.Gson;

import project.com.project.interaptor.impl.LoginActivityImpl;
import project.com.project.model.CustomerModel;
import project.com.project.view.ILoginActivityView;
import project.com.project.view.IMainActivityView;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/6/26.
 */
public class LoginActivityPresenter {
    private ILoginActivityView iLoginActivityView;
    private LoginActivityImpl loginActivity;
    private static LoginActivityPresenter loginActivityPresenter;
    private LoginActivityPresenter(ILoginActivityView iLoginActivityView){
        this.iLoginActivityView=iLoginActivityView;
        loginActivity=new LoginActivityImpl();
    }
    public static LoginActivityPresenter getInstance(ILoginActivityView iLoginActivityView){
        if(loginActivityPresenter==null){
           synchronized (LoginActivityPresenter.class){
               if(loginActivityPresenter==null){
                   loginActivityPresenter=new LoginActivityPresenter(iLoginActivityView);
               }
           }
        }
        return loginActivityPresenter;
    }

    public void login(CustomerModel customerModel){
        loginActivity
                .login(new Gson().toJson(loginActivity))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<CustomerModel>() {
                    @Override
                    public void call(CustomerModel customerModel) {
                        iLoginActivityView.login(customerModel);
                    }
                })
        ;
    }
}
