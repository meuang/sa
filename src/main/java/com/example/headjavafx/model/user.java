//package com.example.headjavafx.model;
//
//import com.example.headjavafx.database.DatabaseConnection;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;
//
//public class user {
//    private String username_U;
//    private String password_U;
//    private String name_U;
//    private String phone_U;
//    private String address_U;
//    private String evidence_U;
//    private String id_U;
//
//    public user() {
//    }
//
//    public user(String name_U, String phone_U, String address_U) {
//        this.name_U = name_U;
//        this.phone_U = phone_U;
//        this.address_U = address_U;
//    }
//
//    public user(String username_U, String password_U, String name_U, String phone_U, String address_U) {
//        this.username_U = username_U;
//        this.password_U = password_U;
//        this.name_U = name_U;
//        this.phone_U = phone_U;
//        this.address_U = address_U;
//    }
//
//    public user(String username_U, String password_U, String name_U, String phone_U, String address_U, String evidence_U, String id_U) {
//        this.username_U = username_U;
//        this.password_U = password_U;
//        this.name_U = name_U;
//        this.phone_U = phone_U;
//        this.address_U = address_U;
//        this.evidence_U = evidence_U;
//        this.id_U = id_U;
//    }
//
//    public String getUsername_U() {
//        return username_U;
//    }
//
//    public void setUsername_U(String username_U) {
//        this.username_U = username_U;
//    }
//
//    public String getPassword_U() {
//        return password_U;
//    }
//
//    public void setPassword_U(String password_U) {
//        this.password_U = password_U;
//    }
//
//    public String getName_U() {
//        return name_U;
//    }
//
//    public void setName_U(String name_U) {
//        this.name_U = name_U;
//    }
//
//    public String getPhone_U() {
//        return phone_U;
//    }
//
//    public void setPhone_U(String phone_U) {
//        this.phone_U = phone_U;
//    }
//
//    public String getAddress_U() {
//        return address_U;
//    }
//
//    public void setAddress_U(String address_U) {
//        this.address_U = address_U;
//    }
//
//    public String getEvidence_U() {
//        return evidence_U;
//    }
//
//    public void setEvidence_U(String evidence_U) {
//        this.evidence_U = evidence_U;
//    }
//
//    public String getId_U() {
//        return id_U;
//    }
//
//    public void setId_U(String id_U) {
//        this.id_U = id_U;
//    }
//
//    public boolean checkLogin(String username, String password){
//        DatabaseConnection connectionNow = new DatabaseConnection();
//        Connection connectionDB = connectionNow.getConnection();
//
//        String connectQuery = "SELECT * FROM microchipapp.user";
//        String connectQueryRole = "";
//
//        try {
//            Statement statement = connectionDB.createStatement();
//            ResultSet queryOutPut = statement.executeQuery(connectQuery);
//            while (queryOutPut.next()){
//                if (username.equals(queryOutPut.getString("username_U")) && password.equals(queryOutPut.getString("password_U"))){
//                    return true;
//                }
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    public boolean checkUsername(String username){
//        DatabaseConnection connectionNow = new DatabaseConnection();
//        Connection connectionDB = connectionNow.getConnection();
//
//        String connectQuery = "SELECT * FROM microchipapp.user";
//        String connectQueryRole = "";
//
//        try {
//            Statement statement = connectionDB.createStatement();
//            ResultSet queryOutPut = statement.executeQuery(connectQuery);
//            while (queryOutPut.next()){
//                if (username.equals(queryOutPut.getString("username_U"))){
//                    return false;
//                }
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        return true;
//    }
//
//    public void registerUser(String name,String username, String password,String phone, String address){
//        DatabaseConnection connectionNow = new DatabaseConnection();
//        Connection connectionDB = connectionNow.getConnection();
//
//        String insertFields = "INSERT INTO microchipapp.user (username_U, password_U, name_U, phone_U, address_U, evidence_U, id_U) VALUES ('";
//        String insertValues = username + "','" + password + "','" + name + "','" + phone + "','" + address + "','" + "-" + "','" + 0 + "')";
//        String insertToRegister = insertFields + insertValues;
//
//
//
//        try {
//            Statement statement = connectionDB.createStatement();
//            statement.executeUpdate(insertToRegister);
//
//
//        }catch (Exception e){
//            e.printStackTrace();
//            e.getCause();
//        }
//    }
//}
