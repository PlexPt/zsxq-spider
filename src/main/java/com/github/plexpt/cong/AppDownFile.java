package com.github.plexpt.cong;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.plexpt.cong.dto.DownloadDTO;

import net.dreamlu.mica.http.HttpRequest;

import java.io.File;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.io.FileUtil;

/**
 */
public class AppDownFile {
    public static List<String> fileIdList = new ArrayList<String>();

    public static void main(String[] args) {

        List<String> idList = getFileIdList("");
        idList.parallelStream().forEach(fileId -> downFileByFileid(fileId, Config.File_Path));
        System.out.println("下载完成,本次共下载" + idList.size() + "个文件");
    }

    /**
     * @param end_time 附件最后的时间
     */
    private static List<String> getFileIdList(String end_time) {

        String url = "https://api.zsxq.com/v1.10/groups/" + Config.GROUP_ID + "/files?count=20";
        System.out.println("获取文件列表：" + url);

        String body = getAllTopic(url, end_time);
        JSONArray jsonArray = JSONObject.parseObject(body).getJSONObject("resp_data").getJSONArray("files");
        String temp = JSONObject.parseObject(jsonArray.get(jsonArray.size() - 1).toString())
                .getJSONObject("file").getString("create_time");
        temp = temp.replaceAll(":", "%3a").replaceAll("\\+", "%2b");
        if (!temp.equals(end_time)) {
            end_time = temp;
            getFileIdList(end_time);
        }
        for (Object object : jsonArray) {
            String file_id = JSONObject.parseObject(object.toString()).getJSONObject("file").getString("file_id");
            fileIdList.add(file_id);
//			downFileByFileid(file_id);
        }
        fileIdList = fileIdList.stream().distinct().collect(Collectors.toList());
        return fileIdList;
    }

    /**
     * 根据文件ID下载文件
     *
     * @param file_id
     */
    private static void downFileByFileid(String file_id, String path) {
        String url = "https://api.zsxq.com/v1.10/files/" + file_id + "/download_url";
        System.out.println("根据文件ID下载文件：" + url);

        try {

            DownloadDTO res = HttpRequest.get(url)
                    .addHeader("Cookie", Config.COOKIE)
                    .addHeader("Referer", "https://wx.zsxq.com/")
                    .userAgent(Config.USER_AGENT)
                    .execute()
                    .asValue(DownloadDTO.class);

            String download_url = res.getResp_data().getDownload_url();
            System.out.println(download_url);
            downFile(download_url, path);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void downFile(String download_url, String path) {
        System.out.println("根据文件ID下载文件：" + download_url);

        try {

            int strStartIndex = download_url.indexOf("attname=");
            int strEndIndex = download_url.indexOf("&");
            String filename = download_url.substring(strStartIndex, strEndIndex).substring("attname=".length());
            filename = URLDecoder.decode(filename, "utf-8");

            System.out.println("下载文件：" + filename);

            File file = new File(path + filename);
            try {
                FileUtil.mkParentDirs(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
            HttpRequest.get(download_url)
                    .addHeader("Cookie", Config.COOKIE)
                    .addHeader("Referer", "https://wx.zsxq.com/")
                    .userAgent(Config.USER_AGENT)
                    .execute()
                    .toFile(file);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取本次请求的响应
     *
     * @param url
     * @param end_time
     * @return
     */
    private static String getAllTopic(String url, String end_time) {
        if (!"".equals(end_time)) {
            url = url + "&end_time=" + end_time;
        }
        System.out.println("获取Topic：" + url);

        try {
            String res = HttpRequest.get(url)
                    .addHeader("Cookie", Config.COOKIE)
                    .addHeader("Referer", "https://wx.zsxq.com/")
                    .userAgent(Config.USER_AGENT)
                    .execute()
                    .asString();
            return res;
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return "ERROR";
    }
}
