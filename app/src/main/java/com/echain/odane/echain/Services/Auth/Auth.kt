package com.echain.odane.echain.Services.Auth

import com.echain.odane.echain.Models.User

/**
 * Created by ksteere on 3/20/2018.
 */
class Auth(val authService: AuthService) {
    fun registerUsers(user: User): io.reactivex.Observable<Result> {
        return authService.registerUser(user = user)
    }

    fun loginUsers(user: User): io.reactivex.Observable<Result> {
        return authService.loginUser(user = user)
    }
}