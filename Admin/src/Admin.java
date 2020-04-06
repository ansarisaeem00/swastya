
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.lang.*;
import java.lang.String;
import java.awt.*;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.GetObjectRequest;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.oracle.jrockit.jfr.EventDefinition;

class Admin {
    private static Admin ad=new Admin();
    private static regs re=new regs();
    private static String k="nqIX2oSu7JUAXRzm+L4Bq7cF/wL3hjs4/Zi2UNQt";            //aws.Pkey
    private static SecretKeySpec secretKey;
    private static byte[] key;
    private static String TE,F;
    private static String E,ER,E1,ER1;
    public static void main(String[] args) throws Exception {
           try{ int i=0;
            Scanner s=new Scanner(System.in);
            Admin aq=new Admin();
            AdminGUI ag=new AdminGUI();             //object of the     main frame
            ag.setResizable(false);                 //disable's Max
            ag.setVisible(true);  //Shows the form
    }
    catch (Exception e){}


    }

                public boolean check(String f,String l,String ano)
               {

                   TE=f+l+ano;
                   return ad.encrypt(TE,k);

                }

                    ///   /   /   /   /   /   /   /   /   /   /   //AES /   /   /   /   /   /   /   /

    public static void setKey(String myKey)             //value of key gen. in rounds
    {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static boolean encrypt(String strToEncrypt, String secret)  //to encrypt pname+puid with aws private key
    {

        try
        {
          setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            E = Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
            ER=E.replaceAll("/", "");
            System.out.println(ER);
            ER=ER+".pdf";
            return ad.aws_v(ER);
        }
        catch (Exception e)
        {
            System.out.println("Error while encrypting: " + e.toString());
            return false;
        }
    }



    //      /   /   /   /   /       /   /   /   /   /   /   /   /   AWS   /    /   /   /  /    /   /   /   /

    public static boolean aws_v(String ER) throws Exception {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(Credentials.access_key_id, Credentials.secret_access_key);
        AmazonS3Client s3 =new AmazonS3Client(awsCreds);
        String Bucket="sawasthyademo";

        try {
            boolean exists = s3.doesObjectExist(Bucket, ER);
            if (exists) {
                System.out.println("Object Exist!");
                return true;

            }
            else {
               System.out.println("Object does not exist!");
               return false;

            }}
            catch(Exception e)
            {}
        return false;
    }


    public static void Depfd(String name,String dob,String bld,String cno,String Em,String add)
    {

            Font b = FontFactory.getFont(FontFactory.HELVETICA, 17, Font.NORMAL, new CMYKColor(75, 68, 67, 500));
            Document document = new Document();
            try
            {
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(ER));
                document.open();
                //Add Image
                Image image1 = Image.getInstance("D:\\logo1.png");
                image1.setAbsolutePosition(178, 750 );
                image1.scaleAbsolute(248, 60);
                document.add(image1);

                for(int i=0;i<6;i++)
                {
                    document.add(new Paragraph(" "));
                }
                document.add(new Paragraph("Name : "+name,b));
                document.add(new Paragraph("D.O.B : "+dob,b));
                document.add(new Paragraph("Blood Group : "+bld,b));
                document.add(new Paragraph("Home Location : "+add,b));
                document.add(new Paragraph("Contact : "+cno,b));
                document.add(new Paragraph("Email : "+Em,b));
                document.close();
                writer.close();
                ad.aws_up(ER);
                ad.aws_up(ER1);
                ad.del();
            } catch (Exception e)
            {
            }
return;
    }


    public static void aws_up(String F) throws Exception {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(Credentials.access_key_id, Credentials.secret_access_key);

        AmazonS3Client s3 =new AmazonS3Client(awsCreds);
                    s3.putObject(new PutObjectRequest("sawasthyademo",F, new File(F)));
                    System.out.println("Done Uploading....");



    }


    public static void encrypt1(String strToEncrypt, String secret)  //to encrypt pname+puid with aws private key
    {

        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            E1 = Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
            ER1=E1.replaceAll("/", "");
            System.out.println(ER);
            ER1=ER1+".txt";
System.out.println(ER1);
ad.Make(ER1,ER);
        }
        catch (Exception e)
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
    }


    public static void Make(String t, String f) {
        try {
            FileWriter writer = new FileWriter(t, false);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(f);
            bufferedWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void eup(String ema)
    {
        try{
            String user = "smart.healthcare.swasthya@gmail.com";
            String pass = "qwertypad1029";
            String to = ema;
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

            Transport transport=mailSession.getTransport("smtp");
            transport.connect("smtp.gmail.com", user, pass);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            System.out.println("message send successfully");
        }catch(Exception ex)
        {
            System.out.println(ex);
        }
    }

    public static void del()
    {
        File file1 = new File(ER);
        File file2 = new File(ER1);
        file1.delete();
        file2.delete();
    }
 }
