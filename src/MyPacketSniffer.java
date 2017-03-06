import org.apache.commons.cli.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyPacketSniffer {
    public static void main(String[] args) {

        CommandLine cmd = getCommandFormatter(args);
        if(cmd == null){
            System.exit(1);
        }

        int countArg = Integer.parseInt(cmd.getOptionValue("c", "-1")); // Find out what the default value of the count should be
        String readFromFileArg = cmd.getOptionValue("r", null);
//        String outputFilenameArg = cmd.getOptionValue("o",null);
//        String typeArg = cmd.getOptionValue("t",null);
//        String sAddressArg = cmd.getOptionValue("src",null);
//        String dAddressArg = cmd.getOptionValue("dst",null);
//        String []sOrDArg = cmd.getOptionValues("sord");
//        String []sAndDArg = cmd.getOptionValues("sandd");
//        String []sourcePortArg = cmd.getOptionValues("sport");
//        String []destPortArg = cmd.getOptionValues("dport");

        if (readFromFileArg != null) {
            readFromFile(readFromFileArg,countArg);
        } else {
            readFromNetwork(countArg);
        }
    }

    private static void readFromNetwork(int countArg) {
        SimplePacketDriver driver = new SimplePacketDriver();
        //Get adapter names and print info
        String[] adapters = driver.getAdapterNames();
        System.out.println("Number of adapters: " + adapters.length);
        for (int i = 0; i < adapters.length; i++) {
            System.out.println("Device name in Java =" + adapters[i]);
            if (driver.openAdapter(adapters[i])) {
                System.out.println("Adapter is open: " + adapters[0]);
                break;
            }
        }
        int count = 0;
        while (count < countArg || count == -1) {
            byte[] packet;
            //Read a packet. Blocking call
            packet = driver.readPacket();
            //Wrap it into a ByteBuffer
            ByteBuffer Packet = ByteBuffer.wrap(packet);
            //Print packet summary
            System.out.println("Packet: " + Packet + " with capacity: " + Packet.capacity());
            System.out.println(driver.byteArrayToString(packet));
            if(count != -1) {
                count++;
            }
        }
    }

    private static CommandLine getCommandFormatter(String[] args) {
        Options options = new Options();

        Option count = new Option("c", "count", true, "Exit after receiving count packets");
        Option input_filename = new Option("r", "readfile", true, "Read packets from file");
        Option output_filename = new Option("o", "writeFile", true, "Save output to file");
        Option type = new Option("t", "type", true, "Print file of specified type (eth,arp,ip,icmp,tcp,udp");
        Option header = new Option("h", "header", false, "Print header only of the specified type");
        Option saddress = new Option("src", "source", true, "Print only packets from source address");
        Option daddress = new Option("dst", "destination", true, "Print only packets from destination address");
        Option sanddaddress = new Option("sandd", "sandd", true, "Print only packets from source and destination address");
        Option sordaddress = new Option("sord", "sord", true, "Print packets from source or destination address");
        Option source_port = new Option("sport", "sourcePort", true, "Print only packets from range of source port1-port2");
        Option dest_port = new Option("dport", "destinationPort", true, "Print only packets from destination port1-port2");

        sordaddress.setArgs(2);
        sanddaddress.setArgs(2);
        source_port.setArgs(2);
        dest_port.setArgs(2);

        options.addOption(count);
        options.addOption(input_filename);
        options.addOption(output_filename);
        options.addOption(type);
        options.addOption(header);
        options.addOption(saddress);
        options.addOption(daddress);
        options.addOption(sanddaddress);
        options.addOption(sordaddress);
        options.addOption(source_port);
        options.addOption(dest_port);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
            return cmd;
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("Packet Sniffer", options);

            System.exit(1);
            return null;
        }
    }

    private static void readFromFile(String fileName,int countArg) {
        //TODO:Simply read from file and output
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;
            int count = 0;

            while (true) {
                line = bufferedReader.readLine();
                if(count < countArg || countArg == -1){
                    System.out.println(line);
                    if(line.isEmpty()){
                        count++;
                    }
                } else{
                    break;
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("File provided " + fileName + " does not exist or could not be found!!");
            System.exit(0);
        }

    }
}