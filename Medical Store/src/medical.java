import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import com.fazecast.jSerialComm.*;


public class medical {
    private static SecretKeySpec secretKey;
    private static byte[] key;
    static SerialPort serialPort = SerialPort.getCommPort("COM4");
    static String same = "";
    static Thread threadToInterrupt = null;
    static InputStream inn = null;


    private static log doc;

    static {
        try {
            doc = new log();
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
    public static String E,Er;                     //AES


    public static class SerialReader implements Runnable {

        static String z=null;
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
                       // System.out.println(s);
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
                       doc.read(1);
                        x=c+5;
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





    public static void main(String[] args) {
        doc.setResizable(false);                 //disable's Max
        doc.setVisible(true);
        serialPort.openPort();
        serialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 100, 0);
        inn = serialPort.getInputStream();
        SerialReader sr= new SerialReader(inn);
        inn = serialPort.getInputStream();
        threadToInterrupt = (new Thread(new SerialReader(inn)));
        threadToInterrupt.start();
    }
}
