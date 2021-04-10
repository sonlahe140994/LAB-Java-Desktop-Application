/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.undo.UndoManager;
import view.MyTextEditorGUI;

/**
 *
 * @author admin
 */
public class controller_MyTextEditor {

    //declare
    //GUI
    MyTextEditorGUI textEditorGUI;
    FindController findController;
    ReplaceController replaceController;
    FontChangedController fontChangedController;

    //JMenuitem
    JMenuItem newItem;
    JMenuItem openItem;
    JMenuItem saveItem;
    JMenuItem saveAsItem;
    JMenuItem exitItem;
    JMenuItem selectAllItem;
    JMenuItem cutItem;
    JMenuItem copyItem;
    JMenuItem pasteItem;
    JMenuItem undoItem;
    JMenuItem redoItem;
    JMenuItem findItem;
    JMenuItem replaceItem;
    JMenuItem changeFontItem;

    //JTextArea
    JTextArea textArea;

    //EventAction
    ActionListener newItemListener;
    ActionListener openItemListener;
    ActionListener saveItemListener;
    ActionListener saveAsItemListener;
    ActionListener exitItemListener;
    ActionListener selectAllItemListener;
    ActionListener cutItemListener;
    ActionListener copyItemListener;
    ActionListener pasteItemListener;
    ActionListener undoItemListener;
    ActionListener redoItemListener;
    ActionListener findItemListener;
    ActionListener replaceItemListener;
    ActionListener changeFontItemListener;

