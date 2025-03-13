/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.naming.spi.DirStateFactory.Result;

/**
 *
 * @author Tanuja
 */
public class LoginChecker {
    
    public boolean doLogin(String empid,String pass)
    {
        boolean flag=false;
        try
        {
           Class.forName("com.mysql.jdbc.Driver").newInstance();
           Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/covid_dose_management_system","root","root");
           Statement st=conn.createStatement();
           
           String query="select * from registerinfo where empid='"+empid+"'and password='"+pass+"'";
           ResultSet rs=st.executeQuery(query);
           
           if(rs.next())
           {
               flag=true;
           }
           else
           {
               flag=false;
           }
           conn.close();
           st.close();
        }
        catch(Exception ex)
        {
            System.out.println("Exception is "+ex);
        }
        return flag;
    }
}

