package com.example.menxinhgai;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterList extends RecyclerView.Adapter<AdapterList.ViewHolder> {
    Context context;
    OnClick callBack;
    ArrayList<Model> models;

    public void setCallBack(OnClick callBack) {
        this.callBack = callBack;
    }

    public AdapterList(Context context, ArrayList<Model> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public AdapterList.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterList.ViewHolder holder, final int position) {
        Model model = models.get(position);
        holder.txtname.setText(model.getTen());
        holder.txtma.setText(model.getMa());
        holder.txtloai.setText(model.getLoai());
        holder.txtday.setText(model.getDay());
        holder.txtkhuyenmai.setText(model.getKhuyenmai());
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                models.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,models.size());

                return false;
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.onClickTvName(models.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtma, txtname, txtloai, txtday, txtkhuyenmai;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtma = itemView.findViewById(R.id.txt_ma);
            txtname = itemView.findViewById(R.id.txt_ten);
            txtloai = itemView.findViewById(R.id.txt_gioitinh);
            txtday = itemView.findViewById(R.id.txt_daydh);
            txtkhuyenmai = itemView.findViewById(R.id.txt_km);
        }
    }
}
