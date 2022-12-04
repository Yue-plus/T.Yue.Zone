package zone.yue.t

import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class TRestController(val ts: TService) {
    @PutMapping("/put")
    fun put(@RequestParam url: String) {
        ts.putUrl(url)
    }

    @GetMapping("/{code}")
    fun redirect(@PathVariable code: String, hsr: HttpServletResponse) {
        val url = ts.getUrlById(code)
        hsr.setHeader("Location", url)
        hsr.status = 301
    }
}