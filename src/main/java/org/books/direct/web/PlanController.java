package org.books.direct.web;

import java.util.List;

import org.books.direct.domain.entities.Plan;
import org.books.direct.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(tags = { "v1", "plans" })
@RequestMapping(value = { "/v1/plans" }, produces = MediaType.APPLICATION_JSON_VALUE)
public class PlanController {

   @Autowired
   private PlanService planService;

   @ApiOperation(value = "Returns a list of all active plans", notes = "Returns a list of all active plans")
   @ApiResponses(value = {
         @ApiResponse(code = 200, message = "Successful retrieval of all active Plans", response = Plan.class)})
   @RequestMapping(method = RequestMethod.GET)
   public ResponseEntity<List<Plan>> getActivePlansV1() {
     return new ResponseEntity<List<Plan>>(planService.getActivePlans(), HttpStatus.OK);
   }

}
