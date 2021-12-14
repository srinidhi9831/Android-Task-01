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
    }

    @Override
    public int getItemCount() {
        return options.length;
    }

    public class Itemsviewholder extends RecyclerView.ViewHolder{

        RadioGroup radioGroup;
        public Itemsviewholder(View itemView) {
            super(itemView);
           radioGroup=itemView.findViewById(R.id.rdGrp);
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
