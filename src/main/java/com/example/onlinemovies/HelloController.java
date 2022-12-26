package com.example.onlinemovies;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;


public class HelloController implements Initializable {
    public static String getName;
    public static String getLink;


    ObservableList<User> usersData = FXCollections.observableArrayList();

    @FXML
    private javafx.scene.layout.Pane Pane;

    @FXML
    private javafx.scene.control.Button Button;

    @FXML
    private TableColumn<User, String> TableGenres;


    @FXML
    private TableColumn<User, String> TableLink;

    @FXML
    private TableColumn<User, String> TableMovie;

    @FXML
    private TableView<User> TableView;


    @FXML
    private TextField TextField;

    @FXML
    void onSearch(ActionEvent event) {
        ObservableList<User> selectedRows, allBooks;
        allBooks = TableView.getItems();

        selectedRows = TableView.getSelectionModel().getSelectedItems();

        for (User user : selectedRows) {
            getName = user.getName();
            getLink = user.getLink();
            try{
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("movie-window.fxml"));
                loader.load();
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                ImageView imageView = (ImageView) scene.lookup("#ImageView");
                File file = new File("C:\\Games\\Online movies\\src\\main\\resources\\Assets\\" + getName + ".png");
                Image image = new Image(file.toURI().toString());
                imageView.setImage(image);
                stage.setScene(scene);
                stage.setTitle("Movie");
                stage.showAndWait();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void onTable(ActionEvent event) {

    }

    @FXML
    void onWriteSearch(ActionEvent event) {


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initData();

        // устанавливаем тип и значение которое должно хранится в колонке

        TableMovie.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
        TableGenres.setCellValueFactory(new PropertyValueFactory<User, String>("genre"));
        TableLink.setCellValueFactory(new PropertyValueFactory<User, String>("link"));

        // заполняем таблицу данными
        TableView.setItems(usersData);

        FilteredList<User> filteredData = new FilteredList<>(usersData, user -> true);

        TextField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(User -> {
                //Если значение поиска отсутствует, то отобразит все записи или любые записи, которые есть на данный момент
                if (newValue.isEmpty() || newValue.isBlank()) {
                    return true;
                }

                String searchKeyword = newValue.toLowerCase();

                if (User.getName().toLowerCase().contains(searchKeyword)) {
                    return true; //Найдено совпадение в bookName
                } else if (User.getGenre().toLowerCase().contains(searchKeyword)) {
                    return true;
                } else
                    return false; //Совпадения не найдены
            });
        });

        SortedList<User> sortedData = new SortedList<>(filteredData);

        //Связывает отсортированный вариант с TableView
        sortedData.comparatorProperty().bind(TableView.comparatorProperty());

        //Применяет отсортированные данные в TableView
        TableView.setItems(sortedData);
    }

    // инициализируем форму данными


    // подготавливаем данные для таблицы
    // вы можете получать их с базы данных
    private void initData() {
        usersData.add(new User("Call Me by Your Name", "драма, мелодрама", "Италия, 1983 год. 17-летний Элио проводит лето на вилле у родителей - американского профессора и переводчицы-итальянки. Начитанный и любознательный юноша разбавляет обычные летние занятия вроде купания в море и ленивого флирта с подругой Марцией чтением и транскрибированием классической музыки. В один прекрасный день безмятежность летнего отдыха нарушает приезд ассистента отца Элио – молодого американского учёного Оливера."));
        usersData.add(new User("Brokeback Mountain", "вестерн, мелодрама, драма", "На фоне живописных просторов штата Вайоминг разворачивается история сложных взаимоотношений двух молодых людей – помощника владельца ранчо и ковбоя родео. Герои случайно встречаются и скоро понимают, что не могут жить друг без друга. Однако судьба упрямо испытывает их на прочность."));
        usersData.add(new User("The Green Elephant", "ужасы, триллер", "Два младших офицера, сидя в одной камере на гауптвахте, вынуждены решать острые социальные и психологические вопросы в небольшом пространстве."));
        usersData.add(new User("Timecop", "фантастика, боевик, триллер, криминал", "Передвижения во времени породили новый тип преступлений. Можно изменять события прошлого, контролировать финансовые рынки и даже уничтожать целые народы. Правительство США создает специальное полицейское подразделение - патруль времени."));
        usersData.add(new User("The Usual Suspects", "триллер, драма, криминал, детектив", "Если есть преступление, есть и мотив. Если проводится опознание, то по крайней мере есть один подозреваемый. Но это было необычное преступление. Пять преступников столкнулись в одном необычном месте и решили прокрутить одно дельце. Но некто более сильный и влиятельный, некто, чье имя пугает всех преступников мира, хочет, чтобы они поработали на него. Это не было обычным преступлением, и они — не просто подозрительные лица."));
        usersData.add(new User("Vase de noces", "ужасы, драма, мелодрама", "Сумасшедший фермер бегает по ферме голый и насилует свинью. Иногда он часами смотрит, как совокупляются куры, катает по ферме колесо и просто радуется жизни. Когда свинья родила от фермера поросят, он начинает ревновать их отцовской ревностью к матери."));
        usersData.add(new User("The Road", "драма, приключения", "На Землю обрушились чудовищные катаклизмы, цивилизация уничтожена, как и практически вся жизнь на планете. Оставшееся человечество разделилось на каннибалов и их добычу. По дороге, покрытой пеплом, идут отец с сыном. Они хотят добраться до теплых мест, чтобы выжить..."));
        usersData.add(new User("The Lighthouse", "ужасы, фэнтези, драма", "1890-е годы, где-то неподалёку от побережья Новой Англии. Молодой человек Эфраим Уинслоу приезжает на отдалённый остров работать новым помощником смотрителя маяка, хромого бородатого любителя выпить Томаса Уэйка. Тот обращается с подчинённым как с личным рабом и запрещает ему подниматься на сам маяк и управлять светом. Эфраима не отпускает собственное прошлое, так поначалу отказывавшийся от алкоголя парень всё чаще прикладывается к бутылке, и вскоре на каменистом острове — то ли ему мерещится, то ли в самом деле — начинает твориться всякая чертовщина."));
        usersData.add(new User("Trainspotting", "драма, криминал", "История четырёх друзей-наркоманов в Эдинбурге 1990-х годов. Кто-то из них пытается завязать, а кто-то озабочен только тем, как достать очередную дозу."));
        usersData.add(new User("21 Grams", "триллер, драма, криминал", "Говорят, что каждый человек в момент смерти теряет 21 грамм. Столько весит горстка монет в пять центов, плитка шоколада, птица колибри..."));







    }


}