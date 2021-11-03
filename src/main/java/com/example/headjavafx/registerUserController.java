//package com.example.headjavafx;
//
//import com.example.headjavafx.model.employee;
//import com.example.headjavafx.model.user;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.PasswordField;
//import javafx.scene.control.TextField;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//
//public class registerUserController {
//    @FXML
//    private TextField name,username,phone,address;
//
//    @FXML
//    private PasswordField password,ConfirmPassword;
//
//    @FXML
//    private Button closeButton;
//
//    @FXML
//    private Label error;
//
//    private user users;
//    private employee employee;
//
//    public void initialize(){
//        users = new user();
//        employee = new employee();
//    }
//
//    public void closeButtonAction(ActionEvent event){
//        Stage stage = (Stage) closeButton.getScene().getWindow();
//        stage.close();
//    }
//
//    public void registerButtonOnAction(ActionEvent event) throws IOException {
//        if (name.getText().isEmpty() || username.getText().isEmpty() || password.getText().isEmpty() || phone.getText().isEmpty() || address.getText().isEmpty() || ConfirmPassword.getText().isEmpty()){
//            error.setText("กรุณากรอกข้อมูลให้ครับ");
//            name.clear();
//            username.clear();
//            password.clear();
//            ConfirmPassword.clear();
//            phone.clear();
//            address.clear();
//        }else {
//            if (password.getText().equals(ConfirmPassword.getText())){
//                if (employee.checkUsername(username.getText())){
//                    if (users.checkUsername(username.getText())){
//                        users.registerUser(name.getText(),username.getText(),password.getText(),phone.getText(),address.getText());
//                        error.setText("ลงทะเบียนสำเร็จ");
//                        System.out.println("3");
//                    }else {
//                        System.out.println("1");
//                        error.setText("username นี้มีแล้ว");
//                        name.clear();
//                        username.clear();
//                        password.clear();
//                        ConfirmPassword.clear();
//                        phone.clear();
//                        address.clear();
//                    }
//                }else {
//                    System.out.println("2");
//                    error.setText("username นี้มีแล้ว");
//                    name.clear();
//                    username.clear();
//                    password.clear();
//                    ConfirmPassword.clear();
//                    phone.clear();
//                    address.clear();
//                }
//
//            }else {
//                error.setText("password ไม่ตรงกัน");
//                name.clear();
//                username.clear();
//                password.clear();
//                ConfirmPassword.clear();
//                phone.clear();
//                address.clear();
//            }
//        }
//
//
//    }
//
//}
