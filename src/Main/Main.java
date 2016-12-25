package Main;

import Zhihu.Spider;
import Zhihu.Zhihu;

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
public class Main {

    public static void main(String[] args) {
        String url = "https://www.zhihu.com/explore/recommendations";
        String content = Spider.sendGet(url);
//        ArrayList<Zhihu> myZhihu = Spider.GetZhihu(content);

        ArrayList<Zhihu> myZhihu = Spider.getRecommendations(content);
        System.out.println(myZhihu);
//        System.out.println(result);
//        Pattern pattern = Pattern.compile("href=\"(.+?)\"");
//        Matcher matcher = pattern.matcher("<a href=\"index.html\">我的主页</a>");

    }





}
