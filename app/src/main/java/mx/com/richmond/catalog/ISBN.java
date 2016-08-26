package mx.com.richmond.catalog;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ISBN extends Fragment {
    Cursor c = null;
    LayoutInflater mInflater;

    class Codigo {
        String codigoName;
        String codigo1;
        String codigo2;
        String codigo3;
        String codigo4;
        String codigo5;
        String codigo6;
        String codigo7;
        String codigo8;
        String codigo9;
        String codigo10;
        String codigo11;
        String codigo12;
        String codigo13;
        String codigo14;
        String codigo15;
        String codigo16;
        String codigo17;
        String codigo18;
        String codigo19;
        String codigo20;
        String codigo21;
        String codigo22;
        String codigo23;
        String codigo24;
        String codigo25;
        String codigo26;
        String codigo27;
        String codigo28;
        String codigo29;
        String codigo30;
        String codigo31;
        String codigo32;
        String codigo33;
        String codigo34;
        String codigo35;
        String codigo36;
        String codigo37;
        String codigo38;
        String codigo39;
        String codigo40;
        String codigo41;
        String codigo42;
        String codigo43;
        String codigo44;
        String codigo45;
        String codigo46;
        String codigo47;
        String codigo48;
        String codigo49;
        String codigo50;
        String codigo51;
        String codigo52;
        String codigo53;
        String codigo54;
        String codigo55;
        String codigo56;
        String codigo57;

        public String getName() {
            return codigoName;
        }

        public void setName(String name) {
            codigoName = name;
        }

        public String getCodigo1() {
            return codigo1;
        }
        public String getCodigo2() {
            return codigo2;
        }
        public String getCodigo3() {
            return codigo3;
        }
        public String getCodigo4() {
            return codigo4;
        }
        public String getCodigo5() {
            return codigo5;
        }
        public String getCodigo6() {
            return codigo6;
        }
        public String getCodigo7() {
            return codigo7;
        }
        public String getCodigo8() {
            return codigo8;
        }
        public String getCodigo9() {
            return codigo9;
        }
        public String getCodigo10() {
            return codigo10;
        }
        public String getCodigo11() {
            return codigo11;
        }
        public String getCodigo12() {
            return codigo12;
        }
        public String getCodigo13() {
            return codigo13;
        }
        public String getCodigo14() {
            return codigo14;
        }
        public String getCodigo15() {
            return codigo15;
        }
        public String getCodigo16() {
            return codigo16;
        }
        public String getCodigo17() {
            return codigo17;
        }
        public String getCodigo18() {
            return codigo18;
        }
        public String getCodigo19() {
            return codigo19;
        }
        public String getCodigo20() {
            return codigo20;
        }
        public String getCodigo21() {
            return codigo21;
        }
        public String getCodigo22() {
            return codigo22;
        }
        public String getCodigo23() {
            return codigo23;
        }
        public String getCodigo24() {
            return codigo24;
        }
        public String getCodigo25() {
            return codigo25;
        }
        public String getCodigo26() {
            return codigo26;
        }
        public String getCodigo27() {
            return codigo27;
        }
        public String getCodigo28() {
            return codigo28;
        }
        public String getCodigo29() {
            return codigo29;
        }
        public String getCodigo30() {
            return codigo30;
        }
        public String getCodigo31() {
            return codigo31;
        }
        public String getCodigo32() {
            return codigo32;
        }
        public String getCodigo33() {
            return codigo33;
        }
        public String getCodigo34() {
            return codigo34;
        }
        public String getCodigo35() {
            return codigo35;
        }
        public String getCodigo36() {
            return codigo36;
        }
        public String getCodigo37() {
            return codigo37;
        }
        public String getCodigo38() {
            return codigo38;
        }
        public String getCodigo39() {
            return codigo39;
        }
        public String getCodigo40() {
            return codigo40;
        }
        public String getCodigo41() {
            return codigo41;
        }
        public String getCodigo42() {
            return codigo42;
        }
        public String getCodigo43() {
            return codigo43;
        }
        public String getCodigo44() {
            return codigo44;
        }
        public String getCodigo45() {
            return codigo45;
        }
        public String getCodigo46() {
            return codigo46;
        }
        public String getCodigo47() {
            return codigo47;
        }
        public String getCodigo48() {
            return codigo48;
        }
        public String getCodigo49() {
            return codigo49;
        }
        public String getCodigo50() {
            return codigo50;
        }
        public String getCodigo51() {
            return codigo51;
        }
        public String getCodigo52() {
            return codigo52;
        }
        public String getCodigo53() {
            return codigo53;
        }
        public String getCodigo54() {
            return codigo54;
        }
        public String getCodigo55() {
            return codigo55;
        }
        public String getCodigo56() {
            return codigo56;
        }
        public String getCodigo57() {
            return codigo57;
        }

        public Codigo(String cName,String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9, String c10,String c11,String c12,String c13,String c14,String c15,String c16,String c17,String c18,String c19,String c20,String c21,String c22,String c23,String c24,String c25,String c26,String c27,String c28,String c29,String c30,String c31,String c32,String c33,String c34,String c35,String c36,String c37,String c38,String c39,String c40,String c41,String c42,String c43,String c44,String c45,String c46,String c47,String c48,String c49,String c50,String c51,String c52,String c53,String c54,String c55,String c56,String c57) {
            codigoName = cName;
            codigo1 = c1;
            codigo2 = c2;
            codigo3 = c3;
            codigo4 = c4;
            codigo5 = c5;
            codigo6 = c6;
            codigo7 = c7;
            codigo8 = c8;
            codigo9 = c9;
            codigo10 = c10;
            codigo11 = c11;
            codigo12 = c12;
            codigo13 = c13;
            codigo14 = c14;
            codigo15 = c15;
            codigo16 = c16;
            codigo17 = c17;
            codigo18 = c18;
            codigo19 = c19;
            codigo20 = c20;
            codigo21 = c21;
            codigo22 = c22;
            codigo23 = c23;
            codigo24 = c24;
            codigo25 = c25;
            codigo26 = c26;
            codigo27 = c27;
            codigo28 = c28;
            codigo29 = c29;
            codigo30 = c30;
            codigo31 = c31;
            codigo32 = c32;
            codigo33 = c33;
            codigo34 = c34;
            codigo35 = c35;
            codigo36 = c36;
            codigo37 = c37;
            codigo38 = c38;
            codigo39 = c39;
            codigo40 = c40;
            codigo41 = c41;
            codigo42 = c42;
            codigo43 = c43;
            codigo44 = c44;
            codigo45 = c45;
            codigo46 = c46;
            codigo47 = c47;
            codigo48 = c48;
            codigo49 = c49;
            codigo50 = c50;
            codigo51 = c51;
            codigo52 = c52;
            codigo53 = c53;
            codigo54 = c54;
            codigo55 = c55;
            codigo56 = c56;
            codigo57 = c57;
        }
    }

    public class CodigoAdapter extends ArrayAdapter<Codigo> {
        private ArrayList<Codigo> items;
        private CodigoViewHolder codigoHolder;

        private class CodigoViewHolder {
            TextView name;
            TextView codigos;
        }

        public CodigoAdapter(Context context, int tvResId, ArrayList<Codigo> items) {
            super(context, tvResId, items);
            this.items = items;
        }

        @Override
        public View getView(int pos, View convertView, ViewGroup parent) {
            mInflater = LayoutInflater.from(getActivity());
            View v = convertView;
            if (v == null) {
                v = mInflater.inflate(R.layout.codigo, null);
                codigoHolder = new CodigoViewHolder();
                codigoHolder.name = (TextView)v.findViewById(R.id.titISBN);
                codigoHolder.codigos = (TextView)v.findViewById(R.id.codigos);
                v.setTag(codigoHolder);
            } else codigoHolder = (CodigoViewHolder)v.getTag();

            Codigo codigo = items.get(pos);
            String[] c = new String[57];
            String codigos = "";
            if (codigo != null) {
                codigoHolder.name.setText(codigo.getName());


                if(codigo.getCodigo1().length()>0)
                    codigos = codigos + "\nLevel N - " + codigo.getCodigo1();
                if(codigo.getCodigo2().length()>0)
                    codigos = codigos + "\nLevel 1 - " + codigo.getCodigo2();
                if(codigo.getCodigo3().length()>0)
                    codigos = codigos + "\nLevel 2 - " + codigo.getCodigo3();
                if(codigo.getCodigo4().length()>0)
                    codigos = codigos + "\nLevel 3 - " + codigo.getCodigo4();
                if(codigo.getCodigo5().length()>0)
                    codigos = codigos + "\nLevel 4 - " + codigo.getCodigo5();
                if(codigo.getCodigo6().length()>0)
                    codigos = codigos + "\nLevel 5 - " + codigo.getCodigo6();
                if(codigo.getCodigo7().length()>0)
                    codigos = codigos + "\nLevel 6 - " + codigo.getCodigo7();
                if(codigo.getCodigo8().length()>0)
                    codigos = codigos + "\nLevel K - " + codigo.getCodigo8();
                if(codigo.getCodigo9().length()>0)
                    codigos = codigos + "\nA1+ - " + codigo.getCodigo9();
                if(codigo.getCodigo10().length()>0)
                    codigos = codigos + "\nA2 - " + codigo.getCodigo10();
                if(codigo.getCodigo11().length()>0)
                    codigos = codigos + "\nB1 - " + codigo.getCodigo11();
                if(codigo.getCodigo12().length()>0)
                    codigos = codigos + "\nB1+ - " + codigo.getCodigo12();
                if(codigo.getCodigo13().length()>0)
                    codigos = codigos + "\nB2 - " + codigo.getCodigo13();
                if(codigo.getCodigo14().length()>0)
                    codigos = codigos + "\nC1 - " + codigo.getCodigo14();
                if(codigo.getCodigo15().length()>0)
                    codigos = codigos + "\nStarter - " + codigo.getCodigo15();
                if(codigo.getCodigo16().length()>0)
                    codigos = codigos + "\nA - " + codigo.getCodigo16();
                if(codigo.getCodigo17().length()>0)
                    codigos = codigos + "\nB - " + codigo.getCodigo17();
                if(codigo.getCodigo18().length()>0)
                    codigos = codigos + "\nC - " + codigo.getCodigo18();
                if(codigo.getCodigo19().length()>0)
                    codigos = codigos + "\nD - " + codigo.getCodigo19();
                if(codigo.getCodigo20().length()>0)
                    codigos = codigos + "\nE - " + codigo.getCodigo20();
                if(codigo.getCodigo21().length()>0)
                    codigos = codigos + "\nF - " + codigo.getCodigo21();
                if(codigo.getCodigo22().length()>0)
                    codigos = codigos + "\nBiology - " + codigo.getCodigo22();
                if(codigo.getCodigo23().length()>0)
                    codigos = codigos + "\nPhysics - " + codigo.getCodigo23();
                if(codigo.getCodigo24().length()>0)
                    codigos = codigos + "\nChemistry - " + codigo.getCodigo24();
                if(codigo.getCodigo25().length()>0)
                    codigos = codigos + "\nA - " + codigo.getCodigo25();
                if(codigo.getCodigo26().length()>0)
                    codigos = codigos + "\nB - " + codigo.getCodigo26();
                if(codigo.getCodigo27().length()>0)
                    codigos = codigos + "\nA - " + codigo.getCodigo27();
                if(codigo.getCodigo28().length()>0)
                    codigos = codigos + "\nB - " + codigo.getCodigo28();
                if(codigo.getCodigo29().length()>0)
                    codigos = codigos + "\nA - " + codigo.getCodigo29();
                if(codigo.getCodigo30().length()>0)
                    codigos = codigos + "\nB - " + codigo.getCodigo30();
                if(codigo.getCodigo31().length()>0)
                    codigos = codigos + "\nA1 - " + codigo.getCodigo31();
                if(codigo.getCodigo32().length()>0)
                    codigos = codigos + "\nA2 - " + codigo.getCodigo32();
                if(codigo.getCodigo33().length()>0)
                    codigos = codigos + "\nB1 - " + codigo.getCodigo33();
                if(codigo.getCodigo34().length()>0)
                    codigos = codigos + "\nB1+ - " + codigo.getCodigo34();
                if(codigo.getCodigo35().length()>0)
                    codigos = codigos + "\nB2 - " + codigo.getCodigo35();
                if(codigo.getCodigo36().length()>0)
                    codigos = codigos + "\nC1 - " + codigo.getCodigo36();
                if(codigo.getCodigo37().length()>0)
                    codigos = codigos + "\n1A - " + codigo.getCodigo37();
                if(codigo.getCodigo38().length()>0)
                    codigos = codigos + "\n1B - " + codigo.getCodigo38();
                if(codigo.getCodigo39().length()>0)
                    codigos = codigos + "\n2A - " + codigo.getCodigo39();
                if(codigo.getCodigo40().length()>0)
                    codigos = codigos + "\n2B - " + codigo.getCodigo40();
                if(codigo.getCodigo41().length()>0)
                    codigos = codigos + "\n3A - " + codigo.getCodigo41();
                if(codigo.getCodigo42().length()>0)
                    codigos = codigos + "\n3B - " + codigo.getCodigo42();
                if(codigo.getCodigo43().length()>0)
                    codigos = codigos + "\n4A - " + codigo.getCodigo43();
                if(codigo.getCodigo44().length()>0)
                    codigos = codigos + "\n4B - " + codigo.getCodigo44();
                if(codigo.getCodigo45().length()>0)
                    codigos = codigos + "\nElementary - " + codigo.getCodigo45();
                if(codigo.getCodigo46().length()>0)
                    codigos = codigos + "\nPre-intermediate - " + codigo.getCodigo46();
                if(codigo.getCodigo47().length()>0)
                    codigos = codigos + "\nIntermediate - " + codigo.getCodigo47();
                if(codigo.getCodigo48().length()>0)
                    codigos = codigos + "\nUpper-intermediate - " + codigo.getCodigo48();
                if(codigo.getCodigo49().length()>0)
                    codigos = codigos + "\nVisual Grammar A2 Elementary - " + codigo.getCodigo49();
                if(codigo.getCodigo50().length()>0)
                    codigos = codigos + "\nVisual grammar B1 Pre-intermediate - " + codigo.getCodigo50();
                if(codigo.getCodigo51().length()>0)
                    codigos = codigos + "\nVocabulary Builder B1 - " + codigo.getCodigo51();
                if(codigo.getCodigo52().length()>0)
                    codigos = codigos + "\nVocabulary Builder B2 - " + codigo.getCodigo52();
                if(codigo.getCodigo53().length()>0)
                    codigos = codigos + "\n" + codigo.getCodigo53();
                if(codigo.getCodigo54().length()>0)
                    codigos = codigos + "\nMovers - " + codigo.getCodigo54();
                if(codigo.getCodigo55().length()>0)
                    codigos = codigos + "\nFlyers - " + codigo.getCodigo55();
                if(codigo.getCodigo56().length()>0)
                    codigos = codigos + "\nKET - " + codigo.getCodigo56();
                if(codigo.getCodigo57().length()>0)
                    codigos = codigos + "\nPET - " + codigo.getCodigo57();

                codigoHolder.codigos.setText(codigos);
            }

            return v;
        }
    }

    
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.isbn,container,false);
        ListView listISBN = (ListView) v.findViewById(R.id.listISBN);
        
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

            int a = 0;
            String[] args = {""+seriesId};
            String[] cols = {"count(*)"};
            c = myDbHelper.query("isbn", cols, "idSeries=?", args, null, null, null);
            c.moveToFirst();
            int count= c.getInt(0);
            c.close();
            String[] codigoNames = new String[count];
            String[] codigo1 = new String[count];
            String[] codigo2 = new String[count];
            String[] codigo3 = new String[count];
            String[] codigo4 = new String[count];
            String[] codigo5 = new String[count];
            String[] codigo6 = new String[count];
            String[] codigo7 = new String[count];
            String[] codigo8 = new String[count];
            String[] codigo9 = new String[count];
            String[] codigo10 = new String[count];
            String[] codigo11 = new String[count];
            String[] codigo12 = new String[count];
            String[] codigo13 = new String[count];
            String[] codigo14 = new String[count];
            String[] codigo15 = new String[count];
            String[] codigo16 = new String[count];
            String[] codigo17 = new String[count];
            String[] codigo18 = new String[count];
            String[] codigo19 = new String[count];
            String[] codigo20 = new String[count];
            String[] codigo21 = new String[count];
            String[] codigo22 = new String[count];
            String[] codigo23 = new String[count];
            String[] codigo24 = new String[count];
            String[] codigo25 = new String[count];
            String[] codigo26 = new String[count];
            String[] codigo27 = new String[count];
            String[] codigo28 = new String[count];
            String[] codigo29 = new String[count];
            String[] codigo30 = new String[count];
            String[] codigo31 = new String[count];
            String[] codigo32 = new String[count];
            String[] codigo33 = new String[count];
            String[] codigo34 = new String[count];
            String[] codigo35 = new String[count];
            String[] codigo36 = new String[count];
            String[] codigo37 = new String[count];
            String[] codigo38 = new String[count];
            String[] codigo39 = new String[count];
            String[] codigo40 = new String[count];
            String[] codigo41 = new String[count];
            String[] codigo42 = new String[count];
            String[] codigo43 = new String[count];
            String[] codigo44 = new String[count];
            String[] codigo45 = new String[count];
            String[] codigo46 = new String[count];
            String[] codigo47 = new String[count];
            String[] codigo48 = new String[count];
            String[] codigo49 = new String[count];
            String[] codigo50 = new String[count];
            String[] codigo51 = new String[count];
            String[] codigo52 = new String[count];
            String[] codigo53 = new String[count];
            String[] codigo54 = new String[count];
            String[] codigo55 = new String[count];
            String[] codigo56 = new String[count];
            String[] codigo57 = new String[count];

            c = myDbHelper.query("isbn", null, "idSeries=?", args, null, null, null);
            if(c.moveToFirst()){
                do{
                    codigoNames[a] = c.getString(2);
                    codigo1[a] = c.getString(3);
                    codigo2[a] = c.getString(4);
                    codigo3[a] = c.getString(5);
                    codigo4[a] = c.getString(6);
                    codigo5[a] = c.getString(7);
                    codigo6[a] = c.getString(8);
                    codigo7[a] = c.getString(9);
                    codigo8[a] = c.getString(10);
                    codigo9[a] = c.getString(11);
                    codigo10[a] = c.getString(12);
                    codigo11[a] = c.getString(13);
                    codigo12[a] = c.getString(14);
                    codigo13[a] = c.getString(15);
                    codigo14[a] = c.getString(16);
                    codigo15[a] = c.getString(17);
                    codigo16[a] = c.getString(18);
                    codigo17[a] = c.getString(19);
                    codigo18[a] = c.getString(20);
                    codigo19[a] = c.getString(21);
                    codigo20[a] = c.getString(22);
                    codigo21[a] = c.getString(23);
                    codigo22[a] = c.getString(24);
                    codigo23[a] = c.getString(25);
                    codigo24[a] = c.getString(26);
                    codigo25[a] = c.getString(27);
                    codigo26[a] = c.getString(28);
                    codigo27[a] = c.getString(29);
                    codigo28[a] = c.getString(30);
                    codigo29[a] = c.getString(31);
                    codigo30[a] = c.getString(32);
                    codigo31[a] = c.getString(33);
                    codigo32[a] = c.getString(34);
                    codigo33[a] = c.getString(35);
                    codigo34[a] = c.getString(36);
                    codigo35[a] = c.getString(37);
                    codigo36[a] = c.getString(38);
                    codigo37[a] = c.getString(39);
                    codigo38[a] = c.getString(40);
                    codigo39[a] = c.getString(41);
                    codigo40[a] = c.getString(42);
                    codigo41[a] = c.getString(43);
                    codigo42[a] = c.getString(44);
                    codigo43[a] = c.getString(45);
                    codigo44[a] = c.getString(46);
                    codigo45[a] = c.getString(47);
                    codigo46[a] = c.getString(48);
                    codigo47[a] = c.getString(49);
                    codigo48[a] = c.getString(50);
                    codigo49[a] = c.getString(51);
                    codigo50[a] = c.getString(52);
                    codigo51[a] = c.getString(53);
                    codigo52[a] = c.getString(54);
                    codigo53[a] = c.getString(55);
                    codigo54[a] = c.getString(56);
                    codigo55[a] = c.getString(57);
                    codigo56[a] = c.getString(58);
                    codigo57[a] = c.getString(59);
                    a++;
                } while(c.moveToNext());
            }
            
            ArrayList<Codigo> codigoList = new ArrayList<Codigo>();

            for (int i = 0; i < codigoNames.length; i++) {
                codigoList.add(new Codigo(codigoNames[i],codigo1[i],codigo2[i],codigo3[i],codigo4[i],codigo5[i],codigo6[i],codigo7[i],codigo8[i],codigo9[i],codigo10[i],codigo11[i],codigo12[i],codigo13[i],codigo14[i],codigo15[i],codigo16[i],codigo17[i],codigo18[i],codigo19[i],codigo20[i],codigo21[i],codigo22[i],codigo23[i],codigo24[i],codigo25[i],codigo26[i],codigo27[i],codigo28[i],codigo29[i],codigo30[i],codigo31[i],codigo32[i],codigo33[i],codigo34[i],codigo35[i],codigo36[i],codigo37[i],codigo38[i],codigo39[i],codigo40[i],codigo41[i],codigo42[i],codigo43[i],codigo44[i],codigo45[i],codigo46[i],codigo47[i],codigo48[i],codigo49[i],codigo50[i],codigo51[i],codigo52[i],codigo53[i],codigo54[i],codigo55[i],codigo56[i],codigo57[i]));
            }

            listISBN.setAdapter(new CodigoAdapter(getActivity(), R.layout.codigo, codigoList));

            TextView content = (TextView) v.findViewById(R.id.content);
            if(listISBN.getCount()>0)
                content.setVisibility(View.GONE);
        }
        return v;
    }
}
