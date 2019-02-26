package org.medipractice.clientui.proxies;


import org.medipractice.clientui.beans.TokenBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "gateway-server")
@RibbonClient(name = "auth-server")
@RequestMapping("auth")
public interface AuthProxy {


    @PostMapping(value = "oauth/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    TokenBean PostLogin(
            @RequestParam("grant_type") String grantType,
            @RequestParam("client_id") String clientId,
            @RequestParam("client_secret") String clientSecret,
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("scope") String scope
    );

    @GetMapping(value = "current")
    void GetCurrent(@RequestHeader("X-Auth-Token") String token);
}
