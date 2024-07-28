package TextEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class SimpleTextEditor extends JFrame implements ActionListener {
    // Components of the text editor
    JTextArea textArea;
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenuItem newItem, openItem, saveItem, exitItem;

    // Constructor to setup the GUI components
    public SimpleTextEditor() {
        // Set the title of the window
        setTitle("Simple Text Editor");

        // Initialize the text area
        textArea = new JTextArea();

        // Create a scroll pane for the text area
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // Initialize the menu bar
        menuBar = new JMenuBar();

        // Initialize the "File" menu
        fileMenu = new JMenu("File");

        // Initialize menu items
        newItem = new JMenuItem("New");
        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");

        // Add action listeners to the menu items
        newItem.addActionListener(this);
        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

        // Add menu items to the "File" menu
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        // Add "File" menu to the menu bar
        menuBar.add(fileMenu);

        // Set the menu bar for the frame
        setJMenuBar(menuBar);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the size of the window
        setSize(600, 400);

        // Make the window visible
        setVisible(true);
    }

    // Implement the actionPerformed method
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "New":
                textArea.setText("");
                break;
            case "Open":
                openFile();
                break;
            case "Save":
                saveFile();
                break;
            case "Exit":
                System.exit(0);
                break;
        }
    }

    // Method to open a file
    private void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                textArea.read(reader, null);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error opening file: " + ex.getMessage());
            }
        }
    }

    // Method to save a file
    private void saveFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                textArea.write(writer);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage());
            }
        }
    }

    // Main method to launch the text editor
    public static void main(String[] args) {
        new SimpleTextEditor();
    }
}
