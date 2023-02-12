package application;

import final_product.Main_app;
import java.util.Scanner;
import javafx.scene.Group;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.shape.Circle;
import javafx.scene.text.TextAlignment;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.geometry.HPos;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
//just added
import javafx.application.Platform;

import javafx.embed.swing.SwingNode;

import javafx.scene.layout.StackPane;

import javax.swing.JButton;
import javax.swing.SwingUtilities;
import final_product.Style;


public class electronConfig extends Application {
	private Label eleLabel;
	private TextField eleField;
	private Label isoLabel;
	private TextField isoField;
	private Label chargeLabel;
	private TextField chargeField;
	private Label res;
	private Label err;
	private Button btn;
	private Button rtn;
	private String str = "";
	private int rings = 0;
	private Circle circ1;
	private Circle circ2;
	private Circle circ3;
	private Circle circ4;
	private Circle ele1_1;
	private Circle ele1_2;
	private Circle ele2_1;
	private Circle ele2_2;
	private Circle ele2_3;
	private Circle ele2_4;
	private Circle ele2_5;
	private Circle ele2_6;
	private Circle ele2_7;
	private Circle ele2_8;
	private Circle ele3_1;
	private Circle ele3_2;
	private Circle ele3_3;
	private Circle ele3_4;
	private Circle ele3_5;
	private Circle ele3_6;
	private Circle ele3_7;
	private Circle ele3_8;
	private Circle ele4_1;
	private Circle ele4_2;
	private Circle ele4_3;
	private Circle ele4_4;
	private Circle ele4_5;
	private Circle ele4_6;
	private Circle ele4_7;
	private Circle ele4_8;
	private ArrayList<Circle> circs = new ArrayList<>();
	
