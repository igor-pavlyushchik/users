package com.ip.users.repo;

import org.springframework.data.repository.CrudRepository;

import com.ip.users.domain.UserItem;

/**
 * Repo.
 */
public interface UserRepository extends CrudRepository<UserItem, Integer> {
}
