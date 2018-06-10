package module;

import java.io.*;

public class Test {
    public static void main(String args[]){
        File text=new File("/home/asuka/test.txt");
        BufferedReader reader;
        String line;
        String result="";
        try {
            reader=new BufferedReader(new FileReader(text));
            while ((line=reader.readLine())!=null){
                //line=line.replace(" ", "");
                line=line.replace('{', '[');
                line=line.replace('}', ']');
                //line=line.replace(",", ", ");
                result+=line+"\n";
            }
            FileWriter writer=new FileWriter(text, false);
            writer.write(result);
            reader.close();
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        return;
    }
}
