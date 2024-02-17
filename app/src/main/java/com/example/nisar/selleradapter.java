package com.example.nisar;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
public class selleradapter extends RecyclerView.Adapter<selleradapter.sellerviewholder> {

    ArrayList<modelsell> lablist;
    ImageView img;
    public selleradapter (ArrayList<modelsell> lablist){
        this.lablist = lablist;
    }


    @NonNull
    @Override
    public sellerviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sellersinglerow,parent,false);
        return new sellerviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull sellerviewholder holder, int position) {
        // String age, String district, String education, String email, String englab, String exp, String name, String phone, String state
        String sdis = lablist.get(position).getSellerdistrict();
        String simg = lablist.get(position).getSellerimage();
        String sname = lablist.get(position).getSellername();
        String sphone = lablist.get(position).getSellerphone();
        String sprice = lablist.get(position).getSellerprice();
        String sstate =lablist.get(position).getSellerstate();

        // String lexp = lablist.get(position).getExperience();
        //String lname = lablist.get(position).getName();
        //String lphone = lablist.get(position).getPhone();
        //String lstate = lablist.get(position).getState();

        holder.name.setText(" "+ sname);
        holder.price.setText("₹"+sprice);
       if(simg.length()!=0){
            Picasso.get().load(simg).into(holder.img);

       }

        //Picasso.get().load(currentItem.getImageUrl()).placeholder(R.drawable.logonisar).fit().centerInside().into(holder.img);


        //Picasso.get().load(currentItem.imguri).into(imgItem);
        //Glide.with(holder.img.getContext()).load(lablist.get(position).getSellerimage()).placeholder(R.drawable.logonisar)
             //   .error(R.drawable.delete).into(holder.img);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.cardView.getContext(),sellerresult.class);
                intent.putExtra("District",sdis);
                intent.putExtra("image",simg);
                intent.putExtra("name",sname);
                intent.putExtra("phone",sphone);
                intent.putExtra("price",sprice);
                intent.putExtra("state",sstate);

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.cardView.getContext().startActivity(intent);

            }
        });





    }



    @Override
    public int getItemCount() {
        return lablist.size();
    }

    class sellerviewholder extends RecyclerView.ViewHolder{
        TextView name, price;
        CardView cardView;
        ImageView img;


        public sellerviewholder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.labname);
            price = itemView.findViewById(R.id.labprice);
            cardView = itemView.findViewById(R.id.lab);
            img = (ImageView)itemView.findViewById(R.id.imgItem);


        }
    }



}




