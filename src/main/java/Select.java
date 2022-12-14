import java.sql.*;

//класс с методами для работы с субд
public class Select extends Father {

    private Connection dbCon = null;

    public void getAnswerAcc(String what, String where) {
        String req = "select " + what + " from main_acc where 1=1 " + where + ";";
        try {
            Class.forName("org.sqlite.JDBC");
            dbCon = DriverManager.getConnection(dbURL);
            Statement stmt = dbCon.createStatement();
            ResultSet rs = stmt.executeQuery(req);
            while (rs.next()) {
                System.out.println("id: " + rs.getInt("id") + " | name: "+ rs.getString("name") + " | surname: " + rs.getString("surname") + " | passport: " + rs.getString("passport") + " | kart: " + rs.getString("kart") + " | passw: " + rs.getString("passw") + " | money: " + rs.getInt("money") + " | status: " + rs.getString("status"));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    //INSERT DLYA NOVOGO AKK
    public void getInsertAcc(String name, String surname, String passport, String kart, String passw, String money, String status) {
        String from = "main_acc ( name, surname, passport, kart, passw, money, status)";
        String ins ="INSERT INTO " + from + " VALUES( '" + name + "', '" + surname + "', '" + passport + "', '" + kart + "', '" + passw + "', '" + money + "', '" + status + "')";
        //System.out.println(ins);
        try {
            Class.forName("org.sqlite.JDBC");
            dbCon = DriverManager.getConnection(dbURL);
            Statement stmt = dbCon.createStatement();
            stmt.execute(ins);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    //единичное значение
    public String getAnswerMainAcc(String what, String where) {
        String req = "select " + what + " from main_acc where 1=1 " + where + ";";
        //System.out.println(req);
        String a = null;
        try {
            Class.forName("org.sqlite.JDBC");
            dbCon = DriverManager.getConnection(dbURL);
            Statement stmt = dbCon.createStatement();
            ResultSet rs = stmt.executeQuery(req);
            while (rs.next()) {
                a=  rs.getString(what);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return a;
    }


    public void getUpdateMainAcc(String what, String where, String set) {
        String upd = "UPDATE main_acc SET  " + what + " = '" + set + "' where 1=1 " + where + ";";
       // System.out.println(upd);
        String a = null;
        try {
            Class.forName("org.sqlite.JDBC");
            dbCon = DriverManager.getConnection(dbURL);
            Statement stmt = dbCon.createStatement();
            stmt.execute(upd);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }


    public void getLog(String what, String where) {
        String req = "select " + what + " from log_data where 1=1 " + where + ";";
        //System.out.println(req);
        try {
            Class.forName("org.sqlite.JDBC");
            dbCon = DriverManager.getConnection(dbURL);
            Statement stmt = dbCon.createStatement();
            ResultSet rs = stmt.executeQuery(req);
            while (rs.next()) {
                System.out.println("id: " + rs.getInt("id") + " | time: "+ rs.getString("time") + " | who: " + rs.getString("who") + " | action: " + rs.getString("action") );
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void getLogCopy(String what, String where) {
        String req = "select " + what + " from log_data_copy where 1=1 " + where + ";";
        //System.out.println(req);
        try {
            Class.forName("org.sqlite.JDBC");
            dbCon = DriverManager.getConnection(dbURL);
            Statement stmt = dbCon.createStatement();
            ResultSet rs = stmt.executeQuery(req);
            while (rs.next()) {
                System.out.println("COPY|| id: " + rs.getInt("id") + " | time: "+ rs.getString("time") + " | who: " + rs.getString("who") + " | action: " + rs.getString("action") );
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
