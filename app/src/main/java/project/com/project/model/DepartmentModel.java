package project.com.project.model;

import project.com.project.model.base.BaseModel;

/**
 * Created by LMW on 2016/6/7.
 */
public class DepartmentModel extends BaseModel<DepartmentModel.ChildOfDepartmentModel>{
    public class ChildOfDepartmentModel{
        private String DeptCode;
        private String DeptName;

        public String getDeptCode() {
            return DeptCode;
        }

        public String getDeptName() {
            return DeptName;
        }

        public void setDeptCode(String deptCode) {
            DeptCode = deptCode;
        }

        public void setDeptName(String deptName) {
            DeptName = deptName;
        }

        @Override
        public String toString() {
            return "ChildOfDepartmentModel{" +
                    "DeptCode='" + DeptCode + '\'' +
                    ", DeptName='" + DeptName + '\'' +
                    '}';
        }
    }
}
