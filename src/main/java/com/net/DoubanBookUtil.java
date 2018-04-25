package com.net;

import com.net.po.Book;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class DoubanBookUtil {
    private final static String baseDoubanUrlByISBN = "https://api.douban.com/v2/book/isbn/"; //9787533941611

    public static Book getBook(String isbn) {
        String website = baseDoubanUrlByISBN + isbn;
        String jsonStr = com.net.HtmlRequestUtil.getHtml(website);

        JSONObject dataJson = JSONObject.fromObject(jsonStr);//new JSONObject(jsonStr);
        JSONObject response = dataJson.getJSONObject("response");
        JSONArray data = response.getJSONArray("data");

        return null;
    }


}
