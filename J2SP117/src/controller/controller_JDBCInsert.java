/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DBContext.DBContext;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import view.JDBCInsertGUI;

/**
 *
 * @author admin
 */
public class controller_JDBCInsert {
//Declare

    //declare
    DBContext db = new DBContext();
    //GUI
    JDBCInsertGUI jDBCInsertGUI;

    //compoment
    JTable StockTable;
    
    JButton InsertButton;
    //Event
    ActionListener InsertListener;

    //model table
    DefaultTableModel StockTableModel;
    //CellRenderer
    DefaultTableCellRenderer StockTableCellRenderer;

    //
    public controller_JDBCInsert() {
        initComponents();
        jDBCInsertGUI.setVisible(true);
    }
    
    private void initComponents() {
        Connection insertConnection = getConnection();
        jDBCInsertGUI = new JDBCInsertGUI();
        StockTable = jDBCInsertGUI.getJDBCTable();
        InsertButton = jDBCInsertGUI.getInsertButton();
        //setTable cell Alignment
        setTableCellAlignment();
        //set all values of cell is ""
        setDefaultValuesOfCell();

        //Add Test case values
        addTestCaseValues();

        //Event Function
        InsertListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (insertConnection == null) {
                    JOptionPane.showMessageDialog(jDBCInsertGUI, "Connection fail");
                    return;
                }
                System.out.println("Connection Success");
                if (!checkDataBaseExits(insertConnection)) {
                    JOptionPane.showMessageDialog(jDBCInsertGUI, "DataBase not exits");
                    return;
                }
                System.out.println("Database exits");
                if (!checkTableExits(insertConnection)) {
                    JOptionPane.showMessageDialog(jDBCInsertGUI, "Table not exits");
                    return;
                }
                System.out.println("Table exits");
                try {
                    insertToDatabase(insertConnection);
                    closingConnection(null, null, insertConnection);
                    if (insertConnection.isClosed()) {
                        JOptionPane.showMessageDialog(jDBCInsertGUI, "Closed Connection");
                    }
                } catch (Exception ex) {
                    
                }
                
            }
            
            private boolean checkDataBaseExits(Connection insertConnection) {
                PreparedStatement psInsert = null;
                ResultSet rs = null;
                try {
                    String sql = "select * from sys.databases where [name] = 'FU_DB'";
                    psInsert = insertConnection.prepareStatement(sql);
                    rs = psInsert.executeQuery();
                    if (rs.next()) {
                        closingConnection(rs, psInsert, null);
                        return true;
                    }
                } catch (SQLException e) {
                    closingConnection(rs, psInsert, null);
                    JOptionPane.showMessageDialog(jDBCInsertGUI, "Database can't not find out");
                }
                closingConnection(rs, psInsert, null);
                return false;
            }
            