	@Override
	public void start(Stage appStage) {	
		
		//Color Green_Blue_Crayola = new Color(.63,.136,.197, 0.0); #3F88C5
		//Color Crimsom = new Color (.215,.38,.56,0.0);
		//Color Carrot_Orange = new Color(.244,.157,.55,0.0); #F49D37
		//Color Dark_purple = new Color(.20,.15,.41,0.0);
		//Color Red_pigment = new Color(.242,.43,.41,0.0);  #F22B29
		Scene scene = null;
		Group pane = new Group();
		scene = new Scene(pane, 750, 600);
		btn = new Button("Generate");
		btn.setLayoutX(345);
		btn.setLayoutY(550);
		btn.setStyle("-fx-background-color: #F49D37");
		btn.setTextFill(Color.WHITE);
		rtn = new Button("Return");
		rtn.setLayoutX(445);
		rtn.setLayoutY(550);
		rtn.setStyle("-fx-background-color: #F49D37");
		rtn.setTextFill(Color.WHITE);
		eleLabel = new Label("Enter Element");
		eleLabel.setLayoutX(60);
		eleLabel.setLayoutY(25);
		eleLabel.setTextFill(Color.web("#3F88C5"));
		eleField = new TextField();
		eleField.setEditable(true);
		eleField.setLayoutX(25);
		eleField.setLayoutY(50);
		isoLabel = new Label("Enter isotope");
		isoLabel.setLayoutX(340);
		isoLabel.setLayoutY(25);
		isoLabel.setTextFill(Color.web("#3F88C5"));
		isoField = new TextField();
		isoField.setEditable(true);
		isoField.setLayoutX(300);
		isoField.setLayoutY(50);
		chargeLabel = new Label("Enter Charge");
		chargeLabel.setLayoutX(620);
		chargeLabel.setLayoutY(25);
		chargeLabel.setTextFill(Color.web("#3F88C5"));
		chargeField = new TextField();
		chargeField.setEditable(true);
		chargeField.setLayoutX(575);
		chargeField.setLayoutY(50);
		res = new Label("");
		res.setLayoutX(370);
		res.setLayoutY(300);
		err = new Label("");
		err.setLayoutX(60);
		err.setLayoutY(100);
		err.setTextFill(Color.web("#F22B29"));

		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//Rings
				pane.getChildren().remove(circ1);
				pane.getChildren().remove(circ2);
				pane.getChildren().remove(circ3);
				pane.getChildren().remove(circ4);
				//Ring1
				pane.getChildren().remove(ele1_1);
				pane.getChildren().remove(ele1_2);
				//Ring2
				pane.getChildren().remove(ele2_1);
				pane.getChildren().remove(ele2_2);
				pane.getChildren().remove(ele2_3);
				pane.getChildren().remove(ele2_4);
				pane.getChildren().remove(ele2_5);
				pane.getChildren().remove(ele2_6);
				pane.getChildren().remove(ele2_7);
				pane.getChildren().remove(ele2_8);
				//Ring3
				pane.getChildren().remove(ele3_1);
				pane.getChildren().remove(ele3_2);
				pane.getChildren().remove(ele3_3);
				pane.getChildren().remove(ele3_4);
				pane.getChildren().remove(ele3_5); 
				pane.getChildren().remove(ele3_6);
				pane.getChildren().remove(ele3_7); 
				pane.getChildren().remove(ele3_8);
				//Ring4
				pane.getChildren().remove(ele4_1);
				pane.getChildren().remove(ele4_2);
				pane.getChildren().remove(ele4_3);
				pane.getChildren().remove(ele4_4);
				pane.getChildren().remove(ele4_5); 
				pane.getChildren().remove(ele4_6);
				pane.getChildren().remove(ele4_7); 
				pane.getChildren().remove(ele4_8);
				err.setText("");
				
				
				Scanner scan = new Scanner(System.in);
				String sym = "";
				int pro = 0;
				int neu = 0;
				int ele = 0;
				int elemInd = -1;
				//Element list up to 20
				//Order: [symbol, #protons, #neutrons, #electrons] 
				String[][] elements = new String[][] {
					{"H", "1", "0" , "1"},
					{"He", "2", "2" , "2"},
					{"Li", "3", "4" , "3"},
					{"Be", "4", "5" , "4"},
					{"B", "5", "5" , "5"},
					{"C", "6", "6" , "6"},
					{"N", "7", "7" , "7"},
					{"O", "8", "8" , "8"},
					{"F", "9", "10" , "9"},
					{"Ne", "10", "10" , "10"},
					{"Na", "11", "12" , "11"},
					{"Mg", "12", "12" , "12"},
					{"Al", "13", "14" , "13"},
					{"Si", "14", "14" , "14"},
					{"P", "15", "16" , "15"},
					{"S", "16", "16" , "16"},
					{"Cl", "17", "18" , "17"},
					{"Ar", "18", "22" , "18"},
					{"K", "19", "21" , "19"},
					{"Ca", "20", "20" , "20"},
				};
				
				sym = eleField.getText();
				if(isoField.getText() != "")
					neu = Integer.parseInt(isoField.getText());
				if(chargeField.getText() != "")
					ele = Integer.parseInt(chargeField.getText());
				
				for(int i = 0; i < 20; i++) {
					if (elements[i][0].equals(sym)) {
						elemInd = i;
					}
				}
				
				try {
					pro = Integer.valueOf(elements[elemInd][1]);
					if (neu != 0 && neu > Integer.valueOf(elements[elemInd][1]))
						neu = neu - Integer.valueOf(elements[elemInd][1]);
					else neu = Integer.valueOf(elements[elemInd][2]);
					if (ele > 0)
						ele = ele - (ele*2);
					else if (ele < 0)
						ele = Math.abs(ele);
					else
						ele = 0;
					if (ele != 0)
						ele = Integer.valueOf(elements[elemInd][1]) + ele;
					else ele = Integer.valueOf(elements[elemInd][3]);
					
					str = Integer.toString(pro) + " P\n" + Integer.toString(neu) + " N";
					res.setText(str);
					
					//Print rings to screen
					if (ele > 18) rings = 4;
					else if (ele > 10) rings = 3;
					else if (ele > 2) rings = 2;
					else rings = 1;		
					//Rings
					if(rings >= 1) {
						pane.getChildren().add(circ1);
						if(rings >= 2) {
							pane.getChildren().add(circ2);
							if(rings >= 3) {
								pane.getChildren().add(circ3);
								if(rings == 4) 
									pane.getChildren().add(circ4);
							}
						}
					}
					
					//Print electrons to screen
					int i = 0;
					while(ele != 0) {
						pane.getChildren().add(circs.get(i));
						i++;
						ele--;
					}
				}
				catch(Exception e) {
					if(elemInd == -1) err.setText("Invalid Element");
					else err.setText("Invalid input");
					pane.getChildren().remove(circ1);
					pane.getChildren().remove(circ2);
					pane.getChildren().remove(circ3);
					pane.getChildren().remove(circ4);
					//Ring1
					pane.getChildren().remove(ele1_1);
					pane.getChildren().remove(ele1_2);
					//Ring2
					pane.getChildren().remove(ele2_1);
					pane.getChildren().remove(ele2_2);
					pane.getChildren().remove(ele2_3);
					pane.getChildren().remove(ele2_4);
					pane.getChildren().remove(ele2_5);
					pane.getChildren().remove(ele2_6);
					pane.getChildren().remove(ele2_7);
					pane.getChildren().remove(ele2_8);
					//Ring3
					pane.getChildren().remove(ele3_1);
					pane.getChildren().remove(ele3_2);
					pane.getChildren().remove(ele3_3);
					pane.getChildren().remove(ele3_4);
					pane.getChildren().remove(ele3_5); 
					pane.getChildren().remove(ele3_6);
					pane.getChildren().remove(ele3_7); 
					pane.getChildren().remove(ele3_8);
					//Ring4
					pane.getChildren().remove(ele4_1);
					pane.getChildren().remove(ele4_2);
					pane.getChildren().remove(ele4_3);
					pane.getChildren().remove(ele4_4);
					pane.getChildren().remove(ele4_5); 
					pane.getChildren().remove(ele4_6);
					pane.getChildren().remove(ele4_7); 
					pane.getChildren().remove(ele4_8);
					res.setText("");
				}
				
			}
		});
		
		rtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//Main_app f = new Main_app();
				//f.main();
			    Platform.exit();
			}
		});
		        
		//RINGS
        //Drawing a Circle
        circ1 = new Circle();
        //Setting the properties of the circle
        circ1.setRadius(50.0f);
        circ1.setLayoutX(378);
		circ1.setLayoutY(315);
        //Setting other properties
        circ1.setFill(Color.TRANSPARENT);
        circ1.setStrokeWidth(3.0);
        circ1.setStroke(Color.DARKSLATEGREY);

        //Drawing a Circle
        circ2 = new Circle();
        //Setting the properties of the circle
        circ2.setRadius(100.0f);
        circ2.setLayoutX(378);
		circ2.setLayoutY(315);
        //Setting other properties
        circ2.setFill(Color.TRANSPARENT);
        circ2.setStrokeWidth(3.0);
        circ2.setStroke(Color.DARKSLATEGREY);
        
        //Drawing a Circle
        circ3 = new Circle();
        //Setting the properties of the circle
        circ3.setRadius(150.0f);
        circ3.setLayoutX(378);
		circ3.setLayoutY(315);
        //Setting other properties
        circ3.setFill(Color.TRANSPARENT);
        circ3.setStrokeWidth(3.0);
        circ3.setStroke(Color.DARKSLATEGREY);
        
        //Drawing a Circle
        circ4 = new Circle();
        //Setting the properties of the circle
        circ4.setRadius(200.0f);
        circ4.setLayoutX(378);
		circ4.setLayoutY(315);
        //Setting other properties
        circ4.setFill(Color.TRANSPARENT);
        circ4.setStrokeWidth(3.0);
        circ4.setStroke(Color.DARKSLATEGREY);
        
        //FIRST RING
        //Drawing a Circle
        ele1_1 = new Circle();
        //Setting the properties of the circle
        ele1_1.setRadius(5.0f);
        ele1_1.setLayoutX(378);
		ele1_1.setLayoutY(265);
        //Setting other properties
        ele1_1.setFill(Color.BLACK);
        ele1_1.setStrokeWidth(1.0);
        ele1_1.setStroke(Color.BLACK);
        
        //Drawing a Circle
        ele1_2 = new Circle();
        //Setting the properties of the circle
        ele1_2.setRadius(5.0f);
        ele1_2.setLayoutX(378);
        ele1_2.setLayoutY(365);
        //Setting other properties
        ele1_2.setFill(Color.BLACK);
        ele1_2.setStrokeWidth(1.0);
        ele1_2.setStroke(Color.BLACK);
        
        //SECOND RING
        //Drawing a Circle
        ele2_1 = new Circle();
        //Setting the properties of the circle
        ele2_1.setRadius(5.0f);
        ele2_1.setLayoutX(368);
        ele2_1.setLayoutY(215);
        //Setting other properties
        ele2_1.setFill(Color.BLACK);
        ele2_1.setStrokeWidth(1.0);
        ele2_1.setStroke(Color.BLACK);
        
        //Drawing a Circle
        ele2_2 = new Circle();
        //Setting the properties of the circle
        ele2_2.setRadius(5.0f);
        ele2_2.setLayoutX(388);
        ele2_2.setLayoutY(215);
        //Setting other properties
        ele2_2.setFill(Color.BLACK);
        ele2_2.setStrokeWidth(1.0);
        ele2_2.setStroke(Color.BLACK);
        
        //Drawing a Circle
        ele2_3 = new Circle();
        //Setting the properties of the circle
        ele2_3.setRadius(5.0f);
        ele2_3.setLayoutX(478);
        ele2_3.setLayoutY(305);
        //Setting other properties
        ele2_3.setFill(Color.BLACK);
        ele2_3.setStrokeWidth(1.0);
        ele2_3.setStroke(Color.BLACK);
        
        //Drawing a Circle
        ele2_4 = new Circle();
        //Setting the properties of the circle
        ele2_4.setRadius(5.0f);
        ele2_4.setLayoutX(478);
        ele2_4.setLayoutY(324);
        //Setting other properties
        ele2_4.setFill(Color.BLACK);
        ele2_4.setStrokeWidth(1.0);
        ele2_4.setStroke(Color.BLACK);
        
        //Drawing a Circle
        ele2_5 = new Circle();
        //Setting the properties of the circle
        ele2_5.setRadius(5.0f);
        ele2_5.setLayoutX(278);
        ele2_5.setLayoutY(305);
        //Setting other properties
        ele2_5.setFill(Color.BLACK);
        ele2_5.setStrokeWidth(1.0);
        ele2_5.setStroke(Color.BLACK);
        
        //Drawing a Circle
        ele2_6 = new Circle();
        //Setting the properties of the circle
        ele2_6.setRadius(5.0f);
        ele2_6.setLayoutX(278);
        ele2_6.setLayoutY(324);
        //Setting other properties
        ele2_6.setFill(Color.BLACK);
        ele2_6.setStrokeWidth(1.0);
        ele2_6.setStroke(Color.BLACK);
        
        //Drawing a Circle
        ele2_7 = new Circle();
        //Setting the properties of the circle
        ele2_7.setRadius(5.0f);
        ele2_7.setLayoutX(388);
        ele2_7.setLayoutY(415);
        //Setting other properties
        ele2_7.setFill(Color.BLACK);
        ele2_7.setStrokeWidth(1.0);
        ele2_7.setStroke(Color.BLACK);
        
        //Drawing a Circle
        ele2_8 = new Circle();
        //Setting the properties of the circle
        ele2_8.setRadius(5.0f);
        ele2_8.setLayoutX(368);
        ele2_8.setLayoutY(415);
        //Setting other properties
        ele2_8.setFill(Color.BLACK);
        ele2_8.setStrokeWidth(1.0);
        ele2_8.setStroke(Color.BLACK);
        
        //THIRD RING
        //Drawing a Circle
        ele3_1 = new Circle();
        //Setting the properties of the circle
        ele3_1.setRadius(5.0f);
        ele3_1.setLayoutX(368);
        ele3_1.setLayoutY(165);
        //Setting other properties
        ele3_1.setFill(Color.BLACK);
        ele3_1.setStrokeWidth(1.0);
        ele3_1.setStroke(Color.BLACK);
        
        //Drawing a Circle
        ele3_2 = new Circle();
        //Setting the properties of the circle
        ele3_2.setRadius(5.0f);
        ele3_2.setLayoutX(388);
        ele3_2.setLayoutY(165);
        //Setting other properties
        ele3_2.setFill(Color.BLACK);
        ele3_2.setStrokeWidth(1.0);
        ele3_2.setStroke(Color.BLACK);
        
        //Drawing a Circle
        ele3_3 = new Circle();
        //Setting the properties of the circle
        ele3_3.setRadius(5.0f);
        ele3_3.setLayoutX(528);
        ele3_3.setLayoutY(305);
        //Setting other properties
        ele3_3.setFill(Color.BLACK);
        ele3_3.setStrokeWidth(1.0);
        ele3_3.setStroke(Color.BLACK);
        
        //Drawing a Circle
        ele3_4 = new Circle();
        //Setting the properties of the circle
        ele3_4.setRadius(5.0f);
        ele3_4.setLayoutX(528);
        ele3_4.setLayoutY(324);
        //Setting other properties
        ele3_4.setFill(Color.BLACK);
        ele3_4.setStrokeWidth(1.0);
        ele3_4.setStroke(Color.BLACK);
        
        //Drawing a Circle
        ele3_5 = new Circle();
        //Setting the properties of the circle
        ele3_5.setRadius(5.0f);
        ele3_5.setLayoutX(228);
        ele3_5.setLayoutY(305);
        //Setting other properties
        ele3_5.setFill(Color.BLACK);
        ele3_5.setStrokeWidth(1.0);
        ele3_5.setStroke(Color.BLACK);
        
        //Drawing a Circle
        ele3_6 = new Circle();
        //Setting the properties of the circle
        ele3_6.setRadius(5.0f);
        ele3_6.setLayoutX(228);
        ele3_6.setLayoutY(324);
        //Setting other properties
        ele3_6.setFill(Color.BLACK);
        ele3_6.setStrokeWidth(1.0);
        ele3_6.setStroke(Color.BLACK);
        
        //Drawing a Circle
        ele3_7 = new Circle();
        //Setting the properties of the circle
        ele3_7.setRadius(5.0f);
        ele3_7.setLayoutX(388);
        ele3_7.setLayoutY(465);
        //Setting other properties
        ele3_7.setFill(Color.BLACK);
        ele3_7.setStrokeWidth(1.0);
        ele3_7.setStroke(Color.BLACK);
        
        //Drawing a Circle
        ele3_8 = new Circle();
        //Setting the properties of the circle
        ele3_8.setRadius(5.0f);
        ele3_8.setLayoutX(368);
        ele3_8.setLayoutY(465);
        //Setting other properties
        ele3_8.setFill(Color.BLACK);
        ele3_8.setStrokeWidth(1.0);
        ele3_8.setStroke(Color.BLACK);
        
        //FOURTH RING
        //Drawing a Circle
        ele4_1 = new Circle();
        //Setting the properties of the circle
        ele4_1.setRadius(5.0f);
        ele4_1.setLayoutX(368);
        ele4_1.setLayoutY(115);
        //Setting other properties
        ele4_1.setFill(Color.BLACK);
        ele4_1.setStrokeWidth(1.0);
        ele4_1.setStroke(Color.BLACK);
        
        //Drawing a Circle
        ele4_2 = new Circle();
        //Setting the properties of the circle
        ele4_2.setRadius(5.0f);
        ele4_2.setLayoutX(388);
        ele4_2.setLayoutY(115);
        //Setting other properties
        ele4_2.setFill(Color.BLACK);
        ele4_2.setStrokeWidth(1.0);
        ele4_2.setStroke(Color.BLACK);
        
        //Drawing a Circle
        ele4_3 = new Circle();
        //Setting the properties of the circle
        ele4_3.setRadius(5.0f);
        ele4_3.setLayoutX(578);
        ele4_3.setLayoutY(305);
        //Setting other properties
        ele4_3.setFill(Color.BLACK);
        ele4_3.setStrokeWidth(1.0);
        ele4_3.setStroke(Color.BLACK);
        
        //Drawing a Circle
        ele4_4 = new Circle();
        //Setting the properties of the circle
        ele4_4.setRadius(5.0f);
        ele4_4.setLayoutX(578);
        ele4_4.setLayoutY(324);
        //Setting other properties
        ele4_4.setFill(Color.BLACK);
        ele4_4.setStrokeWidth(1.0);
        ele4_4.setStroke(Color.BLACK);
        
        //Drawing a Circle
        ele4_5 = new Circle();
        //Setting the properties of the circle
        ele4_5.setRadius(5.0f);
        ele4_5.setLayoutX(178);
        ele4_5.setLayoutY(305);
        //Setting other properties
        ele4_5.setFill(Color.BLACK);
        ele4_5.setStrokeWidth(1.0);
        ele4_5.setStroke(Color.BLACK);
        
        //Drawing a Circle
        ele4_6 = new Circle();
        //Setting the properties of the circle
        ele4_6.setRadius(5.0f);
        ele4_6.setLayoutX(178);
        ele4_6.setLayoutY(324);
        //Setting other properties
        ele4_6.setFill(Color.BLACK);
        ele4_6.setStrokeWidth(1.0);
        ele4_6.setStroke(Color.BLACK);
        
        //Drawing a Circle
        ele4_7 = new Circle();
        //Setting the properties of the circle
        ele4_7.setRadius(5.0f);
        ele4_7.setLayoutX(388);
        ele4_7.setLayoutY(515);
        //Setting other properties
        ele4_7.setFill(Color.BLACK);
        ele4_7.setStrokeWidth(1.0);
        ele4_7.setStroke(Color.BLACK);
        
        //Drawing a Circle
        ele4_8 = new Circle();
        //Setting the properties of the circle
        ele4_8.setRadius(5.0f);
        ele4_8.setLayoutX(368);
        ele4_8.setLayoutY(515);
        //Setting other properties
        ele4_8.setFill(Color.BLACK);
        ele4_8.setStrokeWidth(1.0);
        ele4_8.setStroke(Color.BLACK);
        
        circs.add(ele1_1);
        circs.add(ele1_2);
        circs.add(ele2_1);
        circs.add(ele2_2);
        circs.add(ele2_3);
        circs.add(ele2_4);
        circs.add(ele2_5);
        circs.add(ele2_6);
        circs.add(ele2_7);
        circs.add(ele2_8);
        circs.add(ele3_1);
        circs.add(ele3_2);
        circs.add(ele3_3);
        circs.add(ele3_4);
        circs.add(ele3_5);
        circs.add(ele3_6);
        circs.add(ele3_7);
        circs.add(ele3_8);
        circs.add(ele4_1);
        circs.add(ele4_2);
        circs.add(ele4_3);
        circs.add(ele4_4);
        circs.add(ele4_5);
        circs.add(ele4_6);
        circs.add(ele4_7);
        circs.add(ele4_8);
        
		//POSITIONING
        pane.getChildren().add(btn);
        pane.getChildren().add(rtn);
		pane.getChildren().add(eleLabel);
		pane.getChildren().add(eleField);
		pane.getChildren().add(isoLabel);
		pane.getChildren().add(isoField);
		pane.getChildren().add(chargeLabel);
		pane.getChildren().add(chargeField);
		pane.getChildren().add(res);
		pane.getChildren().add(err);
         
		
		appStage.setScene(scene);
		appStage.setTitle("Javafx Calculator");
		appStage.show();
		
	}
   

	public static void main(String[] args) {
		//launch(args);
		
	}

}
