import com.institute.User

class BootStrap {

     def init = { servletContext ->
         100.times { i ->
             new User(username: "Username $i", email: "email$i@here.com").save()
         }
     }
     def destroy = {
     }
} 