/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package img_emp_src;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author egrubellano
 */
public class ExamplePanel extends JPanel
{
    ArrayList<ExampleComponent> components;

    public ExamplePanel()
    {
        components = new ArrayList<>();
    }

    @Override
    public void paint(Graphics g)
    {
        for(ExampleComponent c : components)
            g.drawImage(c.getImage(), 0, 30, 50, 75, null);
    }

    public void addComponent(ExampleComponent j)
    {
        components.add(j);
        repaint();
    }

    public static void main(String[] args) 
    {
        JFrame app = new JFrame("Staff Prototype");
        app.setSize(700,200);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setResizable(false);

        ExamplePanel s = new ExamplePanel();
        app.getContentPane().add(s);
        s.addComponent(new ExampleComponent());
        app.setVisible(true);
    }
}
