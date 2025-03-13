/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbDemo;


//import static java.lang.Character.UnicodeBlock.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertDatasql
{
    public boolean getInsert(String name,String emailid,String mobileno,String employeeid,String password)
    {
       boolean flag = false;
       try
       {
           Class.forName("com.mysql.jdbc.Driver").newInstance();
           Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/covid_dose_management_system","root","root");
           Statement st=conn.createStatement();
           
           String query="insert into registerinfo values('"+name+"','"+emailid+"','"+mobileno+"','"+employeeid+"','"+password+"')";
           System.out.println("Query is :"+query);
           
           int x=st.executeUpdate(query);
           if(x>0)
                  flag=true;
           else
                 flag=false;
                 conn.close();
                 st.close();
       }
       catch(Exception ex)
       {
           System.out.println("Exception is :"+ex);   
       }
       return flag;
    }

   
       
       
    
}
