package project.com.project.view;

import project.com.project.model.DataListModel;
import project.com.project.model.DepartmentModel;
import project.com.project.model.PersonModel;

/**
 * Created by LMW on 2016/6/7.
 */
public interface IMainActivityView {
    void getUser(PersonModel personModel);
    void getDepartment(DepartmentModel departmentModel);
    void getDataList(DataListModel dataListModel);
}
