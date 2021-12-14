package com.example.listview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.Itemsviewholder>{
    Myadapter.Myviewholder myviewholder;
  foptions[] options;
  String lastchecked=null;
  RadioButton r[];
  int[] ids;
  int pos;
  Context context;
    int x ;
     int y;
    ItemsAdapter(foptions[] ex, Myadapter.Myviewholder myviewholder, int pos, Context context){
        this.options=ex;
        this.myviewholder=myviewholder;
        this.pos=pos;
        this.context=context;

    }

    @Override
    public Itemsviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item_list_view,parent,false);
        return new ItemsAdapter.Itemsviewholder(view);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onBindViewHolder(Itemsviewholder holder, int position) {

         RadioButton r=new RadioButton(holder.itemView.getContext());
            r.setText(options[position].getName());
            r.setId(position*100+111);
            holder.radioGroup.addView(r);

    holder.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            String f=""+i;
            if(lastchecked==null){
                //lastchecked=f;
                 lastchecked=""+radioGroup.getCheckedRadioButtonId();

            }else{
                
            }
            lastchecked=f;
            Toast.makeText(holder.itemView.getContext(),f,Toast.LENGTH_SHORT).show();
        }
    });

//        for(foptions op:options){
//            RadioButton r=new RadioButton(ItemsAdapter.this.context);
//            r.setText(op.getName());
//            holder.radioGroup.addView(r);
//        }


        // holder.radioButton.setText(options[position].getName());
        //holder.radioGroup.addView(new RadioButton().setText(options[position]),position);
       //holder.radioGroup.addView(new RadioButtonposition)
    //        holder.checkBox.setText(options[position].getIcon());
//          holder.t1.setText(options[position].getIcon());
//          holder.t2.setText((options[position].getId()));
         // holder.checkBox.getId();
//   holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//       @SuppressLint("ResourceType")
//       @Override
//       public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//
////           Toast.makeText(holder.itemView.getContext(), ,Toast.LENGTH_SHORT).show();
//           if(holder.checkBox.isChecked()) {
//               holder.checkBox.setEnabled(true);
//
//               //holder.checkBox.isChecked();
//               String y= String.valueOf(holder.checkBox.getId());
//               Toast.makeText(holder.itemView.getContext(),y, Toast.LENGTH_SHORT).show();
//           }
//           else{
//               //Toast.makeText(holder.itemView.getContext(),ids.toString(),Toast.LENGTH_SHORT).show();
//               holder.checkBox.setEnabled(true);
//           }
//       }
//   });



//        if (myviewholder.getLayoutPosition()==y &&(x!=9 || y!=9)){
//            if(holder.getLayoutPosition()!=x){
//                        holder.checkBox.setEnabled(false);
//                        }}
    }

    @Override
    public int getItemCount() {
        return options.length;
    }

    public class Itemsviewholder extends RecyclerView.ViewHolder{
        //CheckBox checkBox;
        //TextView t1,t2;
        RadioGroup radioGroup;
        RadioButton radioButton;

        public Itemsviewholder(View itemView) {
            super(itemView);
           radioGroup=(RadioGroup)itemView.findViewById(R.id.rdGrp);
            //radioButton=(RadioButton) itemView.findViewById(R.id.rdbtn);
            //checkBox=(CheckBox) itemView.findViewById(R.id.itCheckBox);
            //t1=(TextView) itemView.findViewById(R.id.tv01);
            //t2=(TextView) itemView.findViewById(R.id.tv02);
           // t3=(TextView) itemView.findViewById(R.id.tv03);


        }

    }
    public void val(int x,int y,Itemsviewholder holder){
        if (myviewholder.getLayoutPosition()==y){
              if(holder.getLayoutPosition()!=x){
                 // holder.checkBox.setEnabled(false);
              }
        }
    }
}
