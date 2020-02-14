/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoplink;

import java.awt.Adjustable;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.BadLocationException;

/**
 *
 * @author Mathew
 */
public class AutoPlink extends javax.swing.JFrame {

    /**
     * Creates new form AutoPlink
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     */
    DefaultListModel defaultListModelFilteredItems = new DefaultListModel();
    File pathWorkingDirectory = new File(System.getProperty("user.dir"));
    File pathDesktop = new File(System.getProperty("user.home"), "Desktop");
    String pathUserProfile = System.getenv("USERPROFILE");
    File pathLogging = new File(pathDesktop + "\\Logging-Output\\AutoPlink");
    String strPathLoggingFolder = pathDesktop + "\\Logging-Output\\AutoPlink";    
    String strPathLaunchPadFolder = System.getenv("SYSTEMDRIVE") + "\\LaunchPad";
    String strPathAutoPlinkFolder = strPathLaunchPadFolder + "\\Java Apps\\AutoPlink";
    String strPathDeviceGroupFolder = strPathAutoPlinkFolder + "\\DeviceGroups";
    String strPathDeviceSingleFolder = strPathAutoPlinkFolder + "\\DeviceSingle";
    String strPathDeviceSingleFile = strPathDeviceSingleFolder + "\\SingleDevice.txt";    
    String strPathCommandGroupFolder = strPathAutoPlinkFolder + "\\CommandGroups";
    String strPathCommandSingleFolder = strPathAutoPlinkFolder + "\\CommandSingle";
    String strPathCommandSingleFile = strPathCommandSingleFolder + "\\SingleCommand.txt";    
    String strCommandListDefault = strPathAutoPlinkFolder + "\\CommandList.csv";
    //- Get date and time
    SimpleDateFormat simpleDateFormat  = new SimpleDateFormat("yyyyMMdd_HHmm-ssSSS");
    String dateTime = simpleDateFormat.format(new Date());    
    
    //- Plink
    String strPlinkexe = pathWorkingDirectory + "\\plink.exe";

    
    public AutoPlink() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, FileNotFoundException, URISyntaxException {
        initComponents();
        initFolders();
        getCommandList();
        getDeviceGroupList();
        setGUILookAndFeel();
        jComboBoxCommandGroup.setEnabled(false);
        jButtonEditCommandGroup.setEnabled(false);
//        class ValidateThread implements Runnable {
//    @Override
//    public void run() {
//        validate();
//    }
//}
//
//jButtonGo.addActionListener(new ActionListener() {
//    @Override
//    public void actionPerformed(ActionEvent ae) {
//        // Some code checked on some radio buttons
//               Runnable runnable = new ValidateThread();
//               Thread thread = new Thread(runnable);
//               thread.start();
//    }
//
//});

    }
    
    private void initFolders () {
        //--- Create folders
        new File(strPathLaunchPadFolder).mkdirs();
        new File(strPathLoggingFolder).mkdirs();
        new File(strPathAutoPlinkFolder).mkdirs();        
        new File(strPathDeviceGroupFolder).mkdirs();
        new File(strPathCommandGroupFolder).mkdirs();
        new File(strPathDeviceSingleFolder).mkdirs();
    }
    
