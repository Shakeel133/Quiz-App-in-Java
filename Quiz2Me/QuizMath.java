
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuizMath extends JFrame implements ActionListener {
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String user_answers[][] = new String[10][1];

    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupOptions;
    JButton next, lifeline, submit;

    public static int timer = 15; // for timer
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;

    String name;

    QuizMath(String name) {
        this.name = name;
        setBounds(0, 0, 1600, 850);
        getContentPane().setBackground(Color.ORANGE);
        setLayout(null);

        // image

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("imgs/Quiz.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1600, 400);
        add(image);

        qno = new JLabel("1");
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);

        question = new JLabel("This is Question no1");
        question.setBounds(150, 450, 1200, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);

        questions[0][0] = " Find the roots of quadratic equation: 3x2 – 7x – 6 = 0? ";
        questions[0][1] = "6, 3";
        questions[0][2] = "3, -2/3";
        questions[0][3] = "-5, 2";
        questions[0][4] = "-9, 2";

        questions[1][0] = "complete the series: 4.8.9.13.14.18.___? ";
        questions[1][1] = "22";
        questions[1][2] = "32";
        questions[1][3] = "11";
        questions[1][4] = "19";

        questions[2][0] = " 1 acre is equal to ____square foot? ";
        questions[2][1] = "45434 square foot";
        questions[2][2] = "34343 square foot";
        questions[2][3] = "43572 square foot";
        questions[2][4] = "43560 square foot ";

        questions[3][0] = " 40 is subtracted from 60% of a number, the result is 50. Find the number? ";
        questions[3][1] = " 150";
        questions[3][2] = " 110 ";
        questions[3][3] = "130 ";
        questions[3][4] = "140 ";

        questions[4][0] = " Find two number whose sum is 28 and the difference is 4 _____?";
        questions[4][1] = " 12,16";
        questions[4][2] = "18,10";
        questions[4][3] = "15,13";
        questions[4][4] = "14,12";

        questions[5][0] = " The Symbol U is read as or Stand for ";
        questions[5][1] = " Micro set";
        questions[5][2] = " Whole set";
        questions[5][3] = " United set";
        questions[5][4] = " Universal set";

        questions[6][0] = " The number that can be expressed in the from of p/q where p and q are intigers and q is not equal to Zero ";
        questions[6][1] = " Reciprocal";
        questions[6][2] = " Additive";
        questions[6][3] = " Rational";
        questions[6][4] = " Non of them";

        questions[7][0] = " The symbol “ <<” is read as a stand for ";
        questions[7][1] = " Ellipsis ";
        questions[7][2] = " If and only if ";
        questions[7][3] = "Correspondence";
        questions[7][4] = "Implies that";

        questions[8][0] = " The symbol “ [ ]” is read as a stand for ? ";
        questions[8][1] = " Parentheses";
        questions[8][2] = " Square Brackets";
        questions[8][3] = " Hybrid Brackets";
        questions[8][4] = " Curley Brackets";

        questions[9][0] = " The smallest of a triangle are in a ratio of 4:5:6. The smallest angle is  ";
        questions[9][1] = "69 degree";
        questions[9][2] = "56 degree";
        questions[9][3] = "41 degree";
        questions[9][4] = "82 degree ";

        // Find below the Answers Array of the above Questions

        answers[0][1] = " 3, -2/3";
        answers[1][1] = " 19 ";
        answers[2][1] = " 43560 square foot ";
        answers[3][1] = " 150 ";
        answers[4][1] = " 12,16";
        answers[5][1] = " Universal Set";
        answers[6][1] = "Rational";
        answers[7][1] = "Correspondence";
        answers[8][1] = " Square Brackets ";
        answers[9][1] = " 41 degree ";

        opt1 = new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);

        groupOptions = new ButtonGroup();
        groupOptions.add(opt1);
        groupOptions.add(opt2);
        groupOptions.add(opt3);
        groupOptions.add(opt4);

        // buttons
        next = new JButton("Next");
        next.setBounds(1100, 550, 200, 40);
        next.setFont(new Font("Tohama", Font.PLAIN, 22));
        next.setBackground(new Color(30, 144, 255));
        next.setBackground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        lifeline = new JButton("50,50 Lifeline");
        lifeline.setBounds(1100, 630, 200, 40);
        lifeline.setFont(new Font("Tohama", Font.PLAIN, 22));
        lifeline.setBackground(new Color(30, 144, 255));
        lifeline.setBackground(Color.WHITE);
        lifeline.addActionListener(this);
        add(lifeline);

        submit = new JButton("Submit");
        submit.setBounds(1100, 710, 200, 40);
        submit.setFont(new Font("Tohama", Font.PLAIN, 22));
        submit.setBackground(new Color(30, 144, 255));
        submit.setBackground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        // function to start
        start(count);

        setVisible(true);

    }

    // for action on button click
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();

            opt1.setEnabled(true); // to make it again enabled
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            ans_given = 1;
            if (groupOptions.getSelection() == null) {
                user_answers[count][0] = "";
            } else {
                user_answers[count][0] = groupOptions.getSelection().getActionCommand();
            }

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count);
        } else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);

        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupOptions.getSelection() == null) {
                user_answers[count][0] = "";
            } else {
                user_answers[count][0] = groupOptions.getSelection().getActionCommand();
            }

            // loop for calculating score
            for (int i = 0; i < user_answers.length; i++) {
                if (user_answers[i][0].equals(answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            // new Score(name,score); // this will open new page for score

        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        String time = "Time left " + timer + " seconds";
        g.setColor(Color.RED);
        g.setFont(new Font("Tohama", Font.BOLD, 25));

        if (timer > 0) {
            g.drawString(time, 1100, 470);
        } else {
            g.drawString("Times up!!", 1100, 500);
        }

        timer--; // 14 after one second

        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            System.out.println("Any eror occured");
            e.printStackTrace();
        }

        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            opt1.setEnabled(true); // to make it again enabled
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            if (count == 9) { // submit

            } else { // next

            }
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            if (count == 9) { // submit
                if (groupOptions.getSelection() == null) {
                    user_answers[count][0] = "";
                } else {
                    user_answers[count][0] = groupOptions.getSelection().getActionCommand();
                }

                // loop for calculating score
                for (int i = 0; i < user_answers.length; i++) {
                    if (user_answers[i][0].equals(answers[i][1])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                setVisible(false);
                // new Score(name,score); // this will open new page for score

                // score

            } else { // next
                if (groupOptions.getSelection() == null) {
                    user_answers[count][0] = "";
                } else {
                    user_answers[count][0] = groupOptions.getSelection().getActionCommand();
                }
                count++;
                start(count); // will use to play next question
            }
        }
    }

    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupOptions.clearSelection();
    }

    public static void main(String[] args) {
        QuizMath Q1 = new QuizMath("User");
    }
}