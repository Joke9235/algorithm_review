package com.zqr.test;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import java.util.ArrayList;
import java.util.List;

public class PostMNFTQ {
    public static void main(String[] args) {
        String url = "http://query.customs.gov.cn/MNFTQ/MQuery.aspx";

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(url);

            // 构建表单参数（注意参数顺序）
            List<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("__VIEWSTATE", "/wEPDwUKLTY2MjA2NzM3Mw9kFgICAw9kFgICAQ9kFgYCDw8WAh4JaW5uZXJodG1sZWQCFQ8PFgIeB0VuYWJsZWRnZGQCFw88KwALAQAPFggeCERhdGFLZXlzFgAeC18hSXRlbUNvdW50AgEeCVBhZ2VDb3VudAIBHhVfIURhdGFTb3VyY2VJdGVtQ291bnQCAWQWAmYPZBYCAgEPZBYYZg8PFgIeBFRleHQFBDM3MTVkZAIBDw8WAh8GBQbnqbrov5BkZAICDw8WAh8GBQbov5vlj6NkZAIDDw8WAh8GBQYmbmJzcDtkZAIEDw8WAh8GBQ5NRjgxMi8yMDI1MDMxM2RkAgUPDxYCHwYFCzczMTk3ODEwMzcwZGQCBg8PFgIfBgURMjAyNS8zLzEzIDA6MDA6MDBkZAIHDw8WAh8GBQEzZGQCCA8PFgIfBgUGMTA2LjUwZGQCCQ8PFgIfBgUM56Gu5oql5Yqo5oCBZGQCCg8PFgIfBgUM5q2j5bi455CG6LSnZGQCCw8PFgIfBgUJ5pyq6L+Q5oq1ZGRkZLeyDrul5X54msfAGBEiTQAAAAA="));
            params.add(new BasicNameValuePair("__EVENTVALIDATION", "/wEWDQL69+AmArT347MOAqbUp/4BAqPUp/4BAuml3OwFAo6l3OwFArKl3OwFAoWXqrQOArm9rMACAu/lqKwIAq6W/OsMAteU7a4IAvruiskF8pGGJwP62Sh1dMSTey9xmgAAAAA="));
            params.add(new BasicNameValuePair("ScrollTop", ""));
            params.add(new BasicNameValuePair("__essVariable", ""));
            params.add(new BasicNameValuePair("MQueryCtrl1%24ddlCustomCode", "3715"));
            params.add(new BasicNameValuePair("MQueryCtrl1%24ddlTransport", "5"));
            params.add(new BasicNameValuePair("MQueryCtrl1%24ddlBillType", "+"));
            params.add(new BasicNameValuePair("MQueryCtrl1$txtConveyance", ""));
            params.add(new BasicNameValuePair("MQueryCtrl1$txtVoyage", ""));
            params.add(new BasicNameValuePair("MQueryCtrl1$txtParentNo", ""));
            params.add(new BasicNameValuePair("MQueryCtrl1%24txtChildNo", "73197810370"));
            params.add(new BasicNameValuePair("MQueryCtrl1$txtCode", ""));
            params.add(new BasicNameValuePair("MQueryCtrl1$btQuery", "+ 查 询 +"));
            params.add(new BasicNameValuePair("select", "中国政府网"));
            params.add(new BasicNameValuePair("select1", "国务院部门网站"));
            params.add(new BasicNameValuePair("select2", "地方政府网站"));
            params.add(new BasicNameValuePair("select3", "驻港澳机构网站"));
            params.add(new BasicNameValuePair("select4", "世界海关组织"));
            params.add(new BasicNameValuePair("select5", "在京直属事业单位"));
            params.add(new BasicNameValuePair("select6", "社会团体"));
//            params.add(new BasicNameValuePair("select6", "资源网"));
            params.add(new BasicNameValuePair("select8", "媒体"));

            // 设置请求头和编码
            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
//            httpPost.setHeader("upgrade-insecure-requests", "1");
//            httpPost.setHeader("accept-encoding", "gzip, deflate");
            httpPost.setHeader("Content-Type", "multipart/form-data; boundary=<calculated when request is sent>");

            // 发送请求并获取响应
            try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String result = EntityUtils.toString(entity);
                    System.out.println("响应状态：" + response.getStatusLine());
                    System.out.println("响应内容：\n" + result);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
