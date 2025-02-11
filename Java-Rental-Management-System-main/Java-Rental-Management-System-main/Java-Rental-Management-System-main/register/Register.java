package register;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class Register {

    //Variable
    private boolean checkRegister;

    public String checkRegistration(String nameEntered, String phoneEntered, String emailEntered) { //check input error
        checkRegister = true;
        String[] messageArray = new String[3];
        StringBuffer messageBuilder = new StringBuffer();
        Boolean[] checkEachInput = new Boolean[3];
        Arrays.fill(checkEachInput, Boolean.TRUE); //initialise all to true

        //check name
        if(nameEntered == null || nameEntered.isEmpty()){ //check is not empty
            checkEachInput[0] = false;
            messageArray[0] = "Invalid Name.\nName should not be blank.";
        }
        else{ //make sure only alphabet and can have space
            Pattern namePattern = Pattern.compile("^[ A-Za-z]+$");
            Matcher nameMatcher = namePattern.matcher(nameEntered);
            boolean matcherFlag = nameMatcher.matches();
            if(!matcherFlag){
                checkEachInput[0] = false;
                messageArray[0] = "Invalid Name.\nName should contains only alphabets.";
            }
        }

        //check phone
        if (phoneEntered == null || phoneEntered.isEmpty()) { // Check if not empty
            checkEachInput[1] = false;
            messageArray[1] = "Invalid Phone Number.\nPhone number should not be blank.";
        } else if (phoneEntered.length() != 10) { // Check if the phone number is exactly 10 digits
            checkEachInput[1] = false;
            messageArray[1] = "Invalid Phone Number.\nPhone number should be exactly 10 digits.";
        } else { // Ensure only digits are present
            boolean valid = true; // Set flag to true initially
            for (char character : phoneEntered.toCharArray()) {
                if (!Character.isDigit(character)) { // Check if the character is not a digit
                    valid = false; // Set flag to false if a non-digit is found
                    break; // Stop loop when an invalid character is found
                }
            }

            if (!valid) { // If any invalid character was found
                checkEachInput[1] = false;
                messageArray[1] = "Invalid Phone Number.\nPhone number should contain only digits.";
            } else {
                checkEachInput[1] = true; // Set input as valid if all conditions are met
                messageArray[1] = "Valid Phone Number."; // Optional, depending on your logic
            }
        }


        //check email
        if (emailEntered == null || emailEntered.isEmpty()) { // check if not empty
            checkEachInput[2] = false;
            messageArray[2] = "Invalid Email Address.\nEmail address should not be blank.";
        } else { // make sure it is an email
            String emailInput = emailEntered.toLowerCase(); // Normalize to lower case

            // Check for common misspellings
            if (emailInput.contains("gamil")) {
                checkEachInput[2] = false;
                messageArray[2] = "Invalid Email Address.\nDid you mean 'gmail'?";
            } else {
                try {
                    InternetAddress email = new InternetAddress(emailInput); // change String to InternetAddress
                    email.validate(); // if wrong, throw error
                } catch (AddressException ex) {
                    checkEachInput[2] = false;
                    messageArray[2] = "Invalid Email Address.\nPlease make sure your email address is valid.";
                }
            }
        }


        //build error message
        for (int i = 0; i < 3; i++) {
            if(!checkEachInput[i]){ //got error
                checkRegister = false;
                messageBuilder.append("\n"+messageArray[i]);
            }
        }

        //return error message
        if(!checkRegister) { //got error
			return messageBuilder.toString();
		}

        return null;
    }

    //getter
    public boolean getCheckRegister(){
        return checkRegister;
    }
}
