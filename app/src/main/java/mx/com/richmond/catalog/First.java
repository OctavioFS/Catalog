package mx.com.richmond.catalog;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class First extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Typeface titulo = Typeface.createFromAsset(getAssets(), "Montserrat-Bold.otf");
        SpannableString s = new SpannableString("Richmond");
        s.setSpan(new CustomTypefaceSpan("", titulo), 0, s.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.logo);
        actionBar.setTitle(s);
        actionBar.setSubtitle("ELT Catalog 2016");
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        GridView cuadrosHome = (GridView) findViewById(R.id.cuadrosHome);
        cuadrosHome.setAdapter(new MyAdapter(this));

        cuadrosHome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent intent = new Intent(First.this, Series.class);
                intent.putExtra("series", position);
                startActivity(intent);
            }
        });
    }

    public void goHome(View view)
    {
        //Intent intent = new Intent(First.this, First.class);
        //startActivity(intent);
    }
    public void goAbout(View view)
    {
        Intent intent = new Intent(First.this, About.class);
        startActivity(intent);
    }
    public void goWhere(View view)
    {
        Intent intent = new Intent(First.this, Where.class);
        startActivity(intent);
    }

}
