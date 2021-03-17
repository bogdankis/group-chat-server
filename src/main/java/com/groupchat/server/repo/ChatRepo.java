package com.groupchat.server.repo;

import com.groupchat.server.model.Message;
import org.springframework.data.repository.CrudRepository;

//TODO Extinde ceva pentru a avea acces la metodele CRUD in baza de date
public interface ChatRepo extends CrudRepository<Message,String>{
}
