

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
public class BookPackage extends JFrame {
	private JPanel contentPane;
        JTextField t1,t2;
        Choice c1,c2,c3,c4;
        JLabel l1,l2,l3,l4,l5;
         Connection con;
		            ResultSet rs;
		            Statement stmt;
            String str5="";
                String str6="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookPackage frame = new BookPackage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BookPackage() {
		setBounds(420, 220, 1100, 450);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
                Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel la1 = new JLabel(i2);
                la1.setBounds(450,50,700,300);
                add(la1);

		JLabel lblName = new JLabel("BOOK PACKAGE");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblName.setBounds(118, 11, 300, 53);
		contentPane.add(lblName);

                JLabel la2 = new JLabel("Username :");
		la2.setBounds(35, 70, 200, 14);
		contentPane.add(la2);

               c4 = new Choice();
		c4.setBounds(271, 70, 100, 14);
		contentPane.add(c4);
try{
String sql="Select * From customer";
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con=DriverManager.getConnection("jdbc:odbc:travel","","");
		stmt=con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
		rs=stmt.executeQuery(sql);
		rs.beforeFirst();
		while(rs.next())
		{
			c4.addItem(rs.getString(1));
			//str6=rs.getString(1);
		}
} catch(Exception ex){}
try{
String sql="Select * From bookPackage";
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con=DriverManager.getConnection("jdbc:odbc:travel","","");
		stmt=con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
		rs=stmt.executeQuery(sql);
		rs.beforeFirst();
		while(rs.next())
		{
			String sss=rs.getString("ID");

			        	int ssss=Integer.parseInt(sss)+1;


			str6=""+ssss;
		}
} catch(Exception ex){}
                JLabel lblId = new JLabel("Select Package :");
		lblId.setBounds(35, 110, 200, 14);
		contentPane.add(lblId);

                c1 = new Choice();
                c1.add("Gold Package");
                c1.add("Silver Package");
                c1.add("Bronze Package");
                c1.setBounds(271, 110, 150, 30);
                add(c1);

                JLabel la3 = new JLabel("Total Persons");
		la3.setBounds(35, 150, 200, 14);
		contentPane.add(la3);

                t1 = new JTextField();
                t1.setText("0");
		t1.setBounds(271, 150, 150, 20);
		contentPane.add(t1);
		t1.setColumns(10);

		JLabel lbl1 = new JLabel("ID :");
		lbl1.setBounds(35, 190, 200, 14);
		contentPane.add(lbl1);

                 l2 = new JLabel();
		l2.setBounds(271, 190, 200, 14);
		contentPane.add(l2);

		JLabel lbl2 = new JLabel("Number :");
		lbl2.setBounds(35, 230, 200, 14);
		contentPane.add(lbl2);

                 l3 = new JLabel();
		l3.setBounds(271, 230, 200, 14);
		contentPane.add(l3);

		 JLabel lbl3 = new JLabel("Phone :");
		lbl3.setBounds(35, 270, 200, 14);
		contentPane.add(lbl3);

                 l4 = new JLabel();
		l4.setBounds(271, 270, 200, 14);
		contentPane.add(l4);


		JLabel lblDeposite = new JLabel("Total Price :");
		lblDeposite.setBounds(35, 310, 200, 14);
		contentPane.add(lblDeposite);

		 l5 = new JLabel();
		l5.setBounds(271, 310, 200, 14);
                l5.setForeground(Color.RED);
		contentPane.add(l5);

                /*try{
                    //Conn c = new Conn();
                   // ResultSet rs = c.s.executeQuery("select * from customer where ID ='"+t1.getText()+"'");
                    while(rs.next()){
                        l2.setText(rs.getString("id_type"));
                        l3.setText(rs.getString("number"));
                        l4.setText(rs.getString("phone"));

                    }

                    rs.close();
                }catch(SQLException e){}*/

                JButton b1 = new JButton("Check Price");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            String p = c1.getSelectedItem();
                            int cost = 0;
                            if(p.equals("Gold Package")) {
                                cost += 12000;
                            }if(p.equals("Silver Package")){
                                cost += 25000;
                            }else if(p.equals("Bronze Package")){
                                cost += 32000;
                            }

                            cost *= Integer.parseInt(t1.getText());
                            l5.setText("Rs "+cost);

                        }
		});
		JButton b2 = new JButton("Check");
				b2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
		 try
								      	   {
											   String sel11=c4.getSelectedItem();
											   int se=Integer.parseInt(sel11);
								      	   String str="select * from customer where id="+se+"";
								          rs=stmt.executeQuery(str);
								          while(rs.next())
								          {
								          	// t1.setText(rs.getString(1));
								   		                       l2.setText(rs.getString(2));
															                                       l3.setText(rs.getString(3));
															                                       l4.setText(rs.getString(8));


		                                }


								          }
								          catch(Exception ex)
								          {
								          	  System.out.println("error"+ex);
		       }
		                        }
		});
				b2.setBounds(425, 70, 80, 22);
		                b2.setBackground(Color.BLACK);
		                b2.setForeground(Color.WHITE);
		contentPane.add(b2);
		b1.setBounds(50, 350, 120, 30);
                b1.setBackground(Color.BLACK);
                b1.setForeground(Color.WHITE);
		contentPane.add(b1);


		JButton btnNewButton = new JButton("Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


try
   	  {
String sql="Select * From bookPackage";
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con=DriverManager.getConnection("jdbc:odbc:travel","","");
		stmt=con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
		rs=stmt.executeQuery(sql);
		rs.beforeFirst();
		while(rs.next())
		{
			String sss=rs.getString("ID");

			        	int ssss=Integer.parseInt(sss)+1;


			str6=""+ssss;
		}
		   System.out.println(str6);
        str5="insert into bookPackage values('"+str6+"','"+c4.getSelectedItem()+"', '"+c1.getSelectedItem()+"', '"+t1.getText()+"', '"+l2.getText()+"', '"+l3.getText()+"', '"+l4.getText()+"', '"+l5.getText()+"')";

        int n =stmt.executeUpdate(str5);

      JOptionPane.showMessageDialog(null, "Customer Added Successfully");
       //reset1();
      }
      catch(Exception ex)
      {
      	System.out.println("error"+ex);
      }
                            /*try{
	    			String s1 = c1.getSelectedItem();

                                String q1 = "insert into bookPackage values('"+username+"', '"+c1.getSelectedItem()+"', '"+t1.getText()+"', '"+l2.getText()+"', '"+l3.getText()+"', '"+l4.getText()+"', '"+l5.getText()+"')";
                                c.s.executeUpdate(q1);

	    			JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                                setVisible(false);
                            }catch(Exception ee){
	    			System.out.println(ee.getMessage());
                            }*/

			}
		});
		btnNewButton.setBounds(200, 350, 120, 30);
                btnNewButton.setBackground(Color.BLACK);
                btnNewButton.setForeground(Color.WHITE);
		contentPane.add(btnNewButton);

		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            setVisible(false);
			}
		});
		btnExit.setBounds(350, 350, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);

                getContentPane().setBackground(Color.WHITE);
	}
}