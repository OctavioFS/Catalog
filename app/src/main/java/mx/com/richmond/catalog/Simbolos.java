package mx.com.richmond.catalog;

import android.app.ListActivity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Simbolos extends AppCompatActivity {

    String[] itemname ={
            "New Title",
            "Digital Resources",
            "DVD",
            "Audio CD",
            "App",
            "Microsite",
            "Videos",
            "CLIL",
            "Digital Book",
            "Exam-friendly Series",
            "iBook",
            "Richmond Spiral Platform",
            "Richmond Solution",
            "Richmond Learning Platform",
            "British English"
    };
    Integer[] imageId ={
            R.drawable.new_icon,
            R.drawable.digital_resources,
            R.drawable.dvd,
            R.drawable.audio,
            R.drawable.app,
            R.drawable.microsite,
            R.drawable.videos,
            R.drawable.clil,
            R.drawable.digital_book,
            R.drawable.exam_friendly,
            R.drawable.ibook,
            R.drawable.spiral,
            R.drawable.solution,
            R.drawable.learning,
            R.drawable.british
    };

    class Simbolo {
        String simboloName;
        Integer simboloImage;

        public String getName() {
            return simboloName;
        }

        public void setName(String name) {
            simboloName = name;
        }

        public Integer getImage() {
            return simboloImage;
        }

        public void setImage(Integer image) {
            simboloImage = image;
        }

        public Simbolo(String name, Integer image) {
            simboloName = name;
            simboloImage = image;
        }
    }

    public class SimboloAdapter extends ArrayAdapter<Simbolo> {
        private ArrayList<Simbolo> items;
        private SimboloViewHolder simboloHolder;

        private class SimboloViewHolder {
            TextView name;
            ImageView image;
        }

        public SimboloAdapter(Context context, int tvResId, ArrayList<Simbolo> items) {
            super(context, tvResId, items);
            this.items = items;
        }

        @Override
        public View getView(int pos, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater vi = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.list, null);
                simboloHolder = new SimboloViewHolder();
                simboloHolder.name = (TextView)v.findViewById(R.id.itemName);
                simboloHolder.image = (ImageView)v.findViewById(R.id.iconList);
                v.setTag(simboloHolder);
            } else simboloHolder = (SimboloViewHolder)v.getTag();

            Simbolo simbolo = items.get(pos);

            if (simbolo != null) {
                simboloHolder.name.setText(simbolo.getName());
                simboloHolder.image.setImageResource(simbolo.getImage());
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
        setContentView(R.layout.simbolos);


        ListView listSimbolos = (ListView) findViewById(R.id.list);

        ArrayList<Simbolo> simboloList = new ArrayList<Simbolo>();

        for (int i = 0; i < itemname.length; i++) {
            simboloList.add(new Simbolo(itemname[i], imageId[i]));
        }

        listSimbolos.setAdapter(new SimboloAdapter(this, R.layout.list, simboloList));

    }
}
