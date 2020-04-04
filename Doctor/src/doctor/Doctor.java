package doctor;
import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import com.fazecast.jSerialComm.*;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.GetObjectRequest;


 /***********************************READER MODULE***************************************/
public class Doctor  {
    private static SecretKeySpec secretKey;
    private static byte[] key;
    static SerialPort serialPort = SerialPort.getCommPort("COM3");
    static String same = "";
    static Thread threadToInterrupt = null;
    static InputStream inn = null;
    static Doctor app ;
    static boolean available = false;
     private static DoctorGUI doc = new DoctorGUI();
     public static int c=1,x;                //REGEX
    public static String s;                 //READER STRING
    public static String E,Er;                     //AES


    public static class SerialReader implements Runnable {

        String z=null;
        String t = "",first,last,Em,ano,ph;
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
z=first+last+ano;

                        doc.setResizable(false);                 //disable's Max
                        doc.setVisible(true);
                        doc.Name(first+" "+last);
                        doc.Re(z);
                        x=c+5;
                        app.encrypt(z,Credentials.secret_access_key);


                    }
                }
            } catch (Exception e) {
            }

            serialPort.closePort();

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
             E =Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));

            Er=E.replaceAll("/", "");
            System.out.println(Er);
        app.aws_up(Er);

        }
        catch (Exception e)
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

                                                        /****************AWS************/
                                                       /****************GET************/
        public static void aws_up(String E) throws Exception {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(Credentials.access_key_id, Credentials.secret_access_key);

        AmazonS3Client s3 =new AmazonS3Client(awsCreds);
       System.out.println("opening file.....");
      String x=E+".pdf";
          File localFile = new File("D:\\down.pdf");
            ObjectMetadata object = s3.getObject(new GetObjectRequest("sawasthyademo", x), localFile);// download from

           app.call();

        }


     public static void call()
     {

         try
         {
             Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler D:\\down.pdf");
             String z=null;
             doc.Name(z);
             doc.Re(z);
             return ;

         }
         catch (IOException e) {
             e.printStackTrace();
         }
     }

     public static void del()
     {
         File file = new File("down.pdf");
         file.delete();
     }





     public static void main(String[] args) {
            app.del();
         doc.setResizable(false);                 //disable's Max
         doc.setVisible(true);


         serialPort.openPort();
        serialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 100, 0);
        inn = serialPort.getInputStream();
        Doctor s1=new Doctor();
        SerialReader sr= new SerialReader(inn);
            inn = serialPort.getInputStream();
            threadToInterrupt = (new Thread(new SerialReader(inn)));
            threadToInterrupt.start();


    }

}
