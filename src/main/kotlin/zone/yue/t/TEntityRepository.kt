package zone.yue.t;

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.stereotype.Repository


@Repository
@EnableJpaRepositories
interface TEntityRepository : JpaRepository<TEntity, Long> {
    fun findById(code: String): TEntity
    fun findFirstBySha1(sha1: String): TEntity
    fun existsTEntityBySha1(sha1: String): Boolean
//    fun findFirstByCode(code: String): TEntity
}