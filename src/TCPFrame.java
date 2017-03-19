import java.math.BigInteger;

public class TCPFrame {
    Constants constants = Constants.getConstants();
    private String srcPort = "";
    private String dstPort = "";
    private String seqNum = "";
    private String ackNum = "";
    private String body = "";
    private int count = constants.IP_PAYLOAD;

    private TCPFrame() {
    }

    public TCPFrame(byte[] packet, SimplePacketDriver driver) {
        for (byte b : packet) {
            if (count < constants.SRC_PORT_LEN) {
                srcPort += driver.byteToHex(packet[count]);
            } else if (count < constants.DST_PORT_LEN) {
                dstPort += driver.byteToHex(packet[count]);
            } else if (count < constants.TCP_SEQ_NO) {
                seqNum += driver.byteToHex(packet[count]);
            } else if (count < constants.TCP_ACK_NO) {
                ackNum += driver.byteToHex(packet[count]);
            } else if (count > constants.TCP_ACK_NO) {
                try {
                    body += driver.byteToHex(packet[count]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    break;
                }
            }
            count++;
        }
    }

    public String getSrcPort() {
//        System.out.println("Source port in hex: "+srcPort);
        return Integer.valueOf(srcPort, 16).toString();
    }

    public String getDstPort() {
//        System.out.println("Destination port in hex: "+dstPort);
        return Integer.valueOf(dstPort, 16).toString();
    }

    public String getSeqNum() {
        BigInteger actualSeqNum = new BigInteger(seqNum, 16);
//        System.out.println("Sequence Number in hex: "+seqNum);
        return actualSeqNum.toString();
    }

    public String getAckNum() {
//        System.out.println("Acknowledge Number in hex: "+ackNum);
        return Integer.valueOf(ackNum, 16).toString();
    }

    public String getBody() {
//        System.out.println("Body in hex: "+body);
        return constants.hexToDec(body);
    }

}
