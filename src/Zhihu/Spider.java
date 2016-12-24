package Zhihu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by eason on 2016/12/24.
 */
public class Spider {
    public static String sendGet(String url) {
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
        return result;
    }

    public static ArrayList<String> regexString(String targetStr, String patternStr){
        ArrayList<String> results = new ArrayList<>();

        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(targetStr);
        boolean isFind = matcher.find();

        while (isFind){
            results.add(matcher.group(1));
            isFind = matcher.find();
        }
        /*
        if (matcher.find()){
            return matcher.group(1);
        }
        */
        return results;
    }



}
