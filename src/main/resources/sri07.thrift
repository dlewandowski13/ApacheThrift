namespace java edu.pja.sri.lab07
struct PostModel {
    1:i64 id,
    2:string createDate,
    3:string title,
    4:string content,
    5:string author
  }

  exception EmptyError {
    1:string message
  }

  service AddPost {
    void addPost(1: PostModel postModel) throws (1: EmptyError error)
  }

  service GetPost {
    PostModel getPost(1: i64 id)
  }
