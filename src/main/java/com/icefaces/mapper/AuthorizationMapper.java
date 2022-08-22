package com.icefaces.mapper;

import com.icefaces.core.models.Function;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Classname: AuthorizationMapper
 * @Date: 2022/8/22 下午 05:16
 * @Author: kalam_au
 * @Description:
 */


@Repository
public interface AuthorizationMapper {

    List<Function> getFunctions(String applId, String userId);

    List<Function> getFunctions(String applId, String funcId, String userId);

    boolean isAuthorized(String applId, String funcId, String userId);

    List<Function> getAccessRight(String applId, String className, String userId);


}
