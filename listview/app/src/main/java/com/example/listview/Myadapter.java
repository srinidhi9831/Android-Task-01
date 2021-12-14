package com.example.listview;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



public class Myadapter extends RecyclerView.Adapter<Myadapter.Myviewholder> {
    MainActivity mn;
    RecyclerView name2;
    data d;
    Facilities[] facilities;
    Exclusion[][] exclusions;
    Activity activity;
    Myadapter(data d,Activity activity){
        this.activity=activity;
        this.d=d;
        this.facilities=d.getFacilities();
        this.exclusions=d.getExclusions();
       // this.name2=name2;
    }




    @Override
    public Myviewholder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.recyview,parent,false);
        return new Myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder holder, int position) {

          holder.text.setText(facilities[position].getName());
    foptions[] options=  facilities[position].getOptions();

        holder.rec.setLayoutManager(new LinearLayoutManager(activity));
        holder.rec.setAdapter(new ItemsAdapter(options,holder,position,this.activity));
    }
    @Override
    public int getItemCount() {
        return facilities.length;
    }

    public class Myviewholder extends RecyclerView.ViewHolder{

         TextView text;
         RecyclerView rec;
         //CheckBox name,icon,id;
        public Myviewholder(View itemView) {
            super(itemView);

         text=(TextView)itemView.findViewById(R.id.Heading);
         rec=(RecyclerView)itemView.findViewById(R.id.itemRecycle);
        }
    }

}
