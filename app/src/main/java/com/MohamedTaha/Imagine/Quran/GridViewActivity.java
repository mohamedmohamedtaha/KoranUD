package com.MohamedTaha.Imagine.Quran;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.GridView;
import android.widget.TextView;

import com.MohamedTaha.Imagine.Quran.Adapter.ImageAdapter;

import java.util.ArrayList;

public class GridViewActivity extends AppCompatActivity {
    //define ArrayList for put name elmshayekh
    public static ArrayList<String> sheks_names;
    //variable for store all Images in array
    public static int[] mThumbIds = {R.drawable.elsodes, R.drawable.elklbany, R.drawable.elmenshawy, R.drawable.elmenshawy,
            R.drawable.abdeelbaset, R.drawable.elhosary, R.drawable.elhosary, R.drawable.almaqely, R.drawable.msharyelafasy,
            R.drawable.sherem, R.drawable.eltblawy, R.drawable.eldosary, R.drawable.elgeheny, R.drawable.mohamedgbrer,
            R.drawable.naserelqatamy, R.drawable.elagamy, R.drawable.elbana, R.drawable.elqarashy, R.drawable.elqasem, R.drawable.bder};
    //variable for store all type telawa in array
    public static String[] mTypeELtelawa = {"حفص عن عاصم", "حفص عن عاصم", "حفص عن عاصم", "المصحف المجود", "المصحف المجود",
            "حفص عن عاصم", "المصحف المجود", "حفص عن عاصم", "حفص عن عاصم", "حفص عن عاصم", "حفص عن عاصم", "حفص عن عاصم",
            "حفص عن عاصم", "حفص عن عاصم", "حفص عن عاصم", "حفص عن عاصم", "حفص عن عاصم", "حفص عن عاصم", "حفص عن عاصم", "حفص عن عاصم"};
    // define ImageAdapter
    ImageAdapter imageAdapter;
    //define TextView for show the title
    TextView textNameSorActionBar;
    //define ArrayList for callback method getData()
    ArrayList<String> resultEntities;
    //define GridView for put the Images
    private GridView gridViewImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_grid_view);

        //  callback method titleActionBar()
        titleActionBar();

        //  callback method getAllwidgets()
        getAllWidgets();

        //  callback method setAdapter()
        setAdapter();
    }

    //method for define The variables
    private void getAllWidgets() {
        //link TextView defined by TextView in XML file
        textNameSorActionBar = (TextView) findViewById(R.id.tv_name_sora_actionBar);

        //show the text
        textNameSorActionBar.setText(getString(R.string.nameSheck));

        sheks_names = new ArrayList<>();
        resultEntities = new ArrayList<>();

        //link GridView defined by GridView in XML file
        gridViewImage = (GridView) findViewById(R.id.grid_view);
    }

    //method for define Names the mashayekh
    private ArrayList<String> getData() {
        sheks_names.add("عبدالرحمن السديس");
        sheks_names.add("عادل الكلباني");
        sheks_names.add("محمد صديق المنشاوي");
        sheks_names.add("محمد صديق المنشاوي");
        sheks_names.add("عبدالباسط عبدالصمد");
        sheks_names.add("محمود خليل الحصري");
        sheks_names.add("محمود خليل الحصري");
        sheks_names.add("ماهر المعيقلي");
        sheks_names.add("مشاري العفاسي");
        sheks_names.add("سعود الشريم");
        sheks_names.add("محمد محمود الطبلاوي");
        sheks_names.add("ياسر الدوسري");
        sheks_names.add("عبدالله الجهني");
        sheks_names.add("محمد جبريل");
        sheks_names.add("ناصر القطامي");
        sheks_names.add("أحمد العجمي");
        sheks_names.add("محمود علي البنا");
        sheks_names.add("ياسر القرشي");
        sheks_names.add("عبدالمحسن القاسم");
        sheks_names.add("صلاح البدري");

        return sheks_names;
    }

    //method for define Adapter and put the data in GridView
    private void setAdapter() {
        resultEntities = getData();
        imageAdapter = new ImageAdapter(this, resultEntities, mThumbIds, mTypeELtelawa);
        gridViewImage.setAdapter(imageAdapter);
    }

    //method define the actionBar
    public void titleActionBar() {
        ActionBar mActionbar = getSupportActionBar();

        mActionbar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        mActionbar.setDisplayShowCustomEnabled(true);
        mActionbar.setCustomView(R.layout.custom_actionbar);

        //For a void not show The ActionBar match_parent
        Toolbar toolbar = (Toolbar) mActionbar.getCustomView().getParent();
        toolbar.setContentInsetsAbsolute(0, 0);
        toolbar.getContentInsetEnd();
        toolbar.setPadding(0, 0, 0, 0);
    }

}



















