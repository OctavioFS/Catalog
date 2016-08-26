package mx.com.richmond.catalog;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;
import java.sql.SQLException;

public class Dig extends AppCompatActivity {

    int seriesId = 0;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dig);

        Typeface titulo = Typeface.createFromAsset(getAssets(), "Montserrat-Bold.otf");
        SpannableString s = new SpannableString("Richmond");
        s.setSpan(new CustomTypefaceSpan("", titulo), 0, s.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        String id = getIntent().getStringExtra("id");
        String name = getIntent().getStringExtra("name");
        seriesId = Integer.parseInt(id);
        int idImg = 0;

        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.logo);
        actionBar.setTitle(s);
        actionBar.setSubtitle("ELT Catalog 2016 > " + name);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        LinearLayout bottomBar = (LinearLayout) this.findViewById(R.id.bottomBar);
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.drawableDigital));
        bottomBar.setBackgroundColor(getResources().getColor(R.color.colorDigital));

        DatabaseHelper myDbHelper = new DatabaseHelper(this);
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
        String[] args = {""+seriesId};
        c = myDbHelper.query("digital", null, "_id=?", args, null, null, null);
        if(c.moveToFirst()) {
            TextView digitalName = (TextView) this.findViewById(R.id.digitalName);
            digitalName.setText(c.getString(2));
            TextView digitalDesc = (TextView) this.findViewById(R.id.digitalDesc);
            digitalDesc.setText(c.getString(3));
            ImageView digitalImage = (ImageView) this.findViewById(R.id.digitalImage);
            idImg = getResources().getIdentifier("mx.com.richmond.catalog:drawable/" + c.getString(4), null, null);
            if(idImg != 0)
                digitalImage.setImageResource(idImg);
            else
                digitalImage.setImageResource(R.drawable.outer_default);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        SubMenu sub = menu.addSubMenu("Option");
        sub.setIcon(R.drawable.menu);
        sub.add(0, 1, 0, "Preschool").setIcon(R.drawable.preschool);
        sub.add(0, 2, 0, "Primary").setIcon(R.drawable.primary);
        sub.add(0, 3, 0, "Secondary").setIcon(R.drawable.secondary);
        sub.add(0, 4, 0, "Young Adults").setIcon(R.drawable.young_adults);
        sub.add(0, 5, 0, "Supplementary").setIcon(R.drawable.supplementary);
        sub.add(0, 6, 0, "Exams").setIcon(R.drawable.exams);
        sub.add(0, 7, 0, "Digital").setIcon(R.drawable.digital);
        sub.add(0, 8, 0, "Readers").setIcon(R.drawable.readers);
        sub.getItem().setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()!=0) {
            Intent intent = new Intent(Dig.this, Series.class);
            intent.putExtra("series", item.getItemId()-1);
            startActivity(intent);
        }
        return true;
    }
    public void goHome(View view)
    {
        Intent intent = new Intent(Dig.this, First.class);
        startActivity(intent);
    }
    public void goAbout(View view)
    {
        Intent intent = new Intent(Dig.this, About.class);
        startActivity(intent);
    }
    public void goWhere(View view)
    {
        Intent intent = new Intent(Dig.this, Where.class);
        startActivity(intent);
    }
}
