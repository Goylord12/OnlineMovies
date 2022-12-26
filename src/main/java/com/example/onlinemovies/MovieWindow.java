package com.example.onlinemovies;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MovieWindow {
    @FXML
    private Button Back;

    @FXML
    private javafx.scene.image.ImageView ImageView;

    @FXML
    private javafx.scene.control.Label Label;

    @FXML
    private TextArea Text;

    @FXML
    void OnBack(ActionEvent event) {
        Stage stage = (Stage) Back.getScene().getWindow();
        stage.close();

    }


    public void initialize() throws Exception {
        Label.setText(HelloController.getName);
        for(int i = 0; i < HelloController.getLink.length(); i++){
            if((i % 45) == 0){
                Text.setText(Text.getText() + "\n");
            }
            Text.setText(Text.getText() + String.valueOf(HelloController.getLink.charAt(i)));
        }



    }
}
