package zone.yue.t

import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class TRestController {
    @GetMapping("/{code}")
    fun root(@PathVariable code: String, hsr: HttpServletResponse) {
        hsr.setHeader("Location", "https://yue.zone/")
        hsr.status = 301
    }
}