package util;

import base.BaseMethods;
import config.PropertiesFile;
import org.apache.commons.mail.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class SendEmailJava extends BaseMethods {


    public static void sendEmail() throws EmailException {

        /******************************************************************************
         SENDING EMAIL WITHOUT ATTACHMENT
         *****************************************************************************/

        String emailAddressSetFrom = properties.getPropertyValue(PropertiesFile.PropertyKey.EMAIL_ADDRESS_SET_FROM);
        String emailAddressSetTo = properties.getPropertyValue(PropertiesFile.PropertyKey.EMAIL_ADDRESS_SET_TO);
        String emaillUsername = properties.getPropertyValue(PropertiesFile.PropertyKey.EMAIL_USERNAME);
        String emailPassword = properties.getPropertyValue(PropertiesFile.PropertyKey.EMAIL_PASSWORD);

        System.out.println("================ Start sending report to Email =================");

        Email email = new SimpleEmail();

        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator(emaillUsername, emailPassword));
        email.setStartTLSEnabled(true);
        email.setSSLOnConnect(true);
        email.setFrom(emailAddressSetFrom);
        email.setSubject("TEST REPORT");
        email.setMsg("TEST JOB IS COMPLETED ON JENKINS");
        email.getSentDate();
        email.addTo(emailAddressSetTo);

        email.send();

        System.out.println("========== Successfully send notification on Email address ===========");


        /******************************************************************************
         SENDING EMAIL WITH ATTACHMENT
         *****************************************************************************/

        /*
        String userDir = "/Users/ppopovic/Project/ProjectGeckoExample/";
        String attachmentPath = (userDir + "target/Report.zip");

        System.out.println("========== Start sending report to Email ===========");

        // Create the attachment
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath(attachmentPath);
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("Picture of John");
        attachment.setName("John");

        // Create the email message
        MultiPartEmail email = new MultiPartEmail();
        email.setHostName("smtp.sbb.rs");
        email.setSmtpPort(587);
        email.setAuthenticator(new DefaultAuthenticator(emaillUsername, emailPassword));
        email.setStartTLSEnabled(true);
        email.setSSLOnConnect(false);
        email.addTo(emailAddressSetTo, "Predrag Popovic");
        email.setFrom(emailAddressSetFrom);
        email.setSubject("TEST REPORT");
        email.setMsg("TEST JOB IS COMPLETED ON JENKINS");

        // add the attachment
        email.attach(attachment);

        // send the email
        email.send();

        System.out.println("========== Successfully send report to Email ===========");

        */
    }
}