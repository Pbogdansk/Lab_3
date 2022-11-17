package ui;

import Classes.ClassContainer;
import Classes.MyClass;
import Model.MyClassTableModel;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class MainUI {
    private JPanel rootPanel;
    private JComboBox classNamesComboBox;
    private JButton addGroup;
    private JTextField className;
    private JTextField maxStudents;
    private JTable classTable;
    private JTextField studentName;
    private JTextField studentLastName;
    private JComboBox conditionComboBox;
    private JTextField birthAtField;
    private JTextField points;
    private JButton dodajStudentaButton;
    private JComboBox nazwaKlasy;
    private JButton usunStudentaButton;

    public JPanel getRootPanel(){
        return rootPanel;

    }
    ArrayList<MyClass> groups = new ArrayList<MyClass>();
    public MainUI(){
        Student student = new Student("Maciej", "Nowak","Nieobecny",2001, 0.1);
        Student student2 = new Student("Michał", "Fila","Nieobecny",2001, 0.1);
        Student student3 = new Student("Wołga", "Moskwa","Nieobecny",2001, 0.1);
        student.print();

        MyClass klasa1 = new MyClass("Klasa A", 4);
        MyClass klasa2 = new MyClass("Klasa B", 4);
        MyClass klasa3 = new MyClass("Klasa C", 4);
        ClassContainer classContainer = new ClassContainer();
        classContainer.addClass(klasa1);
        classContainer.addClass(klasa2);
        classContainer.addClass(klasa3);
//        String[] classNames =new String[]{klasa1.groupName, klasa2.groupName, klasa3.groupName};
        String[] condition = {"Obecny", "Nieobecny", "Spóźnienie"};
        classNamesComboBox.setModel(new DefaultComboBoxModel(classContainer.grupy.keySet().toArray(new String[0])));
        nazwaKlasy.setModel(new DefaultComboBoxModel(classContainer.grupy.keySet().toArray(new String[0])));

        klasa1.addStudent(student);
        klasa1.addStudent(student2);
        klasa1.addStudent(student3);
        student.print();

        classTable.setModel(new MyClassTableModel(classContainer.grupy.get(classNamesComboBox.getSelectedItem()).getClassStudents()));
        classTable.setAutoCreateRowSorter(true);
        TableColumn sportColumn = classTable.getColumnModel().getColumn(2);
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Nieobecny");
        comboBox.addItem("Obecny");
        comboBox.addItem("Spóźnienie");
        sportColumn.setCellEditor(new DefaultCellEditor(comboBox));
        conditionComboBox.setModel(new DefaultComboBoxModel(condition));

        addGroup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = className.getText();
                Integer max = Integer.parseInt(maxStudents.getText());

                MyClass newClass = new MyClass(name, max);
                groups.add(newClass);
            }
        });
        addGroup.addActionListener(e -> {
            MyClass myClass = new MyClass(className.getText(),Integer.parseInt(maxStudents.getText()));
            classContainer.addClass(myClass);
            classNamesComboBox.setModel(new DefaultComboBoxModel(classContainer.grupy.keySet().toArray(new String[0])));
            nazwaKlasy.setModel(new DefaultComboBoxModel(classContainer.grupy.keySet().toArray(new String[0])));
        });
        dodajStudentaButton.addActionListener(e -> {
            try{
                Student s = new Student(studentName.getText(), studentLastName.getText(), conditionComboBox.getSelectedItem().toString(), Integer.parseInt(birthAtField.getText()), Integer.parseInt(points.getText()));
                String nKlasy = (String) nazwaKlasy.getSelectedItem();
                classContainer.grupy.get(nKlasy).addStudent(s);
                classTable.setModel(new MyClassTableModel(classContainer.grupy.get(classNamesComboBox.getSelectedItem()).getClassStudents()));
            }catch (NumberFormatException exception){
                JOptionPane.showMessageDialog(null,
                        "Sprawdź format danych",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        });
        classNamesComboBox.addActionListener(e -> {
            classTable.setModel(new MyClassTableModel(classContainer.grupy.get(classNamesComboBox.getSelectedItem()).getClassStudents()));
        });
        usunStudentaButton.addActionListener(e -> {
            try{
                String imie = (String) classTable.getValueAt(classTable.getSelectedRow(), 0);
                String nazwisko = (String) classTable.getValueAt(classTable.getSelectedRow(), 1);
                classContainer.grupy.get(classNamesComboBox.getSelectedItem()).removeStudent(imie, nazwisko);

                classTable.setModel(new MyClassTableModel(classContainer.grupy.get(classNamesComboBox.getSelectedItem()).getClassStudents()));

            }catch (ConcurrentModificationException err){
                System.out.print("");
            }
        });
    }
}
