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
public class engiadapter  extends RecyclerView.Adapter<engiadapter.engiviewholder> {
    ArrayList<modelfar> farmlist;
    public engiadapter(ArrayList<modelfar> farmlist) {
        this.farmlist =farmlist;
    }

    @NonNull
    @Override
    public engiadapter.engiviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.engisinglerow,parent,false);
        return new engiadapter.engiviewholder(view);

    }



    @Override
    public void onBindViewHolder(@NonNull engiadapter.engiviewholder holder, int position) {


        String fage = farmlist.get(position).getAge();
        String fdis = farmlist.get(position).getDistrict();
        String fedu = farmlist.get(position).getEducation();
        String femail = farmlist.get(position).getEmail();
        String feng = farmlist.get(position).getEngineeringLabour();
        String fexp = farmlist.get(position).getExperience();

        String fimage=farmlist.get(position).getImage();

        String fname = farmlist.get(position).getName();
        String fphone = farmlist.get(position).getPhone();
        String fstate = farmlist.get(position).getState();

        holder.enginame.setText(""+fname);
        holder.farmerquantity1.setText(""+femail);
        if(fimage.length()!=0){
            Picasso.get().load(fimage).into(holder.img);

        }
        //holder.farmerprice1.setText("Price/Quantal: "+fprice);
        //holder.farmertotalprice1.setText("Total price: "+ftotalprice);
        //holder.farmerstate1.setText("State: "+fstate);
        //holder.farmerdistrict1.setText("District: "+fdist);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.cardView.getContext(),civilengiresult.class);
                intent.putExtra("name",fname);
                intent.putExtra("age",fage);
                intent.putExtra("email",femail);
                intent.putExtra("phone",fphone);
                intent.putExtra("education",fedu);
                intent.putExtra("state",fstate);
                intent.putExtra("dist",fdis);
                intent.putExtra("image",fimage);
                intent.putExtra("experience",fexp);
                intent.putExtra("engineer",feng);

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.cardView.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return farmlist.size();

    }

    class engiviewholder extends RecyclerView.ViewHolder{
        TextView enginame,farmerquantity1;
        CardView cardView;
        ImageView img;

        public engiviewholder(@NonNull View itemView) {
            super(itemView);
            enginame = itemView.findViewById(R.id.farmercrop1);
            farmerquantity1 = itemView.findViewById(R.id.farmerquantity1);
            cardView = itemView.findViewById(R.id.farmcard);
            img = (ImageView)itemView.findViewById(R.id.imgItem);



        }
    }
}



