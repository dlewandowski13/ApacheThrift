package edu.pja.sri.lab07.server.handlers;

import java.util.ArrayList;
import java.util.List;

import edu.pja.sri.lab07.EmptyError;
import edu.pja.sri.lab07.PostModel;
import org.apache.thrift.TException;
import edu.pja.sri.lab07.Post;

public class ProductCartHandler implements Post.Iface {


    @Override
    public PostModel getPost(long id) throws TException {
        System.out.println("to jest post.");
        //        TODO - zapisywanie i pobieranie z bazy
        PostModel post = new PostModel();
        post.id = 1;
        post.author = "Dawid Lewandowski";
        post.createDate = "2022-06-28";
        post.title = "Apache Thrift";
        post.content = "Wszystko źle wygenerowałem.";
        return post;
    }

    @Override
    public void addPost(PostModel postModel) throws EmptyError, TException {
        System.out.println("Dodano post.");
    }
}
