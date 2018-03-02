package com.example.dusk.loginpage;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jared Fipps on 2/25/2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private ArrayList<CardsJava> mList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextOne;
        public TextView mTextTwo;
        public TextView mTextThree;

        public ViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            mTextOne = itemView.findViewById(R.id.titleText);
            mTextTwo = itemView.findViewById(R.id.hourText);
            mTextThree = itemView.findViewById(R.id.minuteText);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public Adapter(ArrayList<CardsJava> cards) {
        mList = cards;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards, parent, false);
        ViewHolder vh = new ViewHolder(v, mListener);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CardsJava currentCard = mList.get(position);
        holder.mTextOne.setText(currentCard.getTitleText());
        holder.mTextTwo.setText((currentCard.getMHour()));
        holder.mTextThree.setText((currentCard.getMMinute()));
    }

    @Override
    public int getItemCount() {

        return mList.size();
    }
}
