package com.ewoo.luck8estjh.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.ewoo.luck8estjh.R;
import com.ewoo.luck8estjh.activities.CountActivity;
import com.ewoo.luck8estjh.activities.ExerciseListActivity;
import com.ewoo.luck8estjh.db.MainDB;
import com.ewoo.luck8estjh.model.Gym;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class GymSelectAdapter extends RecyclerView.Adapter<GymSelectAdapter.ViewHolder>{

    private Context mContext;

    private View mView;

    private List<Gym> gymList;

    public GymSelectAdapter(Context mContext, List<Gym> gymList) {
        this.mContext = mContext;
        this.gymList = gymList;
    }

    public void setList(List<Gym> exerciseList) {
        this.gymList = exerciseList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mView = LayoutInflater.from(mContext).inflate(R.layout.item_name_list, parent, false);

        return new GymSelectAdapter.ViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvGym.setText(gymList.get(position).getGymName());
    }

    @Override
    public int getItemCount() {
        return gymList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ConstraintLayout layoutBg;
        private TextView tvGym;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutBg = itemView.findViewById(R.id.layout_bg);

            tvGym = itemView.findViewById(R.id.i_list_tv_exercise);
            tvGym.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, CountActivity.class);
                    intent.putExtra("gym", gymList.get(getAdapterPosition()).getGymName());
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
