package mx.com.richmond.catalog;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.view.SubMenu;


public class Description extends AppCompatActivity {

    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[]={"Description","For Students","For Teachers","ISBN"};
    int Numboftabs = 4;
    int seriesId = 0;
    Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Typeface titulo = Typeface.createFromAsset(getAssets(), "Montserrat-Bold.otf");
        SpannableString s = new SpannableString("Richmond");
        s.setSpan(new CustomTypefaceSpan("", titulo), 0, s.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        int serie = getIntent().getIntExtra("serie", 0);
        String id = getIntent().getStringExtra("id");
        String name = getIntent().getStringExtra("name");
        seriesId = Integer.parseInt(id);
        bundle.putInt("seriesId", seriesId);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.logo);
        actionBar.setTitle(s);
        actionBar.setSubtitle("ELT Catalog 2016 > " + name);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        LinearLayout bottomBar = (LinearLayout) this.findViewById(R.id.bottomBar);


        adapter =  new ViewPagerAdapter(getSupportFragmentManager(),Titles,Numboftabs,Integer.parseInt(id));
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true);
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(android.R.color.black);
            }
        });
        tabs.setViewPager(pager);
        tabs.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onPageScrollStateChanged(int pos) {
                // TODO Auto-generated method stub
            }
        });


        switch(serie){
            case 0:
                actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.drawablePreeschool));
                bottomBar.setBackgroundColor(getResources().getColor(R.color.colorPreeschool));
                tabs.setBackgroundColor(getResources().getColor(R.color.colorPreeschool));
                break;
            case 1:
                actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.drawablePrimaria));
                bottomBar.setBackgroundColor(getResources().getColor(R.color.colorPrimaria));
                tabs.setBackgroundColor(getResources().getColor(R.color.colorPrimaria));
                break;
            case 2:
                actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.drawableSecundaria));
                bottomBar.setBackgroundColor(getResources().getColor(R.color.colorSecundaria));
                tabs.setBackgroundColor(getResources().getColor(R.color.colorSecundaria));
                break;
            case 3:
                actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.drawableYoung));
                bottomBar.setBackgroundColor(getResources().getColor(R.color.colorYoung));
                tabs.setBackgroundColor(getResources().getColor(R.color.colorYoung));
                break;
            case 4:
                actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.drawableSupplementary));
                bottomBar.setBackgroundColor(getResources().getColor(R.color.colorSupplementary));
                tabs.setBackgroundColor(getResources().getColor(R.color.colorSupplementary));
                break;
            case 5:
                actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.drawableExams));
                bottomBar.setBackgroundColor(getResources().getColor(R.color.colorExams));
                tabs.setBackgroundColor(getResources().getColor(R.color.colorExams));
                break;
            case 6:
                actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.drawableDigital));
                bottomBar.setBackgroundColor(getResources().getColor(R.color.colorDigital));
                tabs.setBackgroundColor(getResources().getColor(R.color.colorDigital));
                break;
            case 7:
                actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.drawableReaders));
                bottomBar.setBackgroundColor(getResources().getColor(R.color.colorReaders));
                tabs.setBackgroundColor(getResources().getColor(R.color.colorReaders));
                break;
            default:
                actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.drawablePrimary));
                bottomBar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                tabs.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                break;
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
            Intent intent = new Intent(Description.this, Series.class);
            intent.putExtra("series", item.getItemId()-1);
            startActivity(intent);
        }
        return true;
    }
    public void goHome(View view)
    {
        Intent intent = new Intent(Description.this, First.class);
        startActivity(intent);
    }
    public void goAbout(View view)
    {
        Intent intent = new Intent(Description.this, About.class);
        startActivity(intent);
    }
    public void goWhere(View view)
    {
        Intent intent = new Intent(Description.this, Where.class);
        startActivity(intent);
    }
}
