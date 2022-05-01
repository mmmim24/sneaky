import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MenuBarDemo extends JFrame implements ActionListener {
    JMenuItem loadItem;
    public MenuBarDemo()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(new FlowLayout());


        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu helpMenu = new JMenu("Help");


        loadItem = new JMenuItem("Load");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");


        loadItem.setMnemonic(KeyEvent.VK_L); /// L for load
        saveItem.setMnemonic(KeyEvent.VK_S); // s for load
        exitItem.setMnemonic(KeyEvent.VK_E);

        loadItem.addActionListener(this);



        menuBar.add(fileMenu);
        fileMenu.add(loadItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        this.setJMenuBar(menuBar);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new MenuBarDemo();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==loadItem)
        {
            System.out.println("THIS IS SPARTA!11");
        }

    }
}
