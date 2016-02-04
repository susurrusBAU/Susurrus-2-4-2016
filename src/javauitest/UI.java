/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javauitest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.MidiUnavailableException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javauitest.MidiConnector;
;

/**
 *
 * @author P
 */
public class UI extends JFrame implements ActionListener{
    MidiConnector midcon;
    JComboBox combo=new JComboBox();
    JButton ConnectToMidiButton=new JButton("Connect Device");
    JPanel panel1=new JPanel();
    String text="test";
    public UI() throws MidiUnavailableException{
        ToastMessage tm=new ToastMessage("Please connect to MIDI controller",3000);
        tm.setVisible(true);
        //JOptionPane.showMessageDialog(null,"Please connect to your Midi Controller", "", JOptionPane.INFORMATION_MESSAGE);
        getContentPane().setLayout(new BorderLayout());
        panel1.setLayout(new FlowLayout(FlowLayout.RIGHT,20,20));
        getContentPane().add(panel1,BorderLayout.NORTH);
        
        midcon=new MidiConnector();
        for(int i=0;i<midcon.NumberOfDevices();i++){
            combo.addItem(midcon.getMidiDeviceAt(i));
        }
        
        panel1.add(combo);
        panel1.add(ConnectToMidiButton);
        ConnectToMidiButton.addActionListener(this);
        setSize(1300,700);
        this.setTitle("Midi Connector");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String[] args) throws MidiUnavailableException  {
        new UI();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ConnectToMidiButton){
            try {
                if(midcon.ConnectToDevice(combo.getSelectedIndex())){
                    JOptionPane.showMessageDialog(null,"Connected to "+midcon.getMidiDeviceAt(combo.getSelectedIndex()), "", JOptionPane.INFORMATION_MESSAGE);
                    //mui=new MenuUI();
                    //8this.setVisible(false);
                }
                else
                    JOptionPane.showMessageDialog(null,"could not connect to "+midcon.getMidiDeviceAt(combo.getSelectedIndex()), "", JOptionPane.ERROR_MESSAGE);
                
            } catch (MidiUnavailableException ex) {
                Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        }
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
}
