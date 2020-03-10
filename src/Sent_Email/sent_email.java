import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by pc on 3/4/2020.
 */
public class sent_email {
    public static final int Text_email=101;
    public static void send(String to, String subject, String message, int textMail) {
        final String user = "mdasikur1.25@gmail.com";
        final String password = "@@ict18025";
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.port", 587);

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }

        });
        try {
            MimeMessage message1 = new MimeMessage(session);
            message1.setFrom();
            message1.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message1.setSubject(subject);
            message1.setText(message);
            Transport.send(message1);
            System.out.printf("Done...");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
