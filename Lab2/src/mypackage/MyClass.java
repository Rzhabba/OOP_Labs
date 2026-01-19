package mypackage;

import java.awt.FlowLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyClass {
    public static void main(String[] args) {
        // Счётчики каждого вида
        final int[] classicCount = {0};
        final int[] goseCount = {0};
        final int[] stoutCount = {0};
        final int[] sourCount = {0};

        // Метки для счётчиков напитков
        final JLabel classicLabel = new JLabel("0");
        final JLabel goseLabel = new JLabel("0");
        final JLabel stoutLabel = new JLabel("0");
        final JLabel sourLabel = new JLabel("0");

        // Метки для итогов
 //!!!!!!VOLUME- ЦЕНА, А НЕ ОБЪЕМ, ЗАПОМНИТЬ!!!!!!!!!
        
        final JLabel totalKegsLabel = new JLabel("Количество кег: 0");
        final JLabel totalVolumeLabel = new JLabel("Общая стоимость: 0 р");

        // Создаём окно
        JFrame frame = new JFrame("Ценник заявки");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 500);
        frame.setLocation(350, 150);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 12));

        // Функция обновления всех итогов
        Runnable updateTotals = () -> {
            int totalKegs = classicCount[0] + goseCount[0] + stoutCount[0] + sourCount[0];
            totalKegsLabel.setText("Количество кег: " + totalKegs);
        };

        //Классика/Пшено
        JButton classicPlus = new JButton("Классика/Пшено (+)");
        JButton classicMinus = new JButton("–");
        classicPlus.addActionListener(e -> {
            classicCount[0]++;
            classicLabel.setText(String.valueOf(classicCount[0]));
            updateTotals.run();
        });
        classicMinus.addActionListener(e -> {
        	//отработка отрицательного значения
            if (classicCount[0] > 0) {
                classicCount[0]--;
                classicLabel.setText(String.valueOf(classicCount[0]));
                updateTotals.run();
            }
        });

        //Гозе
        JButton gosePlus = new JButton("Гозе (+)");
        JButton goseMinus = new JButton("–");
        gosePlus.addActionListener(e -> {
            goseCount[0]++;
            goseLabel.setText(String.valueOf(goseCount[0]));
            updateTotals.run();
        });
        goseMinus.addActionListener(e -> {
        	//отработка отрицательного значения
            if (goseCount[0] > 0) {
                goseCount[0]--;
                goseLabel.setText(String.valueOf(goseCount[0]));
                updateTotals.run();
            }
        });

        //Темное
        JButton stoutPlus = new JButton("Темное (+)");
        JButton stoutMinus = new JButton("–");
        stoutPlus.addActionListener(e -> {
            stoutCount[0]++;
            stoutLabel.setText(String.valueOf(stoutCount[0]));
            updateTotals.run();
        });
        stoutMinus.addActionListener(e -> {
        	//отработка отрицательного значения
            if (stoutCount[0] > 0) {
                stoutCount[0]--;
                stoutLabel.setText(String.valueOf(stoutCount[0]));
                updateTotals.run();
            }
        });

        //Саур
        JButton sourPlus = new JButton("Саур (+)");
        JButton sourMinus = new JButton("–");
        sourPlus.addActionListener(e -> {
            sourCount[0]++;
            sourLabel.setText(String.valueOf(sourCount[0]));
            updateTotals.run();
        });
        sourMinus.addActionListener(e -> {
        	//отработка отрицательного значения
            if (sourCount[0] > 0) {
                sourCount[0]--;
                sourLabel.setText(String.valueOf(sourCount[0]));
                updateTotals.run();
            }
        });

        // Кнопка "Рассчитать стоимость"
//!!!!!!VOLUME- ЦЕНА, А НЕ ОБЪЕМ, ЗАПОМНИТЬ!!!!!!!!!
        JButton calcVolumeButton = new JButton("Стоимость");
        calcVolumeButton.addActionListener(e -> {
            int totalKegs = classicCount[0] + goseCount[0] + stoutCount[0] + sourCount[0];
            long totalVolumeMl = (long) totalKegs * 10240; // цена за 1 кегу
            totalVolumeLabel.setText("Общая стоимость: " + totalVolumeMl + " р");
        });

        // Кнопка "Сбросить всё"
        JButton resetButton = new JButton("Сбросить всё");
        resetButton.addActionListener(e -> {
            classicCount[0] = 0;
            goseCount[0] = 0;
            stoutCount[0] = 0;
            sourCount[0] = 0;

            classicLabel.setText("0");
            goseLabel.setText("0");
            stoutLabel.setText("0");
            sourLabel.setText("0");

            totalKegsLabel.setText("Количество кег: 0");
            totalVolumeLabel.setText("На сумму: 0 р");
        });

        // Собираем итоговое окно
        frame.add(classicPlus);
        frame.add(classicMinus);
        frame.add(new JLabel("Классика:"));
        frame.add(classicLabel);

        frame.add(gosePlus);
        frame.add(goseMinus);
        frame.add(new JLabel("Гозе:"));
        frame.add(goseLabel);

        frame.add(stoutPlus);
        frame.add(stoutMinus);
        frame.add(new JLabel("Темное:"));
        frame.add(stoutLabel);

        frame.add(sourPlus);
        frame.add(sourMinus);
        frame.add(new JLabel("Саур:"));
        frame.add(sourLabel);

        frame.add(totalKegsLabel);
        frame.add(calcVolumeButton);
        frame.add(totalVolumeLabel);
        frame.add(resetButton);

        frame.setVisible(true);
    }
}