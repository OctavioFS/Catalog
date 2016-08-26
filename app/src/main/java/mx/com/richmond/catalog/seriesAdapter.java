package mx.com.richmond.catalog;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class seriesAdapter extends BaseAdapter {
    private final List<Item> mItems = new ArrayList<Item>();
    private final LayoutInflater mInflater;
    Cursor c =null;

    public seriesAdapter(Context context, int series) {
        mInflater = LayoutInflater.from(context);

        DatabaseHelper myDbHelper = new DatabaseHelper(context);
        try{
            myDbHelper.createDataBase();
        }catch (IOException ioe){
            throw new Error("Unable to create database");
        }
        try{
            myDbHelper.openDataBase();
        }catch(SQLException sqle){
            throw new Error("Error de base");
        }
        series = series+1;
        int id = 0;
        int idImg = 0;
        String[] args = {""+series};
        String seriesImage = "";
        c = myDbHelper.query("series", null, "category=?", args, null, null, null);
        if(c.moveToFirst()){
            do{
                id = c.getInt(0);
                idImg = context.getResources().getIdentifier("mx.com.richmond.catalog:drawable/" + c.getString(3), null, null);
                if(idImg != 0)
                    mItems.add(new Item(id, c.getString(1), idImg));
                else
                    mItems.add(new Item(id, c.getString(1), R.drawable.outer_default));
            } while(c.moveToNext());
        }
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
        TextView id;

        if (v == null) {
            v = mInflater.inflate(R.layout.serie, viewGroup, false);
            v.setTag(R.id.seriesImage, v.findViewById(R.id.seriesImage));
            v.setTag(R.id.seriesName, v.findViewById(R.id.seriesName));
            v.setTag(R.id.seriesId, v.findViewById(R.id.seriesId));
        }

        picture = (ImageView) v.getTag(R.id.seriesImage);
        name = (TextView) v.getTag(R.id.seriesName);
        id = (TextView) v.getTag(R.id.seriesId);

        Item item = getItem(i);

        picture.setImageResource(item.drawableId);
        name.setText(item.name);
        id.setText(""+item.id);

        id.setVisibility(View.GONE);
        return v;
    }

    private static class Item {
        public final int id;
        public final String name;
        public final int drawableId;

        Item(int id, String name, int drawableId) {
            this.id = id;
            this.name = name;
            this.drawableId = drawableId;
        }
    }
}
