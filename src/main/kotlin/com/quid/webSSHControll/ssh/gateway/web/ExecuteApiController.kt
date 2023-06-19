package com.quid.webSSHControll.ssh.gateway.web

import com.quid.webSSHControll.ssh.usecase.RunSh
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/execute")
class ExecuteApiController(
    private val runSh: RunSh
) {

    @GetMapping("/mine")
    fun runMine(): Unit = runSh.file("/home/wodnd", "runMine.sh")

}