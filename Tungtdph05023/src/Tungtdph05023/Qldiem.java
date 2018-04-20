/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tungtdph05023;

import Tungtdph05023.QLsv;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import sun.misc.Cleaner;


/**
 *
 * @author Tùng_Anh
 */
public class Qldiem extends javax.swing.JFrame {
    DefaultTableModel dftbDiem = new DefaultTableModel();
    DefaultTableModel dftbTinHoc = new DefaultTableModel();
    DefaultTableModel dftbTiengAnh = new DefaultTableModel();
    DefaultTableModel dftbLapTrinh = new DefaultTableModel();
    DefaultTableModel dftbDoHoa = new DefaultTableModel();
    /**
     * Creates new form Qldiem
     */
    
    public Qldiem() {
        initComponents();
        LoadData();
        LoadTinHoc();
        LoadTiengAnh();
        LoadLapTrinh();
        LoadDoHoa();
    }
    
    public void LoadData(){
    try {
            ConnectionUtils Data = new ConnectionUtils();
            Connection con = Data.getMyConnection();
            String sql = "Select * from Diem";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData meta = rs.getMetaData();
            int n = meta.getColumnCount();
            Vector col = new Vector();
            for (int i = 0; i < n; i++) {
                col.add(meta.getColumnName((i + 1)));
            }
            dftbDiem.setColumnIdentifiers(col);
            while (rs.next()) {
                Vector row = new Vector();
                for (int i = 0; i < n; i++) {
                    row.addElement(rs.getString(i + 1));
                }
                dftbDiem.addRow(row);
            }
    tblDanhSachDiem.setModel(dftbDiem);
    tblDanhSachDiem.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
    @Override
    public void valueChanged(ListSelectionEvent e) {
    if (tblDanhSachDiem.getSelectedRow() >= 0) {
        txtMaSV.setText(tblDanhSachDiem.getValueAt(tblDanhSachDiem.getSelectedRow(), 0).toString());
        txtHoTen.setText(tblDanhSachDiem.getValueAt(tblDanhSachDiem.getSelectedRow(), 1).toString());
        txtTinHoc.setText(tblDanhSachDiem.getValueAt(tblDanhSachDiem.getSelectedRow(), 2).toString());
        txtTiengAnh.setText(tblDanhSachDiem.getValueAt(tblDanhSachDiem.getSelectedRow(), 3).toString());
        txtLapTrinh.setText(tblDanhSachDiem.getValueAt(tblDanhSachDiem.getSelectedRow(), 4).toString());
        txtDoHoa.setText(tblDanhSachDiem.getValueAt(tblDanhSachDiem.getSelectedRow(), 5).toString());
        txtDiemTB.setText("");
        float a = Float.parseFloat(txtTiengAnh.getText());
        float b = Float.parseFloat(txtDoHoa.getText());
        float c = Float.parseFloat(txtTinHoc.getText());
        float d = Float.parseFloat(txtLapTrinh.getText());
        float tb = (a+b+c+d)/4;
        txtDiemTB.setText(tb + "");
            }
        }
    });
    } catch (Exception ex) {
            System.out.println("loi: " + ex.getMessage());
        }
    }
    
    
    public void LoadTinHoc(){
    try {
            ConnectionUtils Data = new ConnectionUtils();
            Connection con = Data.getMyConnection();
            String sql = "select top 3 MaSV, HoTen, TinHoc from Diem order by TinHoc desc";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData meta = rs.getMetaData();
            int n = meta.getColumnCount();
            Vector col = new Vector();
            for (int i = 0; i < n; i++) {
                col.add(meta.getColumnName((i + 1)));
            }
            dftbTinHoc.setColumnIdentifiers(col);
            while (rs.next()) {
                Vector row = new Vector();
                for (int i = 0; i < n; i++) {
                    row.addElement(rs.getString(i + 1));
                }
                dftbTinHoc.addRow(row);
            }
    tblTinHoc.setModel(dftbTinHoc);
    } catch (Exception ex) {
            System.out.println("loi: " + ex.getMessage());
        }
    }
    
    
    public void LoadTiengAnh(){
    try {
            ConnectionUtils Data = new ConnectionUtils();
            Connection con = Data.getMyConnection();
            String sql = "select top 3 MaSV, HoTen, TiengAnh from Diem order by TiengAnh desc";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData meta = rs.getMetaData();
            int n = meta.getColumnCount();
            Vector col = new Vector();
            for (int i = 0; i < n; i++) {
                col.add(meta.getColumnName((i + 1)));
            }
            dftbTiengAnh.setColumnIdentifiers(col);
            while (rs.next()) {
                Vector row = new Vector();
                for (int i = 0; i < n; i++) {
                    row.addElement(rs.getString(i + 1));
                }
                dftbTiengAnh.addRow(row);
            }
    tblTiengAnh.setModel(dftbTiengAnh);
    } catch (Exception ex) {
            System.out.println("loi: " + ex.getMessage());
        }
    }
    
    
    public void LoadLapTrinh(){
    try {
            ConnectionUtils Data = new ConnectionUtils();
            Connection con = Data.getMyConnection();
            String sql = "select top 3 MaSV, HoTen, LapTrinh from Diem order by LapTrinh desc";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData meta = rs.getMetaData();
            int n = meta.getColumnCount();
            Vector col = new Vector();
            for (int i = 0; i < n; i++) {
                col.add(meta.getColumnName((i + 1)));
            }
            dftbLapTrinh.setColumnIdentifiers(col);
            while (rs.next()) {
                Vector row = new Vector();
                for (int i = 0; i < n; i++) {
                    row.addElement(rs.getString(i + 1));
                }
                dftbLapTrinh.addRow(row);
            }
    tblLapTrinh.setModel(dftbLapTrinh);
    } catch (Exception ex) {
            System.out.println("loi: " + ex.getMessage());
        }
    }
    
    
    public void LoadDoHoa(){
    try {
            ConnectionUtils Data = new ConnectionUtils();
            Connection con = Data.getMyConnection();
            String sql = "select top 3 MaSV, HoTen, DoHoa from Diem order by DoHoa desc";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData meta = rs.getMetaData();
            int n = meta.getColumnCount();
            Vector col = new Vector();
            for (int i = 0; i < n; i++) {
                col.add(meta.getColumnName((i + 1)));
            }
            dftbDoHoa.setColumnIdentifiers(col);
            while (rs.next()) {
                Vector row = new Vector();
                for (int i = 0; i < n; i++) {
                    row.addElement(rs.getString(i + 1));
                }
                dftbDoHoa.addRow(row);
            }
    tblDoHoa.setModel(dftbDoHoa);
    } catch (Exception ex) {
            System.out.println("loi: " + ex.getMessage());
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblMaSV = new javax.swing.JLabel();
        txtTkMaSV = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        txtMaSV = new javax.swing.JTextField();
        txtTinHoc = new javax.swing.JTextField();
        txtLapTrinh = new javax.swing.JTextField();
        txtTiengAnh = new javax.swing.JTextField();
        txtDoHoa = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtDiemTB = new javax.swing.JTextField();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDanhSachDiem = new javax.swing.JTable();
        btnExit = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        tptop = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTinHoc = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblTiengAnh = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblLapTrinh = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblDoHoa = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Quản lý điểm sinh viên");

        jLabel2.setText("Tìm kiếm");

        lblMaSV.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblMaSV.setText("Mã SV:");

        txtTkMaSV.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnTimKiem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Họ tên SV:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Mã SV:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Tin học:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Tiếng anh:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Lập trình:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Đồ họa:");

        txtHoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoTenActionPerformed(evt);
            }
        });

        txtMaSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSVActionPerformed(evt);
            }
        });

        txtTinHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTinHocActionPerformed(evt);
            }
        });

        txtTiengAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTiengAnhActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Điểm TB:");

        jLabel10.setText("Thông tin SV:");

        jLabel11.setText("Điểm SV:");

        txtDiemTB.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDiemTB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDiemTBMouseClicked(evt);
            }
        });

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel12.setText(" 3 SV có điểm cao nhất môn:");

        jLabel13.setText("Danh sách điểm SV:");

        tblDanhSachDiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDanhSachDiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachDiemMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDanhSachDiem);

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        tblTinHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblTinHoc);

        tptop.addTab("Tin học", jScrollPane3);

        tblTiengAnh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tblTiengAnh);

        tptop.addTab("Tiếng anh", jScrollPane4);

        tblLapTrinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tblLapTrinh);

        tptop.addTab("Lập trình", jScrollPane5);

        tblDoHoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(tblDoHoa);

        tptop.addTab("Đồ học", jScrollPane6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(10, 10, 10)
                                        .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)
                                        .addComponent(jLabel4)
                                        .addGap(31, 31, 31)
                                        .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel11)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(26, 26, 26)
                                        .addComponent(txtTinHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)
                                        .addComponent(jLabel6)
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtDoHoa)
                                            .addComponent(txtTiengAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtDiemTB)
                                            .addComponent(txtLapTrinh, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(50, 50, 50)
                                        .addComponent(jLabel8))
                                    .addComponent(jLabel12)
                                    .addComponent(tptop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(btnNew)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnReset)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblMaSV)
                                    .addGap(4, 4, 4)
                                    .addComponent(txtTkMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(6, 6, 6)
                                    .addComponent(btnTimKiem)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel13)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(358, 358, 358)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel10)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))))
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTinHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTiengAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel7))
                    .addComponent(txtLapTrinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtDoHoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiemTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tptop, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew)
                    .addComponent(btnUpdate)
                    .addComponent(btnExit)
                    .addComponent(btnReset)
                    .addComponent(btnSave)
                    .addComponent(btnDelete))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblMaSV))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(txtTkMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnTimKiem)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        tptop.getAccessibleContext().setAccessibleName("Tin học\nTiếng anh\nLập trình\nĐồ họa");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtHoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoTenActionPerformed

    private void txtMaSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSVActionPerformed

    private void txtTinHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTinHocActionPerformed
        // TODO add your handling code here:
        

    }//GEN-LAST:event_txtTinHocActionPerformed

    private void txtTiengAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTiengAnhActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtTiengAnhActionPerformed

    private void tblDanhSachDiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachDiemMouseClicked
        
    }//GEN-LAST:event_tblDanhSachDiemMouseClicked

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát không?", "Exit", JOptionPane.YES_NO_OPTION) == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void txtDiemTBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDiemTBMouseClicked
        
    }//GEN-LAST:event_txtDiemTBMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
