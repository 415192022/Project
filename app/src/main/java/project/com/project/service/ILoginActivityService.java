package project.com.project.service;

import project.com.project.model.CustomerModel;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2016/6/26.
 */
public interface ILoginActivityService {
    @GET("loginCustomer")
    Observable<CustomerModel> login(@Query("params") String params);
}
