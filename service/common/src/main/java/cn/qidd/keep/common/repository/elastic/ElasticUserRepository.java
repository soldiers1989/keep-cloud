package cn.qidd.keep.common.repository.elastic;

import cn.qidd.keep.domain.entity.elastic.ElasticUser;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElasticUserRepository extends ElasticsearchRepository<ElasticUser, String> {
}
