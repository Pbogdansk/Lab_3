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

}
