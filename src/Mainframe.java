import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class Mainframe extends JFrame{

    private int ScreenW = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int ScreenH = Toolkit.getDefaultToolkit().getScreenSize().height;
    private int frmW = 700,frmH=600 ;
    private JMenuBar jmb = new JMenuBar();
    private  JMenu jmF = new JMenu("File");
    private  JMenu jmSet = new JMenu("Set");
    private  JMenu jmGame = new JMenu("Game");
    private  JMenu jmAbout = new JMenu("About");
    private  JMenuItem jmItemExit = new JMenuItem("Exit");
    private  JMenuItem jmItemLoto = new JMenuItem("Loto");
    private  JMenuItem jmItemKey = new JMenuItem("Keyboard");
    private JTextField Jtf = new JTextField();
    private JButton Jbtn[] = new JButton[10];
    private int data[] = new int[10];
    private  JLabel Jlb[] = new JLabel[6];
    private int data2[] = new int[6];
    private  JDesktopPane jdp = new JDesktopPane();
    private  JDesktopPane jdp1 = new JDesktopPane();
    private JInternalFrame jif = new JInternalFrame();
    private JInternalFrame jif1 = new JInternalFrame();
    private JPanel Jp= new JPanel(new GridLayout(4,3,3,3));
    private JPanel Jpge1= new JPanel(new GridLayout(1,6,3,3));
    private JPanel Jpge2= new JPanel(new GridLayout(1,2,3,3));
    private JButton Jbtno = new JButton("/");
    private JButton Jbtn1 = new JButton("Close");
    private JButton Jbtnc1 = new JButton("Close");
    private JButton Jbtn2 = new JButton("General");
    private Random rnd = new Random(System.currentTimeMillis());

    private Container cp;
    private Container cp1;
    private boolean b;

    public Mainframe(){

        init();
    }
    private void init(){
            this.setContentPane(jdp);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Mainframe.this.setVisible(false);
              //  log.setVisible(true);
            }
        });
        this.setBounds(ScreenW/2-frmW/2,ScreenH/2-frmH/2,frmW,frmH);
        this.setJMenuBar(jmb);
        Jtf.setEditable(false);
        Jtf.setHorizontalAlignment(JTextField.RIGHT);
        jmb.add(jmF);
        jmb.add(jmSet);
        jmb.add(jmGame);
        jmb.add(jmAbout);

        jmF.add(jmItemExit);
        jmGame.add(jmItemLoto);
        jmGame.add(jmItemKey);
        jmItemExit.setAccelerator(KeyStroke.getKeyStroke('X',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        jmItemLoto.setAccelerator(KeyStroke.getKeyStroke('C',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        jmItemKey.setAccelerator(KeyStroke.getKeyStroke('K',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));

        cp = jif.getContentPane();
        cp.setLayout(new BorderLayout(5,5));
        cp.add(Jtf,BorderLayout.NORTH);
        cp.add(Jp,BorderLayout.CENTER);

        cp1 = jif1.getContentPane();
        cp1.setLayout(new BorderLayout(5,5));
        cp1.add(Jpge1,BorderLayout.CENTER);
        cp1.add(Jpge2,BorderLayout.SOUTH);
        Jpge2.add(Jbtnc1);
        Jpge2.add(Jbtn2);

        jif.setBounds(0,0,400,300);
        jif1.setBounds(0,0,300,120);


Jbtn1.addActionListener(new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        Jp.removeAll();
        jif.dispose();

    }
});
        Jbtnc1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Jp.removeAll();
                jif1.dispose();
            }
        });


         jmItemLoto.addActionListener(new AbstractAction() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 Jpge1.removeAll();
                 Loto();
                 jdp.add(jif1);
                 jif1.setVisible(true);
             }
         });
        jmItemKey.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Jp.removeAll();
                keyboard();
                jdp.add(jif);
                jif.setVisible(true);
            }
        });
        jmItemExit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

Jbtn2.addActionListener(new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
Jpge1.removeAll();

        Loto();



    }
});
    }

    public void keyboard(){
        int  n;
        for(int i=0;i<10;i++){
            for(int j =1;j<11;j++) {
                data[i] = j;
            }

        }
        for(int i=0;i<10;i++)
        {
            b = true;
            while(b) {
                b = false;
                n = rnd.nextInt(10);
                for(int j=0;j<data.length;j++) {
                    if(n==data[j]){
                        b = true;
                    }
                }
                data[i]=n;

            }

            Jbtn[i]=new JButton(Integer.toString(data[i]));
            Jp.add(Jbtn[i]);
            Jbtn[i].setOpaque(true);
            Jbtn[i].setFont(new Font("Source Sans pro ", Font.PLAIN, 22));
            Jbtn[i].setHorizontalAlignment(SwingConstants.CENTER);
            Jbtn[i].addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton tmpButton = (JButton)e.getSource();
                    Jtf.setText(Jtf.getText()+tmpButton.getText());

                }
            });
        } Jp.add(Jbtno);
        Jp.add(Jbtn1);
        Jbtno.setOpaque(true);
        Jbtno.setFont(new Font("Source Sans pro ", Font.PLAIN, 22));
        Jbtno.setHorizontalAlignment(SwingConstants.CENTER);
        Jbtno.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton tmpButton = (JButton)e.getSource();
                Jtf.setText(Jtf.getText()+tmpButton.getText());

            }
        });


    }
    public void Loto(){
        int  n;
        for(int i=0;i<6;i++)
        {
            b = true;
            while(b) {
                b = false;
                n = rnd.nextInt(42)+1;
                for(int j=0;j<data2.length;j++) {
                    if(n==data2[j]){
                        b = true;
                    }
                }
                data2[i]=n;

            }

            Jlb[i]=new JLabel(Integer.toString(data2[i]));
            Jpge1.add(Jlb[i]);
            Jlb[i].setOpaque(true);
            Jlb[i].setBackground(new Color (100,100,255));
            Jlb[i].setFont(new Font("Source Sans pro ", Font.PLAIN, 22));
            Jlb[i].setHorizontalAlignment(SwingConstants.CENTER);
        }
    }

}
