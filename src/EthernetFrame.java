public class EthernetFrame {

    Constants constants = Constants.getConstants();

    private String destAddr = "", srcAddr = "", etherType = "";
    private int count = 0;

    private EthernetFrame() {
    }

    public EthernetFrame(byte[] packet, SimplePacketDriver driver) {
        for (byte b : packet) {
            if (count < constants.MAC_DEST_LEN) {
                destAddr += driver.byteToHex(packet[count]);
                count++;
                if (count < constants.MAC_DEST_LEN) {
                    destAddr += ":";
                }
            } else if (count < constants.MAC_SRC_LEN) {
                srcAddr += driver.byteToHex(packet[count]);
                count++;
                if (count < constants.MAC_SRC_LEN) {
                    srcAddr += ":";
                }
            } else if (count < constants.ETHERTYPE_LEN) {
                etherType += driver.byteToHex(packet[count]);
                count++;
            }
        }
    }

    public String getDestAddr() {
        return destAddr;
    }

    public String getSrcAddr() {
        return srcAddr;
    }

    public String getEtherType() {
        return etherType;
    }
}
