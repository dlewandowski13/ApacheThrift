package edu.pja.sri.lab07.server.handlers;

import java.util.ArrayList;
import java.util.List;

import edu.pja.sri.lab07.EmptyError;
import edu.pja.sri.lab07.PostModel;
import org.apache.thrift.TException;
import edu.pja.sri.lab07.Post;

public class ProductManagerHandler implements Post.Iface {


    @Override
    public PostModel getPost(long id) throws TException {
        System.out.println("to jest nowy post");
        return null;
    }

    @Override
    public void addPost(PostModel postModel) throws EmptyError, TException {
//  TODO - zapisywanie do bazy
        System.out.println("Dodano post numer 1.");
    }
}
