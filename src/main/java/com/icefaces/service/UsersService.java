package com.icefaces.service;

import com.icefaces.mapper.UserProfileDAO;
import com.icefaces.mapper.UsersMapper;
import com.icefaces.models.UserProfile;
import com.icefaces.models.Users;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname: UsersService
 * @Date: 2022/8/8 上午 11:17
 * @Author: kalam_au
 * @Description:
 */

@Service
public class UsersService {
    private static final Logger log = LogManager.getLogger(UsersService.class.getName());

    private UsersMapper usersMapper;
    private UserProfileDAO userProfileDAO;

    @Autowired
    public UsersService(UsersMapper usersMapper, UserProfileDAO userProfileDAO) {
        this.usersMapper = usersMapper;
        this.userProfileDAO = userProfileDAO;
    }



    public List<Users> findAllByMybatis() {
        List<Users> usersList = usersMapper.findAll();
        return usersList;
    }


    public List<UserProfile> findAllMpfaDemoUsers() {
        List<UserProfile> usersList = userProfileDAO.selectAll();
        return usersList;
    }

}

