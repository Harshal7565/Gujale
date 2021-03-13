

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

class randomquiz extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	JLabel label;
	JRadioButton radioButton[] = new JRadioButton[5];
	JButton btnNext;
	ButtonGroup bg;
	int count = 0,  current = 0 , x = 1, y = 1, now = 0;
	int m[] = new int[10];

	// create jFrame with radioButton and JButton
	randomquiz(String s) {
		super(s);
		label = new JLabel();
		add(label);
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			radioButton[i] = new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}
		btnNext = new JButton("Next");
		btnNext.addActionListener(this);
		add(btnNext);
		set();
		label.setBounds(30, 40, 450, 20);
		radioButton[0].setBounds(50, 80, 450, 20);
		radioButton[1].setBounds(50, 110, 200, 20);
		radioButton[2].setBounds(50, 140, 200, 20);
		radioButton[3].setBounds(50, 170, 200, 20);
		btnNext.setBounds(100, 240, 100, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(600, 350);
	}

	// handle all actions based on event
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			if (check())
				count = count + 1;
			current++;
			set();
			if (current == 9) {
				btnNext.setText("Result");
			}
		}
	
		if (e.getActionCommand().equals("Result")) {
			if (check())
				count = count + 1;
			current++;
			JOptionPane.showMessageDialog(this, "correct answers= " + count);
			System.exit(0);
		}
	}

	// SET Questions with options
	void set() {
		radioButton[4].setSelected(true);
		
		for(int k = 0 ; k < 10 ; k++) {
			current = getRandomValue(0,10);
		}	
		
		if (current == 0) {
			label.setText("Que1:  How many legs does cat have ?");
			radioButton[0].setText("Three");
			radioButton[1].setText("Four");
			radioButton[2].setText("Six");
			radioButton[3].setText("Ten");
		}
		if (current == 1) {
			label.setText("Que2:  Who is strongest animal ?");
			radioButton[0].setText("Frog");
			radioButton[1].setText("Elephant");
			radioButton[2].setText("Ant");
			radioButton[3].setText("mouse");
		}
		if (current == 2) {
			label.setText("Que3: Pune located in Maharshtra state.");
			radioButton[0].setText("true");
			radioButton[1].setText("false");
			radioButton[2].setText("don't know");
			radioButton[3].setText("Maybe");
		}
		if (current == 3) {
			label.setText("Que4: What is color of elephant's teeth ?");
			radioButton[0].setText("Yellow");
			radioButton[1].setText("Blue");
			radioButton[2].setText("White");
			radioButton[3].setText("Green");
		}
		if (current == 4) {
			label.setText("Que5: How many eyes does human have ?");
			radioButton[0].setText(" Two");
			radioButton[1].setText("Three");
			radioButton[2].setText("Four");
			radioButton[3].setText("Five");
		}
		if (current == 5) {
			label.setText("Que6: Do you think alians exits ?");
			radioButton[0].setText("Can't predict");
			radioButton[1].setText("Yes");
			radioButton[2].setText("No");
			radioButton[3].setText("I am alian");
		}
		if (current == 6) {
			label.setText("Que7: How many planets exists in our solar system ?");
			radioButton[0].setText("3");
			radioButton[1].setText("9");
			radioButton[2].setText("2");
			radioButton[3].setText("1");
		}
		if (current == 7) {
			label.setText("Que8: Which is used while playing cricket ?");
			radioButton[0].setText("Racket");
			radioButton[1].setText("Ring");
			radioButton[2].setText("Bat");
			radioButton[3].setText("blocks");
		}
		if (current == 8) {
			label.setText("Que9: Which part of body performs blood purification ?");
			radioButton[0].setText("Kidney");
			radioButton[1].setText("lungs");
			radioButton[2].setText("don't know");
			radioButton[3].setText("small intestine");
		}
		if (current == 9) {
			label.setText("Que10: What is number of this question ?");
			radioButton[0].setText("6");
			radioButton[1].setText("5");
			radioButton[2].setText("4");
			radioButton[3].setText("10");
		}
		label.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++) 
			radioButton[j].setBounds(50, 80 + i, 200, 20);
		
	}

	// declare right answers.
	boolean check() {
		if (current == 0)
			return (radioButton[1].isSelected());
		if (current == 1)
			return (radioButton[1].isSelected());
		if (current == 2)
			return (radioButton[0].isSelected());
		if (current == 3)
			return (radioButton[2].isSelected());
		if (current == 4)
			return (radioButton[0].isSelected());
		if (current == 5)
			return (radioButton[0].isSelected());
		if (current == 6)
			return (radioButton[1].isSelected());
		if (current == 7)
			return (radioButton[2].isSelected());
		if (current == 8)
			return (radioButton[0].isSelected());
		if (current == 9)
			return (radioButton[3].isSelected());
		return false;
	}
	
	public static int getRandomValue(int Min, int Max) 
    { 
  
        // Get and return the random integer 
        // within Min and Max 
        return ThreadLocalRandom 
            .current() 
            .nextInt(Min, Max + 1); 
    } 

	public static void main(String s[]) {
		new randomquiz("Online Test App");
	}

}
