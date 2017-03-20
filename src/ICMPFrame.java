
public class ICMPFrame {
    Constants constants = Constants.getConstants();

    private int count = constants.ETHER_PAYLOAD;

    private String icmpVer = "";
    private String TOS = "";
    private String totalLen = "";
    private String ident = "";
    private String flags = "";
    private String offset = "";
    private String ttl = "";
    private String protocol = "";
    private String headerChecksum = "";
    private String srcAddr = "";
    private String dstAddr = "";
    private String type = "";
    private String code = "";
    private String checksum = "";


    private ICMPFrame() {
    }

    public ICMPFrame(byte[] packet, SimplePacketDriver driver) {
        for (byte b : packet) {
            if (count < constants.IPVER_LEN) {
                icmpVer += driver.byteToHex(packet[count]);
            } else if (count < constants.TOS_LEN) {
                TOS += driver.byteToHex(packet[count]);
            } else if (count < constants.TOTAL_LEN) {
                totalLen += driver.byteToHex(packet[count]);
            } else if (count < constants.IDENT_LEN) {
                ident += driver.byteToHex(packet[count]);
            } else if (count < constants.FLAG_LEN) {
                flags += driver.byteToHex(packet[count]);
                offset += driver.byteToHex(packet[count]);
            } else if (count < constants.OFFSET_LEN) {
                offset += driver.byteToHex(packet[count]);
            } else if (count < constants.TTL_LEN) {
                ttl += driver.byteToHex(packet[count]);
            } else if (count < constants.PROTOCOL_LEN) {
                protocol += driver.byteToHex(packet[count]);
            } else if (count < constants.CHECKSUM_LEN) {
                checksum += driver.byteToHex(packet[count]);
            } else if (count < constants.SRC_ADDR_LEN) {
                srcAddr += driver.byteToHex(packet[count]);
            } else if (count < constants.DEST_ADDR_LEN) {
                dstAddr += driver.byteToHex(packet[count]);
            } else if (count < constants.ICMP_TYPE) {
                type += driver.byteToHex(packet[count]);
            } else if (count < constants.ICMP_CODE) {
                code += driver.byteToHex(packet[count]);
            } else if (count < constants.ICMP_CHECKSUM) {
                checksum += driver.byteToHex(packet[count]);
            }
            count++;
        }
    }

    public String getIcmpVer() {
        return icmpVer;
    }

    public String getTOS() {
        return TOS;
    }

    public String getTotalLen() {
        return constants.hexToDec(totalLen);
    }

    public String getIdent() {
        return "0x" + ident;
    }

    public String getFlags() {
        return "0x" + flags;
    }

    public String getOffset() {
        return constants.hexToDec(offset);
    }

    public String getTtl() {
        return constants.hexToDec(ttl);
    }

    public String getProtocol() {
        return constants.hexToDec(protocol);
    }

    public String getHeaderChecksum() {
        return "0x" + headerChecksum;
    }

    public String getSrcAddr() {
        return constants.getIPAddress(srcAddr);
    }

    public String getDstAddr() {
        return constants.getIPAddress(dstAddr);
    }

    public String getType() {
        return "0x" + type;
    }

    public String getCode() {
        return "0x" + code;
    }

    public String getChecksum() {
        return checksum;
    }
}
