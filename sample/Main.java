package sample;

import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import com.jfoenix.controls.JFXRadioButton;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent layout = loader.load();
        Controller controller = loader.getController();
        primaryStage.setTitle("MCQ");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(layout,300,500));
        primaryStage.show();
        ToggleGroup toggleGroup=new ToggleGroup();
        controller.add_btn.setOnMouseClicked(event -> {
            try{
                FXMLLoader loader2 = new FXMLLoader(getClass().getResource("input.fxml"));
                Parent layout2 = loader2.load();
                Input controller2 = loader2.getController();
                controller.stackPane.setVisible(true);
                JFXDialogLayout jfxDialogLayout=new JFXDialogLayout();
                jfxDialogLayout.setBody(layout2);
                jfxDialogLayout.setPrefWidth(250);
                jfxDialogLayout.setPrefHeight(115);
                JFXDialog dialog=new JFXDialog(controller.stackPane,jfxDialogLayout, JFXDialog.DialogTransition.CENTER);
                dialog.show();

                dialog.setOnDialogClosed(event1 -> {
                    controller.stackPane.setVisible(false);
                });

                controller2.cancel.setOnMouseClicked(event1 -> {
                    dialog.close();
                });

                controller2.submit.setOnMouseClicked(event1 -> {
                    String string=controller2.txt.getText();
                    if(!string.isEmpty()){
                        try {
                            dialog.close();
                            FXMLLoader loader1 = new FXMLLoader(getClass().getResource("option.fxml"));
                            Parent layout1 = loader1.load();
                            Option controller1 = loader1.getController();
                            controller1.option.setText(string);
                            controller1.option.setToggleGroup(toggleGroup);
                            controller.vBox.getChildren().add(toggleGroup.getToggles().size()-1,layout1);
                            controller.scroll.setVvalue(1.2);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        });

        controller.view_btn.setOnMouseClicked(event -> {
            String message;
            JFXRadioButton radioButton=(JFXRadioButton)toggleGroup.getSelectedToggle();
            if(radioButton==null)message="No option selected .";
            else message=radioButton.getText();
            Toast.makeText(primaryStage,message,200,500,200);
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
