package cn.qidd.keep.common.repository.mongo;

import cn.qidd.keep.domain.entity.mongo.MongoUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoUserRepository extends MongoRepository<MongoUser, String> {
}
