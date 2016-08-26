package mx.com.richmond.catalog;

import android.content.Intent;
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
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Digital extends AppCompatActivity {

    int seriesId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digital);

        Typeface titulo = Typeface.createFromAsset(getAssets(), "Montserrat-Bold.otf");
        SpannableString s = new SpannableString("Richmond");
        s.setSpan(new CustomTypefaceSpan("", titulo), 0, s.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        String id = getIntent().getStringExtra("id");
        String name = getIntent().getStringExtra("name");
        seriesId = Integer.parseInt(id);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.logo);
        actionBar.setTitle(s);
        actionBar.setSubtitle("ELT Catalog 2016 > " + name);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        LinearLayout bottomBar = (LinearLayout) this.findViewById(R.id.bottomBar);
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.drawableDigital));
        bottomBar.setBackgroundColor(getResources().getColor(R.color.colorDigital));

        GridView cuadrosDigital = (GridView) findViewById(R.id.cuadrosDigital);
        cuadrosDigital.setAdapter(new digitalAdapter(this, seriesId));
        cuadrosDigital.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent intent = new Intent(Digital.this, Dig.class);
                intent.putExtra("id", ((TextView) v.findViewById(R.id.seriesId)).getText());
                intent.putExtra("name", ((TextView) v.findViewById(R.id.seriesName)).getText());
                startActivity(intent);
            }
        });
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
            Intent intent = new Intent(Digital.this, Series.class);
            intent.putExtra("series", item.getItemId()-1);
            startActivity(intent);
        }
        return true;
    }
    public void goHome(View view)
    {
        Intent intent = new Intent(Digital.this, First.class);
        startActivity(intent);
    }
    public void goAbout(View view)
    {
        Intent intent = new Intent(Digital.this, About.class);
        startActivity(intent);
    }
    public void goWhere(View view)
    {
        Intent intent = new Intent(Digital.this, Where.class);
        startActivity(intent);
    }
}
