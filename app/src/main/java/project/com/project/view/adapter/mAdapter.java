//package project.com.project.view.adapter;
//
//import android.annotation.TargetApi;
//import android.content.Context;
//import android.os.Build;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import java.util.List;
//
//import project.com.project.R;
//import project.com.project.model.DataListModel;
//import project.com.project.model.DepartmentModel;
//import project.com.project.model.PersonModel;
//
///**
// * Created by LMW on 2016/6/8.
// */
//public class mAdapter<T> extends RecyclerView.Adapter<mAdapter.ViewHolder> {
//    private Context context;
//    private List<T> list;
//
//    private static mAdapter adapter;
//    public static mAdapter getInstance(Context context){
//        if(null == adapter){
//            synchronized (mAdapter.class){
//                if(null == adapter){
//                    adapter=new mAdapter(context);
//                }
//            }
//        }
//        return adapter;
//    }
//
//    private mAdapter(Context context) {
//        this.context = context;
//    }
//
//    public List<T> getList() {
//        return list;
//    }
//
//    public void setList(List<T> list) {
//        if (list != null && list.size() > 0) {
//            list.clear();
//        }
//        this.list = list;
//        notifyDataSetChanged();
//    }
//
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        LayoutInflater layoutInflater = LayoutInflater.from(context);
//        View view = layoutInflater.inflate(R.layout.item_layout, parent, false);
//        return new ViewHolder(view);
//    }
//    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//        if (list.get(position) instanceof PersonModel) {
//            holder.tv_item_1.setVisibility(View.VISIBLE);
//            holder.tv_item_2.setVisibility(View.VISIBLE);
//            holder.tv_item_1.setText(((List<PersonModel.ChildOfPersonModel>) list).get(position).getEmpName());
//            holder.tv_item_2.setText(((List<PersonModel.ChildOfPersonModel>) list).get(position).getEmpCode());
//            holder.tv_item_3.setVisibility(View.GONE);
//            holder.tv_item_4.setVisibility(View.GONE);
//            holder.tv_item_5.setVisibility(View.GONE);
//            holder.tv_item_6.setVisibility(View.GONE);
//            holder.tv_item_7.setVisibility(View.GONE);
//            holder.tv_item_8.setVisibility(View.GONE);
//        } else if (list.get(position) instanceof DepartmentModel) {
//            holder.tv_item_1.setVisibility(View.VISIBLE);
//            holder.tv_item_2.setVisibility(View.VISIBLE);
//            holder.tv_item_1.setText(((List<DepartmentModel.ChildOfDepartmentModel>) list).get(position).getDeptName());
//            holder.tv_item_2.setText(((List<DepartmentModel.ChildOfDepartmentModel>) list).get(position).getDeptCode());
//            holder.tv_item_3.setVisibility(View.GONE);
//            holder.tv_item_4.setVisibility(View.GONE);
//            holder.tv_item_5.setVisibility(View.GONE);
//            holder.tv_item_6.setVisibility(View.GONE);
//            holder.tv_item_7.setVisibility(View.GONE);
//            holder.tv_item_8.setVisibility(View.GONE);
//        } else if (list.get(position) instanceof DataListModel) {
//            holder.tv_item_1.setVisibility(View.VISIBLE);
//            holder.tv_item_2.setVisibility(View.VISIBLE);
//            holder.tv_item_3.setVisibility(View.VISIBLE);
//            holder.tv_item_4.setVisibility(View.VISIBLE);
//            holder.tv_item_5.setVisibility(View.VISIBLE);
//            holder.tv_item_6.setVisibility(View.VISIBLE);
//            holder.tv_item_7.setVisibility(View.VISIBLE);
//            holder.tv_item_8.setVisibility(View.VISIBLE);
//            holder.tv_item_1.setText(((List<DataListModel.ChildOfDataListModel>) list).get(position).getEmpName());
//            holder.tv_item_2.setText(((List<DataListModel.ChildOfDataListModel>) list).get(position).getEmpCode());
//            holder.tv_item_3.setText(((List<DataListModel.ChildOfDataListModel>) list).get(position).getBeginDate());
//            holder.tv_item_4.setText(((List<DataListModel.ChildOfDataListModel>) list).get(position).getEndDate());
//            holder.tv_item_5.setText(((List<DataListModel.ChildOfDataListModel>) list).get(position).getItemName());
//            holder.tv_item_6.setText(((List<DataListModel.ChildOfDataListModel>) list).get(position).getJobMemo());
//            holder.tv_item_7.setText(((List<DataListModel.ChildOfDataListModel>) list).get(position).getSHMan());
//            holder.tv_item_8.setText(((List<DataListModel.ChildOfDataListModel>) list).get(position).getXMName());
//        } else {
//            holder.tv_item_1.setVisibility(View.GONE);
//            holder.tv_item_2.setVisibility(View.GONE);
//            holder.tv_item_3.setVisibility(View.GONE);
//            holder.tv_item_4.setVisibility(View.GONE);
//            holder.tv_item_5.setVisibility(View.GONE);
//            holder.tv_item_6.setVisibility(View.GONE);
//            holder.tv_item_7.setVisibility(View.GONE);
//            holder.tv_item_8.setVisibility(View.GONE);
//        }
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        public TextView tv_item_1;
//        public TextView tv_item_2;
//        public TextView tv_item_3;
//        public TextView tv_item_4;
//        public TextView tv_item_5;
//        public TextView tv_item_6;
//        public TextView tv_item_7;
//        public TextView tv_item_8;
//
//        public ViewHolder(View itemView) {
//            super(itemView);
//            tv_item_1 = (TextView) itemView.findViewById(R.id.tv_item_1);
//            tv_item_2 = (TextView) itemView.findViewById(R.id.tv_item_2);
//            tv_item_3 = (TextView) itemView.findViewById(R.id.tv_item_3);
//            tv_item_4 = (TextView) itemView.findViewById(R.id.tv_item_4);
//            tv_item_5 = (TextView) itemView.findViewById(R.id.tv_item_5);
//            tv_item_6 = (TextView) itemView.findViewById(R.id.tv_item_6);
//            tv_item_7 = (TextView) itemView.findViewById(R.id.tv_item_7);
//            tv_item_8 = (TextView) itemView.findViewById(R.id.tv_item_8);
//        }
//    }
//}
//
//
//
//
//
