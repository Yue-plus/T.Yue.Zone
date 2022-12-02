package zone.yue.t

import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.util.UriComponentsBuilder

@Controller
class TRestController(val repository: TEntityRepository) {
    @PutMapping("/put")
    fun put(@RequestParam url: String) {
        val uri = UriComponentsBuilder.fromUriString(url)
        return // TODO
    }

    @GetMapping("/{code}")
    fun root(@PathVariable code: String, hsr: HttpServletResponse) {
        val url = repository.findFirstByCode(code).url
        hsr.setHeader("Location", url)
        hsr.status = 301
    }
}