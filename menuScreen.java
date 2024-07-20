import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ComponentUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;
import java.util.Map;


public class menuScreen extends JFrame implements ActionListener {
    JLabel title = new JLabel();
    JLabel currScore = new JLabel();
    JButton optButton1 = new JButton();
    JButton optButton2 = new JButton();
    JButton optButton3 = new JButton();
    JButton optButton4 = new JButton();
    JButton optButton5 = new JButton();
    JButton optButton6 = new JButton();
    JButton optButton7 = new JButton();
    JButton optButton9 = new JButton();
    JButton optButton10 = new JButton();
    JButton optButton11 = new JButton();
    JButton optButton12 = new JButton();
    JButton choice1 = new JButton();
    JButton choice2 = new JButton();
    JButton choice3 = new JButton();
    JButton choice4 = new JButton();
    JPanel panTitle = new JPanel();
    JPanel panName = new JPanel();
    JPanel panBoard = new JPanel();
    JTextField t1 = new JTextField("username");
    JPasswordField p1 = new JPasswordField("password");
    JPanel panAdmin = new JPanel();
    JPanel panEdit = new JPanel();
    JPanel panPlay = new JPanel();
    JLabel question = new JLabel();
    Gamestate gamestate = new Gamestate();
    Map<String, Boolean> choicesVal;
    List<String> choices;
    String id;
    Boolean ans;
    JTextField input = new JTextField("input");
    String word;
    JButton enter = new JButton();
    JButton confirm = new JButton();
    JTextField questionIn = new JTextField("question");
    JTextField choiceAdd1 = new JTextField("choice 1");
    JTextField choiceAddVal1 = new JTextField("truth value");
    JTextField choiceAdd2 = new JTextField("choice 2");
    JTextField choiceAddVal2 = new JTextField("truth value");
    JTextField choiceAdd3 = new JTextField("choice 3");
    JTextField choiceAddVal3 = new JTextField("truth value");
    JTextField choiceAdd4 = new JTextField("choice 4");
    JTextField choiceAddVal4 = new JTextField("truth value");
    String addType;
    JList<String> panList = new JList<>();
    JButton back = new JButton();
    JLabel pass = new JLabel();
    JLabel name = new JLabel();
    ImageIcon playerIcon = new ImageIcon("C:\\Users\\Hoa's Studies\\IdeaProjects\\millionaire\\src\\playerImage.png");
    JLabel playerLabel = new JLabel();
    ImageIcon mon1Icon = new ImageIcon("C:\\Users\\Hoa's Studies\\IdeaProjects\\millionaire\\src\\mon1.png");
    JLabel mon1Label = new JLabel();
    ImageIcon mon3Icon = new ImageIcon("C:\\Users\\Hoa's Studies\\IdeaProjects\\millionaire\\src\\mon3.png");
    JLabel mon3Label = new JLabel();
    ImageIcon mon5Icon = new ImageIcon("C:\\Users\\Hoa's Studies\\IdeaProjects\\millionaire\\src\\mon5.png");
    JLabel mon5Label = new JLabel();
    ImageIcon healthResIcon = new ImageIcon("C:\\Users\\Hoa's Studies\\IdeaProjects\\millionaire\\src\\healthRes.png");
    JLabel healthResLabel = new JLabel();
    ImageIcon giftAnsIcon = new ImageIcon("C:\\Users\\Hoa's Studies\\IdeaProjects\\millionaire\\src\\giftAns.png");
    JLabel giftAnsLabel = new JLabel();
    ImageIcon doubleScrIcon = new ImageIcon("C:\\Users\\Hoa's Studies\\IdeaProjects\\millionaire\\src\\x2.png");
    JLabel doubleScrLabel = new JLabel();
    JPanel healthbar1 = new JPanel();
    JPanel healthbar2 = new JPanel();
    JPanel healthbar3 = new JPanel();
    JPanel healthbar4 = new JPanel();
    JPanel healthbar5 = new JPanel();
    Monster tempMon = new Monster();
    boolean supp1 = false;
    boolean supp2 = false;
    boolean supp3 = false;
    JScrollPane panScroll = new JScrollPane();
    JLabel boardTitle = new JLabel();

    menuScreen() {
        this.setTitle("Quiz Fighting");
        this.setSize(900, 900);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(0x123456));
        this.setVisible(true);

        titlePanel();
        this.setLayout(null);

