package cons;

public class MessageInfo {
    public String username;
    public int avatar;
    public String message;
    public MessageInfo(String username,int avatar,String message){
        this.username=username;
        //todo 头像范围
        this.avatar=avatar;
        this.message=message;
    }
    //public static MessageInfo SearchByName(String username){
        //todo
    //};

    @Override
    public String toString() {
        return "<h1><img src="+"todo"+" alt=\""+avatar+"\">"+username+": </h1>\n<p>"+message+"</p>";
    }
}
