package zone.yue.t

import org.apache.commons.codec.digest.DigestUtils
import org.hashids.Hashids
import org.springframework.stereotype.Service

@Service
class TService(val ter: TEntityRepository, tc: TConfiguration) {
    private final val hashids = Hashids(tc.salt)

    fun putUrl(url: String): String {
        val sha1 = DigestUtils.sha1Hex(url)

        return if (ter.existsTEntityBySha1(sha1)) {
            hashids.encode(ter.findFirstBySha1(sha1).id)
        } else {
            val te = ter.saveAndFlush(TEntity(sha1 , url))
            hashids.encode(te.id)
        }
    }

    fun getUrlById(code: String): String {
        val te = ter.findById(hashids.decode(code)[0]).get()
        te.addCount()
        ter.save(te)
        return te.url
    }
}
