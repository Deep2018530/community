package com.lanqiao.community.provider;

import com.alibaba.fastjson.JSON;
import com.lanqiao.community.dto.AccessTokenDTO;
import com.lanqiao.community.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author DeepSleeping
 * @date 2019/6/11 09:35
 * @description gighub api 第三方支持
 */
@Component
public class GithubProvider {

    /**
     * @description
     * @author DeepSleeping
     * @date 2019/6/11 10:03
     */
    public String getAccessToken(AccessTokenDTO accessTokenDTO) {
        MediaType mediaType
                = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            String token = string.split("&")[0].split("=")[1];
            return token;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @description
     * @author DeepSleeping
     * @date 2019/6/11 10:03
     */
    public GithubUser getUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token=" + accessToken)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
