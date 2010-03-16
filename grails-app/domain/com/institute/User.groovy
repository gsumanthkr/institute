package com.institute

class User {
    String userid
    String password
    String email

    static constraints = {
        userid(size:5..15, blank:false, unique:true)
        password(size:5..15, blank:false)
        email(email:true, blank:false)
    }
}