    private void setGUILookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.put("Button.disabledText", new Color(150,150,150));
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(AutoPlink.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void addToLogWindow(String strLogLine) {
            try {
                jTextPaneLog.getDocument().insertString(jTextPaneLog.getDocument().getEndPosition().getOffset(),strLogLine + "\n", null);
            } catch (BadLocationException ex) {
                Logger.getLogger(AutoPlink.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(strLogLine);
            //- Scroll to bottom
            scrollToBottom(jScrollPaneLog);
            //jScrollPaneLog.update(jScrollPaneLog.getGraphics());            
            jTextPaneLog.update(jTextPaneLog.getGraphics());
            scrollToBottom(jScrollPaneLog);    
    }
    
    private void scrollToBottom(JScrollPane scrollPane) {
        JScrollBar verticalBar = scrollPane.getVerticalScrollBar();
        AdjustmentListener downScroller = new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                Adjustable adjustable = e.getAdjustable();
                adjustable.setValue(adjustable.getMaximum());
                verticalBar.removeAdjustmentListener(this);
            }
        };
        verticalBar.addAdjustmentListener(downScroller);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupCommandType = new javax.swing.ButtonGroup();
        buttonGroupDeviceType = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jTextFieldCommandToRun = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldUsername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxDeviceGroup = new javax.swing.JComboBox<>();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jCheckBoxVerbose = new javax.swing.JCheckBox();
        jButtonGo = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxCommandGroup = new javax.swing.JComboBox<>();
        jRadioButtonCommandTypeSingle = new javax.swing.JRadioButton();
        jRadioButtonCommandTypeGroup = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jButtonEditDeviceGroup = new javax.swing.JButton();
        jButtonEditCommandGroup = new javax.swing.JButton();
        jRadioButtonDeviceTypeSingle = new javax.swing.JRadioButton();
        jRadioButtonDeviceTypeGroup = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldDeviceSingle = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButtonEditDeviceGroup1 = new javax.swing.JButton();
        jCheckBoxAcceptKeys = new javax.swing.JCheckBox();
        jCheckBoxSaveConfig = new javax.swing.JCheckBox();
        jScrollPaneLog = new javax.swing.JScrollPane();
        jTextPaneLog = new javax.swing.JTextPane();
        jTextFieldCommandFilter = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AutoPlink");
        setSize(new java.awt.Dimension(451, 407));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jList1.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jTextFieldCommandToRun.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        jTextFieldCommandToRun.setText("show version | i ptime");

        jLabel1.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Command:");

        jLabel2.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Username:");

        jLabel3.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Password:");

        jTextFieldUsername.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        jTextFieldUsername.setText("admin");

        jLabel4.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Device Group:");

        jComboBoxDeviceGroup.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        jComboBoxDeviceGroup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "switches.txt", "routers.txt" }));
        jComboBoxDeviceGroup.setEnabled(false);

        jPasswordField1.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        jPasswordField1.setText("cisco");

        jButton1.setBackground(new java.awt.Color(255, 233, 162));
        jButton1.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        jButton1.setText("Device Groups");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 233, 162));
        jButton2.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        jButton2.setText("Output Folder");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jCheckBoxVerbose.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        jCheckBoxVerbose.setText("Verbose");
        jCheckBoxVerbose.setToolTipText("");

        jButtonGo.setBackground(new java.awt.Color(200, 255, 153));
        jButtonGo.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        jButtonGo.setText("Go");
        jButtonGo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Command Group:");
        jLabel5.setEnabled(false);

        jComboBoxCommandGroup.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        jComboBoxCommandGroup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxCommandGroup.setEnabled(false);

        buttonGroupCommandType.add(jRadioButtonCommandTypeSingle);
        jRadioButtonCommandTypeSingle.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        jRadioButtonCommandTypeSingle.setSelected(true);
        jRadioButtonCommandTypeSingle.setText("Single");
        jRadioButtonCommandTypeSingle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jRadioButtonCommandTypeSingle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCommandTypeSingleActionPerformed(evt);
            }
        });

        buttonGroupCommandType.add(jRadioButtonCommandTypeGroup);
        jRadioButtonCommandTypeGroup.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        jRadioButtonCommandTypeGroup.setText("Group");
        jRadioButtonCommandTypeGroup.setEnabled(false);
        jRadioButtonCommandTypeGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCommandTypeGroupActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Command Type:");

        jButtonEditDeviceGroup.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        jButtonEditDeviceGroup.setText("Edit");
        jButtonEditDeviceGroup.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonEditDeviceGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditDeviceGroupActionPerformed(evt);
            }
        });

        jButtonEditCommandGroup.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        jButtonEditCommandGroup.setText("Edit");
        jButtonEditCommandGroup.setEnabled(false);

        buttonGroupDeviceType.add(jRadioButtonDeviceTypeSingle);
        jRadioButtonDeviceTypeSingle.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        jRadioButtonDeviceTypeSingle.setSelected(true);
        jRadioButtonDeviceTypeSingle.setText("Single");
        jRadioButtonDeviceTypeSingle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jRadioButtonDeviceTypeSingle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonDeviceTypeSingleActionPerformed(evt);
            }
        });

        buttonGroupDeviceType.add(jRadioButtonDeviceTypeGroup);
        jRadioButtonDeviceTypeGroup.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        jRadioButtonDeviceTypeGroup.setText("Group");
        jRadioButtonDeviceTypeGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonDeviceTypeGroupActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Device Type:");

        jTextFieldDeviceSingle.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        jTextFieldDeviceSingle.setText("10.2.1.51");

        jLabel8.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Device:");

        jButtonEditDeviceGroup1.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        jButtonEditDeviceGroup1.setText("Test");
        jButtonEditDeviceGroup1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonEditDeviceGroup1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditDeviceGroup1ActionPerformed(evt);
            }
        });

        jCheckBoxAcceptKeys.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        jCheckBoxAcceptKeys.setSelected(true);
        jCheckBoxAcceptKeys.setText("Accept Keys");
        jCheckBoxAcceptKeys.setToolTipText("");

        jCheckBoxSaveConfig.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        jCheckBoxSaveConfig.setText("Save Config");
        jCheckBoxSaveConfig.setToolTipText("runs \"copy running-config startup-config\" ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jCheckBoxVerbose)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBoxSaveConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jCheckBoxAcceptKeys))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonGo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jRadioButtonDeviceTypeSingle, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonDeviceTypeGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jTextFieldUsername)
                            .addComponent(jPasswordField1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldDeviceSingle)
                                    .addComponent(jComboBoxDeviceGroup, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(8, 8, 8)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonEditDeviceGroup, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                    .addComponent(jButtonEditDeviceGroup1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jRadioButtonCommandTypeSingle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonCommandTypeGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldCommandToRun)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jComboBoxCommandGroup, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonEditCommandGroup))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonDeviceTypeSingle, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButtonDeviceTypeGroup)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonEditDeviceGroup1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jTextFieldDeviceSingle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonEditDeviceGroup, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBoxDeviceGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonCommandTypeSingle)
                    .addComponent(jRadioButtonCommandTypeGroup)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldCommandToRun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxCommandGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEditCommandGroup))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBoxVerbose)
                            .addComponent(jCheckBoxSaveConfig))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxAcceptKeys))
                    .addComponent(jButtonGo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.getAccessibleContext().setAccessibleDescription("");

        jTextPaneLog.setBackground(new java.awt.Color(0, 0, 0));
        jTextPaneLog.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        jTextPaneLog.setForeground(new java.awt.Color(255, 255, 255));
        jTextPaneLog.setText("Ready...");
        jScrollPaneLog.setViewportView(jTextPaneLog);

        jTextFieldCommandFilter.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        jTextFieldCommandFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldCommandFilterKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                    .addComponent(jTextFieldCommandFilter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPaneLog)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldCommandFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPaneLog, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        String strSelectedValue = jList1.getSelectedValue();
        try {
                if(strSelectedValue.contains(",")) {
                String[] arrSelectedValue = strSelectedValue.split(",");
                jTextFieldCommandToRun.setText(arrSelectedValue[1]);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jList1ValueChanged

    private void jTextFieldCommandFilterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCommandFilterKeyReleased
        try {
            searchFilter(jTextFieldCommandFilter.getText());
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(AutoPlink.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextFieldCommandFilterKeyReleased

    private void jButtonGoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGoActionPerformed
        //- Validate fields
        if (jTextFieldUsername.getText() == null || jTextFieldUsername.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Username is missing!", "Enter Username", 1);
            return;
        }
        if (jPasswordField1.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, "Password is missing!", "Enter Password", 1);
            return;            
        }
        if (jTextFieldCommandToRun.getText() == null || jTextFieldCommandToRun.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Command is missing!", "Enter Command", 1);
            return;
        }        
        if (jTextFieldCommandToRun.getText() == null || jTextFieldCommandToRun.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Command is missing!", "Enter Command", 1);
            return;
        }            
        //- Get Username and Pass
        String strUsername = jTextFieldUsername.getText();
        String strSecret = new String(jPasswordField1.getPassword());
        //- Set Log File
        simpleDateFormat  = new SimpleDateFormat("yyyyMMdd_HHmm-ssSSS");
        dateTime = simpleDateFormat.format(new Date());
        String strLogFile = strPathLoggingFolder + "\\AutoPlink-" + dateTime + " " + (String)jComboBoxDeviceGroup.getSelectedItem() + "";  
        String strSingleCommand = jTextFieldCommandToRun.getText();
        String strCommand;
        File filePlinkexe = new File(strPlinkexe);
        //Check if Plink is found
        if (filePlinkexe.exists()) {
            addToLogWindow("Found plink.exe, continuing...");
        } else {
            addToLogWindow("Plink.exe NOT found, stopping...");
            return;
        }

        System.out.println("Log file: " + strLogFile);


        String strPlinkVerbose;
        String strLogVerbose;
        //- Verbose for extra output
        if (jCheckBoxVerbose.isSelected() == true) {
            strPlinkVerbose = " -v ";
            strLogVerbose = " 2>&1 ";
        } else {
            strPlinkVerbose = "";   
            strLogVerbose = "";
        }           



        //- Begin Plink Automation

        //- Read Device Group file
        String strDevicesPath = strPathDeviceGroupFolder + "\\" + (String)jComboBoxDeviceGroup.getSelectedItem();
        if (jRadioButtonDeviceTypeSingle.isSelected() == true) {                        
            try {
                createSingleDeviceFile(jTextFieldDeviceSingle.getText());
                strDevicesPath = strPathDeviceSingleFile;
            } catch (IOException ex) {
                Logger.getLogger(AutoPlink.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        File fileDevices = new File (strDevicesPath);

        //- Count Lines in file  
        int lines = 0;
        try {
            BufferedReader brCount = new BufferedReader(new FileReader(fileDevices));
            while (brCount.readLine() != null) lines++;                
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AutoPlink.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AutoPlink.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (BufferedReader br = new BufferedReader(new FileReader(fileDevices))) {
            String device;
            //- Count the lines
            int line = 0;

            //- Start processing
            while ((device = br.readLine()) != null) {
                line++;
                jTextPaneLog.setText("Processing " + line + " of " + lines);
                addToLogWindow("Target: " + device);
                try {                        
                    //- command prompt to run plink.exe
                    String strCMD = "cmd.exe /c ";
                    String strEXEC;
                    Process process;
                    
                    //- Insert some space
                    strEXEC = strCMD + " echo. >> \"" + strLogFile + "\" " + strLogVerbose;
                    process = Runtime.getRuntime().exec(strEXEC);
                    process.waitFor();
                    process = Runtime.getRuntime().exec(strEXEC);
                    process.waitFor(); 

                    //- Start Device
                    strEXEC = strCMD + " echo ======================================= Start " + device + " ======================================= >> \"" + strLogFile + "\" " + strLogVerbose;
                    process = Runtime.getRuntime().exec(strEXEC);
                    process.waitFor();
                    
                    //- Insert some space
                    strEXEC = strCMD + " echo. >> \"" + strLogFile + "\" " + strLogVerbose;
                    process = Runtime.getRuntime().exec(strEXEC);
                    process.waitFor();
                    process = Runtime.getRuntime().exec(strEXEC);
                    process.waitFor(); 
                    
                    //- Accept Key
                    if (jCheckBoxAcceptKeys.isSelected() == true) {
                        addToLogWindow("Accepting Key...") ;
                        createSingleCommandFile("exit");
                        strEXEC = strCMD + "echo y | " + strPlinkexe + " " + strPlinkVerbose + " -ssh -2 -l " + strUsername + " -pw " + strSecret + " " + device + " -m \"" + strPathCommandSingleFile + "\"";
                        System.out.println(strEXEC);
                        process = Runtime.getRuntime().exec(strEXEC);
                        process.waitFor();
                    }

                    //- Save Config if selected                        
                    if (jCheckBoxSaveConfig.isSelected() == true) { 
                        addToLogWindow("Running Command: copy running-config startup-config");                        
                        createSingleCommandFile("copy running-config startup-config");
                        strEXEC = strCMD + " echo Saving Config >> \"" + strLogFile + "\" " + strLogVerbose;
                        process = Runtime.getRuntime().exec(strEXEC);
                        process.waitFor();
                        strEXEC = strCMD + "echo. && echo. | " + strPlinkexe + " " + strPlinkVerbose + " -ssh -2 -l " + strUsername + " -pw " + strSecret + " -batch " + device + " -m \"" + strPathCommandSingleFile + "\" >> \"" + strLogFile + "\" " + strLogVerbose;
                        System.out.println(strEXEC);  
                        process = Runtime.getRuntime().exec(strEXEC);
                        process.waitFor(); 
                        //- Insert some space
                        strEXEC = strCMD + " echo. >> \"" + strLogFile + "\" " + strLogVerbose;
                        process = Runtime.getRuntime().exec(strEXEC);
                        process.waitFor();                    
                    }                    

                    //- Write Hostname to file
                    addToLogWindow("Getting Hostname...");                        
                    createSingleCommandFile("show run | i hostname");
                    strEXEC = strCMD + strPlinkexe + " " + strPlinkVerbose + " -ssh -2 -l " + strUsername + " -pw " + strSecret + " -batch " + device + " -m \"" + strPathCommandSingleFile + "\" >> \"" + strLogFile + "\" " + strLogVerbose;
                    System.out.println(strEXEC);  
                    process = Runtime.getRuntime().exec(strEXEC);
                    process.waitFor();

                    //- OUTPUTS TO LOG WINDOW - MIGHT USE LATER    
                    //- Write Hostname to file
//                        addToLogWindow("Getting Hostname...");                        
//                        createSingleCommandFile("show run | i hostname");
//                        strEXEC = strCMD + strPlinkexe + " " + strPlinkVerbose + " -ssh -2 -l " + strUsername + " -pw " + strSecret + " -batch " + device + " -m \"" + strPathCommandSingleFile + "\" >> \"" + strLogFile + "\" " + strLogVerbose;
//                        System.out.println(strEXEC);  
//                        Process p2 = Runtime.getRuntime().exec(strEXEC);
//                        //p2.waitFor();
//                        InputStream stderr = p2.getErrorStream();
//                        InputStreamReader isr = new InputStreamReader(stderr);
//                        BufferedReader brisr = new BufferedReader(isr);
//                        String linebr = null;
//                        System.out.println("<ERROR>");
//                        while ( (linebr = brisr.readLine()) != null) {
//                            System.out.println(linebr);            
//                            addToLogWindow(linebr);
//                        }
//                        System.out.println("</ERROR>");
//                        int exitVal = p2.waitFor();
//                        System.out.println("Process exitValue: " + exitVal);




                    //- Write IP to file
                    addToLogWindow("Writing IP...");                        
                    strEXEC = strCMD + " echo " + device + " >> \"" + strLogFile + "\" " + strLogVerbose;
                    System.out.println(strEXEC);  
                    process = Runtime.getRuntime().exec(strEXEC);
                    process.waitFor();


                    if (jRadioButtonCommandTypeSingle.isSelected() == true) {                        
                        //- Run Command
                        addToLogWindow("Running Command:" + strSingleCommand);                        
                        createSingleCommandFile(strSingleCommand);
                        strEXEC = strCMD + strPlinkexe + " " + strPlinkVerbose + " -ssh -2 -l " + strUsername + " -pw " + strSecret + " -batch " + device + " -m \"" + strPathCommandSingleFile + "\" >> \"" + strLogFile + "\" " + strLogVerbose;
                        System.out.println(strEXEC);  
                        process = Runtime.getRuntime().exec(strEXEC);
                        process.waitFor(); 
                    }

                    //- Insert some space
                    strEXEC = strCMD + " echo. >> \"" + strLogFile + "\" " + strLogVerbose;
                    process = Runtime.getRuntime().exec(strEXEC);
                    process.waitFor();
                    process = Runtime.getRuntime().exec(strEXEC);
                    process.waitFor(); 

                    //- End Device
                    strEXEC = strCMD + " echo ======================================= End " + device + " ======================================= >> \"" + strLogFile + "\" " + strLogVerbose;
                    process = Runtime.getRuntime().exec(strEXEC);
                    process.waitFor();
                    
                    //- Insert some space
                    strEXEC = strCMD + " echo. >> \"" + strLogFile + "\" " + strLogVerbose;
                    process = Runtime.getRuntime().exec(strEXEC);
                    process.waitFor();
                    process = Runtime.getRuntime().exec(strEXEC);
                    process.waitFor(); 
                }                    
                catch (IOException e) {
                    System.out.println("Something is wrong!");
                    JOptionPane.showMessageDialog(null, "Something is wrong!");
                } catch (InterruptedException ex) {
                    Logger.getLogger(AutoPlink.class.getName()).log(Level.SEVERE, null, ex);
                }                          
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(AutoPlink.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AutoPlink.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        if (jRadioButtonDeviceTypeSingle.isSelected() == true) {                        
//            String device = jTextFieldDeviceSingle.getText();
//            jTextPaneLog.setText("Target: " + device);
//            try {                        
//                //- command prompt to run plink.exe
//                String strCMD = "cmd.exe /c ";
//                String strEXEC;
//                Process process;
//
//                //- Accept Key
//                if (jCheckBoxAcceptKeys.isSelected() == true) {
//                    addToLogWindow("Accepting Key...") ;
//                    createSingleCommandFile("exit");
//                    strEXEC = strCMD + "echo y | " + strPlinkexe + " " + strPlinkVerbose + " -ssh -2 -l " + strUsername + " -pw " + strSecret + " " + device + " -m \"" + strPathCommandSingleFile + "\"";
//                    System.out.println(strEXEC);
//                    process = Runtime.getRuntime().exec(strEXEC);
//                    process.waitFor();
//                }
//
//                //- Save Config if selected                        
//                if (jCheckBoxSaveConfig.isSelected() == true) { 
//                    addToLogWindow("Running Command: copy running-config startup-config");                        
//                    createSingleCommandFile("copy running-config startup-config");
//                    strEXEC = strCMD + " echo Saving Config >> \"" + strLogFile + "\" " + strLogVerbose;
//                    process = Runtime.getRuntime().exec(strEXEC);
//                    process.waitFor();
//                    strEXEC = strCMD + "echo. && echo. | " + strPlinkexe + " " + strPlinkVerbose + " -ssh -2 -l " + strUsername + " -pw " + strSecret + " -batch " + device + " -m \"" + strPathCommandSingleFile + "\" >> \"" + strLogFile + "\" " + strLogVerbose;
//                    System.out.println(strEXEC);  
//                    process = Runtime.getRuntime().exec(strEXEC);
//                    process.waitFor(); 
//                    //- Insert some space
//                    strEXEC = strCMD + " echo. >> \"" + strLogFile + "\" " + strLogVerbose;
//                    process = Runtime.getRuntime().exec(strEXEC);
//                    process.waitFor();                    
//                } 
//
//                //- Write Hostname to file
//                addToLogWindow("Getting Hostname...");                        
//                createSingleCommandFile("show run | i hostname");
//                strEXEC = strCMD + strPlinkexe + " " + strPlinkVerbose + " -ssh -2 -l " + strUsername + " -pw " + strSecret + " -batch " + device + " -m \"" + strPathCommandSingleFile + "\" >> \"" + strLogFile + "\" " + strLogVerbose;
//                System.out.println(strEXEC);  
//                process = Runtime.getRuntime().exec(strEXEC);
//                process.waitFor();
//
//                //- Write IP to file
//                addToLogWindow("Writing IP...");                        
//                strEXEC = strCMD + " echo " + device + " >> \"" + strLogFile + "\" " + strLogVerbose;
//                System.out.println(strEXEC);  
//                process = Runtime.getRuntime().exec(strEXEC);
//                process.waitFor();
//
//                //- Run single command if selected
//                if (jRadioButtonCommandTypeSingle.isSelected() == true) {                        
//                    addToLogWindow("Running Command:" + strSingleCommand);                        
//                    createSingleCommandFile(strSingleCommand);
//                    strEXEC = strCMD + strPlinkexe + " " + strPlinkVerbose + " -ssh -2 -l " + strUsername + " -pw " + strSecret + " -batch " + device + " -m \"" + strPathCommandSingleFile + "\" >> \"" + strLogFile + "\" " + strLogVerbose;
//                    System.out.println(strEXEC);  
//                    process = Runtime.getRuntime().exec(strEXEC);
//                    process.waitFor(); 
//                }
//
//                //- Insert some space
//                strEXEC = strCMD + " echo. >> \"" + strLogFile + "\" " + strLogVerbose;
//                Process p5 = Runtime.getRuntime().exec(strEXEC);
//                p5.waitFor();
//                process = Runtime.getRuntime().exec(strEXEC);
//                process.waitFor(); 
//                process.waitFor(); 
//            }                    
//            catch (IOException e) {
//                System.out.println("Something is wrong!");
//                JOptionPane.showMessageDialog(null, "Something is wrong!");
//            } catch (InterruptedException ex) {
//                Logger.getLogger(AutoPlink.class.getName()).log(Level.SEVERE, null, ex);
//            }                          
//        }
        //- Open log file
        addToLogWindow("Opening log File...");                                     
        openFileUsingDesktop(strLogFile);
        addToLogWindow("");                        
        addToLogWindow("We're all done!");           
        
    }//GEN-LAST:event_jButtonGoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        openFileUsingDesktop(strPathLoggingFolder);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        openFileUsingDesktop(strPathDeviceGroupFolder);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        URL iconURL = getClass().getResource("/icon/icon.png");
        ImageIcon img = new ImageIcon(iconURL);
        this.setIconImage(img.getImage());
    }//GEN-LAST:event_formWindowOpened

    private void jButtonEditDeviceGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditDeviceGroupActionPerformed
        openFileUsingDesktop(strPathDeviceGroupFolder + "\\" + (String)jComboBoxDeviceGroup.getSelectedItem());
    }//GEN-LAST:event_jButtonEditDeviceGroupActionPerformed

    private void jRadioButtonCommandTypeSingleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCommandTypeSingleActionPerformed
        jComboBoxCommandGroup.setEnabled(false);
        jButtonEditCommandGroup.setEnabled(false);
        jTextFieldCommandToRun.setEnabled(true);
    }//GEN-LAST:event_jRadioButtonCommandTypeSingleActionPerformed

    private void jRadioButtonCommandTypeGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCommandTypeGroupActionPerformed
        jComboBoxCommandGroup.setEnabled(true);
        jButtonEditCommandGroup.setEnabled(true);
        jTextFieldCommandToRun.setEnabled(false);
    }//GEN-LAST:event_jRadioButtonCommandTypeGroupActionPerformed

    private void jRadioButtonDeviceTypeSingleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonDeviceTypeSingleActionPerformed
        jTextFieldDeviceSingle.setEnabled(Boolean.TRUE);
        jComboBoxDeviceGroup.setEnabled(Boolean.FALSE);        
    }//GEN-LAST:event_jRadioButtonDeviceTypeSingleActionPerformed

    private void jRadioButtonDeviceTypeGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonDeviceTypeGroupActionPerformed
        jTextFieldDeviceSingle.setEnabled(Boolean.FALSE);
        jComboBoxDeviceGroup.setEnabled(Boolean.TRUE);  
    }//GEN-LAST:event_jRadioButtonDeviceTypeGroupActionPerformed

    private void jButtonEditDeviceGroup1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditDeviceGroup1ActionPerformed
        //- Validate fields
        if (jTextFieldUsername.getText() == null || jTextFieldUsername.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Username is missing!", "Enter Username", 1);
            return;
        }
        if (jPasswordField1.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, "Password is missing!", "Enter Password", 1);
            return;            
        }
        if (jTextFieldCommandToRun.getText() == null || jTextFieldCommandToRun.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Command is missing!", "Enter Command", 1);
            return;
        }        
        if (jTextFieldCommandToRun.getText() == null || jTextFieldCommandToRun.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Command is missing!", "Enter Command", 1);
            return;
        }            
        //- Get Username and Pass 
        String strUsername = jTextFieldUsername.getText();
        String strSecret = new String(jPasswordField1.getPassword());
        //- Set Log File
        simpleDateFormat  = new SimpleDateFormat("yyyyMMdd_HHmm-ssSSS");
        dateTime = simpleDateFormat.format(new Date());
        String strLogFile = strPathLoggingFolder + "\\AutoPlink-" + dateTime + " " + (String)jComboBoxDeviceGroup.getSelectedItem() + "";          
        
                
                
                String device = jTextFieldDeviceSingle.getText();

                    jTextPaneLog.setText("Target: " + device);
                    try {                        
                        //- command prompt to run plink.exe
                        String strCMD = "cmd.exe /c ";
                        String strEXEC;
                        if (jCheckBoxAcceptKeys.isSelected() == true) {
                            //- Accept Key
                            addToLogWindow("Accepting Key...") ;
                            createSingleCommandFile("copy running-config startup-config");
                            strEXEC = strCMD + "echo. && echo. | " + strPlinkexe + " -ssh -2 -l " + strUsername + " -pw " + strSecret + " " + device + " -m \"" + strPathCommandSingleFile + "\"";
                            System.out.println(strEXEC);
                            Process p1 = Runtime.getRuntime().exec(strEXEC);
                            p1.waitFor();
                        }
                        
                        //- Add message in file
                        strEXEC = strCMD + " echo You should see your running-config below. >> \"" + strLogFile + "\"  ";
                        Process process = Runtime.getRuntime().exec(strEXEC);
                        process.waitFor();
                        //- Insert some space
                        strEXEC = strCMD + " echo. >> \"" + strLogFile + "\" 2>&1 ";
                        process = Runtime.getRuntime().exec(strEXEC);
                        process.waitFor();
                        process = Runtime.getRuntime().exec(strEXEC);
                        process.waitFor(); 
                        
                        
                        //- Write Hostname to file
                        addToLogWindow("Getting Running-Config...");                        
                        createSingleCommandFile("show running-config");
                        strEXEC = strCMD + strPlinkexe + " -ssh -2 -l " + strUsername + " -pw " + strSecret + " -batch " + device + " -m \"" + strPathCommandSingleFile + "\" >> \"" + strLogFile + "\"  ";
                        System.out.println(strEXEC);  
                        process = Runtime.getRuntime().exec(strEXEC);
                        process.waitFor();

                        //- Write IP to file
                        addToLogWindow("Writing IP...");                        
                        strEXEC = strCMD + " echo " + device + " >> \"" + strLogFile + "\"  ";
                        System.out.println(strEXEC);  
                        Process p3 = Runtime.getRuntime().exec(strEXEC);
                        p3.waitFor();
                    }                    
                    catch (IOException e) {
                        System.out.println("Something is wrong!");
                        JOptionPane.showMessageDialog(null, "Something is wrong!");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(AutoPlink.class.getName()).log(Level.SEVERE, null, ex);
                    }                          
//                }
//            } catch (FileNotFoundException ex) {
//                Logger.getLogger(AutoPlink.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (IOException ex) {
//                Logger.getLogger(AutoPlink.class.getName()).log(Level.SEVERE, null, ex);
//            }
        
        //- Open log file
        addToLogWindow("Opening log File...");                                     
        openFileUsingDesktop(strLogFile);
        addToLogWindow("");                        
        addToLogWindow("We're all done!");     
    }//GEN-LAST:event_jButtonEditDeviceGroup1ActionPerformed
    
    private ArrayList getCommandList() throws FileNotFoundException, IOException, URISyntaxException
    {
        String strCommandList;
        DefaultListModel listModel = new DefaultListModel();
        ArrayList arrCommandList = new ArrayList();
        //File pathWorkingDirectory = new File(System.getProperty("user.dir"));
//        if(jCheckBoxFavorites.isSelected()){
//            strCommandList = strCommandListFavorites;
//        }
//        else {
            strCommandList = strCommandListDefault;
//        }
        System.out.println("CommandList.csv directory: " + strCommandList);
        File archivo = new File(strCommandList);
        if(!archivo.exists()) {  
            archivo.createNewFile();
            List<String> lines = Arrays.asList(
" ~~~~~~~ Info Collection ~~~~~~~~",
"(Access Lists) ,show access-lists",
"(CDP Neighbors) ,show cdp neighbor",
"(CDP Neighbors Detail) ,show cdp neighbor detail",
"(Config) ,show running-config",
"(CPU Sorted) ,show processes cpu sorted 5min | exclude 0.00",
"(CPU History) ,show processes cpu history",
"(Hostnames Only) ,exit",
"(Inventory) ,show inventory",
"(IP ARP Table) ,show ip arp",
"(IP Route Table) ,show ip route",
"(System Image) ,show version | i System image file",
"(Inventory) ,show inventory",
"(LLDP Neighbors) ,show lldp neighbor",
"(LLDP Neighbors Detail) ,show lldp neighbor detail",
"(Inventory) ,show inventory",
"(MAC Address Table) ,show mac address-table",
"(Model Numbers) ,show version | i Model number|WS-C45",
"(Modules) ,show modules",
"(NTP Association) ,show ntp association",
"(NTP Status) ,show ntp status",
"(Serial Numbers) ,show version | i System ser|FOX|SMG|FXS",
"(STP Brief) ,show spanning-tree brief",
"(STP Root) ,show spanning-tree root",
"(STP Summary) ,show spanning-tree summary",
"(SNMP User names) ,show snmp user | i User name",
"(Switch) ,show switch",
"(Uptime) ,show version | i uptime",
"(Usernames) ,show running-config | i username",
"(Version) ,show version",
"(VoIP Serial Numbers) ,show lldp neighbor detail | i Serial number",
"(VTP Status) ,show vtp status",
" ",
" ~~~~~ Compliance Check ~~~~~~",
"(ACL Allow Bypass) ,show running-config | i ACL-ALLOW in",
"(CRC Errors) ,show interfaces | include (Ethernet|CRC) | exclude 0 CRC",
"(Dot1x Auth Open) ,show running-config | i authentication open|access-group ACL-ALLOW|Giga|Fast",
"(Dot1x Enabled) ,show dot1x | i Sysauthcontrol",
"(Err-Disabled Ports) ,show int status err-disabled",
"(Failing Auth Sessions) ,show auth session | i Unauth|Running|Failed",
"(Gateway of Last Resort) ,show ip route | i Gateway",
"(Half-Duplex Ethernet) ,show interfaces | include (Ethernet|Half-duplex)",
"(Line ACL) ,show running-config | i line con|line vty|access-class",
"(Password Recovery) ,show running-config | i password-recovery",
"(Provisioned Switches) ,show switch | i 0000",
"(Stale User Sessions) ,show user",
"(STP Roots) ,show spanning-tree | i This bridge is the root",
"(TACACS Servers) ,show tacacs  | i Server",
"(TFTP Server) ,show running-config | i tftp-server",
"(VLAN ACL) ,show running-config int vlan 777 | i access",
" ",
" ~~~~~~~~ Other ~~~~~~~~~",
"(Cancel Reload) ,reload cancel",
"(Write Memory) ,write memory");
            
            Path file = Paths.get(strCommandList);
            Files.write(file, lines, Charset.forName("UTF-8"));
        }
        try (FileReader fr = new FileReader(archivo)) {
            BufferedReader buffIn;
            buffIn = new BufferedReader(fr);
               
            String line;
            while ((line = buffIn.readLine()) != null) {
                arrCommandList.add(line);
                listModel.addElement(line);
                //System.out.println(line);
            }
        jList1.setModel(listModel);
        }
        catch (IOException e) {
            System.out.println("CommandList.csv no good"); 
            JOptionPane.showMessageDialog(null, "CommandList.csv Error!"); 
        }
        return arrCommandList;
    }
     
    private void searchFilter(String searchTerm) throws IOException, FileNotFoundException, URISyntaxException
    {
        DefaultListModel filteredItems=new DefaultListModel();
        ArrayList commands=getCommandList();

        commands.stream().forEach((command) -> {
            String commandName=command.toString().toLowerCase();
            if (commandName.contains(searchTerm.toLowerCase())) {
                filteredItems.addElement(command);
            }
        });
        defaultListModelFilteredItems=filteredItems;
        jList1.setModel(defaultListModelFilteredItems);

    }

    private ArrayList getDeviceGroupList() throws FileNotFoundException, IOException, URISyntaxException {
        File folder = new File(strPathDeviceGroupFolder);
        File[] listOfFiles = folder.listFiles();
        List<String> fileNames = new ArrayList<>();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                fileNames.add(file.getName());
            } else if (file.isDirectory()) {
                // handle directory
            }
        }
        System.out.println("Found Device Groups: " + fileNames); 
        jComboBoxDeviceGroup.setModel(new DefaultComboBoxModel<>(fileNames.toArray(new String[fileNames.size()])));
        return null;
    }
    
    private void createSingleCommandFile(String strCommand) throws IOException {
        //--- Check for local user properties file
        File fileSingleCommand = new File(strPathCommandSingleFile);
        //if (!fileSingleCommand.exists()) {
            fileSingleCommand.createNewFile();
            //- Multiline for future reference (will need to separate string by comma)
//            List<String> lines = Arrays.asList(strCommand);
//                        List<String> lines = Arrays.asList(
//"conf t",                                
//"interface g0/1");
            Path file = Paths.get(fileSingleCommand.getPath());
            Files.write(file, strCommand.getBytes(StandardCharsets.UTF_8));
        //} 
    }
    
    private void createSingleDeviceFile(String strDevice) throws IOException {
        //--- Check for local user properties file
        File fileSingleCommand = new File(strPathDeviceSingleFile);
        //if (!fileSingleCommand.exists()) {
            fileSingleCommand.createNewFile();
            //- Multiline for future reference (will need to separate string by comma)
//            List<String> lines = Arrays.asList(strCommand);
//                        List<String> lines = Arrays.asList(
//"conf t",                                
//"interface g0/1");
            Path file = Paths.get(fileSingleCommand.getPath());
            Files.write(file, strDevice.getBytes(StandardCharsets.UTF_8));
        //} 
    }
    
    public void openFileUsingDesktop(String strFullFilePath) {
        System.out.println("openFileUsingDesktop: " + strFullFilePath);

        File userManual = new File (strFullFilePath);
        if (userManual.exists())
        {
            try {               
                Desktop.getDesktop().open(userManual);
            } catch (IOException ex) {
                System.out.println("Something is Wrong! openFileUsingDesktop: " + strFullFilePath);
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
                //- Set the look and feel

        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new AutoPlink().setVisible(true);
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IOException | URISyntaxException ex) {
                    Logger.getLogger(AutoPlink.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupCommandType;
    private javax.swing.ButtonGroup buttonGroupDeviceType;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonEditCommandGroup;
    private javax.swing.JButton jButtonEditDeviceGroup;
    private javax.swing.JButton jButtonEditDeviceGroup1;
    private javax.swing.JButton jButtonGo;
    private javax.swing.JCheckBox jCheckBoxAcceptKeys;
    private javax.swing.JCheckBox jCheckBoxSaveConfig;
    private javax.swing.JCheckBox jCheckBoxVerbose;
    private javax.swing.JComboBox<String> jComboBoxCommandGroup;
    private javax.swing.JComboBox<String> jComboBoxDeviceGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JRadioButton jRadioButtonCommandTypeGroup;
    private javax.swing.JRadioButton jRadioButtonCommandTypeSingle;
    private javax.swing.JRadioButton jRadioButtonDeviceTypeGroup;
    private javax.swing.JRadioButton jRadioButtonDeviceTypeSingle;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneLog;
    private javax.swing.JTextField jTextFieldCommandFilter;
    private javax.swing.JTextField jTextFieldCommandToRun;
    private javax.swing.JTextField jTextFieldDeviceSingle;
    private javax.swing.JTextField jTextFieldUsername;
    private javax.swing.JTextPane jTextPaneLog;
    // End of variables declaration//GEN-END:variables
}
