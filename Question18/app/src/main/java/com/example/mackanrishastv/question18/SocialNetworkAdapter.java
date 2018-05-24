package com.example.mackanrishastv.question18;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SocialNetworkAdapter extends RecyclerView.Adapter<SocialNetworkAdapter.ViewHolder> {

    private List<SocialNetwork> socialNetworkList;
    private Context context;

    public SocialNetworkAdapter(List<SocialNetwork> socialNetworkList, Context context) {
        this.socialNetworkList = socialNetworkList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_row, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtNameSocial.setText(socialNetworkList.get(position).getNameSocial());
        holder.imgSocial.setImageResource(socialNetworkList.get(position).getImgSocial());
    }

    @Override
    public int getItemCount() {
        return socialNetworkList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtNameSocial;
        ImageView imgSocial;

        public ViewHolder(View itemView) {
            super(itemView);

            txtNameSocial = (TextView) itemView.findViewById(R.id.txtNameSocial);
            imgSocial = (ImageView) itemView.findViewById(R.id.imgSocial);
        }
    }
}
