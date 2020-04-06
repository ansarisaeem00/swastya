import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;


    class email {
        public static void main(String[] args) {
            try {
                String user = "smart.healthcare.swasthya@gmail.com";
                String pass = "qwertypad1029";
                String to = "s.ajay1092@gmail.com";
                String from = "smart.healthcare.swasthya@gmail.com";
                String subject = "Swasthya Smart Healthcare Welcomes You";
                MimeMultipart multipart = new MimeMultipart("related");

                // first part (the html)
                BodyPart messageBodyPart = new MimeBodyPart();
                String htmlText = "<img src=\"cid:image\">";
                messageBodyPart.setContent(htmlText, "text/html");
                // add it
                multipart.addBodyPart(messageBodyPart);

                // second part (the imageŚ)
                messageBodyPart = new MimeBodyPart();
                DataSource fds = new FileDataSource("F:\\1P\\Admin\\img\\email.jpg");

                messageBodyPart.setDataHandler(new DataHandler(fds));
                messageBodyPart.setHeader("Content-ID", "<image>");

                // add image to the multipart
                multipart.addBodyPart(messageBodyPart);

                Properties props = System.getProperties();

                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.port", "587");
                props.put("mail.smtp.auth", "true");

                Session mailSession = Session.getDefaultInstance(props, null);
                // mailSession.setDebug(sessionDebug);
                Message msg = new MimeMessage(mailSession);

                msg.setFrom(new InternetAddress(from));
                InternetAddress[] address = {new InternetAddress(to)};
                msg.setRecipients(Message.RecipientType.TO, address);
                msg.setSubject(subject);
                msg.setSentDate(new Date());
                msg.setContent(multipart);

                Transport transport = mailSession.getTransport("smtp");
                transport.connect("smtp.gmail.com", user, pass);
                transport.sendMessage(msg, msg.getAllRecipients());
                transport.close();
                System.out.println("message send successfully");
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
