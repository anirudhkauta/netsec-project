
public class Constants {

    private static Constants constants;

    //Ethernet constants
    public final int MAC_DEST_LEN = 6;
    public final int MAC_SRC_LEN = MAC_DEST_LEN + 6;
    public final int ETHERTYPE_LEN = MAC_SRC_LEN + 2;
    public final int ETHER_PAYLOAD = ETHERTYPE_LEN;

    //IP Constants
    public final int IPVER_LEN = ETHER_PAYLOAD + 1;
    public final int HEADER_LEN = 1;
    public final int TOS_LEN = IPVER_LEN + 1;
    public final int TOTAL_LEN = TOS_LEN + 2;
    public final int IDENT_LEN = TOTAL_LEN + 2;
    public final int FLAG_LEN = IDENT_LEN + 1;
    public final int OFFSET_LEN = IDENT_LEN + 2;
    public final int TTL_LEN = OFFSET_LEN + 1;
    public final int PROTOCOL_LEN = TTL_LEN + 1;
    public final int CHECKSUM_LEN = PROTOCOL_LEN + 2;
    public final int SRC_ADDR_LEN = CHECKSUM_LEN + 4;
    public final int DEST_ADDR_LEN = SRC_ADDR_LEN + 4;
    public final int IP_PAYLOAD = DEST_ADDR_LEN;

    //Common TCP and UDP Constants
    public final int SRC_PORT_LEN = DEST_ADDR_LEN + 2;
    public final int DST_PORT_LEN = SRC_PORT_LEN + 2;

    //UDP Constants
    public final int UDP_HEADER_LEN = DST_PORT_LEN + 2;
    public final int UDP_CHECKSUM_LEN = UDP_HEADER_LEN + 2;
    public final int UDP_PAYLOAD = UDP_CHECKSUM_LEN;

    //TCP Constants
    public final int TCP_SEQ_NO = DST_PORT_LEN + 4;
    public final int TCP_ACK_NO = TCP_SEQ_NO + 4;
    public final int TCP_PAYLOAD = IP_PAYLOAD + 24;

    //ARP Constants
    public final int HWD_TYPE = ETHER_PAYLOAD + 2;
    public final int PROTO_TYPE = HWD_TYPE + 2;
    public final int HWD_SIZE = PROTO_TYPE + 1;
    public final int PROTO_SIZE = HWD_SIZE + 1;
    public final int OPCODE = PROTO_SIZE + 1;
    public final int SENDER_MAC_ADDR = OPCODE + 6;
    public final int SENDER_IP_ADDR = SENDER_MAC_ADDR + 4;
    public final int TARGET_MAC_ADDR = SENDER_IP_ADDR + 6;
    public final int TARGET_IP_ADDR = TARGET_MAC_ADDR + 4;

    //ICMP Constants
    public final int ICMP_VER = ETHER_PAYLOAD + 2;
    public final int ICMP_HEADER_LEN = 1;
    public final int ICMP_TOS_LEN = ICMP_VER + 1;
    public final int ICMP_TOTAL_LEN = ICMP_TOS_LEN + 2;
    public final int ICMP_IDENT_LEN = ICMP_TOTAL_LEN + 2;
    public final int ICMP_FLAG_LEN = ICMP_IDENT_LEN + 1;
    public final int ICMP_OFFSET_LEN = ICMP_IDENT_LEN + 2;
    public final int ICMP_TTL_LEN = ICMP_OFFSET_LEN + 1;
    public final int ICMP_PROTOCOL_LEN = ICMP_TTL_LEN + 1;
    public final int ICMP_HEADER_CHECKSUM_LEN = ICMP_PROTOCOL_LEN + 2;
    public final int ICMP_SRC_ADDR_LEN = ICMP_HEADER_CHECKSUM_LEN + 4;
    public final int ICMP_DEST_ADDR_LEN = ICMP_SRC_ADDR_LEN + 4;
    public final int ICMP_TYPE = ICMP_DEST_ADDR_LEN + 2;
    public final int ICMP_CODE = ICMP_TYPE + 2;
    public final int ICMP_CHECKSUM = ICMP_CODE + 4;


    private Constants() {

    }

    public static Constants getConstants() {
        if (constants == null) {
            constants = new Constants();
        }
        return constants;
    }

    public String hexToDec(String hexString) {
        Integer temp;
        String num, actualString = "";
        for (int i = 0; i < hexString.length(); i += 2) {
            num = hexString.substring(i, i + 2);
            temp = Integer.valueOf(num, 16);
            actualString += temp.toString();
        }
        return actualString;
    }

    public String getIPAddress(String address) {
        Integer temp;
        String num, actualAddr = "";
        for (int i = 0; i < address.length(); i += 2) {
            num = address.substring(i, i + 2);
            temp = Integer.valueOf(num, 16);
            actualAddr += temp.toString() + ".";
        }
        return actualAddr;
    }

    public void fileOutput(String filename) {
        
    }
}
