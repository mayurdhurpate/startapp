package com.iitbhu.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by mayur on 23/11/15.
 */
public class ButtonAdapter extends RecyclerView.Adapter<ButtonAdapter.ViewHolder>{
    public Button button;
    public String[] buttonNames;

    public ButtonAdapter(String[] buttonNames){
        this.buttonNames = buttonNames;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public Button button;
        public ViewHolder(View itemView) {
            super(itemView);
            button = (Button)itemView.findViewById(R.id.button);

        }
    }

    @Override
    public ButtonAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.button_element,parent,false);
        button = (Button)view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("test","clicked");
                Toast.makeText(parent.getContext(), "Launching " + buttonNames[viewType]+" Now!", Toast.LENGTH_SHORT).show();
            }
        });
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ButtonAdapter.ViewHolder holder, int position) {
        holder.button.setText(buttonNames[position]);
    }

    @Override
    public int getItemViewType (int position){
        return position;
    }
    @Override
    public int getItemCount() {
        return buttonNames.length;
    }

}
