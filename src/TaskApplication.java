import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JComponent;

public class TaskApplication  extends JComponent  {
    // Поле для рисования
    private Image image;
    // Обьект для рисования
    private Graphics2D g2;
    // Координаты мыши
    private int currentX, currentY, oldX, oldY;

    public TaskApplication() {
        //Установка буффера для рисования
        /**
         *  Sets whether this component should use a buffer to paint.
         *  If set to true, all the drawing from this component will be done
         *  in an offscreen painting buffer. The offscreen painting buffer will
         *  the be copied onto the screen.
         *  If a <code>Component</code> is buffered and one of its ancestor
         *  is also buffered, the ancestor buffer will be used.
         *
         *  @param aFlag if true, set this component to be double buffered
         */
        setDoubleBuffered(false);
        //Обработчик мыши и задание новых координат
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                // Сохраняем координаты
                oldX = e.getX();
                oldY = e.getY();
            }
        });

        //Обработчик движений мыши
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                // координаты
                currentX = e.getX();
                currentY = e.getY();

                //Рисуем линии
                if (g2 != null) {
                    g2.drawLine(oldX, oldY, currentX, currentY);
                    repaint();
                    oldX = currentX;
                    oldY = currentY;
                }
            }
        });
    }

     protected void paintComponent(Graphics g) {
        //Создаем поле для рисования
        if (image == null) {
            image = createImage(getSize().width, getSize().height);
            g2 = (Graphics2D) image.getGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
        }

        g.drawImage(image, 0, 0, null);
    }

    // Создаем Метод Очистки поля
    public void clear() {
        g2.setPaint(Color.white);
        g2.fillRect(0, 0, getSize().width, getSize().height);
        g2.setPaint(Color.black);
        repaint();
    }

    //Добавляем цвета
    public void red() {
        g2.setPaint(Color.red);
    }

    public void black() {
        g2.setPaint(Color.black);
    }

    public void magenta() {
        g2.setPaint(Color.magenta);
    }

    public void green() {
        g2.setPaint(Color.green);
    }

    public void blue() {
        g2.setPaint(Color.blue);
    }
}
