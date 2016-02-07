/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package img_emp_src;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 *
 * @author egrubellano
 */
public class ExampleComponent extends JComponent implements MouseMotionListener
{
    Image image;

    public ExampleComponent()
    {
//        ImageIcon icon = new ImageIcon("image.png");
        ImageIcon icon = new ImageIcon("Galaxy1.jpg");
        image = icon.getImage();
        addMouseMotionListener(this);
    }

    public Image getImage()
    {
        return image;
    }

    @Override
    public void mouseMoved(MouseEvent m) 
    {
        System.out.println("Mouse Moved");
    }

    @Override
    public void mouseDragged(MouseEvent m)
    {
        System.out.println("Mouse Dragged");
    }
}
