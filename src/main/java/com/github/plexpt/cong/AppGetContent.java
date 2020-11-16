package com.github.plexpt.cong;

import com.alibaba.fastjson.JSON;
import com.github.plexpt.cong.dto.Res;

import net.dreamlu.mica.http.HttpRequest;

import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.List;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.text.UnicodeUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppGetContent {
    static int index = 1;

    static String starturl;

    public static void main(String[] args) {

        start();
    }

    public static void start() {
        starturl = "https://api.zsxq.com/v1.10/groups/" + Config.GROUP_ID + "/topics?count=" + (Config.COUNTS_PER_TIME);

        if (Config.ONLY_DIGESTS) {
            starturl = starturl + "&scope=digests";
        }

        getdata(starturl);
        log.info(index + "次获取，结束");


    }

    public static void getdata(String url) {
        log.info(index + "次获取，url：" + url);

        String resstr = HttpRequest.get(url)
                .addHeader("Cookie", Config.COOKIE)
                .addHeader("Referer", "https://wx.zsxq.com/")
                .userAgent(Config.USER_AGENT)
                .execute()
                .asString(Charset.forName("utf-8"));
        Res res = JSON.parseObject(resstr, Res.class);
        List<Res.RespDataBean.TopicsBean> topics = res.getResp_data().getTopics();
        if (topics == null || topics.isEmpty()) {
            return;
        }

        FileUtil.mkdir(Config.Save_Path);
        FileUtil.writeUtf8String((resstr), Config.Save_Path + "unicode/" + index + ".json");
        String pretty = JSON.toJSONString(JSON.parseObject(UnicodeUtil.toString(resstr)), true);
        FileUtil.writeUtf8String(pretty, Config.Save_Path + index + ".json");

        index++;
 

        Res.RespDataBean.TopicsBean topic = topics.get(topics.size() - 1);
        //2020-11-13T14:31:28.618+0800
        String time = topic.getCreate_time();
        String nextUrl;
        String endTime = time;

        nextUrl = starturl + "&end_time=" + URLEncoder.encode(endTime);

        if (nextUrl.equals(url)) {
            return;
        }

        try {
            if (Config.SLEEP > 0) {
                Thread.sleep(Config.SLEEP * 1000);
            }
        } catch (InterruptedException e) {
        }

        getdata((nextUrl));

//        System.out.println(res);

    }

}

