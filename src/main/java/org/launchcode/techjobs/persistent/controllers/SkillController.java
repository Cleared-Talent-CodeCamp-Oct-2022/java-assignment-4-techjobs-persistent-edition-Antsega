package org.launchcode.techjobs.persistent.controllers;

import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("skills")
public class SkillController {

    @Autowired
    private SkillRepository skillRepository;
    private EmployerRepository employerRepository;

    @GetMapping
    public String displayAllSkills(Model model) {
        model.addAttribute("employers", employerRepository.findAll());
        model.addAttribute("skills", skillRepository.findAll());
        return "skills/index";
    }

    @GetMapping("add")
    public String displayAddSkillForm(Model model) {
        model.addAttribute(new Employer());
        model.addAttribute(new Skill());
        return "skills/add";
    }

    @PostMapping("add")
    public String processAddSkillForm(Model model, @ModelAttribute @Valid Skill newSkill,
                                      Errors erros) {
        if (erros.hasErrors()){
            model.addAttribute("skill", "The skill must have 5 characters");
            return "skills/add";
        }

        // add to skill list
        skillRepository.save(newSkill);
        return "redirect:";
    }

//    @GetMapping("view/{skill}")
//    public String displayViewSkill(Model model, @PathVariable String description) {
//
//        // searches through the repo
//        Optional optSkill = skillRepository.;
//    }
 }
