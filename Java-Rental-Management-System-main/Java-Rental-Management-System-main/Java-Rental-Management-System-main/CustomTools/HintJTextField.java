package CustomTools;

import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JTextField;

 public class HintJTextField extends JTextField {

   Font gainFont = new Font("Segoe UI", Font.PLAIN, 18);
   Font lostFont = new Font("Segoe UI", Font.PLAIN, 18);

   public HintJTextField(final String hint) {
     super();
     setText(hint);
     setFont(lostFont);
     setForeground(new java.awt.Color(204, 204, 204));

     this.addFocusListener(new FocusAdapter() {

       @Override
       public void focusGained(FocusEvent e) {
         if (getText().equals(hint)) {
           setText("");
           setFont(gainFont);
         } else {
           setText(getText());
           setFont(gainFont);
         }
       }

       @Override
       public void focusLost(FocusEvent e) {
         if (getText().equals(hint)|| getText().length()==0) {
           setText(hint);
           setFont(lostFont);
           setForeground(new java.awt.Color(204, 204, 204));
         } else {
           setText(getText());
           setFont(gainFont);
           setForeground(new java.awt.Color(204, 204, 204));
         }
       }
     });

   }

   public char[] getPassword() {

       return getPasswordFieldText().toCharArray();
   }
   private String getPasswordFieldText() {
       return new String(super.getText());
   }

public void setEchoChar(char c) {
}
}