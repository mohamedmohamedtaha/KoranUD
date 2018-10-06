package com.MohamedTaha.Imagine.Quran.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.MohamedTaha.Imagine.Quran.getData.Model;
import com.MohamedTaha.Imagine.Quran.R;

import java.util.List;


public class RecycleViewReaderAdapter extends RecyclerView.Adapter<RecycleViewReaderAdapter.RecycleViewHolder>{

        public static final String NAME ="name";
        public static final String URLLINK ="url";
        private List<Model> responses;

        Context context;

        public RecycleViewReaderAdapter(Context context,List<Model> responses){
            this.context = context;
            this.responses = responses;
        }
        @Override
        public RecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_templete,parent,false);
            RecycleViewHolder holder = new RecycleViewHolder(row);
            return holder;
        }

        @Override
        public void onBindViewHolder(RecycleViewHolder holder, int position) {
            Model data = responses.get(position);
            holder.text_title.setText(data.getSora_name());


        }

        @Override
        public int getItemCount() {
            return responses.size();
        }

        class RecycleViewHolder extends RecyclerView.ViewHolder{
            TextView text_title;
            public RecycleViewHolder(View itemView) {
                super(itemView);
                text_title = (TextView)itemView.findViewById(R.id.text_title);

               }
        }

  public interface ClickListener{
        void onClick(View view, int position);

    }
    public static class RecycleTouchListener implements RecyclerView.OnItemTouchListener{
        private GestureDetector gestureDetector;
        private ClickListener clickListener;

        public RecycleTouchListener(Context context, final ClickListener clickLstener)
        {
            this.clickListener = clickLstener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }
                @Override
                public void onLongPress(MotionEvent e) {
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)){
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }


    }


    }