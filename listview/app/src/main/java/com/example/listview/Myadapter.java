package com.example.listview;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



public class Myadapter extends RecyclerView.Adapter<Myadapter.Myviewholder> {
    data d;
    Facilities[] facilities;
    Exclusion[][] exclusions;
    Activity activity;
    MainActivity mainActivity;
    Myadapter(data d,Activity activity){
        this.activity=activity;
        this.d=d;
        this.facilities=d.getFacilities();
        this.exclusions=d.getExclusions();

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

         RadioGroup rg=holder.radioGroup;
                 rg.setId(facilities[position].getFacility_id());

    for(foptions op:options){
        RadioButton r=new RadioButton(holder.itemView.getContext());
        r.setText(op.getName());
        r.setId(op.getId());
        holder.radioGroup.addView(r);

    }

    }
    @Override
    public int getItemCount() {
        return facilities.length;
    }

    public class Myviewholder extends RecyclerView.ViewHolder{

         TextView text;
         RadioGroup radioGroup;
        public Myviewholder(View itemView) {
            super(itemView);


         text=(TextView)itemView.findViewById(R.id.Heading);
         radioGroup=itemView.findViewById(R.id.myrgbtn);
         radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(RadioGroup radioGroup, int i) {

                 for(Exclusion[] ex:exclusions){

                 int options_id_01=ex[0].getOptions_id();
                 int options_id_02=ex[1].getOptions_id();

                 if(((RadioButton)activity.findViewById(options_id_01)).isChecked()){
                     String x="inside exclusion opID="+options_id_02;
                     Toast.makeText(itemView.getContext(),x,Toast.LENGTH_SHORT).show();
                     ((RadioButton)activity.findViewById(options_id_02)).setEnabled(false);
                 }
                 else{
                     activity.findViewById(options_id_02).setEnabled(true);
                 }
//                    if(radioGroup.getId()==facility_id_01 && i==options_id_01){
//
//                       activity.findViewById(options_id_02).setEnabled(false);
//                       break;
//
//                    }
//                    else{
//                        activity.findViewById(options_id_02).setEnabled(true);
//                    }
               }

             }
         });
        }
    }

}
