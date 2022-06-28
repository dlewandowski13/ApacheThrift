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

  struct Result
  {
    1:i32 result;
  }

  service Post {
    PostModel getPost(1: i64 id),
    void addPost(1: PostModel postModel) throws (1: EmptyError error)
  }

  service MultiplyService
  {
    Result multiply(1:i32 a,2:i32 b)
  }