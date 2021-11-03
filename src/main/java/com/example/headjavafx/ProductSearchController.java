package com.example.headjavafx;


import com.example.headjavafx.database.DatabaseConnection;
import com.example.headjavafx.model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductSearchController implements Initializable {

    private Product selectedProduct;
    private Product productDetail;


    @FXML
    private TableView<Product> productTableView;


    @FXML
    private TableColumn<Product, String> id_ProductTableColumn,name_ProductTableColumn,image_ProductTableColumn;
    @FXML
    private TableColumn<Product, Float> price_ProductTableColumn;
    @FXML
    private TableColumn<Product, Integer> quantity_ProductTableColumn;
    @FXML
    private TextField keywordTextField;
    @FXML
    private TextField editQuantity_Field;
    @FXML
    private Label warning,editWarning;
    @FXML
    private TextField idPro_Field, namePro_Field, pricePro_Field, quantityPro_Field,imagePro_Field;

    @FXML
    private Button inQuantity_Button, addProduct_Button, editQuantityButton;
    @FXML
    private Button clear_Button;

    @FXML
    private ImageView imageView;

    @Override
    public void initialize(URL url, ResourceBundle resource) {
        inQuantity_Button.setDisable(true);
        editQuantityButton.setDisable(true);
        addProduct_Button.setDisable(false);
        clear_Button.setDisable(true);
//        addProduct_Button.setDisable(true);
        updateTable();


    }
//onaction textfield//
    private void showSelectedWork(Product product) {
        selectedProduct = product;//getproduct
        inQuantity_Button.setDisable(false);
        editQuantityButton.setDisable(false);
        addProduct_Button.setDisable(true);
        clear_Button.setDisable(false);
        editWarning.setText("");
        warning.setText("");


        System.out.println(selectedProduct.getId_P());

        idPro_Field.setText(selectedProduct.getId_P());
//
        namePro_Field.setText(selectedProduct.getName_P());

        pricePro_Field.setText(String.format("%.2f", selectedProduct.getPrice_P()));
        quantityPro_Field.setText(String.format("%d", selectedProduct.getQuantity_P()));
//        editQuantity_Field.setText(String.format("%d", selectedProduct.getQuantity_P()));


        imagePro_Field.setText(selectedProduct.getImage_P());
//        imageView.setImage(new Image(getClass().getResource(selectedProduct.getImage_P()).toExternalForm()));
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectionDB = connectionNow.getConnection();

        String connectQuery = "SELECT * FROM microchipapp.product";

        try {
            Statement statement = connectionDB.createStatement();
            ResultSet queryOutPut = statement.executeQuery(connectQuery);
            while (queryOutPut.next()){
                File brandingFile = new File("image/"+selectedProduct.getImage_P());
                Image brandingImage = new Image(brandingFile.toURI().toString());
                imageView.setImage(brandingImage);
            }
        } catch (Exception e){
            e.printStackTrace();
        }



    }

    public void updateTable(){
        ObservableList<Product> productObservableList = FXCollections.observableArrayList();
        productDetail = new Product();
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectionDB = connectNow.getConnection();

        //SQL Query - Executed in the backed database
        String productViewQuery = "SELECT * FROM microchipapp.product";

        try {
            Statement statement = connectionDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(productViewQuery);

            while (queryOutput.next()) {
                String queryID = queryOutput.getString("id_P");
                String queryImage = queryOutput.getString("image_P");
                String queryName = queryOutput.getString("name_P");
                float queryPrice = queryOutput.getFloat("price_P");
                int queryQuantity = queryOutput.getInt("all_quantity_P");

                // Populate the ObservableList
                productObservableList.add(new Product(queryID, queryName, queryPrice, queryQuantity, queryImage));


            }

            id_ProductTableColumn.setCellValueFactory(new PropertyValueFactory<>("id_P"));
            name_ProductTableColumn.setCellValueFactory(new PropertyValueFactory<>("name_P"));
            price_ProductTableColumn.setCellValueFactory(new PropertyValueFactory<>("price_P"));
            quantity_ProductTableColumn.setCellValueFactory(new PropertyValueFactory<>("quantity_P"));
            image_ProductTableColumn.setCellValueFactory(new PropertyValueFactory<>("image_P"));
            productTableView.setItems(productObservableList);
            productTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) {
                    showSelectedWork(newValue);
                }
            });

            FilteredList<Product> filteredDate = new FilteredList<>(productObservableList, b -> true);

            keywordTextField.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredDate.setPredicate(product -> {

                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                        return true;
                    }
                    String searchKeyword = newValue.toLowerCase();
                    if (product.getId_P().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;//found a match in product
                    } else if (product.getName_P().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;
                    } else if (product.getImage_P().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;
                    } else
                        return false;//not found

                });
            });
            SortedList<Product> sortedData = new SortedList<>(filteredDate);

            //bind sorted result result with table view
            sortedData.comparatorProperty().bind(productTableView.comparatorProperty());

            //apply filtered and sorted data to the table view
            productTableView.setItems(sortedData);


        } catch (SQLException e) {
            Logger.getLogger(ProductSearchController.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }

    }

    //    public void decreaseQuantityOnAction(ActionEvent event) throws IOException {
