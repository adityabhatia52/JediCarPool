/**
 * 
 */
package com.practo.carpool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author aditya
 *
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundException extends Exception {

  private static final long serialVersionUID = -570050669946005424L;

  public NotFoundException(String message) {
    super(message);
  }

}
