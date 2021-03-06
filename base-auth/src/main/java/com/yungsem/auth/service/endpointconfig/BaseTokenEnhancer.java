package com.yungsem.auth.service.endpointconfig;

import com.yungsem.auth.service.AuthUser;
import com.yunsem.common.model.bo.LoginUser;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangsen
 * @version 1.0
 * @since 2020-08-22
 */
public class BaseTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        final Map<String, Object> additionalInfo = new HashMap<>(4);
        AuthUser authUser = (AuthUser) authentication.getUserAuthentication().getPrincipal();
        additionalInfo.put("id", authUser.getId());
        additionalInfo.put("code", authUser.getCode());
        additionalInfo.put("username", authUser.getUsername());
        additionalInfo.put("realName", authUser.getRealName());
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }
}
