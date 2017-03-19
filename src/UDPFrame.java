
public class UDPFrame {
    Constants constants = new Constants();

    private String srcPort = "";
    private String dstPort = "";
    private String checksum = "";
    private String length = "";
    private int count = constants.IP_PAYLOAD;

    private UDPFrame() {
    }

    public UDPFrame(byte[] packet, SimplePacketDriver driver) {
        for (byte b : packet) {
            if (count < constants.SRC_PORT_LEN) {
                srcPort += driver.byteToHex(packet[count]);
            } else if (count < constants.DST_PORT_LEN) {
                dstPort += driver.byteToHex(packet[count]);
            } else if (count < constants.UDP_HEADER_LEN) {
                length += driver.byteToHex(packet[count]);
            } else if (count < constants.UDP_CHECKSUM_LEN) {
                checksum += driver.byteToHex(packet[count]);
            }
            count++;
        }
    }

    public String getSrcPort() {
//        System.out.println("Source port in hex: " + srcPort);
        return Integer.valueOf(srcPort, 16).toString();
    }

    public String getDstPort() {
//        System.out.println("Destination port in hex: " + dstPort);
        return Integer.valueOf(dstPort, 16).toString();
    }

    public String getLength() {
        return constants.hexToDec(length);
    }

    public String getChecksum() {
        return constants.hexToDec(checksum);
    }
}
