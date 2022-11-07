import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

 class Login extends JFrame implements ActionListener{

	private JPanel panel;
	private JTextField textField;
	private JPasswordField passwordField;
        private JButton b1,b2,b3;
Connection conn=null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	Statement stmt=null;
	Statement stmt1=null;
	Statement stmt2=null;

	ResultSet rs=null;
	ResultSet rs1=null;

    ResultSet r=null;




	public Login() {

	setBackground(new Color(255, 255, 204));
        setBounds(550, 250, 700, 400);

        panel = new JPanel();
	panel.setBackground(Color.WHITE);
	setContentPane(panel);
	panel.setLayout(null);

	JLabel l1 = new JLabel("Username : ");
	l1.setBounds(124, 89, 95, 24);
	panel.add(l1);

	JLabel l2 = new JLabel("Password : ");
	l2.setBounds(124, 124, 95, 24);
	panel.add(l2);

	textField = new JTextField();
	textField.setBounds(210, 93, 157, 20);
	panel.add(textField);

	passwordField = new JPasswordField();
	passwordField.setBounds(210, 128, 157, 20);
	panel.add(passwordField);

	JLabel l3 = new JLabel("");
	l3.setBounds(377, 79, 46, 34);
	panel.add(l3);

	JLabel l4 = new JLabel("");
	l4.setBounds(377, 124, 46, 34);
	panel.add(l3);

        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i1 = c1.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);


        JLabel l6 = new JLabel(i2);
        l6.setBounds(480, 70, 150, 150);
        add(l6);


	b1 = new JButton("Login");
	b1.addActionListener(this);

	b1.setForeground(new Color(46, 139, 87));
	b1.setBackground(new Color(176, 224, 230));
	b1.setBounds(149, 181, 113, 25);
	panel.add(b1);

        b2 = new JButton("Exit");
	b2.addActionListener(this);

	b2.setForeground(new Color(139, 69, 19));
	b2.setBackground(new Color(255, 235, 205));
	b2.setBounds(289, 181, 113, 25);
	panel.add(b2);

	b3 = new JButton("Forgot Password");
	b3.addActionListener(this);

        b3.setForeground(new Color(205, 92, 92));
	b3.setBackground(new Color(253, 245, 230));
	b3.setBounds(199, 231, 179, 25);
	panel.add(b3);

	JLabel l5 = new JLabel("Trouble in Login?");
	l5.setFont(new Font("Tahoma", Font.PLAIN, 15));
	l5.setForeground(new Color(255, 0, 0));
	l5.setBounds(70, 235, 110, 20);
	panel.add(l5);

        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(255, 255, 204));
        panel2.setBounds(24, 40, 434, 263);
        panel.add(panel2);

            }
 public void actionPerformed(ActionEvent ae)
    {
    	if(ae.getSource()==b1)
    	{ String id=textField.getText();
	   String pwd=passwordField.getText();
		if((id.equals("")) || (pwd.equals("")))
		 {
JOptionPane.showMessageDialog((Component) null,"Please Enter Username And Password","",JOptionPane.OK_CANCEL_OPTION);
		 }
		if((id.equals("Mahesh")) && (pwd.equals("MCA")))
		 {
			// new VBTest2();
setVisible(false);

JOptionPane.showMessageDialog(this, "! Login Successfully");
new Loading();
	  }
		  else  {
			  //new VBTest3();
JOptionPane.showMessageDialog((Component) null,"Please Enter correct Username And Password","",JOptionPane.OK_CANCEL_OPTION);
}



	}
    	if(ae.getSource()==b2)
    	{
    		System.exit(0);
    	}

}
  	public static void main(String[] args) {
                new Login().setVisible(true);
         	}

}