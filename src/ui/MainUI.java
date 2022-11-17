package ui;

import Classes.ClassContainer;
import Classes.MyClass;
import Model.MyClassTableModel;
import Model.MyTableModel;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainUI {
    private JPanel rootPanel;
    private JTable mainTable;
    private JComboBox classNamesComboBox;
    private JButton editButton;
    private JScrollPane szkulka;
    private JButton addGroup;
    private JTextField textField1;
    private JTextField className;
    private JTextField maxStudents;
    private JTable classTable;

    public JPanel getRootPanel(){
        return rootPanel;

    }

    ArrayList<MyClass> groups = new ArrayList<MyClass>();
    public MainUI(){
        Student student = new Student("Piotr", "Nowak","najebany",2001, 0.1);
        Student student2 = new Student("Pir", "Nowak","najebany",2001, 0.1);
        Student student3 = new Student("Piotr", "Nok","najeby",2001, 0.1);
        student.print();

        MyClass klasa1 = new MyClass("Pedały", 4);
        MyClass klasa2 = new MyClass("Cipki", 4);
        MyClass klasa3 = new MyClass("Gżybioże", 4);
        ClassContainer classContainer = new ClassContainer();
        classContainer.addClass(klasa1);
        classContainer.addClass(klasa2);
        classContainer.addClass(klasa3);
        String[] classNames =new String[]{klasa1.groupName, klasa2.groupName, klasa3.groupName};
        classNamesComboBox.setModel(new DefaultComboBoxModel(classContainer.grupy.values().toArray()));

        klasa1.addStudent(student);
        klasa1.addStudent(student2);
        klasa1.addStudent(student3);
        student.print();

        classTable.setModel(new MyClassTableModel(klasa1.getClassStudents()));

        mainTable.setModel(new MyTableModel());
        mainTable.setAutoCreateRowSorter(true);
       // mainTable.setModel(new MyClassTableModel(groups));
        TableColumn sportColumn = mainTable.getColumnModel().getColumn(5);
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("obecny");
        comboBox.addItem("nieobecny");
        comboBox.addItem("odrabiający");
        sportColumn.setCellEditor(new DefaultCellEditor(comboBox));


        addGroup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = className.getText();
                Integer max = Integer.parseInt(maxStudents.getText());

                MyClass newClass = new MyClass(name, max);
                groups.add(newClass);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
