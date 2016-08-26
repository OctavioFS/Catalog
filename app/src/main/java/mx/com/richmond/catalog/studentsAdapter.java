package mx.com.richmond.catalog;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class studentsAdapter extends BaseAdapter {
    private final List<Item> mItems = new ArrayList<Item>();
    private final LayoutInflater mInflater;
    Cursor c =null;

    public studentsAdapter(Context context, int series) {
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
        int id = 0;
        String[] args = {""+series,"0"};
        int idImg = 0;
        c = myDbHelper.query("studentsTeachers", null, "idSeries=? AND st=?", args, null, null, null);
        if(c.moveToFirst()){
            do{
                id = c.getInt(0);
                idImg = context.getResources().getIdentifier("mx.com.richmond.catalog:drawable/" + c.getString(3), null, null);
                if(idImg != 0)
                    mItems.add(new Item(id, c.getString(2), idImg));
                else
                    mItems.add(new Item(id, c.getString(2), R.drawable.outer_default));

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

        if (v == null) {
            v = mInflater.inflate(R.layout.st, viewGroup, false);
            v.setTag(R.id.stImage, v.findViewById(R.id.stImage));
            v.setTag(R.id.stName, v.findViewById(R.id.stName));
        }

        picture = (ImageView) v.getTag(R.id.stImage);
        name = (TextView) v.getTag(R.id.stName);

        Item item = getItem(i);

        picture.setImageResource(item.drawableId);
        name.setText(item.name);

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

