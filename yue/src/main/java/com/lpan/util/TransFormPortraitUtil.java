package com.lpan.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class TransFormPortraitUtil {

    /**
     * @param urgentLinkmantel 紧急联系人电话
     * @param wxNickName         发起求助的人的真实姓名
     * @param place            约会地点
     * @param time             约会结束的时间
     * @param appointmentTel   约会人的电话
     * @param remarks          备注
     * @return
     * @throws Exception
     */
    public static int sendCode(String urgentLinkmantel, String wxNickName, String place, Date time, String appointmentTel, String remarks) throws Exception {
        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod("http://gbk.api.smschinese.cn");
        post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
        String msg = "您好，您的好友" + wxNickName + "去了" + place + "，并且把您设置为紧急联系人。" + wxNickName + "设置的约会时间已到，可是他还没有关闭保护，请您尽快联系他以确保安全！他给你的留言是：" + remarks;
        System.out.println(msg);
        NameValuePair[] data = {new NameValuePair("Uid", "a121406811"), new NameValuePair("Key", "d41d8cd98f00b204e980"), new NameValuePair("smsMob", urgentLinkmantel), new NameValuePair("smsText", msg)};
        post.setRequestBody(data);
        client.executeMethod(post);
        Header[] headers = post.getResponseHeaders();
        int statusCode = post.getStatusCode();
        System.out.println("statusCode:" + statusCode);
        for (Header h : headers) {
            System.out.println(h.toString());
        }
        String result = new String(post.getResponseBodyAsString().getBytes("gbk"));
        System.out.println(result); //打印返回消息状态
        post.releaseConnection();
        return statusCode;
    }
}
