package com.practo.carpool.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practo.carpool.exceptions.NotFoundException;
import com.practo.carpool.service.ListingService;

@Controller
public class ApplicationController {
  private int itemsPerPage = 10;

  /*
   * @Autowired private UserService userService;
   * 
   * @Autowired private ListingService listingService;
   * 
   * @Autowired private SourceService sourceService;
   */
  public static Pageable updatePageable(final Pageable source, final int size) {
    return new PageRequest(source.getPageNumber(), size, source.getSort());
  }

  @Autowired
  private ListingService listingService;

  @RequestMapping("/")
  public String index(Model model, Pageable pageable, HttpSession session)
      throws NotFoundException {
    // Pageable pageable = null;
    model.addAttribute("getListing", listingService.get(pageable));
    return "rooms";
  }
}


