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

public class Series extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series);

        Typeface titulo = Typeface.createFromAsset(getAssets(), "Montserrat-Bold.otf");
        SpannableString s = new SpannableString("Richmond");
        s.setSpan(new CustomTypefaceSpan("", titulo), 0, s.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        final int series = getIntent().getIntExtra("series", 0);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.logo);
        actionBar.setTitle(s);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        LinearLayout bottomBar = (LinearLayout) this.findViewById(R.id.bottomBar);

        switch(series){
            case 0:
                actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.drawablePreeschool));
                bottomBar.setBackgroundColor(getResources().getColor(R.color.colorPreeschool));
                actionBar.setSubtitle("ELT Catalog 2016 > Preschool");
                break;
            case 1:
                actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.drawablePrimaria));
                bottomBar.setBackgroundColor(getResources().getColor(R.color.colorPrimaria));
                actionBar.setSubtitle("ELT Catalog 2016 > Primary");
                break;
            case 2:
                actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.drawableSecundaria));
                bottomBar.setBackgroundColor(getResources().getColor(R.color.colorSecundaria));
                actionBar.setSubtitle("ELT Catalog 2016 > Secondary");
                break;
            case 3:
                actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.drawableYoung));
                bottomBar.setBackgroundColor(getResources().getColor(R.color.colorYoung));
                actionBar.setSubtitle("ELT Catalog 2016 > Young Adults");
                break;
            case 4:
                actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.drawableSupplementary));
                bottomBar.setBackgroundColor(getResources().getColor(R.color.colorSupplementary));
                actionBar.setSubtitle("ELT Catalog 2016 > Supplementary");
                break;
            case 5:
                actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.drawableExams));
                bottomBar.setBackgroundColor(getResources().getColor(R.color.colorExams));
                actionBar.setSubtitle("ELT Catalog 2016 > Exams");
                break;
            case 6:
                actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.drawableDigital));
                bottomBar.setBackgroundColor(getResources().getColor(R.color.colorDigital));
                actionBar.setSubtitle("ELT Catalog 2016 > Digital");
                break;
            case 7:
                actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.drawableReaders));
                bottomBar.setBackgroundColor(getResources().getColor(R.color.colorReaders));
                actionBar.setSubtitle("ELT Catalog 2016 > Readers");
                break;
            default:
                actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.drawablePrimary));
                bottomBar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                actionBar.setSubtitle("ELT Catalog 2016");
                break;
        }

        GridView cuadrosSeries = (GridView) findViewById(R.id.cuadrosSeries);
        cuadrosSeries.setAdapter(new seriesAdapter(this, series));
        cuadrosSeries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                CharSequence s = ((TextView) v.findViewById(R.id.seriesId)).getText();
                String ss= s.toString();
                if(series==7) {
                    Intent intent = new Intent(Series.this, Readers.class);
                    intent.putExtra("id", ((TextView) v.findViewById(R.id.seriesId)).getText());
                    intent.putExtra("name", ((TextView) v.findViewById(R.id.seriesName)).getText());
                    startActivity(intent);
                } else if((ss.indexOf("68")>=0)||(ss.indexOf("69")>=0)){
                    Intent intent = new Intent(Series.this, Digital.class);
                    intent.putExtra("id", ((TextView) v.findViewById(R.id.seriesId)).getText());
                    intent.putExtra("name", ((TextView) v.findViewById(R.id.seriesName)).getText());
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(Series.this, Description.class);
                    intent.putExtra("serie", series);
                    intent.putExtra("id", ((TextView) v.findViewById(R.id.seriesId)).getText());
                    intent.putExtra("name", ((TextView) v.findViewById(R.id.seriesName)).getText());
                    startActivity(intent);
                }
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
            Intent intent = new Intent(Series.this, Series.class);
            intent.putExtra("series", item.getItemId()-1);
            startActivity(intent);
        }
        return true;
    }

    public void goHome(View view)
    {
        Intent intent = new Intent(Series.this, First.class);
        startActivity(intent);
    }
    public void goAbout(View view)
    {
        Intent intent = new Intent(Series.this, About.class);
        startActivity(intent);
    }
    public void goWhere(View view)
    {
        Intent intent = new Intent(Series.this, Where.class);
        startActivity(intent);
    }
}
