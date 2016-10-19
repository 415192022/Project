package project.com.project.service;

import project.com.project.model.DataListModel;
import project.com.project.model.DepartmentModel;
import project.com.project.model.PersonModel;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by LMW on 2016/6/7.
 */
public interface IMainActivityService {
    @POST("SumAction_SearchMember")
    Observable<PersonModel> getPerson(@Query("DeptCode") String deptCode);

    @POST("SumAction_searchDept")
    Observable<DepartmentModel> getDepartment(@Query("EmpCode") String empCode, @Query("CompCode") String compCode);

    @POST("SumAction_searchSum")
    Observable<DataListModel> getDataList(@Query("PlanType") String plantType, @Query("Time") String time, @Query("EmpCode") String empCode);
}
