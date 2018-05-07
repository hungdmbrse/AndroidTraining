package com.example.mackanrishastv.question19;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context context;
    private List<SocialNetwork> socialNetworkList;

    public RecyclerViewAdapter(Context context, List<SocialNetwork> socialNetworkList) {
        this.context = context;
        this.socialNetworkList = socialNetworkList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.cardview_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.txtNameSocial.setText(socialNetworkList.get(position).getNameSocical());
        holder.imgSocial.setImageResource(socialNetworkList.get(position).getImgSocial());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, socialNetworkList.get(position).getNameSocical(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return socialNetworkList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txtNameSocial;
        ImageView imgSocial;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);

            txtNameSocial = (TextView) itemView.findViewById(R.id.txtName);
            imgSocial = (ImageView) itemView.findViewById(R.id.imgSocial);
            cardView = (CardView) itemView.findViewById(R.id.cardViewID);
        }
    }
}
