package zone.yue.t

import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
class TController(val ts: TService) {
    @PutMapping("/put")
    @ResponseBody
    fun put(@RequestParam url: String): String {
        return ts.putUrl(url)
    }

    @GetMapping("/{code}")
    fun redirect(@PathVariable code: String, hsr: HttpServletResponse) {
        val url = ts.getUrlById(code)

        if (url != null) {
            hsr.setHeader("Location", url)
            hsr.status = 301
        } else {
            hsr.status = 404
        }
    }
}