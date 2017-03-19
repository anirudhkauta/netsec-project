
public class Constants {
    //Ethernet constants
    public final int MAC_DEST_LEN = 6;
    public final int MAC_SRC_LEN = 12;
    public final int ETHERTYPE_LEN = 14;

    public final int ETHER_PAYLOAD = 14;

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

    public final int TCP_PAYLOAD = 24;

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

}
