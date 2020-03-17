
package mail;

import java.util.*;
import java.io.*;
import static java.util.Date.from;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail {
    
    public SendEmail() {

    }
    
    public void sendEmail(String address, String name, String displayName, String userSession, String comment) {
        
        String emailMessage = "";
        
        Properties properties = System.getProperties();  
        
        String from = "sbanjara.info@gmail.com";  

        // Setup mail server 
        properties.setProperty("mail.smtp.host", "smtp.gmail.com"); 

        // SSL Port 
        properties.put("mail.smtp.port", "465");  

        // enable authentication 
        properties.put("mail.smtp.auth", "true");  

        // SSL Factory 
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");   

        // creating Session instance referenced to  
        // Authenticator object to pass in  
        // Session.getInstance argument 
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() { 
                return new PasswordAuthentication("sbanjara.info@gmail", "MailBanjaraAccount56()"); 
            } 
            
        }); 

        //compose the message 
        try { 
            
            // javax.mail.internet.MimeMessage class is mostly  
            // used for abstraction. 
            MimeMessage message = new MimeMessage(session);  

            // header field of the header. 
            message.setFrom(new InternetAddress(from));  

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(address)); 
            message.setSubject("Thank you for Registration!!");
            
            emailMessage = "Dear " + name + ",\n\n Thank you for signing up with us. "
                            + "\n\nGiven below are the information that you filled;" 
                            + "\n\nName: " + name
                            + "\nDispaly Name: " + displayName
                            + "\nEmail address: " + address
                            + "\nSession: " + userSession
                            + "\nComment: " + comment
                            + "\n\nHave a good one!!\n\nSincerely,\nBanjara Inc.\n700 Pelham Rd N\nPhone: 256-192-9898"
                            + "\nEmail: sbanjara.info@gmail.com";
     
            message.setText(emailMessage); 

            // Send message 
            Transport.send(message); 
            
        } 
        
        catch (MessagingException mex) { 
            mex.printStackTrace(); 
        } 

        
    }  
    
}