            private boolean checkTableExits(Connection insertConnection) {
                PreparedStatement psInsert = null;
                ResultSet rs = null;
                try {
                    String sql = "use FU_DB\n"
                            + "select* from INFORMATION_SCHEMA.TABLES where TABLE_NAME ='Stocks'";
                    psInsert = insertConnection.prepareStatement(sql);
                    rs = psInsert.executeQuery();
                    if (rs.next()) {
                        closingConnection(rs, psInsert, null);
                        return true;
                    }
                } catch (SQLException e) {
                    closingConnection(rs, psInsert, null);
                    JOptionPane.showMessageDialog(jDBCInsertGUI, "Can't not find out table");
                }
                closingConnection(rs, psInsert, null);
                return false;
            }
            
        };
        InsertButton.addActionListener(InsertListener);
    }
    
    private void insertToDatabase(Connection insertConnection) throws Exception {
        initDataFromTBAndInsert(StockTable, insertConnection);
        //reset all values of cell is ""
        setDefaultValuesOfCell();
    }
    
    private void setDefaultValuesOfCell() {
        StockTableModel = (DefaultTableModel) StockTable.getModel();//get model of table
        for (int i = 0; i < StockTableModel.getRowCount(); i++) {
            for (int j = 0; j < StockTableModel.getColumnCount(); j++) {
                StockTableModel.setValueAt("", i, j);
            }
        }
    }
    
    private Connection getConnection() {
        try {
            Connection connection = db.getConnection();
            return connection;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(jDBCInsertGUI, "Can't not connect to database");
        }
        return null;
    }
    
    private void addTestCaseValues() {
        StockTableModel = (DefaultTableModel) StockTable.getModel();
        Object[] Stock1 = {1, "Stock one", "No1-Washington", "11/05/2010", ""};
        Object[] Stock2 = {2, "Stock two", "372 Cave Town -", "09/07/2011", ""};
        Object[] Stock3 = {3, "Stock three", "Nary angel-890", "13/05/2010", "Store dangerous"};
        Object[] Stock4 = {4, "Stock four", "Twin tower-01", "04/07/2015", ""};
        Object[] Stock5 = {5, "Stock five", "Victory anniversary", "08/12/2014", ""};
        StockTableModel.addRow(Stock1);
        StockTableModel.addRow(Stock2);
        StockTableModel.addRow(Stock3);
        StockTableModel.addRow(Stock4);
        StockTableModel.addRow(Stock5);
        
    }
    
    private void setTableCellAlignment() {
        //get Table header and set Alignment is Center
        ((DefaultTableCellRenderer) StockTable.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT);
        StockTableCellRenderer = new DefaultTableCellRenderer();
        //set Aligment for column is leading
        StockTableCellRenderer.setHorizontalAlignment(JLabel.LEADING);
        //add to all the column in table
        for (int i = 0; i < StockTable.getColumnCount(); i++) {
            StockTable.getColumnModel().getColumn(i).setCellRenderer(StockTableCellRenderer);
        }
        
    }
    
    public void initDataFromTBAndInsert(JTable StockTable, Connection insertConnection) throws SQLException, Exception {
        PreparedStatement pstInsert = null;
//create try catch to catching exception of format
        try {
            //string query
            String query = "use FU_DB\ninsert into Stocks\n"
                    + "values(?,?,?,CONVERT(varchar,CONVERT(datetime,?,103),111),?)";
            insertConnection = db.getConnection();
            pstInsert = insertConnection.prepareStatement(query);
            //set auto commit by false to using batch
            insertConnection.setAutoCommit(false);
            //get value of table add to batch
            for (int i = 0; i < StockTable.getRowCount(); i++) {
                //set value for ID column if it is null or not
                if (!StockTable.getValueAt(i, 0).toString().isEmpty()) {
                    pstInsert.setInt(1, Integer.parseInt(StockTable.getValueAt(i, 0).toString()));
                } else {
                    pstInsert.setNull(1, Types.INTEGER);
                }
                pstInsert.setString(2, StockTable.getValueAt(i, 1).toString());
                pstInsert.setString(3, StockTable.getValueAt(i, 2).toString());
                //set null for Date column if the cell is empty
                System.out.println(StockTable.getValueAt(i, 3).toString());
                if (StockTable.getValueAt(i, 3).toString().isEmpty()) {
                    pstInsert.setNull(4, Types.VARCHAR);
                } else {
                    pstInsert.setString(4, StockTable.getValueAt(i, 3).toString());
                }
                pstInsert.setString(5, StockTable.getValueAt(i, 4).toString());
                pstInsert.addBatch();
            }
            pstInsert.executeBatch();
            pstInsert.clearBatch();//clear all the query in batch
            insertConnection.commit();//commit the transaction
            closingConnection(null, pstInsert, insertConnection);
            JOptionPane.showMessageDialog(StockTable, "Insert Successfull!!!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(StockTable, "ERROR " + e.getMessage());
            //if there is an error. Implement the rollback function. cancel all transactions
            insertConnection.rollback();
            closingConnection(null, pstInsert, insertConnection);
        }
    }
    
    private void closingConnection(ResultSet rs, PreparedStatement pst, Connection connection) {
        try {
            if (rs != null) {
                rs.close();
                System.out.println("ResultSet is closed");
            }
            if (pst != null) {
                pst.close();
                System.out.println("PrepareStatement is Closed");
            }
            if (connection != null) {
                connection.close();
                System.out.println("Connnection is Closed");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(jDBCInsertGUI, e.getMessage());
        }
    }
    
}
