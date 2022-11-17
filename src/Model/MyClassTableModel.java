package Model;

import Classes.MyClass;
import ui.Student;

import javax.swing.table.AbstractTableModel;

public class MyClassTableModel extends AbstractTableModel {
    private String[] columnNames = {"Imie", "nazwisko",  "status", "rok urodzenia", "punkty"};


    private Object[][] data;

    public MyClassTableModel(Object[][] data) {
        this.data = data;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public boolean isCellEditable(int row, int col) {
        if (col > 0 && row > 0) {
            return true;
        }
        return true;
    }

    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }

    public static void main(String[] args) {
        Student student = new Student("Piotr", "Nowak","najebany",2001, 0.1);
        Student student2 = new Student("Pir", "Nowak","najebany",2001, 0.1);
        Student student3 = new Student("Piotr", "Nok","najeby",2001, 0.1);
        student.print();

        MyClass klasa1 = new MyClass("Pedały", 4);
        klasa1.addStudent(student);
        klasa1.addStudent(student2);
        klasa1.addStudent(student3);
        student.print();

    }

}
