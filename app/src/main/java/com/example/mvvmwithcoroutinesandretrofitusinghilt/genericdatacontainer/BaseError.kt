package com.example.mvvmwithcoroutinesandretrofitusinghilt.genericdatacontainer

class BaseError {
    var code = 0
    var message = ""

    constructor()
    constructor(code: Int, message: String) {
        this.code = code
        this.message = message
    }

}