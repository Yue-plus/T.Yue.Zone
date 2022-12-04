package zone.yue.t

import org.springframework.stereotype.Service

@Service
class TService(val ter: TEntityRepository) {
    fun putUrl(url: String): String {
        val te = TEntity("", url)
        ter.save(te)
        return te.code
    }

    fun getUrlById(code: String): String {
        return ter.findFirstByCode(code).url
    }
}