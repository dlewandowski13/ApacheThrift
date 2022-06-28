package edu.pja.sri.lab07.server;

import edu.pja.sri.lab07.AddPost;
import edu.pja.sri.lab07.GetPost;
import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

import edu.pja.sri.lab07.server.handlers.GetPostHandler;
import edu.pja.sri.lab07.server.handlers.AddPostHandler;
// Generated code

public class ProductCartServer {

	  public static GetPostHandler getHandler;
	  public static AddPostHandler addHandler;

	  public static GetPost.Processor getPostHandler;
	  public static AddPost.Processor addPostHandler;

	  public static void main(String [] args) {
	    try {
	      getHandler = new GetPostHandler();
		  addHandler = new AddPostHandler();
	      getPostHandler = new GetPost.Processor(getHandler);
	      addPostHandler = new AddPost.Processor(addHandler);

	      Runnable simple = new Runnable() {
	        public void run() {
//	          simple(Processor.addPost);
//			  simple(Processor.getPost);
				simple();
	        }
	      };


	      new Thread(simple).start();

	    } catch (Exception x) {
	      x.printStackTrace();
	    }
	  }

//	  public static void simple(Processor processorAction) {
	  public static void simple() {
//	    try {
//	      TServerTransport serverTransport = new TServerSocket(9090);
//	      TServer server = new TSimpleServer(new Args(serverTransport).processor(processorCart));
//
//	      System.out.println("Starting the simple server...");
//	      server.serve();
//	    } catch (Exception e) {
//	      e.printStackTrace();
//	    }
		  try {
			  int port = 9090;
			  TMultiplexedProcessor processor = new TMultiplexedProcessor();
			  TServerTransport t = new TServerSocket(port);
			  TServer server = new TThreadPoolServer(new     TThreadPoolServer.Args(t).processor(processor));
//			  if (processorAction.equals(Processor.addPost)) {
				  processor.registerProcessor("AddPost", addPostHandler);
//			  } else {
				  processor.registerProcessor("GetPost", getPostHandler);
//			  }
//			  System.out.println("starting server " + processorAction + " " + "port:" + port);
			  System.out.println("starting server " + "port:" + port);
			  server.serve();

		  } catch (Exception e) {
			  e.printStackTrace();
		  }

	  }

	public enum Processor {
		addPost, getPost
	}

	}