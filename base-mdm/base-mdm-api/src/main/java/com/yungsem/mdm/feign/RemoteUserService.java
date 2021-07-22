package com.yungsem.mdm.feign;

import com.yungsem.feign.FeignConfiguration;
import com.yungsem.mdm.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yangsen
 * @version 1.0
 * @since 2020-08-16
 */
@FeignClient(value = "base-mdm-biz", configuration = FeignConfiguration.class)
public interface RemoteUserService {

    @GetMapping("/mdm/remote/user/getByUsername")
    UserDTO getByUsername(@RequestParam(value = "username") String username);
}
