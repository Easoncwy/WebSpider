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
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
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
    public static ArrayList<Zhihu> getRecommendations(String content){
        ArrayList<Zhihu> results = new ArrayList<>();
        Pattern pattern = Pattern.compile("<h2>.+?question_link.+?href=\"(.+?)\".+?</h2>");
        Matcher matcher = pattern.matcher(content);
        boolean isFind = matcher.find();
        while (isFind){
            Zhihu zhihuTemp = new Zhihu(matcher.group(1));
            results.add(zhihuTemp);
            isFind = matcher.find();
        }
        return results;

    }



    /*
    public static ArrayList<Zhihu> GetZhihu(String content){
        ArrayList<Zhihu> results = new ArrayList<>();

        Pattern urlPattern = Pattern.compile("<h2>.+?question_link.+?href=\"(.+?)\".+?</h2>");
        Matcher urlMatcher = urlPattern.matcher(content);
        boolean isFind = urlMatcher.find();
        while (isFind){
            Zhihu zhihuTemp = new Zhihu(urlMatcher.group(1));
            results.add(zhihuTemp);
            isFind = urlMatcher.find();
        }



        Pattern questionPattern = Pattern.compile("question_link.+?>(.+?)<");
        Matcher questionMatcher = questionPattern.matcher(content);

        Pattern urlPattern = Pattern.compile("question_link.+?href=\"(.+?)\"");
        Matcher urlMatcher = urlPattern.matcher(content);

        boolean isFind = questionMatcher.find() && urlMatcher.find();

        while (isFind){
            Zhihu zhihuTemp = new Zhihu();
            zhihuTemp.question = questionMatcher.group(1);
            zhihuTemp.zhihuUrl = "http://www.zhihu.com" + urlMatcher.group(1);

            results.add(zhihuTemp);
            isFind = questionMatcher.find() && urlMatcher.find();

        }
        return results;
    }
    */




}
