package in.kg.insurance.web.rest;

import in.kg.insurance.controller.InsuranceCalculate;
import in.kg.insurance.model.GeneralInfo;
import in.kg.insurance.utils.CheckUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RestAPIController {

    @PostMapping("/")
    public ResponseEntity<String> getInsurancePremium(@RequestBody GeneralInfo generalInfo) {
        InsuranceCalculate calculate = new InsuranceCalculate();
        int pay = calculate.calculate(generalInfo);
        String name = "";
        if (CheckUtil.isMale(generalInfo.getGender())) {
            name = "Mr.";
        } else {
            name = "Mrs.";
        }
        name += generalInfo.getName();
        return ResponseEntity.ok("Health Insurance Premium for " + name + " : Rs." + pay);
    }

}
