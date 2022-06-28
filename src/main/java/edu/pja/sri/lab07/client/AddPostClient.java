package edu.pja.sri.lab07.client;

import edu.pja.sri.lab07.AddPost;
import edu.pja.sri.lab07.PostModel;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TMultiplexedProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class AddPostClient {
	  public static void main(String [] args) {
		  try {
			  TSocket transport = new TSocket("localhost", 9090);
			  transport.open();
			  TBinaryProtocol protocol = new TBinaryProtocol(transport);
			  TMultiplexedProtocol mp = new TMultiplexedProtocol(protocol, "AddPost");

			  AddPost.Client addPostClient = new AddPost.Client(mp);
			  perform(addPostClient);

			  System.out.println("Post created!");

		  } catch (TException e) {
			  e.printStackTrace();
		  }
	  }

		  private static void perform(AddPost.Client client) throws TException {

			  PostModel post = new PostModel();
			  post.id = 1;
			  post.author = "Dawid Lewandowski";
			  post.createDate = "2022-06-28";
			  post.title = "Apache Thrift";
			  post.content = "Wszystko źle wygenerowałem.";
			  client.addPost(post);
		  }
		}
