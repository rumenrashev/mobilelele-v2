package com.spring.mobilelele.web.controllers;

import com.spring.mobilelele.service.models.RegisterServiceModel;
import com.spring.mobilelele.service.services.RegisterService;
import com.spring.mobilelele.web.models.bindings.RegisterBindingModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

import static com.spring.mobilelele.constant.GlobalConstants.LOGIN_PATH;
import static com.spring.mobilelele.constant.GlobalConstants.REGISTER_PATH;


@Controller
public class RegisterController extends BaseController {

    private static final String MODEL_ATTRIBUTE_NAME =
            "registerBindingModel";
    private static final String BINDING_RESULT_ATTRIBUTE_NAME =
            "org.springframework.validation.BindingResult." + MODEL_ATTRIBUTE_NAME;

    private final RegisterService registerService;
    private final ModelMapper modelMapper;

    @Autowired
    public RegisterController(RegisterService registerService, ModelMapper modelMapper) {
        this.registerService = registerService;
        this.modelMapper = modelMapper;
    }


    @GetMapping(REGISTER_PATH)
    public String login(Model model) {
        if (model.getAttribute(MODEL_ATTRIBUTE_NAME) == null) {
            model.addAttribute(MODEL_ATTRIBUTE_NAME, new RegisterBindingModel());
        }
        return REGISTER_PATH;
    }

    @PostMapping(REGISTER_PATH)
    public String registerConfirm(
            @Valid RegisterBindingModel registerBindingModel,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute(MODEL_ATTRIBUTE_NAME, registerBindingModel);
            redirectAttributes.addFlashAttribute(BINDING_RESULT_ATTRIBUTE_NAME, bindingResult);
            return redirect(REGISTER_PATH);
        }
        RegisterServiceModel registerServiceModel =
                this.modelMapper.map(registerBindingModel, RegisterServiceModel.class);

        registerService.registerUser(registerServiceModel);
        return redirect(LOGIN_PATH);
    }
}
