
package Vistas;
import Controlador.*;
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author camil
 */
public class UserMenu extends javax.swing.JFrame {

    Conexion conexion = new Conexion();
    Connection connection;
    Statement st;
    ResultSet rs;
    
    DefaultTableModel contenidoTablaEmpleados; 
    DefaultTableModel contenidoTablaDepartamento;
    ComboBoxModel EnumDepartamentos;
    ComboBoxModel EnumCalles;
    ComboBoxModel EnumZonas;
    
    
    
    public UserMenu() {
        EnumDepartamentos = new DefaultComboBoxModel(EnumDepartamento.values());
        EnumCalles = new DefaultComboBoxModel(EnumTipoCalle.values());
        EnumZonas = new DefaultComboBoxModel(EnumZona.values());
        initComponents();
        setLocationRelativeTo(null);
        listarEmpleados();
        listarDepartamentos();
    }
    
    private void listarDepartamentos(){
        String query = "SELECT DISTINCT nombreDepartamento, zona FROM `direccion`;"; 
        try{
           connection = conexion.getConnection();
           st = connection.createStatement();
           rs = st.executeQuery(query);
           Object[]departamento = new Object[2];
           contenidoTablaDepartamento = (DefaultTableModel) tblDepartamentos.getModel();
           while(rs.next()){
               departamento[0] = rs.getString("nombreDepartamento");
               departamento[1] = rs.getString("zona");
               System.out.println("departamento: "+ departamento[0]+ "Zona: "+ departamento[1] );
               contenidoTablaDepartamento.addRow(departamento);
               tblDepartamentos.setModel(contenidoTablaDepartamento);
           }
        }catch(SQLException e){
            System.out.println("Error");
        }
    }
    private void borrarDatosTablaDepartamentos(){
       for (int i = 0; i < tblDepartamentos.getRowCount(); i++) {
           contenidoTablaDepartamento.removeRow(i);
           i -= 1;
       } 
       }
       

   private void listarEmpleados(){
       String filtroBusqueda = txtSearch.getText();
       if(filtroBusqueda.isEmpty()){
       String queryConsulta = "SELECT * FROM Empleado";
       try{
           connection = conexion.getConnection();
           st = connection.createStatement();
           rs = st.executeQuery(queryConsulta);
           
           Object[] empleados = new Object[6];
           contenidoTablaEmpleados = (DefaultTableModel)tblEmpleados.getModel();
           while(rs.next()){
               empleados[0] = rs.getInt("idEmp");
               empleados[1] = rs.getString("nombreEmp");
               empleados[2] = rs.getString("apellidos");
               empleados[3] = rs.getString("tipoDocumento");
               empleados[4] = rs.getString("documento");
               empleados[5] = rs.getString("correo");
               
               contenidoTablaEmpleados.addRow(empleados);
               System.out.println("id: "+ empleados[0]+ "Nombre: "+ empleados[1] + "tipo doc: "+ empleados[2]+ "Documento: "+ empleados[3]+ "email" + empleados[4] );
               tblEmpleados.setModel(contenidoTablaEmpleados);
               
           }
       } catch(SQLException e){
           System.out.println("Error");    
       }
       
           
       }else{
           String queryConsulta = "SELECT * FROM Empleado WHERE nombreEmp LIKE '%"+filtroBusqueda+"%' or apellidos LIKE '%"+filtroBusqueda+"%'";
           System.out.println(queryConsulta);
           try{
           connection = conexion.getConnection();
           st = connection.createStatement();
           rs = st.executeQuery(queryConsulta);
           
           Object[] empleados = new Object[6];
           contenidoTablaEmpleados = (DefaultTableModel)tblEmpleados.getModel();
           while(rs.next()){
               empleados[0] = rs.getInt("idEmp");
               empleados[1] = rs.getString("nombreEmp");
               empleados[2] = rs.getString("apellidos");
               empleados[3] = rs.getString("tipoDocumento");
               empleados[4] = rs.getString("documento");
               empleados[5] = rs.getString("correo");
               
               contenidoTablaEmpleados.addRow(empleados);
               System.out.println("id: "+ empleados[0]+ "Nombre: "+ empleados[1] + "tipo doc: "+ empleados[2]+ "Documento: "+ empleados[3]+ "email" + empleados[4] );
               tblEmpleados.setModel(contenidoTablaEmpleados);
               
           }
       } catch(SQLException e){
           System.out.println("Error");{
           
       }
       }
   }
   }
   private void borrarDatosTabla(){
       for (int i = 0; i < tblEmpleados.getRowCount(); i++) {
           contenidoTablaEmpleados.removeRow(i);
           i -= 1;
           
       }
   }
    
   
       
  
   
   
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        btnAddUser = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtSucursal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbZona = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbCalle = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNumero1 = new javax.swing.JTextField();
        txtNumero2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnListar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        cbDepartamento = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtNumero3 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDepartamentos = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocationByPlatform(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(35, 124, 208));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1142, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 499, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Home", jPanel1);

