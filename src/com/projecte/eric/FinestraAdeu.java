package com.projecte.eric;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FinestraAdeu extends JFrame {
  public void initComponents() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        // Crear un panell amb BoxLayout en eix Y
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Crear tres JTextField
        JTextField textField1 = new JTextField("Adéu ,fins aviat!", 20);
        textField1.setEditable(false);
        textField1.setHorizontalAlignment(JTextField.CENTER);
        textField1.setBackground(Color.YELLOW);
        textField1.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 12));
        textField1.setForeground(Color.BLUE);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        Border boldBorder = BorderFactory.createLineBorder(Color.BLACK, 1, true);
        Border compoundBorder = BorderFactory.createCompoundBorder(border, boldBorder);
        textField1.setBorder(compoundBorder);

        JTextField textField01 = new JTextField("Programació 1r DAW  Curs:22/23", 20) {
            // Reescriure el mètode paintBorder per dibuixar només la línia inferior en
            // negreta
            @Override
            protected void paintBorder(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                Stroke sepa = g2.getStroke();
                g2.setStroke(
                        new BasicStroke(1.5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 2 }, 0));
                g2.setColor(Color.BLACK);
                g2.drawLine(0, getHeight() - 1, getWidth() - 1, getHeight() - 1);
                g2.setStroke(sepa);
            }
        };
        textField01.setEditable(false);
        textField01.setHorizontalAlignment(JTextField.CENTER);
        textField01.setForeground(Color.RED);
        textField01.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 12));
        textField01.setBackground(Color.WHITE);

        JTextField textField2 = new JTextField("Eric", 20) {
            // Reescriure el mètode paintBorder per dibuixar només la línia inferior en
            // negreta
            @Override
            protected void paintBorder(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                Stroke sepa = g2.getStroke();
                g2.setStroke(
                        new BasicStroke(1.5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 2 }, 0));
                g2.setColor(Color.BLACK);
                g2.drawLine(0, getHeight() - 1, getWidth() - 1, getHeight() - 1);
                g2.setStroke(sepa);
            }
        };
        textField2.setEditable(false);
        textField2.setHorizontalAlignment(JTextField.CENTER);
        textField2.setForeground(Color.RED);
        textField2.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 12));
		textField2.setBackground(Color.WHITE);

		JTextField textField3 = new JTextField("Alex", 20) {
			// Reescriure el mètode paintBorder per dibuixar només la línia inferior en
			// negreta
			@Override
			protected void paintBorder(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				Stroke sepa = g2.getStroke();
				g2.setStroke(
						new BasicStroke(1.5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 2 }, 0));
				g2.setColor(Color.BLACK);
				g2.drawLine(0, getHeight() - 1, getWidth() - 1, getHeight() - 1);
				g2.setStroke(sepa);
			}
		};
		textField3.setEditable(false);
		textField3.setHorizontalAlignment(JTextField.CENTER);
		textField3.setBackground(Color.WHITE);
		textField3.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 12));
		textField3.setForeground(Color.RED);

		JTextField textField4 = new JTextField("Miquel", 20) {
			// Reescriure el mètode paintBorder per dibuixar només la línia inferior en
			// negreta
			@Override
			protected void paintBorder(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				Stroke sepa = g2.getStroke();
				g2.setStroke(
						new BasicStroke(1.5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 2 }, 0));
				g2.setColor(Color.BLACK);
				g2.drawLine(0, getHeight() - 1, getWidth() - 1, getHeight() - 1);
				g2.setStroke(sepa);
			}
		};
		textField4.setEditable(false);
		textField4.setHorizontalAlignment(JTextField.CENTER);
		textField4.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 12));
		textField4.setBackground(Color.WHITE);
		textField4.setForeground(Color.RED);

		JTextField textField5 = new JTextField("Hector", 20) {
			// Reescriure el mètode paintBorder per dibuixar només la línia inferior en
			// negreta
			@Override
			protected void paintBorder(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				Stroke sepa = g2.getStroke();
				g2.setStroke(
						new BasicStroke(1.5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 2 }, 0));
				g2.setColor(Color.BLACK);
				g2.drawLine(0, getHeight() - 1, getWidth() - 1, getHeight() - 1);
				g2.setStroke(sepa);
			}
		};
		textField5.setEditable(false);
		textField5.setHorizontalAlignment(JTextField.CENTER);
		textField5.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 12));
		textField5.setBackground(Color.WHITE);
		textField5.setForeground(Color.RED);

		JTextField textField6 = new JTextField("Sergi", 20) {
			// Reescriure el mètode paintBorder per dibuixar només la línia inferior en
			// negreta
			@Override
			protected void paintBorder(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				Stroke sepa = g2.getStroke();
				g2.setStroke(
						new BasicStroke(1.5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 2 }, 0));
				g2.setColor(Color.BLACK);
				g2.drawLine(0, getHeight() - 1, getWidth() - 1, getHeight() - 1);
				g2.setStroke(sepa);
			}
		};
		textField6.setEditable(false);
		textField6.setHorizontalAlignment(JTextField.CENTER);
		textField6.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 12));
		textField6.setBackground(Color.WHITE);
		textField6.setForeground(Color.RED);
		// Afegir els JTextField al panell
		panel.add(textField1);
		panel.add(textField01);
		panel.add(textField2);
		panel.add(textField3);
		panel.add(textField4);
		panel.add(textField5);
		panel.add(textField6);

		add(panel);
		try {
			BufferedImage img = ImageIO.read(new File("Imagenes/th.jpg"));
			setIconImage(img);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}

