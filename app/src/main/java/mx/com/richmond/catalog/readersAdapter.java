package mx.com.richmond.catalog;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class readersAdapter extends BaseAdapter {
    private final List<Item> mItems = new ArrayList<Item>();
    private final LayoutInflater mInflater;
    Cursor c =null;

    public readersAdapter(Context context, int reader) {
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
        String isbn = "";
        int idImg = 0;
        String[] args = {""+reader};
        String readerImage = "";
        c = myDbHelper.query("readers", null, "idSeries=?", args, null, null, null);
        if(c.moveToFirst()){
            do{
                isbn = "ISBN: "+c.getString(4);
                idImg = context.getResources().getIdentifier("mx.com.richmond.catalog:drawable/" + c.getString(6), null, null);
                if(idImg != 0)
                    mItems.add(new Item(isbn, c.getString(2), c.getString(3), idImg, c.getString(5)));
                else
                    mItems.add(new Item(isbn, c.getString(2), c.getString(3), R.drawable.reader_default, c.getString(5)));

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
        ImageView newicon;
        TextView name;
        TextView isbn;
        TextView level;


        if (v == null) {
            v = mInflater.inflate(R.layout.reader, viewGroup, false);
            v.setTag(R.id.readerImage, v.findViewById(R.id.readerImage));
            v.setTag(R.id.readerName, v.findViewById(R.id.readerName));
            v.setTag(R.id.readerISBN, v.findViewById(R.id.readerISBN));
            v.setTag(R.id.readerLevel, v.findViewById(R.id.readerLevel));
            v.setTag(R.id.newicon, v.findViewById(R.id.newicon));
        }

        picture = (ImageView) v.getTag(R.id.readerImage);
        newicon = (ImageView) v.getTag(R.id.newicon);
        name = (TextView) v.getTag(R.id.readerName);
        level = (TextView) v.getTag(R.id.readerLevel);
        isbn = (TextView) v.getTag(R.id.readerISBN);

        Item item = getItem(i);

        picture.setImageResource(item.drawableId);
        name.setText(item.name);
        level.setText(item.level);
        isbn.setText(item.isbn);

        if(item.iconId.indexOf("0")>=0)
            newicon.setImageResource(R.drawable.empty);
        else
            newicon.setImageResource(R.drawable.new_icon);

        return v;
    }

    private static class Item {
        public final String isbn;
        public final String name;
        public final String level;
        public final int drawableId;
        public final String iconId;

        Item(String isbn, String name, String level, int drawableId, String iconId) {
            this.isbn = isbn;
            this.name = name;
            this.level = level;
            this.drawableId = drawableId;
            this.iconId = iconId;
        }
    }
}
