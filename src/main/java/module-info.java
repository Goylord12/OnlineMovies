module com.example.onlinemovies {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.onlinemovies to javafx.fxml;
    exports com.example.onlinemovies;
}