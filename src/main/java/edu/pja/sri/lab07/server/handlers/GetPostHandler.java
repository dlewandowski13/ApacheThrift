package edu.pja.sri.lab07.server.handlers;

import edu.pja.sri.lab07.GetPost;
import edu.pja.sri.lab07.PostModel;
import org.apache.thrift.TException;

public class GetPostHandler implements GetPost.Iface {


    @Override
    public PostModel getPost(long id) throws TException {
        System.out.println("Zwrócono post.");
        //        TODO - zapisywanie i pobieranie z bazy
        PostModel post = new PostModel();
        post.id = 1;
        post.author = "Dawid Lewandowski";
        post.createDate = "2022-06-28";
        post.title = "Apache Thrift";
        post.content = "Wszystko źle wygenerowałem.";
        return post;
    }

}
