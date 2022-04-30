import javax.swing.*;

public class PaneJOption {
    public PaneJOption()
    {
        /*
        this is just message
         */
//        JOptionPane.showMessageDialog(null,"this is some useless info","title", JOptionPane.PLAIN_MESSAGE);
//        JOptionPane.showMessageDialog(null,"this is some useless info","title", JOptionPane.INFORMATION_MESSAGE);
//        JOptionPane.showMessageDialog(null,"this is some useless info","title", JOptionPane.QUESTION_MESSAGE);
//        JOptionPane.showMessageDialog(null,"this is some useless info","title", JOptionPane.WARNING_MESSAGE);
//        JOptionPane.showMessageDialog(null,"this is some useless info","title", JOptionPane.ERROR_MESSAGE);

    /*
    show confirm dialogue - ok, cancel, stuff

        System.out.println(JOptionPane.showConfirmDialog(null,"bro, do you even code","this is my title",JOptionPane.YES_NO_CANCEL_OPTION));
*/
//        JOptionPane.showInputDialog("What is your name?");


        JOptionPane.showOptionDialog(null,"You are awesome!", "Secret messgage",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE,null,null,0);
    }
    public static void main(String[] args) {
        new PaneJOption();
    }
}
