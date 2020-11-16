# zsxq-spider

爬取知识星球 文件，文章

## 简介

本代码参考了网上的其他开源代码和一些文章。  

## 功能

* 支持下载文件区文件
* 支持下载评论。
* 可控制只下载精华内容或下载全部内容。
* 支持按时间区间下载。

## 环境

* Java 8
* idea

## 用法

修改Config.java 配置文件，里面有详细注释

参考以下配置内容

```python
ZSXQ_ACCESS_TOKEN = '86D82CA0-301A-3797-8528-D09322903A59_6DF24A4ED3558CD4'    # 登录后Cookie中的Token（必须修改）
USER_AGENT = 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:79.0) Gecko/20100101 Firefox/79.0'    # 登录时使用的User-Agent（必须修改）
GROUP_ID = '452445212848'                         # 知识星球中的小组ID
```
ZSXQ_ACCESS_TOKEN 需要自己在浏览器里登录一次，然后查看Cookie中的值。  
USER_AGENT 需要保证和登录时的一致。  
GROUP_ID 可以从浏览器地址栏中看到，或者截取网络请求。  
修改完以上参数后，直接运行对应文件

AppDownFile  为文件下载

AppGetContent 为文章爬取

## 说明

1. 请大家合理使用本代码，不要随意传播，保护网站及作者的合法权益。
2. 爬虫会对网站性能造成一定影响，请勿频繁使用，在必要时合理使用，大家都是去学习知识的，体谅一下吴老板。