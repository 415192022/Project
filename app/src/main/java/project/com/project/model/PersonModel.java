package project.com.project.model;

import project.com.project.model.base.BaseModel;

/**
 * Created by LMW on 2016/6/7.
 */
public class PersonModel extends BaseModel<PersonModel.ChildOfPersonModel> {
    public class ChildOfPersonModel{
        private String EmpName;
        private String EmpCode;

        public String getEmpName() {
            return EmpName;
        }

        public String getEmpCode() {
            return EmpCode;
        }

        public void setEmpName(String empName) {
            EmpName = empName;
        }

        public void setEmpCode(String empCode) {
            EmpCode = empCode;
        }

        @Override
        public String toString() {
            return "ChildOfPersonModel{" +
                    "EmpName='" + EmpName + '\'' +
                    ", EmpCode='" + EmpCode + '\'' +
                    '}';
        }
    }
}
