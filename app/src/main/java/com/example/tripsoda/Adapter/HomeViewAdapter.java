package com.example.tripsoda.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tripsoda.Model.HomeItem;
import com.example.tripsoda.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
public class HomeViewAdapter extends RecyclerView.Adapter<HomeViewAdapter.Holder> {

    private Context context;
    private List<HomeItem> list = new ArrayList<>();

    public HomeViewAdapter(Context context, List<HomeItem> list) {
        this.context = context;
        this.list = list;
    }

    // ViewHolder 생성
    // row layout을 화면에 뿌려주고 holder에 연결
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item, parent, false);
        Holder holder = new Holder(view);
        return holder;
    }

    /*
     * Todo 만들어진 ViewHolder에 data 삽입 ListView의 getView와 동일
     *
     * */
    @Override
    public void onBindViewHolder(Holder holder, int position) {
        // 각 위치에 문자열 세팅
        int itemposition = position;
        holder.date_textView.setText("");
        holder.index_textView.setText("");
        holder.requiredTime_textView.setText("");
    }

    // 몇개의 데이터를 리스트로 뿌려줘야하는지 반드시 정의해줘야한다
    @Override
    public int getItemCount() {
        return list.size(); // RecyclerView의 size return
    }

    // ViewHolder는 하나의 View를 보존하는 역할을 한다
    public class Holder extends RecyclerView.ViewHolder{
        public TextView location_textView;
        public TextView date_textView;
        public TextView index_textView;
        public TextView requiredTime_textView;

        public Holder(View view){
            super(view);
            location_textView = view.findViewById(R.id.location_textView);
            date_textView = (TextView) view.findViewById(R.id.date_textView);
            index_textView = (TextView) view.findViewById(R.id.index_textView);
            requiredTime_textView = (TextView) view.findViewById(R.id.requiredTime_textView);
        }
    }
}


