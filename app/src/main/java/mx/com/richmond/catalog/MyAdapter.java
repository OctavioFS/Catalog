package mx.com.richmond.catalog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public final class MyAdapter extends BaseAdapter {
    private final List<Item> mItems = new ArrayList<Item>();
    private final LayoutInflater mInflater;

    public MyAdapter(Context context) {
        mInflater = LayoutInflater.from(context);

        mItems.add(new Item("Preschool",R.drawable.preschool));
        mItems.add(new Item("Primary",R.drawable.primary));
        mItems.add(new Item("Secondary",R.drawable.secondary));
        mItems.add(new Item("Young Adults",R.drawable.young_adults));
        mItems.add(new Item("Supplementary",R.drawable.supplementary));
        mItems.add(new Item("Exams",R.drawable.exams));
        mItems.add(new Item("Digital",R.drawable.digital));
        mItems.add(new Item("Readers",R.drawable.readers));
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Item getItem(int i) {
        return mItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mItems.get(i).drawableId;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        ImageView picture;
        TextView name;

        if (v == null) {
            v = mInflater.inflate(R.layout.cuadro, viewGroup, false);
            v.setTag(R.id.fondo, v.findViewById(R.id.fondo));
            v.setTag(R.id.nombre, v.findViewById(R.id.nombre));
        }

        picture = (ImageView) v.getTag(R.id.fondo);
        name = (TextView) v.getTag(R.id.nombre);

        Item item = getItem(i);

        picture.setImageResource(item.drawableId);
        name.setText(item.name);

        return v;
    }

    private static class Item {
        public final String name;
        public final int drawableId;

        Item(String name, int drawableId) {
            this.name = name;
            this.drawableId = drawableId;
        }
    }
}