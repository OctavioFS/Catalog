package mx.com.richmond.catalog;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class Stores extends AppCompatActivity {
    class Store {
        String storeName;
        String storeInfo;

        public String getName() {
            return storeName;
        }

        public void setName(String name) {
            storeName = name;
        }

        public String getInfo() {
            return storeInfo;
        }

        public void setInfo(String info) {
            storeInfo = info;
        }

        public Store(String name, String info) {
            storeName = name;
            storeInfo = info;
        }
    }

    public class StoreAdapter extends ArrayAdapter<Store> {
        private ArrayList<Store> items;
        private StoreViewHolder storeHolder;

        private class StoreViewHolder {
            TextView name;
            TextView info;
        }

        public StoreAdapter(Context context, int tvResId, ArrayList<Store> items) {
            super(context, tvResId, items);
            this.items = items;
        }

        @Override
        public View getView(int pos, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater vi = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.store, null);
                storeHolder = new StoreViewHolder();
                storeHolder.name = (TextView)v.findViewById(R.id.titStore);
                storeHolder.info = (TextView)v.findViewById(R.id.subStore);
                v.setTag(storeHolder);
            } else storeHolder = (StoreViewHolder)v.getTag();

            Store store = items.get(pos);

            if (store != null) {
                storeHolder.name.setText(store.getName());
                storeHolder.info.setText(store.getInfo());
                Linkify.addLinks(storeHolder.info, Linkify.ALL);
            }

            return v;
        }
    }

    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;
    Cursor c =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stores);

        Typeface titulo = Typeface.createFromAsset(getAssets(), "Montserrat-Bold.otf");
        SpannableString s = new SpannableString("Richmond");
        s.setSpan(new CustomTypefaceSpan("", titulo), 0, s.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        int state = getIntent().getIntExtra("state", 0);
        String name = getIntent().getStringExtra("name");

        TextView titulo_estado = (TextView) findViewById(R.id.titulo_estado);
        titulo_estado.setText(name);
        ListView listStores = (ListView) findViewById(R.id.listStores);
        int a = 0;

        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.logo);
        actionBar.setTitle(s);
        actionBar.setSubtitle("ELT Catalog 2016 > Where to buy");
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        DatabaseHelper myDbHelper = new DatabaseHelper(Stores.this);
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

        String[] cols = {"count(*)"};
        String[] args = {""+state};
        c = myDbHelper.query("stores", cols, "state=?", args, null, null, null);
        c.moveToFirst();
        int count= c.getInt(0);
        c.close();
        String[] storeNames = new String[count];
        String[] storeInfos = new String[count];
        String telefono = new String();
        String mail = new String();
        String mail2 = new String();
        String mail3 = new String();
        String website = new String();
        c = myDbHelper.query("stores", null, "state=?", args, null, null, null);
        if(c.moveToFirst()){
            do{
                storeNames[a] = c.getString(1);
                if(c.getString(4) != null && !c.getString(4).isEmpty())
                    telefono = "\n"+c.getString(4);
                else
                    telefono = "";
                if(c.getString(5) != null && !c.getString(5).isEmpty())
                    mail = "\n"+c.getString(5);
                else
                    mail = "";
                if(c.getString(6) != null && !c.getString(6).isEmpty())
                    mail2 = "\n"+c.getString(6);
                else
                    mail2 = "";
                if(c.getString(7) != null && !c.getString(7).isEmpty())
                    mail3 = "\n"+c.getString(7);
                else
                    mail3 = "";
                if(c.getString(8) != null && !c.getString(8).isEmpty())
                    website = "\n"+c.getString(8);
                else
                    website = "";

                storeInfos[a] = c.getString(3)+telefono+mail+mail2+mail3+website;
                a++;
            } while(c.moveToNext());
        }

        ArrayList<Store> storeList = new ArrayList<Store>();

        for (int i = 0; i < storeNames.length; i++) {
            storeList.add(new Store(storeNames[i], storeInfos[i]));
        }

        listStores.setAdapter(new StoreAdapter(this, R.layout.store, storeList));
    }
    public void goHome(View view)
    {
        Intent intent = new Intent(Stores.this, First.class);
        startActivity(intent);
    }
    public void goAbout(View view)
    {
        Intent intent = new Intent(Stores.this, About.class);
        startActivity(intent);
    }
    public void goWhere(View view)
    {
        Intent intent = new Intent(Stores.this, Where.class);
        startActivity(intent);
    }
}
