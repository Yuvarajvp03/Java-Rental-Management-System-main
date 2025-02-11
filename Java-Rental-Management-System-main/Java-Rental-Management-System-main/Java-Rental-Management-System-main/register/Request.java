package register;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import account.AccountFactory;
import database.DatabaseConnection;

public class Request {

    private int role;
	private int id;
	private long phone;
    private String name;
    private String email;
    private String password;

    //Constructor
    public Request(){}

    //Constructor
    Request(int role, String name, String email, String phone,String password) {
        this.role = role;
        this.name = name;
        this.email = email;
        this.phone = Long.parseLong(phone);
        this.password=password;
    }

    public boolean insertRequest(){ //to insert database and check if insert successfully

        try {

            Statement statement = DatabaseConnection.getConnection().createStatement();
            String insertFields = "INSERT INTO registration (registration_name, registration_phone, registration_email, registration_account, password) VALUES (\""
                    + name + "\", "
                    + phone + ", \""
                    + email + "\", "
                    + role + ", \""
                    + password + "\")";

            System.out.println(insertFields);
            statement.executeUpdate(insertFields);
            return true; //no email or phone in used
        } catch (Exception ex) {
            return false; //email or phone is in used
        }
    }

    //check if existing table has other user using same email or phone number
    public boolean checkTable(){
        AccountFactory factory = new AccountFactory();
        try{
            String roleString = factory.getAccount(role).toString().toLowerCase();
            Statement statement = DatabaseConnection.getConnection().createStatement();
            String query = "SELECT " + roleString + "_email, " + roleString + "_phone FROM " + roleString + " WHERE " + roleString +
                    "_email = \'" + email + "\' or " + roleString + "_phone = " + phone;
            ResultSet rs = statement.executeQuery(query);

            if(rs.next()){
                return false; //email or phone is in used
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return true; //no email or phone in used
    }

    public ArrayList<ArrayList<Object>> getRequestList(){ //get request table list
        AccountFactory factory = new AccountFactory();
        ArrayList<ArrayList<Object>> requestList = new ArrayList<>();

        try{
            //open connection
            Statement statement = DatabaseConnection.getConnection().createStatement();
            String query = "select * from registration;";
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()){
                //add all data
                ArrayList<Object> requestRow = new ArrayList<>();
                requestRow.add(rs.getInt(1));
                requestRow.add(rs.getString(2));
                requestRow.add(rs.getLong(3));
                requestRow.add(rs.getString(4));
                requestRow.add(factory.getAccount(rs.getInt(5)).toString());
                requestRow.add(rs.getString(6));
                requestList.add(requestRow);
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return requestList;
    }

    //get one request selected from database, return account type
    public Request getRequestFromDatabase(int registrationID){

        try{
            Statement statement = DatabaseConnection.getConnection().createStatement();
            String sql = "select * from registration where registration_id=" + registrationID + ";";
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                int role = result.getInt("registration_account");
                setId(registrationID);
                setName(result.getString("registration_name"));
                setEmail(result.getString("registration_email"));
                setPhone(result.getLong("registration_phone"));
                setPassword(result.getString("password"));
                setRole(role);
                return this;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    //setter
    public void setId(int id) {
        this.id = id;
    }
    public void setRole(int role) {
        this.role = role;
    }
    public void setName(String name){ this.name = name; }
    public void setPhone(long phone){
        this.phone = phone;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    //getter
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public long getPhone(){
        return phone;
    }
    public String getEmail(){
        return email;
    }
    public long getRole(){
        return role;
    }
    public String getPassword() {
        return password;
    }
}
