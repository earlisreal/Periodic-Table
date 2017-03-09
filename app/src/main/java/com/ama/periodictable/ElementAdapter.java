package com.ama.periodictable;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by ching on 3/8/2017.
 */

public class ElementAdapter extends RecyclerView.Adapter<ElementAdapter.ViewHolder>{
    private ArrayList<Element> elements;

    public ElementAdapter(ArrayList<Element> elements) {
        this.elements = elements;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(
                LayoutInflater
                        .from(viewGroup.getContext())
                        .inflate(R.layout.element_item, viewGroup, false)
        );
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Element element = elements.get(i);

        viewHolder.number.setText("" +element.getNumber());
        viewHolder.symbol.setText(element.getSymbol());
        viewHolder.name.setText(element.getName());
        viewHolder.weight.setText(element.getWeight());
    }

    @Override
    public int getItemCount() {
        return elements.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView number, symbol, name, weight;

        public ViewHolder(final View itemView) {
            super(itemView);

            number = (TextView) itemView.findViewById(R.id.number);
            symbol = (TextView) itemView.findViewById(R.id.symbol);
            name = (TextView) itemView.findViewById(R.id.name);
            weight = (TextView) itemView.findViewById(R.id.weight);
        }
    }


}
