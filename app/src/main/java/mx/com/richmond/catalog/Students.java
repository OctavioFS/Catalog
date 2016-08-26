package mx.com.richmond.catalog;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.sql.SQLException;

public class Students extends Fragment {
    Cursor c;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.students,container,false);

        if(getArguments()!=null){
            int seriesId = getArguments().getInt("seriesId");

            GridView cuadrosStudents = (GridView) v.findViewById(R.id.cuadrosStudents);
            cuadrosStudents.setAdapter(new studentsAdapter(getActivity(), seriesId));

            TextView content = (TextView) v.findViewById(R.id.content);
            if(cuadrosStudents.getCount()>0)
                content.setVisibility(View.GONE);
        }
        return v;
    }
}