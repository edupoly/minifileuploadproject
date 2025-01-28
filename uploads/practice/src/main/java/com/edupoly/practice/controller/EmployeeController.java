package com.edupoly.practice.controller;

import com.edupoly.practice.dto.DayWorkoutDto;
import com.edupoly.practice.dto.EmployeeDto;
import com.edupoly.practice.dto.UserDto;
import com.edupoly.practice.dto.WorkoutDto;
import com.edupoly.practice.entity.DayWorkout;
import com.edupoly.practice.entity.Employee;
import com.edupoly.practice.entity.Workout;
import com.edupoly.practice.service.DayWorkoutService;
import com.edupoly.practice.service.EmployeeService;
import com.edupoly.practice.service.UserService;
import com.edupoly.practice.service.WorkoutService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.List;

@Controller
public class EmployeeController
{
    private EmployeeService employeeService;
    private UserService userService;
    private DayWorkoutService dayWorkoutService;
    private WorkoutService workoutService;

    public EmployeeController(EmployeeService employeeService,
                              UserService userService,
                              WorkoutService workoutService,
                              DayWorkoutService dayWorkoutService) {
        this.employeeService = employeeService;
        this.userService = userService;
        this.workoutService = workoutService;
        this.dayWorkoutService = dayWorkoutService;
    }

    @GetMapping("/userWorkoutReport/{email}")
    public String userWorkoutReport(Model model,@PathVariable String email){
        model.addAttribute("email",email);
        DayWorkout[] dayWorkouts = dayWorkoutService.getDayWorkoutsByEmail(email);
        model.addAttribute("userWorkouts",dayWorkouts);
        return "userWorkoutReport";
    }

    @GetMapping("/addWorkout")
    public String addWorkout(Model model){
        String[][] days = {{"Day1","Back and Biceps"},{"Day2","Shoulder Chest and Triceps"}};
        WorkoutDto workoutDto = new WorkoutDto();
        model.addAttribute("workout",workoutDto);
        model.addAttribute("days",days);
        return "addWorkout";
    }
    @PostMapping("/addWorkout")
    public String addWorkout(@ModelAttribute("workout") WorkoutDto workout){
        System.out.println("Controller::"+workout.getWorkout());
        workoutService.addWorkout(workout);
        return "redirect:/addWorkout";
    }
    @GetMapping("/login")
    public String loginPage(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("user",userDto);
        return "loginPage";
    }
    @GetMapping("/")
    public String home(Model model){
        return "redirect:/login";
    }
    @GetMapping("/loginErrorPage")
    public String loginErrorPage(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("user",userDto);
        return "loginErrorPage";
    }

    @PostMapping("/loginUser")
    public String loginUser(@ModelAttribute("user") UserDto user,Model model){
        if(userService.authenticate(user)){
            System.out.println(user.getEmail());
            return "redirect:/days/"+user.getEmail();
        }
        else{
            return "redirect:/loginErrorPage";
        }
    }
    @GetMapping("/days/{email}")
    public String days(Model model,@PathVariable String email){
        System.out.println(email);
        model.addAttribute("email",email);
        return "days";
    }
    @GetMapping("/dayWorkouts/{day}/{email}")
    public String dayWorkouts(Model model,@PathVariable String day,@PathVariable String email){

        model.addAttribute("day",day);
        model.addAttribute("email",email);
        Workout[] workouts = workoutService.getWorkoutsByDay(day);
        model.addAttribute("workouts",workouts);
        DayWorkoutDto dayWorkoutDto = new DayWorkoutDto();
        model.addAttribute("userDayWorkout",dayWorkoutDto);
        return "workouts";
    }
    @GetMapping("/addUserWorkout/{day}/{email}/{workout}/{category}/{sets}/{repetitions}")
    public String addUserWorkout(Model model,@PathVariable String day,@PathVariable String email,@PathVariable String workout,@PathVariable String category,@PathVariable String sets,@PathVariable String repetitions){
        model.addAttribute("day",day);
        model.addAttribute("email",email);
        model.addAttribute("workout",workout);
        model.addAttribute("category",category);
        model.addAttribute("sets",sets);
        model.addAttribute("repetitions ",repetitions);
        DayWorkoutDto dayWorkoutDto = new DayWorkoutDto();
        model.addAttribute("userDayWorkout",dayWorkoutDto);
        return "workoutsEntry";
    }
    @PostMapping("/addUserWorkout")
    public String addUserWorkout(@ModelAttribute("userDayWorkout") DayWorkoutDto dayWorkoutDto){
        System.out.println("Controller::"+dayWorkoutDto.getEmail());
        String s1 = dayWorkoutDto.getEmail();
//        System.out.println("Controller::"+dayWorkoutDto.getDay());
        dayWorkoutService.createDayWorkout(dayWorkoutDto);
//        /userWorkoutReport/nani@gmail.com
        return "redirect:/userWorkoutReport/"+s1;
    }

    @GetMapping("/registerUser")
    public String registerUser(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("user",userDto);
        return "registerUser";
    }

    @PostMapping("/registerUser")
    public String registerUser(@ModelAttribute("user") UserDto user){
        System.out.println("Controller::"+user.getPassword());
        userService.createUser(user);
        return "redirect:/login";
    }

    @GetMapping("/employees")
    public String listEmployees(Model model){
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        model.addAttribute("employees",employees);
        return "employees";
    }

    @GetMapping("/addEmployee")
    public String addEmployee(Model model){
        EmployeeDto employeeDto = new EmployeeDto();
        model.addAttribute("employee",employeeDto);
        return "addEmployee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable Long id, Model model){
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees";
    }

    @PostMapping("/addEmployee")
    public String addNewEmployee(@ModelAttribute("employee") EmployeeDto employee){
        System.out.println(employee);
        employeeService.createEmployee(employee);
        return "redirect:/employees";
    }
}
