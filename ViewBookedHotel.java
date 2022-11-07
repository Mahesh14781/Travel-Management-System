import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.util.*;

public class ViewBookedHotel extends JFrame
{

 	TextField text1,text2,text3;
 	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	Object	data[];
  	JTable table;
	public  ViewBookedHotel() throws Exception
	{
		Container container = getContentPane();
		container.setLayout(new GridLayout());
		Vector vColumns = new Vector();
		vColumns.add("Customer No" );
		vColumns.add("Hotel");
		vColumns.add("Persons");
		vColumns.add("Days");
		vColumns.add("Ac/Non-Ac");
		vColumns.add("Food");
		vColumns.add("IdProof");
		vColumns.add("Number");
		vColumns.add("Mobile No");
vColumns.add("Total");



		try
		{
  			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:travel","","");
			String sql2="select * from bookHotel ";

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
v.add(rs.getString(10));
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
