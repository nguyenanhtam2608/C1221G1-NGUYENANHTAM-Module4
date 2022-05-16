package com.codegym.repository;

import com.codegym.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {
    @Query(value = "select * from user_aop where code_user = :codeUser",nativeQuery = true)
    User findAllByCode(String codeUser);
}
