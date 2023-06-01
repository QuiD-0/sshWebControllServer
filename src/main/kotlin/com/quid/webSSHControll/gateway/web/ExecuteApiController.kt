package com.quid.webSSHControll.gateway.web

import com.quid.webSSHControll.ssh.usecase.RunSh
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/execute")
class ExecuteApiController(
    private val runSh: RunSh
) {

    @GetMapping("/test")
    fun run(): Unit = runSh.execute("/home/wodnd", "run.sh")

}