import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Starter {
    //Обьекты кнопок
    JButton clearBtn, blackBtn, blueBtn, greenBtn, redBtn, magentaBtn;

    TaskApplication taskApplication;
    //Обработчик действий и установка функций кнопок
    ActionListener actionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == clearBtn) {
                taskApplication.clear();
            } else if (e.getSource() == blackBtn) {
                taskApplication.black();
            } else if (e.getSource() == blueBtn) {
                taskApplication.blue();
            } else if (e.getSource() == greenBtn) {
                taskApplication.green();
            } else if (e.getSource() == redBtn) {
                taskApplication.red();
            } else if (e.getSource() == magentaBtn) {
                taskApplication.magenta();
            }
        }
    };

    public static void main(String[] args) {
        new Starter().show();
    }

    public void show() {
        // Создаем главное окно
        JFrame frame = new JFrame("Task Application Рисовальщик");
        Container content = frame.getContentPane();
        // Создаем слой обьектов для размещения
        content.setLayout(new BorderLayout());
        // Создаем обьект поле для рисования
        taskApplication = new TaskApplication();
        content.add(taskApplication, BorderLayout.CENTER);
        // Панель для контрольных кнопок
        JPanel controls = new JPanel();
        clearBtn = new JButton("Очистить");
        clearBtn.addActionListener(actionListener);
        blackBtn = new JButton("Черный");
        blackBtn.addActionListener(actionListener);
        blueBtn = new JButton("Голубой");
        blueBtn.addActionListener(actionListener);
        greenBtn = new JButton("Зеленый");
        greenBtn.addActionListener(actionListener);
        redBtn = new JButton("Красный");
        redBtn.addActionListener(actionListener);
        magentaBtn = new JButton("Розовый");
        magentaBtn.addActionListener(actionListener);
        // Добавляем кнопки в область кнопок
        controls.add(greenBtn);
        controls.add(blueBtn);
        controls.add(blackBtn);
        controls.add(redBtn);
        controls.add(magentaBtn);
        controls.add(clearBtn);
        //Добавляем кнопки в слой контента
        content.add(controls, BorderLayout.NORTH);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