        setupUserName();
        setupPass();
        setupBoard();
    }

    private void setupUserName() {
        name.setText("Username");
        name.setForeground(new Color(0xe5e5e5));
        name.setFont(new Font("Chakra Petch", Font.BOLD, 30));
        name.setBounds(250, 325, 150, 30);

        t1.setForeground(new Color(0x939395));
        t1.setBounds(500, 325, 150, 45);

        optButton4.setBounds(350, 425, 150, 50);
        optButton4.setText("Confirm");
        optButton4.setFocusable(false);
        optButton4.setHorizontalTextPosition(JLabel.CENTER);
        optButton4.setVerticalTextPosition(JLabel.CENTER);
        optButton4.setForeground(new Color(0xe5e5e5));
        optButton4.setFont(new Font("Chakra Petch", Font.BOLD, 30));
        optButton4.setBackground(new Color(0x9b80ed));
        optButton4.addActionListener(this);

        back.setBounds(150, 700, 150, 50);
        back.setText("Back");
        back.setFocusable(false);
        back.setHorizontalTextPosition(JLabel.CENTER);
        back.setVerticalTextPosition(JLabel.CENTER);
        back.setForeground(new Color(0xe5e5e5));
        back.setFont(new Font("Chakra Petch", Font.BOLD, 30));
        back.setBackground(new Color(0x9b80ed));
        back.addActionListener(this);

        panName.add(name);
        panName.add(t1);
        panName.add(back);
        panName.add(optButton4);
        panName.setBorder(new EmptyBorder(5, 5, 5, 5));
        panName.setLayout(null);
        panName.setBackground(new Color(0x123456));
    }

    public void setupPass() {
        pass.setText("Password");
        pass.setForeground(new Color(0xe5e5e5));
        pass.setFont(new Font("Chakra Petch", Font.BOLD, 30));
        pass.setBounds(250, 425, 150, 30);

        p1.setForeground(new Color(0x939395));
        p1.setBounds(500, 425, 150, 50);

        optButton5.setBounds(380, 525, 130, 50);
        optButton5.setText("Login");
        optButton5.setFocusable(false);
        optButton5.setHorizontalTextPosition(JLabel.CENTER);
        optButton5.setVerticalTextPosition(JLabel.CENTER);
        optButton5.setForeground(new Color(0xe5e5e5));
        optButton5.setFont(new Font("Chakra Petch", Font.BOLD, 30));
        optButton5.setBackground(new Color(0x9b80ed));
        optButton5.addActionListener(this);

        panName.add(pass);
        panName.add(p1);
        panName.add(optButton5);
    }

    public void setupBoard() {
        boardTitle.setText("Leader Board");
        boardTitle.setHorizontalTextPosition(JLabel.CENTER);
        boardTitle.setVerticalTextPosition(JLabel.CENTER);
        boardTitle.setForeground(new Color(0xe5e5e5));
        boardTitle.setFont(new Font("Chakra Petch", Font.BOLD, 50));
        boardTitle.setHorizontalAlignment(JLabel.CENTER);
        boardTitle.setVerticalAlignment(JLabel.TOP);
        boardTitle.setBounds(275, 200, 350, 70);

        Border line = BorderFactory.createLineBorder(new Color(0xFEE59A), 3);

        panBoard.setBounds(100, 250, 700, 550);
        panBoard.setLayout(new BoxLayout(panBoard, BoxLayout.Y_AXIS));
        panBoard.setBackground(new Color(0x123456));
        panBoard.setVisible(true);

        List<String> board = gamestate.displayBoard();
        for (int i = 0; i < 5; i++) {
            JLabel label = new JLabel(board.get(i));
            label.setForeground(Color.white);
            label.setFont(new Font("Chakra Petch", Font.BOLD, 30));
            label.setBackground(Color.white);
            panBoard.add(label);
        }

        panScroll.setViewportView(panBoard);
        panScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panScroll.setBorder(line);
        panScroll.setBounds(175, 300, 500, 300);

        panName.add(boardTitle);
        panName.add(panScroll);
    }

    private void titlePanel() {
        title.setText("Quiz Fighting");
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setVerticalTextPosition(JLabel.CENTER);
        title.setForeground(new Color(0xe5e5e5));
        title.setFont(new Font("Chakra Petch", Font.BOLD, 50));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.TOP);
        title.setBounds(275, 265, 350, 70);

        panTitle.setBorder(new EmptyBorder(5, 5, 5, 5));
        panTitle.add(title);
        panTitle.setBackground(new Color(0x123456));
        panTitle.setLayout(null);

        optButton1.setBounds(390, 400, 100, 50);
        optButton1.addActionListener(this);
        optButton1.setText("Play");
        optButton1.setFocusable(false);
        optButton1.setHorizontalTextPosition(JLabel.CENTER);
        optButton1.setVerticalTextPosition(JLabel.CENTER);
        optButton1.setForeground(new Color(0xe5e5e5));
        optButton1.setFont(new Font("Chakra Petch", Font.BOLD, 30));
        optButton1.setBackground(new Color(0x9b80ed));

        optButton2.setBounds(335, 475, 215, 50);
        optButton2.addActionListener(this);
        optButton2.setText("Score Board");
        optButton2.setFocusable(false);
        optButton2.setHorizontalTextPosition(JLabel.CENTER);
        optButton2.setVerticalTextPosition(JLabel.CENTER);
        optButton2.setForeground(new Color(0xe5e5e5));
        optButton2.setFont(new Font("Chakra Petch", Font.BOLD, 30));
        optButton2.setBackground(new Color(0x9b80ed));

        optButton3.setBounds(380, 550, 125, 50);
        optButton3.addActionListener(this);
        optButton3.setText("Admin");
        optButton3.setFocusable(false);
        optButton3.setHorizontalTextPosition(JLabel.CENTER);
        optButton3.setVerticalTextPosition(JLabel.CENTER);
        optButton3.setForeground(new Color(0xe5e5e5));
        optButton3.setFont(new Font("Chakra Petch", Font.BOLD, 30));
        optButton3.setBackground(new Color(0x9b80ed));

        panTitle.add(optButton1);
        panTitle.add(optButton2);
        panTitle.add(optButton3);

        this.setContentPane(panTitle);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == optButton1) {   //play, go to username page
            handleOptButton1();
        }

        if (e.getSource() == optButton2) {  //leaderboard
            handleOptButton2();
        }

        if (e.getSource() == optButton3) {  //login admin
            handleOptButton3();
        }

        if (e.getSource() == optButton4) {
            handleOptButton4();
        }

        if (e.getSource() == enter) {
            handleEnter();
        }

        if (e.getSource() == choice1) {
            handleChoice1();
        }

        if (e.getSource() == choice2) {
            handleChoice2();
        }

        if (e.getSource() == choice3) {
            handleChoice3();
        }

        if (e.getSource() == choice4) {
            handleChoice4();
        }

        if (e.getSource() == optButton5) {
            handleOptButton5();
        }

        if (e.getSource() == optButton6) {     //Add question
            handleOptButton6();
        }

        if (e.getSource() == optButton10) {                  //add multiple choice question
            handleOptButton10();
        }

        if (e.getSource() == confirm) {
            handleConfirm();
        }

        if (e.getSource() == optButton11) {                 //add true false question
            handleOptButton11();
        }

        if (e.getSource() == optButton12) {                //add fill the blank question
            handleOptButton12();
        }

        if (e.getSource() == optButton7) {                //remove question
            handleOptButton7();
        }

        if (e.getSource() == optButton9) {               //display all
            handleOptButton9();
        }

        if (e.getSource() == back) {
            panName.setVisible(false);
            panTitle.setVisible(true);

            this.setContentPane(panTitle);
        }
    }

    private void handleOptButton9() {
        panAdmin.setVisible(false);

        JPanel panDisplay = new JPanel();

        title.setText("All questions and answers");
        title.setBounds(100, 160, 700, 100);

        Border line = BorderFactory.createLineBorder(new Color(0xFEE59A), 5);

        panDisplay.setBounds(60, 60, 100, 70);
        panDisplay.setLayout(new BoxLayout(panDisplay, BoxLayout.Y_AXIS));
        panDisplay.setBackground(new Color(0x123456));
        panDisplay.setVisible(true);

        List<String> list;
        list = gamestate.admin.displayAll();

        for (int i = 0; i < list.size(); i++) {
            JLabel label = new JLabel(list.get(i));
            label.setForeground(Color.white);
            label.setFont(new Font("Chakra Petch", Font.BOLD, 20));
            panDisplay.add(label);
        }

        JScrollPane panScroll = new JScrollPane();
        panScroll.setViewportView(panDisplay);
        panScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panScroll.setBorder(line);
        panScroll.setBounds(100, 250, 700, 550);

        panEdit.add(title);
        panEdit.add(panScroll);
        panEdit.setBorder(new EmptyBorder(5, 5, 5, 5));
        panEdit.setLayout(null);
        panEdit.setBackground(new Color(0x123456));
        panEdit.setVisible(true);

        this.setContentPane(panEdit);
    }

    private void handleOptButton7() {
        panAdmin.setVisible(false);

        JPanel panDisplay = new JPanel();

        title.setText("Choose the question to remove");
        title.setFont(new Font("Chakra Petch", Font.BOLD, 30));
        title.setBounds(100, 160, 700, 100);

        Border line = BorderFactory.createLineBorder(new Color(0xFEE59A), 5);

        panDisplay.setBounds(60, 60, 100, 70);
        panDisplay.setLayout(new BoxLayout(panDisplay, BoxLayout.Y_AXIS));
        panDisplay.setBackground(new Color(0x123456));
        panDisplay.setVisible(true);

        List<String> list;
        list = gamestate.admin.displayOnlyQues();

        for (int i = 0; i < list.size(); i++) {
            JLabel label = new JLabel(list.get(i));
            label.setForeground(Color.white);
            label.setFont(new Font("Chakra Petch", Font.BOLD, 20));
            panDisplay.add(label);
        }

        final DefaultListModel<String> l1 = new DefaultListModel<>();
        for (int i = 0; i < list.size(); i++) {
            l1.addElement(list.get(i));
        }

        panList.setModel(l1);

        JScrollPane panScroll = new JScrollPane();
        panScroll.setViewportView(panList);
        panScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panScroll.setBorder(line);
        panScroll.setBounds(100, 250, 700, 350);

        addType = "remove";

        confirm.setBounds(360, 650, 200, 50);
        confirm.addActionListener(this);
        confirm.setText("Confirm");
        confirm.setFocusable(false);
        confirm.setHorizontalTextPosition(JLabel.CENTER);
        confirm.setVerticalTextPosition(JLabel.CENTER);
        confirm.setForeground(new Color(0xe5e5e5));
        confirm.setFont(new Font("Chakra Petch", Font.BOLD, 30));
        confirm.setBackground(new Color(0x9b80ed));

        panEdit.add(title);
        panEdit.add(confirm);
        panEdit.add(panScroll);
        panEdit.setBorder(new EmptyBorder(5, 5, 5, 5));
        panEdit.setLayout(null);
        panEdit.setBackground(new Color(0x123456));
        panEdit.setVisible(true);

        this.setContentPane(panEdit);
    }

    private void handleOptButton11() {
        addType = "TF";

        questionIn.setForeground(new Color(0x939395));
        questionIn.setBounds(230, 300, 450, 45);
        questionIn.setHorizontalAlignment(JTextField.CENTER);

        choiceAdd1.setForeground(new Color(0x939395));
        choiceAdd1.setBounds(380, 400, 150, 45);
        choiceAdd1.setHorizontalAlignment(JTextField.CENTER);
        choiceAdd1.setText("truth value");

        panEdit.remove(optButton10);
        panEdit.remove(optButton11);
        panEdit.remove(optButton12);

        title.setText("<html>Enter the question along<br>with the truth value</html>");
        title.setBounds(100, 160, 700, 100);

        confirm.setBounds(372, 550, 150, 45);
        confirm.addActionListener(this);

        panEdit.add(questionIn);
        panEdit.add(choiceAdd1);
        panEdit.add(confirm);

        panEdit.setBorder(new EmptyBorder(5, 5, 5, 5));
        panEdit.setLayout(null);
        panEdit.setBackground(new Color(0x123456));
        panEdit.setVisible(true);

        this.setContentPane(panEdit);
    }

    private void handleOptButton12() {
        addType = "FB";

        questionIn.setText("question or word description");
        choiceAdd1.setText("word");

        questionIn.setForeground(new Color(0x939395));
        questionIn.setBounds(230, 300, 450, 45);
        questionIn.setHorizontalAlignment(JTextField.CENTER);

        choiceAdd1.setForeground(new Color(0x939395));
        choiceAdd1.setBounds(380, 400, 150, 45);
        choiceAdd1.setHorizontalAlignment(JTextField.CENTER);

        panEdit.remove(optButton10);
        panEdit.remove(optButton11);
        panEdit.remove(optButton12);

        title.setText("<html>Enter the question along<br>with the word</html>");
        title.setBounds(100, 160, 700, 100);

        confirm.setBounds(372, 550, 150, 45);
        confirm.addActionListener(this);

        panEdit.add(questionIn);
        panEdit.add(choiceAdd1);
        panEdit.add(confirm);

        panEdit.setBorder(new EmptyBorder(5, 5, 5, 5));
        panEdit.setLayout(null);
        panEdit.setBackground(new Color(0x123456));
        panEdit.setVisible(true);

        this.setContentPane(panEdit);
    }

    private void handleConfirm() {
        if (addType.equals("MC")) {
            String typeIdentifier = addType;
            String questionAdd = questionIn.getText();
            String[] choices = {choiceAdd1.getText(), choiceAdd2.getText(),
                    choiceAdd3.getText(), choiceAdd4.getText()};
            String[] answers = {choiceAddVal1.getText(), choiceAddVal2.getText(),
                    choiceAddVal3.getText(), choiceAddVal4.getText()};

            boolean flag =
                    gamestate.admin.addMCQuestion(typeIdentifier, questionAdd, choices, answers);

            if (flag) {
                JOptionPane.showMessageDialog(confirm, "Question added successfully");
            } else {
                JOptionPane.showMessageDialog(confirm, "Question already exists.");
            }
        }

        if (addType.equals("TF")) {
            String typeIdentifier = addType;
            String questionAdd = questionIn.getText();
            String answer = choiceAdd1.getText();

            boolean flag =
                    gamestate.admin.addTFQuestion(typeIdentifier, questionAdd, answer);

            if (flag) {
                JOptionPane.showMessageDialog(confirm, "Question added successfully");
            } else {
                JOptionPane.showMessageDialog(confirm, "Question already exists or" +
                        " invalid truth input.");
            }
        }

        if (addType.equals("FB")) {
            String typeIdentifier = addType;
            String questionAdd = questionIn.getText();
            String answer = choiceAdd1.getText();

            boolean flag =
                    gamestate.admin.addFBQuestion(typeIdentifier, questionAdd, answer);

            if (flag) {
                JOptionPane.showMessageDialog(confirm, "Question added successfully");
            } else {
                JOptionPane.showMessageDialog(confirm, "Question already exists.");
            }
        }

        if (addType.equals("remove")) {
            String questionDescription;
            if (panList.getSelectedIndex() != -1) {
                questionDescription = panList.getSelectedValue();
                try {
                    boolean flag = gamestate.admin.removeQuestion(questionDescription);
                    if (flag) {
                        JOptionPane.showMessageDialog(confirm, "Question removed successfully.");
                    } else {
                        JOptionPane.showMessageDialog(confirm, "Question not found.");
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    private void handleOptButton10() {
        addType = "MC";

        questionIn.setForeground(new Color(0x939395));
        questionIn.setBounds(230, 300, 450, 45);
        questionIn.setHorizontalAlignment(JTextField.CENTER);

        choiceAdd1.setForeground(new Color(0x939395));
        choiceAdd1.setBounds(200, 400, 150, 45);
        choiceAdd1.setHorizontalAlignment(JTextField.CENTER);
        choiceAdd2.setForeground(new Color(0x939395));
        choiceAdd2.setBounds(200, 500, 150, 45);
        choiceAdd2.setHorizontalAlignment(JTextField.CENTER);
        choiceAdd3.setForeground(new Color(0x939395));
        choiceAdd3.setBounds(200, 600, 150, 45);
        choiceAdd3.setHorizontalAlignment(JTextField.CENTER);
        choiceAdd4.setForeground(new Color(0x939395));
        choiceAdd4.setBounds(200, 700, 150, 45);
        choiceAdd4.setHorizontalAlignment(JTextField.CENTER);

        choiceAddVal1.setForeground(new Color(0x939395));
        choiceAddVal1.setBounds(550, 400, 150, 45);
        choiceAddVal1.setHorizontalAlignment(JTextField.CENTER);
        choiceAddVal2.setForeground(new Color(0x939395));
        choiceAddVal2.setBounds(550, 500, 150, 45);
        choiceAddVal2.setHorizontalAlignment(JTextField.CENTER);
        choiceAddVal3.setForeground(new Color(0x939395));
        choiceAddVal3.setBounds(550, 600, 150, 45);
        choiceAddVal3.setHorizontalAlignment(JTextField.CENTER);
        choiceAddVal4.setForeground(new Color(0x939395));
        choiceAddVal4.setBounds(550, 700, 150, 45);
        choiceAddVal4.setHorizontalAlignment(JTextField.CENTER);

        confirm.setBounds(372, 745, 150, 45);
        confirm.addActionListener(this);

        panEdit.remove(optButton10);
        panEdit.remove(optButton11);
        panEdit.remove(optButton12);

        title.setText("<html>Enter the question and choices<br>along with choices truth value</html>");
        title.setBounds(100, 160, 700, 100);

        panEdit.add(questionIn);
        panEdit.add(choiceAdd1);
        panEdit.add(choiceAdd2);
        panEdit.add(choiceAdd3);
        panEdit.add(choiceAdd4);
        panEdit.add(choiceAddVal1);
        panEdit.add(choiceAddVal2);
        panEdit.add(choiceAddVal3);
        panEdit.add(choiceAddVal4);
        panEdit.add(confirm);

        panEdit.setBorder(new EmptyBorder(5, 5, 5, 5));
        panEdit.setLayout(null);
        panEdit.setBackground(new Color(0x123456));
        panEdit.setVisible(true);

        this.setContentPane(panEdit);
    }

    private void handleOptButton6() {
        panAdmin.setVisible(false);

        title.setText("Choose the type of question");
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setVerticalTextPosition(JLabel.CENTER);
        title.setForeground(new Color(0xe5e5e5));
        title.setFont(new Font("Chakra Petch", Font.BOLD, 35));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.TOP);
        title.setBounds(215, 160, 500, 70);

        optButton10.setBounds(300, 300, 300, 50);
        optButton10.addActionListener(this);
        optButton10.setText("Multiple Choices");
        optButton10.setFocusable(false);
        optButton10.setHorizontalTextPosition(JLabel.CENTER);
        optButton10.setVerticalTextPosition(JLabel.CENTER);
        optButton10.setForeground(new Color(0xe5e5e5));
        optButton10.setFont(new Font("Chakra Petch", Font.BOLD, 30));
        optButton10.setBackground(new Color(0x9b80ed));

        optButton11.setBounds(300, 400, 300, 50);
        optButton11.addActionListener(this);
        optButton11.setText("True False");
        optButton11.setFocusable(false);
        optButton11.setHorizontalTextPosition(JLabel.CENTER);
        optButton11.setVerticalTextPosition(JLabel.CENTER);
        optButton11.setForeground(new Color(0xe5e5e5));
        optButton11.setFont(new Font("Chakra Petch", Font.BOLD, 30));
        optButton11.setBackground(new Color(0x9b80ed));

        optButton12.setBounds(300, 500, 300, 50);
        optButton12.addActionListener(this);
        optButton12.setText("Fill the Blank");
        optButton12.setFocusable(false);
        optButton12.setHorizontalTextPosition(JLabel.CENTER);
        optButton12.setVerticalTextPosition(JLabel.CENTER);
        optButton12.setForeground(new Color(0xe5e5e5));
        optButton12.setFont(new Font("Chakra Petch", Font.BOLD, 30));
        optButton12.setBackground(new Color(0x9b80ed));

        confirm.setText("Confirm");
        confirm.setFocusable(false);
        confirm.setHorizontalTextPosition(JLabel.CENTER);
        confirm.setVerticalTextPosition(JLabel.CENTER);
        confirm.setForeground(new Color(0xe5e5e5));
        confirm.setFont(new Font("Chakra Petch", Font.BOLD, 30));
        confirm.setBackground(new Color(0x9b80ed));

        panEdit.add(optButton10);
        panEdit.add(optButton11);
        panEdit.add(optButton12);
        panEdit.add(title);

        panEdit.setBorder(new EmptyBorder(5, 5, 5, 5));
        panEdit.setLayout(null);
        panEdit.setBackground(new Color(0x123456));
        panEdit.setVisible(true);

        this.setContentPane(panEdit);
    }

    private void handleOptButton5() {
        String username = t1.getText();
        String password = p1.getText();
        if (username.equals(gamestate.admin.getUsername())
                && password.equals(gamestate.admin.getPassword())) {
            panName.setVisible(false);

            optButton6.setBounds(285, 350, 300, 50);
            optButton6.setText("Add Question");
            optButton6.setFocusable(false);
            optButton6.setHorizontalTextPosition(JLabel.CENTER);
            optButton6.setVerticalTextPosition(JLabel.CENTER);
            optButton6.setForeground(new Color(0xe5e5e5));
            optButton6.setFont(new Font("Chakra Petch", Font.BOLD, 30));
            optButton6.setBackground(new Color(0x9b80ed));
            optButton6.addActionListener(this);

            optButton7.setBounds(285, 425, 300, 50);
            optButton7.setText("Remove Question");
            optButton7.setFocusable(false);
            optButton7.setHorizontalTextPosition(JLabel.CENTER);
            optButton7.setVerticalTextPosition(JLabel.CENTER);
            optButton7.setForeground(new Color(0xe5e5e5));
            optButton7.setFont(new Font("Chakra Petch", Font.BOLD, 30));
            optButton7.setBackground(new Color(0x9b80ed));
            optButton7.addActionListener(this);

            optButton9.setBounds(260, 500, 350, 50);
            optButton9.setText("Display All Questions");
            optButton9.setFocusable(false);
            optButton9.setHorizontalTextPosition(JLabel.CENTER);
            optButton9.setVerticalTextPosition(JLabel.CENTER);
            optButton9.setForeground(new Color(0xe5e5e5));
            optButton9.setFont(new Font("Chakra Petch", Font.BOLD, 30));
            optButton9.setBackground(new Color(0x9b80ed));
            optButton9.addActionListener(this);

            panAdmin.add(optButton6);
            panAdmin.add(optButton7);
            panAdmin.add(optButton9);
            panAdmin.setBorder(new EmptyBorder(5, 5, 5, 5));
            panAdmin.setLayout(null);
            panAdmin.setBackground(new Color(0x123456));
            panAdmin.setVisible(true);

            this.setContentPane(panAdmin);
        } else {
            JOptionPane.showMessageDialog(optButton5, "Wrong username or password");
        }
    }

    private void handleChoice4() {
        if (gamestate.getSizeMon() != 0){
            if (supp2 == true){
                choice4.setForeground(Color.green);
                tempMon.attacked(100);
                nextQuestion();
                supp2 = false;
                giftAnsLabel.setVisible(false);
            }
            else{
                if (choicesVal.get(choices.get(3)) == Boolean.FALSE) {
                    choice4.setBackground(Color.RED);
                    gamestate.player.attacked(tempMon.getAttackDmg());
                    nextQuestion();
                } else {
                    if (supp3 == true) {
                        gamestate.player.doubleScore();
                        supp3 = false;
                        doubleScrLabel.setVisible(false);
                    } else {
                        gamestate.player.updateScore();
                    }
                    choice4.setBackground(Color.green);
                    tempMon.attacked(100);
                    nextQuestion();
                }
                this.setContentPane(panPlay);
            }
        }
        if (gamestate.player.getHealth() <= 0) {
            JOptionPane.showMessageDialog(panPlay, "Game Over...");
            gamestate.board.updateLeaderboard(gamestate.player.getUsername(), gamestate.player.getScore());
            panPlay.setVisible(false);
            panTitle.setVisible(true);

            this.setContentPane(panTitle);
        }
    }

    private void handleChoice3() {
        if (id.equals("MC")) {
            if (gamestate.getSizeMon() != 0){
                if (supp2 == true){
                    choice1.setBackground(Color.green);
                    tempMon.attacked(100);
                    nextQuestion();
                    supp2 = false;
                    giftAnsLabel.setVisible(false);
                }
                else{
                    if (choicesVal.get(choices.get(0)) == Boolean.FALSE) {
                        choice3.setBackground(Color.RED);
                        gamestate.player.attacked(tempMon.getAttackDmg());
                        nextQuestion();
                    } else {
                        if (supp3 == true) {
                            gamestate.player.doubleScore();
                            supp3 = false;
                            doubleScrLabel.setVisible(false);
                        } else {
                            gamestate.player.updateScore();
                        }
                        choice3.setBackground(Color.green);
                        tempMon.attacked(100);
                        nextQuestion();
                    }
                }
            }
            gameOver();
        }
        if (id.equals("TF")) {
            if (gamestate.getSizeMon() != 0){
                if (supp2 == true) {
                    choice3.setForeground(Color.green);
                    tempMon.attacked(100);
                    nextQuestion();
                    supp2 = false;
                    giftAnsLabel.setVisible(false);
                }
                else{
                    if (ans) {
                        choice3.setBackground(Color.RED);
                        gamestate.player.attacked(tempMon.getAttackDmg());
                        tempMon.attacked(100);
                        nextQuestion();
                    }
                    if (!ans) {
                        {
                            if (supp3 == true) {
                                gamestate.player.doubleScore();
                                supp3 = false;
                                doubleScrLabel.setVisible(false);
                            } else {
                                gamestate.player.updateScore();
                            }
                            choice3.setBackground(Color.green);
                            tempMon.attacked(100);
                            nextQuestion();
                        }
                    }
                    this.setContentPane(panPlay);
                }
            }
            gameOver();
        }
    }

    private void handleChoice2() {
        if (gamestate.getSizeMon() != 0){
            if (supp2 == true){
                choice2.setForeground(Color.green);
                tempMon.attacked(100);
                nextQuestion();
                supp2 = false;
                giftAnsLabel.setVisible(false);
            }
            else{
                if (choicesVal.get(choices.get(1)) == Boolean.FALSE) {
                    choice2.setBackground(Color.RED);
                    gamestate.player.attacked(tempMon.getAttackDmg());
                    nextQuestion();
                } else {
                    if (supp3 == true) {
                        gamestate.player.doubleScore();
                        supp3 = false;
                        doubleScrLabel.setVisible(false);
                    } else {
                        gamestate.player.updateScore();
                    }
                    choice2.setBackground(Color.green);
                    tempMon.attacked(100);
                    nextQuestion();
                }
                this.setContentPane(panPlay);
            }
        }
        if (gamestate.player.getHealth() <= 0) {
            JOptionPane.showMessageDialog(panPlay, "Game Over...");
            gamestate.board.updateLeaderboard(gamestate.player.getUsername(), gamestate.player.getScore());
            panPlay.setVisible(false);
            panTitle.setVisible(true);

            this.setContentPane(panTitle);
        }
    }

    private void handleChoice1() {
        if (id.equals("MC")) {
            if (gamestate.getSizeMon() != 0) {
                if (supp2 == true) {
                    choice1.setBackground(Color.green);
                    tempMon.attacked(100);
                    nextQuestion();
                    supp2 = false;
                    giftAnsLabel.setVisible(false);
                } else {
                    if (choicesVal.get(choices.get(0)) == Boolean.FALSE) {
                        choice1.setBackground(Color.RED);
                        gamestate.player.attacked(tempMon.getAttackDmg());
                        nextQuestion();
                    } else {
                        if (supp3 == true) {
                            gamestate.player.doubleScore();
                            supp3 = false;
                            doubleScrLabel.setVisible(false);
                        } else {
                            gamestate.player.updateScore();
                        }
                        choice1.setBackground(Color.green);
                        tempMon.attacked(100);
                        nextQuestion();
                    }
                }
            }
            gameOver();
        }
        if (id.equals("TF")) {
            if (gamestate.getSizeMon() != 0) {
                if (supp2 == true) {
                    choice1.setForeground(Color.green);
                    tempMon.attacked(100);
                    nextQuestion();
                    supp2 = false;
                    giftAnsLabel.setVisible(false);
                } else {
                    if (ans) {
                        if (supp3 == true) {
                            gamestate.player.doubleScore();
                            supp3 = false;
                            doubleScrLabel.setVisible(false);
                        } else {
                            gamestate.player.updateScore();
                        }
                        choice1.setBackground(Color.green);
                        tempMon.attacked(100);
                        nextQuestion();
                    }
                    if (!ans) {
                        {
                            choice1.setBackground(Color.RED);
                            gamestate.player.attacked(tempMon.getAttackDmg());
                            nextQuestion();
                        }
                    }
                    this.setContentPane(panPlay);
                }
            }
            gameOver();
        }
    }

    private void handleEnter() {                          //check fill the blank player ans and setup next question
        if (gamestate.getSizeMon() != 0) {
            if (supp2 == true) {
                input.setForeground(Color.green);
                tempMon.attacked(100);
                nextQuestion();
                supp2 = false;
                giftAnsLabel.setVisible(false);
            } else {
                String userInput = input.getText();
                if (userInput.equals(word)) {
                    if (supp3 == true) {
                        gamestate.player.doubleScore();
                        supp3 = false;
                        doubleScrLabel.setVisible(false);
                    } else {
                        gamestate.player.updateScore();
                    }
                    input.setForeground(Color.green);
                    tempMon.attacked(100);
                    nextQuestion();
                } else {
                    input.setForeground(Color.RED);
                    gamestate.player.attacked(tempMon.getAttackDmg());
                    nextQuestion();
                }
                this.setContentPane(panPlay);
            }
        }
        if (gamestate.player.getHealth() <= 0) {
            JOptionPane.showMessageDialog(panPlay, "Game Over...");
            gamestate.board.updateLeaderboard(gamestate.player.getUsername(), gamestate.player.getScore());
            panPlay.setVisible(false);
            panTitle.setVisible(true);

            this.setContentPane(panTitle);
        }
    }

    private void setUpPlay() {
        panPlay.add(playerLabel);
        if (gamestate.player.getHealth() == 400) {
            healthbar5.setVisible(false);
        }
        if (gamestate.player.getHealth() == 300) {
            healthbar4.setVisible(false);
            healthbar5.setVisible(false);
        }
        if (gamestate.player.getHealth() == 200) {
            healthbar3.setVisible(false);
            healthbar4.setVisible(false);
            healthbar5.setVisible(false);
        }
        if (gamestate.player.getHealth() == 100) {
            healthbar2.setVisible(false);
            healthbar3.setVisible(false);
            healthbar4.setVisible(false);
            healthbar5.setVisible(false);
        }
        currScore.setText("Score: " + gamestate.player.getScore());
        panPlay.add(currScore);

        if (supp1 == true) {
            healthResLabel.setVisible(false);
        }
        if (supp2 == true) {
            giftAnsLabel.setVisible(false);
        }
        if (supp3 == true) {
            doubleScrLabel.setVisible(false);
        }
    }

    private void handleOptButton4() {
        String name = t1.getText();
        boolean check = gamestate.checkPlayerName(name);
        if (!check) {
            gamestate.setPlayerName(name);

            panName.setVisible(false);

            playerLabel.setIcon(playerIcon);
            playerLabel.setBounds(0, 350, 205, 150);
            playerLabel.setVisible(true);
            panPlay.add(playerLabel);

            Border line = BorderFactory.createLineBorder(new Color(0xFEE59A), 5);

            mon1Label.setIcon(mon1Icon);
            mon1Label.setBounds(650, 100, 205, 150);
            mon1Label.setVisible(true);

            mon3Label.setIcon(mon3Icon);
            mon3Label.setBounds(650, 150, 250, 200);
            mon3Label.setVisible(true);

            mon5Label.setIcon(mon5Icon);
            mon5Label.setBounds(650, 100, 205, 200);
            mon5Label.setVisible(true);

            Border healthLine = BorderFactory.createLineBorder(new Color(0xFEE59A), 2);

            healthbar1.setBackground(Color.red);
            healthbar1.setBounds(50, 325, 30, 15);
            healthbar1.setBorder(healthLine);
            panPlay.add(healthbar1);
            healthbar2.setBackground(Color.red);
            healthbar2.setBounds(80, 325, 30, 15);
            healthbar2.setBorder(healthLine);
            panPlay.add(healthbar2);
            healthbar3.setBackground(Color.red);
            healthbar3.setBounds(110, 325, 30, 15);
            healthbar3.setBorder(healthLine);
            panPlay.add(healthbar3);
            healthbar4.setBackground(Color.red);
            healthbar4.setBounds(140, 325, 30, 15);
            healthbar4.setBorder(healthLine);
            panPlay.add(healthbar4);
            healthbar5.setBackground(Color.red);
            healthbar5.setBounds(170, 325, 30, 15);
            healthbar5.setBorder(healthLine);
            panPlay.add(healthbar5);

            currScore.setText("Score: " + gamestate.player.getScore());
            currScore.setForeground(new Color(0xe5e5e5));
            currScore.setFont(new Font("Chakra Petch", Font.BOLD, 20));
            currScore.setBounds(25, 10, 200, 50);
            panPlay.add(currScore);

            healthResLabel.setIcon(healthResIcon);
            healthResLabel.setBounds(20, 70, 100, 50);
            healthResLabel.setVisible(true);
            healthResLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    healthClicked();
                }
            });
            panPlay.add(healthResLabel);

            giftAnsLabel.setIcon(giftAnsIcon);
            giftAnsLabel.setBounds(20, 120, 100, 50);
            giftAnsLabel.setVisible(true);
            giftAnsLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    giftClicked();
                }
            });
            panPlay.add(giftAnsLabel);

            doubleScrLabel.setIcon(doubleScrIcon);
            doubleScrLabel.setBounds(17, 170, 100, 50);
            doubleScrLabel.setVisible(true);
            doubleScrLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    x2Clicked();
                }
            });
            panPlay.add(doubleScrLabel);

            question.setBorder(line);
            question.setText(gamestate.getQuestion());
            question.setForeground(new Color(0xe5e5e5));
            question.setFont(new Font("Chakra Petch", Font.BOLD, 20));
            question.setBounds(0, 500, 885, 100);

            id = gamestate.getId();

            choice1.addActionListener(this);
            choice1.setFocusable(false);
            choice1.setHorizontalTextPosition(JLabel.CENTER);
            choice1.setVerticalTextPosition(JLabel.CENTER);
            choice1.setForeground(new Color(0xe5e5e5));
            choice1.setFont(new Font("Chakra Petch", Font.BOLD, 20));
            choice1.setBackground(new Color(0x9b80ed));
            choice1.setBounds(0, 655, 350, 55);

            choice2.addActionListener(this);
            choice2.setFocusable(false);
            choice2.setHorizontalTextPosition(JLabel.CENTER);
            choice2.setVerticalTextPosition(JLabel.CENTER);
            choice2.setForeground(new Color(0xe5e5e5));
            choice2.setFont(new Font("Chakra Petch", Font.BOLD, 20));
            choice2.setBackground(new Color(0x9b80ed));
            choice2.setBounds(0, 750, 350, 55);

            choice3.addActionListener(this);
            choice3.setFocusable(false);
            choice3.setHorizontalTextPosition(JLabel.CENTER);
            choice3.setVerticalTextPosition(JLabel.CENTER);
            choice3.setForeground(new Color(0xe5e5e5));
            choice3.setFont(new Font("Chakra Petch", Font.BOLD, 20));
            choice3.setBackground(new Color(0x9b80ed));
            choice3.setBounds(535, 655, 350, 55);

            choice4.addActionListener(this);
            choice4.setFocusable(false);
            choice4.setHorizontalTextPosition(JLabel.CENTER);
            choice4.setVerticalTextPosition(JLabel.CENTER);
            choice4.setForeground(new Color(0xe5e5e5));
            choice4.setFont(new Font("Chakra Petch", Font.BOLD, 20));
            choice4.setBackground(new Color(0x9b80ed));
            choice4.setBounds(535, 750, 350, 55);

            input.setForeground(new Color(0x939395));
            input.setBounds(275, 650, 350, 55);

            enter.setBounds(300, 725, 300, 50);
            enter.setText("Confirm");
            enter.addActionListener(this);
            enter.setFocusable(false);
            enter.setHorizontalTextPosition(JLabel.CENTER);
            enter.setVerticalTextPosition(JLabel.CENTER);
            enter.setForeground(new Color(0xe5e5e5));
            enter.setFont(new Font("Chakra Petch", Font.BOLD, 30));
            enter.setBackground(new Color(0x9b80ed));

            panPlay.setBorder(new EmptyBorder(5, 5, 5, 5));
            panPlay.setLayout(null);
            panPlay.setBackground(new Color(0x123456));

            tempMon = gamestate.getMonster();
            gamestate.removeMonster();

            if (tempMon.getType() == 1) {
                panPlay.add(mon1Label);
            }

            if (tempMon.getType() == 3) {
                panPlay.add(mon3Label);
            }

            if (tempMon.getType() == 5) {
                panPlay.add(mon5Label);
            }

            panPlay.add(question);

            if (id.equals("MC")) {
                choicesVal = gamestate.getChoiceVal();
                choices = gamestate.getChoice();

                choice1.setText(choices.get(0));
                choice2.setText(choices.get(1));
                choice3.setText(choices.get(2));
                choice4.setText(choices.get(3));

                panPlay.add(choice1);
                panPlay.add(choice2);
                panPlay.add(choice3);
                panPlay.add(choice4);
            }

            if (id.equals("TF")) {
                ans = gamestate.getAns();
                gamestate.removeQuestion();

                choice1.setText("TRUE");
                choice3.setText("FALSE");

                panPlay.add(choice1);
                panPlay.add(choice3);
            }

            if (id.equals("FB")) {
                word = gamestate.getWord();
                gamestate.removeQuestion();

                panPlay.add(input);
                panPlay.add(enter);
            }

            panPlay.setVisible(true);

            this.setContentPane(panPlay);
        } else {
            JOptionPane.showMessageDialog(optButton4, "Name already exists. Try again");
        }
    }

    private void x2Clicked() {
        supp3 = true;
    }

    private void giftClicked() {
        supp2 = true;
        gamestate.player.giftAns();
    }

    private void healthClicked() {
        if (gamestate.player.getHealth() == 500) {
            supp1 = false;
        }

        if (gamestate.player.getHealth() == 400) {
            supp1 = true;
            healthbar5.setVisible(true);
            gamestate.player.healthRestore();
        }
        if (gamestate.player.getHealth() == 300) {
            supp1 = true;
            healthbar4.setVisible(true);
            healthbar5.setVisible(false);
            gamestate.player.healthRestore();
        }
        if (gamestate.player.getHealth() == 200) {
            supp1 = true;
            healthbar3.setVisible(true);
            healthbar4.setVisible(false);
            healthbar5.setVisible(false);
            gamestate.player.healthRestore();
        }
        if (gamestate.player.getHealth() == 100) {
            supp1 = true;
            healthbar2.setVisible(true);
            healthbar3.setVisible(false);
            healthbar4.setVisible(false);
            healthbar5.setVisible(false);
            gamestate.player.healthRestore();
        }
        System.out.println("Health: " + gamestate.player.getHealth());
    }

    private void handleOptButton3() {
        panTitle.setVisible(false);
        panName.setVisible(true);

        for (Component comp : panName.getComponents()) {
            comp.setVisible(false);
        }

        for (Component comp : new Component[]{name, pass, t1, p1, optButton5, back}) {
            comp.setVisible(true);
        }
        this.setContentPane(panName);
    }

    private void handleOptButton2() {
        panTitle.setVisible(false);
        panName.setVisible(true);

        for (Component comp : panName.getComponents()) {
            comp.setVisible(false);
        }

        for (Component comp : new Component[]{boardTitle, panScroll, back}) {
            comp.setVisible(true);
        }

        this.setContentPane(panName);
    }

    private void handleOptButton1() {
        panTitle.setVisible(false);
        panName.setVisible(true);

        for (Component comp : panName.getComponents()) {
            comp.setVisible(false);
        }

        for (Component comp : new Component[]{name, t1, optButton4, back}) {
            comp.setVisible(true);
        }

        this.setContentPane(panName);
    }
    
    private void nextQuestion(){
        Timer timer = new Timer(1000, e1 -> {
            question.setText(gamestate.getQuestion());

            setUpPlay();
            if (tempMon.getHealth() == 0) {
                mon1Label.setVisible(false);
                mon3Label.setVisible(false);
                mon5Label.setVisible(false);

                tempMon = gamestate.getMonster();
                gamestate.removeMonster();

                if (tempMon.getType() == 1) {
                    panPlay.add(mon1Label);
                    mon1Label.setVisible(true);
                }

                if (tempMon.getType() == 3) {
                    panPlay.add(mon3Label);
                    mon3Label.setVisible(true);
                }

                if (tempMon.getType() == 5) {
                    panPlay.add(mon5Label);
                    mon5Label.setVisible(true);
                }
            }

            id = gamestate.getId();

            choice1.setBackground(new Color(0x9b80ed));
            choice2.setBackground(new Color(0x9b80ed));
            choice3.setBackground(new Color(0x9b80ed));
            choice4.setBackground(new Color(0x9b80ed));

            input.setForeground(new Color(0x939395));

            if (id.equals("MC")) {
                if (gamestate.listMonster.size() == 0) {
                    JOptionPane.showMessageDialog(panPlay, "Out of Monsters. You Win!!!");
                    gamestate.board.updateLeaderboard(gamestate.player.getUsername(), gamestate.player.getScore());
                    panPlay.setVisible(false);
                    panTitle.setVisible(true);

                    this.setContentPane(panTitle);
                } else {
                    choicesVal = gamestate.getChoiceVal();
                    choices = gamestate.getChoice();

                    choice1.setText(choices.get(0));
                    choice2.setText(choices.get(1));
                    choice3.setText(choices.get(2));
                    choice4.setText(choices.get(3));

                    choice1.setVisible(true);
                    choice2.setVisible(true);
                    choice3.setVisible(true);
                    choice4.setVisible(true);
                    input.setVisible(false);
                    enter.setVisible(false);

                    panPlay.add(question);
                    panPlay.add(choice1);
                    panPlay.add(choice2);
                    panPlay.add(choice3);
                    panPlay.add(choice4);
                }
            }

            if (id.equals("TF")) {
                if(gamestate.listMonster.size()==0){
                    JOptionPane.showMessageDialog(panPlay, "Out of Monsters. You Win!!!");
                    gamestate.board.updateLeaderboard(gamestate.player.getUsername(), gamestate.player.getScore());
                    panPlay.setVisible(false);
                    panTitle.setVisible(true);

                    this.setContentPane(panTitle);
                }
                else {
                    ans = gamestate.getAns();
                    gamestate.removeQuestion();

                    choice1.setText("TRUE");
                    choice3.setText("FALSE");

                    choice2.setVisible(false);
                    choice4.setVisible(false);
                    input.setVisible(false);
                    enter.setVisible(false);

                    choice1.setVisible(true);
                    choice3.setVisible(true);

                    panPlay.add(question);
                    panPlay.add(choice1);
                    panPlay.add(choice2);
                    panPlay.add(choice3);
                    panPlay.add(choice4);
                }
            }

            if (id.equals("FB")) {
                if (gamestate.listMonster.size() == 0) {
                    JOptionPane.showMessageDialog(panPlay, "Out of Monsters. You Win!!!");
                    gamestate.board.updateLeaderboard(gamestate.player.getUsername(), gamestate.player.getScore());
                    panPlay.setVisible(false);
                    panTitle.setVisible(true);

                    this.setContentPane(panTitle);
                } else {
                    word = gamestate.getWord();
                    gamestate.removeQuestion();

                    input.setText("input");

                    choice1.setVisible(false);
                    choice2.setVisible(false);
                    choice3.setVisible(false);
                    choice4.setVisible(false);

                    input.setVisible(true);
                    enter.setVisible(true);

                    panPlay.add(input);
                    panPlay.add(enter);
                }
            }
            panPlay.setVisible(true);
        });
        timer.setRepeats(false);
        timer.start();
    }
    
    private void gameOver(){
        if (gamestate.player.getHealth() <= 0) {
            JOptionPane.showMessageDialog(panPlay, "Game Over...");
            gamestate.board.updateLeaderboard(gamestate.player.getUsername(), gamestate.player.getScore());
            panPlay.setVisible(false);
            panTitle.setVisible(true);

            this.setContentPane(panTitle);
        }
    }
}

