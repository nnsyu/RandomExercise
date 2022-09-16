package com.ewoo.luck8estjh.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ewoo.luck8estjh.R;
import com.ewoo.luck8estjh.model.Exercise;

import java.util.List;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ViewHolder>{

    private Context mContext;

    private View mView;

    private List<Exercise> exerciseList;

    public ExerciseAdapter(Context mContext, List<Exercise> exerciseList) {
        this.mContext = mContext;
        this.exerciseList = exerciseList;
    }

    public void setList(List<Exercise> exerciseList) {
        this.exerciseList = exerciseList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mView = LayoutInflater.from(mContext).inflate(R.layout.item_exercise_list, parent, false);

        return new ExerciseAdapter.ViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvExercise.setText(exerciseList.get(position).getExName());

        int minCount = exerciseList.get(position).getMinCount();
        int maxCount = exerciseList.get(position).getMaxCount();
        int count = (int) (Math.random() * (maxCount - minCount + 1)) + minCount;

        int minSet = exerciseList.get(position).getMinSet();
        int maxSet = exerciseList.get(position).getMaxSet();
        int set = (int) (Math.random() * (maxSet - minSet + 1)) + minSet;

        holder.tvCount.setText(Integer.toString(count));
        holder.tvSet.setText(Integer.toString(set));

    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvExercise, tvCount, tvSet;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvExercise = itemView.findViewById(R.id.i_exercise_tv_exercise);
            tvCount = itemView.findViewById(R.id.i_exercise_tv_count);
            tvSet = itemView.findViewById(R.id.i_exercise_tv_set);
        }
    }
}
