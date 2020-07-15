package com.wanfadger.rentaboat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.wanfadger.rentaboat.home.HomeFragment;
import com.wanfadger.rentaboat.home.HomeFragmentDirections;

import java.util.List;

public class BoatsAdapter  extends RecyclerView.Adapter<BoatsAdapter.BoatsViewHolder> {
     private Context context;
     private List<Boat> boatList;
     private ViewHolderItemClick viewHolderItemClick;


    public BoatsAdapter(Context context, List<Boat> boatList) {
        this.context = context;
        this.boatList = boatList;
    }

    public void setHolderItemClick(ViewHolderItemClick holderItemClick) {
        this.viewHolderItemClick = holderItemClick;
    }


    @NonNull
    @Override
    public BoatsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.boat_item_vh , parent , false);
        return new BoatsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BoatsViewHolder holder, int position) {
    Boat boat = boatList.get(position);
    bindData(holder , boat);
    }

    private void bindData(BoatsViewHolder holder, Boat boat) {
        holder.description.setText(boat.getDescription());
        holder.name.setText(boat.getName());
        holder.price.setText(boat.getPrice());
    }

    @Override
    public int getItemCount() {
        return boatList!=null ? boatList.size() : 10;
    }

    public class BoatsViewHolder extends RecyclerView.ViewHolder{

        private final ImageView boatImageView;
        private final TextView description;
        private final TextView price;
        private final TextView name;

        public BoatsViewHolder(@NonNull View itemView) {
            super(itemView);
            boatImageView = itemView.findViewById(R.id.boat_image_view);
            description = itemView.findViewById(R.id.description_text_view);
            price = itemView.findViewById(R.id.price_text_view);
            name = itemView.findViewById(R.id.name_text_view);

            itemView.setOnClickListener( (View view) -> {
            viewHolderItemClick.holderItemClick(view , getAdapterPosition());
            });


        }
    }

    public interface ViewHolderItemClick{
        void holderItemClick(View view , int position);
    }
}