//        DatabaseConnection connectionNow = new DatabaseConnection();
//        Connection connectDB = connectionNow.getConnection();
//
//        String idProduct = selectedProduct.getId_P();
////        String editQuantity =  editQuantity_Field.getText();
//
//        int n = Integer.parseInt(editQuantity_Field.getText());
//        String i = String.valueOf(n - 1);
//
//        String updateField = "UPDATE microchip.product SET quantity_P = + '" + i + "' WHERE id_P = '" + idProduct + "'";
//
//        try {
//            Statement statement = connectDB.createStatement();
//            statement.executeUpdate(updateField);
//            updateTable();
//
////            Button b = (Button) event.getSource();
////            Stage stage = (Stage) b.getScene().getWindow();
////
////            FXMLLoader loader = new FXMLLoader(getClass().getResource("product-view.fxml"));
////            stage.setScene(new Scene(loader.load(), 1080, 600));
////            stage.setTitle("MicrochipStarApp!");
////            stage.show();
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            e.getCause();
//        }
//
//
//    }
    public void increaseQuantityButtonOnAction(ActionEvent event) throws IOException {
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectDB = connectionNow.getConnection();
        if (editQuantity_Field.getText().isEmpty()) {
            editWarning.setText("Please fill in the empty box before proceed.");
        } else {
            if(productDetail.isInt(editQuantity_Field.getText())) {
                if (Integer.parseInt(editQuantity_Field.getText()) > 0 ) {
                    String idProduct = selectedProduct.getId_P();
                    int n = Integer.parseInt(editQuantity_Field.getText()) + Integer.parseInt(quantityPro_Field.getText());
                    String i = String.valueOf(n);
                    String updateField = "UPDATE microchipapp.product SET all_quantity_P = + '" + i + "' WHERE id_P = '" + idProduct + "'";
                    try {
                        Statement statement = connectDB.createStatement();
                        statement.executeUpdate(updateField);
                        clearSelectedProduct();
                        updateTable();
                    } catch (Exception e) {
                        e.printStackTrace();
                        e.getCause();
                    }
                }
                else{editWarning.setText("Please enter correct information.");}
            }else {editWarning.setText("Please enter the numbers.");
            }
        }






    }
    public void editQuantityButtonOnAction(ActionEvent event){
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectDB = connectionNow.getConnection();

        String idProduct = selectedProduct.getId_P();
        String editQuantity = editQuantity_Field.getText();
        if (editQuantity_Field.getText().isEmpty()) {
            editWarning.setText("Please fill in the empty box before proceed.");
        }
        else {
            if(productDetail.isInt(editQuantity_Field.getText())) {
                if (Integer.parseInt(editQuantity_Field.getText()) >= 0 ) {
                    String updateField = "UPDATE microchipapp.product SET quantity_P = + '" + editQuantity + "' WHERE id_P = '" + idProduct + "'";
                    try {
                        Statement statement = connectDB.createStatement();
                        statement.executeUpdate(updateField);
                        clearSelectedProduct();
                        updateTable();

                    } catch (Exception e) {
                        e.printStackTrace();
                        e.getCause();
                    }
                }
                else{editWarning.setText("Please enter correct information.");}
            }else {editWarning.setText("Please enter the numbers.");
            }
        }









    }

    private void clearSelectedProduct() {
        selectedProduct = null;
        idPro_Field.clear();
        namePro_Field.clear();
        pricePro_Field.clear();
        quantityPro_Field.clear();
        imagePro_Field.clear();
        editQuantity_Field.clear();
        editWarning.setText("");
        warning.setText("");


        editQuantityButton.setDisable(true);
        inQuantity_Button.setDisable(true);
        addProduct_Button.setDisable(true);

    }
    public void clearButtonOnAction(ActionEvent event){
        clearSelectedProduct();
        addProduct_Button.setDisable(false);

    }

    public void addProductOnAction(ActionEvent event) throws IOException {
        if (idPro_Field.getText().isEmpty() || namePro_Field.getText().isEmpty()
                || imagePro_Field.getText().isEmpty() || pricePro_Field.getText().isEmpty() || quantityPro_Field.getText().isEmpty()) {
            warning.setText("Please fill in the empty box before proceed.");
        }
        else {
            if(productDetail.checkProduct(idPro_Field.getText(), namePro_Field.getText(),imagePro_Field.getText())) {
                warning.setText("This information is already taken!.");
            }
            else {
                if(productDetail.isInt(quantityPro_Field.getText()) && productDetail.isFloat(pricePro_Field.getText())) {
                if (Integer.parseInt(quantityPro_Field.getText()) >= 0 && Float.parseFloat(pricePro_Field.getText()) > 0) {
//                    System.out.println(Float.parseFloat(pricePro_Field.getText())+1);
//                    System.out.println(Integer.parseInt(quantityPro_Field.getText())+2);

//                    System.out.println("asfasf");
                    productDetail.addProduct(idPro_Field.getText(), namePro_Field.getText(), Float.parseFloat(pricePro_Field.getText()),
                            imagePro_Field.getText(), Integer.parseInt(quantityPro_Field.getText()));

                    Button b = (Button) event.getSource();
                    Stage stage = (Stage) b.getScene().getWindow();

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("product-view.fxml"));
                    stage.setScene(new Scene(loader.load(), 1080, 600));
                    stage.setTitle("MicrochipStarApp!");
                    stage.show();
                }
                    else{warning.setText("Please enter correct information.");}
            }

                else {
                warning.setText("Please enter correct information.");
            }

            }
        }






    }



    public void nextButtonOnAction(ActionEvent event)throws IOException{
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("market-view.fxml"));
        stage.setScene(new Scene(loader.load(), 1080, 600));
        stage.setTitle("MicrochipStarApp!");
        stage.show();




    }


}