if (JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không?", "Delete", JOptionPane.YES_NO_OPTION) == 0) {
try {
    ConnectionUtils Data = new ConnectionUtils();
    Connection con = Data.getMyConnection();
    String sql = "delete from Diem where maSV=?";
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setString(1, txtMaSV.getText());
    ps.executeUpdate();
    dftbDiem.setRowCount(0);
    LoadData();
    JOptionPane.showMessageDialog(null, "Đã xóa điểm sinh viên");
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Loi " + ex.getMessage());
    }
    }//GEN-LAST:event_btnDeleteActionPerformed
    }
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
try {
    String masv = txtMaSV.getText();
    String hoten = txtHoTen.getText();
    if (txtMaSV.getText().isEmpty() || txtHoTen.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Hãy nhập đầy đủ thông tin");
        return;
    }
    
    String KTDB = "^[!@#$%&’*+/=?{|}~^-]{1,100}$";
    Pattern PT = Pattern.compile(KTDB);
    Matcher HoTen = PT.matcher(txtHoTen.getText());
    Matcher MaSV = PT.matcher(txtMaSV.getText());
    if (HoTen.find()) {
        JOptionPane.showMessageDialog(null, "Họ Tên không chứa kí tự đặc biệt");
        return;
    }
    if (MaSV.find()) {
        JOptionPane.showMessageDialog(null, "Mã sinh viên không chứa kí tự đặc biệt");
        return;
    }
    
    try {
    if (txtMaSV.getText().length() < 5) {
        JOptionPane.showMessageDialog(null, "Mã số sinh viên ít nhất 5 ký tự bắt đầu bằng FPT");
        return;
        }
    if (!txtMaSV.getText().substring(0,3).equals("FPT")) {
        JOptionPane.showMessageDialog(null, "Mã số sinh viên phải bắt đầu bằng FPT");
        return;
    }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null,ex);
        return;
    }
    
    if(txtMaSV.getText().indexOf(" ")>0){
        JOptionPane.showMessageDialog(null, "Mã SV không chứa khoảng trắng");
        return;
    }
    
    if(masv.indexOf(" ")>0){
        JOptionPane.showMessageDialog(null, "Mã SV không chứa khoảng trắng");
        return;
    }
    Pattern Diem = Pattern.compile("^[0-9]+(.[0-9])*$");
    Matcher TinHoc = Diem.matcher(txtTinHoc.getText());
    Matcher TiengAnh = Diem.matcher(txtTiengAnh.getText());
    Matcher LapTrinh = Diem.matcher(txtLapTrinh.getText());
    Matcher DoHoa = Diem.matcher(txtDoHoa.getText());
        if (!TinHoc.matches() || !TiengAnh.matches() || !LapTrinh.matches() || !DoHoa.matches()) {
            JOptionPane.showMessageDialog(null, "Điểm phải là số");
            return;
        }
    float tinhoc = Float.parseFloat(txtTinHoc.getText());
    float tienganh = Float.parseFloat(txtTiengAnh.getText());
    float laptrinh = Float.parseFloat(txtLapTrinh.getText());
    float dohoa = Float.parseFloat(txtDoHoa.getText());
    if (tinhoc <=-1 || tinhoc >=11 || tienganh <=-1 || tienganh >=11 ||
        laptrinh <=-1 || laptrinh >=11 || dohoa <=-1 || dohoa >=11) {
        JOptionPane.showMessageDialog(null, "Điểm từ 0 đếm 10");
        return;
    }
    else {
        try {
            ConnectionUtils Data = new ConnectionUtils();
            Connection con = Data.getMyConnection();
            String sql = "update Diem set MaSV =?, HoTen =?, TinHoc =?, TiengAnh =?, LapTrinh =?, DoHoa=? where MaSV=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, txtMaSV.getText());
            ps.setString(2, txtHoTen.getText());
            ps.setString(3, txtTinHoc.getText());
            ps.setString(4, txtTiengAnh.getText());
            ps.setString(5, txtLapTrinh.getText());
            ps.setString(6, txtDoHoa.getText());
            ps.setString(7, txtMaSV.getText());
            ps.executeUpdate();
            dftbDiem.setRowCount(0);
            LoadData();
            JOptionPane.showMessageDialog(null, "Sửa điểm sinh viên thành công");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Loi " + ex.getMessage());
        }
    }
} catch (Exception e) {
}
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
try {
    String masv = txtMaSV.getText();
    String hoten = txtHoTen.getText();
    if (txtMaSV.getText().isEmpty() || txtHoTen.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Hãy nhập đầy đủ thông tin");
        return;
    }
    
    String KTDB = "^[!@#$%&’*+/=?{|}~^-]{1,100}$";
    Pattern PT = Pattern.compile(KTDB);
    Matcher HoTen = PT.matcher(txtHoTen.getText());
    Matcher MaSV = PT.matcher(txtMaSV.getText());
    if (HoTen.find()) {
        JOptionPane.showMessageDialog(null, "Họ Tên không chứa kí tự đặc biệt");
        return;
    }
    if (MaSV.find()) {
        JOptionPane.showMessageDialog(null, "Mã sinh viên không chứa kí tự đặc biệt");
        return;
    }
    
    try {
    if (txtMaSV.getText().length() < 5) {
        JOptionPane.showMessageDialog(null, "Mã số sinh viên ít nhất 5 ký tự bắt đầu bằng FPT");
        return;
        }
    if (!txtMaSV.getText().substring(0,3).equals("FPT")) {
        JOptionPane.showMessageDialog(null, "Mã số sinh viên phải bắt đầu bằng FPT");
        return;
    }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null,ex);
        return;
    }
    
    if(txtMaSV.getText().indexOf(" ")>0){
        JOptionPane.showMessageDialog(null, "Mã SV không chứa khoảng trắng");
        return;
    }
    
    if(masv.indexOf(" ")>0){
        JOptionPane.showMessageDialog(null, "Mã SV không chứa khoảng trắng");
        return;
    }
    Pattern Diem = Pattern.compile("^[0-9]+(.[0-9])*$");
    Matcher TinHoc = Diem.matcher(txtTinHoc.getText());
    Matcher TiengAnh = Diem.matcher(txtTiengAnh.getText());
    Matcher LapTrinh = Diem.matcher(txtLapTrinh.getText());
    Matcher DoHoa = Diem.matcher(txtDoHoa.getText());
        if (!TinHoc.matches() || !TiengAnh.matches() || !LapTrinh.matches() || !DoHoa.matches()) {
            JOptionPane.showMessageDialog(null, "Điểm phải là số");
            return;
        }
    float tinhoc = Float.parseFloat(txtTinHoc.getText());
    float tienganh = Float.parseFloat(txtTiengAnh.getText());
    float laptrinh = Float.parseFloat(txtLapTrinh.getText());
    float dohoa = Float.parseFloat(txtDoHoa.getText());
    if (tinhoc <=-1 || tinhoc >=11 || tienganh <=-1 || tienganh >=11 ||
        laptrinh <=-1 || laptrinh >=11 || dohoa <=-1 || dohoa >=11) {
        JOptionPane.showMessageDialog(null, "Điểm từ 0 đếm 10");
        return;
    }
    else {
        try {
        ConnectionUtils Data = new ConnectionUtils();
        Connection con = Data.getMyConnection();
        String sql = "Insert into Diem values (?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, txtMaSV.getText());
        ps.setString(2, txtHoTen.getText());
        ps.setString(3, txtTinHoc.getText());
        ps.setString(4, txtTiengAnh.getText());
        ps.setString(5, txtLapTrinh.getText());
        ps.setString(6, txtDoHoa.getText());
        ps.executeUpdate();
        dftbDiem.setRowCount(0);// tranh khi add vao no add lai tu dau
        LoadData();
        JOptionPane.showMessageDialog(null, "Thêm điểm sinh viên thành công");
        // boolean kt = rtbNam.isSelected() ? true : false;
        }catch (Exception ex) {
    JOptionPane.showMessageDialog(null, "Lỗi: "+ex);
    }
}
}catch (Exception ex) {
}
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        txtHoTen.setText("");
        txtMaSV.setText("");
        txtTinHoc.setText("");
        txtTiengAnh.setText("");
        txtLapTrinh.setText("");
        txtDoHoa.setText("");
        txtDiemTB.setText("");
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
    dftbDiem.setRowCount(0);
    LoadData();
    dftbTinHoc.setRowCount(0);
    LoadTinHoc();
    dftbTiengAnh.setRowCount(0);
    LoadTiengAnh();
    dftbLapTrinh.setRowCount(0);
    LoadLapTrinh();
    dftbDoHoa.setRowCount(0);
    LoadDoHoa();
    }//GEN-LAST:event_btnResetActionPerformed
    
    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
