package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {
    @GetMapping("/world-clock")
    //@GetMapping("world-clock")  ánh xạ request lên phương thức xử lý.
    //@RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh")
    // khai báo tham số của phương thức xử lý, ràng buộc với tham số từ request
    // Lấy ra thời gian hiện tại
    public String getTimeByTimezone(ModelMap model, @RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city) {
        Date date = new Date();
        // Lấy ra time zone hiện tại
        TimeZone local = TimeZone.getDefault();
        // Lấy ra time zone của 1 thành phố cụ thể
        TimeZone locale = TimeZone.getTimeZone(city);


        // Tính thời gian hiện tại của một thành phố cụ thể
        long locale_time = date.getTime() +
                (locale.getRawOffset() - local.getRawOffset());
// Cài đặt lại thời gian cho biến date thành thời gian hiện tại của 1 thành phố cụ thể
        date.setTime(locale_time);


        // Chuyển dữ liệu va gửi qua view
        model.addAttribute("city", city);
        model.addAttribute("date", date);

        return "index";


    }

}
