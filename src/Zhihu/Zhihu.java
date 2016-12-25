package Zhihu;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by eason on 2016/12/24.
 */
public class Zhihu {
    public String question;
    public String questionDescription;
    public String zhihuUrl;
    public ArrayList<String> answers;

    public Zhihu(String url){
        question = "";
        questionDescription = "";
        zhihuUrl = "";
        answers = new ArrayList<String>();

        if (getRealUrl(url)){
            System.out.println("正在抓取" + zhihuUrl);
            String content = Spider.sendGet(zhihuUrl);
            Pattern pattern;
            Matcher matcher;

            pattern = Pattern.compile("zh-question-title.+?<h2.+?>(.+?)</h2>");
            matcher = pattern.matcher(content);
            if (matcher.find())
                question = matcher.group(1);
            pattern = Pattern.compile("zh-question-detail.+?<div.+?>(.*?)</div>");
            matcher = pattern.matcher(content);
            if (matcher.find())
                questionDescription = matcher.group(1);
            pattern = Pattern.compile("/answer/content.+?<div.+?>(.*?)</div>");
            matcher = pattern.matcher(content);
            boolean isFind = matcher.find();
            while (isFind){
                answers.add(matcher.group(1));
                isFind = matcher.find();
            }


        }


    }
    boolean getAll(){
        return true;
    }


    boolean getRealUrl(String url){
        Pattern pattern = Pattern.compile("question/(.*?)/");
        Matcher matcher = pattern.matcher(url);
        if (matcher.find()){
            zhihuUrl = "http://www.zhihu.com/question/" + matcher.group(1);
        }else {
            return false;
        }
        return true;
    }




    @Override
    public String toString() {
        return "问题: " + question + "\n" + "描述: " + questionDescription + "\n"
                + "\n链接: " + zhihuUrl + "\n回答: " + answers + "\n";
    }
}
