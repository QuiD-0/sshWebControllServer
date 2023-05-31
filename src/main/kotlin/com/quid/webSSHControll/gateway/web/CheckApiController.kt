package com.quid.webSSHControll.gateway.web

import com.quid.webSSHControll.ssh.usecase.CheckProcess
import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class CheckApiController(
    private val checkProcess: CheckProcess
) {
    @GetMapping("/check/{name}")
    @ResponseStatus(OK)
    fun checkPID(@PathVariable("name") name: String): Boolean = checkProcess.checkProcess(name)

    @GetMapping("/check/java/{name}")
    @ResponseStatus(OK)
    fun checkJavaPID(@PathVariable("name") name: String): Boolean = checkProcess.checkJavaProcess(name)

}