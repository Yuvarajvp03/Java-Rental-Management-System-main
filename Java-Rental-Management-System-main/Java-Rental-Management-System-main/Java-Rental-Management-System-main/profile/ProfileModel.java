package profile;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import account.Account;
import account.Admin;
import account.Agent;
import account.Owner;
import account.PotentialTenant;

public class ProfileModel {

    //Association
    private Account account = Account.getAccount();

    //Variable
    private boolean checkError;

    //Constructor
    ProfileModel() {}

    public void editProfileData(String[] editedValues){ //edit profile
        //edit account's data
        account.setName(editedValues[0]);
        account.setPhone(Long.parseLong(editedValues[1]));
        account.setEmail(editedValues[2]);
        account.setUsername(editedValues[3]);
        account.setPassword(editedValues[4]);

        //update database
        if (account.getRole() == 0){
            PotentialTenant tenant = (PotentialTenant)account;
            tenant.editProfile();
        }
        else if (account.getRole() == 1){
            Agent agent = (Agent)account;
            agent.editProfile();
        }
        else if (account.getRole() == 2){
            Owner owner = (Owner)account;
            owner.editProfile();
        }
        else{
            Admin admin = (Admin)account;
            admin.editProfile();
        }
    }

    public String[] getProfileData() { //get string value of profile's data

        String[] initialValues = new String[5];
        initialValues[0] = account.getName();
        initialValues[1] = String.valueOf(account.getPhone());
        initialValues[2] = account.getEmail();
        initialValues[3] = account.getUsername();
        initialValues[4] = account.getPassword();

        return initialValues;
    }

    public String checkError(String[] editedValues) { //check input error
        checkError = true;
        String[] messageArray = new String[5];
        StringBuffer messageBuilder = new StringBuffer();
        Boolean[] checkEachInput = new Boolean[5];
        Arrays.fill(checkEachInput, Boolean.TRUE); //initialise all to true

        //check name
        if (editedValues[0] == null || editedValues[0].isEmpty()) { //check is not empty
            checkEachInput[0] = false;
            messageArray[0] = "Invalid Name.\nName should not be blank.";
        } else { //make sure only alphabet and can have space
            Pattern namePattern = Pattern.compile("^[ A-Za-z]+$");
            Matcher nameMatcher = namePattern.matcher(editedValues[0]);
            boolean matcherFlag = nameMatcher.matches();
            if (!matcherFlag) {
                checkEachInput[0] = false;
                messageArray[0] = "Invalid Name.\nName should contains only alphabets.";
            }
        }

        //check phone
        if (editedValues[1] == null || editedValues[1].isEmpty()) { // Check if not empty
            checkEachInput[1] = false;
            messageArray[1] = "Invalid Phone Number.\nPhone number should not be blank.";
        } else if (editedValues[1].length() != 10) { // Check if the phone number length is exactly 10 digits
            checkEachInput[1] = false;
            messageArray[1] = "Enter the phone number correctly.\nPhone number should contain exactly 10 digits.";
        } else { // Make sure only digits
            for (char character : editedValues[1].toCharArray()) {
                if (!Character.isDigit(character)) {
                    checkEachInput[1] = false;
                    messageArray[1] = "Invalid Phone Number.\nPhone number should contain only digits.";
                    break; // Exit loop once an invalid character is found
                }
            }
        }

        //checks email
        if (editedValues[2] == null || editedValues[2].isEmpty()) { // check if not empty
            checkEachInput[2] = false;
            messageArray[2] = "Invalid Email Address.\nEmail address should not be blank.";
        } else { // make sure it is an email
            try {
                InternetAddress email = new InternetAddress(editedValues[2]); // change String to InternetAddress
                email.validate(); // if wrong, throw error
            } catch (AddressException ex) {
                checkEachInput[2] = false;
                messageArray[2] = "Enter the correct format."; // Updated error message
            }
        }



        //check username and password
        for (int i = 3; i < 5; i++) {
            String[] attribute = {"Username", "Password"};
            if (editedValues[i] == null || editedValues[i].isEmpty()) {
                checkEachInput[i] = false;
                messageArray[i] = "Invalid " + attribute[i - 3] + ".\n" + attribute[i - 3] + " should not be blank.";
            } else {
                if (editedValues[i].contains(" ")) {
                    checkEachInput[i] = false;
                    messageArray[i] = "Invalid " + attribute[i - 3] + ".\n" + attribute[i - 3] + " should not contains any space.";
                }
            }
        }

        //build error message
        for (int i = 0; i < 5; i++) {
            if (!checkEachInput[i]) { //got error
                checkError = false;
                messageBuilder.append("\n" + messageArray[i]);
            }
        }

        if (!checkError) { //got error
			return messageBuilder.toString();
		} else { //got error
			editProfileData(editedValues);
		}

        return null;
    }

    //getter
    public boolean getCheckError(){
        return checkError;
    }

}
