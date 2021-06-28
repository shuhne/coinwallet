package project_webtech.satu.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import project_webtech.satu.config.endpoints;
import project_webtech.satu.config.viewNames;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {


    @GetMapping(path =endpoints.CREATE)
    public ModelAndView showCreatePage(){ return new ModelAndView(viewNames.CREATE);}

    @GetMapping(path =endpoints.VIEW)
    public ModelAndView showViewPage(){ return new ModelAndView(viewNames.VIEW);}

    @GetMapping(value= {endpoints.INDEX, endpoints.SLASH})
    public ModelAndView getCurrentUser(@AuthenticationPrincipal OidcUser user){
        Map<String, String> viewModelIndex = new HashMap<>();
        if(user!=null) {
            viewModelIndex.put("name", user.getGivenName() + " " +user.getFamilyName() );
        }
        return new ModelAndView(viewNames.INDEX, viewModelIndex);
    }
}
