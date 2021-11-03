//package com.example.headjavafx.model;
//
//import com.example.headjavafx.database.DatabaseConnection;
//
//import java.sql.Connection;
//import java.sql.Statement;
//
//public class PO {
//    private Integer id_PO;
//    private String pn_PO;
//    private int quantity_PO;
//    private float total_price_PO;
//    private String date_PO;
//    private String status_PO;
//
//    public PO() {
//    }
//
//    public PO(int id_PO, String pn_PO, int quantity_PO, float total_price_PO, String date_PO, String status_PO) {
//        this.id_PO = id_PO;
//        this.pn_PO = pn_PO;
//        this.quantity_PO = quantity_PO;
//        this.total_price_PO = total_price_PO;
//        this.date_PO = date_PO;
//        this.status_PO = status_PO;
//    }
//
//    public PO(String pn_PO, int quantity_PO, float total_price_PO, String date_PO, String status_PO) {
//        this.pn_PO = pn_PO;
//        this.quantity_PO = quantity_PO;
//        this.total_price_PO = total_price_PO;
//        this.date_PO = date_PO;
//        this.status_PO = status_PO;
//    }
//
//    public int getId_PO() {
//        return id_PO;
//    }
//
//    public void setId_PO(int id_PO) {
//        this.id_PO = id_PO;
//    }
//
//    public String getPn_PO() {
//        return pn_PO;
//    }
//
//    public void setPn_PO(String pn_PO) {
//        this.pn_PO = pn_PO;
//    }
//
//    public int getQuantity_PO() {
//        return quantity_PO;
//    }
//
//    public void setQuantity_PO(int quantity_PO) {
//        this.quantity_PO = quantity_PO;
//    }
//
//    public float getTotal_price_PO() {
//        return total_price_PO;
//    }
//
//    public void setTotal_price_PO(float total_price_PO) {
//        this.total_price_PO = total_price_PO;
//    }
//
//    public String getDate_PO() {
//        return date_PO;
//    }
//
//    public void setDate_PO(String date_PO) {
//        this.date_PO = date_PO;
//    }
//
//    public String getStatus_PO() {
//        return status_PO;
//    }
//
//    public void setStatus_PO(String status_PO) {
//        this.status_PO = status_PO;
//    }
//
//    public void changeStatus(int id,String status,String statusText){
//        DatabaseConnection connectionNow = new DatabaseConnection();
//        Connection connectionDB = connectionNow.getConnection();
//
//
//        String insertFields = "UPDATE microchipapp.po SET status_PO = '" + status  + "'WHERE id_PO = '" + id + "'AND status_PO = '" + statusText + "'";
////        String insertValues = username + "','" + password + "','" + name + "','" + phone + "','" + address + "','" + "-" + "','" + 0 + "')";
////        String insertToRegister = insertFields + insertValues;
//        System.out.println(insertFields);
//
//
//
//        try {
//            Statement statement = connectionDB.createStatement();
//            statement.executeUpdate(insertFields);
//
//
//        }catch (Exception e){
//            e.printStackTrace();
//            e.getCause();
//        }
//    }
//}
