import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class Loginframe extends JFrame{
    private JLabel JlbID = new JLabel("ID:");
    private JLabel JlbPW = new JLabel("Password:");
    private JTextField JtfID = new JTextField();
    private JPasswordField JtfPW = new JPasswordField();
    private JButton JbtnExit = new JButton("Exit");
    private JButton JbtnLogin = new JButton("Login");
    private Container cp;
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private int frmW = 300,frmH=150 ,ScreenW,ScreenH;


    public Loginframe(){
        init();
    }
    private void init(){
        ScreenH=dim.height;
        ScreenW=dim.width;
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(ScreenW/2-frmW/2,ScreenH/2-frmH/2,frmW,frmH);
        cp=this.getContentPane();
        cp.setLayout(new GridLayout(3,2,3,3));
        JlbID.setHorizontalAlignment(JLabel.RIGHT);
        JlbPW.setHorizontalAlignment(JLabel.RIGHT);
        cp.add(JlbID);
        cp.add(JtfID );
        cp.add(JlbPW );
        cp.add(JtfPW );
        cp.add(JbtnExit );
        cp.add(JbtnLogin );
        JbtnExit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        JbtnLogin.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(JtfID.getText().equals("h304")&&new String (JtfPW.getPassword()).equals("23323456")){
                    Mainframe mainframe = new Mainframe();

//                    Mainframe mainframe = new Mainframe(Loginframe.this);
                  mainframe.setVisible(true);
                    Loginframe.this.setVisible(false);
                    JtfID.setText("");
                    JtfPW.setText("");
                }else{
                    JtfID.setText("");
                    JtfPW.setText("");
                    JOptionPane.showMessageDialog(Loginframe.this,"Error");
                }

            }
        });



    }

}