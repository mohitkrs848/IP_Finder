import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

public class ipFinder extends JFrame implements ActionListener {
    JLabel enter_url_label = new JLabel("Enter URL:");   //declaring JLabel and passing a string "Enter URL"
    JTextField url_field = new JTextField();                   //declaring Text Field
    JButton finder_button = new JButton("Find IP");          //declaring JButton and giving a name "Find IP"

    ipFinder() {                                                //constructor of present class
        this.setTitle("IP Finder -mkz");                        //sets title of frame
        this.setSize(500, 500);                       //sets dimensions
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);       //exit program after clicking on that close button of window that open our frame
        this.setLocationRelativeTo(null);                                   //set location of appearing window relative to null means it will open in middle of screen
        this.setLayout(null);                                           //declare position to components we give inside our panel
        this.setVisible(true);                                          //visibility status of our panel

        //just declare two types of font that we use further
        Font f1 = new Font("Serif", Font.BOLD, 30);
        Font f2 = new Font("Arial", Font.BOLD, 20);

        enter_url_label.setBounds(150, 120, 200, 40);  //setting boundaries for our label
        enter_url_label.setFont(f1);   //the string here is passing with the values of font we declared

        url_field.setBounds(50, 200, 400, 30);   //setting boundaries for our text field

        finder_button.setBounds(150, 300, 200, 40); //setting boundaries for our button
        finder_button.setFont(f2);     //the button name here is passing with the values of font we declared
        finder_button.addActionListener(this);  //make button responsive as name suggest itself that it listen action so when we click on it it will go to the actionperformed class below that will decide what action suppose to take after clicking that button

        // .add adds the components to the container
        this.add(enter_url_label);
        this.add(url_field);
        this.add(finder_button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String url = url_field.getText();   //declaring url string that scan or took the value user entered in url_field
        try {
            InetAddress ia = InetAddress.getByName(url);       //InetAddress class is for IP addresses in java which determine the ip address with the help of url of host by .getByName() method
            String ip = ia.getHostAddress();                    //store the ip-address as  text in a string variable "ip"
            JOptionPane.showMessageDialog(this, "The IP Address of " + url + " is : " + ip);            //here this line opens a dialog box with the help op JOptionPane class and print the message we gave
        } catch (UnknownHostException UnKnownHostException) {
            JOptionPane.showMessageDialog(this, "IP Address not found. Check url !");   //if the ip address is not found then it will shows the given message
        }
    }
}