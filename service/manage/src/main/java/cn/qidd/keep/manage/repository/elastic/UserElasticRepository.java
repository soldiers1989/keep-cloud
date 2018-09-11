package cn.qidd.keep.manage.repository.elastic;

import cn.qidd.keep.domain.entity.elastic.ELUser;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserElasticRepository extends ElasticsearchRepository<ELUser, String> {
}
