        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javauitest;

import com.itextpdf.text.pdf.PdfWriter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Transmitter;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import java.awt.Component;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import org.ini4j.Ini;
import org.jfugue.DeviceThatWillTransmitMidi;
import org.jfugue.MusicStringParser;
import org.jfugue.Note;
import org.jfugue.ParserListenerAdapter;
import org.jfugue.Pattern;
import org.jfugue.Player;

/**
 *
 * @author P
 */
public class MainMenu extends javax.swing.JFrame implements WindowListener{

    /**
     * Creates new form MainMenu
     */
    
    boolean FreeMode=true;
    boolean Lesson1=false;
    boolean Lesson2=false;
    public Please5alesne p5;
    Notes savedNotes[];
    int nbSavedNotes=0;
    DeviceThatWillTransmitMidi dwm;
    Pattern ptrn;
    public boolean MIDIConnected=false;
    boolean ugh=true;
    MusicPlayerThread merp;
    MidiConnectorThreadsus mcts;
    private Graphics2D g;
    int counter=7;
    int counterL=41;
    Metronome metro;
    MidiConnector midcon;
    Thread threadPlayer;
    private ArrayList<MidiDevice> devices = new ArrayList<MidiDevice>();
    private boolean Recording;
    boolean limitOctave=false;
    int limitOctaveAt=0;
    Ini inif;
    FileReader fr;
    BufferedReader br;
    public MainMenu(){
        initComponents();
        
        
        
        savedNotes=new Notes[26];
        
        jSpinner2.setValue(4);
        TitledBorder title = BorderFactory.createTitledBorder("Free Mode Options");
        jPanel1.setBorder(title);
        
        ToastMessage tm=new ToastMessage("Please connect to MIDI controller",3000);
        //tm.setVisible(true);
        
        ToastMessage tm2=new ToastMessage("FreeMode",3000);
        tm2.setVisible(true);
        
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //IMPORTANT
        /*ImageIcon image = new ImageIcon(
                        getClass().getResource("Koala.jpg"));
        jLabel6.setIcon(image);*/
        //IMPORTANT
        try {
            midcon=new MidiConnector();
        } catch (MidiUnavailableException ex) {
            Logger.getLogger(Options.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i=0;i<midcon.NumberOfDevices();i++){
            jComboBox1.addItem(midcon.getMidiDeviceAt(i));
        }
        
//        Document doc=new Document();
//        PdfWriter writer = null;
//        try {
//            writer=PdfWriter.getInstance(doc, new FileOutputStream("Report.pdf"));
//        } catch (DocumentException ex) {
//            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        doc.open();
//        PdfContentByte cb = writer.getDirectContent();
//        PdfTemplate tp = cb.createTemplate(PageSize.A4.getWidth(),PageSize.A4.getHeight());
//        cb.addTemplate(tp, 0, 0);
//        Graphics2D g2d= tp.createGraphics(PageSize.A4.getWidth(),PageSize.A4.getHeight());
//        g2d.scale(0.4, 0.4);
//        ;
//        for(int i=0; i< this.getContentPane().getComponents().length; i++){
//            Component c = this.getContentPane().getComponent(i);
//            if(c instanceof JLabel || c instanceof JScrollPane){
//                g2d.translate(c.getBounds().x,c.getBounds().y);
//                if(c instanceof JScrollPane){c.setBounds(0,0,(int)PageSize.A4.getWidth()*2,(int)PageSize.A4.getHeight()*2);}
//                c.paintAll(g2d);
//                c.addNotify();
//            }
//        }
//        doc.close();
        try {
            fr=new FileReader("loadmidicont.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        br=new BufferedReader(fr);
        try {
            String temp=br.readLine();
            if(temp!="Nan"){
                ReconnecttoMid(temp);
                System.out.println("aaaaaaaaaaaaaaaaaa"+Integer.parseInt(temp));
            }
        } catch (IOException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jSpinner2 = new javax.swing.JSpinner();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton15 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jRadioButton3 = new javax.swing.JRadioButton();
        jSpinner3 = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Freemode Options", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel1.setName("HeaderPanel"); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Keyboard"));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jButton2.setText("Reset");

        jLabel3.setText("Octave Limit");
        jLabel3.setEnabled(false);

        jSpinner2.setEnabled(false);

        jRadioButton2.setText("Off");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jButton15.setText("Set limit");
        jButton15.setEnabled(false);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton15)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jRadioButton2)
                        .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Metronome"));

        jButton5.setText("Reset");

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jRadioButton3.setText("On");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jSpinner3.setEnabled(false);

        jLabel10.setText("Tick:");
        jLabel10.setEnabled(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton3)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton3)
                        .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addComponent(jButton5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Controller"));

        jLabel11.setText("Select Controller");

        jButton6.setText("Connect");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton10.setText("reset connections");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addGap(41, 41, 41)
                .addComponent(jButton10)
                .addContainerGap(300, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jButton6))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javauitest/pics/cat3.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(9, 9, 9))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(180, 180, 180))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Other Menus", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel5.setText("Locked for users with account only");

        jButton3.setText("Sign in");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Register");

        jButton7.setText("Lessons");
        jButton7.setEnabled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Tools");
        jButton8.setEnabled(false);

        jButton9.setText("Others");
        jButton9.setEnabled(false);

        jLabel12.setText("Please select an option");
        jLabel12.setEnabled(false);

        jButton16.setText("Tutorial");
        jButton16.setEnabled(false);
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton7)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4))))
                    .addComponent(jButton16))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton16)
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton4)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javauitest/pics/better.png"))); // NOI18N
        jLabel6.setText("jLabel6");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Record / Info"));

        jLabel13.setText("NbSavedNotes");

        jLabel14.setText("###");

        jLabel15.setText("Octave:");

        jLabel16.setText("###");

        jButton11.setText("Record");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("Save");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("To Freemode");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("Open as sheet music");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton17.setText("Reset Sheets");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addContainerGap(454, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jButton11)
                        .addGap(18, 18, 18)
                        .addComponent(jButton12)
                        .addGap(18, 18, 18)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton17)
                        .addGap(22, 22, 22))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11)
                    .addComponent(jButton12)
                    .addComponent(jButton13)
                    .addComponent(jButton14)
                    .addComponent(jButton17))
                .addGap(19, 19, 19))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javauitest/pics/better.png"))); // NOI18N
        jLabel7.setText("jLabel6");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Free Mode");

        jMenu1.setText("File");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javauitest/pics/gear39.png"))); // NOI18N
        jMenuItem1.setText("Susurrus options");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseReleased(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(9, 9, 9)
                .addComponent(jLabel2)
                .addGap(58, 58, 58))
        );

        jPanel1.getAccessibleContext().setAccessibleName("HeaderPanel");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        
            this.jLabel3.setEnabled(true);
            this.jSpinner2.setEnabled(true);
            
            this.jButton15.setEnabled(true);
        
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        if(MIDIConnected=false){
            this.jLabel10.setEnabled(true);
            this.jSpinner3.setEnabled(true);
            metro=new Metronome();
            metro.start(60);
        }else{
            ToastMessage tm=new ToastMessage("Please connect to MIDI controller first",3000);
            //tm.setVisible(true);
            
        }
        
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
            
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseReleased
        Options opt=new Options();
        opt.setVisible(true);
    }//GEN-LAST:event_jMenuItem1MouseReleased

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
        MidiDevice.Info[] infos = MidiSystem.getMidiDeviceInfo();
        for (int i = 0; i < infos.length; i++) {
            try {
            devices.add(MidiSystem.getMidiDevice(infos[i]));
            devices.get(i).open();
            System.out.println(infos[i]);
            List<Transmitter> transmitters = devices.get(i).getTransmitters();
            for(int j = 0; j<transmitters.size();j++) {
                transmitters.get(j).setReceiver(
                        new MainMenu.MidiInputReceiver(devices.get(i).getDeviceInfo().toString())
                );
            }
            if(devices.get(i).isOpen()){
                System.out.println(devices.get(i).getDeviceInfo()+" Was Opened");
                
            }
            }catch (MidiUnavailableException e) {System.out.println("Error");}
            
        }
        
            DeviceThatWillTransmitMidi dwm;
        try {
            dwm = new DeviceThatWillTransmitMidi(devices.get(1).getDeviceInfo());
            dwm.addParserListener(new GetInstrumentsUsedTool());
            
//            threadPlayer=new Thread(){
//                boolean running=true;
//                public void run() {
//                    dwm.startListening();
//                    
//                    while(running);
//                    dwm.stopListening();
//                }
//                
//                public void setRunning(boolean bool){
//                    running=bool;
//                }
//                
//            };
//            threadPlayer.start();
            p5=new Please5alesne (dwm);
            threadPlayer=new Thread(p5);
            threadPlayer.start();
            System.out.println("reached");
            MIDIConnected=true;
        } catch (MidiUnavailableException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.jLabel12.setEnabled(true);
        this.jButton7.setEnabled(true);
        this.jButton8.setEnabled(true);
        this.jButton9.setEnabled(true);
        this.jButton3.hide();
        this.jButton4.hide();
        this.jLabel5.hide();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        jComboBox1.removeAllItems();
        try {
            midcon=new MidiConnector();
        } catch (MidiUnavailableException ex) {
            Logger.getLogger(Options.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i=0;i<midcon.NumberOfDevices();i++){
            jComboBox1.addItem(midcon.getMidiDeviceAt(i));
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if(Lesson1==false || Lesson2==false){
            FreeMode=false;
        jLabel2.setText("Lesson Mode");
        LessonTest lt;
        g=(Graphics2D ) getGraphics ();
        g.setColor(Color.white);
        //this.jLabel7.hide();
        //g.fillRect(50, 345, 645, 207);
        
        if(Lesson1==true){
            Lesson1=false;
            int countertemp=41;
            g=(Graphics2D ) getGraphics ();
            g.setColor(Color.red);
            g.fillOval((countertemp)*20,432,7,7);//c
            countertemp++;
            g.fillOval((countertemp)*20,432,7,7);//c
            countertemp++;
            
            g.fillOval((countertemp)*20,407,7,7);//g
            countertemp++;
            g.fillOval((countertemp)*20,407,7,7);//g
            countertemp++;
            g.fillOval((countertemp)*20,400,7,7);//a
            countertemp++;
            g.fillOval((countertemp)*20,400,7,7);//a
            countertemp++;
            g.fillOval((countertemp)*20,407,7,7);//g
            countertemp++;
            g.fillOval((countertemp)*20,413,7,7);//f
            countertemp++;
            g.fillOval((countertemp)*20,413,7,7);//f
            countertemp++;
            g.fillOval((countertemp)*20,420,7,7);//e
            countertemp++;
            g.fillOval((countertemp)*20,420,7,7);//e
            countertemp++;            
            g.fillOval((countertemp)*20,426,7,7);//d
            countertemp++;
            g.fillOval((countertemp)*20,426,7,7);//d
            countertemp++;
            g.fillOval((countertemp)*20,432,7,7);//c
            countertemp++;
            
//            g.fillOval((countertemp)*20,420,7,7);//e
//            countertemp++;
//            g.fillOval((countertemp)*20,420,7,7);//e
//            countertemp++;
//            g.fillOval((countertemp)*20,426,7,7);//d
            
            
        }else if(Lesson2==false){
            Lesson2=true;
            int countertemp=41;
            g=(Graphics2D ) getGraphics ();
            g.setColor(Color.red);
            g.fillOval((countertemp)*20,432,7,7);//c
            countertemp++;
            g.fillOval((countertemp)*20,407,7,7);//g
            countertemp++;
            g.fillOval((countertemp)*20,420,7,7);//e
            countertemp++;
            g.fillOval((countertemp)*20,407,7,7);//g
            countertemp++;
            g.fillOval((countertemp)*20,432,7,7);//c
            countertemp++;
            g.fillOval((countertemp)*20,407,7,7);//g
            countertemp++;
            g.fillOval((countertemp)*20,420,7,7);//e
            countertemp++;
            g.fillOval((countertemp)*20,407,7,7);//g
            countertemp++;
        }
        
        
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        p5.setRunning(false);
        this.threadPlayer.interrupt();
        p5.dwm.stopListening();
        Recording=true;
        this.ReconnecttoMid();
        ToastMessage tm=new ToastMessage("Recording...",3000);
        tm.setVisible(true);
        
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        if(MIDIConnected==true){
            p5.dwm.stopListening();
            
            ptrn=p5.dwm.getPatternFromListening();
            Player plr=new Player();
            
            JFileChooser chooser = new JFileChooser(); 
            chooser.setCurrentDirectory(new java.io.File("."));
            String choosertitle="test";
            chooser.setDialogTitle(choosertitle);
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            
            chooser.setAcceptAllFileFilterUsed(false);
            //    
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
              System.out.println("getCurrentDirectory(): " 
                 +  chooser.getCurrentDirectory());
              System.out.println("getSelectedFile() : " 
                 +  chooser.getSelectedFile());
              }
            try {
                plr.saveMidi(ptrn, new File(chooser.getSelectedFile()+"\\Test.mid"));
            } catch (IOException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.ReconnecttoMid();
            ToastMessage tm=new ToastMessage(""+chooser.getSelectedFile(),3000);
            tm.setVisible(true);
        }else{
            ToastMessage tm=new ToastMessage("Please connect to MIDI controller",3000);
            tm.setVisible(true);
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        if(FreeMode==false){
            ReDrawEverythingAndReset();
            jLabel2.setText("Free Mode");
            FreeMode=true;
            Lesson1=false;
            Lesson2=false;
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        if(MIDIConnected==true){
            p5.dwm.stopListening();
            
            ptrn=p5.dwm.getPatternFromListening();
            sheetmusicF ss=new sheetmusicF(ptrn);
            ss.setVisible(true);
            ss.addWindowListener(this);
            counter=7;
            ReconnecttoMid();
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
       
            this.limitOctaveAt=(int) this.jSpinner2.getValue();
            this.limitOctave=true;
        
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        if(FreeMode==true){
            ReDrawEverythingAndReset();
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    // End of variables declaration//GEN-END:variables

    public void ReDrawEverythingAndReset(){
        g.setColor(Color.white);
        g.fillRect(50, 345, 635, 200);
        g.fillRect(750, 345, 635, 200);
        ImageIcon image = new ImageIcon(
        getClass().getResource("better.png"));
        jLabel6.setIcon(image);  
        jLabel7.setIcon(image);
    }
    
    @Override
    public void windowOpened(WindowEvent e) {
        ;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        ;
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("CLOSING WINDOW COPY");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        ;
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        ;
    }

    @Override
    public void windowActivated(WindowEvent e) {
        ;
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        ;
    }

    
    public class ToastMessage extends JDialog {
    int miliseconds;
    public ToastMessage(String toastString, int time) {
        this.miliseconds = time;
        setUndecorated(true);
        getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
        getContentPane().add(panel, BorderLayout.CENTER);

        JLabel toastLabel = new JLabel("");
        toastLabel.setText(toastString);
        toastLabel.setFont(new Font("Dialog", Font.BOLD, 12));
        toastLabel.setForeground(Color.WHITE);

        setBounds(100, 100, toastLabel.getPreferredSize().width+20, 31);


        setAlwaysOnTop(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int y = dim.height/2-getSize().height/2;
        int half = y/2;
        setLocation(dim.width/2-getSize().width/2, y+half);
        panel.add(toastLabel);
        setVisible(false);

        new Thread(){
            public void run() {
                try {
                    Thread.sleep(miliseconds);
                    dispose();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
    }
    public class MidiInputReceiver implements Receiver {
        public String name;
        public MidiInputReceiver(String name) {
            this.name = name;
        }
        public void send(MidiMessage msg, long timeStamp) {
            System.out.println("midi received");
        }
        public void close() {}
    }
    
        public class  GetInstrumentsUsedTool extends ParserListenerAdapter{
        private List<org.jfugue.Instrument> instruments;
        int counter=0;
        public  GetInstrumentsUsedTool()
        {
        instruments = new ArrayList<org.jfugue.Instrument>();
        }
        @Override
        public void noteEvent(Note note){
//            if(note.getDuration()==0.0){
//            org.jfugue.Note n;d
//            n=note;
//            
//            jta.append(note.getVerifyString()+"\n");
//            
//            Player p=new Player();
//            //if(note.getDecimalDuration()<0.1f)
//                note.setDecimalDuration(0.2);
//            //jta.append(note.getDuration()+"<-----old------\n");
//            //jta.append(note.getDecimalDuration()+"<----------\n");
//           // note.setAttackVelocity(velocity);
//            
//            //jta.append(note.getDuration()+"<-----new------\n");
//            //p.play(note.getMusicString());
//            }
//            counter++;
            char NoteType=note.getMusicString().charAt(0);
            char NotePos=note.getMusicString().charAt(1);          
            //jLabel14.setText(""+NoteType);
//            jLabel14.setText(""+nbSavedNotes);
//            //jLabel16.setText(""+NotePos);
//            jLabel16.setText(""+counter);
            //if(note.getDuration()==0.0)
               // try {
                    //DrawNotes(NoteType,NotePos);
            //} catch (IOException ex) {
            //    Logger.getLogger(FreeMode.class.getName()).log(Level.SEVERE, null, ex);
           // }
           merp=new MusicPlayerThread(note);
            Thread t=new Thread(merp);
            t.start();
        }
        @Override
        public void instrumentEvent(org.jfugue.Instrument instrument)
        {
            //System.out.println(instrument.toString());
        
        }

        public List<org.jfugue.Instrument> getInstrumentsUsed(Pattern pattern)
        {
        MusicStringParser parser = new MusicStringParser();
        parser.addParserListener(this);
        parser.parse(pattern);
        return instruments;
        } 
    }
        
        
    public class MusicPlayerThread implements Runnable{
        private Note note;
        
        public MusicPlayerThread(Note n){
            note=n;
        }
        @Override
        public void run() {
            
            if(note.getDuration()==0.0){
                counter++;
                Player p=new Player();
                Pattern ptr=new Pattern();
                note.setDecimalDuration(0.3);
                ptr.add(note.getMusicString());

                    
                
                
                
                char noteT=note.getMusicString().charAt(0);
                char noteP=' ';
                g=(Graphics2D ) getGraphics ();
                g.setColor(Color.black);
                if(limitOctave==true){
                    noteP=(char) limitOctaveAt;
                    
                    
                }else
                    noteP=note.getMusicString().charAt(1);
                
                if(FreeMode==true){//number of notes less than 26
                    
                    System.out.println("Number of saved notes: "+nbSavedNotes+"\nCounter: "+counter);
                    
                    if(noteT=='C'){
                        if(noteP=='4'){
                            g.setColor(Color.red);
                            g.drawLine(counter*20-5, 445, counter*20+10, 445);
                            g.setColor(Color.black);
                            
                            g.fillOval(counter*20,442,7,7);
                            int counterpre=counter-1;
                            savedNotes[nbSavedNotes]=new Notes(noteT,noteP,20,442);
                            nbSavedNotes++;
                        }else if(noteP=='5'){
                            g.fillOval(counter*20,393,7,7);
                            int counterpre=counter-1;
                            savedNotes[nbSavedNotes]=new Notes(noteT,noteP,20,393);
                            nbSavedNotes++;
                        }
                    }else if(noteT=='D'){
                        if(noteP=='4'){
                            g.fillOval(counter*20,435,7,7);
                            int counterpre=counter-1;
                            savedNotes[nbSavedNotes]=new Notes(noteT,noteP,20,435);
                            nbSavedNotes++;
                        } else if(noteP=='5'){
                            g.fillOval(counter*20,386,7,7);
                            int counterpre=counter-1;
                            savedNotes[nbSavedNotes]=new Notes(noteT,noteP,20,386);
                            nbSavedNotes++;
                        }
                    }else if(noteT=='E'){
                        if(noteP=='4'){
                            g.fillOval(counter*20,428,7,7);
                            int counterpre=counter-1;
                            savedNotes[nbSavedNotes]=new Notes(noteT,noteP,20,428);
                            nbSavedNotes++;
                        }else if(noteP=='5'){
                            g.fillOval(counter*20,379,7,7);
                            int counterpre=counter-1;
                            savedNotes[nbSavedNotes]=new Notes(noteT,noteP,20,379);
                            nbSavedNotes++;
                        }
                    }else if(noteT=='F'){
                        if(noteP=='4'){
                            g.fillOval(counter*20,421,7,7);
                            int counterpre=counter-1;
                            savedNotes[nbSavedNotes]=new Notes(noteT,noteP,20,421);
                            nbSavedNotes++;
                        }else if(noteP=='5'){
                            g.fillOval(counter*20,372,7,7);
                            int counterpre=counter-1;
                            savedNotes[nbSavedNotes]=new Notes(noteT,noteP,20,372);
                            nbSavedNotes++;
                        }
                    }else if(noteT=='G'){
                        if(noteP=='4'){
                            g.fillOval(counter*20,414,7,7);
                            int counterpre=counter-1;
                            savedNotes[nbSavedNotes]=new Notes(noteT,noteP,20,414);
                            nbSavedNotes++;
                        }else if(noteP=='5'){
                            g.fillOval(counter*20,366,7,7);
                            int counterpre=counter-1;
                            savedNotes[nbSavedNotes]=new Notes(noteT,noteP,20,366);
                            nbSavedNotes++;
                        }
                    }else if(noteT=='A'){
                        if(noteP=='4'){
                            g.fillOval(counter*20,407,7,7);
                            int counterpre=counter-1;
                            savedNotes[nbSavedNotes]=new Notes(noteT,noteP,20,407);
                            nbSavedNotes++;
                        }
                    }else if(noteT=='B'){
                        if(noteP=='4'){
                            g.fillOval(counter*20,400,7,7);
                            int counterpre=counter-1;
                            savedNotes[nbSavedNotes]=new Notes(noteT,noteP,20,400);
                            nbSavedNotes++;
                        }
                    }
                }
                if(counter==33){
                        
                        g.setColor(Color.white);
                        g.fillRect(50, 345, 635, 200);
                    ImageIcon image = new ImageIcon(
                    getClass().getResource("better.png"));
                    jLabel6.setIcon(image);   
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    counter=32;
                    
                    g.setColor(Color.black);
                    int temp=7;
                    for(int i=1;i<nbSavedNotes;i++){
                        g.fillOval(savedNotes[i].posx*temp,savedNotes[i].posy,7,7);
                        temp++;
                    }
                    for(int i=0;i<nbSavedNotes-1;i++){
                        savedNotes[i]=savedNotes[i+1];
                    }
                     nbSavedNotes=25;   
                    }
                
                jLabel14.setText(""+nbSavedNotes);
            jLabel16.setText(""+counter);
                if(Lesson1==true){
                    g.setColor(Color.green);
                    if(counterL==41){
                        if(noteT=='C' && noteP=='4'){
                            g.fillOval((counterL)*20,432,7,7);
                            counterL++;
                        }
                    }else if(counterL==42){
                        if(noteT=='C' && noteP=='4'){
                            g.fillOval((counterL)*20,432,7,7);
                            counterL++;
                        }
                    }else if(counterL==43){
                        if(noteT=='D' && noteP=='4'){
                            g.fillOval((counterL)*20,426,7,7);
                            counterL++;
                        }
                    }else if(counterL==44){
                        if(noteT=='D' && noteP=='4'){
                            g.fillOval((counterL)*20,426,7,7);
                            counterL++;
                        }
                    }else if(counterL==45){
                        if(noteT=='E' && noteP=='4'){
                            g.fillOval((counterL)*20,418,7,7);
                            counterL++;
                        }
                    }else if(counterL==46){
                        if(noteT=='E' && noteP=='4'){
                            g.fillOval((counterL)*20,418,7,7);
                            counterL++;
                        }
                    }else if(counterL==47){
                        if(noteT=='D' && noteP=='4'){
                            g.fillOval((counterL)*20,426,7,7);
                            counterL++;
                        }
                    }
                }
                p.play(ptr);
                
//                int pos=Integer.getInteger(""+note.getMusicString().charAt(1))+1;
//                String toplay=note.getMusicString().charAt(0)+String.valueOf(pos);
//                p.play(toplay);
            }
        }
        
    }
    
    public class MidiConnectorThreadsus implements Runnable{

        @Override
        public void run() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
    public class Please5alesne implements Runnable{
        public boolean running=true;
        DeviceThatWillTransmitMidi dwm;
        public Please5alesne(DeviceThatWillTransmitMidi d){
            dwm=d;
        }
        @Override
        public void run() {
            dwm.startListening();
            while(running==true);
            dwm.stopListening();
        }
        
        public void setRunning(boolean bool){
                    running=bool;
                }
        
    }
    
    public void ReconnecttoMid(){
        MidiDevice.Info[] infos = MidiSystem.getMidiDeviceInfo();
        for (int i = 0; i < infos.length; i++) {
            try {
            devices.add(MidiSystem.getMidiDevice(infos[i]));
            devices.get(i).open();
            System.out.println(infos[i]);
            List<Transmitter> transmitters = devices.get(i).getTransmitters();
            for(int j = 0; j<transmitters.size();j++) {
                transmitters.get(j).setReceiver(
                        new MainMenu.MidiInputReceiver(devices.get(i).getDeviceInfo().toString())
                );
            }
            if(devices.get(i).isOpen()){
                System.out.println(devices.get(i).getDeviceInfo()+" Was Opened");
                
            }
            }catch (MidiUnavailableException e) {System.out.println("Error");}
            
        }
        
            DeviceThatWillTransmitMidi dwm;
        try {
            dwm = new DeviceThatWillTransmitMidi(devices.get(1).getDeviceInfo());
            dwm.addParserListener(new GetInstrumentsUsedTool());
            p5=new Please5alesne (dwm);
            threadPlayer=new Thread(p5);
            threadPlayer.start();
            System.out.println("reached");
            MIDIConnected=true;
        } catch (MidiUnavailableException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ReconnecttoMid(String pos){
        MidiDevice.Info[] infos = MidiSystem.getMidiDeviceInfo();
        for (int i = 0; i < infos.length; i++) {
            try {
            devices.add(MidiSystem.getMidiDevice(infos[i]));
            devices.get(i).open();
            System.out.println(infos[i]);
            List<Transmitter> transmitters = devices.get(i).getTransmitters();
            for(int j = 0; j<transmitters.size();j++) {
                transmitters.get(j).setReceiver(
                        new MainMenu.MidiInputReceiver(devices.get(i).getDeviceInfo().toString())
                );
            }
            if(devices.get(i).isOpen()){
                System.out.println(devices.get(i).getDeviceInfo()+" Was Opened");
                
            }
            }catch (MidiUnavailableException e) {System.out.println("Error");}
            
        }
        
            DeviceThatWillTransmitMidi dwm;
        try {
            dwm = new DeviceThatWillTransmitMidi(devices.get(Integer.parseInt(pos)).getDeviceInfo());
            dwm.addParserListener(new GetInstrumentsUsedTool());
            p5=new Please5alesne (dwm);
            threadPlayer=new Thread(p5);
            threadPlayer.start();
            System.out.println("reached");
            MIDIConnected=true;
        } catch (MidiUnavailableException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
