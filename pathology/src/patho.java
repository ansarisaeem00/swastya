import java.io.*;
import com.fazecast.jSerialComm.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
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
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.*;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/***********************************READER MODULE***************************************/
public class patho  {
    private static SecretKeySpec secretKey;
    private static byte[] key;
    static SerialPort serialPort = SerialPort.getCommPort("COM4");
    static String same = "";
    static Thread threadToInterrupt = null;
    static InputStream inn = null;
    static patho app ;
    static boolean available = false;
    private static pathoGUI pat;
    private static log lrec;
    static {
        try {
            pat = new pathoGUI();
            lrec=new log();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static int c=1,x;                //REGEX
    public static String s;                 //READER STRING
    public static String k="nqIX2oSu7JUAXRzm+L4Bq7cF/wL3hjs4/Zi2UNQt";            //aws.Pkey
    public static String E,Er,textf,ft,line,p;                     //AES


    public static class SerialReader implements Runnable {

        String z=null;
        String t = "",first,last,Em,ano,ph,au,uname,filen,Textf;
        int c=1,x;
        InputStream in;

        public SerialReader(InputStream in) {
            this.in=in;
        }

        public void run() {
            try {

                while (true) {
                    int ch;
                    t = "";
                    StringBuilder sb = new StringBuilder();
                    while ((ch = in.read()) != 13) {
                        sb.append((char) ch);
                    }
                    c++;
                    if(c==7||c==x)
                    {
                        t = sb.toString();
                        String q= t.trim();
                        String u=q.substring(6); // to remove "name"
                        String r=u.replace("**End Reading**",""); //to remove the end tail
                        String s= r.trim();
                        System.out.println(s);
                        int in=s.indexOf("}");
                        String tri=s.substring(0,in);
                        int f=tri.indexOf("^");
                        int a=tri.indexOf("/");
                        int e=tri.indexOf("|");
                        int p=tri.indexOf("{");
                        int cl=tri.indexOf("}");
                        int l=tri.length();
                                                    first=tri.substring(0,f);
                                                    last=tri.substring(f+1,a);
                                                    ano=tri.substring(a+1,e);
                                                    Em=tri.substring(e+1,p);
                                                    ph=tri.substring(p+1,l);
                                                    z=first+last+ano;
                                                    au=ano.substring(8,12);
                                                    uname=first+last+au;
                        pat.setResizable(false);                 //disable's Max
                        pat.setVisible(true);
                        pat.Name(uname,ph);
//                        lrec.logrec(uname,ph);
                        x=c+5;
                    }
                }
            } catch (Exception e) {
            }

            serialPort.closePort();

        }
    }





    public static void Upload(String Path)
    {
        p=Path;
System.out.println(Path);
int x=Path.lastIndexOf("\\");
int y=Path.lastIndexOf(".");
textf=Path.substring(x+1,y);

                        ft= app.encrypt(textf,k);
        System.out.println(ft);
        try {
            aws_down(ft);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**************** AES ALGORITHM ************/


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



    public static String encrypt(String strToEncrypt, String secret)  //to encrypt pname+puid with aws private key
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            E = Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));

            Er=E.replaceAll("/", "");
        }
        catch (Exception e)
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
     return Er;
    }





    /****************AWS************/

    public static void aws_up(String F) throws Exception {

        BasicAWSCredentials awsCreds = new BasicAWSCredentials(Credentials.access_key_id, Credentials.secret_access_key);

        AmazonS3Client s3 =new AmazonS3Client(awsCreds);
        s3.putObject(new PutObjectRequest("sawasthyademo",F, new File(F)));
        System.out.println("Done Uploading....");
      // app.email(F);
        app.del(F);
    }

    public static void email(String add)
    {
        try {
            String user = "smart.healthcare.swasthya@gmail.com";
            String pass = "Ajay1029";
            String to = "s.ajay1029@gmail.com";
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
            DataSource fds = new FileDataSource(add);
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


    /****************GET************/
    public static void aws_down(String E) throws Exception {

        BasicAWSCredentials awsCreds = new BasicAWSCredentials(Credentials.access_key_id, Credentials.secret_access_key);

        AmazonS3Client s3 =new AmazonS3Client(awsCreds);
        System.out.println("opening file.....");
        String x=E+".txt";

        File localFile = new File(E);
        ObjectMetadata object = s3.getObject(new GetObjectRequest("sawasthyademo", x), localFile);
        read(E);
    }



    public static void aws_down1(String E) throws Exception {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(Credentials.access_key_id, Credentials.secret_access_key);

        AmazonS3Client s3 =new AmazonS3Client(awsCreds);
        System.out.println("opening file.....");


        File localFile = new File("Base.pdf");
        ObjectMetadata object = s3.getObject(new GetObjectRequest("sawasthyademo", E), localFile);
merge();
    }

//`/`/`/`/`/``/`/   /   /   /   /   /   /   /   /READ/      /   /   /   /   /       /   /   /

    public static void read(String R) {
        try {
            FileReader reader = new FileReader(R);
            BufferedReader bufferedReader = new BufferedReader(reader);


            while ((line = bufferedReader.readLine()) != null) {
                try {
                    //System.out.print(line);
                    aws_down1(line);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        del(R);
    }

    public static void merge()
    {
        File file = new File("Base.pdf");

        PDFMergerUtility pdfMerger = new PDFMergerUtility();
        try {
            int o=0;
            // load pdf file
            PDDocument document = PDDocument.load(file);

            // instantiating Splitter
            Splitter splitter = new Splitter();

            // split the pages of a PDF document
            List<PDDocument> Pages = splitter.split(document);

            // Creating an iterator
            Iterator<PDDocument> iterator = Pages.listIterator();

            // saving splits as pdf
            int i = 0;
            while (iterator.hasNext() && i == 0) {
                PDDocument pd = iterator.next();
                // provide destination path to the PDF split
                pd.save("first.pdf");
                System.out.println("Saved sample");
                i++;
            }

            document.removePage(0);
            if (iterator.hasNext()) {
                document.save("rem.pdf");
                o=1;
            }
// load pdf files to be merged
            File file1 = new File("first.pdf");

            File file2 = new File(p);

            File file3 = new File("rem.pdf");

            // set destination file path
            pdfMerger.setDestinationFileName(line);

            // add all source files, to be merged, to pdfMerger
            pdfMerger.addSource(file1);
            pdfMerger.addSource(file2);
             if(o==1){
            pdfMerger.addSource(file3);}

            // merge documents
            pdfMerger.mergeDocuments(null);
            document.close();
            document.close();
            document.close();
del("first.pdf");
del("rem.pdf");
//System.out.print(line);
    aws_up(line);

        }
        catch (Exception e){}
}


    public static void del(String F)
    {
        File file = new File(F);
        file.delete();
    }





    public static void main(String[] args) {
        //app.del();
        //object of the main frame
        pat.setResizable(false);                 //disable's Max
        pat.setVisible(true);


        serialPort.openPort();
        serialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 100, 0);
        inn = serialPort.getInputStream();
        patho s1=new patho();
        SerialReader sr= new SerialReader(inn);
        inn = serialPort.getInputStream();
        threadToInterrupt = (new Thread(new SerialReader(inn)));
        threadToInterrupt.start();


    }

}
