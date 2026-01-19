package mypackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyClass {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Практическое задание 4");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 1, 10, 10));
        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null);

        // Задание 1 — выбор из списка
        String[] countries = {"Россия", "Германия", "Япония", "Бразилия"};
        JComboBox<String> comboBox = new JComboBox<>(countries);
        JLabel comboLabel = new JLabel("Выберите страну:");
        JPanel comboPanel = new JPanel(new FlowLayout());
        comboPanel.add(comboLabel);
        comboPanel.add(comboBox);

        // Слушатель для задания 1
        comboBox.addActionListener(e -> {
            String selected = (String) comboBox.getSelectedItem();
            JOptionPane.showMessageDialog(frame, "Вы выбрали: " + selected);
        });

        // Задание 2 — Выбор (галочкой)
        JCheckBox checkBox = new JCheckBox("Согласен с условиями");
        JPanel checkPanel = new JPanel(new FlowLayout());
        checkPanel.add(checkBox);

        // Слушатель для задания 2 -выбираются оба варианта сразу. Не понимаю, где ошибка
        checkBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                JOptionPane.showMessageDialog(frame, "Вы согласились с условиями.");
            } else {
                JOptionPane.showMessageDialog(frame, "Вы отказались от условий.");
            }
        });

        // Задание 3 - размер строки
        JTextField textField = new JTextField(20);
        JLabel textLabel = new JLabel("Введите текст:");
        JLabel lengthLabel = new JLabel("Длина: —");
        JPanel textPanel = new JPanel(new FlowLayout());
        textPanel.add(textLabel);
        textPanel.add(textField);
        textPanel.add(lengthLabel);

        // Слушатель для задания 3
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String text = textField.getText();
                String category;
                if (text.length() <= 5) {
                    category = "Короткая";
                } else if (text.length() <= 10) {
                    category = "Нормальная";
                } else {
                    category = "Длинная";
                }
                lengthLabel.setText("Длина: " + category);
            }
        });

        // Добавляем панели в окно
        frame.add(comboPanel);
        frame.add(checkPanel);
        frame.add(textPanel);
        frame.add(new JLabel("Наберите текст в поле выше- определим размер строки."));

        frame.setVisible(true);
    }
}