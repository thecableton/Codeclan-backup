package controllers;
import db.DBHelper;
import db.Seeds;
import models.Employee;
import models.Manager;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.get;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.route.HttpMethod.get;

public class EmployeeController {
    public EmployeeController() {
        setupEndPoint();
    }

    private void setupEndPoint() {

        get("/employees", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/employees/index.vtl");
            List<Employee> employees = DBHelper.getAll(Employee.class);
            model.put("employees", employees);
            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());
    }

}
