package com.example.controller;

import com.example.dto.ContractDto;
import com.example.dto.ServiceDto;
import com.example.model.contract.Contract;
import com.example.service.contract.IContractService;
import com.example.service.customer.ICustomerService;
import com.example.service.employee.IEmployeeService;
import com.example.service.service.IServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/contract")
public class ContractController {

    @Autowired
    private IContractService contractService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IServiceService serviceService;

    @GetMapping(value = "/list")
    public String goListContract(@PageableDefault(value = 3) Pageable pageable, Model model) {
        Page<Contract> contractPage = contractService.findAll(pageable);
        model.addAttribute("contractPage", contractPage);
        return "contract/list";
    }

    @GetMapping(value = "/create")
    public String showCreateContract(Model model) {
        model.addAttribute("contractDto", new ContractDto());
//        List<Customer> customerList = customerService.findAll();
//        List<Employee> employeeList = employeeService.findAll();
//        List<Service> serviceList = serviceService.findAll();
        model.addAttribute("customerList", customerService.findAll());
        model.addAttribute("employeeList", employeeService.findAll());
        model.addAttribute("serviceList", serviceService.findAll());
        return "contract/create";
    }

    @PostMapping(value = "/save")
    public String saveService(@ModelAttribute @Validated ContractDto contractDto,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes,
                              Model model) {
        new ContractDto().validate(contractDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerList", customerService.findAll());
            model.addAttribute("employeeList", employeeService.findAll());
            model.addAttribute("serviceList", serviceService.findAll());
            return "contract/create";
        } else {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto, contract);
            contractService.save(contract);
            redirectAttributes.addFlashAttribute("mess", "Create Contract Success");
            return "redirect:/contract/list";
        }
    }


//
//    @PostMapping(value = "/save")
//    public String saveEmployee(@ModelAttribute @Validated EmployeeDto employeeDto,
//                               BindingResult bindingResult,
//                               RedirectAttributes redirectAttributes,
//                               Model model) {
//        new EmployeeDto().validate(employeeDto, bindingResult);
//        if (bindingResult.hasFieldErrors()) {
//            model.addAttribute("divisionList", divisionService.findAll());
//            model.addAttribute("educationDegreeList", educationDegreeService.findAll());
//            model.addAttribute("positionList", positionService.findAll());
//            return "employee/create";
//        } else {
//            Employee employee = new Employee();
//            BeanUtils.copyProperties(employeeDto, employee);
//            employeeService.save(employee);
//            redirectAttributes.addFlashAttribute("mess", "Create Employee Success");
//            return "redirect:/employee/list";
//        }
//    }
}
