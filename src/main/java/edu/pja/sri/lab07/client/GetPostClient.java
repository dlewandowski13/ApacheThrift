package edu.pja.sri.lab07.client;

import edu.pja.sri.lab07.PostModel;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import edu.pja.sri.lab07.Post;

public class GetPostClient {
    public static void main(String [] args) {
        try {
            TTransport transport;

            transport = new TSocket("localhost", 9090);
            transport.open();

            TProtocol protocol = new  TBinaryProtocol(transport);
            Post.Client cartClient = new Post.Client(protocol);

            perform(cartClient);

            transport.close();
        } catch (TException x) {
            x.printStackTrace();
        }
    }

    private static void perform(Post.Client client) throws TException {
        client.getPost(1);
    }
}
