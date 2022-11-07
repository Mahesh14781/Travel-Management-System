import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.util.*;

public class ViewCustomers extends JFrame
{

 	TextField text1,text2,text3;
 	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	Object	data[];
  	JTable table;
	public  ViewCustomers() throws Exception
	{
		Container container = getContentPane();
		container.setLayout(new GridLayout());
		Vector vColumns = new Vector();
		vColumns.add("Customer No" );
		vColumns.add("IdProofe");
		vColumns.add("Number");
		vColumns.add("Name");
		vColumns.add("Gender");
		vColumns.add("Country");
		vColumns.add("Address");
		vColumns.add("Mobile No");
		vColumns.add("Email");




		try
		{
  			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:travel","","");
			String sql2="select * from customer ";

			stmt=con.createStatement(rs.TYPE_SCROLL_SENSITIVE,rs.CONCUR_UPDATABLE);
			rs=stmt.executeQuery(sql2);
			rs.beforeFirst();

			Vector vData = new Vector();


			while(rs.next())
			{
                Vector v = new Vector();
				v.add(rs.getInt(1));
				v.add(rs.getString(2));

                v.add(rs.getString(3));

				v.add(rs.getString(4));
				v.add(rs.getString(5));
				v.add(rs.getString(6));

				v.add(rs.getString(7));
				v.add(rs.getString(8));
				v.add(rs.getString(9));

				vData.add(v);




			}


			JTable table=new JTable(vData,vColumns);

			JScrollPane jsp=new JScrollPane(table);
			add(jsp);


		}catch(Exception e)
			{
				System.out.println("error"+e);
			}
		this.setVisible(true);
		this.setSize(500,500);
		setTitle("Customer Report");
    }

}
