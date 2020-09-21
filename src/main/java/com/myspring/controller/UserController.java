package com.myspring.controller;

import com.myspring.services.UserService;

public class UserController {

    UserService userService;
   public void printuserService(){
       System.out.println("UserController");
       userService.printUserDao();
   }

}
