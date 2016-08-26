package mx.com.richmond.catalog;

import android.app.Dialog;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;
import java.sql.SQLException;

public class Desc extends Fragment {
    Cursor c;
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final Context context = getActivity();
        final View v =inflater.inflate(R.layout.desc,container,false);
        TextView textName = (TextView) v.findViewById(R.id.textName);
        TextView t = (TextView) v.findViewById(R.id.textView);
        ImageView innerImage = (ImageView) v.findViewById(R.id.innerImage);
        final LinearLayout btnOpenPopup = (LinearLayout) v.findViewById(R.id.icons);

        btnOpenPopup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Dialog dialog = new Dialog(context);

                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); //before
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); //before
                dialog.setContentView(R.layout.symbolkey);

                dialog.show();
            }
        });


        ImageView newIcon= (ImageView) v.findViewById(R.id.newIcon);
        ImageView britishIcon = (ImageView) v.findViewById(R.id.britishIcon);
        ImageView digitalResourcesIcon = (ImageView) v.findViewById(R.id.digitalResourcesIcon);
        ImageView dvdIcon = (ImageView) v.findViewById(R.id.dvdIcon);
        ImageView audioIcon = (ImageView) v.findViewById(R.id.audioIcon);
        ImageView appIcon = (ImageView) v.findViewById(R.id.appIcon);
        ImageView micrositeIcon = (ImageView) v.findViewById(R.id.micrositeIcon);
        ImageView videosIcon = (ImageView) v.findViewById(R.id.videosIcon);
        ImageView clilIcon = (ImageView) v.findViewById(R.id.clilIcon);
        ImageView digitalbookIcon = (ImageView) v.findViewById(R.id.digitalBookIcon);
        ImageView examFriendlyIcon = (ImageView) v.findViewById(R.id.examFriendlyIcon);
        ImageView iBookIcon = (ImageView) v.findViewById(R.id.iBookIcon);
        ImageView suggestedIcon = (ImageView) v.findViewById(R.id.suggestedIcon);
        ImageView spiralIcon = (ImageView) v.findViewById(R.id.spiralIcon);
        ImageView solutionIcon = (ImageView) v.findViewById(R.id.solutionIcon);
        ImageView learningIcon = (ImageView) v.findViewById(R.id.learningIcon);
        ImageView levelIcon = (ImageView) v.findViewById(R.id.levelIcon);

        if(getArguments()!=null){
            int seriesId = getArguments().getInt("seriesId");
            DatabaseHelper myDbHelper = new DatabaseHelper(getActivity());
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
            c = myDbHelper.query("series", null, "_id=?", args, null, null, null);
            if(c.moveToFirst()){
                String description = c.getString(2);
                int idImg = getResources().getIdentifier("mx.com.richmond.catalog:drawable/" + c.getString(4), null, null);
                if(idImg != 0)
                    innerImage.setImageResource(idImg);
                else
                    innerImage.setImageResource(R.drawable.inner_default);
                if(c.getInt(6)<2)
                    levelIcon.setVisibility(View.GONE);
                else{
                    switch(c.getInt(6)){
                        case 2:
                            levelIcon.setImageResource(R.drawable.levels2);
                            break;
                        case 3:
                            levelIcon.setImageResource(R.drawable.levels3);
                            break;
                        case 4:
                            levelIcon.setImageResource(R.drawable.levels4);
                            break;
                        case 5:
                            levelIcon.setImageResource(R.drawable.levels5);
                            break;
                        case 6:
                            levelIcon.setImageResource(R.drawable.levels6);
                            break;
                        case 7:
                            levelIcon.setImageResource(R.drawable.levels7);
                            break;
                    }
                }
                if(c.getString(7).isEmpty())
                    suggestedIcon.setVisibility(View.GONE);
                else{
                    switch(c.getString(7)){
                        case "90/120":
                            suggestedIcon.setImageResource(R.drawable.hours90_120);
                            break;
                        case "80/120":
                            suggestedIcon.setImageResource(R.drawable.hours80_120);
                            break;
                        case "80/100":
                            suggestedIcon.setImageResource(R.drawable.hours80_100);
                            break;
                        case "7/10":
                            suggestedIcon.setImageResource(R.drawable.hours7_10);
                            break;
                        case "7+":
                            suggestedIcon.setImageResource(R.drawable.hours7);
                            break;
                        case "5/7.5":
                            suggestedIcon.setImageResource(R.drawable.hours5_75);
                            break;
                        case "5/10":
                            suggestedIcon.setImageResource(R.drawable.hours5_10);
                            break;
                        case "5+":
                            suggestedIcon.setImageResource(R.drawable.hours5);
                            break;
                        case "45/60":
                            suggestedIcon.setImageResource(R.drawable.hours45_60);
                            break;
                        case "3/5":
                            suggestedIcon.setImageResource(R.drawable.hours3_5);
                            break;
                        case "2/4":
                            suggestedIcon.setImageResource(R.drawable.hours2_4);
                            break;
                        case "10+":
                            suggestedIcon.setImageResource(R.drawable.hours10);
                            break;
                        case "1/3":
                            suggestedIcon.setImageResource(R.drawable.hours1_3);
                            break;
                        case "3":
                            suggestedIcon.setImageResource(R.drawable.hours3);
                            break;
                        case "45":
                            suggestedIcon.setImageResource(R.drawable.hours45);
                            break;
                        case "35":
                            suggestedIcon.setImageResource(R.drawable.hours35);
                            break;
                    }
                }
                if(c.getInt(8)!=1)
                    newIcon.setVisibility(View.GONE);
                if(c.getInt(9)!=1)
                    britishIcon.setVisibility(View.GONE);
                if(c.getInt(10)!=1)
                    digitalResourcesIcon.setVisibility(View.GONE);
                if(c.getInt(11)!=1)
                    dvdIcon.setVisibility(View.GONE);
                if(c.getInt(12)!=1)
                    audioIcon.setVisibility(View.GONE);
                if(c.getInt(13)!=1)
                    appIcon.setVisibility(View.GONE);
                if(c.getInt(14)!=1)
                    micrositeIcon.setVisibility(View.GONE);
                if(c.getInt(15)!=1)
                    videosIcon.setVisibility(View.GONE);
                if(c.getInt(16)!=1)
                    clilIcon.setVisibility(View.GONE);
                if(c.getInt(17)!=1)
                    digitalbookIcon.setVisibility(View.GONE);
                if(c.getInt(18)!=1)
                    examFriendlyIcon.setVisibility(View.GONE);
                if(c.getInt(19)!=1)
                    iBookIcon.setVisibility(View.GONE);
                if(c.getInt(20)!=1)
                    spiralIcon.setVisibility(View.GONE);
                if(c.getInt(21)!=1)
                    solutionIcon.setVisibility(View.GONE);
                if(c.getInt(22)!=1)
                    learningIcon.setVisibility(View.GONE);
                textName.setText(c.getString(1));
                t.setText(description);
            }
        }
        return v;
    }

}