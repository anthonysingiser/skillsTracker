package org.launchcode.skillstracker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SkillsController {
    private static String name;
    private static String firstChoice;
    private static String secondChoice;
    private static String thirdChoice;

    @GetMapping(value="")
    @ResponseBody
    public String HelloWorld() {
        return  "<h1> Skills Tracker </h1>" +
                "<h2> Here are some languages that are fun to learn! Rank the languages at /form </h2>" +
                "<ol>" +
                "<li> Java </li>" +
                "<li> JavaScript </li>" +
                "<li> Python </li>" +
                "</ol>";
    }

    @GetMapping("form")
    @ResponseBody
    public String displayForm() {
        return "<form method = 'post'>" +
                "<label for='name'>Name:</label><br>" +
                "<input type='text' id='name' name='name'><br>" +
                "<label for='firstChoice'>First Choice:</label><br>" +
                "<select id='firstChoice' name='firstChoice'>" +
                "<option value='Java'>Java</option>" +
                "<option value='Javascript'>JavaScript</option>" +
                "<option value='Python'>Python</option>" +
                "</select><br>" +
                "<label for='secondChoice'>Second Choice:</label><br>" +
                "<select id='secondChoice' name='secondChoice'>" +
                "<option value='Java'>Java</option>" +
                "<option value='Javascript'>JavaScript</option>" +
                "<option value='Python'>Python</option>" +
                "</select><br>" +
                "<label for='thirdChoice'>Third Choice:</label><br>" +
                "<select id='thirdChoice' name='thirdChoice'>" +
                "<option value='Java'>Java</option>" +
                "<option value='Javascript'>JavaScript</option>" +
                "<option value='Python'>Python</option>" +
                "</select><br>" +
                "<input type='submit' value='Submit'>" +
                "</form>";
    }

    @PostMapping("form")
    @ResponseBody
    public String processForm(@RequestParam String name, @RequestParam String firstChoice, @RequestParam String secondChoice, @RequestParam String thirdChoice) {
        SkillsController.name = name;
        SkillsController.firstChoice = firstChoice;
        SkillsController.secondChoice = secondChoice;
        SkillsController.thirdChoice = thirdChoice;

        return "Form submitted successfully! View your submission at /viewData";
    }

    @GetMapping("viewData")
    @ResponseBody
    public String viewData() {
        return "<h1>" + name + "</h1>" +
                "<table style='border:1px solid black; border-collapse: collapse; width: 50%;'>" +
                "<tr style='background-color: #f2f2f2;'><th style='border:1px solid black; padding: 10px;'>Ranking</th><th style='border:1px solid black; padding: 10px;'>Language Choices</th></tr>" +
                "<tr><td style='border:1px solid black; padding: 10px; text-align: center;'>1</td><td style='border:1px solid black; padding: 10px; text-align: center'>" + firstChoice + "</td></tr>" +
                "<tr><td style='border:1px solid black; padding: 10px; text-align: center;'>2</td><td style='border:1px solid black; padding: 10px; text-align: center'>" + secondChoice + "</td></tr>" +
                "<tr><td style='border:1px solid black; padding: 10px; text-align: center;'>3</td><td style='border:1px solid black; padding: 10px; text-align: center'>" + thirdChoice + "</td></tr>" +
                "</table>";
    }
}