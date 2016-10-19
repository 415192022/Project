package project.com.project.interaptor;

import project.com.project.model.DataListModel;
import project.com.project.model.DepartmentModel;
import project.com.project.model.PersonModel;
import rx.Observable;

/**
 * Created by Administrator on 2016/6/7.
 */
public interface IMainActivityInterapter {
    Observable<PersonModel> getPerson(String deptCode);
    Observable<DepartmentModel> getDepartment(String empCode, String compCode);
    Observable<DataListModel> getDataList(String plantType, String time,  String empCode);
}
