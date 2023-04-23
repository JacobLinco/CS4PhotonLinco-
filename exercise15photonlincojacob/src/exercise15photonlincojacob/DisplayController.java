/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package exercise15photonlincojacob;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DisplayController implements Initializable {

    @FXML private Button prev, next, back, search;
    @FXML private ImageView icon;
    @FXML private Text name, units, grade;
    @FXML private TextField searchTerm;
    private Alert alert;
    private Subject subject;
    
    public void setSubject(Subject s){
        subject = s;
        Image img = new Image(getClass().getResourceAsStream("imgs/" + s.getImgFileName()));
        icon.setImage(img);
        name.setText(s.getName());
        units.setText(Double.toString(s.getUnits()));
        grade.setText(Double.toString(s.getGrade()));
        disableButton();
    }
    
    public void disableButton(){
        int index = Subject.getSubjectIndex(subject);
        if(index == 0) prev.setDisable(true);
        else prev.setDisable(false);
        if(index == Subject.getListLength()-1) next.setDisable(true);
        else next.setDisable(false);
    }
    
    public void search(String term){
        try{
            Subject searched = Subject.searchSubject(term);
            setSubject(searched);
        }
        catch(NullPointerException err){
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Not Found");
            alert.setContentText("Subject not found...");
            alert.showAndWait();
        }
    }
    
    @FXML private void previous(ActionEvent event){
        int index = Subject.getSubjectIndex(subject);
        subject = Subject.getSubjectByIndex(index-1);
        setSubject(subject);
    }
    
    @FXML private void next(ActionEvent event){
        int index = Subject.getSubjectIndex(subject);
        subject = Subject.getSubjectByIndex(index+1);
        setSubject(subject);
    }
    
    @FXML private void back(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
        Parent root = loader.load();
        
        Scene subjectScene = new Scene(root);
        Stage thisStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        thisStage.hide();
        thisStage.setScene(subjectScene);
        thisStage.show();
    }
    
    @FXML private void search(ActionEvent event){
        String term = searchTerm.getText();
        search(term);
    }
    
    @FXML private void searchEnter(KeyEvent event){
        if(event.getCode().equals(KeyCode.ENTER)){
            String term = searchTerm.getText();
            search(term);
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
