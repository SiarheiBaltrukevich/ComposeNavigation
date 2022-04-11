package com.boltic28.composenavigation.data

import com.boltic28.composenavigation.data.model.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserManager @Inject constructor(
    repository: Repository
)  {

    var currentUser: User = repository.users.random()
}