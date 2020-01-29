package com.example.aqarmaptask.model;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.aqarmaptask.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieAdapter  extends ArrayAdapter {
    Context context ;
    List<Movie> movieList;
    int resouceItem;
    @BindView(R.id.movieImage)
    ImageView imageView;
    @BindView(R.id.movieItem)
    TextView  movieItem;

     public MovieAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context = context;
        this.resouceItem = resource;
        this.movieList = objects;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

       View itemView = LayoutInflater.from(context).inflate(resouceItem , parent , false);
       ButterKnife.bind(this , itemView);
       movieItem.setText(movieList.get(position).title);
        Glide.with(context).load( movieList.get(position).poster_path).into(imageView);
        View alertView = LayoutInflater.from(context).inflate(R.layout.alert_dialog , parent , false);

        TextView overView = alertView.findViewById(R.id.overview);
        overView.setText(movieList.get(position).overview);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               showAlertDialog(alertView);
            }
        });
       return itemView;



    }

    private void showAlertDialog(View alertView) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        alertDialogBuilder.setView(alertView);

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        alertDialog.getWindow().setWindowAnimations(R.style.DialogAnimation);


        alertDialog.show();
    }
}
