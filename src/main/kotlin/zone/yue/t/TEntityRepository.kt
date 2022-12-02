package zone.yue.t;

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.stereotype.Repository


@Repository
@EnableJpaRepositories
interface TEntityRepository : JpaRepository<TEntity, Long> {
    fun findFirstByCode(code: String): TEntity
}