package cn.qidd.keep.manage.repository.jpa;

import cn.qidd.keep.domain.entity.jpa.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<User, String> {
}
