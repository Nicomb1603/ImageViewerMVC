import control.Command;
import model.Image;
import view.SwingImageDisplay;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class MainFrame extends JFrame {
    private Dimension screenSize;
    private SwingImageDisplay imageDisplay;
    private Map<String, Command> commands;
    private JButton nextButton;
    private JButton previousButton;

    public MainFrame() throws IOException {
        this.commands = new HashMap<>();
        this.setTitle("Image Viewer");
        setScreenSize();
        imageDisplay = new SwingImageDisplay(screenSize);
        this.setSize(screenSize);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(imageDisplay);
        createButtons();
        this.add(previousButton, BorderLayout.WEST);
        this.add(nextButton, BorderLayout.EAST);
    }

    private void createButtons(){
        nextButton = new JButton(">");
        previousButton = new JButton("<");

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get(">").execute();
            }
        });
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("<").execute();
            }
        });
    }

    public void add(String name, Command command){this.commands.put(name, command);}

    public SwingImageDisplay imageDisplay() {return imageDisplay;}

    private void setScreenSize(){screenSize = Toolkit.getDefaultToolkit().getScreenSize();}


}