package sharma.pankaj.cryptocoininfo;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HLVAdapter extends RecyclerView.Adapter<HLVAdapter.ViewHolder> {

    ArrayList<String> almName;
    ArrayList<String> almPrice;
    ArrayList<String> almlupdate;
    ArrayList<Integer> alImage;
    ArrayList<String> alId;

    Context context;

    public HLVAdapter(Context context, ArrayList<String> almName,
                      ArrayList<String> almPrice,
                      ArrayList<String> almlupdate,
                      ArrayList<Integer> alImage,
                      ArrayList<String> alId) {
        super();
        this.context = context;
        this.almName = almName;
        this.almPrice = almPrice;
        this.almlupdate = almlupdate;
        this.alImage = alImage;
        this.alId = alId;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.raw, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.mName.setText(almName.get(i));
        viewHolder.mPrice.setText(almPrice.get(i));
        viewHolder.mlaupdate.setText(almlupdate.get(i));
        viewHolder.mImg.setImageResource(alImage.get(i));

        viewHolder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if (isLongClick) {
                    Intent intent = new Intent(context, DataActivity.class);
                    intent.putExtra("POS", alId.get(position));
                    context.startActivity(intent);

                } else {
                    Intent intent = new Intent(context, DataActivity.class);
                    intent.putExtra("POS", alId.get(position));
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return almlupdate.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        public ImageView mImg;
        public TextView mName, mPrice, mlaupdate;
        private ItemClickListener clickListener;

        public ViewHolder(View itemView) {
            super(itemView);
            mImg = (ImageView) itemView.findViewById(R.id.img);
            mName = (TextView) itemView.findViewById(R.id.name);
            mPrice = (TextView) itemView.findViewById(R.id.price);
            mlaupdate = (TextView) itemView.findViewById(R.id.lupdate);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void setClickListener(ItemClickListener itemClickListener) {
            this.clickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {
            clickListener.onClick(view, getPosition(), false);
        }

        @Override
        public boolean onLongClick(View view) {
            clickListener.onClick(view, getPosition(), true);
            return true;
        }
    }

}

