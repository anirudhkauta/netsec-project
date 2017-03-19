public class IPFrame {
    Constants constants = new Constants();

    private int count = constants.ETHER_PAYLOAD;
    private String IPVersion = "";
    private String TOS = "";
    private String totalLen = "";
    private String ident = "";
    private String flags = "";
    private String offset = "";
    private String ttl = "";
    private String protocol = "";
    private String checksum = "";
    private String srcAddr = "";
    private String dstAddr = "";

    public IPFrame(byte[] packet, SimplePacketDriver driver) {
        for (byte b : packet) {
            if (count < constants.IPVER_LEN) {
                IPVersion += driver.byteToHex(packet[count]);
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
            }
            count++;
        }
    }

    private static String hexToDec(String hexString) {
        Integer temp;
        String num, actualString = "";
        for (int i = 0; i < hexString.length(); i += 2) {
            num = hexString.substring(i, i + 2);
            temp = Integer.valueOf(num, 16);
            actualString += temp.toString();
        }
        return actualString;
    }

    public String getIPVersion() {
        return IPVersion;
    }

    public String getTOS() {
        return TOS;
    }

    public String getTotalLen() {
        return hexToDec(totalLen);
    }

    public String getIdent() {
        return "0x" + ident;
    }

    public String getFlags() {
        return "0x" + flags;
    }

    public String getOffset() {
        return hexToDec(offset);
    }

    public String getTtl() {
        return hexToDec(ttl);
    }

    public String getProtocol() {
        return hexToDec(protocol);
    }

    public String getChecksum() {
        return "0x" + checksum;
    }

    public String getSrcAddr() {
        Integer temp;
        String num, actualSrcAddr = "";
        for (int i = 0; i < srcAddr.length(); i += 2) {
            num = srcAddr.substring(i, i + 2);
            temp = Integer.valueOf(num, 16);
            actualSrcAddr += temp.toString() + ".";
        }
        return actualSrcAddr;
    }

    public String getDstAddr() {
        Integer temp;
        String num, actualDstAddr = "";
        for (int i = 0; i < dstAddr.length(); i += 2) {
            num = dstAddr.substring(i, i + 2);
            temp = Integer.valueOf(num, 16);
            actualDstAddr += temp.toString() + ".";
        }
        return actualDstAddr;
    }
}