Vector col=new Vector();
col.addElement("MaSV");
col.addElement("HoTen");
col.addElement("TinHoc");
col.addElement("TiengAnh");
col.addElement("LapTrinh");
col.addElement("DoHoa");
PreparedStatement prtm;
ResultSet rs;
ConnectionUtils Data = new ConnectionUtils();
try {
    Connection con = Data.getMyConnection();
    //String sql = "select * from Diem where MaSV=?";
    //prtm=con.prepareStatement(sql);
    //prtm.setString(1, txtTkMaSV.getText());
    //rs=prtm.executeQuery();
    String sql = "select * from Diem where MaSV like '%" + txtTkMaSV.getText() + "%'";
    Statement st = con.createStatement();
    rs = st.executeQuery(sql);
    Vector Data2 = new Vector();
    int no = 0;
    while(rs.next())
    {
        Vector sinhvien=new Vector();
        sinhvien.addElement(rs.getString("MaSV"));
        sinhvien.addElement(rs.getString("HoTen"));
        sinhvien.addElement(rs.getString("TinHoc"));
        sinhvien.addElement(rs.getString("TiengAnh"));
        sinhvien.addElement(rs.getString("LapTrinh"));
        sinhvien.addElement(rs.getString("DoHoa"));
        Data2.addElement(sinhvien);
    }
    tblDanhSachDiem.setModel(new DefaultTableModel(Data2,col));
    tblDanhSachDiem.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
    @Override
    public void valueChanged(ListSelectionEvent e) {
    if (tblDanhSachDiem.getSelectedRow() >= 0) {
        txtMaSV.setText(tblDanhSachDiem.getValueAt(tblDanhSachDiem.getSelectedRow(), 0).toString());
        txtHoTen.setText(tblDanhSachDiem.getValueAt(tblDanhSachDiem.getSelectedRow(), 1).toString());
        txtTinHoc.setText(tblDanhSachDiem.getValueAt(tblDanhSachDiem.getSelectedRow(), 2).toString());
        txtTiengAnh.setText(tblDanhSachDiem.getValueAt(tblDanhSachDiem.getSelectedRow(), 3).toString());
        txtLapTrinh.setText(tblDanhSachDiem.getValueAt(tblDanhSachDiem.getSelectedRow(), 4).toString());
        txtDoHoa.setText(tblDanhSachDiem.getValueAt(tblDanhSachDiem.getSelectedRow(), 5).toString());
        txtDiemTB.setText("");
        float a = Float.parseFloat(txtTiengAnh.getText());
        float b = Float.parseFloat(txtDoHoa.getText());
        float c = Float.parseFloat(txtTinHoc.getText());
        float d = Float.parseFloat(txtLapTrinh.getText());
        float tb = (a+b+c+d)/4;
        txtDiemTB.setText(tb + "");
            }
        }
    });
    } catch (Exception ex) {
            System.out.println("loi: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Qldiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Qldiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Qldiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Qldiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Qldiem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblMaSV;
    private javax.swing.JTable tblDanhSachDiem;
    private javax.swing.JTable tblDoHoa;
    private javax.swing.JTable tblLapTrinh;
    private javax.swing.JTable tblTiengAnh;
    private javax.swing.JTable tblTinHoc;
    private javax.swing.JTabbedPane tptop;
    private javax.swing.JTextField txtDiemTB;
    private javax.swing.JTextField txtDoHoa;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtLapTrinh;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtTiengAnh;
    private javax.swing.JTextField txtTinHoc;
    private javax.swing.JTextField txtTkMaSV;
    // End of variables declaration//GEN-END:variables
}
