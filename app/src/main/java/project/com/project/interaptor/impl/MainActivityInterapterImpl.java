package project.com.project.interaptor.impl;

import project.com.project.interaptor.IMainActivityInterapter;
import project.com.project.model.DataListModel;
import project.com.project.model.DepartmentModel;
import project.com.project.model.PersonModel;
import project.com.project.service.IMainActivityService;
import project.com.project.utils.Const;
import project.com.project.utils.RetrofitUtils;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by LMW on 2016/6/7.
 */
public class MainActivityInterapterImpl implements IMainActivityInterapter{
    @Override
    public Observable<PersonModel> getPerson(String deptCode) {
        return RetrofitUtils
                .getInstance()
                .retrofitCtreate(Const.URL.URL_BASE,IMainActivityService.class)
                .getPerson(deptCode)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                ;
    }

    @Override
    public Observable<DepartmentModel> getDepartment(String empCode, String compCode) {
        return RetrofitUtils
                .getInstance()
                .retrofitCtreate(Const.URL.URL_BASE,IMainActivityService.class)
                .getDepartment(empCode,compCode)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                ;
    }

    @Override
    public Observable<DataListModel> getDataList(String plantType, String time, String empCode) {
        return RetrofitUtils
                .getInstance()
                .retrofitCtreate(Const.URL.URL_BASE,IMainActivityService.class)
                .getDataList(plantType,time,empCode)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                ;
    }
}
