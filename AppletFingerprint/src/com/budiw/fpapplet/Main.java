package com.budiw.fpapplet;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main extends JApplet {

	private static final long serialVersionUID = 4472512675731104474L;

	//Called when this applet is loaded into the browser.
    public void init() {
        //Execute a job on the event-dispatching thread; creating this applet's GUI.
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    createGUI();
                }
            });
        } catch (Exception e) {
            System.err.println("createGUI didn't complete successfully");
            e.printStackTrace();
            
        }
    }
    
    //Let's do this: LEEEERRRROOOOOYYYYYY..............
    private void createGUI() {
    	final JButton enroll = new JButton("Fingerprint Enrollment");
        enroll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { onEnroll(); }});
		
		final JButton verify = new JButton("Fingerprint Verification");
        verify.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { onVerify(); }});
        
        JPanel center = new JPanel();
		center.setLayout(new GridLayout(4, 1, 0, 5));
		center.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
		center.add(enroll);
		center.add(verify);

		setLayout(new BorderLayout());
		add(center, BorderLayout.CENTER);
		setSize(200,150);
	}

    protected void onEnroll() {
		new EnrollmentForm();
	}
    
    protected void onVerify() {
//    	DPFPTemplate t = DPFPGlobal.getTemplateFactory().createTemplate();
	}
}