package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by eason on 2016/12/24.
 */
public class Main {

    public static String sendGet(String url) {
//        String url = "http://www.baidu.com";
        String result = "";

        BufferedReader in = null;

        try {
            URL readUrl = new URL(url);

            URLConnection connection = readUrl.openConnection();

            connection.connect();
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null){
                result += line;


            }

        }catch (Exception e){
            System.out.println("发送GET请求出现异常!" + e);
            e.printStackTrace();
        }finally {
            try {
                if (in != null){
                    in.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
//        System.out.println(result);
        return url;
    }

    public String regexString(String targetStr, String patternStr){
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(targetStr);
        if (matcher.find()){
            return matcher.group(1);
        }
        return "";
    }




    public static void main(String[] args) {
        String url = "http://www.baidu.com";
        String result = sendGet(url);
//        System.out.println(result);
        Pattern pattern = Pattern.compile("href=\"(.+?)\"");
        Matcher matcher = pattern.matcher("<a href=\"index.html\">我的主页</a>");
        if (matcher.find()){
            System.out.println(matcher.group(1));
        }
    }





}