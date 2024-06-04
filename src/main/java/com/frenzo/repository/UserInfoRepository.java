package com.frenzo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frenzo.entity.UserInfo;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

//	Optional<UserInfo> findByUserName(String username);

	Optional<UserInfo> findByName(String username);

}
