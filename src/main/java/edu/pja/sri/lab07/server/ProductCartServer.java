package edu.pja.sri.lab07.server;

import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

import edu.pja.sri.lab07.server.handlers.ProductCartHandler;
import edu.pja.sri.lab07.server.handlers.ProductManagerHandler;

import edu.pja.sri.lab07.Post;
// Generated code

public class ProductCartServer {

	  public static ProductCartHandler handlerCart;
	  public static ProductManagerHandler handlerManager;

	  public static Post.Processor processorCart;

	  public static void main(String [] args) {
//	    try {
//	      handlerCart = new ProductCartHandler();
//	      processorCart = new Post.Processor(handlerCart);
//
//	      Runnable simple = new Runnable() {
//	        public void run() {
//	          simple(processorCart);
//	        }
//	      };
//
//	      new Thread(simple).start();
//	    } catch (Exception x) {
//	      x.printStackTrace();
//	    }

		  try {
			  int port = 9090;
			  TMultiplexedProcessor processor = new TMultiplexedProcessor();
			  TServerTransport t = new TServerSocket(port);
			  TServer server = new TThreadPoolServer(new     TThreadPoolServer.Args(t).processor(processor));
			  processor.registerProcessor("MultiplyService", new   MultiplyService.Processor<MultiplyService.Iface>(new MultiplyServiceImpl()));
			  processor.registerProcessor("UserService", new  UserService.Processor<UserService.Iface>(new UserServiceImpl()));

			  System.out.println("starting server port:" + port);
			  server.serve();

		  } catch (Exception e) {
			  e.printStackTrace();
		  }
	  }

	  public static void simple(Post.Processor processorCart) {
	    try {
	      TServerTransport serverTransport = new TServerSocket(9090);
	      TServer server = new TSimpleServer(new Args(serverTransport).processor(processorCart));

	      System.out.println("Starting the simple server...");
	      server.serve();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }
	 
	}