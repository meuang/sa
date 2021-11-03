//package com.example.headjavafx;
//
//import com.example.headjavafx.database.DatabaseConnection;
//import com.example.headjavafx.model.PO;
//import javafx.collections.transformation.FilteredList;
//import javafx.collections.transformation.SortedList;
//import javafx.fxml.Initializable;
//import javafx.scene.control.cell.PropertyValueFactory;
//
//import java.net.URL;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ResourceBundle;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//
//public class profileUserController implements Initializable {
//
//
//    public void initialize(URL url, ResourceBundle resourceBundle){
////        pos = new PO();
////        choiceBoxState.getItems().addAll(state);
////        choiceBoxState.setValue("กำลังผลิต");
////        confirmState.setOnAction(e -> getChoice(choiceBoxState));
//
////        setStatus();
//
//        DatabaseConnection connectNow = new DatabaseConnection();
//        Connection connectDB = connectNow.getConnection();
//
//        String productViewQuery = "SELECT * FROM microchipapp.po";
//        String userViewQuery = "SELECT * FROM microchipapp.user";
//
//        try {
//
//            Statement statement = connectDB.createStatement();
//            ResultSet queryOutPut = statement.executeQuery(productViewQuery);
//
////            Statement statementUser = connectDB.createStatement();
////            ResultSet queryOutPutUser = statementUser.executeQuery(userViewQuery);
//
//            while (queryOutPut.next()){
//                if (queryOutPut.getString("status_PO").equals("-")){
//                    System.out.println(queryOutPut.getString("status_PO"));
//                }else {
//                    Integer queryPOID = queryOutPut.getInt("id_PO");
////                    String queryPOName = queryOutPutUser.getString("name_U");
//                    String queryPOPN = queryOutPut.getString("pn_PO");
//                    Integer queryPOQuantity = queryOutPut.getInt("quantity_PO");
//                    float queryPOTP = queryOutPut.getFloat("total_price_PO");
////                    String queryPOPhone = queryOutPutUser.getString("phone_U");
////                    String queryPOAddress = queryOutPutUser.getString("address_U");
//                    String queryPODate = queryOutPut.getString("date_PO");
//                    String queryPOStatus = queryOutPut.getString("status_PO");
//                    poObservableList.add(new PO(queryPOID,queryPOPN,queryPOQuantity,queryPOTP,queryPODate,queryPOStatus));
////                    userObservableList.add(new user(queryPOName,queryPOPhone,queryPOAddress));
//                    System.out.println(queryOutPut.getString("status_PO"));
//
//                }
//
////                Integer queryPOID = queryOutPut.getInt("id_PO");
////                String queryPOName = queryOutPut.getString("name_PO");
////                String queryPOPN = queryOutPut.getString("pn_PO");
////                Integer queryPOQuantity = queryOutPut.getInt("quantity_PO");
////                float queryPOTP = queryOutPut.getFloat("total_price_PO");
////                String queryPOPhone = queryOutPut.getString("phone_PO");
////                String queryPOAddress = queryOutPut.getString("address_PO");
////                String queryPODate = queryOutPut.getString("date_PO");
////                String queryPOStatus = queryOutPut.getString("status_PO");
////                poObservableList.add(new PO(queryPOID,queryPOName,queryPOPhone,queryPOAddress,queryPOPN,queryPOQuantity,queryPOTP,queryPODate,queryPOStatus));
//            }
//
//
//
//            id_po.setCellValueFactory(new PropertyValueFactory<>("id_PO"));
////            name.setCellValueFactory(new PropertyValueFactory<>("name_U"));
////            phone.setCellValueFactory(new PropertyValueFactory<>("phone_U"));
////            address.setCellValueFactory(new PropertyValueFactory<>("address_U"));
//            pn.setCellValueFactory(new PropertyValueFactory<>("pn_PO"));
//            quantity.setCellValueFactory(new PropertyValueFactory<>("quantity_PO"));
//            tp.setCellValueFactory(new PropertyValueFactory<>("total_price_PO"));
//            date.setCellValueFactory(new PropertyValueFactory<>("date_PO"));
//            status.setCellValueFactory(new PropertyValueFactory<>("status_PO"));
//
//            POTable.setItems(poObservableList);
//
//            POTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//                if (newValue != null) {
//                    showSelectedMemberCard(newValue);
//                }
//            });
//
//            FilteredList<PO> filteredData = new FilteredList<>(poObservableList, b -> true);
//
//            serach.textProperty().addListener((observable, oldValue, newValue) ->{
//                filteredData.setPredicate(PO -> {
//
//                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null){
//                        return true;
//                    }
//
//                    String searchKeyword = newValue.toLowerCase();
//
//                    if (PO.getDate_PO().toLowerCase().indexOf(searchKeyword) > -1){
//                        return true;
//                    }
////                    else if (PO.getDate_po().toLowerCase().indexOf(searchKeyword) > -1){
////                        return true;
////                    }
//                    else if (PO.getPn_PO().toLowerCase().indexOf(searchKeyword) > -1){
//                        return true;
//                    }
////                    else if (PO.getStatus_po().toLowerCase().indexOf(searchKeyword) > -1){
////                        return true;
////                    }
////                    else if (PO.getId_PO().toString().toLowerCase().indexOf(searchKeyword) > -1){
////                        return true;
////                    }
//                    else {
//                        return false;
//                    }
//
//                });
//            });
//
//
//            SortedList<PO> sortedData = new SortedList<>(filteredData);
//            sortedData.comparatorProperty().bind(POTable.comparatorProperty());
//
//            POTable.setItems(sortedData);
//
//        }catch (SQLException e){
//            Logger.getLogger(homeEmployeeController.class.getName()).log(Level.SEVERE,null,e);
//            e.printStackTrace();
//        }
//
//
//
//    }
//}