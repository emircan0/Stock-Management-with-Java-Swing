package command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class GeneralListener implements ActionListener, MouseListener {

    private Command command;

    public GeneralListener(Command command) {
        this.command = command;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        command.execute(); 
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        command.execute(); 
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
