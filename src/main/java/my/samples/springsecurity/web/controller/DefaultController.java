/*
 * Copyright 2003-2025 OneVizion, Inc. All rights reserved.
 */

package my.samples.springsecurity.web.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.security.core.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = { "", "/", "/default" })
public class DefaultController {

    @GetMapping
    public String getDefaultPage(HttpServletRequest request, Model model) {
        Principal principal = request.getUserPrincipal();

        List<String> grantedAuthorityNames = List.of();
        String userName = null;
        if (principal instanceof Authentication authentication) {
            userName = authentication.getName();
            grantedAuthorityNames = authentication.getAuthorities()
                                                  .stream()
                                                  .map(GrantedAuthority::getAuthority)
                                                  .toList();
        }

        DeafultPageModel pageModel = new DeafultPageModel(userName, grantedAuthorityNames);
        model.addAttribute("data", pageModel);

        return "default";
    }

    private record DeafultPageModel(String userName, List<String> grantedAuthorityNames) {};
}
