package com.github.plexpt.cong;

public interface Config {

    //    private static String cookie = "zsxq_access_token=676F065A-F27E-5CD6-EF78-C65F75545723_742DE3448AC78AE0";
    String COOKIE = "sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22173a39bbb6c115-052507c1cc3f1e-4353760-1327104-173a39bbb6e796%22%2C%22%24device_id%22%3A%22173a39bbb6c115-052507c1cc3f1e-4353760-1327104-173a39bbb6e796%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E5%BC%95%E8%8D%90%E6%B5%81%E9%87%8F%22%2C%22%24latest_referrer%22%3A%22http%3A%2F%2Fwww.54tianzhisheng.cn%2F2018%2F10%2F13%2Fflink-introduction%2F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC%22%7D%7D; UM_distinctid=175bff53d9f764-09c5610faff271-303464-1fa400-175bff53da05e5; zsxq_access_token=4454D058-E1CE-0924-C2E4-E05A8BFA6F5F_742DE3448AC78AE0; abtest_env=product";

    /**
     * 群组
     */
    String GROUP_ID = "1824528822";
    /**
     * 登录时使用的User-Agent（必须修改）
     */
    String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.111 Safari/537.36";

    /**
     * 下载文件保存地址
     */
    String File_Path = "d:/zsxq-file/";
    /**
     * 文章保存地址
     */
    String Save_Path = "d:/zsxq/";
    /**
     * 每次请求加载几个主题 最大可设置为30
     */
    int COUNTS_PER_TIME = 20;
    /**
     * SLEEP秒数 ， 0不休眠
     */
    int SLEEP = 1;
    /**
     * 只精华
     */
    boolean ONLY_DIGESTS = false;

    /**
     * # DEBUG开关
     */
    boolean DEBUG = true;
    /**
     * # DEBUG时 跑多少条数据后停止 需与COUNTS_PER_TIME结合考虑
     */
    int DEBUG_NUM = 30;

    /**
     * 按时间区间下载
     */
    boolean FROM_DATE_TO_DATE = false;
    /**
     * # 最早时间 当FROM_DATE_TO_DATE=True时生效 为空表示不限制 形如'2017-05-25T00:00:00.000+0800'
     */
    String EARLY_DATE = "";
    /**
     * # 最晚时间 当FROM_DATE_TO_DATE=True时生效 为空表示不限制 形如'2017-05-25T00:00:00.000+0800'
     */
    String LATE_DATE = "2018-05-25T00:00:00.000+0800";

    //DOWLOAD_PICS = False                               # 是否下载图片 True | False 下载会导致程序变慢
    //DOWLOAD_COMMENTS = True                           # 是否下载评论
}
