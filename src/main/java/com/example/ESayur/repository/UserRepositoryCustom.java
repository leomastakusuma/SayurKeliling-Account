package com.example.ESayur.repository;

import com.example.ESayur.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepositoryCustom {

    @Query(value="select * from user u where u.phone_number =:phoneNumber order by u.id_user desc  limit 1 ", nativeQuery=true)
    User findByPhone(@Param("phoneNumber") String phoneNumber);

    @Query(value="select * from user u where u.level='grobak' order by u.id_user desc  limit 1 ", nativeQuery=true)
    List<User> listGrobakSayur();


}
