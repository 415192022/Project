package project.com.project.view.activity;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import project.com.project.R;
import project.com.project.model.DataListModel;
import project.com.project.model.DepartmentModel;
import project.com.project.model.MessageModel;
import project.com.project.model.PersonModel;
import project.com.project.presenter.MainActivityPresenter;
import project.com.project.utils.RxBusUtil;
import project.com.project.view.IMainActivityView;
import project.com.project.view.adapter.MAdatpter;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 *
 */
public class MainActivity extends AppCompatActivity implements IMainActivityView, View.OnClickListener {
    MainActivityPresenter mainActivityPresenter;
    LinearLayout ll_list_root;
    ListView rv_child;
    ListView lv_last;
    Button btn_department;
    Button btn_person;
    MAdatpter adapter;


    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("onRestart");
        Toast.makeText(this, "onRestart", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show();
        setContentView(R.layout.layout_activity);
        RxBusUtil.getDefault().register(this);
        mainActivityPresenter = MainActivityPresenter.getInstance(this);
        ll_list_root = (LinearLayout) findViewById(R.id.ll_list_root);
        rv_child = (ListView) findViewById(R.id.rv_child);
        lv_last = (ListView) findViewById(R.id.lv_last);
        adapter = MAdatpter.getInstance(this);
        rv_child.setAdapter(adapter);
        btn_department = (Button) findViewById(R.id.btn_department);
        btn_person = (Button) findViewById(R.id.btn_person);
        btn_department.setOnClickListener(this);
        btn_person.setOnClickListener(this);
    }

    //获得部门下人员信息
    @Override
    public void getUser(PersonModel personModel) {
        adapter.clearData();
        Observable.from(personModel.getDatalist())
                .flatMap(new Func1<PersonModel.ChildOfPersonModel, Observable<PersonModel.ChildOfPersonModel>>() {
                    @Override
                    public Observable<PersonModel.ChildOfPersonModel> call(PersonModel.ChildOfPersonModel childOfPersonModel) {
                        return Observable.just(childOfPersonModel);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<PersonModel.ChildOfPersonModel>() {
                    @Override
                    public void call(PersonModel.ChildOfPersonModel childOfPersonModel) {
                        ll_list_root.setVisibility(View.VISIBLE);
                        adapter.addData(childOfPersonModel);
                    }
                });
    }

    //获得部门
    @Override
    public void getDepartment(DepartmentModel departmentModel) {
        adapter.clearData();
        Observable.from(departmentModel.getDatalist())
                .flatMap(new Func1<DepartmentModel.ChildOfDepartmentModel, Observable<DepartmentModel.ChildOfDepartmentModel>>() {
                    @Override
                    public Observable<DepartmentModel.ChildOfDepartmentModel> call(DepartmentModel.ChildOfDepartmentModel childOfDepartmentModel) {
                        return Observable.just(childOfDepartmentModel);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<DepartmentModel.ChildOfDepartmentModel>() {
                    @Override
                    public void call(DepartmentModel.ChildOfDepartmentModel childOfDepartmentModel) {
                        adapter.addData(childOfDepartmentModel);
                    }
                });
    }

    //获得人员计划
    @Override
    public void getDataList(DataListModel dataListModel) {
        Toast.makeText(this, dataListModel.toString(), Toast.LENGTH_SHORT).show();
        ll_list_root.setVisibility(View.VISIBLE);
        adapter.clearData();
        Observable.from(dataListModel.getDatalist())
                .flatMap(new Func1<DataListModel.ChildOfDataListModel, Observable<DataListModel.ChildOfDataListModel>>() {
                    @Override
                    public Observable<DataListModel.ChildOfDataListModel> call(DataListModel.ChildOfDataListModel child) {
                        return Observable.just(child);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<DataListModel.ChildOfDataListModel>() {
                    @Override
                    public void call(DataListModel.ChildOfDataListModel child) {
                        adapter.addData(child);
                    }
                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_department:
                if (null != ll_list_root) {
                    switch (ll_list_root.getVisibility()) {
                        case View.VISIBLE:
                            ll_list_root.setVisibility(View.GONE);
                            break;
                        case View.GONE:
                            ll_list_root.setVisibility(View.VISIBLE);
                            mainActivityPresenter.getDepartment("00000002", "99");
//                            mainActivityPresenter.getPerson("02");
                            break;
                        default:
                            ll_list_root.setVisibility(View.GONE);
                            break;
                    }
                }
                break;
            case R.id.btn_person:
                mainActivityPresenter.getPerson(departmentCode);
                if (null != departmentCode && !departmentCode.equals(null) && !departmentCode.equals("")) {
                }
                break;
        }
    }

    String departmentCode = "";

    @RxBusUtil.Subscribe(code = 2)
    public void updateUi(MessageModel<String> s) {
        if (adapter.getList().get(0) instanceof DepartmentModel.ChildOfDepartmentModel) {
            btn_department.setText(s.getT() + "");
            ll_list_root.setVisibility(View.GONE);
            departmentCode = s.getT2();
        } else if (adapter.getList().get(0) instanceof PersonModel.ChildOfPersonModel) {
            btn_person.setText(s.getT() + "");
            ll_list_root.setVisibility(View.GONE);
        } else if (adapter.getList().size() > 0 && adapter.getList().get(0) instanceof DataListModel.ChildOfDataListModel) {
            Toast.makeText(this, "没有下一级了", Toast.LENGTH_SHORT).show();
        }
    }
}
