package cons;

import java.util.HashMap;
import java.util.LinkedList;

public class Constant {
    public static final String WEB_TITLE="Casino online in Macao!";

    public static final int COOKIE_MAX_AGE=7*24*60*60;
    // 新浪ip地址查询url
    public static final LinkedList<String> IP_SEARCHER_URLS=new LinkedList<>(){{
        add("http://int.dpool.sina.com.cn/iplookup/iplookup.php?ip=");
    }};
    /**
     * List含参初始化
     */
    public static HashMap<String,HashMap<String,String>> BOOK_MARKS =new HashMap<>(){{
        put("jack",new HashMap<>(){{
            put("澳门首家线上赌场上线了！","http://www.casinonline.cf");
        }});
    }};

    public static HashMap<String, String> KEYWORDS=new HashMap<>(){{
        put("澳门赌场","****");
        put("<","&lt");
        put(">","&rt");
        //todo
    }};

    public static LinkedList<MessageInfo> MASSAGE_BOARD=new LinkedList<>();
    public static HashMap<String,LinkedList<MessageInfo>> USER_MESSAGES=new HashMap<>();
    public void SortMessageBoardByName(){
        if (!MASSAGE_BOARD.isEmpty()){
            for (MessageInfo ms:MASSAGE_BOARD
                 ) {
                LinkedList<MessageInfo> list;
                if ((list=USER_MESSAGES.get(ms.username))!=null){
                    list.add(ms);
                }
                else {
                    list=new LinkedList<>();
                    list.add(ms);
                    USER_MESSAGES.put(ms.username,list);
                }
            }
        }
    }
    // todo
}