package com.example.safak.adisyon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class MyExpandableListAdapter extends BaseExpandableListAdapter{

    private Context context;
    private List<ParentProvider> parent;
    private HashMap<ParentProvider, List<ParentProvider>> child;

    public MyExpandableListAdapter(Context context,HashMap<ParentProvider, List<ParentProvider>> child,List<ParentProvider> parent){
        this.context = context;
        this.parent = parent;
        this.child = child;
    }

    class LayoutHandler{
        ImageView foto;
        TextView textView;
    }

    class ViewHolder{
        ImageView foto;
        TextView textView,textView2;
    }

    @Override
    public int getGroupCount() {
        return this.parent.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return this.child.get(this.parent.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return this.parent.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return this.child.get(this.parent.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        LayoutHandler layoutHandler;
        if (view == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.parent_layout,viewGroup,false);
            layoutHandler = new LayoutHandler();
            layoutHandler.foto = (ImageView) view.findViewById(R.id.fotoKategori);
            layoutHandler.textView = (TextView) view.findViewById(R.id.textKategori);
            view.setTag(layoutHandler);
        }
        else
            layoutHandler = (LayoutHandler) view.getTag();
        ParentProvider provider = (ParentProvider) this.getGroup(i);
        layoutHandler.foto.setImageResource(provider.getFoto());
        layoutHandler.textView.setText(provider.getAd());
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        ViewHolder layoutHandler;
        if (view == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.child_layout,viewGroup,false);
            layoutHandler = new ViewHolder();
            layoutHandler.foto = (ImageView) view.findViewById(R.id.fotoChild);
            layoutHandler.textView = (TextView) view.findViewById(R.id.textUrun);
            layoutHandler.textView2 = (TextView) view.findViewById(R.id.textFiyat);
            view.setTag(layoutHandler);
        }
        else
            layoutHandler = (ViewHolder) view.getTag();
        ParentProvider provider = (ParentProvider) this.getChild(i,i1);
        layoutHandler.foto.setImageResource(provider.getFoto());
        layoutHandler.textView.setText(provider.getAd());
        layoutHandler.textView2.setText(String.valueOf(provider.getFiyat()));
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
