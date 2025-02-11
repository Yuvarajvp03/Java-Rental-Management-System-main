package register;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import CustomTools.HintJTextField;
import login.PreLoginPage;
import main.Frame;

public class RegisterView extends Frame{

    //Gui - swing
    private JLabel backLabel, descriptionLabel1, descriptionLabel2, iconLabel1, iconLabel2, iconLabel3, loginLabel, logoIconLabel, roleLabel, titleLabel;

    private JTextField emailTF, nameTF1, phoneTF,passwordTF;
    private JPanel pinkBgPanel, whiteBgPanel;
    private JButton signUpButton;
    private String nameEntered,emailEntered, passwordEntered ;
	private String phoneEntered;

    //Controller
    private RegisterContr registerContr = new RegisterContr(this);
    private JSeparator nameSep;
    private JSeparator phoneSep;
    private JSeparator emailSep;
    private JSeparator passwordSep;

    //Constructor
    public RegisterView(int roleNumber){
        this.setTitle("Register Page");
        this.setSize(new Dimension(570, 639));

        whiteBgPanel = new javax.swing.JPanel();
        pinkBgPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        nameTF1 = new HintJTextField("Name");
        phoneTF = new HintJTextField("Phone Number");
        emailTF = new HintJTextField("Enter Email");
        passwordTF = new HintJTextField("Password");
        iconLabel1 = new javax.swing.JLabel();
        iconLabel2 = new javax.swing.JLabel();
        iconLabel3 = new javax.swing.JLabel();
        signUpButton = new javax.swing.JButton();
        logoIconLabel = new javax.swing.JLabel();
        loginLabel = new javax.swing.JLabel();
        roleLabel = new javax.swing.JLabel();
        backLabel = new javax.swing.JLabel();
        descriptionLabel1 = new javax.swing.JLabel();
        descriptionLabel2 = new javax.swing.JLabel();

        setBgColor1(whiteBgPanel, pinkBgPanel);
        pinkBgPanel.setBorder(BorderFactory.createCompoundBorder());

        titleLabel.setFont(new java.awt.Font("SansSerif", Font.BOLD, 30)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Registration");

        nameTF1.setBackground(new java.awt.Color(186, 79, 84));
        nameTF1.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
        nameTF1.setForeground(new java.awt.Color(204, 204, 204));
        nameTF1.setHorizontalAlignment(SwingConstants.CENTER);
//        nameTF1.setText("Your Name");

        nameTF1.setBorder(null);
        nameTF1.setCaretColor(new java.awt.Color(255, 255, 255));

        phoneTF.setBackground(new java.awt.Color(186, 79, 84));
        phoneTF.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
        phoneTF.setForeground(new java.awt.Color(204, 204, 204));
        phoneTF.setHorizontalAlignment(SwingConstants.CENTER);
//        phoneTF.setText("Phone Number");
        phoneTF.setBorder(null);
        phoneTF.setCaretColor(new java.awt.Color(255, 255, 255));

        emailTF.setBackground(new java.awt.Color(186, 79, 84));
        emailTF.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
        emailTF.setForeground(new java.awt.Color(204, 204, 204));
        emailTF.setHorizontalAlignment(SwingConstants.CENTER);
//        emailTF.setText("Email Address");
 //       emailTF.setToolTipText("Email Address");
        emailTF.setBorder(null);
        emailTF.setCaretColor(new java.awt.Color(255, 255, 255));



        passwordTF.setBackground(new java.awt.Color(186, 79, 84));
        passwordTF.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
        passwordTF.setForeground(new java.awt.Color(204, 204, 204));
        passwordTF.setHorizontalAlignment(SwingConstants.CENTER);
//        emailTF.setText("Email Address");
 //       emailTF.setToolTipText("Email Address");
        passwordTF.setBorder(null);
        passwordTF.setCaretColor(new java.awt.Color(255, 255, 255));

        iconLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Profile.png"))); // NOI18N

        iconLabel2.setBackground(new java.awt.Color(255, 255, 255));
        iconLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Phone.png"))); // NOI18N

        iconLabel3.setBackground(new java.awt.Color(255, 255, 255));
        iconLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Email.png"))); // NOI18N

        signUpButton.setBackground(Color.white);
        signUpButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        signUpButton.setForeground(new java.awt.Color(51, 51, 51));
        signUpButton.setText("Sign Up");
        signUpButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        signUpButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signUpButton.setFocusPainted(false);
        signUpButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
                //get user input to be referenced by controller
                nameEntered = nameTF1.getText();
                phoneEntered = phoneTF.getText();
                passwordEntered = passwordTF.getText();
                emailEntered = emailTF.getText();
                registerContr.signUpButtonMouseClicked(roleNumber);
            }
        });

        logoIconLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/CyberentLogo.png"))); // NOI18N

        loginLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        loginLabel.setForeground(new java.awt.Color(204, 204, 204));
        loginLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginLabel.setText("Already Have an account? Click Here to Log In");
        loginLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
                close();
                new PreLoginPage().setVisible(true);
            }
        });

        roleLabel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        roleLabel.setForeground(new java.awt.Color(204, 204, 204));
        roleLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        roleLabel.setText(super.getRoleString(roleNumber));

        backLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Back.png"))); // NOI18N
        backLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
                close();
                new PreRegisterView().setVisible(true);
            }
        });

        descriptionLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descriptionLabel1.setForeground(new java.awt.Color(204, 204, 204));
        descriptionLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descriptionLabel1.setText("the system after Registration Approved");
        descriptionLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        descriptionLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descriptionLabel2.setForeground(new java.awt.Color(204, 204, 204));
        descriptionLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descriptionLabel2.setText("Username and Password will be autogenerated by");
        descriptionLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        nameSep = new JSeparator();
        nameSep.setForeground(new Color(192, 192, 192));
        nameSep.setBackground(new Color(230, 230, 250));

        phoneSep = new JSeparator();
        phoneSep.setForeground(new Color(160, 160, 160));
        phoneSep.setBackground(new Color(230, 230, 250));

        emailSep = new JSeparator();
        emailSep.setBackground(new Color(230, 230, 250));

        passwordSep = new JSeparator();
        passwordSep.setForeground(new Color(128, 128, 128));
        passwordSep.setBackground(new Color(230, 230, 250));
        
        JSeparator separator = new JSeparator();

        //Alignment
        javax.swing.GroupLayout pinkBgPanelLayout = new javax.swing.GroupLayout(pinkBgPanel);
        pinkBgPanelLayout.setHorizontalGroup(
        	pinkBgPanelLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(pinkBgPanelLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(backLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 393, Short.MAX_VALUE)
        			.addComponent(roleLabel, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        		.addComponent(logoIconLabel, GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
        		.addGroup(pinkBgPanelLayout.createSequentialGroup()
        			.addContainerGap(173, Short.MAX_VALUE)
        			.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
        			.addGap(174))
        		.addGroup(pinkBgPanelLayout.createSequentialGroup()
        			.addContainerGap(118, Short.MAX_VALUE)
        			.addGroup(pinkBgPanelLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(descriptionLabel1, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)
        				.addComponent(descriptionLabel2, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(118, Short.MAX_VALUE))
        		.addGroup(pinkBgPanelLayout.createSequentialGroup()
        			.addGap(244)
        			.addComponent(signUpButton, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(245, Short.MAX_VALUE))
        		.addGroup(pinkBgPanelLayout.createSequentialGroup()
        			.addGap(76)
        			.addComponent(loginLabel, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(72, Short.MAX_VALUE))
        		.addGroup(pinkBgPanelLayout.createSequentialGroup()
        			.addContainerGap(86, Short.MAX_VALUE)
        			.addGroup(pinkBgPanelLayout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(pinkBgPanelLayout.createSequentialGroup()
        					.addComponent(iconLabel1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
        					.addGap(19))
        				.addGroup(pinkBgPanelLayout.createSequentialGroup()
        					.addGroup(pinkBgPanelLayout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(iconLabel3)
        						.addComponent(iconLabel2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)))
        			.addGroup(pinkBgPanelLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(separator, GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE)
        				.addComponent(nameSep, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE)
        				.addComponent(passwordSep, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
        				.addComponent(phoneSep, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
        				.addGroup(pinkBgPanelLayout.createParallelGroup(Alignment.LEADING, false)
        					.addComponent(nameTF1, Alignment.TRAILING, 290, 290, Short.MAX_VALUE)
        					.addComponent(passwordTF, Alignment.TRAILING, 290, 290, Short.MAX_VALUE)
        					.addComponent(emailTF, Alignment.TRAILING, 290, 290, Short.MAX_VALUE)
        					.addComponent(phoneTF, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        				.addComponent(emailSep, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(138, Short.MAX_VALUE))
        );
        pinkBgPanelLayout.setVerticalGroup(
        	pinkBgPanelLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(pinkBgPanelLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(pinkBgPanelLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(roleLabel, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
        				.addComponent(backLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
        			.addGap(17)
        			.addComponent(logoIconLabel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(titleLabel)
        			.addGap(30)
        			.addComponent(descriptionLabel2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(descriptionLabel1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
        			.addGroup(pinkBgPanelLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(pinkBgPanelLayout.createSequentialGroup()
        					.addComponent(iconLabel1, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        					.addPreferredGap(ComponentPlacement.RELATED))
        				.addComponent(nameTF1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGroup(pinkBgPanelLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(pinkBgPanelLayout.createSequentialGroup()
        					.addGap(10)
        					.addComponent(nameSep, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
        					.addGap(27)
        					.addComponent(phoneTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(phoneSep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(26)
        					.addComponent(emailTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(emailSep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(21)
        					.addComponent(passwordTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(passwordSep, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
        					.addComponent(signUpButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
        					.addGap(18))
        				.addGroup(pinkBgPanelLayout.createSequentialGroup()
        					.addGap(34)
        					.addComponent(iconLabel2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(iconLabel3, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)))
        			.addComponent(loginLabel)
        			.addGap(64))
        );
        pinkBgPanel.setLayout(pinkBgPanelLayout);

        javax.swing.GroupLayout whiteBgPanelLayout = new javax.swing.GroupLayout(whiteBgPanel);
        whiteBgPanel.setLayout(whiteBgPanelLayout);
        whiteBgPanelLayout.setHorizontalGroup(
                whiteBgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(whiteBgPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(pinkBgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        whiteBgPanelLayout.setVerticalGroup(
                whiteBgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(whiteBgPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(pinkBgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(whiteBgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(whiteBgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }

    //getter
    public String getNameEntered(){
        return nameEntered;
    }
    public String getPhoneEntered(){
        return phoneEntered;
    }
    public String getEmailEntered(){
        return emailEntered;
    }
    public String getPassword() {
    	return passwordEntered;
    }
}
