import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Main {
    private static JFrame frame = new JFrame();
    private static JLabel timelabel = new JLabel();
    private static JButton start = new JButton();
    private static JButton stop = new JButton();
    private static JButton reset = new JButton();
    private static JButton exit = new JButton();
    private static Container container = new Container();
    static Color bgColor = new Color(9,27,49);
    static Color foregroundColor = new Color(23,244,203);
    static Font timeFont = new Font("Tahoma",Font.BOLD,140);
    private static Timer timer;
    private void stopwatch(){
        Color foregroundColor = new Color(23,244,203);
        timelabel.setForeground(foregroundColor);
        timelabel.setText("00:00:00");
        timelabel.setFont(timeFont);
        timelabel.setBounds(80,15,750,450);
        frame.add(timelabel);
    }
    private void stopTimer(){
        timer.stop();
    }
    public void layout(){

        frame.getContentPane().setBackground(bgColor);
        frame.setSize(800,500);
        frame.setLocation(400,200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setUndecorated(true);

        //buttons
        start.setBorderPainted(true);
        start.setText("Start");
        start.setBackground(Color.green);
        start.setForeground(Color.BLACK);
        start.setFont(new Font("Tahoma",Font.PLAIN,15));
        start.setBounds(230,400,100,30);
        frame.add(start);

        stop.setBorderPainted(true);
        stop.setText("Stop");
        stop.setBackground(Color.RED);
        stop.setForeground(Color.WHITE);
        stop.setFont(new Font("Tahoma",Font.PLAIN,15));
        stop.setBounds(350,400,100,30);
        frame.add(stop);

        reset.setBorderPainted(true);
        reset.setText("Reset");
        reset.setBackground(Color.BLACK);
        reset.setForeground(Color.WHITE);
        reset.setFont(new Font("Tahoma",Font.PLAIN,15));
        reset.setBounds(470,400,100,30);
        frame.add(reset);

        // exit button
        JButton exit = new JButton(){
            protected void paintComponent(Graphics g){
                Image image = new ImageIcon(this.getClass().getResource("exit.png")).getImage();
                g.drawImage(image,0,0,this.getWidth(),this.getHeight(),this);
            }

        };
        exit.setBorderPainted(false);
        exit.setBounds(780,5,20,20);
        frame.add(exit);
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        frame.setLayout(null);
        frame.setVisible(true);
        container.add(frame);
    }

    public static void main(String[] args) {
        Main obj = new Main();
        obj.stopwatch();
        obj.layout();
    }
}