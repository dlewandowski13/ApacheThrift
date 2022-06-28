package edu.pja.sri.lab07.client;

import edu.pja.sri.lab07.GetPost;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TMultiplexedProtocol;
import org.apache.thrift.transport.TSocket;


public class GetPostClient {
    public static void main(String [] args) {
        try {
            TSocket transport = new TSocket("localhost", 9090);
            transport.open();
            TBinaryProtocol protocol = new TBinaryProtocol(transport);
            TMultiplexedProtocol mp = new TMultiplexedProtocol(protocol, "GetPost");

            GetPost.Client getPostClient = new GetPost.Client(mp);
            perform(getPostClient);

        } catch (TException e) {
            e.printStackTrace();
        }
    }

    private static void perform(GetPost.Client client) throws TException {
        System.out.println(client.getPost(1));
    }
}
