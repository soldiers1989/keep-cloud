package cn.qidd.keep.common.repository.jpa;

import cn.qidd.keep.domain.entity.jpa.JpaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserRepository extends JpaRepository<JpaUser, String> {
}
