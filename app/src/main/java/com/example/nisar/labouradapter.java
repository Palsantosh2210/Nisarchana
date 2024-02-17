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

public class labouradapter extends RecyclerView.Adapter<labouradapter.labviewholder> {
    ArrayList<modelfar> lablist;

    public labouradapter (ArrayList<modelfar> lablist){
        this.lablist = lablist;
    }


    @NonNull
    @Override
    public labviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.laboursinglerow,parent,false);
        return new labviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull labviewholder holder, int position) {
        // String age, String district, String education, String email, String englab, String exp, String name, String phone, String state
        String lage = lablist.get(position).getAge();
        String ldis = lablist.get(position).getDistrict();
        String ledu = lablist.get(position).getEducation();
        String lemail = lablist.get(position).getEmail();
        String leng = lablist.get(position).getEngineeringLabour();
        String lexp = lablist.get(position).getExperience();

        String limage=lablist.get(position).getImage();

        String lname = lablist.get(position).getName();
        String lphone = lablist.get(position).getPhone();
        String lstate = lablist.get(position).getState();

        holder.name.setText(""+ lname);
        holder.price.setText(""+ldis);
        if(limage.length()!=0){
            Picasso.get().load(limage).into(holder.img);

        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.cardView.getContext(),farmresult.class);
                intent.putExtra("name",lname);
                intent.putExtra("age",lage);
                intent.putExtra("email",lemail);
                intent.putExtra("phone",lphone);
                intent.putExtra("education",ledu);
                intent.putExtra("state",lstate);
                intent.putExtra("dist",ldis);
                intent.putExtra("image",limage);
                intent.putExtra("experience",lexp);
                intent.putExtra("engineer",leng);

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.cardView.getContext().startActivity(intent);




            }
        });

    }



    @Override
    public int getItemCount() {
        return lablist.size();
    }

    class labviewholder extends RecyclerView.ViewHolder{
        TextView name, price;
        CardView cardView;
        ImageView img;


        public labviewholder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.labname);
            price = itemView.findViewById(R.id.labprice);
            cardView = itemView.findViewById(R.id.lab);
            img = (ImageView)itemView.findViewById(R.id.imgItem);


        }
    }



}
