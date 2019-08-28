package com.example.demo;
/*creates the routes for each CRUD action. @Autowired instantiates JobRepository object
@RequestMapping ("/") on default route, user will see a list of records saved in dB. JobRepository retrieves
all records as an iterable. @GetMapping("/add") adds a new instance of Job class when user goes to default route.
The (form) input can then be stored in the fields of the model and validated with the rules in Job class.
@PostMapping("/process) When submit button is pressed the view returns to the controller to execute the method
under this route. This method checks the object that was passed to the view. That object is populated with the user's
input which can be validated agains the rules in Job class. @Valid is used with BindingResult object to check object for
validity agains validation constraints.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    TODORepository TODORepository;

    @RequestMapping("/")
    public String listTODO(Model model){
        model.addAttribute("todos", TODORepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String todoForm(Model model){
        model.addAttribute("todo", new TODO());
        return "todoform";
    }

    @PostMapping("/process")
    public String processForm(@Valid TODO todo, BindingResult result){
        if (result.hasErrors()){
            return "todoform";
        }
        TODORepository.save(todo);
        return "redirect:/";
    }
}
