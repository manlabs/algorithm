package com.manlabs.demo.jxls;

import com.manlabs.demo.jxls.pojo.Employee;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Demo {
    public static void main(String[] args) throws Exception {
        List<Employee> employees = generateSampleEmployeeData();
        try(InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("templates/grouping_template.xlsx")) {
            try (OutputStream os = new FileOutputStream("target/grouping_output.xlsx")) {
                Context context = new Context();
                context.putVar("employees", employees);
                JxlsHelper.getInstance().processTemplate(is, os, context);
            }
        }

    }

    private static List<Employee> generateSampleEmployeeData() throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MMM-dd", Locale.US);
        List<Employee> res = new ArrayList<>();
        ArrayList<Employee> chilren = new ArrayList<>();
        res.add( new Employee("Elsa", dateFormat.parse("1970-Jul-10"), 1500, 0.15,10,chilren));

        chilren.add(new Employee("child1", dateFormat.parse("1970-Jul-10"), 1500, 0.15,5,chilren));
        chilren.add(new Employee("child1", dateFormat.parse("1970-Jul-10"), 1500, 0.15,3,chilren));


        return res;

    }
}
