package com.echain.odane.echain.Services.Auth

import com.echain.odane.echain.Services.Auth.Auth
import com.echain.odane.echain.Services.Auth.AuthService

/**
 * Created by ksteere on 3/20/2018.
 */

object AuthProvider {

    fun provideAuthServices(): Auth {
        return Auth(AuthService.create())
    }

}