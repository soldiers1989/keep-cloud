package cn.qidd.keep.manage.repository.mongo;

import cn.qidd.keep.domain.entity.mongo.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMongoRepository extends MongoRepository<User, String> {
}
