package Recept;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class modul extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(5, 5, 5, 5));

        TextArea beskrivning = new TextArea("1. Skölj kikärtorna och ha ner i en mixer tillsammans med olivolja, några matskedar vatten och kryddor. Kör till en slät smet och späd med mer vatten till den fått lagom konsistens.\n" +
                "\n" +
                "2. Förstek kycklinglåren i smör med skinnsidan nedåt. Låt svalna och lossa sedan skinnet utom i ena änden. Vik av skinnet och lägg på ett lager ost, ramslök och hackade pumpafrön. Fäll tillbaka skinnlocket och rada upp kycklinglåren i en ugnsfast form. Ställ in i ugnen i 175° i 25 min.\n" +
                "\n" +
                "3. Sprita bondbönorna och snoppa haricots vertsen. Skär moroten till stavar. Ångkoka allt cirka 5-10 minuter med lite salt. Kärna ur och strimla paprikan. Hyvla champinjonerna på en mandolin. Blanda allt. Smält smör i en kastrull och ringla över.");
        pane.add(beskrivning, 1, 0);
        beskrivning.setEditable(false);
        beskrivning.setDisable(false);
        beskrivning.setWrapText(true);

        //beskrivning.setText(i);

        TreeItem<String> kategorier = new TreeItem("Kategorier");
        kategorier.setExpanded(true);

        TreeItem<String> kott = new TreeItem("Kött");
        kott.setExpanded(true);
        kott.getChildren().add(new TreeItem<>("Fläskkött"));

        TreeItem<String> gronsaker = new TreeItem("Grönsaker");
        gronsaker.setExpanded(true);
        gronsaker.getChildren().add(new TreeItem<>("Gurka"));
        gronsaker.getChildren().add(new TreeItem<>("Tomat"));


        kategorier.getChildren().addAll(kott, gronsaker);
        TreeView<String> kategorierna = new TreeView<>(kategorier);


        MultipleSelectionModel valjflera = kategorierna.getSelectionModel();
        valjflera.setSelectionMode(SelectionMode.MULTIPLE);

        Label valdkategori = new Label();


        kategorierna.getSelectionModel().selectedItemProperty().addListener(
                (ov, old_val, new_val) -> valdkategori.setText(" " + old_val + new_val));
        pane.getChildren().addAll(kategorierna, valdkategori);


        Image image = new Image("file:images/veggies.jpg");
        ImageView theIV = new ImageView(image);
        pane.add(theIV, 0,6,1,6);
        //theIV.setPreserveRatio(true);


        Image image1 = new Image("file:images/veggies.jpg");
        ImageView theIV1 = new ImageView(image);
        pane.add(theIV1, 1,6,2,6);
        //theIV1.setPreserveRatio(true);



        Scene scene = new Scene(pane);
        primaryStage.setTitle("Vad kan jag laga?");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

