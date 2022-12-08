package zone.yue.t

import org.hashids.Hashids
import org.springframework.stereotype.Service

@Service
class TService(val ter: TEntityRepository, tc: TConfiguration) {
    private final val hashids = Hashids(tc.salt)

    fun putUrl(url: String): String {
        return if (ter.existsTEntityByUrl(url)) {
            hashids.encode(ter.findFirstByUrl(url).id)
        } else {
            hashids.encode(ter.saveAndFlush(TEntity(url)).id)
        }
    }

    fun getUrlById(code: String): String {
        val te = ter.findById(hashids.decode(code)[0]).get()
        te.count++
        ter.save(te)
        return te.url
    }
}
