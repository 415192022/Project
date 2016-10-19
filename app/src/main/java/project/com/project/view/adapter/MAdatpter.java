package project.com.project.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import project.com.project.R;
import project.com.project.model.DataListModel;
import project.com.project.model.DepartmentModel;
import project.com.project.model.MessageModel;
import project.com.project.model.PersonModel;
import project.com.project.presenter.MainActivityPresenter;
import project.com.project.utils.RxBusUtil;
import project.com.project.view.IMainActivityView;

/**
 * Created by LMW on 2016/6/8.
 */
public class MAdatpter<T> extends BaseAdapter {

    private Context context;
    private List<T> list=new ArrayList<>();
    private LayoutInflater layoutInflater;
    private static MAdatpter adapter;
    public static MAdatpter getInstance(Context context){
        if(null == adapter){
            synchronized (MAdatpter.class){
                if(null == adapter){
                    adapter=new MAdatpter(context);
                }
            }
        }
        return adapter;
    }
    private MAdatpter(Context context) {
        this.context = context;
        layoutInflater=LayoutInflater.from(context);
    }

    public List<T> getList() {
        return list;
    }

    public void clearData(){
        if (list != null && list.size() > 0) {
            list.clear();
        }
    }
    public void addData(T t) {
        list.add(t);
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(null == convertView){
            convertView=layoutInflater.inflate(R.layout.item_layout,parent,false);
            holder=new ViewHolder();
            holder.tv_item_1 = (TextView) convertView.findViewById(R.id.tv_item_1);
            holder.tv_item_2 = (TextView) convertView.findViewById(R.id.tv_item_2);
            holder.tv_item_3 = (TextView) convertView.findViewById(R.id.tv_item_3);
            holder.tv_item_4 = (TextView) convertView.findViewById(R.id.tv_item_4);
            holder.tv_item_5 = (TextView) convertView.findViewById(R.id.tv_item_5);
            holder.tv_item_6 = (TextView) convertView.findViewById(R.id.tv_item_6);
            holder.tv_item_7 = (TextView) convertView.findViewById(R.id.tv_item_7);
            holder.tv_item_8 = (TextView) convertView.findViewById(R.id.tv_item_8);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        //如果是Person
        if (list.get(position) instanceof PersonModel.ChildOfPersonModel) {
            holder.tv_item_1.setVisibility(View.VISIBLE);
            holder.tv_item_2.setVisibility(View.VISIBLE);
            holder.tv_item_1.setText(((List<PersonModel.ChildOfPersonModel>) list).get(position).getEmpName());
            holder.tv_item_2.setText(((List<PersonModel.ChildOfPersonModel>) list).get(position).getEmpCode());
            holder.tv_item_3.setVisibility(View.GONE);
            holder.tv_item_4.setVisibility(View.GONE);
            holder.tv_item_5.setVisibility(View.GONE);
            holder.tv_item_6.setVisibility(View.GONE);
            holder.tv_item_7.setVisibility(View.GONE);
            holder.tv_item_8.setVisibility(View.GONE);
        }
        //如果是Department
        else if (list.get(position) instanceof DepartmentModel.ChildOfDepartmentModel) {
            holder.tv_item_1.setVisibility(View.VISIBLE);
            holder.tv_item_2.setVisibility(View.VISIBLE);
            holder.tv_item_1.setText(((List<DepartmentModel.ChildOfDepartmentModel>) list).get(position).getDeptName());
            holder.tv_item_2.setText(((List<DepartmentModel.ChildOfDepartmentModel>) list).get(position).getDeptCode());
            holder.tv_item_3.setVisibility(View.GONE);
            holder.tv_item_4.setVisibility(View.GONE);
            holder.tv_item_5.setVisibility(View.GONE);
            holder.tv_item_6.setVisibility(View.GONE);
            holder.tv_item_7.setVisibility(View.GONE);
            holder.tv_item_8.setVisibility(View.GONE);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(position > list.size()){
                        return;
                    }
                    if(list.get(position) instanceof DepartmentModel.ChildOfDepartmentModel){
                        MessageModel<String> messageModel=new MessageModel<String>();
                        messageModel.setT(((List<DepartmentModel.ChildOfDepartmentModel>) list).get(position).getDeptName());
                        messageModel.setT2(((List<DepartmentModel.ChildOfDepartmentModel>) list).get(position).getDeptCode());
                        RxBusUtil.getDefault().post(2,messageModel);
                    }else if(list.get(position) instanceof PersonModel.ChildOfPersonModel){
//                        Toast.makeText(context,((List<PersonModel.ChildOfPersonModel>) list).get(position).getEmpCode()+"ssssss",Toast.LENGTH_SHORT).show();
                        MainActivityPresenter.getInstance((IMainActivityView) context).getDataList("M","2016-6",((List<PersonModel.ChildOfPersonModel>) list).get(position).getEmpCode()+"");
                        MessageModel<String> messageModel=new MessageModel<String>();
                        messageModel.setT(((List<PersonModel.ChildOfPersonModel>) list).get(position).getEmpName());
                        RxBusUtil.getDefault().post(2,messageModel);
                    }else if(list.get(position) instanceof DataListModel.ChildOfDataListModel){
                        Toast.makeText(context,"没有下一级了",Toast.LENGTH_SHORT).show();
                    }

//                    MainActivityPresenter.getInstance((IMainActivityView) context).getPerson(((List<DepartmentModel.ChildOfDepartmentModel>) list).get(position).getDeptCode());
                }
            });
            //<editor-fold desc="Description">
        }
        //</editor-fold>
        //如果是DataList
        else if (list.get(position) instanceof DataListModel.ChildOfDataListModel) {
            holder.tv_item_1.setVisibility(View.VISIBLE);
            holder.tv_item_2.setVisibility(View.VISIBLE);
            holder.tv_item_3.setVisibility(View.VISIBLE);
            holder.tv_item_4.setVisibility(View.VISIBLE);
            holder.tv_item_5.setVisibility(View.VISIBLE);
            holder.tv_item_6.setVisibility(View.VISIBLE);
            holder.tv_item_7.setVisibility(View.VISIBLE);
            holder.tv_item_8.setVisibility(View.VISIBLE);
            holder.tv_item_1.setText(((List<DataListModel.ChildOfDataListModel>) list).get(position).getEmpName());
            holder.tv_item_2.setText(((List<DataListModel.ChildOfDataListModel>) list).get(position).getEmpCode());
            holder.tv_item_3.setText(((List<DataListModel.ChildOfDataListModel>) list).get(position).getBeginDate());
            holder.tv_item_4.setText(((List<DataListModel.ChildOfDataListModel>) list).get(position).getEndDate());
            holder.tv_item_5.setText(((List<DataListModel.ChildOfDataListModel>) list).get(position).getItemName());
            holder.tv_item_6.setText(((List<DataListModel.ChildOfDataListModel>) list).get(position).getJobMemo());
            holder.tv_item_7.setText(((List<DataListModel.ChildOfDataListModel>) list).get(position).getSHMan());
            holder.tv_item_8.setText(((List<DataListModel.ChildOfDataListModel>) list).get(position).getXMName());
        }
        //什么都不是
        else {
            holder.tv_item_1.setVisibility(View.GONE);
            holder.tv_item_2.setVisibility(View.GONE);
            holder.tv_item_3.setVisibility(View.GONE);
            holder.tv_item_4.setVisibility(View.GONE);
            holder.tv_item_5.setVisibility(View.GONE);
            holder.tv_item_6.setVisibility(View.GONE);
            holder.tv_item_7.setVisibility(View.GONE);
            holder.tv_item_8.setVisibility(View.GONE);
        }
        return convertView;
    }

    public class ViewHolder{
        public TextView tv_item_1;
        public TextView tv_item_2;
        public TextView tv_item_3;
        public TextView tv_item_4;
        public TextView tv_item_5;
        public TextView tv_item_6;
        public TextView tv_item_7;
        public TextView tv_item_8;
    }
}
