package com.example.aqarmaptask.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.aqarmaptask.R;
import com.example.aqarmaptask.model.Movie;
import com.example.aqarmaptask.model.MovieAdapter;
import com.example.aqarmaptask.presenter.MoviesPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements viewInterface {


    @BindView(R.id.movieList)
    ListView movieList;
    MoviesPresenter presenter;
    MovieAdapter adapter ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MoviesPresenter(this);
        presenter.getListFormModel();
    }


    @Override
    public void setList(List<Movie> list) {
        adapter = new MovieAdapter(this , R.layout.movie_item ,list);
        movieList.setAdapter(adapter);
    }
}
