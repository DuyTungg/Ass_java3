/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tungtdph05023;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Tùng_Anh
 */
public class ConnectionUtils {
    public static Connection getMyConnection() throws SQLException,
          ClassNotFoundException {

      return SQLServerConnUtils_SQLJDBC.getSQLServerConnection();
  }
 

  public static void main(String[] args) throws SQLException,
          ClassNotFoundException {

      System.out.println("Get connection ... ");
 
      Connection conn = ConnectionUtils.getMyConnection();
 
      System.out.println("Get connection " + conn);
 
      System.out.println("Done!");}
}