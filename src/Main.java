import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {

    private static void ipAddress(String first, String second) throws UnknownHostException {
        byte[] bytesFirst = InetAddress.getByName(first).getAddress();
        byte[] bytesSecond = InetAddress.getByName(second).getAddress();
        int fIP = new BigInteger(1, bytesFirst).intValue();
        int sIP = new BigInteger(1, bytesSecond).intValue();

        while (sIP > fIP){
            int ip  = sIP ;
            String ipStr =
                    String.format("%d.%d.%d.%d",
                            (ip >> 24 & 0xff),
                            (ip >> 16 & 0xff),
                            (ip >> 8 & 0xff),
                            (ip & 0xff));
            System.out.println(ipStr);
            sIP--;
        }
    }


    public static void main(String[] args) {
        try {
            ipAddress("192.168.0.1", "192.168.0.5");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
