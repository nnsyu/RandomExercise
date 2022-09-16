package com.ewoo.luck8estjh.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.ewoo.luck8estjh.R;
import com.ewoo.luck8estjh.db.MainDB;
import com.ewoo.luck8estjh.model.Exercise;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class ListExerciseAdapter extends RecyclerView.Adapter<ListExerciseAdapter.ViewHolder>{

    private Context mContext;

    private View mView;

    private List<Exercise> exerciseList;

    public ListExerciseAdapter(Context mContext, List<Exercise> exerciseList) {
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
        mView = LayoutInflater.from(mContext).inflate(R.layout.item_name_list, parent, false);

        return new ListExerciseAdapter.ViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvExercise.setText(exerciseList.get(position).getExName());
    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ConstraintLayout layoutBg;
        private TextView tvExercise;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutBg = itemView.findViewById(R.id.layout_bg);

            tvExercise = itemView.findViewById(R.id.i_list_tv_exercise);
            tvExercise.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    Snackbar snackbar = Snackbar.make(layoutBg, "삭제하시겠습니까?", Snackbar.LENGTH_LONG);
                    snackbar.setAction("삭제", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            MainDB mainDB = MainDB.getInstance(mContext);
                            mainDB.exerciseDao().deleteExercise(exerciseList.get(getAdapterPosition()).getExName());
                            exerciseList.remove(getAdapterPosition());
                            notifyDataSetChanged();
                            snackbar.dismiss();
                        }
                    });
                    snackbar.show();
                    return false;
                }
            });
        }
    }
}
