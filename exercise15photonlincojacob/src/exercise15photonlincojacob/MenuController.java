/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package exercise15photonlincojacob;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MenuController implements Initializable {
    
    @FXML private ImageView icon1, icon2, icon3;
    @FXML private Button prev, next, load;
    @FXML private VBox base;
    
    private int page;
    private int maxPage;
    private ArrayList<ImageView> iconList;
    
    @FXML private void next(){
        clearIcons();
        page++;
        setSubjectIcons();
        checkLimit();
    }
    
    @FXML private void previous(){
        clearIcons();
        page--;
        setSubjectIcons();
        checkLimit();
    }
    
    @FXML private void openSubject(MouseEvent event) throws IOException{
        int index = 0;
        if(event.getSource() == iconList.get(0)) index = page*3;
        if(event.getSource() == iconList.get(1)) index = page*3 + 1;
        if(event.getSource() == iconList.get(2)) index = page*3 + 2;
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Display.fxml"));
        Parent root = loader.load();
        DisplayController controller = loader.getController();
        controller.setSubject(Subject.getSubjectByIndex(index));
        
        Scene subjectScene = new Scene(root);
        Stage newStage = new Stage();
        Stage thisStage = (Stage)((Node)base).getScene().getWindow();
        thisStage.hide();
        newStage.setScene(subjectScene);
        newStage.show();
    }
    
    @FXML private void load(ActionEvent event) throws FileNotFoundException, IOException{
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        Stage thisStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(thisStage);
        
        if(selectedFile != null){
            BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
        
            String line;
            Subject.subjectList.clear();
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                new Subject(details[0], details[1], Double.parseDouble(details[2]), Double.parseDouble(details[3]));
                
                iconList = new ArrayList();
                iconList.add(icon1);
                iconList.add(icon2);
                iconList.add(icon3);
                page = 0;
                maxPage = Subject.getListLength()/3;
                setSubjectIcons();
                checkLimit();
            }
            reader.close();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("No file selected");
            alert.setContentText("No file selected.");
            alert.showAndWait();
        }
        
    }
    
    public void setSubjectIcons(){
        int index = page*3;
        for(int i=0; i<iconList.size(); i++){
            try{
                Subject s = Subject.getSubjectByIndex(index + i);
                Image img = new Image(getClass().getResourceAsStream("imgs/" + s.getImgFileName()));
                iconList.get(i).setImage(img);
            }
            catch(IndexOutOfBoundsException e){
                Image img = new Image(getClass().getResourceAsStream("imgs/empty.png"));
                iconList.get(i).setImage(img);
            }
        }
    }
    
    public void checkLimit(){
        if(page == maxPage) next.setDisable(true);
        else next.setDisable(false);
        if(page == 0) prev.setDisable(true);
        else prev.setDisable(false);
    }
    
    public void clearIcons(){
        for(ImageView i : iconList){
            i.setImage(null);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iconList = new ArrayList();
        iconList.add(icon1);
        iconList.add(icon2);
        iconList.add(icon3);
        page = 0;
        maxPage = Subject.getListLength()/3;
        setSubjectIcons();
        checkLimit();
    }    
    
}
