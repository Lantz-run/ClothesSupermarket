package com.Lantz.utils;

import java.util.ArrayList;
import java.util.List;

public class ConsoleTable {
    private List<String[]> rows;
    private int[] columnWidths;

    private boolean printHeader = false;



    public ConsoleTable(int numColumns, boolean printHeader) {
        this.printHeader = printHeader;
        rows = new ArrayList<>();
        this.columnWidths = new int[numColumns];

    }

    public void addRow(Object... values) {
        String[] strings = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            strings[i] = String.valueOf(values[i]);
            if (strings[i].length() > columnWidths[i]) {
                columnWidths[i] = strings[i].length();
            }
        }
        rows.add(strings);
    }

    public void print() {
        int totalWidth = 0;
        for (int width : columnWidths) {
            totalWidth += width;
        }
        totalWidth += columnWidths.length * 10; // Add spacing between columns

        // Print table header
        printLine(totalWidth);
        for (int i = 0; i < columnWidths.length; i++) {
            System.out.print("| " + centerText(rows.get(0)[i], columnWidths[i]) + " ");
        }
        System.out.println("|");
        printLine(totalWidth);

        // Print table rows
        for (int i = 1; i < rows.size(); i++) {
            for (int j = 0; j < columnWidths.length; j++) {
                System.out.print("| " + leftAlignText(rows.get(i)[j], columnWidths[j]) + " ");
            }
            System.out.println("|");
        }
        printLine(totalWidth);
    }

    @Override
    public String toString() {
        StringBuilder tableString = new StringBuilder();
        int totalWidth = 0;

        // Calculate total width and build the table string
        for (int width : columnWidths) {
            totalWidth += width;
        }
        totalWidth += columnWidths.length * 10; // Add spacing between columns

        // Build table header
        tableString.append("\n");
        tableString.append(printLine(totalWidth)); // Use printLine to add the line
        for (int i = 0; i < columnWidths.length; i++) {
            tableString.append("| ").append(centerText(rows.get(0)[i], columnWidths[i])).append(" ");
        }
        tableString.append("|\n");

        // Build table rows
        for (int i = 1; i < rows.size(); i++) {
            for (int j = 0; j < columnWidths.length; j++) {
                String cellValue = rows.get(i)[j];
                int cellWidth = columnWidths[j];
                if (cellValue.length() > cellWidth) {
                    cellValue = cellValue.substring(0, cellWidth); // Trim cell text if it's too long
                }
                tableString.append("| ").append(leftAlignText(cellValue, cellWidth)).append(" ");
            }
            tableString.append("|\n");
        }

        tableString.append(printLine(totalWidth)); // Use printLine to add the line

        return tableString.toString();
    }


    private String printLine(int width) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < width; i++) {
            line.append("-");
        }
        line.append("\n");
        return line.toString();
    }


    private String centerText(String text, int width) {
        return String.format("%-" + width + "s", String.format("%" + (width + (text.length() - width) / 2) + "s", text));
    }

    private String leftAlignText(String text, int width) {
        return String.format("%-" + width + "s", text);
    }

    public static void main(String[] args) {
        ConsoleTable table = new ConsoleTable(3, true);
        table.addRow("Header 1", "Header 2", "Header 3");
        table.addRow("Value 1", "Value 2", "Value 3");
        table.addRow("Longer Value 1", "Value 2", "Value 3");
        table.addRow("Longer Value 1", "Value 2", "Value 3");


        table.print();
    }
}
