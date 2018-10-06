package com.MohamedTaha.Imagine.Quran.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.MohamedTaha.Imagine.Quran.ListSoundReader;
import com.MohamedTaha.Imagine.Quran.R;

import java.util.List;

import static com.MohamedTaha.Imagine.Quran.GridViewActivity.sheks_names;


public class ImageAdapter extends BaseAdapter {

    //variable for store shekh_id
    public static final String SHEKH_ID = "shekh_id";
    //variable for store shekh_name
    public static final String SHEKH_NAME = "shekh_name";
    //variable for inflater
    private static LayoutInflater inflater = null;
    //variable for imageId
    int[] imageId;
    //define Context
    private Context mContext;
    //  String [] nameListReads;
    private List<String> nameListReads;
    //variable for define  Array typeELtelawa
    private String[] typeELtelawa;

    //Constructor
    public ImageAdapter(Context context, List<String> nameListRead, int[] nameImages, String[] typeELtelawa) {
        this.nameListReads = nameListRead;
        this.mContext = context;
        this.imageId = nameImages;
        this.typeELtelawa = typeELtelawa;
        inflater = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        //for fill GridView by all data
        return nameListReads.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //Create a new ImageView for each item referenced by the Adapter
    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        View rowView = convertView;
        TextView tvShowname, tvShowType;
        ImageView img;
        if (rowView == null ){
            rowView = inflater.inflate(R.layout.custom_name_reader, null);
        }

        tvShowname = (TextView) rowView.findViewById(R.id.tv_name_shekh);
        tvShowType = (TextView) rowView.findViewById(R.id.tv_type_tlawa);
        img = (ImageView) rowView.findViewById(R.id.image_shekh);

        tvShowname.setText(nameListReads.get(position));
        tvShowType.setText(typeELtelawa[position]);

        //setting the bitmap from the drawable folder
        Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), imageId[position]);
        //set the image to the imageView
        img.setImageBitmap(bitmap);
        //   holder.img.setImageResource(imageId[position]);
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, ListSoundReader.class);
                i.putExtra(SHEKH_ID, position);
                i.putExtra(SHEKH_NAME, sheks_names.get(position));
                mContext.startActivity(i);
            }
        });
        return rowView;
    }

 }
