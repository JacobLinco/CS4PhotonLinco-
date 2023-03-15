/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package exercise13photonjacoblinco;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SubjDisplayController implements Initializable {
    
    @FXML private Text units, grade, response;
    @FXML private TextField searchbar;
    @FXML private ImageView img;
    @FXML private Label label;
    @FXML private Button prev, next, search;
    
        
        @FXML private void SearchSubject(ActionEvent event) {
            String input = searchbar.getText();
            
            try{
            Subject.setCurrentDisplay(Subject.searchSubject(input));
            label.setText(Subject.getCurrentDisplay().getName());
            grade.setText("Grades: " + Subject.getCurrentDisplay().getGrade());
            units.setText("Units: " + Subject.getCurrentDisplay().getUnits());
            img.setImage(new Image(Exercise13photonjacoblinco.class.getResourceAsStream(Subject.getCurrentDisplay().getImgFileName())));
            response.setText("subject " + Subject.currentDisplay.getName() + " is now being displayed.");
            response.setFill(Color.GREEN);
            }
            
            catch(NullPointerException e) {
                response.setText("could not find " + input);
                response.setFill(Color.RED);
            }
        }
            
    
        @FXML private void ChangeSubject(ActionEvent event) {
        int incDec = 0;
        if(event.getSource() == prev){ incDec = -1;}
        if(event.getSource() == next){ incDec = +1;}
   
        Subject.setCurrentDisplay(Subject.subjectList.get(Subject.getSubjectIndex(Subject.currentDisplay)+incDec));
        label.setText(Subject.getCurrentDisplay().getName());
        grade.setText("Grades: " + Subject.getCurrentDisplay().getGrade());
        units.setText("Units: " + Subject.getCurrentDisplay().getUnits());
        img.setImage(new Image(Exercise13photonjacoblinco.class.getResourceAsStream(Subject.getCurrentDisplay().getImgFileName())));
        response.setText("");
        if(Subject.getSubjectIndex(Subject.currentDisplay) == 0){prev.setDisable(true);}
        else{prev.setDisable(false);}
        if(Subject.getSubjectIndex(Subject.currentDisplay) == Subject.getListLength()-1){next.setDisable(true);}
        else{next.setDisable(false);}
            
        
    
    }
    
    
    @Override   
    public void initialize(URL url, ResourceBundle rb) {
       
        Subject.setCurrentDisplay(Subject.searchSubject("math"));
        prev.setDisable(true);
        label.setText(Subject.getCurrentDisplay().getName());
        grade.setText("Grades: " + Subject.getCurrentDisplay().getGrade());
        units.setText("Units: " + Subject.getCurrentDisplay().getUnits());
        img.setImage(new Image(Exercise13photonjacoblinco.class.getResourceAsStream(Subject.getCurrentDisplay().getImgFileName())));
        response.setText("");
        
        
        /*
        label.setText(Subject.subjectList.get(0).getName());
        grade.setText("Grades: " + Subject.subjectList.get(0).getGrade());
        units.setText("Units: " + Subject.subjectList.get(0).getUnits());
        img.setImage(new Image(Exercise13photonjacoblinco.class.getResourceAsStream(Subject.subjectList.get(0).getImgFileName())));
        response.setText("");
        */
        /*
        label.setText("bio");
        grade.setText("4.00");
        units.setText("2.00");
        img.setImage(new Image(Exercise13photonjacoblinco.class.getResourceAsStream("biology.png")));
        response.setText("");
       */ 
    }  

    
}
