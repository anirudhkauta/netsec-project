
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

    //UDP Constants
//    public final int SRC_PORT_LEN = DEST_ADDR_LEN + 2;
//    public final int DST_PORT_LEN =  SRC_PORT_LEN + 2;
//    public final int UDP_CHECKSUM_LEN = DST_PORT_LEN + 2;
//
//    public final int UDP_PAYLOAD = UDP_CHECKSUM_LEN;

}
