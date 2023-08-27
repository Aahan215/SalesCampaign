package org.saleCampaign.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.saleCampaign.dto.CampaignDto;
import org.saleCampaign.dto.ProductDto;
import org.saleCampaign.model.CampaignData;
import org.saleCampaign.model.ProductData;
import org.saleCampaign.pojo.ProductPojo;
import org.saleCampaign.service.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping("/api/")
public class Controller {

    @Autowired
    private ProductDto productDto;

    @Autowired
    private CampaignDto campaignDto;

    @ApiOperation(value = "Get list of all products")
    @RequestMapping(path = "products", method = RequestMethod.GET)
    public List<ProductData> getAll() {
        return productDto.getAll();
    }

    @ApiOperation(value = "Add a product")
    @RequestMapping(path = "products", method = RequestMethod.POST)
    public void add(ProductPojo p) throws ApiException{
         productDto.add(p);
    }

    @ApiOperation(value = "Create a sales campaign")
    @RequestMapping(path = "campaigns", method = RequestMethod.POST)
    public void createCampaign(@RequestBody CampaignData data) throws ApiException {
        campaignDto.createCampaign(data);
    }

}
