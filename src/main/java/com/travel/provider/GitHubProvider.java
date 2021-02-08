package com.travel.provider;

import com.alibaba.fastjson.JSON;
import com.travel.dto.AccessTokenDTO;
import com.travel.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

@Component
public class GitHubProvider {
    //post请求github获取access_token
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
            System.out.println("string"+string);
            System.out.println("token"+token);
            return token;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    //get请求github获取user信息
    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.github.com/user")
                .header("Authorization", "token " + accessToken)
                .build();
        System.out.println("https://api.github.com/user?access_token="+accessToken);
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
