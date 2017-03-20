public class ARPFrame {

    private Constants constants = Constants.getConstants();
    int count = constants.ETHER_PAYLOAD;
    private String hwdType = "";
    private String protoType = "";
    private String hwdSize = "";
    private String protoSize = "";
    private String opcode = "";
    private String senderMacAddr = "";
    private String senderIPAddr = "";
    private String targetMacAddr = "";
    private String targetIPAddr = "";

    private ARPFrame() {
    }

    public ARPFrame(byte[] packet, SimplePacketDriver driver) {
        for (byte b : packet) {
            if (count < constants.HWD_TYPE) {
                hwdType += driver.byteToHex(packet[count]);
            } else if (count < constants.PROTO_TYPE) {
                protoType += driver.byteToHex(packet[count]);
            } else if (count < constants.HWD_SIZE) {
                hwdSize += driver.byteToHex(packet[count]);
            } else if (count < constants.PROTO_SIZE) {
                protoSize += driver.byteToHex(packet[count]);
            } else if (count < constants.OPCODE) {
                opcode += driver.byteToHex(packet[count]);
            } else if (count < constants.SENDER_MAC_ADDR) {
                senderMacAddr += driver.byteToHex(packet[count]);
                if (count < constants.SENDER_MAC_ADDR) {
                    senderMacAddr += ":";
                }
            } else if (count < constants.SENDER_IP_ADDR) {
                senderIPAddr += driver.byteToHex(packet[count]);
            } else if (count < constants.TARGET_MAC_ADDR) {
                targetMacAddr += driver.byteToHex(packet[count]);
                if (count < constants.TARGET_MAC_ADDR) {
                    targetMacAddr += ":";
                }
            } else if (count < constants.TARGET_IP_ADDR) {
                targetIPAddr += driver.byteToHex(packet[count]);
            }
            count++;
        }
    }


    public String getHwdType() {
        return hwdType;
    }

    public String getProtoType() {
        return protoType;
    }

    public String getHwdSize() {
        return hwdSize;
    }

    public String getProtoSize() {
        return protoSize;
    }

    public String getOpcode() {
        return opcode;
    }

    public String getSenderMacAddr() {
        return senderMacAddr;
    }

    public String getSenderIPAddr() {
        return constants.getIPAddress(senderIPAddr);
    }

    public String getTargetMacAddr() {
        return targetMacAddr;
    }

    public String getTargetIPAddr() {
        return constants.getIPAddress(targetIPAddr);
    }
}
