package com.project.dispatchdelivery.user;

import com.project.dispatchdelivery.db.entity.User;
import com.project.dispatchdelivery.db.request.userRequest.SignOutRequest;
import com.project.dispatchdelivery.db.request.userRequest.UserRegisterRequest;
import com.project.dispatchdelivery.db.request.userRequest.UserSignInRequest;
import com.project.dispatchdelivery.db.response.LogoutResponse;
import com.project.dispatchdelivery.db.response.UserResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // signup
    @PostMapping("/signup")
    public UserResponse signup(@RequestBody UserRegisterRequest userRequest) {
        return userService.createNewUser(userRequest);
    }


    // SIGN IN
    @PostMapping("/signin")
    public UserResponse signin(@RequestBody UserSignInRequest userSignInRequest, HttpServletRequest request) {
        User user = userService.checkUserPassword(userSignInRequest.getEmail(), userSignInRequest.getPassword());
        UserResponse response = new UserResponse();
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user_id", user.getUID());
            response.setUser(user);
            response.setStatus("OK");
            response.setMessage("Success!");
            return response;
        } else {
            response.setStatus("failed");
            response.setStatus("can't login");
        }
        return response;
    }

    @PostMapping("/signout")
    public LogoutResponse signout(@RequestBody SignOutRequest request,
                                  HttpServletRequest req, HttpServletResponse res) {
        HttpSession session = req.getSession(false);
        if (session == null) {
            LogoutResponse response = new LogoutResponse();
            response.setStatus("Failed");
            response.setMessage("You should login first");
            res.setStatus(404);
            return response;
        } else {
            session.invalidate();
            System.out.println("UID is :" + request.getUID());
            return new LogoutResponse("200", "OK");
        }
    }

}