        jPanel3.setBackground(new java.awt.Color(102, 153, 255));
        jPanel3.setFont(new java.awt.Font("Calibri", 1, 11)); // NOI18N

        tblEmpleados.setAutoCreateRowSorter(true);
        tblEmpleados.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellido", "Tipo de documento", "Documento", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmpleados.setGridColor(new java.awt.Color(255, 255, 255));
        tblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmpleados);

        btnAddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/avatar.png"))); // NOI18N
        btnAddUser.setText("Crear Empleado");
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("INFORMACIÓN EMPLEADOS");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/showUser.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NOMBRE");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(102, 102, 102)
                .addComponent(btnAddUser)
                .addGap(90, 90, 90))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 812, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jLabel3)
                        .addGap(27, 27, 27)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jButton1)))
                .addContainerGap(265, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddUser)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );

        jTabbedPane1.addTab("Empleados", jPanel3);

        jPanel4.setBackground(new java.awt.Color(64, 225, 196));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo.png"))); // NOI18N

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setText("Sucursal:");

        jLabel6.setText("Zona:");

        cbZona.setModel(EnumZonas);
        cbZona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbZonaActionPerformed(evt);
            }
        });

        jLabel7.setText("Tipo Calle:");

        cbCalle.setModel(EnumCalles);

        jLabel8.setText("Departamento:");

        jLabel9.setText("Numero:");

        txtNumero2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumero2ActionPerformed(evt);
            }
        });

        jLabel10.setText("-");

        btnListar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/showUser.png"))); // NOI18N
        btnListar.setText("Ver Sucursales");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/confirmIcon.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        cbDepartamento.setModel(EnumDepartamentos);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Dirección:");

        txtNumero3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumero3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(132, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbZona, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtSucursal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(102, 102, 102))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addGap(412, 412, 412))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtNumero2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNumero3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap()))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(txtSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)))
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtNumero2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtNumero3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        tblDepartamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Departamento", "Zona"
            }
        ));
        jScrollPane2.setViewportView(tblDepartamentos);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sucursales", jPanel4);

        jPanel5.setBackground(new java.awt.Color(51, 204, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1142, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 499, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Productos", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        AddUserForm addUserF = new AddUserForm(this, rootPaneCheckingEnabled);
        addUserF.setVisible(true);
        borrarDatosTabla();
        listarEmpleados();

    }//GEN-LAST:event_btnAddUserActionPerformed

    private void tblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadosMouseClicked
        int row = tblEmpleados.getSelectedRow();
        System.out.println("FIla seleccionada N°: " + row);
        //Validation: User dont select any employ
        if(row < 0){
            JOptionPane.showMessageDialog(this, "No ha seleccionado ningún empleado","",JOptionPane.WARNING_MESSAGE);
            
        }else{
            //debemos recorrer 6 atributos por cada fila
            int idEmp = Integer.parseInt(tblEmpleados.getValueAt(row, 0).toString());
            String nombreEmp = tblEmpleados.getValueAt(row, 1).toString();
            String apellidos = tblEmpleados.getValueAt(row, 2).toString();
            String tipoDocumento = tblEmpleados.getValueAt(row, 3).toString();
            String documento = tblEmpleados.getValueAt(row, 4).toString();
            String correo = tblEmpleados.getValueAt(row, 5).toString();
            
            System.out.println("idempl: "+ idEmp + ", nombreEmp:"+ nombreEmp + ", apellido" + apellidos + 
                    ", TipoDocumento:" + tipoDocumento + ", documento"+ documento + ", correo: "+correo);
            ShowUserForm showUserForm = new ShowUserForm(this, true);
            showUserForm.recibeDatos(idEmp, nombreEmp, apellidos, tipoDocumento, documento, correo);
            showUserForm.setVisible(true);
            //para que la tabla actualice se debe borrar todos los datos y volverlos a cargar
            borrarDatosTabla();
            listarEmpleados();
        }
    }//GEN-LAST:event_tblEmpleadosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        borrarDatosTabla();
        listarEmpleados();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnListarActionPerformed

    private void cbZonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbZonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbZonaActionPerformed

    private void txtNumero2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumero2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumero2ActionPerformed

    private void txtNumero3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumero3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumero3ActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String nombreSucursal = txtSucursal.getText();
        int departamentoOption = (int) cbDepartamento.getSelectedIndex();
        int zonaOption = cbZona.getSelectedIndex();
        int tipoCalleOption = cbCalle.getSelectedIndex();
        String numero1 =txtNumero1.getText();
        String numero2 =txtNumero2.getText();
        String numero3 =txtNumero3.getText();
                
        String zonaOptionT = "";
        String tipoCalleOptionT="";
        String tipoDepartamentoT = "";
        if(zonaOption == 0){
            zonaOptionT = "Rural";                      
        }else
            zonaOptionT = "Urbana";
        
        if(tipoCalleOption == 0 ){
            tipoCalleOptionT = "Avenida";
        }else if(tipoCalleOption == 1){
            tipoCalleOptionT = "Calle";
        }else if(tipoCalleOption == 2){
            tipoCalleOptionT = "Carrera";
        }else if(tipoCalleOption == 3){
            tipoCalleOptionT = "Cicunvalar";
        }else if(tipoCalleOption == 4){
            tipoCalleOptionT = "Transversal";
        }else if(tipoCalleOption == 5){
            tipoCalleOptionT = "Diagonal";
        }else if(tipoCalleOption == 6){
            tipoCalleOptionT = "Manzana";
        }else{
            tipoCalleOptionT = "otro";
        }
        
        if(departamentoOption == 0){
            tipoDepartamentoT ="Amazonas";
        }else if(departamentoOption == 1){
            tipoDepartamentoT ="Antioquia";
        }else if(departamentoOption == 2){
            tipoDepartamentoT = "Arauca";
        }else if(departamentoOption == 3){
            tipoDepartamentoT = "Atlántico";
        }else if(departamentoOption == 4){
            tipoDepartamentoT = "Bogotá";
        }else if(departamentoOption == 5){
            tipoDepartamentoT = "Bolívar";
        }else if(departamentoOption == 6){
            tipoDepartamentoT = "Boyacá";
        }else if(departamentoOption == 7){
            tipoDepartamentoT ="Caldas";
        }else if(departamentoOption == 8){
            tipoDepartamentoT ="Caquetá";
        }else if(departamentoOption == 9){
            tipoDepartamentoT ="Casanare";
        }else if(departamentoOption == 10){
            tipoDepartamentoT ="Cauca";
        }else if(departamentoOption == 11){
            tipoDepartamentoT ="Cesar";
        }else if(departamentoOption == 12){
            tipoDepartamentoT ="Chocó";
        }else if(departamentoOption == 13){
            tipoDepartamentoT ="Córdoba";
        }else if(departamentoOption == 14){
            tipoDepartamentoT ="Cundinamarca";
        }else if(departamentoOption == 15){
            tipoDepartamentoT ="Guainía";
        }else if(departamentoOption == 16){
            tipoDepartamentoT ="Guaviare";
        }else if(departamentoOption == 17){
            tipoDepartamentoT ="Huila";
        }else if(departamentoOption == 18){
            tipoDepartamentoT ="LaGuajira";
        }else if(departamentoOption == 19){
            tipoDepartamentoT ="Magdalena";
        }else if(departamentoOption == 20){
            tipoDepartamentoT ="Meta";
        }else if(departamentoOption == 21){
            tipoDepartamentoT ="Nariño";
        }else if(departamentoOption == 22){
            tipoDepartamentoT ="NortedeSantander";
        }else if(departamentoOption == 23){
            tipoDepartamentoT ="Putumayo";
        }else if(departamentoOption == 24){
            tipoDepartamentoT ="Quindío";
        }else if(departamentoOption == 25){
            tipoDepartamentoT ="Risaralda";
        }else if(departamentoOption == 26){
            tipoDepartamentoT ="SanAndrésyProvidencia";
        }else if(departamentoOption == 27){
            tipoDepartamentoT ="Santander";
        }else if(departamentoOption == 28){
            tipoDepartamentoT ="Sucre";
        }else if(departamentoOption == 29){
            tipoDepartamentoT ="Tolima";
        }else if(departamentoOption == 30){
            tipoDepartamentoT ="ValledelCauca";
        }else if(departamentoOption == 31){
            tipoDepartamentoT ="Vaupés";
        }else{
            tipoDepartamentoT ="Vichada";
        }


        
        System.out.println("Sucursal: " +nombreSucursal + "Departamento: "+ tipoDepartamentoT+ "Zona: " + zonaOptionT+"Tipocalle: "+tipoCalleOptionT+ "numero 1.: "+ numero1+"numero 2: "+numero2+"numero 3: "+numero3 );
        
        String queryDireccion = "INSERT INTO `direccion`( `zona`, `tipoCalle`, `numero1`,  `numero2`, `numero3`,nombreDepartamento) VALUES ('"+zonaOptionT+"','"+tipoCalleOptionT +"','"+numero1+"','"+numero2+"','"+numero3+"','"+tipoDepartamentoT+"')";
        System.out.println(queryDireccion);
       
        try{
            connection = conexion.getConnection();
            st= connection.createStatement();
            st.executeUpdate(queryDireccion);
            JOptionPane.showMessageDialog(this, "Dirección creada");
            borrarDatosTablaDepartamentos();
            listarDepartamentos();
                        
        }catch (SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "No se pudo crear la dirección", "", JOptionPane.ERROR_MESSAGE
            );
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

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
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnListar;
    private javax.swing.JComboBox<String> cbCalle;
    private javax.swing.JComboBox<String> cbDepartamento;
    private javax.swing.JComboBox<String> cbZona;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblDepartamentos;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtNumero1;
    private javax.swing.JTextField txtNumero2;
    private javax.swing.JTextField txtNumero3;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSucursal;
    // End of variables declaration//GEN-END:variables
}
