

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Image;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class DeleteCustomer extends JFrame {
	private JPanel contentPane;
        Choice c1;
           JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
           Connection con=null;
		   	PreparedStatement pstmt=null;
		   	PreparedStatement pstmt1=null;
		   	Statement stmt=null;
		   	Statement stmt1=null;
		   	Statement stmt2=null;

		   	ResultSet rs=null;
		   	ResultSet rs1=null;

    ResultSet r=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteCustomer frame = new DeleteCustomer();
					frame.setVisible(true);
				} catch (Exception ep) {
					//e.printStackTrace();
				}
			}
		});
	}

	public DeleteCustomer() throws SQLException {
		setBounds(580, 220, 850, 550);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
                Image i3 = i1.getImage().getScaledInstance(300, 300,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
              l1 = new JLabel(i2);
                l1.setBounds(500,100,300,300);
                add(l1);

		JLabel lblName = new JLabel("DELETE CUSTOMER DETAILS");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblName.setBounds(118, 11, 300, 53);
		contentPane.add(lblName);

                JLabel lb3 = new JLabel("Username :");
		lb3.setBounds(35, 70, 200, 14);
		contentPane.add(lb3);

c1=new Choice();
                c1.setBounds(271, 70, 150, 30);
                add(c1);

                JLabel lblId = new JLabel("ID :");
		lblId.setBounds(35, 110, 200, 14);
		contentPane.add(lblId);

               l2 = new JLabel();
		l2.setBounds(271, 110, 200, 14);
		contentPane.add(l2);

                JLabel lb2 = new JLabel("Number :");
		lb2.setBounds(35, 150, 200, 14);
		contentPane.add(lb2);

                 l3 = new JLabel();
		l3.setBounds(271, 150, 200, 14);
		contentPane.add(l3);

		JLabel lblName_1 = new JLabel("Name :");
		lblName_1.setBounds(35, 190, 200, 14);
		contentPane.add(lblName_1);

		 l4 = new JLabel();
		l4.setBounds(271, 190, 200, 14);
		contentPane.add(l4);


		JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(35, 230, 200, 14);
		contentPane.add(lblGender);

                 l5 = new JLabel();
		l5.setBounds(271, 230, 200, 14);
		contentPane.add(l5);

		JLabel lblCountry = new JLabel("Country :");
		lblCountry.setBounds(35, 270, 200, 14);
		contentPane.add(lblCountry);

                 l6 = new JLabel();
		l6.setBounds(271, 270, 200, 14);
		contentPane.add(l6);

		JLabel lblReserveRoomNumber = new JLabel("Permanent Address :");
		lblReserveRoomNumber.setBounds(35, 310, 200, 14);
		contentPane.add(lblReserveRoomNumber);

                 l7 = new JLabel();
		l7.setBounds(271, 310, 200, 14);
		contentPane.add(l7);

		JLabel lblCheckInStatus = new JLabel("Phone :");
		lblCheckInStatus.setBounds(35, 350, 200, 14);
		contentPane.add(lblCheckInStatus);

                 l8 = new JLabel();
		l8.setBounds(271, 350, 200, 14);
		contentPane.add(l8);


		JLabel lblDeposite = new JLabel("Email :");
		lblDeposite.setBounds(35, 390, 200, 14);
		contentPane.add(lblDeposite);

		 l9 = new JLabel();
		l9.setBounds(271, 390, 200, 14);
		contentPane.add(l9);
		try{
String sql="Select * From customer";
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con=DriverManager.getConnection("jdbc:odbc:travel","","");
		stmt=con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
		rs=stmt.executeQuery(sql);
		rs.beforeFirst();
		while(rs.next())
		{
			c1.addItem(rs.getString(1));
		}
} catch(Exception ex){}
		JButton b1 = new JButton("Check");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
 try
						      	   {
									   String sel11=c1.getSelectedItem();
									   int se=Integer.parseInt(sel11);
						      	   String str="select * from customer where id="+se+"";
						          rs=stmt.executeQuery(str);
						          while(rs.next())
						          {
						          	// t1.setText(rs.getString(1));
						   		                       l2.setText(rs.getString(2));
													                                       l3.setText(rs.getString(3));
													                                       l4.setText(rs.getString(4));
													                                       l5.setText(rs.getString(5));
													                                       l6.setText(rs.getString(6));
													                                       l7.setText(rs.getString(7));
													                                       l8.setText(rs.getString(8));
													                                       l9.setText(rs.getString(9));
                                }


						          }
						          catch(Exception ex)
						          {
						          	  System.out.println("error"+ex);
       }
                        }
		});
		b1.setBounds(425, 70, 80, 22);
                b1.setBackground(Color.BLACK);
                b1.setForeground(Color.WHITE);
		contentPane.add(b1);


		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
  try{
				String sel11=c1.getSelectedItem();
				int se=Integer.parseInt(sel11);



String sql = "DELETE FROM customer WHERE ID=?";

PreparedStatement statement = con.prepareStatement(sql);
statement.setString(1, sel11);

int rowsDeleted = statement.executeUpdate();
if (rowsDeleted > 0) {
    System.out.println("A user was deleted successfully!");
}


				}
	                          catch(Exception ez)
	                                {
	                                  	System.out.println("error"+ez);
                                 }
			}
		});
		btnNewButton.setBounds(100, 430, 120, 30);
                btnNewButton.setBackground(Color.BLACK);
                btnNewButton.setForeground(Color.WHITE);
		contentPane.add(btnNewButton);

		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            setVisible(false);
			}
		});
		btnExit.setBounds(260, 430, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);

                getContentPane().setBackground(Color.WHITE);
	}
}