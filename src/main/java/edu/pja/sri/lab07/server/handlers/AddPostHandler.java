package edu.pja.sri.lab07.server.handlers;

import edu.pja.sri.lab07.AddPost;
import edu.pja.sri.lab07.EmptyError;
import edu.pja.sri.lab07.PostModel;
import org.apache.thrift.TException;
import edu.pja.sri.lab07.Post;

public class AddPostHandler implements AddPost.Iface {


    @Override
    public void addPost(PostModel postModel) throws EmptyError, TException {
//  TODO - zapisywanie do bazy
        System.out.println("Dodano post numer 1.");
    }
}
