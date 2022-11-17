package Model;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {


    private String[] columnNames = {"Imie", "nazwisko", "grupa", "numer albumu", "rok urodzenia", "status"};
    private Object[][] data = {{"blada", "krzywy", "chujowa", "2137", "2003", "chujowy"},{"blada", "krzywy", "chujowa", "2137", "2003", "chujowy"},{"blada", "krzywy", "chujowa", "2137", "2003", "chujowy"},{"blada", "krzywy", "chujowa", "2137", "2003", "chujowy"}};


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
