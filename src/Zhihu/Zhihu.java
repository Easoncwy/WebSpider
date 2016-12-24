package Zhihu;

import java.util.ArrayList;

/**
 * Created by eason on 2016/12/24.
 */
public class Zhihu {
    public String question;
    public String zhihuUrl;
    public ArrayList<String> answers;

    public Zhihu(){
        question = "";
        zhihuUrl = "";
        answers = new ArrayList<String>();
    }

    @Override
    public String toString() {
        return "问题: " + question + "\n链接: " + zhihuUrl + "\n回答: " + answers + "\n";
    }
}