    WindowAdapter windowAdapter;
    boolean isDefaultDocument = true;
    boolean isSave = true;
    File fileOpening = null;

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }

    UndoManager undoManager = new UndoManager();
    DocumentListener documentListener; //using to receving notification of changes to a text document
    final FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Document", "txt");
    JFileChooser fileChooser = new JFileChooser();

    final String fileDefaultName = "MTEText";

    Transferable transferable;
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    Thread checkSaveThread;

    public controller_MyTextEditor() {
        initComponents();
        initTextAreaActionPerform();
        initThread();
        initEvent();
        textEditorGUI.setVisible(true);

    }

    private void initComponents() {
        //ConnectGUI
        textEditorGUI = new MyTextEditorGUI();
        //MenuItem
        newItem = textEditorGUI.getNewItem();
        openItem = textEditorGUI.getOpenItem();
        saveItem = textEditorGUI.getSaveItem();
        saveAsItem = textEditorGUI.getSaveAsItem();
        exitItem = textEditorGUI.getExitItem();
        selectAllItem = textEditorGUI.getSlectAllItem();
        cutItem = textEditorGUI.getCutItem();
        copyItem = textEditorGUI.getCopyItem();
        pasteItem = textEditorGUI.getPasteItem();
        undoItem = textEditorGUI.getUndoItem();
        redoItem = textEditorGUI.getRedoItem();
        findItem = textEditorGUI.getFindItem();
        replaceItem = textEditorGUI.getReplaceItem();
        changeFontItem = textEditorGUI.getChangeFontItem();
        //TextArea
        textArea = textEditorGUI.getjTextArea1();
        //File chooser
        fileChooser = textEditorGUI.getFilleChoose();
        fileChooser.setFileFilter(new FileNameExtensionFilter(".txt", "txt"));
    }

    private void initEvent() {
        //function of item
        newItemListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkSaveFile()) {//check if file have been saved or file is new file of Document
                    newDefaultDocument();
                } else {
                    if (saveOption()) {//if yes option to saving file
                        if (isDefaultDocument) {
                            saveAsDocument();
                        } else {
                            saveCurrentDocument();
                        }
                        newDefaultDocument();
                    } else {
                        newDefaultDocument();
                    }
                }
            }
        };
        openItemListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkSaveFile()) {
                    System.out.println("Duoc mo file luon");
                    openFileInDocument();
                } else {
                    System.out.println("Khong duoc mo file luon");
                    if (saveOption()) {
                        if (isDefaultDocument) {
                            System.out.println("Default Document");
                            saveAsDocument();
                        }
                        if (!isDefaultDocument && !isSave) {
                            System.out.println("khong phai default va khong save");
                            saveCurrentDocument();
                        }
                        System.out.println("OpenFile");
                        openFileInDocument();
                    } else {
                        System.out.println("Nguoi dung khong luu");
                        openFileInDocument();
                    }
                }

            }

        };
        saveItemListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((isSave && isDefaultDocument) || (isDefaultDocument && !isSave)) {
                    System.out.println("File moi chua duoc luu");
                    saveAsDocument();
                } else if (!isDefaultDocument && isSave) {
                    System.out.println("Khong phai File Default va da luu roi");
                    return;
                } else if (!isDefaultDocument && !isSave) {
                    System.out.println("Khong phai file Default va chua luu");
                    saveCurrentDocument();

                }
            }
        };

        saveAsItemListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Save as cho tat ca cac file");
                saveAsDocument();
            }
        };
        exitItemListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closingEvent();
            }

        };

        selectAllItemListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.selectAll();
            }
        };
        cutItemListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.cut();
            }
        };
        copyItemListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.copy();
            }
        };
        pasteItemListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.paste();
            }
        };
        undoItemListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                undoManager.undo();
            }
        };
        redoItemListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                undoManager.redo();
            }
        };
        findItemListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findController = new FindController(textEditorGUI, true, textArea);
            }
        };
        replaceItemListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                replaceController = new ReplaceController(textEditorGUI, true, textArea);
            }
        };
        changeFontItemListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fontChangedController = new FontChangedController(textEditorGUI,textArea);
            }
        };

        windowAdapter = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closingEvent();
            }
        };
        //add event to item
        newItem.addActionListener(newItemListener);
        openItem.addActionListener(openItemListener);
        saveItem.addActionListener(saveItemListener);
        saveAsItem.addActionListener(saveAsItemListener);
        exitItem.addActionListener(exitItemListener);
        selectAllItem.addActionListener(selectAllItemListener);
        cutItem.addActionListener(cutItemListener);
        copyItem.addActionListener(copyItemListener);
        pasteItem.addActionListener(pasteItemListener);
        undoItem.addActionListener(undoItemListener);
        redoItem.addActionListener(redoItemListener);
        findItem.addActionListener(findItemListener);
        replaceItem.addActionListener(replaceItemListener);
        changeFontItem.addActionListener(changeFontItemListener);
        textEditorGUI.addWindowListener(windowAdapter);
    }

    private void initTextAreaActionPerform() {
        undoManager = new UndoManager();
        textArea.getDocument().addUndoableEditListener(undoManager);
        documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                System.out.println("Nhap");
                isSave = false;
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                System.out.println("Xoa");
                isSave = false;
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                isSave = false;
            }
        };
        textArea.getDocument().addDocumentListener(documentListener);
    }

    private void initThread() {
        checkSaveThread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (textArea.getText().isEmpty()) {
                        selectAllItem.setEnabled(false);
                        findItem.setEnabled(false);
                        replaceItem.setEnabled(false);
                    } else {
                        selectAllItem.setEnabled(true);
                        findItem.setEnabled(true);
                        replaceItem.setEnabled(true);
                    }
                    if (textArea.getSelectionStart() == textArea.getSelectionEnd()) {
                        copyItem.setEnabled(false);
                        cutItem.setEnabled(false);
                    } else {
                        copyItem.setEnabled(true);
                        cutItem.setEnabled(true);
                    }
                    if (checkTransferable()) {
                        pasteItem.setEnabled(true);
                    } else {
                        pasteItem.setEnabled(false);
                    }
                    if (undoManager.canRedo()) {
                        redoItem.setEnabled(true);
                    } else {
                        redoItem.setEnabled(false);
                    }
                    if (undoManager.canUndo()) {
                        undoItem.setEnabled(true);
                    } else {
                        undoItem.setEnabled(false);
                    }
                    if (textArea.getSelectionStart() == textArea.getSelectionEnd()) {
                        copyItem.setEnabled(false);
                        cutItem.setEnabled(false);
                    } else {
                        cutItem.setEnabled(false);
                        copyItem.setEnabled(true);
                    }

                }
            }
        };
        checkSaveThread.start();
    }

    private boolean checkTransferable() {
        try {
            transferable = clipboard.getContents(this);
            if (transferable != null && transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }

        return false;
    }

    private void newDefaultDocument() {
        textEditorGUI.setTitle(fileDefaultName);
        textArea.setText("");
        isSave = true;
        isDefaultDocument = true;
        fileOpening = null;
    }

    private boolean checkSaveFile() {
        //if file opening  Default Document and text area is empty
        if (isDefaultDocument && textArea.getText().isEmpty()) {
            System.out.println("file Default Document va text trong");
            return true;
        } //if file opening is not Default Document and file is saved
        if (!isDefaultDocument && isSave) {
            System.out.println("file khong phai Default Document va da luu");
            return true;
        }

        return false;
    }

    private boolean saveOption() {
        System.out.println("Checkoption lan 1");
        int option = JOptionPane.showConfirmDialog(textArea, "Do you want to save this file", "File no saving", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (option == JOptionPane.YES_OPTION) {
            return true;
        }
        return false;
    }

    private void saveCurrentDocument() {
        writeDataToFile(fileOpening);
        JOptionPane.showMessageDialog(textEditorGUI, "File Saved");
    }

    private boolean replaceOption(File file) {
        int value = JOptionPane.showConfirmDialog(textEditorGUI, "File " + file.getName() + " already exits\nDo you want to replace it?", "File have been exits?", JOptionPane.YES_NO_OPTION);
        if (value == JOptionPane.YES_OPTION) {
            return true;
        }
        return false;
    }

    private void writeDataToFile(File file) {
        try {
            textArea.write(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
            isSave = true;
        } catch (IOException e) {
            System.out.println("writerDataToFile\n" + e.getMessage());
        }
    }

    private File readDataFromFile(File file) {
        try {
            textArea.read(new InputStreamReader(new FileInputStream(file), "UTF-8"), file);
            return file;
        } catch (IOException e) {
            System.out.println("readDataFromFile " + e.getMessage());
        }
        return null;
    }

    private void saveAsDocument() {
        if (isDefaultDocument) {
            fileChooser.setSelectedFile(new File("MTEText.txt"));
        } else {
            fileChooser.setSelectedFile(new File(fileOpening.getName()));
        }
        int optionSelectFile = fileChooser.showSaveDialog(textEditorGUI);
        while (optionSelectFile == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            file = formatFile(file);
            if (file.exists()) {
                if (!replaceOption(file)) {
                    optionSelectFile = fileChooser.showSaveDialog(textEditorGUI);
                    continue;
                }
            }
            writeDataToFile(file);
            fileOpening = readDataFromFile(file);
            isSave = true;
            textEditorGUI.setTitle(fileOpening.getName());
            initTextAreaActionPerform();
            JOptionPane.showMessageDialog(textEditorGUI, "File Saved");
            break;
        }

    }

    private File formatFile(File file) {
        if (!file.getName().toLowerCase().endsWith(".txt")) {
            file = new File(file.getParentFile(), file.getName() + ".txt");
        }
        return file;
    }

    private void openFileInDocument() {

        int optionOpenValues = fileChooser.showOpenDialog(textEditorGUI);
        while (optionOpenValues == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            file = formatFile(file);
            if (file.exists()) {
                fileOpening = readDataFromFile(file);
                textEditorGUI.setTitle(fileOpening.getName());
                isDefaultDocument = false;
                isSave = true;
                initTextAreaActionPerform();
                return;
            } else {
                JOptionPane.showMessageDialog(textEditorGUI, "File not Found!!!");
                optionOpenValues = fileChooser.showOpenDialog(textEditorGUI);
            }
        }
    }

    private void closingEvent() {
        if ((isSave && !isDefaultDocument) || (isSave && isDefaultDocument)) {
            System.out.println("Tat ca cac file da save(Bao gom Documents)");
            System.exit(0);
        } else {
            System.out.println("File chua duoc luu");
            if (saveOption()) {
                if (isDefaultDocument) {
                    saveAsDocument();
                } else {
                    saveCurrentDocument();
                }
                System.exit(0);
            } else {
                System.exit(0);
            }
        }
    }
}
