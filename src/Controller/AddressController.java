package Controller;

import base.Constants;
import base.Services;
import entity.Address;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by sarmeetsingh on 9/9/16 with love and lots of chai
 * latte from The Bean on Bedford and North 11. Brooklyn.
 */
public class AddressController {
    public static Address createAddress(HttpServletRequest request) {

        String firstLine = request.getParameter(Constants.addressFirstLine);
        String secondLine = request.getParameter(Constants.addressSecondLine);
        String city = request.getParameter(Constants.addressCity);
        String state = request.getParameter(Constants.addressState);
        String country = request.getParameter(Constants.addressCountry);
        String zip = request.getParameter(Constants.addressZip);

        Address address = new Address();
        address.setFirstLine(firstLine);
        address.setSecondLine(secondLine);
        address.setCity(city);
        address.setState(state);
        address.setCountry(country);
        address.setZip(zip);
        // System.out.println(address.toString());
        Services.ds.save(address);
        return address;

    }




}
