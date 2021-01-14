package com.travle.provider;

import com.alibaba.fastjson.JSON;
import com.travle.dto.AccessTokenDTO;
import com.travle.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GitHubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO){
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            /*
            * access_token=5c96fcb915a418e664bb46577c2ead8edc32d44c&scope=user&token_type=bearer
            * 先用&分开  [0]为access_token=5c96fcb915a418e664bb46577c2ead8edc32d44c
            * 再用=分开  [1]就是5c96fcb915a418e664bb46577c2ead8edc32d44c
            * */
            String token = string.split("&")[0].split("=")[1];
            System.out.println(string);
            System.out.println(token);
            return token;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url("https://api.github.com/user?access_token=" + accessToken).build();
        System.out.println("https://api.github.com/user?access_token="+accessToken);
        try{
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            System.out.println(string);
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
