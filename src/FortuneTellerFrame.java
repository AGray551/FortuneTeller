import javax.swing.*;
import java.awt.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.StyledDocument;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FortuneTellerFrame extends JFrame {

    JPanel topPnl;
    JScrollPane midPnl;
    JPanel botPnl;

    JLabel titleLbl;
    JTextArea fortuneDly;
    JButton read;
    JButton quit;
    String lastFortune;

    public FortuneTellerFrame() {
        setLayout(new BorderLayout());

        createTopPanel();
        createMidPanel();
        createBotPanel();

        setLocationRelativeTo(null);
        setLocation(500, 200);
        setSize(new Dimension(800, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createTopPanel() {
        topPnl = new JPanel();
        ImageIcon icon = new ImageIcon("src/genie.png");
        titleLbl = new JLabel("Fortune Teller:", icon, JLabel.CENTER);
        titleLbl.setFont(new Font("MS Mincho",Font.PLAIN, 36));
        titleLbl.setVerticalTextPosition (JLabel.BOTTOM);
        titleLbl.setHorizontalTextPosition (JLabel.CENTER);
        topPnl.add(titleLbl);
        add(topPnl, BorderLayout.NORTH);
    }

    private void createMidPanel() {
        midPnl = new JScrollPane();

        fortuneDly = new JTextArea("Fortunes: ",5,5);
        fortuneDly.setEditable(false);

        midPnl.setViewportView(fortuneDly);
        add(midPnl, BorderLayout.CENTER);
    }

    private void createBotPanel() {
        botPnl = new JPanel();

        read = new JButton("Read Your Fortune!");
        quit = new JButton("Quit");

        read.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fortuneRandomizer();
            }
        });



        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        botPnl.add(read);
        botPnl.add(quit);
        add(botPnl, BorderLayout.SOUTH);
    }

    private void fortuneRandomizer() {
        ArrayList<String> fortunes = new ArrayList<String>();
        fortunes.add("A whole lotta nothing is happening to you today.");
        fortunes.add("Today you will be blessed with 5 extra minutes of free time.");
        fortunes.add("Your destined lover is somewhere within the atmosphere.");
        fortunes.add("You are especially resilient towards the corners of tables.");
        fortunes.add("Kindness MIGHT be in your favor.");
        fortunes.add("Water will taste very good for you.");
        fortunes.add("You are not going to win the lottery.");
        fortunes.add("Winning will not come easy to you, losing will.");
        fortunes.add("This fortune is a lie, am I telling the truth?");
        fortunes.add("You will not make any more speling errors.");
        fortunes.add("The wind is on your side, it is going to be slightly cold.");
        fortunes.add("Watch out for sheer cliffs, they are dangerous.");

        String fortune;
        do {
            fortune = fortunes.get((int) (Math.random() * fortunes.size()));
        } while (fortune.equals(lastFortune));
        lastFortune = fortune;

        fortuneDly.append("\n" + fortune);
    }
    public static void main(String[] args) {
    }


}
