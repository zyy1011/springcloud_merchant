package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value ="spring-provider")
public interface serviceFeign  extends UserService{

}
