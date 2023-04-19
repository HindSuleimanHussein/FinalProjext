package com.example.finalprojext;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;


public class Main extends Application {

    Scene scene, addScene, deleteScene, searchScene, returnScene;


    @Override
    public void start(Stage stage) throws IOException {

        RentVehicleSystem system = new RentVehicleSystem();

        // Creating A Main Window

        Button customer = new Button("Customer");
        customer.setOnAction(e -> stage.setScene(scene));
        customer.setFont(Font.font("Traditional Arabic", FontWeight.BOLD, FontPosture.ITALIC, 18));

        Image image = new Image("https://www.designrush.com/uploads/users/customer-11/image_1526479777_RYv4kDbzP5OgvDePRfi9jcp8zE9ql3hSAb2ZBmHE.jpeg");
        ImageView img = new ImageView(image);
        img.setFitHeight(450);
        img.setFitWidth(450);

        Label label = new Label("Rental Vehicle System");
        label.setFont(Font.font("Traditional Arabic", FontWeight.BOLD, FontPosture.ITALIC, 18));

        VBox paneForButtons = new VBox(20);
        paneForButtons.getChildren().add(customer);

        Pane pane = new Pane();
        pane.getChildren().add(img);
        VBox images = new VBox();
        images.getChildren().addAll(pane, label);

        HBox main = new HBox();
        main.getChildren().addAll(paneForButtons, images);

        main.setAlignment(Pos.CENTER);
        images.setAlignment(Pos.CENTER);
        paneForButtons.setAlignment(Pos.CENTER);
        label.setAlignment(Pos.BOTTOM_CENTER);

        returnScene= new Scene(main,1600,900);

        // End Main Page Window

        //Customer Window

        BorderPane mainRoot = new BorderPane();

        Button addNewCustomer = new Button("Add New Customer");
        addNewCustomer.setOnAction(e -> stage.setScene(addScene));
        addNewCustomer.setFont(Font.font("Traditional Arabic", FontWeight.BOLD, FontPosture.ITALIC, 18));

        Button deleteCustomer = new Button("Delete A Customer");
        deleteCustomer.setOnAction(e -> stage.setScene(deleteScene));
        deleteCustomer.setFont(Font.font("Traditional Arabic", FontWeight.BOLD, FontPosture.ITALIC, 18));

        Button searchCustomerID = new Button("Search A Customer By Entering ID");
        searchCustomerID.setOnAction(e -> stage.setScene(searchScene));
        searchCustomerID.setFont(Font.font("Traditional Arabic", FontWeight.BOLD, FontPosture.ITALIC, 18));

        Button mainPage = new Button("Return To Main Page");
        mainPage.setOnAction(e -> stage.setScene(returnScene));
        mainPage.setFont(Font.font("Traditional Arabic", FontWeight.BOLD, FontPosture.ITALIC, 18));

        VBox boxForButtons = new VBox(20);
        boxForButtons.getChildren().addAll(addNewCustomer, deleteCustomer, searchCustomerID, mainPage);
        boxForButtons.setAlignment(Pos.CENTER);
        boxForButtons.setLayoutX(710);
        boxForButtons.setLayoutY(300);
        boxForButtons.setScaleX(1.5);
        boxForButtons.setScaleY(1.5);

        mainRoot.setCenter(boxForButtons);
        scene = new Scene(mainRoot, 1600, 920);
        // End of Customer Window

        // Add Customer Window

        BorderPane addCustomerRoot = new BorderPane();

        TextField customerName = new TextField();
        Label labelName = new Label("Customer Name: ");
        labelName.setFont(Font.font("Traditional Arabic", FontWeight.BOLD, FontPosture.ITALIC, 18));

        TextField customerAddress = new TextField();
        Label labelAddress = new Label("Customer Address: ");
        labelAddress.setFont(Font.font("Traditional Arabic", FontWeight.BOLD, FontPosture.ITALIC, 18));

        TextField customerPlan = new TextField();
        Label labelPlan = new Label("Customer's Plan: ");
        labelPlan.setFont(Font.font("Traditional Arabic", FontWeight.BOLD, FontPosture.ITALIC, 18));

        ImageView addIcon = new ImageView("https://img.icons8.com/dusk/344/add--v2.png");
        addIcon.setFitHeight(40);
        addIcon.setFitWidth(40);
        Button add = new Button("Add", addIcon);
        add.setFont(Font.font("Traditional Arabic", FontWeight.BOLD, FontPosture.ITALIC, 18));
        add.setOnAction(e->{
            try {
                system.addCustomer(customerName.getText(), customerAddress.getText(), customerPlan.getText());
                customerName.setText("");
                customerAddress.setText("");
                customerPlan.setText("");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }

        });

        ImageView backIcon = new ImageView("https://img.icons8.com/dusk/344/circled-left-2.png");
        backIcon.setFitHeight(40);
        backIcon.setFitWidth(40);
        Button back = new Button("Back", backIcon);
        back.setOnAction(e -> stage.setScene(scene)); // not sure which scene
        back.setFont(Font.font("Traditional Arabic", FontWeight.BOLD, FontPosture.ITALIC, 18));

        //HERE'S THE ADD AND BACK BUTTONS FOR ADD CUSTOMER SCENE

        HBox addAndBack = new HBox(20);
        addAndBack.getChildren().addAll(add, addIcon, back, backIcon);
        addAndBack.setAlignment(Pos.BOTTOM_CENTER);


        GridPane grid = new GridPane();
        grid.addRow(0, labelName, customerName);
        grid.addRow(1, labelPlan, customerPlan);
        grid.addRow(2, labelAddress, customerAddress);
        grid.addRow(3, addAndBack);
        grid.setTranslateX(30);
        grid.setTranslateY(50);
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setScaleX(1.5);
        grid.setScaleY(1.5);
        grid.setAlignment(Pos.CENTER);

        customerPlan.setEditable(false);
        customerAddress.setEditable(false);

        customerName.setOnKeyTyped(e->{
            customerPlan.setEditable(true);
            customerAddress.setEditable(false);
        });

        customerPlan.setOnKeyTyped(e->{
            customerAddress.setEditable(true);
        });

        addCustomerRoot.setCenter(grid);
        addScene= new Scene(addCustomerRoot, 1600, 900);

        // End Add Customer Window

        // Delete Customer Window

        BorderPane deleteCustomerRoot = new BorderPane();

        TextField deleteName = new TextField();
        Label nameLabel = new Label("Customer Name: ");
        nameLabel.setFont(Font.font("Traditional Arabic", FontWeight.BOLD, FontPosture.ITALIC, 18));
        deleteName.setDisable(false);

        TextField deletePlan = new TextField();
        Label deleteLabel = new Label("Customer Plan: ");
        deleteLabel.setFont(Font.font("Traditional Arabic", FontWeight.BOLD, FontPosture.ITALIC, 18));

        TextField deleteAddress = new TextField();
        Label addressLabel = new Label("Customer Address: ");
        addressLabel.setFont(Font.font("Traditional Arabic", FontWeight.BOLD, FontPosture.ITALIC, 18));

        ImageView findIcon = new ImageView("https://img.icons8.com/external-flat-satawat-anukul/344/external-find-travel-flat-satawat-anukul-2.png");
        findIcon.setFitHeight(40);
        findIcon.setFitWidth(40);
        Button find = new Button("Find", findIcon);
        find.setFont(Font.font("Traditional Arabic", FontWeight.BOLD, FontPosture.ITALIC, 18));
        TextField lettingUserKnowDelete = new TextField();

        find.setOnAction(e -> {
            if(system.searchCustomers(deleteName.getText())==-1){
                lettingUserKnowDelete.setText("No Customers With That Name");
                deleteName.setText("");
                deleteAddress.setText("");
                deletePlan.setText("");
            }

            else {
                int searchingCustomer = system.searchCustomers( deleteName.getText());
                deleteName.setText(system.customerArray.get(searchingCustomer).getName());
                deletePlan.setText(system.customerArray.get(searchingCustomer).getPlan());
                deleteAddress.setText(system.customerArray.get(searchingCustomer).getAddress());
                lettingUserKnowDelete.setText("");

            }
        });

        ImageView deleteIcon = new ImageView("https://img.icons8.com/dusk/344/filled-trash.png");
        deleteIcon.setFitHeight(40);
        deleteIcon.setFitWidth(40);
        Button delete = new Button("Delete", deleteIcon);
        delete.setFont(Font.font("Traditional Arabic", FontWeight.BOLD, FontPosture.ITALIC, 18));
        delete.setOnAction(e->{
            try {
                    system.deleteCustomer(deleteName.getText());
                    deleteName.setText("");
                    deleteAddress.setText("");
                    deletePlan.setText("");
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });

        ImageView backIcon4 = new ImageView("https://img.icons8.com/dusk/344/circled-left-2.png");
        backIcon4.setFitHeight(40);
        backIcon4.setFitWidth(40);
        Button back4 = new Button("Back", backIcon4);
        back4.setOnAction(e -> stage.setScene(scene));
        back4.setFont(Font.font("Traditional Arabic", FontWeight.BOLD, FontPosture.ITALIC, 18));

        HBox deleteAndBack = new HBox(20);
        deleteAndBack.getChildren().addAll(find, findIcon, delete, deleteIcon, back4, backIcon4);


        GridPane gPane = new GridPane();
        gPane.addRow(1, nameLabel, deleteName);
        gPane.addRow(2, deleteLabel, deletePlan);
        gPane.addRow(3, addressLabel, deleteAddress);
        gPane.addRow(4, lettingUserKnowDelete);
        gPane.addRow(5, deleteAndBack);
        gPane.setTranslateX(30);
        gPane.setTranslateY(50);
        gPane.setHgap(20);
        gPane.setVgap(20);
        gPane.setScaleX(1.5);
        gPane.setScaleY(1.5);
        gPane.setAlignment(Pos.CENTER);
        deleteAndBack.setAlignment(Pos.BOTTOM_CENTER);

        deletePlan.setEditable(false);
        deleteAddress.setEditable(false);

        deleteName.setOnKeyTyped(e->{
            deletePlan.setEditable(true);
            deleteAddress.setEditable(false);
        });

        deletePlan.setOnKeyTyped(e->{
            deleteAddress.setEditable(true);
        });

        deleteCustomerRoot.setCenter(gPane);
        deleteScene = new Scene (deleteCustomerRoot, 1600, 900);

        //End Delete Customer Window

        // Search Customer Window

        BorderPane searchCustomerRoot = new BorderPane();

        TextField searchName = new TextField();
        Label labelingName = new Label("Customer Name: ");
        labelingName.setFont(Font.font("Traditional Arabic", FontWeight.BOLD, FontPosture.ITALIC, 18));


        TextField searchAddress = new TextField();
        Label labelingAddress = new Label("Customer Address: ");
        labelingAddress.setFont(Font.font("Traditional Arabic", FontWeight.BOLD, FontPosture.ITALIC, 18));

        TextField searchPlan = new TextField();
        Label labelingPlan = new Label("Customer Plan: ");
        labelingPlan.setFont(Font.font("Traditional Arabic", FontWeight.BOLD, FontPosture.ITALIC, 18));

        ImageView searchIcon = new ImageView("https://img.icons8.com/external-icongeek26-flat-icongeek26/344/external-search-project-work-icongeek26-flat-icongeek26-1.png");
        searchIcon.setFitHeight(40);
        searchIcon.setFitWidth(40);
        Button search = new Button("Search", searchIcon);
        search.setFont(Font.font("Traditional Arabic", FontWeight.BOLD, FontPosture.ITALIC, 18));

        TextField lettingUserKnow = new TextField();
        search.setOnAction(e->{
            if(system.searchCustomers(searchName.getText())==-1){
                lettingUserKnow.setText("No Customers By That Name");
                searchName.setText("");
                searchAddress.setText("");
                searchPlan.setText("");

            }
            else {
                int specificUpdateCustomer = system.searchCustomers(searchName.getText());
                searchName.setText(system.customerArray.get(specificUpdateCustomer).getName());
                searchAddress.setText(system.customerArray.get(specificUpdateCustomer).getAddress());
                searchPlan.setText(system.customerArray.get(specificUpdateCustomer).getPlan());
                lettingUserKnow.setText("");

            }

        });

        ImageView backIcon6 = new ImageView("https://img.icons8.com/dusk/344/circled-left-2.png");
        backIcon6.setFitHeight(40);
        backIcon6.setFitWidth(40);
        Button back6 = new Button("Back", backIcon6);
        back6.setOnAction(e ->{
                searchName.setText("");
                searchAddress.setText("");
                searchPlan.setText("");
                lettingUserKnow.setText("");
                stage.setScene(scene);
        }); // not sure which scene
        back6.setFont(Font.font("Traditional Arabic", FontWeight.BOLD, FontPosture.ITALIC, 18));


        //HERE'S THE ADD AND BACK BUTTONS FOR SEARCH CUSTOMER SCENE
        HBox searchAndBack = new HBox(20);
        searchAndBack.getChildren().addAll(search, searchIcon, back6, backIcon6);
        searchAndBack.setAlignment(Pos.BOTTOM_CENTER);


        GridPane paneGrid = new GridPane();
        paneGrid.addRow(0, labelingName, searchName);
        paneGrid.addRow(1, labelingAddress, searchAddress);
        paneGrid.addRow(2, labelingPlan, searchPlan);
        paneGrid.addRow(3, lettingUserKnow);
        paneGrid.addRow(4, searchAndBack);
        paneGrid.setTranslateX(30);
        paneGrid.setTranslateY(50);
        paneGrid.setHgap(20);
        paneGrid.setVgap(20);
        paneGrid.setScaleX(1.5);
        paneGrid.setScaleY(1.5);
        paneGrid.setAlignment(Pos.CENTER);

        searchPlan.setEditable(false);
        searchAddress.setEditable(false);

        searchName.setOnKeyTyped(e->{
            searchPlan.setEditable(true);
            searchAddress.setEditable(false);
        });

        searchPlan.setOnKeyTyped(e->{
            searchAddress.setEditable(true);
        });

        searchCustomerRoot.setCenter(paneGrid);
        searchScene = new Scene (searchCustomerRoot, 1600, 900);

        // End Search Customer Window


        stage.setTitle("Vehicle Rental Manager!");
        stage.setMaximized(true);
        stage.setScene(returnScene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}