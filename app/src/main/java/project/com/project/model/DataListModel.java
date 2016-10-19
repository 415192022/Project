package project.com.project.model;

import project.com.project.model.base.BaseModel;

/**
 * Created by LMW on 2016/6/7.
 */
public class DataListModel extends BaseModel<DataListModel.ChildOfDataListModel>{
   public class ChildOfDataListModel{
       private String JobMemo;
       private String EndDate;
       private String BeginDate;
       private String SHMan;
       private String ItemName;
       private String EmpName;
       private String XMName;
       private String EmpCode;

       public String getJobMemo() {
           return JobMemo;
       }

       public String getEndDate() {
           return EndDate;
       }

       public String getBeginDate() {
           return BeginDate;
       }

       public String getSHMan() {
           return SHMan;
       }

       public String getItemName() {
           return ItemName;
       }

       public String getEmpName() {
           return EmpName;
       }

       public String getXMName() {
           return XMName;
       }

       public String getEmpCode() {
           return EmpCode;
       }

       public void setJobMemo(String jobMemo) {
           JobMemo = jobMemo;
       }

       public void setEndDate(String endDate) {
           EndDate = endDate;
       }

       public void setBeginDate(String beginDate) {
           BeginDate = beginDate;
       }

       public void setSHMan(String SHMan) {
           this.SHMan = SHMan;
       }

       public void setItemName(String itemName) {
           ItemName = itemName;
       }

       public void setEmpName(String empName) {
           EmpName = empName;
       }

       public void setXMName(String XMName) {
           this.XMName = XMName;
       }

       public void setEmpCode(String empCode) {
           EmpCode = empCode;
       }

       @Override
       public String toString() {
           return "ChildOfDataListModel{" +
                   "JobMemo='" + JobMemo + '\'' +
                   ", EndDate='" + EndDate + '\'' +
                   ", BeginDate='" + BeginDate + '\'' +
                   ", SHMan='" + SHMan + '\'' +
                   ", ItemName='" + ItemName + '\'' +
                   ", EmpName='" + EmpName + '\'' +
                   ", XMName='" + XMName + '\'' +
                   ", EmpCode='" + EmpCode + '\'' +
                   '}';
       }
   }
}
