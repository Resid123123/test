package com.test.repository.redis;

import com.test.entity.TokenEntity;
import com.test.entity.TokenEntity2;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends CrudRepository<TokenEntity2,String> {

}
