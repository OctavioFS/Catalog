package mx.com.richmond.catalog;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.util.Linkify;
import android.view.View;
import android.widget.TextView;

import java.util.regex.Pattern;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Typeface titulo = Typeface.createFromAsset(getAssets(), "Montserrat-Bold.otf");
        SpannableString s = new SpannableString("Richmond");
        s.setSpan(new CustomTypefaceSpan("", titulo), 0, s.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.logo);
        actionBar.setTitle(s);
        actionBar.setSubtitle("ELT Catalog 2016 > About Us");
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        TextView t = (TextView)findViewById(R.id.textoAbout);
        t.setMovementMethod(new ScrollingMovementMethod());
        SpannableStringBuilder builder = new SpannableStringBuilder();
        String about1 = "Dear Teacher\n\nI’m very happy to introduce the ";
        String about2 = "Richmond's 2016 English Language Teaching Catalog.\n\n";
        SpannableString about2Spannable= new SpannableString(about2);
        String about3 = "Whether you are looking for materials for preschool or adult, in British or American English, ";
        String about4 = "in print or online, we offer a complete range of materials ";
        SpannableString about4Spannable= new SpannableString(about4);
        String about30 = "for both ";
        String about31 = "students ";
        SpannableString about31Spannable= new SpannableString(about31);
        String about32 = "and ";
        String about33 = "teachers.\n\n";
        SpannableString about33Spannable= new SpannableString(about33);
        String about5 = "Our publishing team here in Oxford and around the world are proud of all the exciting materials we’ve created in 2015, and we hope you will enjoy using them in your classroom.\nCheck out our beautiful preschool series, ";
        String about6 = "Crickets";
        SpannableString about6Spannable= new SpannableString(about6);
        String about7 = ", on page 16, and the new ";
        String about8 = "Cubby House";
        SpannableString about8Spannable= new SpannableString(about8);
        String about9 = ", on page 8; our exciting range of primary courses for all kinds of teaching situations; and two innovative secondary courses, ";
        String about10 = "Achievers ";
        SpannableString about10Spannable= new SpannableString(about10);
        String about11 = "and the brand-new ";
        String about12 = "Stopwatch";
        SpannableString about12Spannable= new SpannableString(about12);
        String about13 = "; all with a full package of digital and print materials and support for teachers and students.\n\nFor older learners we are delighted to include several new titles for ";
        String about14 = "Cambridge ";
        SpannableString about14Spannable= new SpannableString(about14);
        String about15 = "and ";
        String about16 = "TOEFL® exams preparation";
        SpannableString about16Spannable= new SpannableString(about16);
        String about17 = "; ";
        String about18 = "English iDentities";
        SpannableString about18Spannable= new SpannableString(about18);
        String about19 = ", by Paul Seligson and Luiz Otávio Barros; our award-winning ";
        String about20 = "Business Mazes";
        SpannableString about20Spannable= new SpannableString(about20);
        String about21 = ", available in app or print formats; and a wealth of other materials.\nYou can see all of these courses and more on our website at ";
        String about22 = "www.richmond.com.mx\n\n";
        SpannableString about22Spannable= new SpannableString(about22);
        String about23 = "There’s lots of digital practice for every course on the ";
        String about24 = "Richmond Learning Platform ";
        SpannableString about24Spannable= new SpannableString(about24);
        String about25 = "and ";
        String about26 = "Primary Spiral";
        SpannableString about26Spannable= new SpannableString(about26);
        String about27 = ", plus some fun apps and digital books.\n\nWe develop our projects with the help of teachers all over the world, and we’d love to hear from you, wherever you are. If you would like to be involved in future Richmond courses, by giving us product feedback, writing a review, compiling a worksheet or running a pilot class with our new materials, please do get in touch with me at ";
        String about28 = "dtricker@richmondelt.com\n\n";
        SpannableString about28Spannable= new SpannableString(about28);
        String about29 = "With very best wishes\n\nDeborah Tricker\nGroup Publishing Director, Richmond";
        int rosa = Color.parseColor("#fc1488");
        int naranja = Color.parseColor("#fd8d28");
        int morado = Color.parseColor("#904094");
        int cafe = Color.parseColor("#bf8c1e");
        int menta = Color.parseColor("#18b494");
        int verde = Color.parseColor("#84af20");

        builder.append(about1);
        about2Spannable.setSpan(new ForegroundColorSpan(rosa), 0, about2.length(), 0);
        about2Spannable.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, about2.length(), 0);
        builder.append(about2Spannable);
        builder.append(about3);
        about4Spannable.setSpan(new ForegroundColorSpan(rosa), 0, about4.length(), 0);
        about4Spannable.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, about4.length(), 0);
        builder.append(about4Spannable);
        builder.append(about30);
        about31Spannable.setSpan(new ForegroundColorSpan(rosa), 0, about31.length(), 0);
        about31Spannable.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, about31.length(), 0);
        builder.append(about31Spannable);
        builder.append(about32);
        about33Spannable.setSpan(new ForegroundColorSpan(rosa), 0, about33.length(), 0);
        about33Spannable.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, about33.length(), 0);
        builder.append(about33Spannable);
        builder.append(about5);
        about6Spannable.setSpan(new ForegroundColorSpan(naranja), 0, about6.length(), 0);
        about6Spannable.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, about6.length(), 0);
        builder.append(about6Spannable);
        builder.append(about7);
        about8Spannable.setSpan(new ForegroundColorSpan(naranja), 0, about8.length(), 0);
        about8Spannable.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, about8.length(), 0);
        builder.append(about8Spannable);
        builder.append(about9);
        about10Spannable.setSpan(new ForegroundColorSpan(morado), 0, about10.length(), 0);
        about10Spannable.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, about10.length(), 0);
        builder.append(about10Spannable);
        builder.append(about11);
        about12Spannable.setSpan(new ForegroundColorSpan(morado), 0, about12.length(), 0);
        about12Spannable.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, about12.length(), 0);
        builder.append(about12Spannable);
        builder.append(about13);
        about14Spannable.setSpan(new ForegroundColorSpan(cafe), 0, about14.length(), 0);
        about14Spannable.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, about14.length(), 0);
        builder.append(about14Spannable);
        builder.append(about15);
        about16Spannable.setSpan(new ForegroundColorSpan(cafe), 0, about16.length(), 0);
        about16Spannable.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, about16.length(), 0);
        builder.append(about16Spannable);
        builder.append(about17);
        about18Spannable.setSpan(new ForegroundColorSpan(menta), 0, about18.length(), 0);
        about18Spannable.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, about18.length(), 0);
        builder.append(about18Spannable);
        builder.append(about19);
        about20Spannable.setSpan(new ForegroundColorSpan(verde), 0, about20.length(), 0);
        about20Spannable.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, about20.length(), 0);
        builder.append(about20Spannable);
        builder.append(about21);
        about22Spannable.setSpan(new ForegroundColorSpan(rosa), 0, about22.length(), 0);
        about22Spannable.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, about22.length(), 0);
        builder.append(about22Spannable);
        builder.append(about23);
        about24Spannable.setSpan(new ForegroundColorSpan(menta), 0, about24.length(), 0);
        about24Spannable.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, about24.length(), 0);
        builder.append(about24Spannable);
        builder.append(about25);
        about26Spannable.setSpan(new ForegroundColorSpan(menta), 0, about26.length(), 0);
        about26Spannable.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, about26.length(), 0);
        builder.append(about26Spannable);
        builder.append(about27);
        about28Spannable.setSpan(new ForegroundColorSpan(rosa), 0, about28.length(), 0);
        about28Spannable.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, about28.length(), 0);
        builder.append(about28Spannable);
        builder.append(about29);

        t.setText(builder, TextView.BufferType.SPANNABLE);
        t.setMovementMethod(LinkMovementMethod.getInstance());

        Linkify.addLinks(t, Linkify.ALL);
    }

    public void goHome(View view)
    {
        Intent intent = new Intent(About.this, First.class);
        startActivity(intent);
    }
    public void goAbout(View view)
    {
        //Intent intent = new Intent(About.this, About.class);
        //startActivity(intent);
    }
    public void goWhere(View view)
    {
        Intent intent = new Intent(About.this, Where.class);
        startActivity(intent);
    }
}
