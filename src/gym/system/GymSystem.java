package gym.system;

import javafx.scene.image.Image;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class GymSystem extends Application {
    
    public Connection conn = null;
    public PreparedStatement pst, pst2 = null;
    public ResultSet res = null;
    public Stage window;
    public Scene login, managerProfile, profile;
    public String idd, role, name, address, priv, type,iddd,pass,passdb;
    public int  hrs, days, rate, disf, dis, exp, fixes, check, age;
    public Text profileheader;
    public TableView customertable;
    public ObservableList<Customer> customerdata;
    public Coach thiss;
    public boolean passcheck;
    public Text txt2;
    public PasswordField passtxt;
    public TextField idtxt;
//    public List<Customer> CustomerList;
    public Customer C;
    public FilteredList<Customer> filter;
        
    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
//      Login Scene
        LoginScene(window);
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
//    Manager Scene 
    public void ManagerScene(Stage primaryStage) {
        
//        Creating the layout
        Text namee = new Text(name);
        profileheader = new Text("Welcome ");
        namee.setId("profileName");
        
        Button btn1 = new Button();
        btn1.setText("Add");
        btn1.setId("addbtn");

        Button btn2 = new Button();
        btn2.setText("Clear");
        btn2.setId("clearbtn");

        Text Title = new Text("Add New Customer");
        Title.setId("addCustomer");
        profileheader.setId("Welcome");

        TextField idtxtc = new TextField();
        idtxtc.setPromptText("ID");
        TextField fnametxtc = new TextField();
        fnametxtc.setPromptText("First Name");
        TextField lnametxtc = new TextField();
        lnametxtc.setPromptText("Last Name");
        TextField agetxtc = new TextField();
        agetxtc.setPromptText("Age");
        TextField nidtxtc = new TextField();
        nidtxtc.setPromptText("Natiional ID");
        TextField phonetxtc = new TextField();
        phonetxtc.setPromptText("Phone Number");
        TextField invtxtc = new TextField();
        invtxtc.setPromptText("Invitations");
        TextField subsntxtc = new TextField();
        subsntxtc.setPromptText("Subscribtion");
        TextField drinkstxtc = new TextField();
        drinkstxtc.setPromptText("Free Drinks");
        TextField viptxtc = new TextField();
        viptxtc.setPromptText("VIP LOUNGE ENTRY");


        GridPane g1 = new GridPane();
        g1.add(Title, 0, 0, 2, 1);
        g1.add(idtxtc, 0, 1, 2, 1);
        g1.add(fnametxtc, 0, 2, 2, 1);
        g1.add(lnametxtc, 0, 3, 2, 1);
        g1.add(agetxtc, 0, 4, 2, 1);
        g1.add(nidtxtc, 0, 5, 2, 1);
        g1.add(phonetxtc, 0, 6, 2, 1);
        g1.add(invtxtc,0, 7, 2, 1);
        g1.add(subsntxtc, 0, 8, 2, 1);
        g1.add(drinkstxtc, 0, 9, 2, 1);
        g1.add(viptxtc, 0, 10, 2, 1);
        g1.add(profileheader, 0,12, 2,1);
        g1.add(namee, 0,12, 2, 1);


        g1.add(btn1, 0, 11);
        g1.add(btn2, 1, 11);

        g1.setVgap(10);
        g1.setHgap(10);
        g1.setAlignment(Pos.CENTER);
        g1.setHalignment(Title, HPos.CENTER);
        g1.setHalignment(profileheader, HPos.LEFT);
        g1.setValignment(profileheader, VPos.BOTTOM);
        g1.setHalignment(idtxtc, HPos.CENTER);
        g1.setHalignment(fnametxtc, HPos.CENTER);
        g1.setHalignment(lnametxtc, HPos.CENTER);
        g1.setHalignment(agetxtc, HPos.CENTER);
        g1.setHalignment(nidtxtc, HPos.CENTER);
        g1.setHalignment(phonetxtc, HPos.CENTER);
        g1.setHalignment(invtxtc, HPos.CENTER);
        g1.setHalignment(subsntxtc, HPos.CENTER);
        g1.setHalignment(drinkstxtc, HPos.CENTER);
        g1.setHalignment(viptxtc, HPos.CENTER);
        g1.setHalignment(namee, HPos.RIGHT);
        g1.setValignment(namee, VPos.BOTTOM);
        g1.setPadding(new Insets(20));

        customertable = new TableView();
        customertable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        customertable.setPlaceholder(new Label("No rows to display"));

        TableColumn<Integer, Customer> c1 = new TableColumn<>("ID");
        c1.setCellValueFactory(new PropertyValueFactory<>("ID"));

        TableColumn<String, Customer> c2 = new TableColumn<>("First Name");
        c2.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<String, Customer> c3 = new TableColumn<>("Last Name");
        c3.setCellValueFactory(new PropertyValueFactory<>("name2"));

        TableColumn<Integer, Customer> c4 = new TableColumn<>("Age");
        c4.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<Integer, Customer> c5 = new TableColumn<>("National ID");
        c5.setCellValueFactory(new PropertyValueFactory<>("NationalID"));

        TableColumn<Integer, Customer> c6 = new TableColumn<>("Phone");
        c6.setCellValueFactory(new PropertyValueFactory<>("PhoneNum"));

        TableColumn<Integer, Customer> c7 = new TableColumn<>("Invitations");
        c7.setCellValueFactory(new PropertyValueFactory<>("Invitations"));

        TableColumn<Integer, Customer> c8 = new TableColumn<>("Subscribtion");
        c8.setCellValueFactory(new PropertyValueFactory<>("Subscription"));

        TableColumn<Integer, Customer> c9 = new TableColumn<>("Free Drinks");
        c9.setCellValueFactory(new PropertyValueFactory<>("FreeDrinks"));

        TableColumn<String, Customer> c10 = new TableColumn<>("VIP");
        c10.setCellValueFactory(new PropertyValueFactory<>("VipLoungeEntry"));

        customertable.getColumns().addAll(c1, c2, c3, c4, c5,c6,c7,c8,c9, c10);
        VBox v = new VBox();
        v.getChildren().addAll(customertable);
        v.setPadding(new Insets(20));
//         Populating the table with customoers from the database
        try {
            show();
        } catch (SQLException a) {
            System.err.println(a.toString());
        }
//         addinig customers to the DB
        btn1.setOnAction((ActionEvent event) -> {

            conn = dbConn.DBConnection();
            String sql1 = "Insert into CUSTOMERS (ID,FIRSTNAME,LASTNAME,AGE,NATIONALID,PHONENUM,INVITATIONS,SUBSCRIPTION,FREEDRINKS,VIPLOUNGEENTRY) Values(?,?,?,?,?,?,?,?,?,?)";

            try {
                pst = conn.prepareStatement(sql1);
                pst.setString(1, idtxtc.getText());
                pst.setString(2, fnametxtc.getText());
                pst.setString(3, lnametxtc.getText());
                pst.setString(4, agetxtc.getText());
                pst.setString(5, nidtxtc.getText());
                pst.setString(6, phonetxtc.getText());
                pst.setString(7, invtxtc.getText());
                pst.setString(8, subsntxtc.getText());
                pst.setString(9, drinkstxtc.getText());
                pst.setString(10, viptxtc.getText());

                int i = pst.executeUpdate();
                if (i == 1) {
                    System.out.println("Data is inserted");
                }
                pst.close();
                conn.close();
                show();
            } catch (Exception ex) {
                System.out.println(ex.toString());
                System.out.println("no1");

            }
            set();
        });
//        Clear button
        btn2.setOnAction((ActionEvent event) -> {

            idtxtc.setText("");
            fnametxtc.setText("");
            lnametxtc.setText("");
            agetxtc.setText("");
            nidtxtc.setText("");
            phonetxtc.setText("");
            subsntxtc.setText("");
            drinkstxtc.setText("");
            viptxtc.setText("");
            invtxtc.setText("");
            
        });

        Button btn3 = new Button();
        btn3.setText("Logout");
        btn3.setId("logoutbtn");
//        Logout button 
        btn3.setOnAction((ActionEvent event) -> {
            passtxt.setText("");
            txt2.setText("");
            passcheck = false;
            primaryStage.setTitle("Login");
            primaryStage.setScene(login);

        });
//        Search
        Label search= new Label("Search");
        TextField srch= new TextField();
        srch.setPrefWidth(240);
        
        //Wrap the ObservableList in a FilteredList (initially display all data).
        filter = new FilteredList<>(customerdata, e-> true);
      
        //Will be notified whenever the value of the ObservableValue changes.   
        srch.textProperty().addListener((ObsValue, oldValue, newValue)->{
                filter.setPredicate(cus ->{
                    // If filter text is empty, display all students.
                    if(newValue == null || newValue.isEmpty()){
                        set();
                        try {
                            show();
                        } catch (SQLException ex) {
                            Logger.getLogger(GymSystem.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        return true;
                    }
                    String s= newValue.toLowerCase();
                    if(Integer.toString(cus.getID()).contains(newValue)){
                        return true;
                    }
                        
                    else if(cus.getName().toLowerCase().contains(s)){
                        return true;
                    }
                        
                    else if(cus.getName2().toLowerCase().contains(s)){
                        return true;
                    }
                        
                    else if(Integer.toString(cus.getPhoneNum()).toLowerCase().contains(s)){
                        return true;
                    }
                        
                    else if(Double.toString(cus.getNationalID()).contains(newValue)){
                        return true;
                    }
                        
                    return false;    
                });
                //Wrap the FilteredList in a SortedList.
            SortedList <Customer> sort= new SortedList<>(filter);
            sort.comparatorProperty().bind(customertable.comparatorProperty());
            customertable.setItems(sort);
        });
        
//        Delete
        Label deletelabel = new Label("Delete Customer");
        Label deleteid = new Label("ID");
        TextField deleteidtxt = new TextField();
        Button deletebtn = new Button("Delete");
        deletebtn.setId("deletebtn");

        GridPane deletegrid = new GridPane();

        deletegrid.add(deletelabel, 0, 0, 2, 1);
        deletegrid.add(deleteid, 0, 1);
        deletegrid.add(deleteidtxt, 1, 1);
        deletegrid.add(deletebtn, 0, 3, 2, 1);

        deletegrid.setVgap(10);
        deletegrid.setHgap(10);
        deletegrid.setPadding(new Insets(20));
        
        
        deletebtn.setOnAction(e -> {
            String id = deleteidtxt.getText();
            String sql = "Delete from CUSTOMERS where id = ?";

            conn = dbConn.DBConnection();
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, id);
                pst.executeUpdate();
                pst.close();
                conn.close();
                show();
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
            set();

        });
 
//        Update Info
        Label updatelabel = new Label("Update Subscription");
        Label updateid = new Label("ID");
        TextField updateidtxt = new TextField();
        Label sublabel = new Label("New Subscription");
        TextField subtxt = new TextField();
        Button updatebtn = new Button("Update");
        updatebtn.setId("updatebtn");

        GridPane updategrid = new GridPane();

        updategrid.add(updatelabel, 0, 0, 2, 1);
        updategrid.add(updateid, 0, 1);
        updategrid.add(updateidtxt, 1, 1);
        updategrid.add(sublabel, 0, 2);
        updategrid.add(subtxt, 1, 2);
        updategrid.add(updatebtn, 0, 4, 2, 1);

        updategrid.setVgap(10);
        updategrid.setHgap(10);
        updategrid.setPadding(new Insets(20));
        
        updatebtn.setOnAction((ActionEvent event) -> {

            String id = updateidtxt.getText();
            String m = subtxt.getText();

            String sql = "Update CUSTOMERS set SUBSCRIPTION = ? where id = ?";
            conn = dbConn.DBConnection();
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, m);
                pst.setString(2, id);
                pst.executeUpdate();
                pst.close();
                conn.close();
                show();
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
            set();

        });
        
        VBox srsh= new VBox(search, srch, updategrid, deletegrid);


        FlowPane table = new FlowPane(g1,v,srsh);
        table.setAlignment(Pos.CENTER);
        VBox managerLayout = new VBox(table, btn3);
        managerLayout.getStylesheets().add("File:src/gym/system/css/ManagerCSS.css");
        managerLayout.setAlignment(Pos.CENTER);

        managerProfile = new Scene(managerLayout, 1500, 720);
        primaryStage.setScene(managerProfile);
        primaryStage.setTitle("Manager");
    }
    
//    Employee Scene
    public void EmployeeScene(Stage primaryStage) {
        
//        Getting employee info from db
        String sq3 = "SELECT ROLE, FIRSTNAME, LASTNAME, WORKINGHRS, WORKINGDAYS, RATE, DISCOUNTF, DISCOUNT, ADDRESS, PRIVATE, TYPE, EXPERIENCE, AMOUNTOFFIXES, AGE FROM EMPLOYEES WHERE id ="+idd;

        conn = dbConn.DBConnection();
//        Storing info into variables
        try {
            pst = conn.prepareStatement(sq3);
            pst.executeUpdate();
            Statement conn3 = conn.createStatement();
            ResultSet rs2 = conn3.executeQuery(sq3);
            while ( rs2.next() ) {
                role = rs2.getString("ROLE");
                name = rs2.getString("FIRSTNAME")+" "+rs2.getString("LASTNAME");
                hrs = rs2.getInt("WORKINGHRS");
                days = rs2.getInt("WORKINGDAYS");
                rate= rs2.getInt("RATE");
                disf = rs2.getInt("DISCOUNTF");
                dis = rs2.getInt("DISCOUNT");
                address = rs2.getString("ADDRESS");
                priv = rs2.getString("PRIVATE");
                type = rs2.getString("TYPE");
                exp = rs2.getInt("EXPERIENCE");
                fixes = rs2.getInt("AMOUNTOFFIXES");
                age = rs2.getInt("AGE");

                thiss = new Coach(name, age , Integer.parseInt(idd), Integer.parseInt(idd), Integer.parseInt(idd), address , hrs , priv);
            }
            pst.close();
            conn.close();
            rs2.close();
            conn3.close();
        } catch (Exception ex) {
            System.out.println(ex.toString());
            System.out.println("lol");
        }

//        Creating Profile Layout
        profileheader = new Text("Welcome "+ name);
        profileheader.setId("head");

        Label idlabel = new Label("ID");
        idlabel.getStyleClass().add("labels");
        Label idres = new Label(String.valueOf(thiss.ID));
        Label agelabel = new Label("Age");
        agelabel.getStyleClass().add("labels");
        Label ageres = new Label(String.valueOf(thiss.Age));
        Label rolelabel = new Label("ROLE");
        rolelabel.getStyleClass().add("labels");
        Label roleres = new Label(role);
        Label hrslabel = new Label("WORKINGHRS");
        hrslabel.getStyleClass().add("labels");
        Label hrsres = new Label(String.valueOf(thiss.WorkingHrs));
        Label dayslabel = new Label("WORKINGDAYS");
        dayslabel.getStyleClass().add("labels");
        Label daysres = new Label(String.valueOf(thiss.getWorkingDays()));
        Label ratelabel = new Label("RATE");
        ratelabel.getStyleClass().add("labels");
        Label rateres = new Label(String.valueOf(thiss.getRate()));
        Label discflabel = new Label("DISCOUNTF");
        discflabel.getStyleClass().add("labels");
        Label discfres = new Label(String.valueOf(thiss.getDiscountF()));
        Label dusclabel = new Label("DISCOUNT");
        dusclabel.getStyleClass().add("labels");
        Label discres = new Label(String.valueOf(thiss.getDiscount()));
        Label addresslabel = new Label("ADDRESS");
        addresslabel.getStyleClass().add("labels");
        Label addressres = new Label(thiss.getAddress());
        Label privlabel = new Label("PRIVATE");
        privlabel.getStyleClass().add("labels");
        Label privres = new Label(thiss.getPrivate());
        Label typelabel = new Label("TYPE");
        typelabel.getStyleClass().add("labels");
        Label typeres = new Label(thiss.Type);
        Label fixeslabel = new Label("AMOUNTOFFIXES");
        fixeslabel.getStyleClass().add("labels");
        Label fixesres = new Label(String.valueOf(fixes));
        Label salarylabel = new Label("Salary");
        salarylabel.getStyleClass().add("labels");
        Label salaryres = new Label(String.valueOf(thiss.SalaryChk()));

        GridPane profgrid = new GridPane();

        profgrid.add(idlabel, 0, 0);
        profgrid.add(idres, 1, 0);
        profgrid.add(agelabel, 0, 1);
        profgrid.add(ageres, 1, 1);
        profgrid.add(rolelabel, 0, 2);
        profgrid.add(roleres, 1, 2);
        profgrid.add(hrslabel, 0, 3);
        profgrid.add(hrsres, 1, 3);
        profgrid.add(dayslabel, 0, 4);
        profgrid.add(daysres, 1, 4);

        profgrid.add(ratelabel, 2, 0);
        profgrid.add(rateres, 3, 0);
        profgrid.add(discflabel, 2, 1);
        profgrid.add(discfres, 3, 1);
        profgrid.add(dusclabel, 2, 2);
        profgrid.add(discres, 3, 2);
        profgrid.add(addresslabel, 2, 3);
        profgrid.add(addressres, 3, 3);
        profgrid.add(privlabel, 2, 4);
        profgrid.add(privres, 3, 4);

        profgrid.add(typelabel, 4, 0);
        profgrid.add(typeres, 5, 0);
        profgrid.add(fixeslabel, 4, 1);
        profgrid.add(fixesres, 5, 1);
        profgrid.add(salarylabel, 4, 2);
        profgrid.add(salaryres, 5, 2);

        profgrid.setVgap(20);
        profgrid.setHgap(-50);

        Button btn3 = new Button();
        btn3.setText("Logout");
        btn3.setId("logbtn");
//       Logout Button
        btn3.setOnAction((ActionEvent event) -> {
            txt2.setText("");
            passtxt.setText("");
            passcheck = false;
            primaryStage.setTitle("Login");
            primaryStage.setScene(login);

        });



        VBox profileLayout = new VBox(profileheader, profgrid, btn3);
        profileLayout.setAlignment(Pos.CENTER);
        profileLayout.setSpacing(40);
        profileLayout.getStylesheets().add("File:src/gym/system/css/ProfileCSS.css");

        profile = new Scene(profileLayout, 1280, 720);

        primaryStage.setScene(profile);
        primaryStage.setTitle("Profile");
                    
    }
    
//    Login button functionality
    public void Loginbtn(Button loginbtn) {
    
        loginbtn.setOnAction(e -> {
//            Check if the account is in db
            idd = (idtxt.getText());
            pass = passtxt.getText();
            String sql = "SELECT * FROM ACCOUNTS WHERE id ="+idd;
            String sq2 = "SELECT ROLE, FIRSTNAME, LASTNAME FROM EMPLOYEES WHERE id = "+idd;

            conn = dbConn.DBConnection();
            
            try {
                pst = conn.prepareStatement(sql);
                Statement conn4 = conn.createStatement();
                ResultSet rs3 = conn4.executeQuery(sql);
                while ( rs3.next() ) {
                    iddd = rs3.getString("ID");
                    passdb = rs3.getString("PASSWORD");
                }
                if ((iddd.equals(idd)) && (passdb.equals(pass))){
                    passcheck = true;
                }
                pst.executeUpdate();
                pst.close();
                Statement conn2 = conn.createStatement();
                ResultSet rs = conn2.executeQuery(sq2);
                while ( rs.next() ) {
                    role = rs.getString("ROLE");
                    name = rs.getString("FIRSTNAME")+" "+rs.getString("LASTNAME");
                }
                conn.close();
                rs.close();
                conn2.close();
                rs3.close();
                conn4.close();
                


//                checks if the employee is manager or coach to diaplay the appropriate scene
                if ("Manager".equals(role) && passcheck){
                    //      Manager Layout 
                    ManagerScene(window);
                    

                    
                }else if ((!(role == null)) && (!(name == null)) && passcheck) {
                    //      Profile Begin
                    EmployeeScene(window);
                    
                }
                else {
                    txt2.setText("wrong user or pass");
                }
                
                
//                window.setScene(profile);
            } catch (Exception ex) {
                System.out.println(ex.toString());
                System.out.println("no2");
            }

        });
    }
    
//    Login Scene
    public void LoginScene(Stage primaryStage) {
    
        Image image1 = new Image("File:src\\gym\\system\\imgs/Logo.png",150,150, true,true);
        ImageView logoview = new ImageView(image1);
        
        
        Button loginbtn = new Button();
        loginbtn.setText("Login");
        loginbtn.setId("loginbtn");
        loginbtn.setMinSize(150,30);
        
        Text txt1 = new Text("Login");
        txt2 = new Text("");
        
        txt1.setTextAlignment(TextAlignment.CENTER);
        
        
        txt1.setId("text");
        txt1.getStyleClass().add("text");
        txt2.getStyleClass().add("text");
        txt2.setId("wrongtxt");
        
        idtxt = new TextField();
        idtxt.setPromptText("ID");
        passtxt = new PasswordField();
        passtxt.setPromptText("Password");
        
        GridPane logingrid = new GridPane();
        
        logingrid.add(txt1, 1, 0, 2, 1);
        logingrid.add(idtxt, 0, 1,3,1);
        logingrid.add(passtxt, 0, 2,3,1);
        logingrid.add(loginbtn, 0, 3,3,1);
        logingrid.add(txt2, 0, 4,2,2);
        
        logingrid.setVgap(10);
        logingrid.setHgap(10);
        logingrid.setAlignment(Pos.CENTER);
        logingrid.setHalignment(idtxt, HPos.CENTER);
        logingrid.setHalignment(passtxt, HPos.CENTER);
        logingrid.setHalignment(txt1, HPos.CENTER);
        logingrid.setHalignment(loginbtn, HPos.CENTER);
        logingrid.setHalignment(txt2, HPos.CENTER);
        logingrid.setPadding(new Insets(20));
        
        Loginbtn(loginbtn);
//      Login Scene End

//      Login Layout           
        VBox root = new VBox(logoview,logingrid);
        root.setAlignment(Pos.CENTER);
        root.getStyleClass().add("root");
        
        login = new Scene(root, 600, 600);
        login.getStylesheets().add(getClass().getResource("css/LoginCSS.css").toExternalForm());
        primaryStage.minWidthProperty().bind(login.heightProperty().multiply(1.5));
        primaryStage.minHeightProperty().bind(login.widthProperty().divide(2));
        
        primaryStage.setTitle("Login");
        primaryStage.setScene(login);
        primaryStage.show();
        
    }
    
//    Table Populating Function
    public void show() throws SQLException {

        customerdata = FXCollections.observableArrayList();
//        CustomerList = new ArrayList<Customer>();
        conn = dbConn.DBConnection();

        pst = conn.prepareStatement("SELECT * FROM CUSTOMERS");
        res = pst.executeQuery();

        while (res.next()) {
            C = new Customer(res.getInt(1), String.valueOf(res.getString(2)),String.valueOf(res.getString(3)),  res.getInt(4), res.getInt(5), res.getInt(6), res.getInt(7), res.getInt(8),res.getInt(9), String.valueOf(res.getString(10)));
            customerdata.add(C);
//            CustomerList.add(C);
        }
        pst.close();
        conn.close();
//        for (Customer cus : CustomerList){
//            cus.viewProfile();
//        }
        customertable.setItems(customerdata);
    }
    
    public void set() {
        filter = new FilteredList<>(customerdata, e-> true);
    } 
}
