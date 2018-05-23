package com.MohamedTaha.Imagine.Quran;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.MohamedTaha.Imagine.Quran.Adapter.RecycleViewReaderAdapter;

import java.util.ArrayList;

import android.widget.TextView;
import android.widget.Toast;

import com.MohamedTaha.Imagine.Quran.getData.Model;

import java.util.List;

import static com.MohamedTaha.Imagine.Quran.Adapter.ImageAdapter.SHEKH_ID;
import static com.MohamedTaha.Imagine.Quran.Adapter.ImageAdapter.SHEKH_NAME;
import static com.MohamedTaha.Imagine.Quran.Adapter.RecycleViewReaderAdapter.NAME;
import static com.MohamedTaha.Imagine.Quran.Adapter.RecycleViewReaderAdapter.URLLINK;


public class ListSoundReader extends AppCompatActivity {
    //  private List<Model> respones;
    public static List<Model> respones;
    //for define RecycleViewReaderAdapter
    RecycleViewReaderAdapter recycleViewAdaptor;
    //  private List<Model> model_list;
    List<Model> model_list = new ArrayList<>();
    //variable for shekh_id
    int shekh_id;
    //Arrays for links el Qoran
    String[] ArrayLinkYaserEldosary, ArrayLinkElhosaryMgwad, ArrayLinkElmenshawyHafs, ArrayLinkElmenshawyMgwad, ArrayLinkAbdlaElgeheny, ArrayLinkMAHER_ELMEAQLY, ArrayLinkAbdelbasetMgwad, ArrayLinkSoaadElsherem, ArrayLinkALTABLAWY, ArrayLinkElklbanyHafs, ArrayLinkElsodes, ArrayLinkMsharyElafasy, ArrayLinkElhosaryHAfs, ArrayLinkMohamedGbrer, ArrayLinkNaserElqatamy, ArrayLinkElagamy, ArrayLinkElbana, ArrayLinkElqarashy, ArrayLinkElqasem, ArrayLinkBder;
    //define TextView
    TextView textNameSorActionBar;
    //for define RecyclerView
    private RecyclerView recycleViewSound;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_list_sound);
        //callback method  titleActionBar()
        titleActionBar();
        respones = new ArrayList<>();

        //Intent for fetch shekh_id from GridViewActivity
        Intent i = getIntent();
        shekh_id = i.getIntExtra(SHEKH_ID, 0);

        //callback method defineVirable()
        defineVariable();


        recycleViewSound.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        respones = getShekhAyat(shekh_id);
        recycleViewAdaptor = new RecycleViewReaderAdapter(getApplicationContext(), respones);
        recycleViewSound.setAdapter(recycleViewAdaptor);

        //Action on RecycleView
        recycleViewSound.addOnItemTouchListener(new RecycleViewReaderAdapter.RecycleTouchListener(getApplicationContext(),
                recycleViewSound, new RecycleViewReaderAdapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(ListSoundReader.this, MainActivity.class);
                intent.putExtra(NAME, respones.get(position).getSora_name());
                intent.putExtra(URLLINK, respones.get(position).getSora_link());
                intent.putExtra(SHEKH_NAME, getIntent().getStringExtra(SHEKH_NAME));
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {
                Intent intent = new Intent(ListSoundReader.this, MainActivity.class);
                intent.putExtra(NAME, respones.get(position).getSora_name());
                intent.putExtra(URLLINK, respones.get(position).getSora_link());
                intent.putExtra(SHEKH_NAME, getIntent().getStringExtra(SHEKH_NAME));
                startActivity(intent);
            }
        }));
    }

    //define method for select specifect shekh
    private List<Model> getShekhAyat(int posision) {
        String[] soar = null;
        switch (posision) {
            case 0:
                soar = (getResources().getStringArray(R.array.name_allSwar));
                for (int i = 0; i < soar.length; ++i) {
                    Model model = new Model();
                    model.setSora_name(soar[i]);
                    model.setSora_link(ArrayLinkElsodes[i]);
                    model_list.add(model);
                }
                break;
            case 1:
                soar = (getResources().getStringArray(R.array.name_allSwar));
                for (int i = 0; i < soar.length; ++i) {
                    Model model = new Model();
                    model.setSora_name(soar[i]);
                    model.setSora_link(ArrayLinkElklbanyHafs[i]);
                    model_list.add(model);
                }
                break;
            case 2:
                soar = (getResources().getStringArray(R.array.name_allSwar));
                for (int i = 0; i < soar.length; ++i) {
                    Model model = new Model();
                    model.setSora_name(soar[i]);
                    model.setSora_link(ArrayLinkElmenshawyHafs[i]);
                    model_list.add(model);
                }
                break;
            case 3:
                soar = (getResources().getStringArray(R.array.name_allSwar));
                for (int i = 0; i < soar.length; ++i) {
                    Model model = new Model();
                    model.setSora_name(soar[i]);
                    model.setSora_link(ArrayLinkElmenshawyMgwad[i]);
                    model_list.add(model);
                }
                break;
            case 4:
                soar = (getResources().getStringArray(R.array.name_allSwar));
                for (int i = 0; i < soar.length; ++i) {
                    Model model = new Model();
                    model.setSora_name(soar[i]);
                    model.setSora_link(ArrayLinkAbdelbasetMgwad[i]);
                    model_list.add(model);
                }
                break;
            case 5:
                soar = (getResources().getStringArray(R.array.name_allSwar));
                for (int i = 0; i < soar.length; ++i) {
                    Model model = new Model();
                    model.setSora_name(soar[i]);
                    model.setSora_link(ArrayLinkElhosaryHAfs[i]);
                    model_list.add(model);
                }
                break;
            case 6:
                soar = (getResources().getStringArray(R.array.name_allSwar));
                for (int i = 0; i < soar.length; ++i) {
                    Model model = new Model();
                    model.setSora_name(soar[i]);
                    model.setSora_link(ArrayLinkElhosaryMgwad[i]);
                    model_list.add(model);
                }
                break;
            case 7:
                soar = (getResources().getStringArray(R.array.name_allSwar));
                for (int i = 0; i < soar.length; ++i) {
                    Model model = new Model();
                    model.setSora_name(soar[i]);
                    model.setSora_link(ArrayLinkMAHER_ELMEAQLY[i]);
                    model_list.add(model);
                }
                break;
            case 8:
                soar = (getResources().getStringArray(R.array.name_allSwar));
                for (int i = 0; i < soar.length; ++i) {
                    Model model = new Model();
                    model.setSora_name(soar[i]);
                    model.setSora_link(ArrayLinkMsharyElafasy[i]);
                    model_list.add(model);
                }
                break;
            case 9:
                soar = (getResources().getStringArray(R.array.name_allSwar));
                for (int i = 0; i < soar.length; ++i) {
                    Model model = new Model();
                    model.setSora_name(soar[i]);
                    model.setSora_link(ArrayLinkSoaadElsherem[i]);
                    model_list.add(model);
                }
                break;
            case 10:
                soar = (getResources().getStringArray(R.array.name_allSwar));
                for (int i = 0; i < soar.length; ++i) {
                    Model model = new Model();
                    model.setSora_name(soar[i]);
                    model.setSora_link(ArrayLinkALTABLAWY[i]);
                    model_list.add(model);
                }
                break;
            case 11:
                soar = (getResources().getStringArray(R.array.name_allSwar));
                for (int i = 0; i < soar.length; ++i) {
                    Model model = new Model();
                    model.setSora_name(soar[i]);
                    model.setSora_link(ArrayLinkYaserEldosary[i]);
                    model_list.add(model);
                }
                break;
            case 12:
                soar = (getResources().getStringArray(R.array.name_allSwar));
                for (int i = 0; i < soar.length; ++i) {
                    Model model = new Model();
                    model.setSora_name(soar[i]);
                    model.setSora_link(ArrayLinkAbdlaElgeheny[i]);
                    model_list.add(model);
                }
                break;
            case 13:
                soar = (getResources().getStringArray(R.array.name_allSwar));
                for (int i = 0; i < soar.length; ++i) {
                    Model model = new Model();
                    model.setSora_name(soar[i]);
                    model.setSora_link(ArrayLinkMohamedGbrer[i]);
                    model_list.add(model);
                }
                break;
            case 14:
                soar = (getResources().getStringArray(R.array.name_allSwar));
                for (int i = 0; i < soar.length; ++i) {
                    Model model = new Model();
                    model.setSora_name(soar[i]);
                    model.setSora_link(ArrayLinkNaserElqatamy[i]);
                    model_list.add(model);
                }
                break;
            case 15:
                soar = (getResources().getStringArray(R.array.name_allSwar));
                for (int i = 0; i < soar.length; ++i) {
                    Model model = new Model();
                    model.setSora_name(soar[i]);
                    model.setSora_link(ArrayLinkElagamy[i]);
                    model_list.add(model);
                }
                break;
            case 16:
                soar = (getResources().getStringArray(R.array.name_allSwar));
                for (int i = 0; i < soar.length; ++i) {
                    Model model = new Model();
                    model.setSora_name(soar[i]);
                    model.setSora_link(ArrayLinkElbana[i]);
                    model_list.add(model);
                }
                break;
            case 17:
                soar = (getResources().getStringArray(R.array.name_allSwar));
                for (int i = 0; i < soar.length; ++i) {
                    Model model = new Model();
                    model.setSora_name(soar[i]);
                    model.setSora_link(ArrayLinkElqarashy[i]);
                    model_list.add(model);
                }
                break;

            case 18:
                soar = (getResources().getStringArray(R.array.name_allSwar));
                for (int i = 0; i < soar.length; ++i) {
                    Model model = new Model();
                    model.setSora_name(soar[i]);
                    model.setSora_link(ArrayLinkElqasem[i]);
                    model_list.add(model);
                }
                break;
            case 19:
                soar = (getResources().getStringArray(R.array.name_allSwar));
                for (int i = 0; i < soar.length; ++i) {
                    Model model = new Model();
                    model.setSora_name(soar[i]);
                    model.setSora_link(ArrayLinkBder[i]);
                    model_list.add(model);
                }
                break;
            default:
                Toast.makeText(getApplicationContext(), "لم يتم ادخال قائمة بعد", Toast.LENGTH_SHORT).show();
        }
        return model_list;
    }

    //define method for define Variables
    public void defineVariable() {

        //define  RecyclerView and link it by XML file
        recycleViewSound = (RecyclerView) findViewById(R.id.recycle_view_sound);

        //define  TextView and link it by XML file and put SHEKH_NAME inside it
        textNameSorActionBar = (TextView) findViewById(R.id.tv_name_sora_actionBar);
        textNameSorActionBar.setText(getIntent().getStringExtra(SHEKH_NAME));

        //Fetch the data in Array.xml file
        ArrayLinkElhosaryMgwad = getResources().getStringArray(R.array.linkesElhosaryMgwad);
        ArrayLinkAbdelbasetMgwad = getResources().getStringArray(R.array.linkesAbdelbasetMgwad);
        ArrayLinkMAHER_ELMEAQLY = getResources().getStringArray(R.array.linkesMaherElmaqly);
        ArrayLinkSoaadElsherem = getResources().getStringArray(R.array.linkesSoaadElsherem);
        ArrayLinkALTABLAWY = getResources().getStringArray(R.array.linkesEltblawy);
        ArrayLinkElklbanyHafs = getResources().getStringArray(R.array.linkesElklbany);
        ArrayLinkAbdlaElgeheny = getResources().getStringArray(R.array.linkesAbdlaElgeheny);
        ArrayLinkElmenshawyMgwad = getResources().getStringArray(R.array.linkesElmenshawyMgwad);
        ArrayLinkElmenshawyHafs = getResources().getStringArray(R.array.linkesElmenshawyHafs);
        ArrayLinkYaserEldosary = getResources().getStringArray(R.array.linkesyasser);
        ArrayLinkElsodes = getResources().getStringArray(R.array.linkesElsodes);
        ArrayLinkMsharyElafasy = getResources().getStringArray(R.array.linkesMsharyElafasy);
        ArrayLinkMohamedGbrer = getResources().getStringArray(R.array.linkesMohamedGbrer);
        ArrayLinkElhosaryHAfs = getResources().getStringArray(R.array.linkesElhosaryHAfs);
        ArrayLinkNaserElqatamy = getResources().getStringArray(R.array.linkesNaserElqatamy);
        ArrayLinkElagamy = getResources().getStringArray(R.array.linkesElagamy);
        ArrayLinkElbana = getResources().getStringArray(R.array.linkesElbana);
        ArrayLinkElqarashy = getResources().getStringArray(R.array.linkesElqarashy);
        ArrayLinkElqasem = getResources().getStringArray(R.array.linkesElqasem);
        ArrayLinkBder = getResources().getStringArray(R.array.linkesBder);
    }

    //define method for titleActionBar
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