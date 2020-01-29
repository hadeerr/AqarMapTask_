package com.example.aqarmaptask.presenter;

import com.example.aqarmaptask.model.Movie;
import com.example.aqarmaptask.view.viewInterface;


public class  MoviesPresenter{

    Movie movie = new Movie();
    com.example.aqarmaptask.view.viewInterface viewInterface;
    public MoviesPresenter(viewInterface viewInterface) {

        this.viewInterface = viewInterface;

    }


    public void getListFormModel (){
           movie.getLisFromApi(this.viewInterface);
    }
}
