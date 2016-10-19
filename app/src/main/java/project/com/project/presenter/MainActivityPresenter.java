package project.com.project.presenter;

import project.com.project.interaptor.impl.MainActivityInterapterImpl;
import project.com.project.model.DataListModel;
import project.com.project.model.DepartmentModel;
import project.com.project.model.PersonModel;
import project.com.project.view.IMainActivityView;
import rx.functions.Action1;

/**
 * Created by LMW on 2016/6/7.
 */
public class MainActivityPresenter {
    private static MainActivityPresenter mainActivityPresenter;
    private MainActivityInterapterImpl mainActivityInterapter;
    private IMainActivityView iMainActivityView;

    private MainActivityPresenter(IMainActivityView iMainActivityView) {
        this.iMainActivityView = iMainActivityView;
        mainActivityInterapter = new MainActivityInterapterImpl();
    }

    public static MainActivityPresenter getInstance(IMainActivityView iMainActivityView) {
        if (mainActivityPresenter == null) {
            synchronized (MainActivityPresenter.class) {
                if (mainActivityPresenter == null)
                    mainActivityPresenter = new MainActivityPresenter(iMainActivityView);
            }
        }
        return mainActivityPresenter;
    }
    //获得部门下人员信息
    public void getPerson(String deptCode) {
        mainActivityInterapter
                .getPerson(deptCode)
                .subscribe(new Action1<PersonModel>() {
                    @Override
                    public void call(PersonModel personModel) {
                        iMainActivityView.getUser(personModel);
                    }
                });
    }
    //获得人员计划
    public void getDataList(String plantType, String time, String empCode) {
        mainActivityInterapter
                .getDataList(plantType, time, empCode)
                .subscribe(new Action1<DataListModel>() {
                    @Override
                    public void call(DataListModel dataListModel) {
                        iMainActivityView.getDataList(dataListModel);
                    }
                });
    }

    //获得部门
    public void getDepartment(String empCode, String compCode){
        mainActivityInterapter
                .getDepartment(empCode,compCode)
                .subscribe(new Action1<DepartmentModel>() {
                    @Override
                    public void call(DepartmentModel departmentModel) {
                        iMainActivityView.getDepartment(departmentModel);
                    }
                })
                ;
    }

    public void login(){

    }

}
