package com.example.onlinemovies;

import javafx.beans.property.SimpleStringProperty;

public class User {

        private SimpleStringProperty name;
        private SimpleStringProperty genre;
        private SimpleStringProperty link;


        public User(String name, String genre, String link) {
            this.genre = new SimpleStringProperty(genre);
            this.name = new SimpleStringProperty(name);
            this.link = new SimpleStringProperty(link);
        }

    public String getLink(){return link.get();}

    public SimpleStringProperty LinkProperty(){return link;}

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty NameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getGenre() {
        return genre.get();
    }

    public SimpleStringProperty GenreProperty() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre.set(genre);
    }
}
