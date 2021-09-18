package com.enterprise.redcord.service;

import com.enterprise.redcord.dto.Message;


public interface IMessageService {

    Message save(Message message) throws Exception;
}
