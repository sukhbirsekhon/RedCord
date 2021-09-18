package com.enterprise.redcord.dao;

import com.enterprise.redcord.dto.Message;


public interface IMessageDAO {

    Message save(Message message) throws Exception;

}
