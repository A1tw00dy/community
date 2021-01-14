package com.travle.controller;

import com.travle.dto.AccessTokenDTO;
import com.travle.dto.GithubUser;
import com.travle.provider.GitHubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GitHubProvider gitHubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("8767bb6ea767e2749178");
        accessTokenDTO.setClient_secret("26a0c0e26342fc2eeecdce44c43b653ea1f8cc06");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8080/callback");
        accessTokenDTO.setState(state);
        String accessToken = gitHubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = gitHubProvider.getUser(accessToken);
        System.out.println(user);
        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getBio());
        return "index";
    }
}
