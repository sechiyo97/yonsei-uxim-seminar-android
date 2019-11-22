package com.example.uxim_android_1121;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private ArrayList<ItemList> mList;

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView id;
        protected TextView english;

        protected Button deleteBtn; // delete 기능 추가 : 버튼 정의

        public CustomViewHolder(View view) {
            super(view);
            this.id = (TextView) view.findViewById(R.id.id_listitem);
            this.english = (TextView) view.findViewById(R.id.english_listitem);
            this.deleteBtn = (Button) view.findViewById(R.id.delete_btn); // delete 기능 추가 : 버튼 가져오기
        }
    }


    public CustomAdapter(ArrayList<ItemList> list) {
        this.mList = list;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_list, viewGroup, false);

        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder viewholder, int position) {

        viewholder.id.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        viewholder.english.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);

        viewholder.id.setGravity(Gravity.CENTER);
        viewholder.english.setGravity(Gravity.CENTER);

        viewholder.id.setText(Integer.toString(position));
        viewholder.english.setText(mList.get(position).getEnglish());

        // delete 기능 추가 : 가져온 버튼에 삭제기능 추가
        viewholder.deleteBtn.setTag(viewholder.getAdapterPosition()); // 몇번째 버튼인지 Tag로 넣어 줌
        viewholder.deleteBtn.setOnClickListener(new Button.OnClickListener(){ // 클릭하면
            @Override
            public void onClick(View view) {
                int pos = (int)view.getTag(); // 태그로 버튼 번호 가져오고
                mList.remove(pos); // 리스트에서 이 내용을 지우고
                notifyItemRemoved(pos); // 실제 화면에 반영한다.
                for (int i=0;i<mList.size();i++) notifyItemChanged(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }
}